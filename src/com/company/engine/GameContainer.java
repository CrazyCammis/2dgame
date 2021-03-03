package com.company.engine;

import com.company.Class.AbstractGame;
import com.company.Class.Input;
import com.company.Class.Renderer;
import com.company.Class.Window;

public class GameContainer implements Runnable {


    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private  AbstractGame game;

    private int width = 320, height = 240;
    private float scale = 1f;
    private String title = "Engine v1.0";
    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;


    public GameContainer(AbstractGame game) {
        this.game = game;

    }


    public void start() {
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);

        thread = new Thread(this);
        thread.run();
    }

    public void stop() {

    }

    public void run() {

        running = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;




        while (running) {

            running = true;
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;


            unprocessedTime += passedTime;


            while (unprocessedTime >= UPDATE_CAP) {

                unprocessedTime -= UPDATE_CAP;
                render = true;

                //TODO: updata

                input.update();
                game.update(this, (float)UPDATE_CAP);

                if(frameTime >= 1.0){
                    frameTime= 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }

            if (render) {
                renderer.clear();
                game.render(this, renderer);
                window.update();
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        dispose();
    }

    public void dispose() {

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Window getWindow() {
        return window;
    }

    public Input getInput() {
        return input;
    }
}


