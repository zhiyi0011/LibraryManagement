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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import librarymanagement.po.Admin;
import librarymanagement.service.AdminService;




/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/lg")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		
		// 1封装前台传过来的数据
		Admin ad=new Admin();//声明实例化user类型的对象
		ad.setAname(request.getParameter("Aname"));
		ad.setPassword(request.getParameter("Password"));
		// 2将数据信息传送给业务逻辑层处理
		AdminService ser=new AdminService();
		Admin adm=ser.login(ad);
		// 3判断结果
		// 设置结果
		Map<String, Object> mp = new HashMap<String, Object>();
		if(adm==null) {
			mp.put("msg", "用户名或密码错误");
			mp.put("error", false);
		} else {
			mp.put("error", true);
			//记录登录用户的信息，存入session对象
			HttpSession session=request.getSession();//获得本次回话的session对象
			//将用户信息设置成session属性
			session.setAttribute("info", adm);
		}
		// 将信息转换成json格式
		Gson gs = new Gson();
		String str = gs.toJson(mp);// 将mp的内容转换成json字符串
		// 将json字符串打印给V层
		PrintWriter out = response.getWriter();// 从响应对象提取出
		out.println(str);
		out.flush();
	
	}

}
