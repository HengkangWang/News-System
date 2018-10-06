import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Register extends HttpServlet {
	
	private String account = null;
	private String password = null;
	private String registeredAccount = null;
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charest=utf-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		account = new String(req.getParameter("account").getBytes("ISO-8859-1"), "UTF-8");
		password = req.getParameter("password");
		boolean isRegistered = false;
		File file = new File("E:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/system/account.txt");
        
		FileReader fr = new FileReader(file);
		LineNumberReader lnr = new LineNumberReader(fr);
		
		while((registeredAccount = lnr.readLine()) != null){
			int ch = 0;
			if((ch = lnr.getLineNumber()%2) == 1){
				if(registeredAccount.equals(account)){
					out.println("<html>");
				    out.println("<head><title>注册</title></head>");
				    out.println("<h1 align=\"center\">该帐号已存在！</h1>");
				    out.println("<meta http-equiv = \"refresh\" content = \"1;url = http://localhost:8080/system/Register.html\">");
				    out.println("</html>");
				    isRegistered = true;
				    break;
				    }
				}
			}
		lnr.close();
		if(isRegistered == false){
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(account);
		bw.newLine();
		bw.flush();
		bw.write(password);
		bw.newLine();
		bw.close();
		out.println("<html>");
	    out.println("<head><title>注册</title></head>");
	    out.println("<h1 align=\"center\">用户注册成功！</h1>");
	    out.println("<meta http-equiv = \"refresh\" content = \"1;url = http://localhost:8080/system/Login.html\">");
	    out.println("</html>");
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	}