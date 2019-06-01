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

import librarymanagement.po.Bookdemage;
import librarymanagement.service.BookdemageService;

/**
 * Servlet implementation class EditDemServlet
 */
@WebServlet("/html/editD")
public class EditDemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.封装数据
		Bookdemage dem=new Bookdemage();
		dem.setDemage_id(Integer.parseInt(request.getParameter("demage_id")));
		//dem.setDname(request.getParameter("dname"));
		//dem.setWriter(request.getParameter("writer"));
		//dem.setDtype(request.getParameter("dtype"));
		//dem.setdInventory(request.getParameter("dInventory"));
       dem.setDamage(request.getParameter("damage"));
		
		//2.调用service层
		BookdemageService serv=new BookdemageService();
		boolean flag=serv.editdem(dem);
		//3.结果反馈
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("msg", "报损失败");
		map.put("error", flag);
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		out.println(gson.toJson(map));
		out.flush();
	}

}
