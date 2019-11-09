import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int n=scores.length;
        int index = n-1, m=alice.length, temp = -1; 
        int[] ans = new int[alice.length];
        int[] ranks = new int[n]; 
        int t=0;
        for(int i=0, rank=1; i < n; i++){
            if(i > 0 && scores[i-1] != scores[i])
                rank++;
            ranks[i] = rank;    
        }
        int arank = ranks[ranks.length-1] + 1;

        for(int k=0; k < m; k++)
        {
            int level =alice[k];
        
            for(int i = index; i >= -1; i--)
            {
                if(i < 0 || scores[i] > level)
                {
                    ans[t]=arank;
                    t++;
                    break;
                }
                else if(scores[i] < level)
                {
                    if(scores[i] != temp)
                    {
                        arank--;    
                    }
                    index--;
                }
                else
                {
                    index--;
                    arank = ranks[i];
                }
                temp = scores[i];
            }
        }
        return ans; 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
