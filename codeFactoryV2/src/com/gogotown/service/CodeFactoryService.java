package com.gogotown.service;

import com.gogotown.commons.Constans;
import com.gogotown.entity.DbEntity;
import com.gogotown.entity.FileEntity;
import com.gogotown.entity.TableEntity;
import com.gogotown.utils.GoGoStringUtil;
import com.gogotown.utils.code.CreateCodeUtil;
import com.gogotown.utils.database.GenEntityMysqlUtil;
import com.gogotown.utils.page.CreatePateUtil;
import com.gogotown.utils.xml.XmlUtil;

public class CodeFactoryService {
	
	/** 
	* @author hezhoujun
	* @Title: codeGenerateRun 
	* @Description: 代码生成器方法入口
	* @param tablename
	* @param dbEntity
	* @param fileEntity
	* @throws Exception void
	*/
	public static void codeGenerateRun(String tablename,DbEntity dbEntity,FileEntity fileEntity)throws Exception{
		//bean
		TableEntity table = GenEntityMysqlUtil.generateEntityRun(tablename, dbEntity, fileEntity);
		//code
		CreateCodeUtil.createCode(table.getTablename(), table.getTable_description(), fileEntity);
		//page
		CreatePateUtil.createPage(table, fileEntity);
		tablename = GoGoStringUtil.firstChar2Up(tablename);
		String urlPattern = GoGoStringUtil.firstChar2Little(tablename);
		String fullClassPath = fileEntity.getBasePackage()+ "." +Constans.TYPE_ACTION+"."+ tablename +"Action";
		//web.xml
		XmlUtil.createWebXml(fileEntity, tablename, fullClassPath, urlPattern);
	}
	
	public static void main(String[] args){
		/**
		 * String realPath = CodeGenerateTest.class.getResource("/").toString();
			realPath = realPath.substring(0, realPath.indexOf("/target/"))+"/";
			String projectPath = (realPath + "src/main/").replaceAll("file:/", "");
		 * */
		try {
			DbEntity dbEntity = new DbEntity("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.155:3306/lisendb", "root", "root");
			String tablename = "admin";
			FileEntity fileEntity = new FileEntity("E:/testpage/","com.lisen.entity","hezhoujun",false);
			codeGenerateRun(tablename, dbEntity, fileEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
