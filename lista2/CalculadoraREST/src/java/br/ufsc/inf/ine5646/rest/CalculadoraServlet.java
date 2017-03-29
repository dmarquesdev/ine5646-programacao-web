/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.ine5646.rest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "CalculadoraServlet", urlPatterns = {"/calc/*"})
public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println(handleRequest(req.getPathInfo().substring(1)));
        }
        
    }
    
    public String handleRequest(String urlParams) {
        String[] params = urlParams.split("/");
        JsonArray ja = new JsonArray();
        try {
        if(params.length != 3) {
            ja.add(new JsonPrimitive("erro"));
            ja.add(new JsonPrimitive("número de parâmetros incorreto! Exemplo: soma/5/8"));
        } else if (!params[0].equals("soma") && !params[0].equals("subt") && 
                !params[0].equals("mult") && !params[0].equals("divi")) {
            ja.add(new JsonPrimitive("erro"));
            ja.add(new JsonPrimitive("Operação deve ser uma destas: soma,subt,mult,divi"));
        } else if (params[0].equals("divi") && Double.parseDouble(params[2]) == 0) {
            ja.add(new JsonPrimitive("erro"));
            ja.add(new JsonPrimitive("divisão por zero"));
        } else {
            double num1 = Double.parseDouble(params[1]);
            double num2 = Double.parseDouble(params[2]);
            
            ja.add(new JsonPrimitive("ok"));
            
            switch(params[0]) {
                case "soma":
                    ja.add(new JsonPrimitive(num1 + num2));
                    break;
                case "subt":
                    ja.add(new JsonPrimitive(num1 - num2));
                    break;
                case "mult":
                    ja.add(new JsonPrimitive(num1 * num2));
                    break;
                case "divi":
                    ja.add(new JsonPrimitive(num1 / num2));
                    break;
                default:
                    break;
            }
        }
        
        } catch (NumberFormatException ex) {
            ja.add(new JsonPrimitive("erro"));
            ja.add(new JsonPrimitive(params[1] + " e/ou " + params[2] + " não é número"));
        }
        
        return ja.toString();
    }
    
}
