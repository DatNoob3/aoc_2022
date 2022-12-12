// 12/10/2022 - 3PM
// Solved with extra help from Morgan/Noah

package Day4;
import java.util.*;
import java.io.*;

public class Day4 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("campCleanup.dat"));
        int count = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] all = line.split(",");
            String part1 = all[0];
            String part2 = all[1];
            String[] p1 = part1.split("-");
            String[] p2 = part2.split("-");
            int min1 = Integer.parseInt(p1[0]);
            int max1 = Integer.parseInt(p1[1]);
            int min2 = Integer.parseInt(p2[0]);
            int max2 = Integer.parseInt(p2[1]);
            int range1 = max1 - min1 + 1; //1
            int range2 = max2 - min2 + 1; //3
            // 6-6, 4-6
            
            if (range1 < range2) {
                if (min2 <= min1 && max2 >= max1) {
                    count++;
                }
            } 

            if (range1 > range2) {
                if (min1 <= min2 && max1 >= max2) {
                    count++;
                }
            }

            if (range1 == range2) {
                if (min1 == min2 || max1 == max2) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
// Answer: 569
