package com.gogotown.utils.code;

import java.io.IOException;
import java.util.Map;

import com.gogotown.ObjectMapUtil;
import com.gogotown.commons.Constans;
import com.gogotown.entity.CodeEntity;
import com.gogotown.entity.FileEntity;
import com.gogotown.utils.GoGoStringUtil;
import com.gogotown.utils.freemarker.FreemarkerUtil;

/**   
* @Title: CreateCodeUtil.java 
* @Package com.gogotown.utils.code 
* @Description: 通过模版创建dao、service、action代码
* @author hezhoujun
* @date 2015-8-14 上午11:02:45 
* @version V1.0   
*/
public class CreateCodeUtil {
	
	/** 
	* @author hezhoujun
	* @Title: createCode 
	* @Description: 生成service dao action实体类
	* @param tableName
	* @param tableDesc
	* @param fileEntity void
	*/
	public static void createCode(String tableName,String tableDesc,FileEntity fileEntity){
		try {
			if(null != fileEntity){
				//adminAction
				String littleEntityName = GoGoStringUtil.firstChar2Little(tableName);
				//AdminAction
				String bigEntityName = GoGoStringUtil.firstChar2Up(tableName);
				//封装datamap实体类
				CodeEntity codeEntity = new CodeEntity(tableDesc, fileEntity.getBasePackage(), littleEntityName,fileEntity.getAuthorName());
				Map<String, Object> datamap = ObjectMapUtil.obj2Map(codeEntity);
				//Dao
				String document_dao = GoGoStringUtil.getFilePath(fileEntity.getProjectPath(), fileEntity.getBasePackage(), Constans.TYPE_DAO);
				FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_DAO,document_dao,bigEntityName+"Dao.java",datamap,fileEntity.isIs_cover());
				//Service
				String document_service = GoGoStringUtil.getFilePath(fileEntity.getProjectPath(), fileEntity.getBasePackage(), Constans.TYPE_SERVICE);
				FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_SERVICE,document_service,bigEntityName+"Service.java",datamap,fileEntity.isIs_cover());
				//Action
				String document_Action = GoGoStringUtil.getFilePath(fileEntity.getProjectPath(), fileEntity.getBasePackage(), Constans.TYPE_ACTION);
				FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_ACTION,document_Action,bigEntityName+"Action.java",datamap,fileEntity.isIs_cover());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String tablename = "admin";
		String tableDesc = "管理员信息";
		FileEntity fileEntity = new FileEntity("E:/test/hz/abc/def", "com.manage", "hezhoujun", true);
		createCode(tablename,tableDesc,fileEntity);
	}
}
