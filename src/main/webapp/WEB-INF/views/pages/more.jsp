<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<section class="section section--black" id="image-slider">
    <div class="container">
        <div class="section__title section__title--sm-pad section__title--big">
            <h1>news</h1>
            <ul class="breadcrumbs">
                <li><a href="/">home page</a></li>
                <li><a href="/news">news</a></li>
            </ul>
        </div>
        <div class="section__actions">
            <div class="carousel-actions" style="display: none;">
                <div class="lr-controls">
                    <i data-back class="icon icon-chevr-left"></i>
                    <i data-next class="icon icon-chevr-right active"></i>
                </div>
            </div>
        </div>

        <div class="section__body">
            <div class="carousel-item carousel-item--massive">
                <div class="carousel-item__display image-slider">
                    <img class="image-slider__slide" src="/uploads/${data.imageURL}">
                    <%--<img class="image-slider__slide" src="http://fillmurray.com/1150/470" />
                    <img class="image-slider__slide" src="http://fillmurray.com/1150/475" />--%>
                </div>
                <div class="carousel-item__body">
                          <span href="#" class="carousel-item__title">
                              ${language == 'en' ? data.details.titleEN : data.details.titleRU}
                          </span>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- News section -->
<section class="section section--separator">
    <div class="container">
        <div class="section__body">
            <div class="carousel-item__date carousel-item__date--standalone">
                <fmt:formatDate value="${data.dateCreated}"
                                pattern="dd-MM-yyyy"/>
            </div>
            <div class="news-body">
                ${language == 'en' ? data.details.descriptionEN : data.details.descriptionRU}
            </div>
        </div>
    </div>
</section>

<script src="/assets/js/image-slider.js"></script>
<script>
    new ImageSlider(document.getElementById('image-slider'));
</script>