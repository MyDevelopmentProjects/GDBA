<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="HtmlTruncator" uri="/WEB-INF/tlds/HtmlTruncator" %>

<!-- Subheader Container -->
<div class="section section--grey section--fixed">
    <div class="section__body">
        <div class="container">
            <!-- New Slider -->
            <div class="large-slider">
                <div class="main-slider">
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
                                        <c:set var="bgimg" value="//img.youtube.com/vi/${video_path}/0.jpg"/>
                                        <img video-uri="https://www.youtube.com/embed/${video_path}" class="youvideo"
                                             src="/assets/images/youtube.png"/>
                                    </c:if>
                                    <div data-display="" class="content-slider__slide" style="background-image: url(${bgimg})">
                                        <div data-display="" class="content-slider__slide">
                                            <div class="slider-details slider-details--right">
                                                <div class="slider-details__content">
                                                    <div class="slider-details__content-wrap">
                                                        <p class="slider-details__date">
                                                            <fmt:formatDate value="${item.dateCreated}" pattern="dd-MM-yyyy"/>
                                                        </p>
                                                        <h2 class="slider-details__body">
                                                            <a href="${empty item.href ? '#':item.href}">
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

<!-- Services section -->
<section class="section">
    <div class="container">
        <h3 class="section__title">
            <fmt:message key="home.services.title"/>
        </h3>
        <div class="section__body">
            <div class="grid grid--equal grid--spaced">
                <div class="grid__cell">
                    <article class="article article--yellow">
                        <header class="article__title">
                            <a href="news/${serviceNews[0].news.id}">
                                ${language == 'en' ? serviceNews[0].details.titleEN : serviceNews[0].details.titleRU}
                            </a>
                        </header>
                        <section class="article__body">
                            ${language == 'en' ? serviceNews[0].details.descriptionEN : serviceNews[0].details.descriptionRU}
                        </section>
                    </article>
                </div>
                <div class="grid__cell">
                    <article class="article article--green">
                        <header class="article__title">
                            <a href="news/${serviceNews[1].news.id}">
                                ${language == 'en' ? serviceNews[1].details.titleEN : serviceNews[1].details.titleRU}
                            </a>
                        </header>
                        <section class="article__body">
                            ${language == 'en' ? serviceNews[1].details.descriptionEN : serviceNews[1].details.descriptionRU}
                        </section>
                    </article>
                </div>
                <div class="grid__cell">
                    <article class="article article--red">
                        <header class="article__title">
                            <a href="news/${serviceNews[2].news.id}">
                                ${language == 'en' ? serviceNews[2].details.titleEN : serviceNews[2].details.titleRU}
                            </a>
                        </header>
                        <section class="article__body">
                            ${language == 'en' ? serviceNews[2].details.descriptionEN : serviceNews[2].details.descriptionRU}
                        </section>
                    </article>
                </div>
                <div class="grid__cell">
                    <article class="article article--orange">
                        <header class="article__title">
                            <a href="news/${serviceNews[3].news.id}">
                                ${language == 'en' ? serviceNews[3].details.titleEN : serviceNews[3].details.titleRU}
                            </a>
                        </header>
                        <section class="article__body">
                            ${language == 'en' ? serviceNews[3].details.descriptionEN : serviceNews[3].details.descriptionRU}
                        </section>
                    </article>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- News section -->
<section class="section section--black">
    <div class="container">
        <div class="section__title section__title--sm-pad">
            <fmt:message key="home.news_opinion.title"/>
        </div>
        <div class="section__actions">
            <div class="carousel-actions">
                <div class="lr-controls inverted news-slider-arrows">
                    <i class="icon icon-chevr-left active"></i>
                    <i class="icon icon-chevr-right active"></i>
                </div>
            </div>
        </div>
        <div class="section__body">
            <div class="news-slider">
                <c:forEach items="${last9news}" var="item">
                    <div>
                        <div class="carousel-item">
                            <div class="carousel-item__date">
                                <fmt:formatDate value="${item.dateCreated}" pattern="dd-MM-yyyy"/>
                            </div>
                            <a href="/news/${item.id}" class="carousel-item__display">
                                <img src="/uploads/${item.imageURL}">
                            </a>
                            <div class="carousel-item__body">
                                <a href="#" class="carousel-item__title">
                                   ${language == 'en' ? item.details.titleEN : item.details.titleRU}
                                </a>
                                <span class="carousel-item__descr">
                                   <%--${fn:substring((language == 'en' ? item.details.descriptionEN : item.details.descriptionRU), 0, 50)}...--%>
                                </span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="silder-static-controls"></div>

        </div>
    </div>
</section>

<!-- Partners section-->
<section class="section">
    <div class="container">
        <div class="section__title section__title--sm-pad">
            <fmt:message key="home.partners.title"/>
        </div>
        <div class="section__actions">
            <div class="carousel-actions">
                <div class="lr-controls partners-slider-arrows">
                    <i data-prev class="icon icon-chevr-left active"></i>
                    <i data-next class="icon icon-chevr-right active"></i>
                </div>
            </div>
        </div>
        <div class="section__body centered-nav">

            <fmt:parseNumber var="size" integerOnly="true" type="number" value="${fn:length(partnersList)}"/>
            <fmt:parseNumber var="divSize" integerOnly="true" type="number" value="${size / 10}"/>
            <fmt:parseNumber var="maxDivSize" integerOnly="true" type="number" value="${divSize < 1 ? 1 : (size % 10 == 0 ? divSize : divSize + 1)}"/>

            <div class="partners-slider">
                <c:forEach begin="0" end="${maxDivSize - 1}" var="i">
                    <div>
                        <div class="grid grid--wrapping grid--fives">
                            <fmt:parseNumber var="start" integerOnly="true" type="number" value="${i * 10}"/>
                            <fmt:parseNumber var="end" integerOnly="true" type="number" value="${start + (i == (maxDivSize - 1) ? (size - start < 10 ? size - start - 1 : 9) : 9) }"/>
                            <c:forEach begin="${start}" end="${end}" var="j">
                                <a href="${empty partnersList[j].href ? '#':partnersList[j].href}" target="_blank" class="grid__cell">
                                    <div class="partner">
                                        <img class="partner__logo" src="/uploads/${partnersList[j].image}"/>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="silder-static-controls"></div>
        </div>
    </div>
</section>

<%@include file="../includes/videoFrame.jsp" %>
<script>
    document.addEventListener("DOMContentLoaded", function (event) {
        loadMainPage()
    });
</script>