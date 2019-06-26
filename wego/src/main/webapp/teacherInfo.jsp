<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		// 初始化信息
		$('#dg').datagrid({    
		    url:'tInfoController/initTInfo',
		   	pagination : true,
			fit : true,
			fitColumns : true,
		    toolbar:'#tb',
		    columns:[[
		    	{field:'tid',checkbox:true,width:300},        
		        {field:'tnumber',title:'工号',width:300},    
		        {field:'tname',title:'姓名',width:300},    
		        {field:'tpassword',title:'密码',width:300},    
		    ]]    
		}); 
		// 添加
		$("#add-teacher").click(function() {
			//弹出一个插入对话框
			$('#dialog-add').dialog({ 
				//打开对话框
			    closed: false,  
			    buttons:[{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						//保存按钮的动作写于此
						//提交表单
						$('#form-teacher').form('submit', {    
						    url:'tInfoController/add',    
						    onSubmit: function(){    
						        // 表单验证工作
						        return $('#form-teacher').form('validate');
						    },    
						    success:function(flag){
						        //判断
						        if(flag=='true'){
						        	$.messager.show({
										title:'消息提示',
										msg:'插入成功!',
										timeout:5000,
										showType:'slide'
									});
						        	//表单清空
						        	$('#form-teacher').form('clear');
						        	//关闭对话框
						        	$('#dialog-add').dialog({closed:true});
						        	//datagrid刷新
						        	$('#dg').datagrid('reload');
						        }else{
						        	//关闭对话框
						        	$('#dialog-add').dialog({closed:true});
						        	//弹出消息
						        	alert("插入失败!");
						        }
						    }    
						});  
					}
				}]

			}); 
		});
		
		//给删除按钮注册单击事件
		$('#del-teacher').click(function() {
			//获取所有选中的行
			var tcherArrs=$('#dg').datagrid('getSelections');
			//存储所有被选中的产品编号
			var tNumbArr=[];
			//判断选中的行
			//没有选中
			if (tcherArrs.length==0) {
				alert("请选中要修改的部门");
				return;
				//多选
			}else if(tcherArrs.length>0){
				//遍历dptArrs
				for (var i = 0; i < tcherArrs.length; i ++) {
					//将当前元素push到dptIdAdd里面
					tNumbArr.push(tcherArrs[i].tnumber);
				}
				//发送请求
				$.post('tInfoController/remove',{"tNumbArr[]":tNumbArr},function(flag){
					 //判断
			        if(flag=true){
			        	//弹出消息
			        	alert("删除成功!");
			        	//datagrid刷新
			        	$('#dg').datagrid('reload');

			        }else{
			        	//弹出消息
			        	alert("删除失败!");
			        }  
				});
			}
		});
		//给修改按钮注册一个单击事件
		$('#edit-teacher').click(function() {
			//获取所有选中的行
			var dptArrs=$('#dg').datagrid('getSelections');
			//判断选中的行
			//没有选中
			if (dptArrs.length==0) {
				alert("请选中要修改的部门");
				return;
				//多选
			}else if(dptArrs.length>1){
				alert("每次只能修改一个部门");
				//取消所有的选中行
				$('#dg').datagrid('unselectAll');
				return;
			}else{
				//发送请求,根据部门编号获取部门信息
				$('#edit-teacher-form').form('load',$('#dg').datagrid('getSelected'));
				//弹出修改对话框
				$('#edit-teacher-dialog').dialog({
					closed: false,  
					buttons:[{
						text:'保存',
						iconCls:'icon-save',
						handler:function(){
							//提交表单
							$('#edit-teacher-form').form('submit', {    
							    url:'tInfoController/edit',    
							    onSubmit: function(){    
							      //表单验证
							      return $('edit-teacher-form').form('validate');
							    },    
							    success:function(data){    
							    	if(flag=true){
							        	//弹出消息
							        	alert("修改成功!");
							        	//datagrid刷新
							        	$('#dg').datagrid('reload');
							        	$('#edit-teacher-dialog').dialog({closed:true});
							        }else{
							        	//弹出消息
							        	alert("修改失败!");
							        	$('#edit-teacher-form').form('clear');
							        }  
							    }    
							}); 
						}
					}]
				});
			}
		});
		
		//给查询按钮注册一个单击事件
		$('#srch-teacher').click(function() {
			$('#dg').datagrid('load', {    
				tname: $("#input-search").val()    
			});  
		});
	});
</script>
</head>
<body>
	<table id="dg"></table>  

	<div id="tb">
		<table>
			<tr>
				<td>
				<input class="easyui-textbox" id="input-search" data-options="iconCls:'icon-search'" style="width:150px"> 
				<a id="srch-teacher" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>  
				</td>
			</tr>
		</table>
		<a href="#" id="add-teacher" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加老师</a>
		<a href="#" id="edit-teacher" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改部门</a>
		<a href="#" id="del-teacher" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除部门</a>
	</div>
	
	<!-- 添加部门的对话框 -->
	<div id="dialog-add" class="easyui-dialog" title="添加部门" style="width:auto;height:auto;"   
        data-options="closed:true"> 
        <form id="form-teacher" method="post">   
	        <table>
	        	<tr>
	        		<td>
	        			教师工号：<input name="tnumber" class="easyui-validatebox" data-options="required:true" />
	        		</td>
	        	</tr>
	        	<tr>
	        		<td>
	        			教师姓名：<input name="tname" class="easyui-validatebox" data-options="required:true" />
	        		</td>
	        		
	        	</tr>
	        	<tr>
	        		<td>
	        			教师密码：<input name="tpassword" class="easyui-validatebox" data-options="required:true" />
	        		</td>
	        	</tr>
	        </table>  
        </form>
	</div> 
	<!-- 修改部门的对话框 -->
	<div id="edit-teacher-dialog" class="easyui-dialog" title="修改部门" style="width:auto;height:auto;"   
        data-options="closed:true"> 
        <form id="edit-teacher-form" method="post">   
        <table>
        	<tr>
        		<td>
        			工号：<input name="tnumber" type="text" readonly="readonly"/>
        		</td>
        	</tr>
        	<tr>
        		<td>
        			姓名：<input name="tname" type="text" />
        		</td>
        	</tr>
        	<tr>
        		<td>
        			密码：<input name="tpassword" type="text" />
        		</td>
        	</tr>
        </table>  
        </form>
	</div> 
</body>
</html>