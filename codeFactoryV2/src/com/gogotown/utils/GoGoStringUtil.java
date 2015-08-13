package com.gogotown.utils;

/**   
* @Title: GoGoStringUtil.java 
* @Package com.gogotown.utils 
* @Description: 简单的字符串处理
* @author hezhoujun
* @date 2014-12-22 上午10:19:23 
* @version V1.0   
*/
public class GoGoStringUtil {
	
	public static boolean isNotBlank(String str){
		if(null != str && "" != str){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean IsBlank(String str){
		if(null == str || str == ""){
			return true;
		}else{
			return false;
		}
	}
}
