package com.gogotown.entity;

/**   
* @Title: FlagEntity.java 
* @Package com.gogotown.entity 
* @Description: 控制是否生成对应文件，默认为true，都生成
* @author hezhoujun
* @date 2015-8-19 下午3:06:32 
* @version V1.0   
*/
public class FlagEntity {
	 /**@Fields isCreateDao : 是否生成dao*/ 
	private boolean isCreateDao = true;
	 /**@Fields isCreateService : 是否生成service*/ 
	private boolean isCreateService = true;
	 /**@Fields isCreateAction : 是否创建action*/ 
	private boolean isCreateAction = true;
	 /**@Fields isCreateWebXml : 是否创建web.xml*/ 
	private boolean isCreateWebXml = true;
	 /**@Fields isCreatePage : 是否创建jsp页面*/ 
	private boolean isCreatePage = true;
	 /**@Fields isCreatePropertie : 是否生成xxDao.properties 默认不生成*/ 
	private boolean isCreatePropertie = false;
	
	public boolean isCreateDao() {
		return isCreateDao;
	}
	public void setCreateDao(boolean isCreateDao) {
		this.isCreateDao = isCreateDao;
	}
	public boolean isCreateService() {
		return isCreateService;
	}
	public void setCreateService(boolean isCreateService) {
		this.isCreateService = isCreateService;
	}
	public boolean isCreateAction() {
		return isCreateAction;
	}
	public void setCreateAction(boolean isCreateAction) {
		this.isCreateAction = isCreateAction;
	}
	public boolean isCreateWebXml() {
		return isCreateWebXml;
	}
	public void setCreateWebXml(boolean isCreateWebXml) {
		this.isCreateWebXml = isCreateWebXml;
	}
	public boolean isCreatePage() {
		return isCreatePage;
	}
	public void setCreatePage(boolean isCreatePage) {
		this.isCreatePage = isCreatePage;
	}
	public boolean isCreatePropertie() {
		return isCreatePropertie;
	}
	public void setCreatePropertie(boolean isCreatePropertie) {
		this.isCreatePropertie = isCreatePropertie;
	}
	
}
