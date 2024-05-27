package codingTest_similar_majorCompany;
//2021년 12월, 네 번째로 개최된 ZOAC의 오프닝을 맡은 성우는 오프라인 대회를 대비하여 강의실을 예약하려고 한다.
//강의실에서 대회를 치르려면 거리두기 수칙을 지켜야 한다!
//한 명씩 앉을 수 있는 테이블이 행마다 W개씩 H행에 걸쳐 있을 때, 모든 참가자는 세로로 N칸 또는 가로로 M칸 이상 비우고 앉아야 한다.
// 즉, 다른 모든 참가자와 세로줄 번호의 차가 N보다 크거나 가로줄 번호의 차가 M보다 큰 곳에만 앉을 수 있다.
//논문과 과제에 시달리는 성우를 위해 강의실이 거리두기 수칙을 지키면서 최대 몇 명을 수용할 수 있는지 구해보자.
//입력
//H, W, N, M이 공백으로 구분되어 주어진다. (0 < H, W, N, M ≤ 50,000)

import java.util.Scanner;

public class B23971 {
    public static void main(String[] args) {
    int count = 0;
    int r =1,c=1; // r은 row로 행 c는 colum으로 열 , (1,1)부터 시작
    int H,W,N,M; // H는 행, W는 열, N은 띄워야할 세로칸, M은 띄어야할 가로칸
    Scanner sc = new Scanner(System.in);
    System.out.print("row : ");
    H = sc.nextInt();
    System.out.print("colum : ");
    W = sc.nextInt();
    System.out.print("length : ");//세로
    N = sc.nextInt();
    System.out.print("width : ");//가로
    M = sc.nextInt();
        if (r <= H) { //r은 H보다 작거나 같아야함
            for(int i = r; i<=H; i+=(N+1)) { //
                for (int j = c; j <= W; j += (M + 1)) { //같은 행에서 c가 W보다 작거나 같을 동안 count 증가
                    count++;
                }
            }
        }
        System.out.println("앉을 수 있는 사람 : " + count);
    }
}
