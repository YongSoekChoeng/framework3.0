<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%                                                                                                              
/******************************************* 변수 선언 시작 *******************************************/        	  
String                                                         RETURN_CD;                                       
java.util.HashMap                                              returnObj;                                       
java.util.List<com.sample.member.vo.SampleGroupVo>                  returnVoList;                       
com.sample.member.vo.SampleGroupVo                                  sampleGroupVo;                
com.common.utils.PageUtil                                      pageUtil;                                        
/******************************************* 변수 선언 끝 *********************************************/           
                                                                                                                
/******************************************* 변수 정의 시작 *******************************************/           
RETURN_CD           = (String)request.getAttribute("RETURN_CD");                                             
returnObj           = (java.util.HashMap)request.getAttribute("returnObj");                                   
sampleGroupVo            = null;                                                                          
returnVoList        = null;                                                                          
pageUtil            = null;                                                                          
if(returnObj != null){                                                                                          
    returnVoList    = (java.util.List<com.sample.member.vo.SampleGroupVo>)returnObj.get("returnObj"); 
    pageUtil        = (com.common.utils.PageUtil)returnObj.get("pageUtil");                                   
}                                                                                                             
/******************************************* 변수 정의 끝 *********************************************/        
%>                                                                                                              
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">      
<html>                                                                                                          
<head>                                                                                                          
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">                                         
<title>Insert title here</title>                                                                                
<script type="text/javascript">                                                                               
	function goForIt(){                                                                                          
		document.MAIN_FORM.submit();                                                                             
	}                                                                                                            
</script>                                                                                                       
</head>                                                                                                         
<body>                                                                                                          
                                                                                                                
<!--폼 시작-->                                                                                                   
<form name="MAIN_FORM" method="post" action="/group/listSampleGroup.do">                            
	<input type=hidden name="PAGE_NUM" value="<%= (pageUtil != null ? pageUtil.intPageNum : 1) %>">           
	<input type='button' name='' value='LIST' onclick='javascript:goForIt();' >                                 
	<table border=1>                                                                                              
		<tr>                                                                                                      
			<td>GROUP_ID&nbsp;</td><td>NAME&nbsp;</td><td>INPUT_DT&nbsp;</td>
		</tr>                                                                                                     
		<%                                                                                                        
		if(returnVoList!=null){                                                                                   
			for(int i=0; i<returnVoList.size(); i++){                                                             
				sampleGroupVo = returnVoList.get(i);                                                         
		%>                                                                                                        
		<tr>                                                                                                      
			<td><%=sampleGroupVo.getGROUP_ID() %>&nbsp;</td><td><%=sampleGroupVo.getNAME() %>&nbsp;</td><td><%=sampleGroupVo.getINPUT_DT() %>&nbsp;</td>
		</tr>	                                                                                                  
		<%                                                                                                        
			}                                                                                                     
		}                                                                                                         
		%>                                                                                                        
		<tr>                                                                                                      
			<td colspan=3 &nbsp; ><%= (pageUtil != null ? pageUtil.htmlPostPage(request, "MAIN_FORM", "PAGE_NUM" ) : "" ) %></td> 
		</tr>	                                                                                                  
	</table>                                                                                                      
                                                                                                                 
</form>                                                                                                          
<!--폼 끝-->                                                                                                      
                                                                                                                 
</body>                                                                                                          
</html>     