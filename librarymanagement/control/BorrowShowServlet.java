package librarymanagement.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import librarymanagement.po.Borrow;
import librarymanagement.service.BorrowService;


/**
 * Servlet implementation class BorrowShowServlet
 */
@WebServlet("/html/showBor")
public class BorrowShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //从service层拿数据
		BorrowService serv=new BorrowService();
		List<Borrow> list=serv.searchAll();
		//发送到前端
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		out.println(gson.toJson(list));
		out.flush();
	}

}
