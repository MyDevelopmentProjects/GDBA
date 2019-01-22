
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:message key="placeholder.email" var="placeholderEmail"/>
<fmt:message key="placeholder.textarea" var="placeholderTextarea"/>
<fmt:message key="placeholder.firstName" var="placeholdeFirstName"/>
<fmt:message key="placeholder.lastName" var="placeholderLastName"/>
<fmt:message key="placeholder.telephone" var="placeholderTelephone"/>

<div class="section">
    <!-- Map -->
    <div class="map-holder" id="map-mount-node"></div>

    <!-- Form -->
    <div class="container">
        <div class="grid grid--equal grid--spaced">
            <div class="grid__cell">
                <div class="contact-area">
                    <div class="contact-area__title">
                        <fmt:message key="contact.title"/>
                    </div>
                    <div class="contact-area__content">
                        <form class="form">
                            <div class="form__field">
                                <input class="form__input" type="text" placeholder="<fmt:message key="contact.name"/>" name="name" />
                            </div>
                            <div class="form__field">
                                <input class="form__input" type="text" placeholder="<fmt:message key="contact.details.email"/>" name="email" />
                            </div>
                            <div class="form__field">
                                <textarea class="form__input" placeholder="<fmt:message key="contact.message"/>" name="message"></textarea>
                            </div>
                            <div class="form__field">
                                <button class="form__button" type="submit"><fmt:message key="contact.send"/></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="grid__cell">
                <div class="contact-area">
                    <div class="contact-area__title contact-area__title--bordered">
                        <fmt:message key="contact.details"/>
                    </div>
                    <div class="contact-area__content">
                        <ul class="key-value">
                            <li class="key-value__item">
                                <label class="key-value__label"><fmt:message key="contact.details.email"/></label>
                                <span class="key-value__data">${contactEmail}</span>
                            </li>

                            <li class="key-value__item">
                                <label class="key-value__label"><fmt:message key="contact.details.phone"/></label>
                                <span class="key-value__data">${contactMobileNumber}</span>
                            </li>

                            <li class="key-value__item">
                                <label class="key-value__label"><fmt:message key="contact.details.address"/></label>
                                <span class="key-value__data">${contactAddress}</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function initializeMap() {
        var mapOptions = {
            center: new google.maps.LatLng(41.7113964,44.7826846),
            zoom: 17,
            mapTypeId: 'roadmap'
        };

        var map = new google.maps.Map(document.getElementById('map-mount-node'), mapOptions);

        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(41.7113964,44.7826846),
            map: map
        });

    }
</script>
<script type="text/javascript" src="//maps.google.com/maps/api/js?sensor=false&callback=initializeMap&key=AIzaSyC0J0P9pDQebPqqUuxkfp6hPLFQHrwqFBM"></script>