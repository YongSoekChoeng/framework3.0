package com.common.utils;

import java.io.*;
import javax.servlet.http.*;

public class InitServlet extends javax.servlet.http.HttpServlet {

	public void init(javax.servlet.ServletConfig config) throws javax.servlet.ServletException {
		super.init(config);
		try {
			/*** 1. com.common.utils.PropUtil Start ***/
			String rootDirectory = config.getServletContext().getRealPath("/WEB-INF/conf/properties");
			com.common.utils.PropUtil.initialize(rootDirectory);

		} catch (Exception es) {
			es.printStackTrace();
		}
	}
}
