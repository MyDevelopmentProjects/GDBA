<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>GDBA | Login</title>
    <meta name="description" content="Admin, Dashboard, Bootstrap, Bootstrap 4, Angular, AngularJS"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimal-ui"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- for ios 7 style, multi-resolution icon of 152x152 -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-barstyle" content="black-translucent">
    <link rel="apple-touch-icon" href="/assets/images/logo.png">
    <meta name="apple-mobile-web-app-title" content="Admin">
    <!-- for Chrome on Android, multi-resolution icon of 196x196 -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="shortcut icon" sizes="196x196" href="/assets/images/logo.png">

    <link rel="stylesheet" href="/assets/bootstrap/dist/css/bootstrap.min.css" type="text/css"/>
    <!-- build:css ../assets/styles/app.min.css -->
    <link rel="stylesheet" href="/assets/styles/app.css" type="text/css"/>
    <!-- endbuild -->
    <link rel="stylesheet" href="/assets/styles/font.css" type="text/css"/>
    <link rel="stylesheet" href="/assets/fonts/geo/font.css" type="text/css"/>
    <c:if test="${not empty error}">
        <style>
            #errorDialog {
                display: block;
            }
        </style>
    </c:if>
</head>
<body class="pace-done dark bg-auto">
<div class="app">
    <div id="sign-in-div" class="main-area center-block w-xxl w-auto-xs p-y-md">
        <%--        <div class="navbar">
                    <div class="logo-login">
                        <img src="/assets/images/logo-login.png"/>
                    </div>
                </div>--%>
        <div class="p-a-md box-color r box-shadow-z1 text-color m-a">
            <div class="m-b text-sm">
                შეიყვანეთ მომხმარებელი და პაროლი
            </div>
            <form name="form" id="loginFrm"  action="<c:url value='/auth/login' />" method="post">
                <input type="hidden"
                       name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <div class="md-form-group float-label">
                    <input type="text" class="md-input" placeholder="მომხმარებელი" name="username" required>
                </div>
                <div class="md-form-group float-label">
                    <input type="password" class="md-input" placeholder="პაროლი" name="password"
                           autocomplete="new-password" required>
                </div>
                <div class="m-b-md">
                    <label class="md-check">
                        <input type="checkbox"><i class="primary"></i> დამიმახსოვრე
                    </label>
                </div>
                <button type="submit" class="btn primary btn-block p-x-md">შესვლა</button>
            </form>
        </div>
        <%--        <div class="p-v-lg text-center">
                    <div class="m-b"><a href="#/forgot-pwd"
                                        class="text-primary _600">
                        დაგავიწყდა პაროლი?</a></div>
                    <div>არ ხარ რეგისტრირებული? <a href="#/sign-up" class="text-primary _600">რეგისტრაცია</a>
                    </div>
                </div>--%>
    </div>
</div>
</body>
</html>