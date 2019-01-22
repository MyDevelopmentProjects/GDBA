<fmt:message key="placeholder.firstName" var="placeholderFirstName"/>
<fmt:message key="placeholder.lastName" var="placeholderLastName"/>
<fmt:message key="placeholder.name" var="placeholderName"/>
<fmt:message key="placeholder.password" var="placeholderPassword"/>

<div class="overlay"></div>
<div class="autorize-popup">
    <div class="autorize-tabs">
        <a href="#" class="autorize-tab-a current"><fmt:message key="auth.modal.signin"/> </a>
        <a href="#" class="autorize-tab-b"><fmt:message key="auth.modal.register"/></a>
        <a href="#" class="autorize-close"></a>
        <div class="clear"></div>
    </div>
    <section class="autorize-tab-content">
        <div class="autorize-padding">
            <div id="auth-form">
                <h6 class="autorize-lbl"><fmt:message key="auth.modal.welcome-text"/></h6>
                <div id="auth-message-box" class="message-box-b" style="display: none"></div>
                <input id="auth-username" class="lg-input" type="text" placeholder="${placeholderName}">
                <input id="auth-password" class="lg-input" type="password" placeholder="${placeholderPassword}">
                <footer class="autorize-bottom">
                    <button id="auth-btn" class="authorize-btn"><fmt:message key="auth.modal.login"/></button>
                    <a href="#" class="authorize-forget-pass"><fmt:message key="auth.modal.forgot-password"/> </a>
                    <div class="clear"></div>
                </footer>
            </div>
        </div>
    </section>
    <section class="autorize-tab-content">
        <div class="autorize-padding">
            <h6 class="autorize-lbl"><fmt:message key="auth.modal.register-account"/></h6>
            <div id="reg-message-box" class="message-box-b" style="display: none"></div>
            <input id="reg-firstName" class="lg-input" type="text" placeholder="${placeholderFirstName}">
            <input id="reg-lastName" class="lg-input" type="text" placeholder="${placeholderLastName}">
            <input id="reg-username" class="lg-input" type="text" placeholder="${placeholderName}">
            <input id="reg-password" class="lg-input" type="text" placeholder="${placeholderPassword}">
            <footer class="autorize-bottom">
                <button id="reg-btn" class="authorize-btn"><fmt:message key="auth.modal.registration"/></button>
                <div class="clear"></div>
            </footer>
        </div>
    </section>
</div>
