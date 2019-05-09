/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacote;

import com.sun.javafx.geom.AreaOp;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author aluno
 */



public class Classuda {
    
    public static void main(String[] args) {
        
        int histogram[] = new int[256];
        int histR[] = new int[256];
        int histG[] = new int[256];
        int histB[] = new int[256];
        
        for(int i=0;i<histogram.length;i++){
            histogram[i]=0;
        }

        
        try{
            File f = new File("C:\\Users\\a120088\\Downloads\\minazinha.jpg");
            BufferedImage img = ImageIO.read(f);
//            BufferedImage redImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
//            BufferedImage greenImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
//            BufferedImage blueImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
//            BufferedImage estouradassaImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
                    
            for (int x = 0; x < img.getWidth(); x++) {
                    for (int y = 0; y < img.getHeight(); y++) {
                        Color c = new Color(img.getRGB(x, y));
                        int rgb = img.getRGB(x, y);
                        //System.out.println("RGB: "+Integer.toHexString(rgb));
                        //System.out.println("Pos:("+x+","+y+") | RGB: " + rgb+" | RBG Hex: "  +Integer.toHexString(rgb));
                        int r = c.getRed();
                        int g = c.getGreen();
                        int b = c.getBlue();
                        
                        histR[c.getRed()]++;
                        histG[c.getGreen()]++;
                        histB[c.getBlue()]++;
                    }
            }
            System.out.println("teste: "+histR);
            //Formula? P(rk) = 
            // Considerando L = 256
            // P(rk) = estimativa de probabilidade de um pixel na imagem ser da cor K
            // NK = numero de pixels da imagem que estao maquela escala de cinza
            // N =  TOTAL de numero de pixels da imagem
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    Color c = new Color(img.getRGB(x, y));
                    int rgb = img.getRGB(x, y);
                    
                    System.out.println("RGB: "+Integer.toHexString(rgb));
                    
                    //System.out.println("Pos:("+x+","+y+") | RGB: " + rgb+" | RBG Hex: "  +Integer.toHexString(rgb));
//                    int r = c.getRed();
//                    int g = c.getGreen();
//                    int b = c.getBlue();
//                    
//                    int redNew;
//                    if (g>b) redNew = r-g;
                    
                    //System.out.println("R: "+r+"  G: "+g+"  B: "+b+"\n");
//                    Color novaCorR = new Color(r,r,r);
//                    redImage.setRGB(x, y, novaCorR.getRGB());
//                    
//                    Color novaCorG = new Color(g,g,g);
//                    greenImage.setRGB(x, y, novaCorG.getRGB());
//                    
//                    Color novaCorB = new Color(r,r,r);
//                    blueImage.setRGB(x, y, novaCorB.getRGB());
//                    
                    //Color novaCorESTOURADASSA = new Color(Rresultante, Rresultante, Rresultante);
                    //estouradassaImage.setRGB(x, y, novaCorESTOURADASSA.getRGB());
                             
                }
                
//                File outR = new File("C:\\Users\\a120088\\Downloads\\minazinhaR.jpg");
//                ImageIO.write(redImage, "JPG", outR);
//                
//                File outG = new File("C:\\Users\\a120088\\Downloads\\minazinhaG.jpg");
//                ImageIO.write(greenImage, "JPG", outG);
//                
//                File outB = new File("C:\\Users\\a120088\\Downloads\\minazinhaB.jpg");
//                ImageIO.write(blueImage, "JPG", outB);
                
            }

        }catch(Exception ex){
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    
}
