import java.util.*;
import java.io.*;

public class Day5_test {

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
        Scanner input = new Scanner(new File("testCrates.dat"));
        //     [D]    
        // [N] [C]    
        // [Z] [M] [P]
        //  1   2   3 
         
        String[][] crates = new String[10][3];
        crates[9][0] = "Z";
        crates[9][1] = "M";
        crates[9][2] = "P";
        crates[8][0] = "N";
        crates[8][1] = "C";
        crates[7][1] = "D";
        

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

        for (int r=0; r<10; r++) {
            for (int c=0; c<3; c++) {
                System.out.print(crates[r][c] + "\t");
            }
            System.out.println();
        }
    }
    
}
//  H LWZNLR