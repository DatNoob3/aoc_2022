// 12/11/2022 - 8PM

import java.util.*;
import java.io.*;

public class Day8_part2 {
    public static boolean isVisible(String[][] arr, int row, int col) {
        int test = Integer.parseInt(arr[row][col]);

        // 3       0       3       7       3
        // 2       5       5       1       2
        // 6       5       3       3       2
        // 3       3       5       4       9
        // 3       5       3       9       0

        if (row == 0 || col == 0 || row == arr.length || col == arr[0].length) {
            return true;
        }
        // left/right
        boolean hor = true;
        for (int c1=0; c1<col; c1++) {
            if (Integer.parseInt(arr[row][c1]) >= test) {
                for (int c2=col+1; c2<arr[0].length; c2++) {
                    if (Integer.parseInt(arr[row][c2]) >= test) {
                        hor = false;
                    }

                }
            }
        }

        boolean ver = true;
        for (int r1=0; r1<row; r1++) {
            if (Integer.parseInt(arr[r1][col]) >= test) {
                for (int r2=row+1; r2<arr.length; r2++) {
                    if (Integer.parseInt(arr[r2][col]) >= test) {
                        ver = false;
                    }
    
                }
            }
        }

        if (hor == false && ver == false) {
            return false;
        }
        return true;
    }

    public static int calculateScenicScore(String[][] arr, int row, int col) {
        int test = Integer.parseInt(arr[row][col]);
        // left/right
        if (row == 0 || col == 0 || row == arr.length || col == arr[0].length) {
            return 0;
        }

        int west = 0;
        for (int c1=col-1; c1>=0; c1--) {
            if (Integer.parseInt(arr[row][c1]) >= test) {
                west = col-c1;
                break;
            } else {
                west = col;
            }
        }
        int east = 0;
        for (int c2=col+1; c2<arr[0].length; c2++) {
            if (Integer.parseInt(arr[row][c2]) >= test) {
                east = c2-col;
                break;
            } else {
                east = arr[0].length-col-1;
            }
        }
        int north = 0;
        for (int r1=row-1; r1>=0; r1--) {
            if (Integer.parseInt(arr[r1][col]) >= test) {
                north = row-r1;
                break;
            } else {
                north = row;
            }
        }
        int south = 0;
        for (int r2=row+1; r2<arr.length; r2++) {
            if (Integer.parseInt(arr[r2][col]) >= test) {
                south = r2-row;
                break;
            } else {
                south = arr.length-row-1;
            }

        }
        return west*east*north*south;
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("trees.dat"));

        int numRows = 99;
        int numCols = 99;

        String[][] map = new String[numRows][numCols];

        int rowNum = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] parts = line.split("");
            for (int x=0; x<parts.length; x++) {
                map[rowNum][x] = parts[x];
            }
            rowNum++;
        }

        int max = 0;
        for (int r=0; r<numRows; r++) {
            for (int c=0; c<numCols; c++) {
                if (calculateScenicScore(map, r, c) > max) {
                    max = calculateScenicScore(map, r, c);
                }
            }
        }
        System.out.println(max);
    }
}

// Answer: 268464
