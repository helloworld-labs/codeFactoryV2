package com.gogotown.entity;

public class FileEntity {
	/** 
	* @Fields projectPath :代码生成到的位置 com的上一层
	*/ 
	private String projectPath = null;
	 /** 
	* @Fields packageOutPath : 指定实体生成所在包的路径 
	*/ 
	private String packagePath = null;
	 /** 
	* @Fields authorName : 作者名字
	*/ 
	private String authorName = null;
	
	 /** 
	* @Fields flag : 是否覆盖已经生成的代码
	*/ 
	private boolean is_cover = false;

	public FileEntity(String projectPath, String packagePath,
			String authorName, boolean is_cover) {
		super();
		this.projectPath = projectPath;
		this.packagePath = packagePath;
		this.authorName = authorName;
		this.is_cover = is_cover;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public boolean isIs_cover() {
		return is_cover;
	}

	public void setIs_cover(boolean is_cover) {
		this.is_cover = is_cover;
	}
}
