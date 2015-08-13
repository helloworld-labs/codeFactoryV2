package com.gogotown.utils.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {
	
	/** 
	* @author hezhoujun
	* @Title: analysisTemplate 
	* @Description: freemarker加载模版生成文件
	* @param templateName 模版文件名称(action.ftl)
	* @param distinctPath 目标目录
	* @param distinctName 目标文件名称
	* @param datamap 需要编译的数据 (name : zhangsan)
	 * @throws IOException 
	*/
	public static void analysisTemplate(String templateName,String distinctPath,String distinctName,Map<?,?> datamap) throws IOException{
		BufferedWriter bw = null;
		StringWriter sw = null;
		//生成文件保存的位置(完整路径:example:e:/xx/xx/xxActino.java)
		File distinctFile = getDistinctFile(distinctPath, distinctName);
		try {
			Configuration config=new Configuration();
			File file=new File("src/templates");
			//设置要解析的模板所在的目录，并加载模板文件
			config.setDirectoryForTemplateLoading(file);
			//设置包装器，并将对象包装为数据模型
			config.setObjectWrapper(new DefaultObjectWrapper());
			
			//获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致
			Template template=config.getTemplate(templateName,"utf-8");
			
			//合并数据模型与模板
			//StringWriter stringWriter = new StringWriter(); 
			//输出到控制台
			//Writer out = new OutputStreamWriter(System.out);  
			//返回字符串
		  sw = new StringWriter();
		  template.process(datamap, sw);
		  bw = new BufferedWriter(new FileWriter(distinctFile));
		  bw.write(sw.toString());
		  sw.flush();
		  bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (TemplateException e) {
			e.printStackTrace();
		}finally{
			if(bw != null){
				bw.close();
			}
			if(sw != null){
				sw.close();
			}
		}
		System.out.println("创建文件:"+distinctFile.getPath()+" 成功！");
	}
	
	/**
	 * 根据文件路径+名称，自动生成文件夹及其文件
	 * @param distinctPath
	 * @param distinctName
	 * @return
	 * @throws IOException
	 */
	private static File getDistinctFile(String distinctPath,String distinctName) throws IOException{
		File document = new File(distinctPath);
		if(!document.exists()) document.mkdirs();
		if(!distinctPath.endsWith("/") || !distinctPath.endsWith("\\")){
			distinctPath += "/";
		}
		String fullPathFile = distinctPath+distinctName;
		File file = new File(fullPathFile);
		if(!file.exists()) file.createNewFile();
		return file;
	}
	
	public static void main(String[] args) {
		try {
			Map<String, Object> datamap = new HashMap<String, Object>();
			datamap.put("action_package", "xx.xx.xx");
			datamap.put("entity_package", "xa.aa.aa");
			datamap.put("entityDomain", "testAction");
			analysisTemplate("action.ftl","e:/test/hzj/abc/def","pageAction.java",datamap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
