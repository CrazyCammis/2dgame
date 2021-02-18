package com.company.engine;

public class GameContainer implements Runnable {


    private Thread thread;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;


    public GameContainer() {

    }


    public void start() {
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
            passedTime = firstTime - passedTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;


            unprocessedTime += passedTime;


            while (unprocessedTime >= UPDATE_CAP) {

                unprocessedTime -= UPDATE_CAP;
                render = true;

                //TODO: UPDATE GAME
                if(frameTime >= 1.0){
                    frameTime= 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }

            if (render) {
                //TODO; render game
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


    public  static   void main(String args[]){

        GameContainer gc = new GameContainer();
        gc.start();

    }


}


