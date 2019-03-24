package net.dstone.sample.member; 
 
import java.util.List; 
import java.util.Map; 
 
import org.springframework.stereotype.Repository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.orm.ibatis.SqlMapClientTemplate; 
 
@Repository 
public class MemberDao extends net.dstone.common.biz.BaseDao { 

    @Autowired 
    @Qualifier("sqlMapClientTemplate1") 
    private SqlMapClientTemplate sqlMapClientTemplate1; 
     
    /* 
     * 샘플멤버정보 리스트조회(카운트) 
     */ 
    public int listSampleMemberCount(net.dstone.sample.member.vo.SampleMemberVo sampleMemberVo) throws Exception { 
        Object returnObj = sqlMapClientTemplate1.queryForObject("COM_SAMPLE_MEMBER_MEMBERDAO.listSampleMemberCount", sampleMemberVo); 
        if (returnObj == null) {
            return 0;
        } else {
            return ((Integer) returnObj).intValue();
        }
    } 
    /* 
     * 샘플멤버정보 리스트조회 
     */ 
    public List<net.dstone.sample.member.vo.SampleMemberVo> listSampleMember(net.dstone.sample.member.vo.SampleMemberVo sampleMemberVo) throws Exception { 
        return (List<net.dstone.sample.member.vo.SampleMemberVo>) sqlMapClientTemplate1.queryForList("COM_SAMPLE_MEMBER_MEMBERDAO.listSampleMember", sampleMemberVo); 
    } 


    /* 
     * 샘플멤버정보 상세조회 
     */ 
    public net.dstone.sample.member.vo.SampleMemberVo getSampleMember(net.dstone.sample.member.vo.SampleMemberVo sampleMemberVo) throws Exception { 
        return (net.dstone.sample.member.vo.SampleMemberVo) sqlMapClientTemplate1.queryForObject("COM_SAMPLE_MEMBER_MEMBERDAO.getSampleMember", sampleMemberVo); 
    } 

} 
