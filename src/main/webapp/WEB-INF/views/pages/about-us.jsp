<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="HtmlTruncator" uri="/WEB-INF/tlds/HtmlTruncator" %>


<!-- Subheader Container -->
<div class="section section--grey section--fixed">
    <div class="section__body">
        <div class="container">
            <!-- Main Slider -->
            <div class="large-slider">
                <div class="main-slider-about">
                    <c:forEach items="${sliderList}" var="item">
                        <div>
                            <div class="content-slider content-slider--full">
                                <div class="content-slider__wrapper">

                                    <c:if test="${item.video == false}">
                                        <c:set var="bgimg" value="/uploads/${item.image}"/>
                                        <c:set var="video_path" value=""/>
                                    </c:if>
                                    <c:if test="${item.video == true && item.image != null}">
                                        <c:set var="video_id" value="${fn:split(item.image, 'v=')[1]}"/>
                                        <c:set var="video_path" value="${fn:split(video_id, '&')[0]}"/>
                                        <c:set var="bgimg"
                                               value="//img.youtube.com/vi/${video_path}/0.jpg"/>
                                        <img video-uri="https://www.youtube.com/embed/${video_path}" class="youvideo"
                                             src="/assets/images/youtube.png"/>
                                    </c:if>

                                    <div data-display="" class="content-slider__slide"
                                         style="background-image: url(${bgimg})">
                                        <div data-display="" class="content-slider__slide">
                                            <div class="slider-details slider-details--right">
                                                <div class="slider-details__content">
                                                    <div class="slider-details__content-wrap">
                                                        <p class="slider-details__date">
                                                            <fmt:formatDate value="${item.dateCreated}"
                                                                            pattern="dd-MM-yyyy"/>
                                                        </p>
                                                        <h2 class="slider-details__body">
                                                            <a href="#">
                                                                    ${language == 'en' ? item.captions.captionOneEN : item.captions.captionOneRU}
                                                                    ${fn:substring((language == 'en' ? item.captions.captionTwoEN : item.captions.captionTwoRU), 0, 33)}...
                                                            </a>
                                                        </h2>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="section">
    <div class="container">
        <div class="section__title section__title--big">
            <ul class="breadcrumbs">
                <li><a href="/"><fmt:message key="navbar.home"/></a></li>
                <li><a><fmt:message key="navbar.about-us"/></a></li>
            </ul>
        </div>
        <%--<h1>${language == 'en' ? data.details.titleEN : data.details.titleRU}</h1>--%>
        <div class="section__body">
            ${language == 'en' ? data.details.descriptionEN : data.details.descriptionRU}
        </div>
    </div>
</section>

<%@include file="../includes/videoFrame.jsp" %>

<script>

    document.addEventListener("DOMContentLoaded", function (event) {
        tns({
            container: '.main-slider-about',
            mode: 'gallery',
            items: 1,
            slideBy: 'page',
            nav: true,
            autoplay: true,
            autoplayHoverPause: true
        });
    });


</script>