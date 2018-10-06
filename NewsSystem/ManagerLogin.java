import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ManagerLogin extends HttpServlet{
	
	private String account = null;
	private String password = null;
	private String registeredAccount = null;
    private String registeredPassword = null;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charest=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		account = new String(req.getParameter("account").getBytes("ISO-8859-1"), "UTF-8");
		password = req.getParameter("password");
		boolean isScuceed = false;
		File file = new File("E:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/system/manager.txt");
		
		FileReader sfr = new FileReader(file);
		LineNumberReader lnr = new LineNumberReader(sfr);
		
		while((registeredAccount = lnr.readLine()) != null){
			int ch = 0;
			if((ch = lnr.getLineNumber()%2) == 1){
				if(registeredAccount.equals(account)){
					registeredPassword = lnr.readLine();
					if(registeredPassword.equals(password)){
						out.println("<html>");
					    out.println("<head><title>µÇÂ¼</title></head>");
					    out.println("<h1 align=\"center\">µÇÂ¼³É¹¦£¡</h1>");
					    out.println("<meta http-equiv = \"refresh\" content = \"1;url = http://localhost:8080/system/ManagerMain.html\">");
					    out.println("</html>");
					    isScuceed = true;
					    break;
					    }
					else{
						out.println("<html>");
					    out.println("<head><title>µÇÂ¼</title></head>");
					    out.println("<h1 align=\"center\">ÃÜÂë´íÎó£¡</h1>");
					    out.println("<meta http-equiv = \"refresh\" content = \"1;url = http://localhost:8080/system/Login.html\">");
					    out.println("</html>");
					    isScuceed = true;
					    break;
					    }
					}
				}
			}
		lnr.close();
		if(isScuceed == false){
		out.println("<html>");
	    out.println("<head><title>µÇÂ¼</title></head>");
	    out.println("<h1 align=\"center\">¸ÃÕÊºÅ²»´æÔÚ£¡</h1>");
	    out.println("<meta http-equiv = \"refresh\" content = \"1;url = http://localhost:8080/system/Login.html\">");
	    out.println("</html>");
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	}