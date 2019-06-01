package librarymanagement.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import librarymanagement.po.Admin;
import librarymanagement.po.Menu;
import librarymanagement.service.MenuService;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/html/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
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
		//1.��session�л�õ�¼�û���Ϣ
		HttpSession session=request.getSession();
		Admin admin=(Admin) session.getAttribute("info");
		//2.���û���Ϣ���ݸ�server����в˵���ѯ
		MenuService serv=new MenuService();
		List<Menu> list=serv.searchMenuByAdminID(admin);
		//3.����ѯ����Ϣת����json���ݴ��ݸ�ǰ��
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("error", true);
		Gson gson=new Gson();
		map.put("data",list);
		
		PrintWriter out=response.getWriter();
		out.println(gson.toJson(map));
		out.flush();
	}
}
