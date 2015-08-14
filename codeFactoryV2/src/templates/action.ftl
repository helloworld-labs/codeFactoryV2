package ${base_packge}.${type_action};

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import ${base_packge}.commons.ResultData;
import ${base_packge}.constant.SysConstants;
import ${base_packge}.${type_model}.${entityDomain?cap_first};
import ${base_packge}.${type_service}.${entityDomain?cap_first}Service;
import ${base_packge}.util.ObjectMapUtil;
import ${base_packge}.util.ReflectionModelUtil;
import ${base_packge}.util.StringUtils;
import ${base_packge}.util.json.JsonUtil;
import ${base_packge}.util.log.util.CustomerLogUtil;

/**   
* @Title: ${entityDomain?cap_first}Action.java 
* @Package ${base_packge}.${type_action}
* @Description: ${table_description}
* @author ${author}
* @date ${current_now}
* @version V1.0   
* create by codeFactory
*/
public class ${entityDomain?cap_first}Action extends HttpServlet{
	Logger logger = Logger.getLogger(${entityDomain?cap_first}Action.class);
	
	 /**@Fields serialVersionUID : TODO*/ 
	private static final long serialVersionUID = 1L;
	String actionFilePath = "${entityDomain}";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.endsWith("list")){
			list(req,resp);
		}else if(uri.endsWith("edit")){
			edit(req, resp);
		}else if(uri.endsWith("delete")){
			delete(req, resp);
		}else if(uri.endsWith("save")){
			save(req, resp);
		}else{
			resp.sendError(400, "未找到对应页面");
		}
	}

	/** 
	* @author hezhoujun
	* @Title: list 
	* @Description: 查询列表
	* @param req
	* @param resp void
	*/
	void list(HttpServletRequest req,HttpServletResponse resp){
		try {
			${entityDomain?cap_first} ${entityDomain} = ReflectionModelUtil.getObjectModelRequest(${entityDomain?cap_first}.class, req);
			Map<String, Object> maps = ObjectMapUtil.obj2Map(${entityDomain});
			ResultData data = ${entityDomain?cap_first}Service.list(maps);
			req.setAttribute("resultData", data);
			//获取处理结果信息
			//save/update/delete
			req.setAttribute("operation", req.getParameter("operation"));
			//处理结果 1成功 0失败
			req.setAttribute("operation_result", req.getParameter("result"));
			req.getRequestDispatcher(SysConstants.PAGE_BASE_PATH+actionFilePath+"/list.jsp").forward(req, resp);
		} catch (Exception e) {
			CustomerLogUtil.hezhoujunLog(logger, "查询列表出错，error："+e.getMessage(), e.fillInStackTrace());
		}
	}
	
	/** 
	* @author hezhoujun
	* @Title: edit 
	* @Description: 编辑、新增页面
	* @param req
	* @param resp void
	*/
	void edit(HttpServletRequest req,HttpServletResponse resp){
		try {
			String id = req.getParameter("id");
			if(StringUtils.isNotBlank(id) && StringUtils.isNumber(id)){
				${entityDomain?cap_first} ${entityDomain} = ${entityDomain?cap_first}Service.getById(Long.parseLong(id));
				req.setAttribute("${entityDomain}", ${entityDomain});
			}
			req.getRequestDispatcher(SysConstants.PAGE_BASE_PATH+actionFilePath+"/edit.jsp").forward(req, resp);
		} catch (Exception e) {
			CustomerLogUtil.hezhoujunLog(logger, "到编辑页面出错，error："+e.getMessage(), e.fillInStackTrace());
		}
	}
	
	/** 
	* @author hezhoujun
	* @Title: save 
	* @Description: 保存
	* @param request
	* @param response void
	*/
	void save(HttpServletRequest req,HttpServletResponse resp){
		int code = 0;
		try {
			${entityDomain?cap_first} ${entityDomain} = ReflectionModelUtil.getObjectModelRequest(${entityDomain?cap_first}.class, req);
			<#if primary_colmun?exists>
			//修改
			if(null != ${entityDomain}.get${primary_colmun}() && ${entityDomain}.get${primary_colmun}() > 0){
				${entityDomain?cap_first}Service.update(${entityDomain});
			}else{
			//保存
				${entityDomain} = ${entityDomain?cap_first}Service.save(${entityDomain});
			}
			</#if>
			code = 1;
			String result = JsonUtil.returnJsonInfo(code, "");
			resp.getWriter().print(result);
		} catch (Exception e) {
			CustomerLogUtil.hezhoujunLog(logger, "保存出错，error："+e.getMessage(), e.fillInStackTrace());
		}
	}
	
	/** 
	* @author hezhoujun
	* @Title: delete 
	* @Description: 删除
	* @param request
	* @param response void
	*/
	void delete(HttpServletRequest req,HttpServletResponse resp){
		String id = req.getParameter("id");
		int code = 0;
		if(StringUtils.isNotBlank(id) && StringUtils.isNumber(id)){
			try {
				PrintWriter out = resp.getWriter();
				int n = ${entityDomain?cap_first}Service.delete(Long.parseLong(id));
				code = n > 0 ? 1 : 0;
				out.print(JsonUtil.returnJsonInfo(code, ""));
			}  catch (Exception e) {
				CustomerLogUtil.hezhoujunLog(logger, "删除出错，error："+e.getMessage(), e.fillInStackTrace());
			}
		}
	}
}