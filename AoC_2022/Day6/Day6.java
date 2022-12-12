// 12/11/2022 - 11PM
// Took less than an hour

package Day6;
import java.util.*;
import java.io.*;

public class Day6 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("signal.dat"));
        boolean dup = false;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            for (int i=0; i<=line.length()-4; i++) {
                String check = line.substring(i, i+4);
                for (int j=0; j<check.length()-1; j++) {
                    for (int h=j+1; h<check.length(); h++) {
                        if (check.substring(j, j+1).equals(check.substring(h, h+1))) {
                            dup = true;
                        }
                    }
                }
                if (dup != true) {
                    System.out.println(i+4);
                    break;
                }
                dup = false;
            }    
        }
    }    
}

// Answer: 1804