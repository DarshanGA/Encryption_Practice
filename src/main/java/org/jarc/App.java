package org.jarc;

import java.util.Locale;
import java.util.Scanner;

public class App {

    private static Scanner inputScan = new Scanner(System.in);

    public static void main(String[] args) {

        int conversationCounter = 1, tempNumber;
        String temp = "", continueChat = "yes";


        Person personA = new Person("First-Person");
        Person personB = new Person("Second-Person");
        System.out.println("\nConversation between [ '" + personA.getName() + "' and '" + personB.getName()
                + " ] : \nPlease note: we already have setup of two people chatting between them and YOU ARE ALWAYS: " + personA.getName());
        System.out.println("Hello, " + personA.getName() + "!\n Type a Prime Number, which you agreed with '" + personB.getName() + "'.");
        tempNumber = inputScan.nextInt();
        if(tempNumber % 2 == 0){

            System.out.println("WARN: Typed number is not a prime, processes canceled!");
        }
        else{

            bothAgreeOnPublicPrimeNumber(personA, personB, tempNumber);
            System.out.println("Type a random number of your choice, bigger the better: ");
            bothAgreeOnPublicGeneratorNumber(personA, personB, inputScan.nextInt());
            inputScan.nextLine();
            System.out.println("Prior LOG: " + personA.getPubliclyAgreeParametersAsString()
                    + "\nPrivate Number for PersonA: " + personA.getPrivateSecretNumber()
                    + "\nPrivate Number for PersonB: " + personB.getPrivateSecretNumber() + "\nComputed shared secret of personA: " + personA.generateSharedSecret());
            System.out.println("You are all set, " + personA.getName() + "! \n Start your chat with '" + personB.getName() + " here: \n"
                    + "\n-------------------------- CHAT START ------------------");
            // chat logic.
            do{


                System.out.println("-------------------------- Conversation: " + conversationCounter + " ------------------\n" + personA.getName() + "(Enter will send this): ");
                conversationCounter++;
                temp = inputScan.nextLine();
                System.out.println("Your Typed: " + temp);
                //sending encrypted message logic here.

                System.out.println("Continue this conversation? Type 'no' to END!; Anything else will Continue.");
                switch(inputScan.nextLine().toLowerCase(Locale.ROOT)){
                    case "no" -> continueChat = "no";
                    default -> continueChat = "yes";
                }
            }while(continueChat.equals("yes"));
            System.out.println("-------------------------- CHAT END ------------------");
        }
    }

    public static void bothAgreeOnPublicPrimeNumber(Person p1, Person p2, int givenPrime){

        p1.agreePubliclyOnPrimeNumber(givenPrime);
        p2.agreePubliclyOnPrimeNumber(givenPrime);
    }

    public static void bothAgreeOnPublicGeneratorNumber(Person p1, Person p2, int givenGenerator){

        p1.agreePubliclyOnRandomGeneratorNumber(givenGenerator);
        p2.agreePubliclyOnRandomGeneratorNumber(givenGenerator);
    }
}
