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


import librarymanagement.po.Reader;

import librarymanagement.service.ReaderService;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/html/addR")
public class AddReaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.封装数据
		Reader rea = new Reader();
		
		rea.setReader_id(Integer.parseInt(request.getParameter("Reader_id")));
		
		rea.setRname(request.getParameter("Rname"));
		rea.setSex(request.getParameter("Sex"));
		rea.setDepart(request.getParameter("Depart"));
		// 2.调用service层
		ReaderService serv =new ReaderService();
		boolean flag = serv.addRea(rea);

		// 3.结果反馈
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "添加失败");
		map.put("error", flag);
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(map));
		out.flush();

	}

}


