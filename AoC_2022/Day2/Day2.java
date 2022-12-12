// 12/9/2022 - 12PM
// Forgot my phone in Dad's car = coding in calculus

package Day2;
import java.util.*;
import java.io.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("rps.dat"));
        int score = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] parts = line.split(" ");
            // A/X - rock
            // B/Y - scissors
            // C/Z - paper

            // rock = 1; paper = 2; scissors = 3
            // loss = 0; draw = 3; win = 6;

            if (parts[0].equals("A")) { // rock
                if (parts[1].equals("X")) { // rock // lose-scissors
                    // score += 4;
                    score += 3;
                } else if (parts[1].equals("Y")) { // paper // draw-rock
                    // score += 8;
                    score += 4;
                } else if (parts[1].equals("Z")) { // scissors // win-paper
                    // score += 3;
                    score += 8;
                }
            } else if (parts[0].equals("B")) { // paper
                if (parts[1].equals("X")) { // rock // lose-rock
                    // score += 1;
                    score += 1;
                } else if (parts[1].equals("Y")) { // paper // draw-paper
                    // score += 5; 
                    score += 5;
                } else if (parts[1].equals("Z")) { // scissors // win-scissors
                    // score += 9;
                    score += 9;
                }
            } else if (parts[0].equals("C")) { // scissors
                if (parts[1].equals("X")) { // rock // lose-paper
                    // score += 7;
                    score += 2;
                } else if (parts[1].equals("Y")) { // paper // draw-scissors
                    // score += 2;
                    score += 6;
                } else if (parts[1].equals("Z")) { // scissors // win-rock
                    // score += 6;
                    score += 7;
                }
            }
        }
        System.out.println(score);
    }
}

// Answer 1: 15572
// Answer 2: 16098