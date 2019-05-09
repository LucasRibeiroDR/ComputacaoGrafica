/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex10;

/**
 *
 * @author CC39689758802
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Suavizacao {
    
    public void img_toSuaveMediana(String path, String name, String extension, int dimension) throws IOException{
        File f = new File(path + "\\" + name + extension);
        BufferedImage img = ImageIO.read(f);
        
        BufferedImage SuaveMediana_Image = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y));
                double r = c.getRed()/255f;
                double g = c.getGreen()/255f;
                double b = c.getBlue()/255f;
                
                int raio = (dimension - ((dimension/2)+1));
                int somaR = 0, somaB = 0, somaG = 0, cont = 0;

                for(int j = x-raio; j <= x+raio; j++){
                    for(int k = y-raio; k <= y+raio; k++){

                        if(k >= 0 && j >= 0 && j < img.getWidth() && k < img.getHeight()){
                            Color cor = new Color(img.getRGB(j, k));
                            somaR += cor.getRed();
                            somaG += cor.getGreen();
                            somaB += cor.getBlue();
                            cont++;
                        }
                                          
                    }
                }
                
                int mediaR = somaR/cont;
                int mediaG = somaG/cont;
                int mediaB = somaB/cont;
                
                Color novaCorH = new Color(mediaR,mediaG,mediaB);
                SuaveMediana_Image.setRGB(x, y, novaCorH.getRGB());

            }
        }
    
    
        File outputFile = new File(path + "\\" + "New_ImageSuaveMediana.jpg");
        ImageIO.write(SuaveMediana_Image, "JPG", outputFile);
        
    }
}
