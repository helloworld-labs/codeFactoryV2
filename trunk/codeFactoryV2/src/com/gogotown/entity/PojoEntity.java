package com.gogotown.entity;

import com.gogotown.commons.Constans;
import com.gogotown.utils.DateUtil;


public class PojoEntity {
	String base_packge;
	String type_model;
	String tablename;
	String entityName;
	String table_description;
	String author;
	String current_now;
	String[] fieldNames;
	String[] remaks;
	String[] table_filelds;
	String[] filedTypes;
	String primary_colmun;
	
	public PojoEntity(String base_packge, String tablename,
			String entityName, String table_description, String author,
			String[] fieldNames, String[] remaks,
			String[] table_filelds, String[] filedTypes,String primary_colmun) {
		super();
		this.base_packge = base_packge;
		this.type_model = Constans.TYPE_MODEL;
		this.tablename = tablename;
		this.entityName = entityName;
		this.table_description = table_description;
		this.author = author;
		this.current_now = DateUtil.getCurrentTime();
		this.fieldNames = fieldNames;
		this.remaks = remaks;
		this.table_filelds = table_filelds;
		this.filedTypes = filedTypes;
		this.primary_colmun = primary_colmun;
	}
	public String getBase_packge() {
		return base_packge;
	}
	public void setBase_packge(String base_packge) {
		this.base_packge = base_packge;
	}
	public String getType_model() {
		return type_model;
	}
	public void setType_model(String type_model) {
		this.type_model = type_model;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getTable_description() {
		return table_description;
	}
	public void setTable_description(String table_description) {
		this.table_description = table_description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCurrent_now() {
		return current_now;
	}
	public void setCurrent_now(String current_now) {
		this.current_now = current_now;
	}
	public String[] getFieldNames() {
		return fieldNames;
	}
	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}
	public String[] getRemaks() {
		return remaks;
	}
	public void setRemaks(String[] remaks) {
		this.remaks = remaks;
	}
	public String[] getTable_filelds() {
		return table_filelds;
	}
	public void setTable_filelds(String[] table_filelds) {
		this.table_filelds = table_filelds;
	}
	public String[] getFiledTypes() {
		return filedTypes;
	}
	public void setFiledTypes(String[] filedTypes) {
		this.filedTypes = filedTypes;
	}
	public String getPrimary_colmun() {
		return primary_colmun;
	}
	public void setPrimary_colmun(String primary_colmun) {
		this.primary_colmun = primary_colmun;
	}
	
}
