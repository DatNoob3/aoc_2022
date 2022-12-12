// 12/8/2022 - 2PM
// Samuel didn't write half of this, what do you mean?

package Day1;
import java.util.*;
import java.io.*;

public class Day1
{    public static void main(String[] args) throws IOException 
    {
        Scanner input = new Scanner(new File("calories.dat"));
        ArrayList<Integer> calories = new ArrayList<Integer>();
        int total = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (!line.equals("")) {
                total += Integer.parseInt(line);
            }
            else {
                calories.add(total);
                total = 0;
            }
        }
        System.out.println(calories);
        int max1 = calories.get(0);
        for (int i = 1; i < calories.size(); i++) {
            if (calories.get(i) > max1) {
                max1 = calories.get(i);
            }
        }
        calories.remove(calories.indexOf(max1));
        int max2 = calories.get(0);
        for (int j = 1; j < calories.size()-1; j++) {
            if (calories.get(j) > max2) {
                max2 = calories.get(j);
            }
        }
        calories.remove(calories.indexOf(max2));
        int max3 = calories.get(0);
        for (int h = 1; h < calories.size()-2; h++) {
            if (calories.get(h) > max3) {
                max3 = calories.get(h);
            }
        }
        System.out.println(max1 + max2 + max3); 
        System.out.println(max1);
    }
}

// Answer 1 = 72511
// Answer 2 = 212117