import java.util.*;
import java.io.*;

public class Day4_part2 {
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
            // 5-7, 4-6
            
            if (min2 <= min1 && max2 >= min1) {
                count++;
            }
            else if (min1 <= min2 && max1 >= min2) {
                count++;
            }
            else if (max2 <= max1 && min2 >= max1) {
                count++;
            }
            else if (max1 <= max2 && min1 >= max2) {
                count++;
            }
            
        }
        System.out.println(count);
    }
}

// Answer: 936
