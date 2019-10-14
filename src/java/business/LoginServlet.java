/*******************************************************
 * Student: Barbara Sullivan                           *
 * CIST 2373 - Java Programming III - Fall 2019        *
 * Lab#5 - More Servlets                               *
 *******************************************************/
package business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Monique
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("idtb");
            String password = request.getParameter("pwtb");

            System.out.println("User Id is: " + id);
            System.out.println("Password is: " + password);

            //JSP
            Customer c1 = new Customer();
            c1.SelectDB(Integer.parseInt(id));
            c1.Display();

            //Database login
            String userDB = password;
            String userDBPass = c1.getCustPassword();

            System.out.println("-----------------");
            System.out.println(userDB);
            System.out.println(userDBPass);
            System.out.println("-----------------");

            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("c1", c1);

            if (userDB.equals(userDBPass)) {
                System.out.println("Valid Login");
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/DisplayAccounts.jsp");
                rd.forward(request, response);
            } else {
                System.out.println("Invalid Login");
                RequestDispatcher rd;
                rd = request.getRequestDispatcher("/loginError.jsp");
                rd.forward(request, response);
            }

        } catch (IOException | NumberFormatException | ServletException e) {

            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
