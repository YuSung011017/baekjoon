package codingTest_similar_majorCompany;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
//2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다.
//   상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
public class B2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int regionNUm = Integer.parseInt(br.readLine());
        int requestBudget[] = new int[regionNUm];
        long totalRequest = 0;
        int maxBudget = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<regionNUm; i++) {
            requestBudget[i] = Integer.parseInt(st.nextToken());
            totalRequest += requestBudget[i];
            maxBudget = Math.max(maxBudget, requestBudget[i]);
        }

        long totalBudget = Long.parseLong(br.readLine());
        if(totalRequest<=totalBudget){
            System.out.println(maxBudget);
            System.exit(0);
        }
        int left = 0;
        int right = maxBudget;
        while(left<=right) {
            long currentTotal = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < regionNUm; i++) {
                if (requestBudget[i] < mid)
                    currentTotal += requestBudget[i];
                else
                    currentTotal += mid;
            }
            if (currentTotal <= totalBudget)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(right);
    }

}
