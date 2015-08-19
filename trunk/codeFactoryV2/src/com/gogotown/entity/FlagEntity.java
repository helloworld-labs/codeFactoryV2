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
	private boolean isCreateDao = true;
	private boolean isCreateService = true;
	private boolean isCreateAction = true;
	private boolean isCreateWebXml = true;
	private boolean isCreatePage = true;
	
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
	
}
