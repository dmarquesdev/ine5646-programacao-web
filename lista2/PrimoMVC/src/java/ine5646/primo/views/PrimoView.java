/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646.primo.views;

import ine5646.primo.models.Numero;
import java.io.PrintWriter;

/**
 *
 * @author diego
 */
public class PrimoView {

    public static void render(PrintWriter out, Numero numero, String mensagem, String cor) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>INE5646 - primo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>INE5646 - primo</h1>");
        out.println("<h2 style='color: " + cor + "'>" + 
                (numero != null ? (numero + " : ") : "") + 
                mensagem + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
