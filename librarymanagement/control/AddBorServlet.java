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

import librarymanagement.po.Borrow;
import librarymanagement.service.BorrowService;

/**
 * Servlet implementation class AddBorServlet
 */
@WebServlet("/html/addBorrow")
public class AddBorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.封装数据
				Borrow bor=new Borrow();
				bor.setReader_id(Integer.parseInt(request.getParameter("Reader_id")));
				bor.setBook_id(Integer.parseInt(request.getParameter("book_id")));
				bor.setBorrow_date(request.getParameter("Borrow_date"));
				bor.setSend_date(request.getParameter("Send_date"));
				bor.setContinue_send(request.getParameter("Continue_send"));
				
				//2.调用service层
				BorrowService serv=new BorrowService();
				boolean flag=serv.addBor(bor);
				
				//3.效果反馈
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("msg", "添加失败");
				map.put("error", flag);
				Gson gson=new Gson();
				PrintWriter out= response.getWriter();
				out.println(gson.toJson(map));
				out.flush();
	}

}
