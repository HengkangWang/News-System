import java.io.*;
import java.util.StringTokenizer;

import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteNews extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charest=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		String title = new String(req.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
		boolean isDeeted = false;
		
		File f = new File("E:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/system/News");
		String[] fullNames = f.list();
		String[] names = new String[fullNames.length];
		for(int j = 0;j<fullNames.length;++j){
			StringTokenizer st = new StringTokenizer(fullNames[j],".");
			names[j] = st.nextToken();
			if(title.equals(names[j])){
				File df = new File("E:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/system/News", title +".html");
				df.delete();
				isDeeted = true;
				out.println("<html>");
			    out.println("<head><title>删除新闻</title></head>");
			    out.println("<h1 align=\"center\">删除新闻成功！</h1>");
			    out.println("<meta http-equiv = \"refresh\" content = \"1;url = http://localhost:8080/system/ManagerMain.html\">");
			    out.println("</html>");
			    
			    
			    File ddf = new File("E:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/system/News");
			    File fi = new File("E:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/system","View"+".html");
			    String[] dfullNames = ddf.list();
				String[] dnames = new String[dfullNames.length];
				for(int m = 0;m<dfullNames.length;m++){
					StringTokenizer stt = new StringTokenizer(dfullNames[m],".");
					dnames[m] = stt.nextToken();
				}
				
				
			    PrintWriter outt = new PrintWriter(fi,"utf-8");
			    outt.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
			    outt.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
			    outt.println("<head>");
			    outt.println("<style type=\"text/css\">");
			    outt.println(".STYLE1 {font-size: 32px}");
			    outt.println(".STYLE2 {font-size: 16px}");
			    outt.println(".STYLE3 {font-size: 16px}");
			    outt.println("</style>");
			    outt.println("<title>main</title>");
			    outt.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
			    outt.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />");
			    outt.println("<script type=\"text/javascript\" src=\"js/cufon-yui.js\"></script>");
			    outt.println("<script type=\"text/javascript\" src=\"js/arial.js\"></script>");
			    outt.println("<script type=\"text/javascript\" src=\"js/cuf_run.js\"></script>");
			    outt.println("</head>");
			    outt.println("<body>");
			    outt.println("<div class=\"main\">");
			    outt.println("  <div class=\"header\">");
			    outt.println("    <div class=\"header_resize\">");
			    outt.println("      <div class=\"logo\">");
			    outt.println("        <h1> <a href=\"Login.html\">新<span>news</span>闻</a> <small>发布系统</small> </h1>");
			    outt.println("      </div>");
			    outt.println("      <div class=\"menu_nav\">");
			    outt.println("      <!--<ul>");
			    outt.println("          <li class=\"active\"><a href=\"index.html\">Home</a></li>");
			    outt.println("          <li><a href=\"support.html\">Support</a></li>");
			    outt.println("          <li><a href=\"about.html\">About US</a></li>");
			    outt.println("          <li><a href=\"blog.html\">Blog</a></li>");
			    outt.println("          <li><a href=\"contact.html\">Contact US</a></li>");
			    outt.println("      </ul>-->");
			    outt.println("      </div>");
			    outt.println("      <div class=\"clr\"></div>");
			    outt.println("        <table height=\"258\" border=\"0\">");
			    outt.println("          <tr>");
			    outt.println("            <td width=\"322\" align=\"left\" valign=\"top\">");
			    outt.println("            	<br/>");
			    for(int i =0;i<dnames.length;i++){
					outt.println("<li><a href=\"http://localhost:8080/system/News/"+dnames[i]+".html\"><font color=\"#0000FF\" size=\"+2\">"+dnames[i]+"</font></a></li>");
				}
			    outt.println("                <br/>");
			    outt.println("				<li><a href=\"Login.html\"><font color=\"#0000FF\" size=\"+2\">退出登录</font></a></li>");
			    outt.println("				</ul>");
			    outt.println("            <td width=\"637\" valign=\"bottom\" align=\"right\"><img src=\"images/main_img.png\" alt=\"image\"/></td>");
			    outt.println("          </tr>");
			    outt.println("        </table>");
			    outt.println("    </div>");
			    outt.println("  </div>");
			    outt.println("</div>");
			    outt.println("<div>");
			    outt.println("</div>");
			    outt.println("<div style=\"display:none\"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>");
			    outt.println("</body>");
			    outt.println("</html>");
			    outt.close();
			}
		}
		if(isDeeted == false){
			out.println("<html>");
		    out.println("<head><title>删除新闻</title></head>");
		    out.println("<h1 align=\"center\">输入的新闻不存在！</h1>");
		    out.println("<meta http-equiv = \"refresh\" content = \"1;url = http://localhost:8080/system/DeleteNews.html\">");
		    out.println("</html>");
		    out.close();
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}