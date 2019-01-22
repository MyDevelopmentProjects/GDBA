<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="HtmlTruncator" uri="/WEB-INF/tlds/HtmlTruncator" %>

<section class="section section--dynamic" id="partners-rotator">
    <div class="container">
        <div class="section__title section__title--sm-pad section__title--big">
            <h1>Partners</h1>
            <ul class="breadcrumbs">
                <li><a href="/"><fmt:message key="navbar.home"/></a></li>
                <li><a><fmt:message key="home.partners.title"/></a></li>
            </ul>
        </div>
        <div class="section__actions">
            <div class="carousel-actions">
                <div class="lr-controls">
                    <i data-back class="icon icon-chevr-left"></i>
                    <i data-next class="icon icon-chevr-right active"></i>
                </div>
            </div>
        </div>
        <div class="section__body">
            <div class="banner-rotator">
                <c:forEach items="${topPartnersList}" var="item">
                    <div class="banner-rotator__slide banner-rotator__slide--show banner-rotator__slide--fadein"
                         data-color="${item.bgColor != null ? item.bgColor : 'cccccc'}">
                        <img class="partner__logo partner__logo--big" src="uploads/${item.image}"
                             alt="${language == 'en' ? item.captions.captionOneEN : item.captions.captionOneRU}"/>
                    </div>
                </c:forEach>
            </div>
            <div class="st-controls">
                <ul class="bullet-list bullet-list--overlay">
                </ul>
            </div>
        </div>
    </div>
</section>

<section class="section section--separator">
    <div class="container">
        <div class="section__body">
            <div class="grid grid--wrapping grid--threes grid--spaced news-listing">
                <c:forEach items="${partnersList}" var="item">
                    <div class="grid__cell">
                        <div class="partner partner--grey" data-title="${language == 'en' ? item.captions.captionOneEN : item.captions.captionOneRU}">
                            <img class="partner__logo" src="uploads/${item.image}" alt="${language == 'en' ? item.captions.captionOneEN : item.captions.captionOneRU}"/>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>

<script src="assets/js/slider.js"></script>

<script>
    new ColorfulSlider(document.querySelector('#partners-rotator'));
</script>