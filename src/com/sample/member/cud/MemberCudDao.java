package com.sample.member.cud; 
 
import java.util.List; 
import java.util.Map; 
 
import org.springframework.stereotype.Repository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.orm.ibatis.SqlMapClientTemplate; 
 
@Repository 
public class MemberCudDao extends com.common.biz.BaseDao { 
    @Autowired 
    @Qualifier("sqlMapClientTemplate1") 
    private SqlMapClientTemplate sqlMapClientTemplate1; 
     

    /******************************************* 샘플맴버[SAMPLE_MEMBER] 시작 *******************************************/ 
    /* 
     * 샘플맴버[SAMPLE_MEMBER] NEW키값 조회 
     */ 
    public com.sample.member.cud.vo.SampleMemberCudVo selectSampleMemberNewKey(com.sample.member.cud.vo.SampleMemberCudVo sampleMemberCudVo) throws Exception { 
        return (com.sample.member.cud.vo.SampleMemberCudVo) sqlMapClientTemplate1.queryForObject("COM_SAMPLE_MEMBER_CUD_MEMBERCUDDAO.selectSampleMemberNewKey", sampleMemberCudVo); 
    } 
    /* 
     * 샘플맴버[SAMPLE_MEMBER] 입력 
     */  
    public void insertSampleMember(com.sample.member.cud.vo.SampleMemberCudVo sampleMemberCudVo) throws Exception { 
        sqlMapClientTemplate1.insert("COM_SAMPLE_MEMBER_CUD_MEMBERCUDDAO.insertSampleMember", sampleMemberCudVo); 
    } 
    /* 
     * 샘플맴버[SAMPLE_MEMBER] 수정 
     */  
    public void updateSampleMember(com.sample.member.cud.vo.SampleMemberCudVo sampleMemberCudVo) throws Exception { 
        sqlMapClientTemplate1.update("COM_SAMPLE_MEMBER_CUD_MEMBERCUDDAO.updateSampleMember", sampleMemberCudVo); 
    } 
    /* 
     * 샘플맴버[SAMPLE_MEMBER] 삭제 
     */ 
    public void deleteSampleMember(com.sample.member.cud.vo.SampleMemberCudVo sampleMemberCudVo) throws Exception { 
        sqlMapClientTemplate1.delete("COM_SAMPLE_MEMBER_CUD_MEMBERCUDDAO.deleteSampleMember", sampleMemberCudVo); 
    } 
    /******************************************* 샘플맴버[SAMPLE_MEMBER] 끝 *******************************************/ 



    /******************************************* 샘플그룹[SAMPLE_GROUP] 시작 *******************************************/ 
    /* 
     * 샘플그룹[SAMPLE_GROUP] NEW키값 조회 
     */ 
    public com.sample.member.cud.vo.SampleGroupCudVo selectSampleGroupNewKey(com.sample.member.cud.vo.SampleGroupCudVo sampleGroupCudVo) throws Exception { 
        return (com.sample.member.cud.vo.SampleGroupCudVo) sqlMapClientTemplate1.queryForObject("COM_SAMPLE_MEMBER_CUD_MEMBERCUDDAO.selectSampleGroupNewKey", sampleGroupCudVo); 
    } 
    /* 
     * 샘플그룹[SAMPLE_GROUP] 입력 
     */  
    public void insertSampleGroup(com.sample.member.cud.vo.SampleGroupCudVo sampleGroupCudVo) throws Exception { 
        sqlMapClientTemplate1.insert("COM_SAMPLE_MEMBER_CUD_MEMBERCUDDAO.insertSampleGroup", sampleGroupCudVo); 
    } 
    /* 
     * 샘플그룹[SAMPLE_GROUP] 수정 
     */  
    public void updateSampleGroup(com.sample.member.cud.vo.SampleGroupCudVo sampleGroupCudVo) throws Exception { 
        sqlMapClientTemplate1.update("COM_SAMPLE_MEMBER_CUD_MEMBERCUDDAO.updateSampleGroup", sampleGroupCudVo); 
    } 
    /* 
     * 샘플그룹[SAMPLE_GROUP] 삭제 
     */ 
    public void deleteSampleGroup(com.sample.member.cud.vo.SampleGroupCudVo sampleGroupCudVo) throws Exception { 
        sqlMapClientTemplate1.delete("COM_SAMPLE_MEMBER_CUD_MEMBERCUDDAO.deleteSampleGroup", sampleGroupCudVo); 
    } 
    /******************************************* 샘플그룹[SAMPLE_GROUP] 끝 *******************************************/ 


} 
