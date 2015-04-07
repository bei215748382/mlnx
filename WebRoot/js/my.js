//ajax验证管理员登录的用户名密码
function loginCheck() {
	$
			.ajax({
				type : "get",// 请求方式
				url : "ajax!login.action",// 发送请求地址
				data : {// 发送给数据库的数据
					adName : $("#username").val(),
					adPass : $("#password").val()

				},
				// 请求成功后的回调函数有两个参数

				success : function(data, textStatus) {

					if (data == "1") {
						window.location.assign("admin!showHeader.action");
					} else {
						document.getElementById("alert").style.color = "red";
						$("#alert").html("用户名密码错误！");
						setTimeout(
								'$("#alert").html("请重新输入您的用户名和密码:");document.getElementById("alert").style.color="";',
								2000);
					}

				}

			});
}

// 回车键触发登录界面的登录按钮click（）
function eKeyup(e) {
	e = e ? e : (window.event ? window.event : null);
	if (e.keyCode == 13)// Enter
	{
		document.getElementById("MSlogin").click();
	}
}

// 删除指定页顶信息
function deleHeader(selcId1) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteHeader.action?selcId1=" + selcId1);
	}
}

// 删除指定导航菜单
function deleNavigation(selcId2) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteNavigation.action?selcId2="
				+ selcId2);
	}
}

// 删除指定banner
function deleBanner(selcId3) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteBanner.action?selcId3=" + selcId3);
	}
}

// 删除指定二维码信息
function deleQrcode(selcId4) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteQrcode.action?selcId4=" + selcId4);
	}
}

// 删除指定友链信息
function deleLink(selcId5) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteLink.action?selcId5=" + selcId5);
	}
}

// 删除指定版权信息
function deleCopyright(selcId6) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteCopyright.action?selcId6="
				+ selcId6);
	}
}

// 删除指定页面内容
function deleContent(selcId7) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteContent.action?selcId7=" + selcId7);
	}
}

// 删除指定产品信息
function deleProduct(selcId8) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteProduct.action?selcId8=" + selcId8);
	}
}

// 删除指定招聘信息
function deleRecruitment(selcId9) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteRecruitment.action?selcId9="
				+ selcId9);
	}
}

// 删除指定联系信息
function deleContact(selcId10) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteContact.action?selcId10="
				+ selcId10);
	}
}

// 删除指定图片
function deleImage(selcId11) {
	if (confirm("确定删除此项？") == true) {
		window.location.assign("admin!deleteImage.action?selcId11=" + selcId11);
	}
}

// 修改导航菜单信息
function modiNavigation(mdId1) {
	var name = document.getElementById("navName" + mdId1).innerHTML;
	var priority = document.getElementById("navPriority" + mdId1).innerHTML;
	document.getElementById("navName" + mdId1).innerHTML = "<input class='input-xlarge focused' id='name"
			+ mdId1 + "' type='text' value=" + name + ">";
	var str = "";
	for (i = 1; i <= 9; i++) {
		var str1;
		if (i == priority) {
			str1 = "<option selected='selected'>" + i + "</option>";
		} else {
			str1 = "<option>" + i + "</option>";
		}
		str = str + str1;
	}
	document.getElementById("navPriority" + mdId1).innerHTML = "<select id='priority"
			+ mdId1 + "'>" + str + "</select>";
	document.getElementById("modiNav" + mdId1).innerHTML = "<a class='btn btn-primary' style='cursor: pointer;' onclick='confirmModiNav("
			+ mdId1 + ")'><i class='icon-edit icon-white'></i> 确认  </a>";
}

// 确认修改导航信息
function confirmModiNav(chosenId1) {
	var navName = document.getElementById("name" + chosenId1).value;
	var navPriority = document.getElementById("priority" + chosenId1).value;
	if (confirm("确定更改此项？") == true) {
		window.location.assign("admin!modifyNavigation.action?modiId1="
				+ chosenId1 + "&navName1=" + navName + "&navPriority1="
				+ navPriority);
	} else {
		window.location.assign("admin!showNavigation.action");
	}
}

