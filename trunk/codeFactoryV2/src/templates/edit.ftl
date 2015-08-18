<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../commons/head.jsp">
<jsp:param value="Y" name="isSencond"/>
<jsp:param value="saveObjForm" name="formId"/>
</jsp:include>
<title>${table.table_description}编辑</title>
</head>
<body>
<div class="ibox float-e-margins">
<div class="ibox-title">
<div class="row">
<div class="col-md-10"><h3>${r"${"}${table.entityName} == null ?'新增':'修改'}${table.table_description}信息</h3></div>
<div class="col-md-2">
<a href="javascript:history.go(-1);" role="button" class="btn btn-success">&lt;&lt;返回</a>
</div>
</div>
</div>
<div class="ibox-content" style="display: block;">
<form data="editForm" class="form-horizontal" id="saveObjForm">
	<#--主键隐藏域-->
 <input type="hidden"  name="${table.primary_colmun?if_exists}" value="${r"${"}${table.entityName}.${table.primary_colmun?if_exists}}">
 <#list table.fieldNames as i>
 	<#--排除主键生成form字段-->
     <#if table.primary_colmun != table.fieldNames[i_index]>
 <div class="form-group">
     <label class="col-sm-2 control-label">${table.remaks[i_index]}</label>
     <div class="col-sm-10">
     <#if table.filedTypes[i_index] != "Date">
     <input type="text"  name="${table.fieldNames[i_index]}"  placeholder="请输入${table.fieldNames[i_index]}" value="${r"${"}${table.entityName}.${table.fieldNames[i_index]}}" class="form-control"/>
     </#if>
     <#if table.filedTypes[i_index] == "Date">
     <input type="text" class="Wdate" onClick="WdatePicker()"  name="${table.fieldNames[i_index]}"  placeholder="日期" value="<fmt:formatDate value="${r"${"}${table.entityName}.${table.fieldNames[i_index]}}" pattern="yyyy-MM-dd HH:mm:ss"/>" class="form-control"/>
     </#if>
     </div>
 </div>
     </#if>
 </#list>
<div class="form-group">
    <div class="col-sm-4 col-sm-offset-2">
     <button type="button" class="btn btn-success"  onclick="saveObj('${r"${"}${table.entityName} == null ?'save':'update'}')">保存</button>
    <button type="reset" class="btn btn-danger" >取消</button>
    </div>
</div>
 </form>
</div>
</div>
<!--main-container-part-->
</body>
</html>