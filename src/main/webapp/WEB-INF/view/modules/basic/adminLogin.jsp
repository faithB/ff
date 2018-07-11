<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2017/2/19
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/modules/basic/tags.jsp"%>
<html>
<head>
    <title>管理员登录</title>
    <%@ include file="head.jsp" %>
    <link rel="stylesheet" href="<%=ctx%>/statics/css/font-awesome.min.css" />
    <link rel="stylesheet" href="<%=ctx%>/statics/css/ace.min.css" />
    <link rel="stylesheet" href="<%=ctx%>/statics/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
</head>
<body class="login-layout">
<div class="space-30"></div>
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>
                            <span class="red">Ace</span>
                            <span class="white">Application</span>
                        </h1>
                        <h4 class="blue">&copy; Company Name</h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>
                                        欢迎
                                    </h4>

                                    <div class="space-6"></div>

                                    <form id="loginForm" action="<%=ctx%>/admin/index" method="post">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="请输入账号" name="account" value="${admin.account}"/>
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="请输入密码" name="password" value="${admin.password}"/>
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <div class="space"></div>
                                            <c:if test="${message!=null}">
                                                <div class="alert alert-warning alert-dismissible" role="alert">
                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                   ${message}
                                                </div>
                                            </c:if>

                                            <div class="clearfix">
                                                <label class="inline">
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl"> Remember Me</span>
                                                </label>

                                                <button type="button" class="width-35 pull-right btn btn-sm btn-primary" onclick="validate(this.form)">
                                                    <i class="icon-key"></i>
                                                    Login
                                                </button>
                                            </div>
                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>
                                </div><!-- /widget-main -->
                            </div><!-- /widget-body -->
                        </div><!-- /login-box -->
                    </div><!-- /position-relative -->
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div>
</div><!-- /.main-container -->
</body>
<script type="application/javascript">
    function validate(form){
        if(form.account.value==''){
            alert('请输入账号↖(^ω^)↗');
            form.account.focus();
            return false;
        }
        if(form.password.value==''){
            alert('请输入密码↖(^ω^)↗')
            form.password.focus();
            return false;
        }
        form.submit();
    }
</script>
</html>
