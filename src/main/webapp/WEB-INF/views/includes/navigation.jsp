<div class="header-b">
    <div class="mobile-menu">
        <nav>
            <ul>
                <li><a href="/"><fmt:message key="navbar.home" /></a></li>
                <li><a href="/hotel"><fmt:message key="navbar.hotels" /></a></li>
                <li><a class="has-child" href="#"><fmt:message key="navbar.tours"/></a>
                    <ul>
                        <c:forEach items="${navCategoryList}" var="item">
                            <li><a href="tour_alternative.html">${language == 'en' ? item.titles.titleEN:item.titles.titleRU}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="#"><fmt:message key="navbar.flights" /></a></li>
                <li><a href="/about-us"><fmt:message key="navbar.about-us" /></a></li>
                <li><a href="/gallery"><fmt:message key="navbar.gallery" /></a></li>
                <li><a href="/contact"><fmt:message key="navbar.contact" /></a></li>
                <li><a href="/faq"><fmt:message key="navbar.faq" /></a></li>
            </ul>
        </nav>
    </div>
    <div class="wrapper-padding">
        <div class="header-right">
            <div class="hdr-srch-devider"></div>
            <a href="#" class="menu-btn"></a>
            <nav class="header-nav">
                <ul>
                    <li><a href="/"><fmt:message key="navbar.home" /></a></li>
                    <li><a href="/hotel"><fmt:message key="navbar.hotels" /></a></li>
                    <li><a class="has-child" href="#"><fmt:message key="navbar.tours"/></a>
                        <ul>
                            <c:forEach items="${navCategoryList}" var="item">
                                <li>
                                    <a href="/tour/${item.id}/${(language == 'en' ? item.seoURL.seoEN:item.seoURL.seoRU)}">
                                        ${language == 'en' ? item.titles.titleEN:item.titles.titleRU}
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li><a href="#"><fmt:message key="navbar.flights" /></a></li>
                    <li><a href="/about-us"><fmt:message key="navbar.about-us" /></a></li>
                    <li><a href="/gallery"><fmt:message key="navbar.gallery" /></a></li>
                    <li><a href="/contact"><fmt:message key="navbar.contact" /></a></li>
                    <li><a href="/faq"><fmt:message key="navbar.faq" /></a></li>
                </ul>
            </nav>
        </div>
        <div class="clear"></div>
    </div>
</div>