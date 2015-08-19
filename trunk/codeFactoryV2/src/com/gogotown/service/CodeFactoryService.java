package com.gogotown.service;

import com.gogotown.commons.Constans;
import com.gogotown.entity.DbEntity;
import com.gogotown.entity.FileEntity;
import com.gogotown.entity.FlagEntity;
import com.gogotown.entity.TableEntity;
import com.gogotown.utils.GoGoStringUtil;
import com.gogotown.utils.code.CreateCodeUtil;
import com.gogotown.utils.database.CreateEntityUtil;
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
	public static void codeGenerateRun(String tablename,DbEntity dbEntity,FileEntity fileEntity,FlagEntity flagEntity)throws Exception{
		//bean
		TableEntity table = CreateEntityUtil.generateEntityRun(tablename, dbEntity, fileEntity);
		//code
		CreateCodeUtil.createCode(table, fileEntity,flagEntity);
		//page
		CreatePateUtil.createPage(table, fileEntity,flagEntity);
		String entityName = GoGoStringUtil.firstChar2Up(table.getEntityName());
		String urlPattern = GoGoStringUtil.firstChar2Little(table.getEntityName());
		String fullClassPath = fileEntity.getBasePackage()+ "." +Constans.TYPE_ACTION+"."+ entityName +"Action";
		//web.xml
		XmlUtil.createWebXml(fileEntity, entityName, fullClassPath, urlPattern,flagEntity);
	}
	
	public static void main(String[] args){
		/**
		 * String realPath = CodeGenerateTest.class.getResource("/").toString();
			realPath = realPath.substring(0, realPath.indexOf("/target/"))+"/";
			String projectPath = (realPath + "src/main/").replaceAll("file:/", "");
		 * */
		try {
			DbEntity dbEntity = new DbEntity("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/lisendb", "root", "root");
			String tablename = "admin";
			FileEntity fileEntity = new FileEntity("E:/testpage/","com.lisen.entity","hezhoujun",true);
			codeGenerateRun(tablename, dbEntity, fileEntity,new FlagEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
