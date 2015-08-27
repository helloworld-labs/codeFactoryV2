package com.gogotown.utils.code;

import java.io.IOException;
import java.util.Map;

import com.gogotown.ObjectMapUtil;
import com.gogotown.commons.Constans;
import com.gogotown.entity.CodeEntity;
import com.gogotown.entity.FileEntity;
import com.gogotown.entity.FlagEntity;
import com.gogotown.entity.TableEntity;
import com.gogotown.utils.StringUtil;
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
	public static void createCode(TableEntity table,FileEntity fileEntity,FlagEntity flagEntity){
		try {
			String entityName = table.getEntityName();
			if(null != fileEntity){
				//AdminAction
				String bigEntityName = StringUtil.firstChar2Up(entityName);
				//封装datamap实体类
				CodeEntity codeEntity = new CodeEntity(table, fileEntity.getBasePackage(),fileEntity.getAuthorName());
				Map<String, Object> datamap = ObjectMapUtil.obj2Map(codeEntity);
				String projectPath = fileEntity.getProjectPath();
				projectPath = projectPath + ((projectPath.endsWith("/") || projectPath.endsWith("\\")) ? "java" : "/java");
				if(flagEntity.isCreateDao()){
					//DaoImpl
					String document_dao = StringUtil.getFilePath(projectPath, fileEntity.getBasePackage(), Constans.TYPE_DAO+"/impl");
					FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_DAO,document_dao,bigEntityName+"DAOImpl.java",datamap,fileEntity);
				}
				if(flagEntity.isCreatePropertie()){
					//XxDao.properties
					String document_dao = StringUtil.getFilePath(projectPath, fileEntity.getBasePackage(), Constans.TYPE_DAO);
					FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_PROPERTIE,document_dao,bigEntityName+"Dao.properties",datamap,fileEntity);
				}
				if(flagEntity.isCreateService()){
					//ServiceImpl
					String document_service = StringUtil.getFilePath(projectPath, fileEntity.getBasePackage(), Constans.TYPE_SERVICE+"/impl");
					FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_SERVICE,document_service,bigEntityName+"ServiceImpl.java",datamap,fileEntity);
				}
				if(flagEntity.isCreateAction()){
					//Action
					String document_Action = StringUtil.getFilePath(projectPath, fileEntity.getBasePackage(), Constans.TYPE_ACTION);
					FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_ACTION,document_Action,bigEntityName+"Action.java",datamap,fileEntity);
				}
				if(flagEntity.isCreateIDao()){
					//idao
					String i_document_dao = StringUtil.getFilePath(projectPath, fileEntity.getBasePackage(), Constans.TYPE_DAO);
					FreemarkerUtil.analysisTemplate(Constans.TEMPATE_I_DAO,i_document_dao,"I"+bigEntityName+"Dao.java",datamap,fileEntity);
				}
				if(flagEntity.isCreateIservice()){
					//iservice
					String i_document_service = StringUtil.getFilePath(projectPath, fileEntity.getBasePackage(), Constans.TYPE_SERVICE);
					FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_I_SERVICE,i_document_service,"I"+bigEntityName+"Service.java",datamap,fileEntity);
				}
				if(flagEntity.isCreateMapperXml()){
					//mapper
					String document = StringUtil.getFilePath(projectPath, fileEntity.getBasePackage(), Constans.TYPE_MODEL);
					FreemarkerUtil.analysisTemplate(Constans.TEMPLATE_MAPPER,document,bigEntityName+"Mapper.xml",datamap,fileEntity);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
