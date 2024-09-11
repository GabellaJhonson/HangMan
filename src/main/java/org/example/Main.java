package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        while (true) {
            System.out.println("Начать новую игру - y");
            System.out.println("Выйти из игры - n");
            Scanner in = new Scanner(System.in);
            String answer = in.nextLine();
            if (answer.equals("y")) {
                Game game = Game.getInstance();
                game.startGame();
            } else if (answer.equals("n")) {
                System.exit(0);
            }
            else {
                System.out.println("Я вас не понял, давайте сначала");
                TimeUnit.SECONDS.sleep(1);
                for (int i = 0; i < 15; i++){
                    System.out.println( );
                }
            }
        }
    }
}