// 修改页面内容
function modiContent(mdId2) {
	var title = document.getElementById("conTitle" + mdId2).innerHTML;
	var text = document.getElementById("conText" + mdId2).innerHTML;
	var position = document.getElementById("conPosition" + mdId2).innerHTML;
	document.getElementById("conTitle" + mdId2).innerHTML = "<input class='input-xlarge focused' id='title"
			+ mdId2 + "' type='text' style='width: 95%' value=" + title + ">";
	document.getElementById("conText" + mdId2).innerHTML = "<textarea style='width:95%' class='cleditor' id='text"
			+ mdId2 + "' rows='5'></textarea>";
	document.getElementById("text" + mdId2).innerHTML = text;

	var str = "";
	for (i = 1; i <= 9; i++) {
		var str1;
		if (i == position) {
			str1 = "<option selected='selected'>" + i + "</option>";
		} else {
			str1 = "<option>" + i + "</option>";
		}
		str = str + str1;
	}
	document.getElementById("conPosition" + mdId2).innerHTML = "<select style='width:80%' id='position"
			+ mdId2 + "'>" + str + "</select>";
	document.getElementById("modiCont" + mdId2).innerHTML = "<a class='btn btn-primary' style='cursor: pointer;' onclick='confirmModiCont("
			+ mdId2 + ")'><i class='icon-edit icon-white'></i> 确认 </a>";
}

// 确认修改页面内容
function confirmModiCont(chosenId2) {
	var conTitle = document.getElementById("title" + chosenId2).value;
	var conText = document.getElementById("text" + chosenId2).value;
	var conPosition = document.getElementById("position" + chosenId2).value;
	if (confirm("确定更改此项？") == true) {
		window.location.assign("admin!modifyContent.action?modiId2="
				+ chosenId2 + "&conTitle1=" + conTitle + "&conText1=" + conText
				+ "&conPosition1=" + conPosition);
	} else {
		window.location.assign("admin!showContent.action");
	}
}

// 修改产品信息
function modiProduct(mdId3) {
	var name = document.getElementById("pduName" + mdId3).innerHTML;
	var detail = document.getElementById("pduDetail" + mdId3).innerHTML;
	var priority = document.getElementById("pduPriority" + mdId3).innerHTML;
	document.getElementById("pduName" + mdId3).innerHTML = "<input class='input-xlarge focused' style='width: 95%' id='name"
			+ mdId3 + "' type='text' value=" + name + ">";
	document.getElementById("pduDetail" + mdId3).innerHTML = "<textarea class='cleditor' id='detail"
			+ mdId3 + "' rows='5'></textarea>";
	document.getElementById("detail" + mdId3).innerHTML = detail;

	var str = "";
	for (i = 1; i <= 9; i++) {
		var str1;
		if (i == priority) {
			str1 = "<option selected='selected'>" + i + "</option>";
		} else {
			str1 = "<option>" + i + "</option>";
		}
		str = str + str1;
	}
	document.getElementById("pduPriority" + mdId3).innerHTML = "<select style='width:100%' id='priority"
			+ mdId3 + "'>" + str + "</select>";
	document.getElementById("modiPdu" + mdId3).innerHTML = "<a class='btn btn-primary' style='cursor: pointer;' onclick='confirmModiPdu("
			+ mdId3 + ")'><i class='icon-edit icon-white'></i> 确认 </a>";
}

// 确认修改产品信息
function confirmModiPdu(chosenId3) {
	var pduName = document.getElementById("name" + chosenId3).value;
	var pduDeatil = document.getElementById("detail" + chosenId3).value;
	var pduPriority = document.getElementById("priority" + chosenId3).value;
	if (confirm("确定更改此项？") == true) {
		window.location.assign("admin!modifyProduct.action?modiId3="
				+ chosenId3 + "&pduName1=" + pduName + "&pduDetail1="
				+ pduDeatil + "&pduPriority1=" + pduPriority);
	} else {
		window.location.assign("admin!showProduct.action");
	}
}

