import java.io.*;
import java.util.StringTokenizer;

import javax.servlet.*;
import javax.servlet.http.*;

public class EditNews extends HttpServlet{
	
	private String title = null;
	private String content = null;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charest=utf-8");
		resp.setCharacterEncoding("utf-8");
		title = new String(req.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
		content = new String(req.getParameter("content").getBytes("ISO-8859-1"), "UTF-8");
		StringTokenizer s = new StringTokenizer(content, "\r\n");
		int count = s.countTokens();
		String[] array = new String[count];
		for(int i = 0; i <count ; ++i){
			array[i] = s.nextToken();
		}
		
		File f = new File("E:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/system/News");
	    File file = new File(f, title + ".html");
	    File fi = new File("E:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/system","View"+".html");

	    
	    PrintWriter pw = new PrintWriter(file);
	    pw.println("<!doctype html>");
	    pw.println("<html>");
	    pw.println("<head><title>" + title + "</title></head>");
	    pw.println("<body topmargin=\"40px\">");
	    pw.println("<h2 align=\"center\">" + title + "</h2>" + "<br>");
	    for(int j = 0; j <count ;++j){
	    	pw.println("<p align=\"center\">" + array[j] + "</p>");
	    }
	    pw.println("</body>");
	    pw.println("</html>");
	    pw.close();
	    
	    
	    String[] fullNames = f.list();
		String[] names = new String[fullNames.length];
		for(int j = 0;j<fullNames.length;++j){
			StringTokenizer st = new StringTokenizer(fullNames[j],".");
			names[j] = st.nextToken();
		}
	    PrintWriter out = new PrintWriter(fi);
	    out.println("<head>");
		out.println("<title>查看新闻</title></head>");
		out.println("<body>");
		out.println("<h1 align=center>"+"查看新闻"+"</h1>");
		out.println("<ol class=\"g\" leftmargin=\"100px\">");
		for(int i =0;i<names.length;++i){
			out.println("<li><a href=\"http://localhost:8080/system/News/"+names[i]+".html\">"+names[i]+"</a></li>");
		}
		out.println("<li><a href=\"Login.html\">退出登录</a></li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	    
	    
	    resp.setContentType("text/html;charest=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter outt = resp.getWriter();
	    outt.println("<html>");
	    outt.println("<head><title>增加新闻</title></head>");
	    outt.println("<h1 align=\"center\">增加新闻成功！</h1>");
	    outt.println("<meta http-equiv = \"refresh\" content = \"1;url = http://localhost:8080/system/ManagerMain.html\">");
	    outt.println("</html>");
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}