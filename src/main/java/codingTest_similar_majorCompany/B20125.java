package codingTest_similar_majorCompany;
//첫 번째 줄에는 심장이 위치한 행의 번호 x와 열의 번호 y를 공백으로 구분해서 출력한다.
//두 번째 줄에는 각각 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이를 공백으로 구분해서 출력하여라.

//심장 -> 처음 *이 발견된 좌표에서 아래로 한칸이 심장의 위치
//왼팔의 길이-> 심장이 있는 줄의 처음 *이 발견되 위치에서 심장의 위치를 뺌
//오른팔의 길이 -> 심장이 있는 줄에서의 마지막 *이 발견된 위치에서 심장의 위치를 뺌
//허리의 길이 -> 심장의 위치에서 다리가 시작되는 전 줄의 위치를 뺌
//왼쪽 다리의 길이-> 허리가 끝난 다음 줄부터 처음 *이 발견되었을 때의 좌표에서 그 세로줄에서 더이상 *이 안나올 때까지
//오른 다리의 길이 -> 왼쪽 다리 다음다음부터 좌표가 시작되므로 그 세로 줄에서 더이상 *이 안나올 때까지


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.valueOf(br.readLine());
        boolean[][] map = new boolean[size][size];
        int hx = 0;
        int hy = 0;
        for(int i = 0; i<size; i++){
            String line = br.readLine();
            for(int j = 0; j<size; j++){
                char ch = line.charAt(j);
                if(ch =='*') {
                    map[i][j] = true;
                    if(hx ==0 && hy ==0) {
                        hx = i+1;
                        hy = j;
                    }
                }
            }
        }
        int las = 0;
        int ra = 0;
        int w = 0;
        int ll = 0;
        int rl = 0;
        for(int i = 0; i<size; i++){//왼팔 길이
            if(map[hx][i] == true && i<hy)
                las++;

            if(map[hx][i] == true && i>hy)
                ra++;
            if(map[i][hy] == true && hx<i)
                w++;
            if(map[i][hy-1]==true && i>(hx+w))
                ll++;
            if(map[i][hy+1]==true && i>(hx+w))
                rl++;
        }
        System.out.println((hx+1)+" "+(hy+1));
        System.out.print(las+" "+ra+" "+w+" "+ll+" "+rl);
    }
}
