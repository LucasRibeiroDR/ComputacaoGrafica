/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex8;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author CC39689758802
 */
public class Limiarizacao {

    public void limiarizacao(String path, String name, String extension) throws IOException {
        File f = new File(path + "\\" + name + extension);
        BufferedImage img = ImageIO.read(f);

        BufferedImage novaLimiarizacao = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        int type = 0;
        int redValue = 0;
        int greenValue = 0;
        int blueValue = 0;

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y));

                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                redValue += r;
                greenValue += g;
                blueValue += b;

            }
        }

        if (redValue > greenValue && redValue > blueValue) {
            type = 0;
        } else if (greenValue > redValue && greenValue > blueValue) {
            type = 1;
        } else if (blueValue > redValue && blueValue > greenValue) {
            type = 2;
        }

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color c = new Color(img.getRGB(x, y));

                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                if (type == 0) {
                    if (r > g && r > b) {
                        Color novaCor = new Color(255, 255, 255);
                        novaLimiarizacao.setRGB(x, y, novaCor.getRGB());
                    } else {
                        Color novaCor = new Color(0, 0, 0);
                        novaLimiarizacao.setRGB(x, y, novaCor.getRGB());
                    }
                }

                if (type == 1) {
                    if (g > b && g > r) {
                        Color novaCor = new Color(255, 255, 255);
                        novaLimiarizacao.setRGB(x, y, novaCor.getRGB());
                    } else {
                        Color novaCor = new Color(0, 0, 0);
                        novaLimiarizacao.setRGB(x, y, novaCor.getRGB());
                    }
                }

                if (type == 2) {
                    if (b > r && b > g) {
                        Color novaCor = new Color(255, 255, 255);
                        novaLimiarizacao.setRGB(x, y, novaCor.getRGB());
                    } else {
                        Color novaCor = new Color(0, 0, 0);
                        novaLimiarizacao.setRGB(x, y, novaCor.getRGB());
                    }
                }
            }
        }
        File outputFile = new File(path + "\\" + "Limiarizacao.jpg");
        ImageIO.write(novaLimiarizacao, "JPG", outputFile);
    }
}
