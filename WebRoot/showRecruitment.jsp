<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>mlnx后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- The styles -->
<link id="bs-css" href="css/bootstrap-cerulean.css" rel="stylesheet">
<style type="text/css">
body {
  padding-bottom: 40px;
}

.sidebar-nav {
  padding: 9px 0;
}
</style>

<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/charisma-app.css" rel="stylesheet">
<link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
<link href='css/fullcalendar.css' rel='stylesheet'>
<link href='css/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='css/chosen.css' rel='stylesheet'>
<link href='css/uniform.default.css' rel='stylesheet'>
<link href='css/colorbox.css' rel='stylesheet'>
<link href='css/jquery.cleditor.css' rel='stylesheet'>
<link href='css/jquery.noty.css' rel='stylesheet'>
<link href='css/noty_theme_default.css' rel='stylesheet'>
<link href='css/elfinder.min.css' rel='stylesheet'>
<link href='css/elfinder.theme.css' rel='stylesheet'>
<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='css/opa-icons.css' rel='stylesheet'>
<link href='css/uploadify.css' rel='stylesheet'>
</head>

<body>
  <c:if test="${sessionScope.user==null }">
    <script>
					window.location.href = "MSlogin.jsp";
				</script>
  </c:if>

  <c:if test="${sessionScope.user!=null }">
    <%@include file="top.jsp"%>

    <div class="container-fluid">
      <div class="row">
        <%@include file="left.jsp"%>

        <div class="span10">
          <div class="box span10">
            <div class="box-header well" data-original-title>
              <h2>
                <i class="icon-user"></i> 招聘信息
              </h2>
              <div class="box-icon">
                <a href="#" class="btn btn-setting btn-round"><i
                  class="icon-cog"></i></a> <a href="#"
                  class="btn btn-minimize btn-round"><i
                  class="icon-chevron-up"></i></a> <a href="#"
                  class="btn btn-close btn-round"><i
                  class="icon-remove"></i></a>
              </div>
            </div>
            <div class="box-content">
              <table
                class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                  <tr>
                    <th class="span2">招聘岗位</th>
                    <th class="span3">岗位职责</th>
                    <th class="span3">岗位要求</th>
                    <th class="span1">发布日期</th>
                    <th class="span3">操作</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${recruitments }" var="rec">
                    <tr>
                      <td class="center" id="recruitPost${rec.rid }">${rec.recruitPost
                        }</td>
                      <td class="center" id="recruitDuty${rec.rid }">${rec.recruitDuty
                        }</td>
                      <td class="center" id="recruitClaim${rec.rid }">${rec.recruitClaim
                        }</td>
                      <td class="center" id="recruitTime${rec.rid }"><f:formatDate
                          value="${rec.recruitTime
                        }"
                          pattern="yyyy-MM-dd"></f:formatDate></td>
                      <td class="center"><c:if
                          test="${rec.recruitStatus==0 }">
                          <a class="btn btn-success"
                            href="admin!changeRecruitment.action?status9=0&currId9=${rec.rid }">
                            <i class="icon-ok icon-white"></i> 启用
                          </a>
                        </c:if> <c:if test="${rec.recruitStatus==1 }">
                          <a class="btn btn-warning"
                            href="admin!changeRecruitment.action?status9=1&currId9=${rec.rid }">
                            <i class="icon-remove icon-white"></i> 禁用
                          </a>
                        </c:if><span id="modiRec${rec.rid }"> <a
                          class="btn btn-info" style="cursor: pointer;"
                          onclick="modiRecruitment(${rec.rid })"> <i
                            class="icon-edit icon-white"></i> 修改
                        </a>
                      </span> <a class="btn btn-danger"
                        style="cursor: pointer;"
                        onclick="deleRecruitment(${rec.rid })"> <i
                          class="icon-trash icon-white"></i> 删除
                      </a></td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
            <div align="right">
              <a href="addRecruitment.jsp"><button type="button"
                  class="btn btn-primary">
                  新增 <i class="icon-plus"></i>
                </button></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </c:if>

  <!-- external javascript
	================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->

  <!-- jQuery -->
  <script src="js/jquery-1.7.2.min.js"></script>
  <!-- jQuery UI -->
  <script src="js/jquery-ui-1.8.21.custom.min.js"></script>
  <!-- transition / effect library -->
  <script src="js/bootstrap-transition.js"></script>
  <!-- alert enhancer library -->
  <script src="js/bootstrap-alert.js"></script>
  <!-- modal / dialog library -->
  <script src="js/bootstrap-modal.js"></script>
  <!-- custom dropdown library -->
  <script src="js/bootstrap-dropdown.js"></script>
  <!-- scrolspy library -->
  <script src="js/bootstrap-scrollspy.js"></script>
  <!-- library for creating tabs -->
  <script src="js/bootstrap-tab.js"></script>
  <!-- library for advanced tooltip -->
  <script src="js/bootstrap-tooltip.js"></script>
  <!-- popover effect library -->
  <script src="js/bootstrap-popover.js"></script>
  <!-- button enhancer library -->
  <script src="js/bootstrap-button.js"></script>
  <!-- accordion library (optional, not used in demo) -->
  <script src="js/bootstrap-collapse.js"></script>
  <!-- carousel slideshow library (optional, not used in demo) -->
  <script src="js/bootstrap-carousel.js"></script>
  <!-- autocomplete library -->
  <script src="js/bootstrap-typeahead.js"></script>
  <!-- tour library -->
  <script src="js/bootstrap-tour.js"></script>
  <!-- library for cookie management -->
  <script src="js/jquery.cookie.js"></script>
  <!-- calander plugin -->
  <script src='js/fullcalendar.min.js'></script>
  <!-- data table plugin -->
  <script src='js/jquery.dataTables.min.js'></script>

  <!-- chart libraries start -->
  <script src="js/excanvas.js"></script>
  <script src="js/jquery.flot.min.js"></script>
  <script src="js/jquery.flot.pie.min.js"></script>
  <script src="js/jquery.flot.stack.js"></script>
  <script src="js/jquery.flot.resize.min.js"></script>
  <!-- chart libraries end -->

  <!-- select or dropdown enhancer -->
  <script src="js/jquery.chosen.min.js"></script>
  <!-- checkbox, radio, and file input styler -->
  <script src="js/jquery.uniform.min.js"></script>
  <!-- plugin for gallery image view -->
  <script src="js/jquery.colorbox.min.js"></script>
  <!-- rich text editor library -->
  <script src="js/jquery.cleditor.min.js"></script>
  <!-- notification plugin -->
  <script src="js/jquery.noty.js"></script>
  <!-- file manager library -->
  <script src="js/jquery.elfinder.min.js"></script>
  <!-- star rating plugin -->
  <script src="js/jquery.raty.min.js"></script>
  <!-- for iOS style toggle switch -->
  <script src="js/jquery.iphone.toggle.js"></script>
  <!-- autogrowing textarea plugin -->
  <script src="js/jquery.autogrow-textarea.js"></script>
  <!-- multiple file upload plugin -->
  <script src="js/jquery.uploadify-3.1.min.js"></script>
  <!-- history.js for cross-browser state change on ajax -->
  <script src="js/jquery.history.js"></script>
  <!-- application script for Charisma demo -->
  <script src="js/charisma.js"></script>

  <!-- my js -->
  <script src="js/my.js"></script>
</body>
</html>
