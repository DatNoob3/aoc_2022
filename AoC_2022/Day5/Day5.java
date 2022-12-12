// 12/11/2022 - 2AM
// God empowered me, I swear...

import java.util.*;
import java.io.*;

public class Day5 {

    public static int findEmptyIndex(String[][] arr, int col) {
        int numRows = arr.length;
        for (int i=0; i<numRows; i++) {
            if (arr[i][col] != null) {
                return i-1;
            }
        }
        return numRows-1;    
    } 

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("crates.dat"));
        //     [D]    
        // [N] [C]    
        // [Z] [M] [P]
        //  1   2   3 
         
        String[][] crates = new String[61][9];
        crates[60][0] = "P";
        crates[60][1] = "H";
        crates[60][2] = "P";
        crates[60][3] = "Q";
        crates[60][4] = "P";
        crates[60][5] = "M";
        crates[60][6] = "P";
        crates[60][7] = "F";
        crates[60][8] = "D";

        crates[59][0] = "F";
        crates[59][1] = "F";
        crates[59][2] = "Z";
        crates[59][3] = "H";
        crates[59][4] = "S";
        crates[59][5] = "Z";
        crates[59][6] = "T";
        crates[59][7] = "D";
        crates[59][8] = "S";

        crates[58][0] = "M";
        crates[58][1] = "R";
        crates[58][2] = "R";
        crates[58][3] = "P";
        crates[58][4] = "M";
        crates[58][5] = "T";
        crates[58][6] = "H";
        crates[58][7] = "Q";
        crates[58][8] = "C";

        crates[57][0] = "Q";
        crates[57][2] = "V";
        crates[57][3] = "B";
        crates[57][4] = "J";
        crates[57][5] = "H";
        crates[57][6] = "N";
        crates[57][7] = "R";
        crates[57][8] = "N";

        crates[56][0] = "W";
        crates[56][2] = "G";
        crates[56][3] = "F";
        crates[56][4] = "H";
        crates[56][5] = "S";
        crates[56][6] = "M";
        crates[56][8] = "L";

        crates[55][0] = "G";
        crates[55][2] = "H";
        crates[55][3] = "W";
        crates[55][5] = "R";
        crates[55][6] = "L";
        crates[55][8] = "P";

        crates[54][0] = "R";
        crates[54][2] = "S";
        crates[54][3] = "G";
        crates[54][5] = "P";
        crates[54][8] = "H";

        crates[53][0] = "T";
        crates[53][2] = "D";
        crates[53][5] = "L";

        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] parts = line.split(" ");
            int num = Integer.parseInt(parts[1]); // num boxes being moved
            int begin = Integer.parseInt(parts[3]) - 1; // col being moved
            int end = Integer.parseInt(parts[5]) - 1; // col moving to
            for (int i=0; i<num; i++) {
                int bLast = findEmptyIndex(crates, begin) + 1; //rrsghplrh
                int eLast = findEmptyIndex(crates, end);
                String move = crates[bLast][begin];
                crates[eLast][end] = move;
                crates[bLast][begin] = null;
            }
        }

        for (int r=0; r<61; r++) {
            for (int c=0; c<9; c++) {
                System.out.print(crates[r][c] + "\t");
            }
            System.out.println();
        }
        for (int x=0; x<9; x++) {
            int temp = findEmptyIndex(crates, x) + 1;
            System.out.print(crates[temp][x]);
        }
    }
}

// Answer: TPGVQPFDH