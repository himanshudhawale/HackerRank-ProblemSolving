import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int xx1 = -1;
        int xx2 = -1;
        int xx3 = -1;
        int xx4 = -1;
        int xx5 = -1;
        int xx6 = -1;
        int xx7 = -1;
        int xx8 = -1;
        int xx9 = -1;
        int xx10 = -1;
        int xx11 = -1;
        int xx12 = -1;
        int xx13 = -1;
        int xx14 = -1;
        int xx15 = -1;
        int xx16 = -1;
        
        int ans = 0;
        
        for(int i = 0; i < k; i++){
            int rOb = obstacles[i][0];
            int cOb = obstacles[i][1];

            if((rOb > xx5 || xx5 == -1) && rOb < r_q && cOb == c_q)
            {
                xx5 = rOb;
                xx6 = cOb;
            }

            if(r_q - rOb == c_q - cOb && cOb < c_q && rOb < r_q 
               && ((rOb > xx7 && cOb > xx8) || xx7 == -1))
            {
                xx7 = rOb;
                xx8 = cOb;
            }
            
            if((cOb < xx2 || xx1 == -1) && cOb > c_q && rOb == r_q)
            {
                xx1 = rOb;
                xx2 = cOb;
            }
            
            if(r_q - rOb == cOb - c_q && cOb > c_q && rOb < r_q 
               && ((rOb > xx3 && cOb < xx4) || xx3 == -1))
            {
                xx3 = rOb;
                xx4 = cOb;
            }

            if(c_q - cOb == rOb - r_q && cOb < c_q && rOb > r_q 
               && ((rOb < xx11 && cOb > xx12) || xx11 == -1))
            {
                xx11 = rOb;
                xx12 = cOb;
            }            

            
            if((cOb > xx10 || xx9 == -1) && cOb < c_q && rOb == r_q)
            {
                xx9 = rOb;
                xx10 = cOb;
            }
            
            if(rOb - r_q == cOb - c_q && cOb > c_q 
               && rOb > r_q && ((rOb < xx15 && cOb < xx16) || xx15 == -1))
            {
                xx15 = rOb;
                xx16 = cOb;
            }
               
            
            if((rOb < xx13 || xx13 == -1) && rOb > r_q && cOb == c_q)
            {
                xx13 = rOb;
                xx14 = cOb;
            }
            
            
        }
    
        ans += (xx2 != -1) ? (xx2 - c_q -1) : n - c_q;   
        ans += (xx13 != -1) ? (xx13 - r_q - 1) : n - r_q;  
        ans += (xx5 != -1) ? (r_q - xx5 - 1) : r_q - 1;   
        ans += (xx10 != -1) ? (c_q - xx10 -1) : c_q - 1;  

        ans += (xx4 != -1) ? (xx4 - c_q -1) : Math.min(n - c_q, r_q - 1);
        ans += (xx15 != -1) ? (xx16 - c_q - 1) : Math.min(n - c_q, n - r_q);  
        ans += (xx7 != -1) ? (c_q - xx8 - 1) : Math.min(c_q - 1, r_q - 1); 
        ans += (xx12 != -1) ? (c_q - xx12 -1) : Math.min(c_q - 1, n - r_q);  

        return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
