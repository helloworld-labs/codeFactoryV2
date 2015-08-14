package com.gogotown.utils.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.gogotown.utils.GoGoStringUtil;
import com.gogotown.utils.database.GenEntityMysqlUtil;

public class SpringXmlUtil {
	
	/** 
	* @author hezhoujun
	* @Title: updateDaoServiceXml 
	* @Description: 对dao xml和service xml进行追加
	* @param className 类名
	* @param beanName id名
	* @param xmlPath xml路径
	* @param attrName property的属性的name
	* @param attrRef property的属性的ref
	* @param type 类型 dao or service
	* @return String 处理结果
	*/
	@SuppressWarnings("unchecked")
	public String updateDaoServiceXml(String className,String beanName,String xmlPath,String attrName,String attrRef,String type){
		String info = "";
		SAXReader reader = new SAXReader(); 
		   Document doc;
		try {
			doc = reader.read(xmlPath);
			Element rootElement = doc.getRootElement(); 
			Element addressElement = rootElement.addElement("bean");
			List<Element> nodes = rootElement.elements("bean");
			boolean createFlag = true;
			for (Element element : nodes) {
				if(beanName.equals(element.attributeValue("id"))){
					createFlag = false;
				}
			}
			if(createFlag){
				addressElement.addAttribute("id", beanName);
				addressElement.addAttribute("class", className);
				Element child = addressElement.addElement("property");
				child.addAttribute("name", attrName);
				child.addAttribute("ref", attrRef);
//				OutputFormat format = new OutputFormat();
				OutputFormat format = OutputFormat.createPrettyPrint();// 创建文件输出的时候，自动缩进的格式
				format.setEncoding("UTF-8");
				XMLWriter writer = new XMLWriter(new FileWriter(xmlPath), format);
				writer.write(doc);
				writer.close();
				info = "success:处理dao & service xml成功";
			}else{
				info = "success:对应的bean的id已经存在";
			}
		} catch (DocumentException e) {
			info = "failed:出现异常："+e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			info = "failed:出现异常："+e.getMessage();
			e.printStackTrace();
		} 
		return info;
	}
	
	/** 
	* @author hezhoujun
	* @Title: updateXmlRun 
	* @Description: 对dao xml和service xml进行追加 方法入口
	* @param className 类名
	* @param beanName id名
	* @param xmlPath xml路径
	* @param attrName property的属性的name   type为dao事可为null
	* @param attrRef property的属性的ref   type为dao事可为null
	* @param type 类型 dao or service
	* @return String 处理结果
	*/
	public static String updateXmlRun(String className,String beanName,String xmlPath,String attrName,String attrRef,String type){
		String info = "";
		if("dao".equals(type)){
			attrName = attrRef = "sqlSessionFactory";
		}
		if(GoGoStringUtil.isNotBlank(className) && GoGoStringUtil.isNotBlank(beanName) && GoGoStringUtil.isNotBlank(xmlPath) && GoGoStringUtil.isNotBlank(attrName) && GoGoStringUtil.isNotBlank(attrRef) && GoGoStringUtil.isNotBlank(type)){
			info = new SpringXmlUtil().updateDaoServiceXml(className, beanName, xmlPath, attrName, attrRef, type);
		}else{
			info = "failed:参数传输不完整";
		}
		return info;
	}
	
	/**
	 * 修改sql mapper文件
	 * @param className
	 * @param xmlPath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String updateSqlMapXml(String classFullPath,String xmlPath){
		String info = "";
		String className = classFullPath.substring(classFullPath.lastIndexOf(".")+1, classFullPath.length());
		String alias = GenEntityMysqlUtil.first2little(className);
		SAXReader reader = new SAXReader(); 
		   Document doc;
		try {
			doc = reader.read(xmlPath);
			Element rootElement = doc.getRootElement(); 
			Element typeElement = rootElement.element("typeAliases");
			List<Element> nodes = typeElement.elements("typeAlias");
			boolean createFlag = true;
			for (Element element : nodes) {
				System.out.println(alias+"  "+element.attributeValue("alias"));
				if(alias.equals(element.attributeValue("alias"))){
					System.out.println("this.....");
					createFlag = false;
				}
			}
			if(createFlag){
				Element typeChild = typeElement.addElement("typeAlias");
				typeChild.addAttribute("type", classFullPath);
				typeChild.addAttribute("alias", alias);
				Element mappersElement = rootElement.element("mappers");
				Element mapperChild = mappersElement.addElement("mapper");
				mapperChild.addAttribute("resource", "resource/mapper/"+className+"Mapper.xml");
//				OutputFormat format = new OutputFormat();
				OutputFormat format = OutputFormat.createPrettyPrint();// 创建文件输出的时候，自动缩进的格式
				format.setEncoding("UTF-8");
				XMLWriter writer = new XMLWriter(new FileWriter(xmlPath), format);
				writer.write(doc);
				writer.close();
				info = "success:处理sqlmap xml成功";
			}else{
				info = "success:对应的alias的值已经存在";
			}
		}catch (Exception e) {
			info = "failed:出现异常："+e.getMessage();
			e.printStackTrace();
		} 
		return info;
	}
	
	public static void main(String[] args) {
//		String className = "com.lisen.entity.Hezhoujun";
//		String beanName = "testBean02";
//		String xmlPath = "H:/Projects/tlts/LiSenPro/WebContent/WEB-INF/sqlmap-config.xml";
//		String attrName = "x22";
//		String attrRef = "x33";
//		String info = updateSqlMapXml(className, xmlPath);
	}
}
