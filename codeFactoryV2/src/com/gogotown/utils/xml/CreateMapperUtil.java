package com.gogotown.utils.xml;
import java.util.ArrayList;
import java.util.List;

import com.gogotown.utils.GoGoStringUtil;

/**   
* @Title: CreateMapperUtil.java 
* @Package com.gogotown.utils 
* @Description: 生成mybaits mapper文件
* @author hezhoujun
* @date 2014-12-21 下午4:07:13 
* @version V1.0   
*/
public class CreateMapperUtil{
	
	/** 
	* @Fields colnames :列名类型数组
	*/ 
	private String[] colnames; 
	 /** 
	* @Fields colTypes : 列名类型数组
	*/ 
	private String[] colTypes; 
	 /** 
	* @Fields fieldNames : 实体类字段数组
	*/ 
	private String[] fieldNames;
	 /** 
	* @Fields indexs : 以上几个数组的索引
	*/ 
	private List<Integer> indexs = new ArrayList<Integer>();
	
	 /** 
	* @Fields tableName : 表名
	*/ 
	private String tableName;
	// 12.开关：默认情况下已经存在的文件不需要生成代码 true:覆盖所有代码
	// flag=true覆盖所有代码，不能恢复
	private boolean flag = true;
	// 生成mapper文件的实体类
	private String domain = "";
	// 3.有那些模板需要生成
	private String[] templates = {"Mapper.xml"};
	// 4.模板文件对应的生成文件路径
	private static String[] files = {};
	private static boolean fileNotExists = false;
	//实体类包路径
	private String entity_package;
	//表主键
	private String primary_column_tab;

	

	public CreateMapperUtil(String[] colnames, String[] colTypes,String[] fieldNames, String domain,String tableName,boolean flag,String entity_package,String primary_column_tab) {
		this.colnames = colnames;
		this.colTypes = colTypes;
		this.fieldNames = fieldNames;
		this.domain = domain;
		this.flag = flag;
		this.tableName = tableName;
		this.entity_package = entity_package;
		this.primary_column_tab = primary_column_tab;
		if(colnames.length > 0){
			for (int i = 0; i < colnames.length; i++) {
				indexs.add(i);
			}
		}
	}

	/*public void create() throws Exception {
		VelocityContext context = new VelocityContext();
		context.put("entityDomain", domain);
		//处理domain首字母小写
		String lowerEntityDomain =domain.substring(0, 1).toLowerCase()+ domain.substring(1);
		context.put("lowerEntityDomain", lowerEntityDomain);
		context.put("colTypes", colTypes);
		context.put("colnames", colnames);
		context.put("fieldNames", fieldNames);
		context.put("indexs", indexs);
		context.put("tableName", tableName);
		context.put("entity_package", entity_package);
		primary_column_tab = primary_column_tab == null ? "id": primary_column_tab;
		context.put("primary_column_tab",primary_column_tab);
		//实例化文件存放的路径:先打印文件的绝对路径
		File file = new File(files[0] + domain + templates[0]);
		//判断父目录是否存在
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		// 默认情况下已经存在的文件不需要生成代码
		if (flag || !file.exists()) {
			fileNotExists = true;
			System.out.println(file.getAbsolutePath());
			Properties p = new Properties();
			p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");  
		    p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");  
		    //这里加载类路径里的模板而不是文件系统路径里的模板  
		    p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"); 
		    //properties.put(Velocity.FILE_RESOURCE_LOADER_PATH, CreateCodeUtil.class.getResource("/").getPath());
			Velocity.init(p);
			Template template = Velocity.getTemplate( templates[0], "UTF-8");
			FileWriter writer = new FileWriter(file);
			// 11.必须关闭流，写入内容
			template.merge(context, writer);
			writer.close();
		}
	}*/
	
	/** 
	* @author hezhoujun
	* @Title: createMapperMain 
	* @Description: 根据表字段、实体类字段、实体类类名、表名字段类型、生成mybatis mapper文件方法入口
	* @param colnames 表字段
	* @param colTypes 表名字段类型
	* @param fieldNames 实体类字段
	* @param domain 实体类类名
	* @param tableName    表名 
	* @param mapperPath    代码生成到的位置 com的上一层 例如：E:/devloper_workspace/platformCommon/src/main/java/
	* @param packge   service dao的上层包路径 例如：com/gogotown/
	* @param isRecover 是否覆盖已经生成的代码 true 覆盖   false 不覆盖
	* @return String   返回处理结果
	*/
	public static String createMapperMain(String[] colnames, String[] colTypes,String[] fieldNames,String domain,String tableName,String mapperPath,boolean isRecover,String entity_package,String primary_column_tab){
		files = new String[]{ mapperPath};
		CreateMapperUtil codeUtil = new CreateMapperUtil(colnames, colTypes, fieldNames, domain,tableName,isRecover,entity_package,primary_column_tab);
		if(arrIsNotBlank(colnames) && arrIsNotBlank(colTypes) && arrIsNotBlank(fieldNames) && GoGoStringUtil.isNotBlank(domain) && GoGoStringUtil.isNotBlank(tableName) && GoGoStringUtil.isNotBlank(mapperPath)){
			try {
//				codeUtil.create();
				return fileNotExists ? "success:生成mapper文件成功."  :  "success:生成mapper文件 文件已经存在";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			return "failed:生成mapper文件,参数传输有误";
		}
		return null;
	}
	
	/** 
	* @author hezhoujun
	* @Title: arrIsNotBlank 
	* @Description: 判断数组是否为空
	* @param  arr
	* @param   设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	private static boolean arrIsNotBlank(String[] arr){
		if(null != arr && arr.length > 0){
			return true;
		}else{
			return false;
		}
	}
}