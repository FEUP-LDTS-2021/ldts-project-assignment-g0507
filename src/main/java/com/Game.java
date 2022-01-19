package com;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    Screen screen;
    Paddle paddle;

    public Game() throws IOException {

        try {
            DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(80,40));
            Terminal terminal = defaultTerminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();

            paddle = new Paddle(35,35);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        paddle.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        boolean running = true;
        draw();
        while (running) {
            KeyStroke key = screen.readInput();
            System.out.println(key.getKeyType());
            if((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') || (key.getKeyType() == KeyType.EOF)) running = false;
            if(key.getCharacter() == 'a') movePaddle(paddle.moveLeft());
            if(key.getCharacter() == 'd') movePaddle(paddle.moveRight());
            draw();
        }
        screen.close();
    }

    private void movePaddle(Position position) {
        paddle.setPosition(position);
    }
}
