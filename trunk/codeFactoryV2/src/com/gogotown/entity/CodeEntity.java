package com.gogotown.entity;

import com.gogotown.commons.Constans;
import com.gogotown.utils.DateUtil;

public class CodeEntity {
	 /**@Fields table_description : 表描述*/ 
	private String table_description;
	 /**@Fields base_packge : 项目包根路径*/ 
	private String base_packge;
	 /**@Fields entityDomain : 实体类类名(首字母小写)*/ 
	private String entityDomain;
	 /**@Fields current_now : 当前时间*/ 
	private String current_now;
	 /**@Fields author : 作者*/ 
	private String author;
	 /**@Fields model_type : action、dao、service的名称*/ 
	private String type_action;
	private String type_service;
	private String type_model;
	private String type_dao;
	
	public CodeEntity(String table_description, String base_packge,
			String entityDomain,String author) {
		super();
		this.table_description = table_description;
		this.base_packge = base_packge;
		this.entityDomain = entityDomain;
		this.current_now = DateUtil.getCurrentTime();
		this.author = author;
		this.type_action = Constans.TYPE_ACTION;
		this.type_dao = Constans.TYPE_DAO;
		this.type_model = Constans.TYPE_MODEL;
		this.type_service = Constans.TYPE_SERVICE;
	}
	
	public String getTable_description() {
		return table_description;
	}
	public void setTable_description(String table_description) {
		this.table_description = table_description;
	}
	public String getBase_packge() {
		return base_packge;
	}
	public void setBase_packge(String base_packge) {
		this.base_packge = base_packge;
	}
	public String getEntityDomain() {
		return entityDomain;
	}
	public void setEntityDomain(String entityDomain) {
		this.entityDomain = entityDomain;
	}
	public String getCurrent_now() {
		return current_now;
	}
	public void setCurrent_now(String current_now) {
		this.current_now = current_now;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType_action() {
		return type_action;
	}

	public void setType_action(String type_action) {
		this.type_action = type_action;
	}

	public String getType_service() {
		return type_service;
	}

	public void setType_service(String type_service) {
		this.type_service = type_service;
	}

	public String getType_model() {
		return type_model;
	}

	public void setType_model(String type_model) {
		this.type_model = type_model;
	}

	public String getType_dao() {
		return type_dao;
	}

	public void setType_dao(String type_dao) {
		this.type_dao = type_dao;
	}
	
}
