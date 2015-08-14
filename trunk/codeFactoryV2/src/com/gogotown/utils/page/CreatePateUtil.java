package com.gogotown.utils.page;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import com.gogotown.ObjectMapUtil;
import com.gogotown.commons.Constans;
import com.gogotown.entity.DbEntity;
import com.gogotown.entity.FileEntity;
import com.gogotown.entity.PageEntity;
import com.gogotown.entity.TableEntity;
import com.gogotown.utils.GoGoStringUtil;
import com.gogotown.utils.database.GenEntityMysqlUtil;
import com.gogotown.utils.freemarker.FreemarkerUtil;

public class CreatePateUtil {
	
	/** 
	* @author hezhoujun
	* @Title: createPage 
	* @Description: 通过模版生成jsp页面
	* @param templateName
	* @param distinctPath
	* @param distinctName
	* @param datamap
	* @throws IOException void
	*/
	@SuppressWarnings("static-access")
	public static void createPage(TableEntity table,FileEntity fileEntity) throws IOException{
		String tablename = GoGoStringUtil.firstChar2Little(table.getTablename());
		PageEntity pageEntity = new PageEntity(Arrays.asList(table.getRemaks()),Arrays.asList(table.getFieldNames()),table.getTable_description(),tablename);
		Map<String, Object> datamap = ObjectMapUtil.obj2Map(pageEntity);
		String folder_name = GoGoStringUtil.firstChar2Little(table.getTablename());
		//edit.jsp
		String document_edit = GoGoStringUtil.getFilePath(fileEntity.getProjectPath(), Constans.WEB_JSP_PATH,folder_name);
		datamap.put("primary_colmun", table.getPrimary_colmun());
		FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_EDIT,document_edit,"edit.jsp",datamap,fileEntity.isIs_cover());
		//list.jsp
		String document_list = GoGoStringUtil.getFilePath(fileEntity.getProjectPath(), Constans.WEB_JSP_PATH,folder_name);
		FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_EDIT,document_list,"list.jsp",datamap,fileEntity.isIs_cover());
	}
	
	public static void main(String[] args) {
		try {
			DbEntity dbConstans = new DbEntity("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.155:3306/lisendb", "root", "root");
			String tableName = "admin";
			FileEntity fileEntity = new FileEntity("E:/test/hz/abc/def", "com.manage", "hezhoujun", false);
			TableEntity table = GenEntityMysqlUtil.generateEntityRun(tableName,dbConstans,fileEntity);
			createPage(table,fileEntity);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
