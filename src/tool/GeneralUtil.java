package tool;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public class GeneralUtil {
	
	/**
	 * 格式化數字
	 * @param number 數字
	 * @param pattern 格式化樣式
	 * @return String 格式化後的數字
	 */
	public static String formatNumber(Number number, String pattern) {
		return new DecimalFormat(pattern).format(number);
	}
	
	public static String formatNumber(String str, String pattern){
		if(NumberUtils.isNumber(str)){
			return formatNumber(Double.valueOf(str),pattern);
		}
		return str;
	}
	
	/**
	 * 將Timestamp的資料格式化成"yyyy/MM/dd"
	 * @param ts 
	 * @return String
	 * */
	public static String formatTimestamp(Timestamp ts){
		if(null != ts){
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			return df.format(new Date(ts.getTime()));
		} else 
			return "";
	}
	
	public static Date convertStringToDate(String str){
		return convertStringToDate(str,"yyyy/MM/dd HH:mm:ss");
	}
	
	public static Date convertStringToDate(String str, String format){
		if(isAllNotEmpty(str,format)){
			DateFormat df = new SimpleDateFormat(format);
			try {
				return df.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} return null;
	}
	
	/**get the pre-string from a string separated by ":"*/
	public static String getCodeFromData(String data){
		if (StringUtils.isEmpty(data)) return null;
		return data.indexOf(":") > 0 ? data.split(":")[0].trim() : data.trim();
	}
	
	public static boolean isAllNotEmpty(String... str){
		boolean result = false;
		if(null != str && str.length != 0){
			for(int i = 0; i < str.length; i++){
				if(StringUtils.isEmpty(str[i])) return false;
			}
			result = true;
		}
		return result;
	}
	
	/**
	 * tomcat不同版本在處理參數有些會強制將單一字串轉成陣列.此方法遇到到字串陣列會取出第一筆
	 * */
	public static String getString(Object o){
		if (null != o && o.getClass().isArray() && !ArrayUtils.isEmpty((Object[])o)){
			return ((String[])o)[0];
		} else if(o instanceof String){
			try {
				return new String(o.toString().getBytes("iso8859_1"));
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		} else return null;
	}
	
	/**
	 * 4捨5入
	 * */
	 public static double round(double d, int scale) {
	     long temp=1;
	     for (int i = scale; i>0; i--) {
	             temp *= 10;
	     }
	     d*=temp;
	     long dl=Math.round(d);
	     return (double)(dl)/temp;
	 }
	 
	 public static double pow2(double d){
		 double result = Math.pow(d, 2);
		 String str = String.valueOf(d);
		 int index = str.indexOf(".");
		 int length = 0;
		 if(index > 0){
			 length = str.length() - index + 1;
			 return round(result,length * 2);
		 }
		 return result;
		 
	 }
	 /**
	  * Convert "abc,cde" to "'abc','cde'"
	  * */
	 public static String getInClause(String str){
		 String[] split = str.split(",");
		 if(null == split || split.length == 0) return "";
		 StringBuilder result = new StringBuilder();
		 for(int i = 0; i < split.length; i++){
			 result.append("'" + split[i] + "',");
		 }
		 int lastIndexOf = result.lastIndexOf(",");
		 return result.toString().substring(0,lastIndexOf);
	 }
	 
	 public static void main(String[] args) {
		//System.out.println(GeneralUtil.norminv(0.95, 2584.13, 177.796674603323));
		 System.out.println(formatNumber("-123.0", "#.000"));
	}
	 
	 
	 /**
	  * 輸入字串，如果為空則回傳""
	  * @param str
	  * */
	 public static String nvl(String str){
		 return nvl(str,"");
	 }

	 /**
	  * 輸入字串，如果為空則回傳空字串，則回傳replacement
	  * @param str
	  * @param replacement
	  * */
	 public static String nvl(String str,String replacement){
		 return StringUtils.isEmpty(str) ? replacement : str;
	 }

	 /**
	  * 輸入字串，如果為空則回傳False，則回傳如果是Y一律為ture,其餘皆為false;
	  * @param str
	  * @param replacement
	  * */
	 public static boolean parseBoolean(String str){
		 return StringUtils.isEmpty(str) ? false : (str.toUpperCase().equals("Y")) ? true : false;
	 }
}


