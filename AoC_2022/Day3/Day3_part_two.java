import java.util.*;
import java.io.*;

public class Day3_part_two {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("rucksack.dat"));
        int total = 0;
        while (input.hasNextLine()) { // bruh
            String line1 = input.nextLine(); // vJrwpWtwJgWrhcsFMMfFFhFp
            String line2 = input.nextLine();
            String line3 = input.nextLine();
            int value = 0;
            for (int i=0; i<line1.length(); i++) {
                String first = line1.substring(i, i+1);
                for (int j=0; j<line2.length(); j++) {
                    String second = line2.substring(j, j+1);
                    for (int k=0; k<line3.length(); k++) {
                        String third = line3.substring(k, k+1);
                        if (first.equals(second) && second.equals(third)) {
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
            }
            System.out.println(value);
            total += value;
        }
        System.out.println(total);
    }
}

// Answer: 2633

