package com.example;

import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class pr3 {
    public static void draw(int n){
        switch (n){
            case 0:
                System.out.println("+---+");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("+-------");
                break;
            case 1:
                System.out.println("+---+");
                System.out.println("|   |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("+-------");
                break;
            case 2:
                System.out.println("+---+");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("+-------");
                break;
            case 3:
                System.out.println("+---+");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|   |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("+-------");
                break;
            case 4:
                System.out.println("+---+");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|   |");
                System.out.println("|    \\");
                System.out.println("|");
                System.out.println("+-------");
                break;
            case 5:
                System.out.println("+---+");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|   |");
                System.out.println("|  / \\");
                System.out.println("|");
                System.out.println("+-------");
                break;
            case 6:
                System.out.println("+---+");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|   |\\");
                System.out.println("|  / \\");
                System.out.println("|");
                System.out.println("+-------");
                break;
            case 7:
                System.out.println("+---+");
                System.out.println("|   |");
                System.out.println("|   0");
                System.out.println("|  /|\\");
                System.out.println("|  / \\");
                System.out.println("|");
                System.out.println("+-------");
                break;
            default:
                ;

        }
    }
    public static void main(String[] args) {
        char cha[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String final_answer = "";
        ArrayList already_list = new ArrayList<Integer>();
        int random_letter;
        char guess_times =0;
        System.out.println("This program plays a game of reverse hangman\n" +
                "You think up a word(by typing it in the computer) and " +
                "I'll try to guess the letters. ");
        System.out.println("How many letters are in your word?");
        Scanner sc = new Scanner(System.in);
        int letter_count = sc.nextInt();
        System.out.println("Please enter the word for me to guess(letters only):");
        Scanner str_sc= new Scanner(System.in);
        String word = str_sc.next();
        for(int i=0;i<letter_count;i++){
            already_list.clear();
           while (true){
               System.out.print(final_answer);
               for(int j=0;j<letter_count-final_answer.length();j++){
                  System.out.print("-");
               }
               System.out.print("\n");
               draw(guess_times);
               System.out.println("I've got "+i+" of the "+ letter_count+" letters so far");
               for(;;){
                   int ran = (int)(Math.random()*cha.length);
                   if(already_list.contains(ran)==false){
                       already_list.add(ran);
                       random_letter=ran;
                       break;
                   }
               }
               System.out.println("I guess:"+cha[random_letter]);

               System.out.print("Is that letter in the word?(y or n)");
               String isTrue = str_sc.next();
               if(isTrue.equals("y")) {
                   final_answer += cha[random_letter];
                   break;
               }else {
                   guess_times++;
               }
               if(guess_times>=7){
                   for(int j=0;j<letter_count-final_answer.length();j++){
                       System.out.print("-");
                   }
                   System.out.print("\n");
                   draw(7);
                   System.out.println("You beat me this time.");
                   return;
               }
           }
        }
        System.out.print("The final answer is "+final_answer);
    }

}
