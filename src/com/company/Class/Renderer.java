package com.company.Class;

import com.company.engine.GameContainer;
import com.company.engine.gfx.Image;

import java.awt.image.DataBufferInt;

public class Renderer {
    private int pixelWidth, pixelHeight;
    private int[] p;

    public Renderer(GameContainer gameContainer){
        pixelWidth = gameContainer.getWidth();
        pixelHeight = gameContainer.getHeight();
        // gives p[] direct access to the pixel data of our image in our window
        p = ((DataBufferInt) gameContainer.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }

    public void clear(){
        for(int i = 0; i < p.length; i++){
            p[i] = 0;
        }
    }

    public void setPixel(int x, int y, int value){
        if((x < 0 || x >= pixelWidth || y < 0 || y>= pixelHeight) || value == 0xffff00ff){
            return;
        }

        p[x + y * pixelWidth] = value;
    }

    public void drawImage(Image image, int offX, int offY){
        for(int y = 0; y< image.getHeight(); y++){
            for(int x=0; x < image.getWidth(); x++){
                setPixel(x + offX, y + offY, image.getP()[x + y * image.getWidth()]);
            }
        }
    }
}
