/*********************************************************
 * Student: Barbara Sullivan                             *
 * CIST 2373 - Java Programming III - Fall 2019          *
 * Lab#6 - Simple JSPs - Part IV (AccountLookupServlet)  *
 *********************************************************/
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
@WebServlet(name = "AccountLookupServlet", urlPatterns = {"/AccountLookupServlet"})
public class AccountLookupServlet extends HttpServlet {

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
            
			Account a1;

            String userNum;
            String userAcctNum;
            try {
                userAcctNum = request.getParameter("Accttb");

                //Get Session
                HttpSession ses2;
                ses2 = request.getSession();
                Customer c1 = (Customer) ses2.getAttribute("c1");

                int custId = c1.getCustId();
                a1 = new Account();
                a1.SelectDB(Integer.parseInt(userAcctNum));
                a1.Display();

                ses2.setAttribute("a1", a1);
                System.out.println("Customer Added");
                userNum = String.valueOf(a1.getAcctNo());

                if (userNum.equals(userAcctNum)) {
                    System.out.println("Valid Account");
                    RequestDispatcher rd;
                    rd = request.getRequestDispatcher("/displayAccount.jsp");
                    rd.forward(request, response);
                } else {
                    System.out.println("Invalid Account");
                    RequestDispatcher rd;
                    rd = request.getRequestDispatcher("/loginError.jsp");
                    rd.forward(request, response);
                }
            } finally {
                System.out.println("AccountServerLookup Done");
                out.close();
            }
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
