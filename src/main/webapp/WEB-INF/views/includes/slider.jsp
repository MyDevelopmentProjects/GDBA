<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="mp-slider search-only">
    <div class="mp-slider-row">
            <div class="swiper-container">
                <a href="#" class="arrow-left"></a>
                <a href="#" class="arrow-right"></a>
                <div class="swiper-pagination"></div>
                <div class="swiper-wrapper">
                    <c:forEach items="${sliderList}" var="item">
                        <c:if test="${item.active}">
                            <div class="swiper-slide">
                                <div class="slide-section" style="background:url(/upload/files/${item.image}) center top no-repeat;">
                                    <c:if test="${item.captions != null}">
                                        <c:if test="${(language == 'en' ? item.captions.captionOneEN : item.captions.captionOneRU) != null}">
                                            <div class="mp-slider-lbl"> ${language == 'en' ? item.captions.captionOneEN : item.captions.captionOneRU}</div>
                                        </c:if>
                                        <c:if test="${(language == 'en' ? item.captions.captionTwoEN : item.captions.captionTwoRU)!= null}">
                                            <div class="mp-slider-lbl-a">${language == 'en' ? item.captions.captionTwoEN : item.captions.captionTwoRU}</div>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${item.href != null}">
                                        <div class="mp-slider-btn">
                                            <a href="${item.href}" class="btn-a"><fmt:message key="lbl.learn-more"/></a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
    </div>
</div>