// 修改招聘信息
function modiRecruitment(mdId4) {
	var post = document.getElementById("recruitPost" + mdId4).innerHTML;
	var duty = document.getElementById("recruitDuty" + mdId4).innerHTML;
	var claim = document.getElementById("recruitClaim" + mdId4).innerHTML;
	document.getElementById("recruitPost" + mdId4).innerHTML = "<input class='input-xlarge focused' style='width: 95%' id='post"
			+ mdId4 + "' type='text' value=" + post + ">";
	document.getElementById("recruitDuty" + mdId4).innerHTML = "<textarea class='cleditor' id='duty"
			+ mdId4 + "' rows='5'></textarea>";
	document.getElementById("duty" + mdId4).innerHTML = duty;
	document.getElementById("recruitClaim" + mdId4).innerHTML = "<textarea class='cleditor' id='claim"
			+ mdId4 + "' rows='5'></textarea>";
	document.getElementById("claim" + mdId4).innerHTML = claim;
	document.getElementById("modiRec" + mdId4).innerHTML = "<a class='btn btn-primary' style='cursor: pointer;' onclick='confirmModiRec("
			+ mdId4 + ")'><i class='icon-edit icon-white'></i> 确认 </a>";
}

// 确认修改招聘信息
function confirmModiRec(chosenId4) {
	var recruitPost = document.getElementById("post" + chosenId4).value;
	var recruitDuty = document.getElementById("duty" + chosenId4).value;
	var recruitClaim = document.getElementById("claim" + chosenId4).value;
	if (confirm("确定更改此项？") == true) {
		window.location.assign("admin!modifyRecruitment.action?modiId4="
				+ chosenId4 + "&recruitPost1=" + recruitPost + "&recruitDuty1="
				+ recruitDuty + "&recruitClaim1=" + recruitClaim);
	} else {
		window.location.assign("admin!showRecruitment.action");
	}
}

// 修改联系信息
function modiContact(mdId5) {
	var phone = document.getElementById("ctPhone" + mdId5).innerHTML;
	var fax = document.getElementById("ctFax" + mdId5).innerHTML;
	var email = document.getElementById("ctEmail" + mdId5).innerHTML;
	var adress = document.getElementById("ctAdress" + mdId5).innerHTML;
	document.getElementById("ctPhone" + mdId5).innerHTML = "<input class='input-xlarge focused' id='phone"
			+ mdId5 + "' type='text' style='width: 95%' value=" + phone + ">";
	document.getElementById("ctFax" + mdId5).innerHTML = "<input class='input-xlarge focused' id='fax"
			+ mdId5 + "' type='text' style='width: 95%' value=" + fax + ">";
	document.getElementById("ctEmail" + mdId5).innerHTML = "<input class='input-xlarge focused' id='email"
			+ mdId5 + "' type='text' style='width: 95%' value=" + email + ">";
	document.getElementById("ctAdress" + mdId5).innerHTML = "<input class='input-xlarge focused' id='adress"
			+ mdId5 + "' type='text' style='width: 95%' value=" + adress + ">";
	document.getElementById("modiCta" + mdId5).innerHTML = "<a class='btn btn-primary' style='cursor: pointer;' onclick='confirmModiCta("
			+ mdId5 + ")'><i class='icon-edit icon-white'></i> 确认 </a>";
}

// 确认修改联系信息
function confirmModiCta(chosenId5) {
	var ctPhone = document.getElementById("phone" + chosenId5).value;
	var ctFax = document.getElementById("fax" + chosenId5).value;
	var ctEmail = document.getElementById("email" + chosenId5).value;
	var ctAdress = document.getElementById("adress" + chosenId5).value;
	if (confirm("确定更改此项？") == true) {
		window.location.assign("admin!modifyContact.action?modiId5="
				+ chosenId5 + "&ctPhone1=" + ctPhone + "&ctFax1=" + ctFax
				+ "&ctEmail1=" + ctEmail + "&ctAdress1=" + ctAdress);
	} else {
		window.location.assign("admin!showContact.action");
	}
}

