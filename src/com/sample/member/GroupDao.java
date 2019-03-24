package com.sample.member; 
 
import java.util.List; 
import java.util.Map; 
 
import org.springframework.stereotype.Repository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.orm.ibatis.SqlMapClientTemplate; 
 
@Repository 
public class GroupDao extends com.common.biz.BaseDao { 

    @Autowired 
    @Qualifier("sqlMapClientTemplate1") 
    private SqlMapClientTemplate sqlMapClientTemplate1; 
     
    /* 
     * 샘플그룹정보 리스트조회(카운트) 
     */ 
    public int listSampleGroupCount(com.sample.member.vo.SampleGroupVo sampleGroupVo) throws Exception { 
        Object returnObj = sqlMapClientTemplate1.queryForObject("COM_SAMPLE_MEMBER_GROUPDAO.listSampleGroupCount", sampleGroupVo); 
        if (returnObj == null) {
            return 0;
        } else {
            return ((Integer) returnObj).intValue();
        }
    } 
    /* 
     * 샘플그룹정보 리스트조회 
     */ 
    public List<com.sample.member.vo.SampleGroupVo> listSampleGroup(com.sample.member.vo.SampleGroupVo sampleGroupVo) throws Exception { 
        return (List<com.sample.member.vo.SampleGroupVo>) sqlMapClientTemplate1.queryForList("COM_SAMPLE_MEMBER_GROUPDAO.listSampleGroup", sampleGroupVo); 
    } 


    /* 
     * 샘플그룹정보 상세조회 
     */ 
    public com.sample.member.vo.SampleGroupVo getSampleGroup(com.sample.member.vo.SampleGroupVo sampleGroupVo) throws Exception { 
        return (com.sample.member.vo.SampleGroupVo) sqlMapClientTemplate1.queryForObject("COM_SAMPLE_MEMBER_GROUPDAO.getSampleGroup", sampleGroupVo); 
    } 

} 
