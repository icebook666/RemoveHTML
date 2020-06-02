package com.alpha.service.param.impl;

import java.io.Serializable;
import java.util.Map;
import tool.GeneralUtil;
import com.alpha.service.param.QueryParam;

//將畫面的參數檔案從FaceLet傳遞進來,並設定在自定義的Param物件內
public class RemoveHTMLParam implements QueryParam,Serializable {
	
	private String html_text;
	private String functionName;
	
	@Override
	public void setValues(Map<String, Object> paramMap) {
		setHtml_text(GeneralUtil.getString(paramMap.get("html_text")));
		setFunctionName(GeneralUtil.getString(paramMap.get("functionName")));
	}

	public String getHtml_text() {
		return html_text;
	}

	public void setHtml_text(String html_text) {
		this.html_text = html_text;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
}
