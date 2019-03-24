package com.sample.dept; 
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.utils.DateUtil;
import com.common.utils.PropUtil;
import com.common.utils.StringUtil;
import com.common.utils.BeanUtil;
@Controller
@RequestMapping(value = "/dept/*")
public class DeptController extends com.common.biz.BaseController { 
    

    /********* SVC 정의부분 시작 *********/
    @Autowired 
    private com.sample.dept.DeptService deptService; 
    /********* SVC 정의부분 끝 *********/
    
    /** 
     * 샘플부서정보 리스트조회 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/listSampleDept.do") 
    public ModelAndView listSampleDept(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
   		// 필요없는 주석들은 제거하시고 사용하시면 됩니다.
   		/************************ 세션체크 시작 ************************/
   		loginCheck(request, response);
   		/************************ 세션체크 끝 **************************/
   		
   		/************************ 변수 선언 시작 ************************/
   		com.common.utils.RequestUtil 					requestUtil;
   		Map 											returnObj;
   		//파라메터
   		//String										ACTION_MODE;
   		//파라메터로 사용할 VO
   		com.sample.dept.vo.SampleDeptVo 					paramVo;
   		//com.sample.dept.vo.SampleDeptVo[] 				paramList;
   		/************************ 변수 선언 끝 **************************/
   		try {
   			/************************ 변수 정의 시작 ************************/
   			requestUtil 			= new com.common.utils.RequestUtil(request, response);
   			paramVo					= null;
   			//paramList				= null;
   			returnObj				= null;
   			/************************ 변수 정의 끝 ************************/
   			
   			/************************ 컨트롤러 로직 시작 ************************/
   			// 1. 파라메터 바인딩
   			// 일반 파라메터 받는경우
   			//ACTION_MODE				= requestUtil.getParameter("ACTION_MODE", "LIST_PLAIN");
   			// 싱글 VALUE 맵핑일 경우
   			paramVo 				= (com.sample.dept.vo.SampleDeptVo)bindSingleValue(requestUtil, new com.sample.dept.vo.SampleDeptVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.dept.vo.SampleDeptVo[])bindMultiValues(requestUtil, "com.sample.dept.vo.SampleDeptVo");
   			/*** 페이징파라메터 세팅 시작 ***/
   			if(!com.common.utils.StringUtil.isEmpty(requestUtil.getParameter("PAGE_NUM", ""))){
   				paramVo.setPAGE_NUM(requestUtil.getIntParameter("PAGE_NUM"));
   				paramVo.setPAGE_SIZE(com.common.utils.PageUtil.DEFAULT_PAGE_SIZE);
   			}
   			/*** 페이징파라메터 세팅 끝 ***/
   			// 2. 서비스 호출
   			returnObj 				= deptService.listSampleDept(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, returnObj	);
   			mav.setViewName("/sample/view/dept/listSampleDept");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/dept/listSampleDept");
   		}
   		return mav;
    } 


    /** 
     * 샘플부서정보 상세조회 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/getSampleDept.do") 
    public ModelAndView getSampleDept(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
   		// 필요없는 주석들은 제거하시고 사용하시면 됩니다.
   		/************************ 세션체크 시작 ************************/
   		loginCheck(request, response);
   		/************************ 세션체크 끝 **************************/
   		
   		/************************ 변수 선언 시작 ************************/
   		com.common.utils.RequestUtil 					requestUtil;
   		com.sample.dept.vo.SampleDeptVo					returnObj;
   		//파라메터
   		//String										ACTION_MODE;
   		//파라메터로 사용할 VO
   		com.sample.dept.vo.SampleDeptVo 					paramVo;
   		//com.sample.dept.vo.SampleDeptVo[] 				paramList;
   		/************************ 변수 선언 끝 **************************/
   		try {
   			/************************ 변수 정의 시작 ************************/
   			requestUtil 			= new com.common.utils.RequestUtil(request, response);
   			paramVo					= null;
   			//paramList				= null;
   			returnObj				= null;
   			/************************ 변수 정의 끝 ************************/
   			
   			/************************ 컨트롤러 로직 시작 ************************/
   			// 1. 파라메터 바인딩
   			// 일반 파라메터 받는경우
   			//ACTION_MODE				= requestUtil.getParameter("ACTION_MODE", "LIST_PLAIN");
   			// 싱글 VALUE 맵핑일 경우
   			paramVo 				= (com.sample.dept.vo.SampleDeptVo)bindSingleValue(requestUtil, new com.sample.dept.vo.SampleDeptVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.dept.vo.SampleDeptVo[])bindMultiValues(requestUtil, "com.sample.dept.vo.SampleDeptVo");
   			// 2. 서비스 호출
   			returnObj 				= deptService.getSampleDept(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, returnObj	);
   			mav.setViewName("/sample/view/dept/getSampleDept");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/dept/getSampleDept");
   		}
   		return mav;
    } 


    /** 
     * 샘플부서정보 입력 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/insertSampleDept.do") 
    public ModelAndView insertSampleDept(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
   		// 필요없는 주석들은 제거하시고 사용하시면 됩니다.
   		/************************ 세션체크 시작 ************************/
   		loginCheck(request, response);
   		/************************ 세션체크 끝 **************************/
   		
   		/************************ 변수 선언 시작 ************************/
   		com.common.utils.RequestUtil 					requestUtil;
   		//파라메터
   		//String											ACTION_MODE;
   		//파라메터로 사용할 VO
   		com.sample.dept.cud.vo.SampleDeptCudVo 							paramVo;
   		//com.sample.dept.cud.vo.SampleDeptCudVo[] 							paramList;
   		/************************ 변수 선언 끝 **************************/
   		try {
   			/************************ 변수 정의 시작 ************************/
   			requestUtil 			= new com.common.utils.RequestUtil(request, response);
   			paramVo					= null;
   			//paramList				= null;
   			/************************ 변수 정의 끝 ************************/
   			
   			/************************ 컨트롤러 로직 시작 ************************/
   			// 1. 파라메터 바인딩
   			// 일반 파라메터 받는경우
   			//ACTION_MODE				= requestUtil.getParameter("ACTION_MODE", "LIST_PLAIN");
   			// 싱글 VALUE 맵핑일 경우
   			paramVo 				= (com.sample.dept.cud.vo.SampleDeptCudVo)bindSingleValue(requestUtil, new com.sample.dept.cud.vo.SampleDeptCudVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.dept.cud.vo.SampleDeptCudVo[])bindMultiValues(requestUtil, "com.sample.dept.cud.vo.SampleDeptCudVo");
   			// 2. 서비스 호출
   			boolean result 			= deptService.insertSampleDept(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, new Boolean(result) );
   			mav.setViewName("/sample/view/dept/insertSampleDept");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/dept/insertSampleDept");
   		}
   		return mav;
    } 


    /** 
     * 샘플부서정보 수정 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/updateSampleDept.do") 
    public ModelAndView updateSampleDept(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
   		// 필요없는 주석들은 제거하시고 사용하시면 됩니다.
   		/************************ 세션체크 시작 ************************/
   		loginCheck(request, response);
   		/************************ 세션체크 끝 **************************/
   		
   		/************************ 변수 선언 시작 ************************/
   		com.common.utils.RequestUtil 					requestUtil;
   		//파라메터
   		//String											ACTION_MODE;
   		//파라메터로 사용할 VO
   		com.sample.dept.cud.vo.SampleDeptCudVo 							paramVo;
   		//com.sample.dept.cud.vo.SampleDeptCudVo[] 							paramList;
   		/************************ 변수 선언 끝 **************************/
   		try {
   			/************************ 변수 정의 시작 ************************/
   			requestUtil 			= new com.common.utils.RequestUtil(request, response);
   			paramVo					= null;
   			//paramList				= null;
   			/************************ 변수 정의 끝 ************************/
   			
   			/************************ 컨트롤러 로직 시작 ************************/
   			// 1. 파라메터 바인딩
   			// 일반 파라메터 받는경우
   			//ACTION_MODE				= requestUtil.getParameter("ACTION_MODE", "LIST_PLAIN");
   			// 싱글 VALUE 맵핑일 경우
   			paramVo 				= (com.sample.dept.cud.vo.SampleDeptCudVo)bindSingleValue(requestUtil, new com.sample.dept.cud.vo.SampleDeptCudVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.dept.cud.vo.SampleDeptCudVo[])bindMultiValues(requestUtil, "com.sample.dept.cud.vo.SampleDeptCudVo");
   			// 2. 서비스 호출
   			boolean result 			= deptService.updateSampleDept(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, new Boolean(result) );
   			mav.setViewName("/sample/view/dept/updateSampleDept");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/dept/updateSampleDept");
   		}
   		return mav;
    } 


    /** 
     * 샘플부서정보 삭제 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/deleteSampleDept.do") 
    public ModelAndView deleteSampleDept(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
   		// 필요없는 주석들은 제거하시고 사용하시면 됩니다.
   		/************************ 세션체크 시작 ************************/
   		loginCheck(request, response);
   		/************************ 세션체크 끝 **************************/
   		
   		/************************ 변수 선언 시작 ************************/
   		com.common.utils.RequestUtil 					requestUtil;
   		//파라메터
   		//String											ACTION_MODE;
   		//파라메터로 사용할 VO
   		com.sample.dept.cud.vo.SampleDeptCudVo 							paramVo;
   		//com.sample.dept.cud.vo.SampleDeptCudVo[] 							paramList;
   		/************************ 변수 선언 끝 **************************/
   		try {
   			/************************ 변수 정의 시작 ************************/
   			requestUtil 			= new com.common.utils.RequestUtil(request, response);
   			paramVo					= null;
   			//paramList				= null;
   			/************************ 변수 정의 끝 ************************/
   			
   			/************************ 컨트롤러 로직 시작 ************************/
   			// 1. 파라메터 바인딩
   			// 일반 파라메터 받는경우
   			//ACTION_MODE				= requestUtil.getParameter("ACTION_MODE", "LIST_PLAIN");
   			// 싱글 VALUE 맵핑일 경우
   			paramVo 				= (com.sample.dept.cud.vo.SampleDeptCudVo)bindSingleValue(requestUtil, new com.sample.dept.cud.vo.SampleDeptCudVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.dept.cud.vo.SampleDeptCudVo[])bindMultiValues(requestUtil, "com.sample.dept.cud.vo.SampleDeptCudVo");
   			// 2. 서비스 호출
   			boolean result 			= deptService.deleteSampleDept(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, new Boolean(result) );
   			mav.setViewName("/sample/view/dept/deleteSampleDept");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/dept/deleteSampleDept");
   		}
   		return mav;
    } 

} 
