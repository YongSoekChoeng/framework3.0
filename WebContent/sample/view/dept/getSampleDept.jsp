<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%                                                                                                              
/******************************************* 변수 선언 시작 *******************************************/        	  
String                                                         RETURN_CD;                                       
com.sample.dept.vo.SampleDeptVo                                      returnObj;                                       
/******************************************* 변수 선언 끝 *********************************************/           
                                                                                                                
/******************************************* 변수 정의 시작 *******************************************/           
RETURN_CD           = (String)request.getAttribute("RETURN_CD");                                             
returnObj           = (com.sample.dept.vo.SampleDeptVo)request.getAttribute("returnObj");                                   
/******************************************* 변수 정의 끝 *********************************************/        
%>                                                                                                              
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">      
<html>                                                                                                          
<head>                                                                                                          
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">                                         
<title>Insert title here</title>                                                                                
<script type="text/javascript">                                                                               
	function goForIt(){                                                                                          
		var param = document.MAIN_FORM.PARAM.value;                                                              
		location.href = "/dept/getSampleDept.do?" + param;                                            
	}                                                                                                            
</script>                                                                                                       
</head>                                                                                                         
<body>                                                                                                          
                                                                                                                
<!--폼 시작-->                                                                                                   
<form name="MAIN_FORM" method="post"  >                                                                     
	<input type='button' name='' value='GET' onclick='javascript:goForIt();' >                                 
	                                                                                                              
	<table border=1>                                                                                              
		<tr>                                                                                                      
			<td>파라메터(예:USER_ID=0002&GROUP_ID=1)</td>                                                                                       
		</tr>                                                                                                     
		<tr>                                                                                                      
			<td><input type='text' name='PARAM' value='' size=50 ></td>                                                    
		</tr>                                                                                                     
	</table>                                                                                                      
	<br>                                                                                                         
	<table border=1>                                                                                              
		<tr>                                                                                                      
			<td>DEPT_ID&nbsp;</td><td>DEPT_NAME&nbsp;</td><td>INPUT_DT&nbsp;</td>
		</tr>                                                                                                     
		<%                                                                                                        
		if(returnObj!=null){                                                                                   
		%>                                                                                                        
		<tr>                                                                                                      
			<td><%=returnObj.getDEPT_ID() %>&nbsp;</td><td><%=returnObj.getDEPT_NAME() %>&nbsp;</td><td><%=returnObj.getINPUT_DT() %>&nbsp;</td>
		</tr>	                                                                                                  
		<%                                                                                                        
		}                                                                                                         
		%>                                                                                                        
	</table>                                                                                                      
                                                                                                                
</form>                                                                                                         
<!--폼 끝-->                                                                                                    
                                                                                                                
</body>                                                                                                         
</html>