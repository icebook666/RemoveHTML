package com.alpha;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import com.alpha.service.impl.RemoveHTMLServicesImpl;
import com.alpha.service.param.impl.RemoveHTMLParam;

public class QueryServlet extends HttpServlet {
	private static final String PARAM_FUNCTION_NAME = "functionName";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		Map<String,Object> paramMap = req.getParameterMap();
		String functionName = req.getParameter(PARAM_FUNCTION_NAME);
		//System.out.println("functionName..."+functionName);
		
		if(StringUtils.isNotEmpty(functionName)){
			
			resp.setContentType("application/xml");
			OutputStreamWriter writer = new OutputStreamWriter(resp.getOutputStream(),"UTF-8");
			
			switch(FUNCTION_NAME.valueOf(functionName)){
			
			case RemoveHTML:
				RemoveHTMLParam rh = new RemoveHTMLParam();
				rh.setValues(paramMap);
				writer.write(new RemoveHTMLServicesImpl().doXml(rh));
				break;
				
			}
			writer.flush();
			writer.close();
		}
	
	}
	
	enum FUNCTION_NAME{
		//HelloReport("RemoveHTML"),
		RemoveHTML("RemoveHTML");
		
		String function;
		private FUNCTION_NAME(String function){
			this.function = function;
		}
		public String toString(){
			return function;
		}
	}
}
