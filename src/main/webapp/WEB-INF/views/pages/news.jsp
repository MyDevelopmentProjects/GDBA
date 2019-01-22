<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tlds/Paginator" %>
<%@ taglib prefix="HtmlTruncator" uri="/WEB-INF/tlds/HtmlTruncator" %>
<section class="section section--black">
    <div class="container">
        <div class="section__title section__title--sm-pad section__title--big">
            <h1>news</h1>
            <ul class="breadcrumbs">
                <li><a href="/"><fmt:message key="navbar.home"/></a></li>
                <li><a><fmt:message key="navbar.news"/></a></li>
            </ul>
        </div>
        <div class="section__actions">
            <div class="carousel-actions">
                <div class="lr-controls inverted news-inner-slider-arrows">
                    <i class="icon icon-chevr-left active"></i>
                    <i class="icon icon-chevr-right active"></i>
                </div>
            </div>
        </div>
        <div class="section__body">
            <div class="news-inner-slider">

                <c:forEach items="${sliderList}" var="item">
                    <div>
                        <div class="carousel-item carousel-item--big carousel-item--shaded">
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
                            <div class="carousel-item__date">
                                <fmt:formatDate value="${item.dateCreated}"
                                                pattern="dd-MM-yyyy"/>
                            </div>
                            <a href="${item.href}" class="carousel-item__display">
                                <img src="${bgimg}"/>
                            </a>
                            <div class="carousel-item__body">
                                <a class="carousel-item__title" href="${empty item.href ? '#':item.href}">
                                        ${language == 'en' ? item.captions.captionOneEN : item.captions.captionOneRU}
                                </a>
                                <span class="carousel-item__descr">
                                  ${fn:substring((language == 'en' ? item.captions.captionTwoEN : item.captions.captionTwoRU), 0, 33)}...
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

<!-- News section -->
<section class="section section--separator">
    <div class="container">
        <div class="section__body">
            <div class="grid grid--wrapping grid--threes grid--spaced news-listing">
                <c:forEach items="${data.results}" var="item">
                    <div class="grid__cell">
                        <div class="carousel-item">
                            <div class="carousel-item__date">
                                <fmt:formatDate value="${item.dateCreated}"
                                                pattern="dd-MM-yyyy"/>
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

            <c:if test="${not empty data.results}">
                <pagination:display uri="/news"
                                    currPage="${ empty param.pageNumber ? 0:param.pageNumber}"
                                    maxPage="${data.maxPages}"
                                    totalItems="${data.total}"/>
            </c:if>

            <div>
            </div>
        </div>
    </div>
    </div>
</section>

<%@include file="../includes/videoFrame.jsp" %>
<script>
    document.addEventListener("DOMContentLoaded", function (event) {
        var newsSlider = tns({
            container: '.news-inner-slider',
            items: 2,
            slideBy: 'page',
            nav: true,
            gutter: 50
        });

        var newsSliderArrows = document.querySelector('.news-inner-slider-arrows');
        newsSliderArrows.querySelector('.icon-chevr-left').addEventListener('click', function () {
            newsSlider.goTo('prev');
        });

        newsSliderArrows.querySelector('.icon-chevr-right').addEventListener('click', function () {
            newsSlider.goTo('next');
        });
    });
</script>