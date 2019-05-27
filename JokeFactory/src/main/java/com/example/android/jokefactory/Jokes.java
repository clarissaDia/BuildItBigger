package com.example.android.jokefactory;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Jokes {
    List<String> jokesList = asList (
            "Why do Java developers wear glasses? Because they can't c#",
            "Debugging: being a detective in a crime movie where you are also the murderer",
            "3 Database SQL walked into a NoSQL bar. A little bit later... They walked out, because they couldn't fnd a table.",
            "[hip,hip] / hip hip array!",
            "A SQL query goes into a bar, walks up to two table and asks: Can i join you?",
            "A user interface is like a joke. If you have to explain it, it's not that good."
    );

    public String getJoke (){
        Random random = new Random();
        String randomJoke = jokesList.get(random.nextInt(jokesList.size()));
        return randomJoke;
    }
}
