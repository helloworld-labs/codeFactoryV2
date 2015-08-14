package ${base_packge}.${type_service};

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import ${base_packge}.commons.ResultData;
import ${base_packge}.${type_dao}.${entityDomain?cap_first}Dao;
import ${base_packge}.${type_model}.${entityDomain?cap_first};
import ${base_packge}.util.log.util.CustomerLogUtil;

 /**   
* @Title: ${entityDomain?cap_first}Service.java 
* @Package ${base_packge}.${type_service}
* @Description: ${table_description}
* @author ${author}
* @date ${current_now}
* @version V1.0   
* create by codeFactory
*/
public class ${entityDomain?cap_first}Service {
	private static Logger logger = Logger.getLogger(${entityDomain?cap_first}Service.class);
	/** 
	* @author hezhoujun
	* @Title: save 
	* @Description: 保存
	* @param t
	* @return
	* @throws Exception ${entityDomain?cap_first}
	*/
	public static ${entityDomain?cap_first} save(${entityDomain?cap_first} t) throws Exception{
		${entityDomain?cap_first} a = null;
		try {
			a = ${entityDomain?cap_first}Dao.save(t);
		} catch (Exception e) {
			CustomerLogUtil.hezhoujunLog(logger, "保存出错，error："+e.getMessage(), e.fillInStackTrace());
			throw e;
		}
		return a;
	}
	
	/** 
	* @author hezhoujun
	* @Title: list 
	* @Description: 分页查询
	* @param maps
	* @return
	* @throws Exception ResultData
	*/
	public static ResultData list(Map<String, Object> maps) throws Exception{
		ResultData data = new ResultData();
		try {
			int count = ${entityDomain?cap_first}Dao.qryListObjectCount(Api.class, maps);
			int currentpage = (int) maps.get("current");
			int pagesize =(int) maps.get("pageSize");
			int pages = count%pagesize == 0 ? count / pagesize : count/pagesize +1;
			maps.put("pages", pages);
			 List<${entityDomain?cap_first}> list= ${entityDomain?cap_first}Dao.qryListObject(${entityDomain?cap_first}.class, maps, currentpage, pagesize);
			data.setPageSize(pagesize);
			data.setTotal(count);
			data.setData(list);
			data.setMem(maps);
			data.setParam(maps);
		} catch (Exception e) {
			CustomerLogUtil.hezhoujunLog(logger, "分页查询出错，error："+e.getMessage(), e.fillInStackTrace());
			throw e;
		}
		return data;
	}
	
	/** 
	* @author hezhoujun
	* @Title: getList 
	* @Description: 获取列表
	* @param maps
	* @return
	* @throws Exception List<${entityDomain?cap_first}>
	*/
	public static List<${entityDomain?cap_first}> getList(Map<String, Object> maps) throws Exception{
		List<${entityDomain?cap_first}> list = null;
		try {
			list = ${entityDomain?cap_first}Dao.qryList(${entityDomain?cap_first}.class, maps);
		} catch (Exception e) {
			CustomerLogUtil.hezhoujunLog(logger, "查询列表出错，error："+e.getMessage(), e.fillInStackTrace());
			throw e;
		}
		return list;
	}
	
	/** 
	* @author hezhoujun
	* @Title: getById 
	* @Description: 根据id查询
	* @param id
	* @return
	* @throws Exception ${entityDomain?cap_first}
	*/
	public static ${entityDomain?cap_first} getById(Long id) throws Exception{
		${entityDomain?cap_first} t = null;
		try {
			t = ${entityDomain?cap_first}Dao.getById(${entityDomain?cap_first}.class, id);
		} catch (Exception e) {
			CustomerLogUtil.hezhoujunLog(logger, "根据id查询出错，error："+e.getMessage(), e.fillInStackTrace());
			throw e;
		}
		return t;
	}
	
	/** 
	* @author hezhoujun
	* @Title: delete 
	* @Description: 根据id删除
	* @param id
	* @return
	* @throws Exception int
	*/
	public static int delete(Long id) throws Exception{
		return ${entityDomain?cap_first}Dao.delete(${entityDomain?cap_first}.class, id);
	}
	
	/** 
	* @author hezhoujun
	* @Title: update 
	* @Description: 修改
	* @param t
	* @throws Exception void
	*/
	public static void update(${entityDomain?cap_first} t) throws Exception{
		${entityDomain?cap_first}Dao.update(t);
	}