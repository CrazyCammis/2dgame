package com.company.game;

import com.company.Class.AbstractGame;
import com.company.Class.Renderer;
import com.company.engine.GameContainer;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    public  GameManager(){

    }
    @Override
    public void update(GameContainer gameContainer, float dt) {
        if(gameContainer.getInput().isKey(KeyEvent.VK_A)){
            System.out.println("A was pressed");
        }
    }

    @Override
    public void render(GameContainer gameContainer, Renderer renderer) {

    }

    public  static void main(String args[]){
        GameContainer gameContainer = new GameContainer(new GameManager());
        gameContainer.start();
    }
}
