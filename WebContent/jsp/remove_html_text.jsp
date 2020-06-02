<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="net.sf.json.*"%>
<%@ page import="org.jsoup.*"%>
<%@ page import="tool.DelTagsUtil"%>
<%
	String html_text = request.getParameter("html_text");
	String method = request.getParameter("method");
	JSONObject jo = new JSONObject();
	String myResult = "";
	
	//System.out.println(html_text);
	
	if (method.equals("Regex"))
		myResult = DelTagsUtil.getTextFromHtml(html_text); //使用正規表示法去除html
	else
		myResult = Jsoup.parse(html_text).text(); //使用Jsoup API去除html
	
	jo.put("result", myResult);
	
	out.clear();
	response.getWriter().write(jo.toString());
%>

