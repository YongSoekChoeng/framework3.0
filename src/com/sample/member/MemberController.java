package com.sample.member; 
 
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
@RequestMapping(value = "/member/*")
public class MemberController extends com.common.biz.BaseController { 
    

    /********* SVC 정의부분 시작 *********/
    @Autowired 
    private com.sample.member.MemberService memberService; 
    /********* SVC 정의부분 끝 *********/
    
    /** 
     * 샘플멤버정보 리스트조회 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/listSampleMember.do") 
    public ModelAndView listSampleMember(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
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
   		com.sample.member.vo.SampleMemberVo 					paramVo;
   		//com.sample.member.vo.SampleMemberVo[] 				paramList;
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
   			paramVo 				= (com.sample.member.vo.SampleMemberVo)bindSingleValue(requestUtil, new com.sample.member.vo.SampleMemberVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.member.vo.SampleMemberVo[])bindMultiValues(requestUtil, "com.sample.member.vo.SampleMemberVo");
   			/*** 페이징파라메터 세팅 시작 ***/
   			if(!com.common.utils.StringUtil.isEmpty(requestUtil.getParameter("PAGE_NUM", ""))){
   				paramVo.setPAGE_NUM(requestUtil.getIntParameter("PAGE_NUM"));
   				paramVo.setPAGE_SIZE(com.common.utils.PageUtil.DEFAULT_PAGE_SIZE);
   			}
   			/*** 페이징파라메터 세팅 끝 ***/
   			// 2. 서비스 호출
   			returnObj 				= memberService.listSampleMember(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, returnObj	);
   			mav.setViewName("/sample/view/member/listSampleMember");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/member/listSampleMember");
   		}
   		return mav;
    } 


    /** 
     * 샘플멤버정보 상세조회 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/getSampleMember.do") 
    public ModelAndView getSampleMember(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
   		// 필요없는 주석들은 제거하시고 사용하시면 됩니다.
   		/************************ 세션체크 시작 ************************/
   		loginCheck(request, response);
   		/************************ 세션체크 끝 **************************/
   		
   		/************************ 변수 선언 시작 ************************/
   		com.common.utils.RequestUtil 					requestUtil;
   		com.sample.member.vo.SampleMemberVo					returnObj;
   		//파라메터
   		//String										ACTION_MODE;
   		//파라메터로 사용할 VO
   		com.sample.member.vo.SampleMemberVo 					paramVo;
   		//com.sample.member.vo.SampleMemberVo[] 				paramList;
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
   			paramVo 				= (com.sample.member.vo.SampleMemberVo)bindSingleValue(requestUtil, new com.sample.member.vo.SampleMemberVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.member.vo.SampleMemberVo[])bindMultiValues(requestUtil, "com.sample.member.vo.SampleMemberVo");
   			// 2. 서비스 호출
   			returnObj 				= memberService.getSampleMember(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, returnObj	);
   			mav.setViewName("/sample/view/member/getSampleMember");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/member/getSampleMember");
   		}
   		return mav;
    } 


    /** 
     * 샘플멤버정보 입력 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/insertSampleMember.do") 
    public ModelAndView insertSampleMember(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
   		// 필요없는 주석들은 제거하시고 사용하시면 됩니다.
   		/************************ 세션체크 시작 ************************/
   		loginCheck(request, response);
   		/************************ 세션체크 끝 **************************/
   		
   		/************************ 변수 선언 시작 ************************/
   		com.common.utils.RequestUtil 					requestUtil;
   		//파라메터
   		//String											ACTION_MODE;
   		//파라메터로 사용할 VO
   		com.sample.member.cud.vo.SampleMemberCudVo 							paramVo;
   		//com.sample.member.cud.vo.SampleMemberCudVo[] 							paramList;
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
   			paramVo 				= (com.sample.member.cud.vo.SampleMemberCudVo)bindSingleValue(requestUtil, new com.sample.member.cud.vo.SampleMemberCudVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.member.cud.vo.SampleMemberCudVo[])bindMultiValues(requestUtil, "com.sample.member.cud.vo.SampleMemberCudVo");
   			// 2. 서비스 호출
   			boolean result 			= memberService.insertSampleMember(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, new Boolean(result) );
   			mav.setViewName("/sample/view/member/insertSampleMember");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/member/insertSampleMember");
   		}
   		return mav;
    } 


    /** 
     * 샘플멤버정보 수정 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/updateSampleMember.do") 
    public ModelAndView updateSampleMember(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
   		// 필요없는 주석들은 제거하시고 사용하시면 됩니다.
   		/************************ 세션체크 시작 ************************/
   		loginCheck(request, response);
   		/************************ 세션체크 끝 **************************/
   		
   		/************************ 변수 선언 시작 ************************/
   		com.common.utils.RequestUtil 					requestUtil;
   		//파라메터
   		//String											ACTION_MODE;
   		//파라메터로 사용할 VO
   		com.sample.member.cud.vo.SampleMemberCudVo 							paramVo;
   		//com.sample.member.cud.vo.SampleMemberCudVo[] 							paramList;
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
   			paramVo 				= (com.sample.member.cud.vo.SampleMemberCudVo)bindSingleValue(requestUtil, new com.sample.member.cud.vo.SampleMemberCudVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.member.cud.vo.SampleMemberCudVo[])bindMultiValues(requestUtil, "com.sample.member.cud.vo.SampleMemberCudVo");
   			// 2. 서비스 호출
   			boolean result 			= memberService.updateSampleMember(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, new Boolean(result) );
   			mav.setViewName("/sample/view/member/updateSampleMember");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/member/updateSampleMember");
   		}
   		return mav;
    } 


    /** 
     * 샘플멤버정보 삭제 
     * @param request 
     * @param model 
     * @return 
     */ 
    @RequestMapping(value = "/deleteSampleMember.do") 
    public ModelAndView deleteSampleMember(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, ModelAndView mav) {
   		// 필요없는 주석들은 제거하시고 사용하시면 됩니다.
   		/************************ 세션체크 시작 ************************/
   		loginCheck(request, response);
   		/************************ 세션체크 끝 **************************/
   		
   		/************************ 변수 선언 시작 ************************/
   		com.common.utils.RequestUtil 					requestUtil;
   		//파라메터
   		//String											ACTION_MODE;
   		//파라메터로 사용할 VO
   		com.sample.member.cud.vo.SampleMemberCudVo 							paramVo;
   		//com.sample.member.cud.vo.SampleMemberCudVo[] 							paramList;
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
   			paramVo 				= (com.sample.member.cud.vo.SampleMemberCudVo)bindSingleValue(requestUtil, new com.sample.member.cud.vo.SampleMemberCudVo());
   			// 멀티 VALUE 맵핑일 경우
   			//paramList 			= (com.sample.member.cud.vo.SampleMemberCudVo[])bindMultiValues(requestUtil, "com.sample.member.cud.vo.SampleMemberCudVo");
   			// 2. 서비스 호출
   			boolean result 			= memberService.deleteSampleMember(paramVo);
   			// 3. 결과처리
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_SUCCESS );
   			request.setAttribute("RETURN_MSG"	, "" );
   			//request.setAttribute("ACTION_MODE"	, ACTION_MODE	);
   			request.setAttribute("returnObj"	, new Boolean(result) );
   			mav.setViewName("/sample/view/member/deleteSampleMember");
   			/************************ 컨트롤러 로직 끝 ************************/
   		
   		} catch (Exception e) {
   			handleException(request, response, e);
   			request.setAttribute("RETURN_CD"	, com.common.biz.BaseController.RETURN_FAIL );
   			request.setAttribute("RETURN_MSG"	, e.toString() );
   			mav.setViewName("/sample/view/member/deleteSampleMember");
   		}
   		return mav;
    } 

} 
