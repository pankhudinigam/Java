// nth line of pascal's triangle
import java.io.*;
import java.util.*;

class PascalTriangle {
  
  public static void main(String[] args) {
    int n = 11;
    ArrayList<Integer> lastRow = new ArrayList<Integer>(n);
    lastRow.add(1);
    for(int i=1; i<n; i++) {
      ArrayList<Integer> currentRow = new ArrayList<Integer>(i);
      for(int j=0; j<=i; j++) 
        if(j == 0 || j== i)
          currentRow.add(1);
        else
          currentRow.add( lastRow.get(j-1) + lastRow.get(j));
      System.out.println(lastRow);
      lastRow = currentRow;
    }
  }
}
