package tool;

/**
 * 去除文章內容頁面裡的HTML Tags
 * @author 10008433
 *
 */
public class DelTagsUtil {

	/**
	 * 去除html代碼中含有的標簽
	 * @param htmlStr
	 * @return
	 */
	private static String delHtmlTags(String htmlStr) {
		// script正則表達式，去除js
        String scriptRegex="<script[^>]*?>[\\s\\S]*?<\\/script>";
        // style正則表達式，去除style樣式
        String styleRegex="<style[^>]*?>[\\s\\S]*?<\\/style>";
        // HTML正則表達式，去除html只提取文字肉容
        String htmlRegex="<[^>]+>";
        //定義空格,Enter,換行符,Tab
        String spaceRegex = "\\s*|\t|\r|\n";
 
        // 過濾script
        htmlStr = htmlStr.replaceAll(scriptRegex, "");
        // 過濾style
        htmlStr = htmlStr.replaceAll(styleRegex, "");
        // 過濾html
        htmlStr = htmlStr.replaceAll(htmlRegex, "");
        // 過濾空格等
        //htmlStr = htmlStr.replaceAll(spaceRegex, "");
        return htmlStr.trim(); // 回傳本文字串
    }
	
    /**
     * 取得去除HTML的文字
     * @param htmlStr
     * @return
     */
    public static String getTextFromHtml(String htmlStr){
        //去除html tags
        htmlStr = delHtmlTags(htmlStr);
        //去除空格" "
        //htmlStr = htmlStr.replaceAll(" ","");
        return htmlStr;
    }
	
	public static void main(String[] args) {
		String htmlStr= "<script type>var i=1; alert(i)</script><style> .font1{font-size:12px}</style><span>Test String";
        System.out.println(getTextFromHtml(htmlStr));
	}
}
