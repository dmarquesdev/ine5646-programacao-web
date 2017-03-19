package ine5646.primo.servlets;

import ine5646.primo.models.Numero;
import ine5646.primo.views.PrimoView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leandro
 */
@WebServlet(name = "ServletVerificador", urlPatterns = {"/verifique"})
public class ServletVerificador extends HttpServlet {

    private Numero numero;
    private final String COR_PRIMO = "green";
    private final String COR_NAO_PRIMO = "orange";
    private final String COR_ERRO_NAO_EH_HUMERO = "red";
    private String cor = COR_NAO_PRIMO;
    private String mensagem = "Não é primo!";

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        numero = null;
        processeNumero(request.getParameter("numero"));
        PrimoView.render(response.getWriter(), numero, mensagem, cor);
    }

    private void processeNumero(String num) {
        try {
            numero = new Numero(Long.parseLong(num));
            numero.processarValor();
            if (numero.isPrimo()) {
                mensagem = "É primo!";
                cor = COR_PRIMO;
            } else {
                mensagem = "Não é primo!";
                cor = COR_NAO_PRIMO;
            }
        } catch (NumberFormatException ex) {
            mensagem = "Não é um número válido!";
            cor = COR_ERRO_NAO_EH_HUMERO;
        }
    }
}
