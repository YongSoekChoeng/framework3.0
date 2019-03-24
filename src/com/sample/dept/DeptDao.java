package com.sample.dept; 
 
import java.util.List; 
import java.util.Map; 
 
import org.springframework.stereotype.Repository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.orm.ibatis.SqlMapClientTemplate; 
 
@Repository 
public class DeptDao extends com.common.biz.BaseDao { 

    @Autowired 
    @Qualifier("sqlMapClientTemplate2") 
    private SqlMapClientTemplate sqlMapClientTemplate2; 
     
    /* 
     * 샘플부서정보 리스트조회(카운트) 
     */ 
    public int listSampleDeptCount(com.sample.dept.vo.SampleDeptVo sampleDeptVo) throws Exception { 
        Object returnObj = sqlMapClientTemplate2.queryForObject("COM_SAMPLE_DEPT_DEPTDAO.listSampleDeptCount", sampleDeptVo); 
        if (returnObj == null) {
            return 0;
        } else {
            return ((Integer) returnObj).intValue();
        }
    } 
    /* 
     * 샘플부서정보 리스트조회 
     */ 
    public List<com.sample.dept.vo.SampleDeptVo> listSampleDept(com.sample.dept.vo.SampleDeptVo sampleDeptVo) throws Exception { 
        return (List<com.sample.dept.vo.SampleDeptVo>) sqlMapClientTemplate2.queryForList("COM_SAMPLE_DEPT_DEPTDAO.listSampleDept", sampleDeptVo); 
    } 


    /* 
     * 샘플부서정보 상세조회 
     */ 
    public com.sample.dept.vo.SampleDeptVo getSampleDept(com.sample.dept.vo.SampleDeptVo sampleDeptVo) throws Exception { 
        return (com.sample.dept.vo.SampleDeptVo) sqlMapClientTemplate2.queryForObject("COM_SAMPLE_DEPT_DEPTDAO.getSampleDept", sampleDeptVo); 
    } 

} 
