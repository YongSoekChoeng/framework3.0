﻿package net.dstone.common.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BaseService extends net.dstone.common.spring.mvc.BaseObject {

	protected void debug(Object o) {
		super.debug(o);
	}

	
}
