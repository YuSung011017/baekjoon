package JavaCodingTestStudy.week1;

import java.util.Collections;
import java.util.PriorityQueue;

public class PGS_defence {
    public static int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //Collections.reverseOrder() 이 코드를 추가함으로써 큰 숫자먼저 나온다
        int answer = 0;
        for (int en : enemy) {
            //적들의 수(en)를 우선순위 큐에 넣고 만약 병사 수(n)가 음수가 됬을 때 우선순위 큐에서 큰 수부터 꺼내 n에 더하고
            // 무적권(k)의 값을 감소시킨다.
            //n,k가 0보다 작고 작거나 같아지면 answer 반환
            //갈 수 있는 최대 라운드까지 계산하는 거니깐 가장 많이 막을 수 있을 때 막음 == 적의 최대 수를 막음 == n += largestNumber
            pq.offer(en);
            n -= en;
            if (n < 0) {
                if (k <= 0) {
                    return answer;
                }
                int largestNumber = pq.poll();
                n += largestNumber;
                k--;
            }
            answer++;
        }
        return answer;

    }
    public static void main(String[] args) {
        System.out.println(solution(7,3,new int[]{4,2,4,5,3,3,1}));
        System.out.println(solution(7,3,new int[]{5,3,4,3,1,4,2}));
        System.out.println(solution(2,4,new int[]{3,3,3,3}));
    }
}
