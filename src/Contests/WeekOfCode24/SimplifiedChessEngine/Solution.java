package Contests.WeekOfCode24.SimplifiedChessEngine;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int g = Integer.parseInt(in.nextLine());
    for (int ig = 0; ig < g; ig++) {
      String inputData = in.nextLine();
      int w = Integer.parseInt(inputData.split(" ")[0]);
      int b = Integer.parseInt(inputData.split(" ")[1]);
      int m = Integer.parseInt(inputData.split(" ")[2]);
      List<String> wPieces = new ArrayList<String>();
      List<String> bPieces = new ArrayList<String>();
      for (int i = 0; i < w; i++) {
        wPieces.add(in.nextLine());
      }
      for (int i = 0; i < b; i++) {
        bPieces.add(in.nextLine());
      }
      in.close();
      chessTeam whiteTeam = new chessTeam(wPieces);
      chessTeam blackTeam = new chessTeam(bPieces);

      boolean flag = true;



//      for (int i = 0; i <m ; i++) {
//        whiteTeam.move();
//      }

      flag = chessTeam.result(whiteTeam, blackTeam, m);
      if (flag) {
        System.out.println("YES");
      }
      else {
        System.out.println("NO");
      }
    }
  }

  public static class chessTeam {
    chessPiece queen;

    List<chessPiece> rocks = new ArrayList<chessPiece>();

    List<chessPiece> bishops = new ArrayList<chessPiece>();

    List<chessPiece> nights = new ArrayList<chessPiece>();

    public chessTeam(List<String> inputPieces) {
      for (int i = 0; i < inputPieces.size(); i++) {
        if (inputPieces.get(i).split(" ")[0].equals("Q")) {
          this.queen = new queen(inputPieces.get(i).split(" ")[1], inputPieces.get(i).split(" ")[2]);
        }
        else if (inputPieces.get(i).split(" ")[0].equals("R")) {
          this.rocks.add(new rock(inputPieces.get(i).split(" ")[1], inputPieces.get(i).split(" ")[2]));
        }
        else if (inputPieces.get(i).split(" ")[0].equals("B")) {
          this.bishops.add(new bishop(inputPieces.get(i).split(" ")[1], inputPieces.get(i).split(" ")[2]));
        }
        else if ((inputPieces.get(i).split(" ")[0].equals("N"))) {
          this.nights.add(new night(inputPieces.get(i).split(" ")[1], inputPieces.get(i).split(" ")[2]));
        }
      }
    }

    public static boolean result(chessTeam iwhiteTeam, chessTeam iblackTeam, int moves){
      boolean flag = false;
      chessTeam whiteTeam = iwhiteTeam;
      chessTeam blackTeam = iblackTeam;
      if (moves>=1){
        if(moves>=3){
          return true;
        } else if(moves==1){
          if(whiteTeam.queen.isCanKill(whiteTeam, blackTeam )){
            return true;
          }


        } else if (moves ==2){


        }

      } else {
        return false;
      }
      return flag;
    }
  }

  public static class chessPiece {
    int posHorizontal;
    int posVertical;

    public boolean isCanKill(chessTeam iwhiteTeam, chessTeam iblackTeam) {
      return false;
    }
  }

  public static class queen extends chessPiece {

    public queen(String posHorizontal, String posVertical) {
      if (posHorizontal.equals("A")){
        this.posHorizontal = 1;
      } else if (posHorizontal.equals("B")){
        this.posHorizontal = 2;
      } else if (posHorizontal.equals("C")){
        this.posHorizontal = 3;
      } else if (posHorizontal.equals("D")){
        this.posHorizontal = 4;
      }
      this.posVertical = Integer.parseInt(posVertical);
    }
    @Override
    public boolean isCanKill(chessTeam iwhiteTeam, chessTeam iblackTeam) {
      boolean flag=false;
      if(iwhiteTeam.rocks.size()==0 && iwhiteTeam.bishops.size()==0 && iwhiteTeam.nights.size()==0
          &&iblackTeam.rocks.size()==0 && iblackTeam.bishops.size()==0 && iblackTeam.nights.size()==0) {
        if(iwhiteTeam.queen.posHorizontal==iblackTeam.queen.posHorizontal) {
          return true;
        }
        if(iwhiteTeam.queen.posVertical==iblackTeam.queen.posVertical) {
          return true;
        }
        if(iwhiteTeam.queen.posVertical<iblackTeam.queen.posVertical) { //TODO here how to kill queen by diagonal
          if (iwhiteTeam.queen.posVertical==iblackTeam.queen.posVertical-1 ){
            return true;
          }
          if (iwhiteTeam.queen.posVertical==iblackTeam.queen.posVertical-2 && iwhiteTeam.queen.posHorizontal==iblackTeam.queen.posHorizontal-2){
            return true;
          }
          if (iwhiteTeam.queen.posVertical==iblackTeam.queen.posVertical-3 && iwhiteTeam.queen.posHorizontal==iblackTeam.queen.posHorizontal-3){
            return true;
          }
        } else {
          if (iblackTeam.queen.posVertical==iwhiteTeam.queen.posVertical-1 ){
            return true;
          }
          if (iblackTeam.queen.posVertical==iwhiteTeam.queen.posVertical-2 && iblackTeam.queen.posHorizontal-2==iwhiteTeam.queen.posHorizontal){
            return true;
          }
          if (iblackTeam.queen.posVertical==iwhiteTeam.queen.posVertical-3 && iblackTeam.queen.posHorizontal-3==iwhiteTeam.queen.posHorizontal){
            return true;
          }
        }
      }
      return flag;
    }
  }

  public static class rock extends chessPiece {

    public rock(String posHorizontal, String posVertical) {
      if (posHorizontal.equals("A")){
        this.posHorizontal = 1;
      } else if (posHorizontal.equals("B")){
        this.posHorizontal = 2;
      } else if (posHorizontal.equals("C")){
        this.posHorizontal = 3;
      } else if (posHorizontal.equals("D")){
        this.posHorizontal = 4;
      }
      this.posVertical = Integer.parseInt(posVertical);
    }
    @Override
    public boolean isCanKill(chessTeam iwhiteTeam, chessTeam iblackTeam) {
      return false;
    }
  }

  public static class bishop extends chessPiece {

    public bishop(String posHorizontal, String posVertical) {
      if (posHorizontal.equals("A")){
        this.posHorizontal = 1;
      } else if (posHorizontal.equals("B")){
        this.posHorizontal = 2;
      } else if (posHorizontal.equals("C")){
        this.posHorizontal = 3;
      } else if (posHorizontal.equals("D")){
        this.posHorizontal = 4;
      }
      this.posVertical = Integer.parseInt(posVertical);
    }
    @Override
    public boolean isCanKill(chessTeam iwhiteTeam, chessTeam iblackTeam) {
      return false;
    }
  }

  public static class night extends chessPiece {

    public night(String posHorizontal, String posVertical) {
      if (posHorizontal.equals("A")){
        this.posHorizontal = 1;
      } else if (posHorizontal.equals("B")){
        this.posHorizontal = 2;
      } else if (posHorizontal.equals("C")){
        this.posHorizontal = 3;
      } else if (posHorizontal.equals("D")){
        this.posHorizontal = 4;
      }
      this.posVertical = Integer.parseInt(posVertical);
    }
    @Override
    public boolean isCanKill(chessTeam iwhiteTeam, chessTeam iblackTeam) {
      return false;
    }
  }
}