//package com.company.Class;
//
//import java.awt.image.DataBufferInt;
//
//public class Renderer {
//    private int pixelWidth, pixelHeight;
//    private int[] p;
//
//    public Renderer(GameContainer gameContainer){
//        pixelWidth = gameContainer.getWidth();
//        pixelHeight = gameContainer.getHeight();
//        // gives p[] direct access to the pixel data of our image in our window
//        p = ((DataBufferInt) gameContainer.getWindow().getImage().getRaster().getDataBuffer()).getData();
//    }
//
//    public void clear(){
//        for(int i = 0; i < p.length; i++){
//            p[i] = 0;
//        }
//    }
//}