// 修改图片信息
function modiImage(mdId6) {
	var detail = document.getElementById("imgDetail" + mdId6).innerHTML;
	var type = document.getElementById("imgType" + mdId6).innerHTML;
	var position = document.getElementById("imgPosition" + mdId6).innerHTML;
	var str = "";
	for (i = 1; i <= 5; i++) {
		var str1;
		var str2;
		switch (i) {
		case 1:
			str2 = "人员类";
			break;
		case 2:
			str2 = "证书类";
			break;
		case 3:
			str2 = "产品类";
			break;
		case 4:
			str2 = "背景类";
			break;
		case 5:
			str2 = "服务类";
			break;
		}
		if (str2 == type) {
			str1 = "<option selected='selected'>" + str2 + "</option>";
		} else {
			str1 = "<option>" + str2 + "</option>";
		}
		str = str + str1;
	}
	var str3;
	for (i = 1; i <= 5; i++) {
		if (i == position) {
			var str4 = "<option selected='selected'>" + i + "</option>";
		} else {
			var str4 = "<option>" + i + "</option>";
		}
		str3 = str3 + str4;
	}

	document.getElementById("imgDetail" + mdId6).innerHTML = "<textarea class='cleditor' id='detail"
			+ mdId6 + "' rows='5'></textarea>";
	document.getElementById("detail" + mdId6).innerHTML = detail;
	document.getElementById("imgType" + mdId6).innerHTML = "<select style='width:100%' id='type"
			+ mdId6 + "'>" + str + "</select>";
	document.getElementById("imgPosition" + mdId6).innerHTML = "<select style='width:100%' id='position"
			+ mdId6 + "'>" + str3 + "</select>";
	document.getElementById("modiImg" + mdId6).innerHTML = "<a class='btn btn-primary' style='cursor: pointer;' onclick='confirmModiImg("
			+ mdId6 + ")'><i class='icon-edit icon-white'></i> 确认 </a>";
}

// 确认修改图片信息
function confirmModiImg(chosenId6) {
	var imgDetail = document.getElementById("detail" + chosenId6).value;
	var imgType = document.getElementById("type" + chosenId6).value;
	var imgPosition = document.getElementById("position" + chosenId6).value;
	if (confirm("确定更改此项？") == true) {
		window.location.assign("admin!modifyImage.action?modiId6=" + chosenId6
				+ "&imgDetail1=" + imgDetail + "&imgType1=" + imgType
				+ "&imgPosition1=" + imgPosition);
	} else {
		window.location.assign("admin!showImage.action");
	}
}

// 修改二维码信息
function modiQrcode(mdId7) {
	var name = document.getElementById("qrName" + mdId7).innerHTML;
	var position = document.getElementById("qrPosition" + mdId7).innerHTML;
	document.getElementById("qrName" + mdId7).innerHTML = "<input class='input-xlarge focused' style='width: 95%' id='name"
			+ mdId7 + "' type='text' value=" + name + ">";
	var str = "";
	for (i = 1; i <= 9; i++) {
		var str1;
		if (i == position) {
			str1 = "<option selected='selected'>" + i + "</option>";
		} else {
			str1 = "<option>" + i + "</option>";
		}
		str = str + str1;
	}
	document.getElementById("qrPosition" + mdId7).innerHTML = "<select style='width:100%' id='position"
			+ mdId7 + "'>" + str + "</select>";
	document.getElementById("modiQr" + mdId7).innerHTML = "<a class='btn btn-primary' style='cursor: pointer;' onclick='confirmModiQr("
			+ mdId7 + ")'><i class='icon-edit icon-white'></i> 确认 </a>";
}

// 确认修改二维码信息
function confirmModiQr(chosenId7) {
	var qrName = document.getElementById("name" + chosenId7).value;
	var qrPosition = document.getElementById("position" + chosenId7).value;
	if (confirm("确定更改此项？") == true) {
		window.location.assign("admin!modifyQrcode.action?modiId7=" + chosenId7
				+ "&qrName1=" + qrName + "&qrPosition1=" + qrPosition);
	} else {
		window.location.assign("admin!showQrcode.action");
	}
}