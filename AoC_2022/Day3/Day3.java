// 12/11/2022 - 12PM
// Woke up this morning and decided to code

package Day3;
import java.util.*;
import java.io.*;

public class Day3 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("rucksack.dat"));
        int total = 0;
        while (input.hasNextLine()) { // bruh
            String line = input.nextLine(); // vJrwpWtwJgWrhcsFMMfFFhFp
            int size = line.length()/2;
            String one = line.substring(0, size); // vJrwpWtwJgWr
            String two = line.substring(size); // hcsFMMfFFhFp
            int value = 0;
            for (int i=0; i<size; i++) {
                String first = one.substring(i, i+1);
                for (int j=0; j<size; j++) {
                    String second = two.substring(j, j+1);
                    if (first.equals(second)) {
                        char c = first.charAt(0);
                        value = (int)c;
                        if (value >= 97) {
                            value -= 96;
                        } else {
                            value -= 38;
                        }
                    }
                }
            }
            System.out.println(value);
            total += value;
        }
        System.out.println(total);
    }
}

// Answer: 7785