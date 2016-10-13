package secondpackage;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sdemianets on 12/10/2016.
 */
public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int Q = in.nextInt();
    for (int a0 = 0; a0 < Q; a0++) {
      int n = in.nextInt();
      String b = in.next();
      String c = b.toUpperCase();
      char[] charArray = c.toCharArray();
      char[] sortedCharArray = c.toCharArray();
      Arrays.sort(sortedCharArray);
      StupidLadyBug stupidLadyBug = new StupidLadyBug(charArray);
      boolean flagSort = stupidLadyBug.checkMoves();
      if(flagSort){
        //        StupidLadyBug.moves(flagSort,charArray,sortedCharArray);
        Arrays.sort(charArray);
      }


      boolean flag = StupidLadyBug.result(charArray);
      if (flag) {
        System.out.println("YES");
      }
      else {
        System.out.println("NO");
      }


    }
  }
  public static class StupidLadyBug{

    char[] charArray;

    public StupidLadyBug(char[] charArray) {
      this.charArray = charArray;
    }

    public boolean checkMoves(){
      for (int i = 0; i < charArray.length; i++) {
        if (charArray[i] == '_') {
          return true;
        }
      }
      return false;
    }

    public static void moves(boolean flag, char[] originalArray, char[] compareArray){
      int attempt=20;
      while(flag && attempt>0){


        if(Arrays.equals(originalArray, compareArray)){
          flag=false;
        }
        attempt--;
      }
    }


    public static boolean result(char[] charArray){
      boolean flag = true;
      if (charArray.length > 2)
      {
        for (int i = 2; i < charArray.length; i++)
        {
          if (charArray[i - 2] != charArray[i - 1] && charArray[i - 1] != charArray[i])
          {
            flag = false;
            break;
          }
        }
      } else if (charArray.length == 2)
      {
        if (charArray[0] != charArray[1]) {
          flag = false;
        }}
      else if (charArray[0] != '_')
      {
        flag = false;
      }
      return flag;


    }
  }
}

