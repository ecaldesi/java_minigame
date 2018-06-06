// Elisabetta Caldesi

package edu.nd.cse.paradigms;
import java.awt.image.BufferedImage;

public class PEScreen{
    private int width, height;
    private int bg;
    private BufferedImage image;
    private int[][] pixels;

    public PEScreen(int width, int height){
        this.width = width;
        this.height = height;
        this.bg = 0xf9ffaa;
        pixels = new int[width][height];
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public boolean inBounds(int px, int py){
        return ((px < width) && (px >= 0) && (py < height) && (py >= 0));
    }

    public void setPixel(int px, int py, int color){
        if ((this.inBounds(px,py)) == true) {
            pixels[px][py] = color;
        }
    }

    public void clear(){
        for (int i = 0; i < width; i++) {
            for (int k = 0; k< height; k++) {
                this.setPixel(i,k,bg);
            }
        }
    }


    public void renderWorldObject(PEWorldObject wo) {
       wo.render(this);
    }

    public BufferedImage render(){
        for (int i = 0; i < width; i++) {
            for (int k = 0;  k< height; k++){
                image.setRGB(i,k,pixels[i][k]);
            }
        }
        return image;
    }
}
