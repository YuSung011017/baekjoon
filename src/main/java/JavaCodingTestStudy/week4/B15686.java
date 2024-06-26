package JavaCodingTestStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15686 {
    static int [][]map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N x N 맵을 받기 위함
        int M = Integer.parseInt(st.nextToken());// 망하지 않는 최대 치킨집 수
        map = new int[N][N];
        ArrayList<RowCol>chick = new ArrayList<>(); //치킨집의 정보를 가진 배열
        ArrayList<RowCol>citizen = new ArrayList<>();
        int k = 0;
        int p = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    chick.add(new RowCol(j,i));
                    k++;
                }else if(map[i][j] == 1){
                    citizen.add(new RowCol(j,i));
                }
            }
        }
        int length[] = new int[chick.size()];
        for(int i = 0; i<chick.size(); i++){
            for(int j = 0 ; j < citizen.size() ; j++){
                length[i] += Math.abs(chick.get(i).row-citizen.get(j).row)+Math.abs(chick.get(i).col-citizen.get(j).col);
            }
        }
        RowCol realChick[] = new RowCol[M];
        for(int i = 0 ; i < M ; i++){
            realChick[i] = chick.get(i);
        }
        int minLength[] = new int[M];
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i<citizen.size(); i++){
            for(int j = 0 ; j < M ; j++){
                int temp = Math.abs(citizen.get(i).row - realChick[j].row) + Math.abs(citizen.get(i).col - realChick[j].col);
                if(temp < min){
                    min = temp;
                }
            }
            sum += min;
        }
        System.out.println(sum);
    }
}
class RowCol{
    int row,col;
    public RowCol(int row, int col){
        this.row = row;
        this.col = col;
    }
}
