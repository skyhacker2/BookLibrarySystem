<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<% 
	String tPath = request.getContextPath();
	String tBasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+tPath+"/";
	request.setAttribute("basePath", tBasePath);
%>
<html>
    <head>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>管理员登陆</title>
        <meta name="description" content="Custom Login Form Styling with CSS3" />
        <meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder" />
        <meta name="author" content="Codrops" />

        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="${basePath }css/style.css" />
		<script src="${basePath }js/modernizr.custom.63321.js"></script>
		<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->
		<style>	
			@import url(http://fonts.googleapis.com/css?family=Raleway:400,700);
			body {
				background: #7f9b4e url(${basePath}img/login.jpg) no-repeat center top;
				-webkit-background-size: cover;
				-moz-background-size: cover;
				background-size: cover;
			}
			.container > header h1,
			.container > header h2 {
				color: #fff;
				text-shadow: 0 1px 1px rgba(0,0,0,0.7);
			}
		</style>
    </head>
    <body>
        <div class="container">
			<div class="codrops-top">
                <a href="${basePath }index.do">
                    <strong>&laquo; 返回首页</strong>
                </a>

            </div>
        	<header>
			
				<h1>图书管理系统</h1>

			</header>
			<section class="main">
				<form class="form-4" method="post" action="login.do">
				    <h1>管理员登陆<small style="color:red;">${error }</small></h1>
				    <p>
				        <label for="login">管理员账号</label>
				        <input type="text" name="username" placeholder="管理员账号" required>
				    </p>
				    <p>
				        <label for="password">密码</label>
				        <input type="password" name='password' placeholder="密码" required> 
				    </p>

				    <p>
				        <input type="submit" name="submit" value="登陆">
				    </p>       
				</form>​
			</section>
			
        </div>
    </body>
</html>