/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex11;

import java.io.IOException;

/**
 *
 * @author CC39689758802
 */
public class Conversao {
        public static void main(String[] args) throws IOException {
            Mascaras mascaras = new Mascaras();
            mascaras.img_toFiltragemMascara("C:\\Users\\CC39689758802\\Desktop", "senna", ".jpg", 1);
    }
}
