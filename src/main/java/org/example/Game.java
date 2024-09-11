package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Game instance;
    private int score;
    private final String name;
    private final Random rand;
    private final Scanner in;

    private Game(){
        score = 0;
        rand = new Random();
        in = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        name = in.nextLine();
    }
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
    public void startGame() throws IOException {
        String word = Files.readAllLines(Paths.get("/Users/iisuos/IdeaProjects/Kolok with test/HangMan/src/main/java/dictionary.txt")).get(rand.nextInt(100));
        String secretWord = new String(new char[word.length()]).replace((char) 0, '@');
        int lives = 10;
        int letters = word.length();
        String input;
        System.out.println("Хорошо, " + name + ", я загадал новое слово test push");
        while(lives > 0 && letters > 0) {
            draw(secretWord);
            input = in.nextLine();
            if(input.length() != 1){
                System.out.println("Введите одну букву!");
                continue;
            }

            //Проверить была ли введена такая буква раньше
            if(word.split(input, -1).length - 1 != 0){
                System.out.println("Отлично, вы угадали букву!");
                for (int i = 0; i < word.length(); i++){
                    if(word.charAt(i) == input.charAt(0)){
                        secretWord = secretWord.substring(0, i) + input.charAt(0) +
                                     secretWord.substring(i + 1);
                        letters--;
                    }
                }
            }
            else{
                System.out.println("Такой буквы нет(");
                lives--;
            }
        }
    }
    private void draw(String secretWord){
        System.out.println(secretWord);
    }

    public int getScore() {
        return score;
    }
}
