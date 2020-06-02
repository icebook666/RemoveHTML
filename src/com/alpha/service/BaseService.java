package com.alpha.service;

import com.alpha.service.param.QueryParam;
/**
 * Provide an interface for defining the method feature of creating xml string.
 * */
public interface BaseService {
	/**
	 * 產生xml資料格式，用來回應Reporting Service的請求， 不同報表所生成的xml格式各不相同。
	 * 設計xml結構時需要考慮到時間成本以及Reporting Service支援xml格式的規範。
	 * @param param 自訂義的參數介面，每份報表都有自己的查詢條件，這些查詢條件會從Reporting Service傳過來，傳入的參數物件都必須實作QueryParam介面。
	 * */
	String doXml(QueryParam param);
}
