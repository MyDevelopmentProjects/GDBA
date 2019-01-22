<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="h-help">
    <div class="h-help-lbl"><fmt:message key="contact.need-help"/></div>
    <div class="h-help-lbl-a"><fmt:message key="contact.we-would-be-happy"/></div>
    <div class="h-help-phone">${contactMobileNumber}</div>
    <div class="h-help-email">${contactEmail}</div>
</div>