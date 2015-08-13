package com.gogotown.entity;

public class TableEntity {
		 /** 
		* @Fields tablename : 表名
		*/ 
		private String tablename = null;
		 /** 
		* @Fields table_description :表描述
		*/ 
		private String table_description = null;
		 /** 
		* @Fields colnames :列名类型数组
		*/ 
		private static String[] colnames; 
		 /** 
		* @Fields colTypes : 列名类型数组
		*/ 
		private static String[] colTypes; 
		 /** 
		* @Fields filedTypes : 对应实体类的类型
		*/ 
		private static String[] filedTypes;
		 /** 
		* @Fields remaks :列注释
		*/ 
		private String[] remaks;
		 /** 
		* @Fields colSizes : 列名大小数组
		*/ 
		private int[] colSizes; 
		 /**@Fields primary_colmun : 主键*/ 
		private String primary_colmun;
		 /** 
		* @Fields f_util : 是否需要导入包java.util.*
		*/ 
		private boolean f_util = false; 
		 /** 
		* @Fields f_sql : 是否需要导入包java.sql.*
		*/ 
		private boolean f_sql = false; 
		private boolean f_math = false;
		 /** 
		* @Fields fieldNames : 实体类字段数组
		*/ 
		private static String[] fieldNames;
		public String getTablename() {
			return tablename;
		}
		public void setTablename(String tablename) {
			this.tablename = tablename;
		}
		public String getTable_description() {
			return table_description;
		}
		public void setTable_description(String table_description) {
			this.table_description = table_description;
		}
		public static String[] getColnames() {
			return colnames;
		}
		public static void setColnames(String[] colnames) {
			TableEntity.colnames = colnames;
		}
		public static String[] getColTypes() {
			return colTypes;
		}
		public static void setColTypes(String[] colTypes) {
			TableEntity.colTypes = colTypes;
		}
		public static String[] getFiledTypes() {
			return filedTypes;
		}
		public static void setFiledTypes(String[] filedTypes) {
			TableEntity.filedTypes = filedTypes;
		}
		public String[] getRemaks() {
			return remaks;
		}
		public void setRemaks(String[] remaks) {
			this.remaks = remaks;
		}
		public int[] getColSizes() {
			return colSizes;
		}
		public void setColSizes(int[] colSizes) {
			this.colSizes = colSizes;
		}
		public boolean isF_util() {
			return f_util;
		}
		public void setF_util(boolean f_util) {
			this.f_util = f_util;
		}
		public boolean isF_sql() {
			return f_sql;
		}
		public void setF_sql(boolean f_sql) {
			this.f_sql = f_sql;
		}
		public boolean isF_math() {
			return f_math;
		}
		public void setF_math(boolean f_math) {
			this.f_math = f_math;
		}
		public static String[] getFieldNames() {
			return fieldNames;
		}
		public static void setFieldNames(String[] fieldNames) {
			TableEntity.fieldNames = fieldNames;
		}
		public String getPrimary_colmun() {
			return primary_colmun;
		}
		public void setPrimary_colmun(String primary_colmun) {
			this.primary_colmun = primary_colmun;
		}
		
}
