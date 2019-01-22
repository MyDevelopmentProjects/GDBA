<fmt:message key="search.hotel.name" var="placeHolderHotelName"/>
<div class="wrapper-a-holder full-width-search">
    <div class="wrapper-a">
        <div class="page-search full-width-search search-type-b">
            <div class="search-type-padding">
                <nav class="page-search-tabs">
                    <div class="search-tab active"><fmt:message key="navbar.tours"/></div>
                    <div class="search-tab"><fmt:message key="navbar.hotels"/></div>
                    <div class="clear"></div>
                </nav>
                <div class="page-search-content">
                    <div class="search-tab-content">
                        <form action="/tour">
                            <div class="page-search-p">
                                <div class="search-large-i">
                                    <div class="srch-tab-line no-margin-bottom">
                                        <label><fmt:message key="search.tour.category"/></label>
                                        <div class="select-wrapper">
                                            <select class="custom-select">
                                                <option>- Select Category-</option>
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="search-large-i">
                                    <div class="srch-tab-line no-margin-bottom">
                                        <div class="srch-tab-left">
                                            <label><fmt:message key="search.tour.datefrom"/></label>
                                            <div class="input-a"><input type="text" value="" class="date-inpt"
                                                                        placeholder="mm/dd/yy"> <span
                                                    class="date-icon"></span></div>
                                        </div>
                                        <div class="srch-tab-right">
                                            <label><fmt:message key="search.tour.dateto"/></label>
                                            <div class="input-a"><input type="text" value="" class="date-inpt"
                                                                        placeholder="mm/dd/yy"> <span
                                                    class="date-icon"></span></div>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <div class="search-large-i">
                                    <div class="srch-tab-line no-margin-bottom">
                                        <div class="srch-tab-left transformed">
                                            <label><fmt:message key="search.tour.qty"/></label>
                                            <div class="select-wrapper">
                                                <select class="custom-select">
                                                    <option>--</option>
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="srch-tab-right transformed">
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <div class="clear"></div>
                            </div>
                            <footer class="search-footer">
                                <button type="submit" class="srch-btn"><fmt:message key="btn.search"/></button>
                            </footer>
                        </form>
                    </div>
                    <div class="search-tab-content">
                        <form action="/hotel">
                            <div class="page-search-p">
                                <div class="search-large-i">
                                    <div class="srch-tab-line no-margin-bottom">
                                        <label><fmt:message key="search.hotel.name"/></label>
                                        <div class="input-a"><input type="text" name="searchExpression"
                                                                    placeholder="${placeHolderHotelName}"></div>
                                    </div>
                                </div>
                                <div class="search-large-i">
                                    <div class="srch-tab-line no-margin-bottom">
                                        <div class="srch-tab-left transformed">
                                            <label><fmt:message key="search.hotel.stars"/></label>
                                            <div class="select-wrapper">
                                                <select class="custom-select">
                                                    <option value="-1" name="starCount">--</option>
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <div class="search-large-i">
                                    <div class="srch-tab-line no-margin-bottom">
                                        <div class="srch-tab-3c">
                                            <label><fmt:message key="search.hotel.rooms"/></label>
                                            <div class="select-wrapper">
                                                <select class="custom-select" name="roomCount">
                                                    <option value="-1">--</option>
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="srch-tab-3c">
                                            <label><fmt:message key="search.hotel.adult"/></label>
                                            <div class="select-wrapper">
                                                <select class="custom-select" name="adultAmount">
                                                    <option value="-1">--</option>
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="srch-tab-3c">
                                            <label><fmt:message key="search.hotel.child"/></label>
                                            <div class="select-wrapper">
                                                <select class="custom-select" name="childrenAmount">
                                                    <option value="-1">--</option>
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <div class="clear"></div>
                                <div class="search-asvanced">
                                    <div class="clear"></div>
                                </div>
                            </div>
                            <footer class="search-footer">
                                <button type="submit" class="srch-btn"><fmt:message key="btn.search"/></button>
                            </footer>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>