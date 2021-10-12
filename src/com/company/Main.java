package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random= new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Lets play blackjack!");
        do {
            int computerhand = random.nextInt(11) + random.nextInt(11) + 2;
            int humanhand = random.nextInt(11) + random.nextInt(11) + 2;
            String answer="";
            System.out.println("You have a total of " + humanhand);
            boolean card=true;
            boolean finalcards=true;
            while (true){
                if(humanhand>20){
                    break;
                }
                if(finalcards && computerhand+random.nextInt(5)<=20 && computerhand<21){
                    computerhand= computerhand + random.nextInt(11)+1;
                }
                else{
                    finalcards=false;
                }
                if(computerhand>20){
                    break;
                }

                if(card){
                    System.out.println("Press y if you want another card");
                    answer = input.next().toLowerCase();
                    if(answer.charAt(0)!='y'){
                        card=false;
                    }
                    else {
                        humanhand = humanhand + random.nextInt(11) + 1;
                        System.out.println("You have a total of " + humanhand);
                    }
                }
                if(!card && !finalcards){
                    break;
                }
            }
            System.out.println("The computer had a total of " + computerhand);
            int winnercalculator = computerhand-humanhand;
            if(winnercalculator==0){
                System.out.println("Tie!");
            }
            else if(computerhand>21){
                System.out.println("You win!");
            }
            else if(humanhand>21){
                System.out.println("You lost!");
            }
            else if(winnercalculator>0){
                System.out.println("You lost!");
            }
            else{
                System.out.println("You win!");
            }

            System.out.println("do you want to play again? press y!");
            answer = input.next().toLowerCase();
            if(answer.charAt(0)!='y') {
                break;
            }
        }while(true);
    }
}
