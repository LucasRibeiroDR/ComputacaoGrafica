/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex7;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author CC39689758802
 */
public class Ycbcr {

    public void img_toYCbCr(String path, String name, String extension) throws IOException {
        File f = new File(path + "\\" + name + extension);
        BufferedImage img = ImageIO.read(f);

        BufferedImage YCbCr_Image = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        
        BufferedImage Y_Image = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        BufferedImage Cb_Image = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        BufferedImage Cr_Image = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y));
                double r = c.getRed() / 255f;
                double g = c.getGreen() / 255f;
                double b = c.getBlue() / 255f;

                double Y, cb, cr;

                Y = ((0.2568 * r) + (0.5041 * g) + (0.0979 * b)) + 16;
                cb = ((-0.1482 * r) + (-0.2910 * g) + (0.4392 * b)) + 128;
                cr = ((0.4392 * r) + (-0.3678 * g) + (-0.0714 * b)) + 128;

                //Normalizado
                double nY = ((Y - 16) / 218) * 255;
                double ncb = ((cb - 16) / 224) * 255;
                double ncr = ((cr - 16) / 224) * 255;

                int newColorY = (int) nY;
                int newColorcb = (int) ncb;
                int newColorcr = (int) ncr;

                if (newColorY > 255) {
                    newColorY = 255;
                } else if (newColorY < 0) {
                    newColorY = 0;
                }
                if (newColorcb > 255) {
                    newColorcb = 255;
                } else if (newColorcb < 0) {
                    newColorcb = 0;
                }
                if (newColorcr > 255) {
                    newColorcr = 255;
                } else if (newColorcr < 0) {
                    newColorcr = 0;
                }

                Color novaCorY = new Color(newColorY, newColorY, newColorY);
                Color novaCorCb = new Color(newColorcb, newColorcb, newColorcb);
                Color novaCorCr = new Color(newColorcr, newColorcr, newColorcr);
                Color novaCorYCbCr = new Color(newColorY, newColorcb, newColorcr);
                
                YCbCr_Image.setRGB(x, y, novaCorYCbCr.getRGB());
                Y_Image.setRGB(x, y, novaCorY.getRGB());
                Cb_Image.setRGB(x, y, novaCorCb.getRGB());
                Cr_Image.setRGB(x, y, novaCorCr.getRGB());
            }
        }
        File outputFile = new File(path + "\\" + "YCbCr_Image.jpg");
        ImageIO.write(YCbCr_Image, "JPG", outputFile);

        File output2File = new File(path + "\\" + "Y_Image.jpg");
        ImageIO.write(Y_Image, "JPG", output2File);

        File output3File = new File(path + "\\" + "Cb_Image.jpg");
        ImageIO.write(Cb_Image, "JPG", output3File);
        
        
        File output4File = new File(path + "\\" + "Cr_Image.jpg");
        ImageIO.write(Cr_Image, "JPG", output4File);
    }
}

