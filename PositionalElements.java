/* M x N matrix. You have to count the total no. of cells which are either maximum or minimum or both in it’s row or column. Two different cells can have same value.  – Can be easily solved using hash.
For better understanding : a)If a cell has min/max value in row as well as column it’ll be counted only one and not twice.
b) assume value (3, 4) is 6 and (5, 6) is also 6 and both are min/max values in row/column, then it’ll be counted twice. */

import java.io.*;
import java.util.*;

class PositionalElements {
  
  public static void main(String[] args) {
    int m=3, n=3;
    int[][] matrix = {{1, 3, 4}, {5, 2, 9}, {8, 7, 6}};
    int[][] result_row = { {0, 0}, {0, 0}, {0, 0}};
    int[][] result_col = { {0, 0}, {0, 0}, {0, 0}};
    ArrayList<Integer> result = new ArrayList<Integer>(2*(m+n));
    int count = 0;
    
    for(int i=0; i<3; i++)
    {
      for(int j=0; j<3; j++)
      {
        if(matrix[i][j] < matrix[i][result_row[i][0]])
          result_row[i][0] = j;
        if(matrix[i][j] > matrix[i][result_row[i][1]])
          result_row[i][1] = j;
        if(matrix[i][j] < matrix[i][result_col[j][0]])
          result_col[j][0] = i;
        if(matrix[i][j] > matrix[i][result_col[j][1]])
          result_col[j][1] = i;
      }
    }
    
    for(int i=0; i<3; i++)
    {
      int min = i*3 + result_row[i][0] * 1000;
      int max = i*3 + result_row[i][1] * 1000;
      if(result.indexOf(min) == -1)
        count ++;
      result.add(min);
      if(result.indexOf(max) == -1)
        count ++;
      result.add(max);
      System.out.println(min + ", " + max);
    }
    System.out.println();
    for(int j=0; j<3; j++)
    {
      int min = result_col[j][0]*3 + j*1000;
      int max = result_col[j][1]*3 + j*1000;
      if(result.indexOf(min) == -1)
        count ++;
      result.add(min);
      if(result.indexOf(max) == -1)
        count ++;
      result.add(max);
      System.out.println(min + ", " + max);
    }
    System.out.println(count);
  }
}
