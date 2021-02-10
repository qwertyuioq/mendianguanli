<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>门店管理</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<style type="text/css">
	body {
		font-family: "微软雅黑";
		background-color: #EDEDED;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		width: 96%;
		margin: 0 auto;
		text-align: center;
		border-collapse: collapse;
		font-size: 16px;
	}
	
	td, th {
		padding: 5px;
	}
	
	th {
		background-color: #DCDCDC;
		width: 120px;
	}
	
	th.width-40 {
		width: 40px;
	}
	
	th.width-70 {
		width: 70px;
	}
	
	th.width-80 {
		width: 80px;
	}
	
	hr {
		margin-bottom: 20px;
		border: 1px solid #aaa;
	}
	
	#add-door {
		text-align: center;
		font-size: 20px;
	}
	</style>
	<script type="text/javascript">
	/* 点击删除链接，执行函数 */
		function deleteById(id){
		/*confirm提醒框  */
		var b=window.confirm("你是否真的要删除该门店")
		if(b){
			//执行删除操作，访问“doorDelete?id=id”
			window.location.href="doorDelete?id="+id;
		}else{
			
		}
	}
	
	</script>
</head>
<body><!-- body-start  -->

<h2>门店管理</h2>
<div id="add-door">
	<a href="door_add" target="rightFrame">新增门店</a>
</div>
<hr/>
<table border="1">
	<tr>
		<th class="width-40">序号</th>
		<th>门店名称</th>
		<th class="width-80">联系电话</th>
		<th>门店地址</th>
		<th class="width-80">操 作</th>
	</tr>

	<!-- jstl遍历取出数据，el表达式取值 -->
	<c:forEach items="${ list }" var="door" varStatus="status">
		<tr>
			<td>${ status.count }</td>
			<td>${ door.name }</td>
			<td>${ door.tel }</td>
			<td>${ door.addr }</td>
			<td><!--javascript:void(0)阻止超链接跳转  -->
				<a href="javascript:void(0)" onclick="deleteById(${ door.id })">删除</a>
				&nbsp;|&nbsp;
				<a href="doorInfo?id=${ door.id }">修改</a>
			</td>
		</tr>
	</c:forEach>
	
	


	
</table>
</body><!-- body-end  -->
</html>



