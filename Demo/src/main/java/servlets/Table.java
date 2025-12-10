package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/table")
public class Table extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nombreArg = request.getParameter("nombre");
        
        PrintWriter out = response.getWriter();
        
        if(nombreArg != null ) {
        	int nombre = Integer.parseInt(nombreArg);
        	for (int i = 0; i < 11; i++) {
    			
            	out.printf(nombre ," * ", i ," = ", nombre*i ,"<br>");		
    			
    		}
        	
        }
        
        
        
    }
}