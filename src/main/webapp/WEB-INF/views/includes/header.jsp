<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="${language}">
<head>
    <meta charset="utf-8" />
    <title><fmt:message key="title.news"/></title>
    <!--<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=1"/>-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
    <meta property="Copyright" content="Copyright GDBA 2017. All Rights Reserved."/>

    <link rel="icon" href="/assets/favicon.ico">

    <link rel="stylesheet" href="/assets/css/normalize.css" />
    <link rel="stylesheet" href="/assets/css/fonts.css" />
    <link rel="stylesheet" href="/assets/css/tiny-slider.css" />
    <link rel="stylesheet" href="/assets/css/layout.css" />
</head>
<body>
<!-- Header -->
<header class="header">
    <div class="container container--full-h">
        <div class="header-wrap">
            <div class="header-logo">
                <a href="#" class="logo-wrap">
                    <span class="logo-wrap__img"></span>
                    <span class="logo-wrap__txt">gdba</span>
                </a>
            </div>
            <div class="header-navigation">
                <ul class="nav-menu">
                    <li class="nav-menu__item ${loadPageContent == 'main' ? 'active' : ''}">
                        <a href="/"><fmt:message key="navbar.home"/></a>
                    </li>
                    <li class="nav-menu__item ${loadPageContent == 'about-us' ? 'active' : ''}">
                        <a href="/about-us"><fmt:message key="navbar.about-us"/></a>
                    </li>
                    <li class="nav-menu__item ${loadPageContent == 'news' ? 'active' : ''}">
                        <a href="/news"><fmt:message key="navbar.news"/></a>
                    </li>
                    <li class="nav-menu__item ${loadPageContent == 'partners' ? 'active' : ''}">
                        <a href="/members"><fmt:message key="navbar.members"/></a>
                    </li>
                    <li class="nav-menu__item ${loadPageContent == 'contact' ? 'active' : ''}">
                        <a href="/contact"><fmt:message key="navbar.contact"/></a>
                    </li>

                    <li class="nav-menu__item nav-menu__item--right ${(language == 'en' ? 'active' : '')} ">
                        <a href="/?lang=en">en</a>
                    </li>
                    <li class="nav-menu__item nav-menu__item--right ${(language == 'ge' ? 'active' : '')}">
                        <a href="/?lang=ge">ge</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
