<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function addTabs(url,title) {
		//生成一个选项卡
		if(!$('#tt').tabs('exists',title)){
			$('#tt').tabs('add',{
				title: title,
				selected: true,
				closable:true,
				content: "<iframe src ="+url+" width=100% height=100%>"
			});
		}else {
			//获取选中的选项卡
			var tab=$('#tt').tabs('getTab',title);
			//选中标题为"title"的选项卡
			$('#tt').tabs('select',title);
			//将选中的选项卡刷新
			$('#tt').tabs('update', {
				tab: tab,
				options: {
					title: title,
					content: "<iframe src ="+url+" width=100% height=100%>"
				}
			}); 
		}		
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'计步管理',split:true"style="height: 100px;"></div>
	
	<div data-options="region:'west',title:'导航菜单',split:true"	style="width: 150px; height: 600px;" >
		<div class="easyui-accordion" style="width:300px;height:200px;">   
		    <div title="老师信息管理" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
		    	<a id="btn" href="JavaScript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="addTabs('teacherInfo.jsp','老师信息')">老师信息</a> 
		    	<br/><br/>
		    	<a id="btn" href="JavaScript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="addTabs('user_list.jsp','用户一览')">用户一览</a>
		    	<br/><br/>
		    	<a id="btn" href="JavaScript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="addTabs('user_list.jsp','用户一览')">用户一览</a>                  
		    </div> 
		</div>
	</div>

	<div data-options="region:'center',title:'center title'" style="padding: 5px; background: #eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true"></div>  
	</div>
	</body> 
</html>