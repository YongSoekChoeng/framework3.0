package com.common.biz;

import java.util.List; 
import java.util.Map; 

import org.springframework.stereotype.Repository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.SqlMapClientTemplate; 

@Repository
public class BaseDao extends com.common.spring.mvc.BaseObject {

	protected void debug(Object o) {
		super.debug(o);
	}
	
    @Autowired 
    @Qualifier("sqlMapClientTemplate1") 
    protected SqlMapClientTemplate sqlMapClientTemplate1; 
     
}
