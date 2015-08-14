<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../commons/head.jsp">
<jsp:param value="Y" name="isSencond"/>
<jsp:param value="saveObjForm" name="formId"/>
</jsp:include>
<title>${table_description}编辑</title>
</head>
<body>
<div class="ibox float-e-margins">
<div class="ibox-title">
<div class="row">
<div class="col-md-10"><h3>${r"${"}${tableName} == null ?'新增':'修改'}${table_description}信息</h3></div>
<div class="col-md-2">
<a href="javascript:history.go(-1);" role="button" class="btn btn-success">&lt;&lt;返回</a>
</div>
</div>
</div>
<div class="ibox-content" style="display: block;">
<form data="editForm" class="form-horizontal" id="saveObjForm">
 <input type="hidden"  name="${primary_colmun?if_exists}" value="${r"${"}${tableName}.${primary_colmun?if_exists}}">
 <#list fieldNames as i>
 <div class="form-group">
     <label class="col-sm-2 control-label">${remarks[i_index]}</label>
     <div class="col-sm-10">
     <input type="text"  name="${fieldNames[i_index]}"  placeholder="请输入${fieldNames[i_index]}" value="${r"${"}${tableName}.${fieldNames[i_index]}}" class="form-control"/>
     </div>
 </div>
 </#list>
<div class="form-group">
    <div class="col-sm-4 col-sm-offset-2">
     <button type="button" class="btn btn-success"  onclick="saveObj('${r"${"}${tableName} == null ?'save':'update'}')">保存</button>
    <button type="reset" class="btn btn-danger" >取消</button>
    </div>
</div>
 </form>
</div>
</div>
<!--main-container-part-->
</body>
</html>