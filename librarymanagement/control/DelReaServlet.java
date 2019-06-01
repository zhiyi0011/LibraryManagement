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

import librarymanagement.service.ReaderService;

/**
 * Servlet implementation class DelReaServlet
 */
@WebServlet("/html/delR")
public class DelReaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelReaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Reader_id=Integer.parseInt(request.getParameter("Reader_id"));
		
		ReaderService serv =new ReaderService();
		boolean flag = serv.delRea(Reader_id);

		// 3.结果反馈
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "删除失败");
		map.put("error", flag);
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(map));
		out.flush();

	}

}
