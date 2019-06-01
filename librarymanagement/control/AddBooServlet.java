package librarymanagement.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import librarymanagement.po.Book;
import librarymanagement.service.BookService;

/**
 * Servlet implementation class AddBooServlet
 */
@WebServlet("/html/addB")
public class AddBooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.封装数据
		Book boo=new Book();
		boo.setBname(request.getParameter("bname"));
		boo.setBauthor(request.getParameter("bauthor"));
		boo.setBorrow(request.getParameter("borrow"));
		boo.setBtype(request.getParameter("btype"));
		boo.setInventory(request.getParameter("Inventory"));
	//2.调用service层
		BookService serv=new BookService();
		boolean flag=serv.addboo(boo);
	//3.结果反馈
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("msg", "添加失败");
		map.put("error", flag);
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		out.println(gson.toJson(map));
		out.flush();
	}

}
