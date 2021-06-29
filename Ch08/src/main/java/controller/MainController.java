package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommonService;



public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> instances = new HashMap<>();
	
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// ������Ƽ ����(�׼��ּ� ���� ����) ��� ���ϱ�=========================
		ServletContext ctx = config.getServletContext();
		String path = ctx.getRealPath("/WEB-INF")+"/urlMapping.properties";
		
		// ������Ƽ ���� �Է½�Ʈ�� ���� �� ������Ƽ ��ü ����====================
		Properties prop = new Properties();
		
		try {
			
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// ������Ƽ ��ü�� ���� ���� ��ü(Map ����ü) ����=====================
		Iterator iter = prop.keySet().iterator();  // interator : �ݺ���
	
		
		while(iter.hasNext()) {
			
			String k = iter.next().toString();
			String v = prop.getProperty(k);
			
			try {
				
				Class obj = Class.forName(v);
				Object instance = obj.newInstance();
				instances.put(k, instance);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	} //init-end
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req, resp);
	}
	
	protected void requestProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ��û�ּ� Service��ü key���ϱ�
		String path = req.getContextPath();          // /Ch08
		String uri  = req.getRequestURI();           // /Ch08/hello.do
		String key  = uri.substring(path.length());  // /hello.do
		
		// Map���� Service��ü ������
		CommonService instance = (CommonService) instances.get(key);
		
		// Service��ü ���� �� View ���� �ޱ�
		String view = instance.requestProc(req, resp);  // "/hello.jsp", "/greeting.jsp", "/welcome.jsp"
		
		// View ������
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, resp);
		
	}
	
}






































