package org.jarc;

import java.util.Random;

public class Person {

    private String name;
    private int publicPrimeNumber, publicGenerator, finalPrivateSharedSecret, otherPersonPublicSharedSecret;
    final private int privateSecretNumber;
    private Random randomGen = new Random();

    public Person(String givenName){

        this.name = givenName;
        this.privateSecretNumber = (randomGen.nextInt(100) + 1) % 100;
    }

    public void agreePubliclyOnPrimeNumber(int publicPrime){

        this.publicPrimeNumber = publicPrime;
    }

    public void agreePubliclyOnRandomGeneratorNumber(int publicGen){

        this.publicGenerator = publicGen;
    }

    public String getPubliclyAgreeParametersAsString(){

        return "Publicly agreed - Prime Number: " + publicPrimeNumber + ", Generator Number: " + publicGenerator;
    }

    public int getPublicPrimeNumber(){

        return this.publicPrimeNumber;
    }

    public int getPublicGenerator(){

        return this.publicGenerator;
    }

    public int getPrivateSecretNumber(){

        return this.privateSecretNumber;
    }

    public String getName(){

        return this.name;
    }

    public int generateSharedSecret(){

        return (int)Math.pow(this.publicGenerator, this.privateSecretNumber) % publicPrimeNumber;
    }

    public void storeOtherPersonPublicSharedSecret(int givenSecret){

        this.otherPersonPublicSharedSecret = givenSecret;
    }
}
