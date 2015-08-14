package com.gogotown.entity;

import java.util.List;

public class PageEntity {
	private List<String> remarks;
	private List<String> fieldNames;
	private String table_description;
	private String tableName;
	
	public PageEntity(List<String> remarks, List<String> fieldNames,String table_description,String tableName) {
		super();
		this.remarks = remarks;
		this.fieldNames = fieldNames;
		this.table_description = table_description;
		this.tableName = tableName;
	}
	public List<String> getRemarks() {
		return remarks;
	}
	public void setRemarks(List<String> remarks) {
		this.remarks = remarks;
	}
	public List<String> getFieldNames() {
		return fieldNames;
	}
	public void setFieldNames(List<String> fieldNames) {
		this.fieldNames = fieldNames;
	}
	public String getTable_description() {
		return table_description;
	}
	public void setTable_description(String table_description) {
		this.table_description = table_description;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
