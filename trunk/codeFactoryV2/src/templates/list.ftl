<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>${table.table_description}列表</title>
<jsp:include page="../commons/head.jsp"/>
</head>
<body>
<%@include file="../commons/tip_info.jsp" %>
<div class="wrapper wrapper-content animated fadeInRight">
<div class="row">
<div class="col-lg-12">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
          <a class="btn btn-primary btn-xs" href="edit" role="button">添加</a>
        </div>
        <div class="ibox-content" style="display: block;">
            <div role="grid" class="dataTables_wrapper form-inline" id="DataTables_Table_0_wrapper">
            <div class="row">
            <!-- 搜索表单区域 -->
            <form id="searchForm" class="form-inline" action="list" method="post">
            <!-- 分页条数切换 -->
            <%@include file="../commons/pageSizeChange.jsp" %>
            <!-- 搜索条件区域 -->
            <div class="col-sm-6"><div id="DataTables_Table_0_filter" class="dataTables_filter">
            <label>
            <!-- 方法名称:<input type="search" name="methodName" class="form-control input-sm" aria-controls="DataTables_Table_0" value="${r"$"}{resultData.mem.methodName}">-->
            <button type="submit" class="btn">搜索</button>
            </label>
            </div>
            </div>
            </form>
            </div>
            <!-- 数据表格 -->
            <table class="table table-striped table-bordered table-hover dataTables-example dataTable table-condensed" id="DataTables_Table_0">
                <thead>
                    <tr>
                    <#list table.fieldNames as i>
					<th>${table.remaks[i_index]}</th>
                    </#list>
                  <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${r"$"}{resultData.data}" var="obj" varStatus="i">
                  <tr>
                  <#list table.fieldNames as i>
	     		 <td>
	     		 <#if table.filedTypes[i_index] == "Date">
	     		 <fmt:formatDate value="${r"$"}{obj.${table.fieldNames[i_index]}}" pattern="yyyy-MM-dd HH:mm:ss"/>
	     		 </#if>
	     		 <#if table.filedTypes[i_index] != "Date">
	     		 ${r"$"}{obj.${table.fieldNames[i_index]}}
	     		 </#if>
	     		 </td>
                  </#list>
			      <td >
			      	<div class="btn-group" role="group" >				      		      		 
		          	    <a class="btn icon-minus-sign"  href="javascript:del('${r"$"}{obj.${table.primary_colmun} }');" role="button" >删除</a>		         	   
		          	    <a class="btn icon-edit" href="edit?id=${r"$"}{obj.${table.primary_colmun?if_exists}}&operation=edit" role="button">编辑</a>
          			</div>
			      </td>
                </tr>
                 </c:forEach>
                </tbody>
            </table>
           	 <div class="row">
           	 <!-- 分页信息展示 -->
            <%@include file="../commons/pageinfo.jsp" %>
            <div class="col-sm-6">
            <div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">
            <nav>
		  <ul class="pagination">
		  <!-- 分页 -->
		  <pg:pager url="list.do" maxPageItems="${r"$"}{resultData.pageSize }" items="${r"$"}{resultData.total}" export="currentPageNumber=pageNumber" scope="request" >
		  <pg:param name="pageSize" value="${r"$"}{resultData.mem.pageSize}" />
		  <jsp:include page="../commons/pager.jsp"/>
	    	</pg:pager>
		  </ul>
			</nav>
            </div>
            </div>
            </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>
</html>
