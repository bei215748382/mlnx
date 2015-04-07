package com.mlnxMS.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.mlnxMS.service.AdminService;
import com.mlnxMS.core.Admin;

public class AjaxAction extends BaseAction {

	AdminService adminService = new AdminService();

	/**
	 * 管理员登录验证
	 * 
	 * @throws IOException
	 */
	public String adName;
	public String adPass;
	public void login() throws IOException {

		PrintWriter out = ServletActionContext.getResponse().getWriter();

		List<Admin> admins = adminService.findAll();
		boolean exist = true;
		for (Iterator<Admin> iterator = admins.iterator(); iterator.hasNext();) {
			Admin admin = (Admin) iterator.next();
			if (adName.equals(admin.getAdName())
					&& adPass.equals(admin.getAdPass())) {
				exist = true;
				session.setAttribute("user", adName);
				break;
			} else {
				exist = false;
			}
		}

		if (exist) {
			out.print("1");
		} else {
			out.print("0");
		}

	}
}
