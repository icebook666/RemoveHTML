package com.alpha.service.impl;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jsoup.Jsoup;

import tool.GeneralUtil;

import com.alpha.service.BaseService;
import com.alpha.service.param.QueryParam;
import com.alpha.service.param.impl.RemoveHTMLParam;

public class RemoveHTMLServicesImpl implements BaseService {
	
	@Override
	public String doXml(QueryParam param) {
		
		RemoveHTMLParam rh = (RemoveHTMLParam) param;
		String myResult = "";
		myResult = Jsoup.parse(rh.getHtml_text()).text(); //使用Jsoup API去除html
		
		Document xmlDoc = DocumentHelper.createDocument();
		Element root =xmlDoc.addElement("DATA");
		Element entity = root.addElement("ENTITY");
		entity.addElement("CONVERT_TEXT").addText(GeneralUtil.nvl(myResult));
		
		return xmlDoc.asXML();
	}	
}
