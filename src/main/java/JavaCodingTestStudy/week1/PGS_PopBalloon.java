package JavaCodingTestStudy.week1;

public class PGS_PopBalloon {
    public static int solution(int[] a) {
        int answer = 0;
        int N = a.length;
        int[] leftMins = new int[N]; //왼쪽 최소값을 저장하는 배열
        int[] rightMins = new int[N]; //오른쪽 최소값을 저장하는 배열
        leftMins[0] = a[0]; //초기화
        rightMins[N-1] = a[N-1];
        for (int i = 1; i < N; i++) {
            leftMins[i] = Math.min(leftMins[i-1], a[i]); //최솟값 배열 요소 추가
            rightMins[N-i-1] = Math.min(rightMins[N-i], a[N-i-1]); // 최댓값 배열 요소 추가
        }
        for (int i = 0; i < N; i++) {
            int leftMin = leftMins[i];
            int rightMin = rightMins[i];
            if (a[i] > leftMin && a[i] > rightMin) {
                //만약 a[i]가 왼쪽 오른쪽 최솟값 보다 크다면 작은 풍선을 떠뜨리는 기회를 두 번 사용해야 하므로 마지막까지 살아남을 수 없다
                answer++;
            }
        }
        return N - answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int []{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }
}
