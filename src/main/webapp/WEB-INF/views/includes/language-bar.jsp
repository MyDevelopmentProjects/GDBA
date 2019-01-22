<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ge.unknown.security.UserUtils" %>
<div class="header-a">
    <div class="wrapper-padding">
        <div class="header-phone"><span>${contactMobileNumber}</span></div>
        <% if(UserUtils.isAuthenticated()) {%>
        <div class="header-logout">
            <span><a href="/logout">Log Out</a></span>
        </div>
        <% } %>
        <% if(UserUtils.isAuthenticated() && UserUtils.isAdmin()) {%>
        <div class="header-logout">
            <span><a href="/admin">Admin Panel</a></span>
        </div>
        <% } %>
        <div class="header-account">
            <% if(UserUtils.isAuthenticated()) {%>
                <a href="#" class="auth-inner-page"><%=UserUtils.currentUser().getFirstName()%> <%=UserUtils.currentUser().getLastName()%>  </a>
            <% } else { %>
                <a href="#" class="auth-login-modal"><fmt:message key="account.my"/> </a>
            <% } %>
        </div>
        <% if(UserUtils.isAuthenticated()) {%>
        <div class="header-viewed">
            <a href="#" class="header-viewed-btn"><fmt:message key="account.cardlist"/></a>
            <div class="viewed-drop">
                <div class="viewed-drop-a">
                    <c:forEach items="${userCardList}" var="item">
                        <div class="viewed-item">
                            <div class="viewed-item-l">
                                <a href="#">
                                    <img alt="" src="${item.image}"/>
                                </a>
                            </div>
                            <div class="viewed-item-r">
                                <div class="viewed-item-lbl">
                                    <a href="#">
                                        ${language == 'en' ? item.translation.titleEN : item.translation.titleRU}
                                    </a>
                                </div>
                                <div class="viewed-item-cat">
                                    <fmt:message key="lbl.location"/> :
                                    ${ language == 'en' ? item.city.titles.titleEN : item.city.titles.titleRU}
                                </div>
                                <div class="viewed-price">152$</div>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <% } %>
        <div class="header-lang">
            <a href="#"><img alt="" src="/img/en.gif"/></a>
            <div class="langs-drop">
                <div><a href="/?lang=en" class="langs-item en"><fmt:message key="language.en"/></a></div>
                <div><a href="/?lang=ru" class="langs-item ru"><fmt:message key="language.ru"/></a></div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>