package edu.ucla.cs.cs144;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet implements Servlet {
       
    public SearchServlet() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       SearchResult[] results = AuctionSearchClient.basicSearch((String)request.getParameter("q"), 
    		   													Integer.parseInt(request.getParameter("numResultsToSkip")),
    		   													Integer.parseInt(request.getParameter("numResultsToReturn")));
//       request.setAttribute("query", req);
       request.setAttribute("results", results);

       request.getRequestDispatcher("/searchResults.jsp").forward(request, response);
    }
}
