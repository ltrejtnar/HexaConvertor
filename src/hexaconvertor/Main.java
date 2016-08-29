/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexaconvertor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nudista
 */
public class Main {

    public static void write(String file, String number) {
        try (FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(number);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public static String convert(String number) {
        String result = "";

        String delims = "[ ]";
        String[] item = number.split(delims);
        for (String item1 : item) {
            result = result + " " + convertItem(item1);
        }
        return result;
    }

    public static String convertItem(String number) {
        int i = Integer.parseInt(number, 16);
        return "" + i;
    }

    public static void main(String[] args) {
        try {
            String INfile = "input.txt";
            String OUTfile = "output.txt";
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(INfile));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (String line; (line = br.readLine()) != null;) {
                write(OUTfile, convert(line));
            }
            // line is not visible here.
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
