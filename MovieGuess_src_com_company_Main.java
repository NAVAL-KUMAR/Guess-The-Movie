package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\NavalK\\IdeaProjects\\MovieGuess\\src\\com\\company\\movie.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        while (sc.hasNextLine()) {
            arrayList.add(sc.nextLine());
        }

        int chooseRandomMovie = (int)(Math.random()*arrayList.size());
        String movieName = arrayList.get(chooseRandomMovie);
        char[] c= new char[movieName.length()];

        for(int i = 0 ; i<c.length; i++){
            if(movieName.charAt(i)==' '){
                c[i]=' ';
            }else{
                c[i]='_';
            }
        }

        System.out.println("Enter the Character by guessing.");
        System.out.println("If entered character is correct it will be placed at its original Position");
        System.out.println("Else it will wrong input and planty will be charged of 10 points out total");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wrongPredicted = new ArrayList<>();
        while(!movieName.equals(new String(c))){
            System.out.println("You are quessing: "+ new String(c));
            System.out.print("You have quessed ("+wrongPredicted.size()+") wrong letters:");
            for( Character x:wrongPredicted){
                System.out.print(x+" ");
            }
            System.out.println();
            char guess;
            System.out.print("Guess a letter :");
            guess = scanner.next().charAt(0);
            boolean flag = true;
            for(int i = 0 ; i<c.length; i++){
                if(movieName.charAt(i) == guess){
                    c[i]=guess;
                    flag=false;
                }
            }
            if(flag){
                wrongPredicted.add(guess);
                flag = true;
            }
        }
        System.out.println("You Win!");
        System.out.println("Your have guessed "+movieName+" correctly");
        int points = (10*movieName.length())-(10*wrongPredicted.size());
        int percentage = 10*points/movieName.length();
        System.out.println("Your Score : "+percentage);
    }
}
