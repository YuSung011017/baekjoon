package codingTest_similar_majorCompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B11723F { //시간 초과로 인한 실패
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> s = new HashSet<>();
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    s.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    int n = Integer.parseInt(st.nextToken());
                    if(s.contains(n) == true)
                        s.remove(n);
                    break;
                case "check":
                    int n1 = Integer.parseInt(st.nextToken());
                    if(s.contains(n1) == true)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "toggle":
                    int n2 = Integer.parseInt(st.nextToken());
                    if(s.contains(n2) == true)
                        s.remove(n2);
                    else
                        s.add(n2);
                case "all":
                   s = new HashSet<>();
                    for(int j = 1; j<=20; j++)
                        s.add(j);
                    break;
                case "empty":
                    s.clear();
                    break;
            }
        }
    }
}
