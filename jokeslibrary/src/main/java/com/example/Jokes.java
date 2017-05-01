package com.example;

import java.util.Random;

public class Jokes {
    private static String[] jokesList = {
            "A programmer got stuck in the shower because the instructions on the shampoo bottle said...\nLather, rinse, repeat.",
            "I'll never forget the words of my late great grandfather.....\"Sorry, I'm late.\"",
            "Why did the programmer quit his job? \n Because he didn't get arrays (a raise).",
            "Why do Java programmers have to wear glasses? \n Because they don't C#",
            "There once was a street called Chuck Norris, but the name was changed for public safety because nobody crosses Chuck Norris and lives.",
            "Chuck Norris will never have a heart attack...\n even a heart isn\'t foolish enough to attack Chuck Norris.",
            "If minorities have the race card and women have the gender card, what do rednecks have? \n The Trump Card",
            "Why can't Donald Trump be a Lannister? \n Because he never pays his debts.",
            "How does Donald Trump plan on deporting 12 million illegal immigrants? \n Juan by Juan.",
            "What does Donald Trump say when he can't find his Viagra?\n \"The erection is rigged!\"",
            "Whats Donald Trump's favorite nation?\n Discrimination."
    };

    public String tellJoke(){
        Random r = new Random();
        int randomNum = r.nextInt(jokesList.length);
        return jokesList[randomNum];
    }

}
