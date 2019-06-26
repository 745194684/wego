<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int i = 0;
		int j = 0;
	 %>
	 <table border="1">
		<%
			for( i=0; i<10; i++){
				
				%><tr><%
				for( j=0; j<10; j++){
				%>
				<td>
				<%
					if(i==0&&j==0){
					
					}else if(i==0&&j!=0){
						out.print(j);
					}else if(i!=0&&j==0){
						out.print(i);
					}else{
					out.print( i + "*" + j + "=" + (i*j));
					
					}
				%>
					</td>
				<%
				}
				%> 
				</tr>
				<%
			}
		 %> 
	 </table>
</body>
</html>