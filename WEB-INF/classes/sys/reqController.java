package sys;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

//sets url
@WebServlet(urlPatterns = {""})
public class reqController extends HttpServlet {

  //create an instance of a hash class to run on the server
  SecureHash hash = new SecureHash();


//handles get requests
  public void doGet(HttpServletRequest req, HttpServletResponse res) 
    throws IOException, ServletException
  {
    doIndexView(req, res);
    
  }
  

  //handles post requests
  public void doPost(HttpServletRequest req, HttpServletResponse res) 
    throws IOException, ServletException
  {
   
      String toHash = req.getParameter("submited");
        /*
        ** Password Hashing
        */
        
        String hashed = hash.hasher(toHash);

        req.setAttribute("hashed", hashed);
        //get the game jsp
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/hashed.jsp");

        //forward the request
        view.forward(req, res);
  }

 
  

   //displays the game jsp
   private void doIndexView(HttpServletRequest req, HttpServletResponse res) 
   throws IOException, ServletException
 {
   //get the game jsp
   RequestDispatcher view = req.getRequestDispatcher("WEB-INF/index.jsp");

   //forward the request
   view.forward(req, res);
 }

  

}

  