(function () {
    'use strict';
    angular
        .module('app')
        .run(runBlock)
        .constant('urls', {
            BASE_API: '/'
        })
        .config(config);

    runBlock.$inject = ['$rootScope', '$state', '$stateParams'];
    function runBlock($rootScope, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    }

    config.$inject = ['$stateProvider', '$urlRouterProvider', 'MODULE_CONFIG'];
    function config($stateProvider, $urlRouterProvider, MODULE_CONFIG) {

        $urlRouterProvider.otherwise('/app/dashboard');

        $stateProvider
            .state('app', {
                abstract: true,
                url: '/app',
                views: {
                    '': {
                        templateUrl: '/view/Default/aside.html'
                    }
                }
            })
            .state('app.dashboard', {
                url: '/dashboard',
                templateUrl: '/view/Default/index.html',
                data: {title: 'მთავარი გვერდი'},
                controller: 'DefaultController',
                resolve: {
                    loadMyFiles: function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name: "app",
                            files: [
                                "js/ng/controllers/DefaultController.js"
                            ]
                        });
                    }
                }
            })

            // main state
            .state('app.main', {
                url: '/main',
                template: '<div ui-view></div>'
            })
            .state('app.main.about', {
                url: '/about',
                templateUrl: '/view/About/index.html',
                data: {title: 'ჩვენი შესახებ'},
                controller: 'AboutController',
                resolve: load(["summernote", "js/ng/controllers/AboutController.js"])
            })
            .state('app.main.agency', {
                url: '/agency',
                templateUrl: '/view/Agency/index.html',
                data: {title: 'ჩვენი სააგენტო'},
                controller: 'AgencyController',
                resolve: load([
                    'icon-picker',
                    'js/ng/controllers/AgencyController.js'
                ])
            })
            .state('app.main.why-us', {
                url: '/why-us',
                templateUrl: '/view/WhyUs/index.html',
                data: {title: 'რატომ ჩვენ'},
                controller: 'WhyUsController',
                resolve: load([
                    'icon-picker',
                    'js/ng/controllers/WhyUsController.js'
                ])
            })
            .state('app.main.team', {
                url: '/team',
                templateUrl: '/view/Team/index.html',
                data: {title: 'ჩვენი გუნდი'},
                controller: 'TeamController',
                resolve: load([
                    'js/ng/controllers/TeamController.js'
                ])
            })
            .state('app.main.slider', {
                url: '/slider',
                templateUrl: '/view/Slider/index.html',
                data: {title: 'სლაიდერი'},
                controller: 'SliderController',
                resolve: load([
                    'js/ng/controllers/SliderController.js'
                ])
            })
            // hotel state
            .state('app.hotels', {
                url: '/hotels',
                template: '<div ui-view></div>'
            })
            .state('app.hotels.list', {
                url: '/hotel',
                templateUrl: '/view/Hotel/index.html',
                data: {title: 'სასტუმროების სია'},
                controller: 'HotelController',
                resolve: load(
                    [
                        'ui.map',
                        'summernote',
                        'js/ng/controllers/load-google-maps.js',
                        'js/ng/controllers/HotelController.js'
                    ],
                    function () {
                        return loadGoogleMaps();
                    }
                )
            })
            .state('app.hotels.faq', {
                url: '/faq',
                templateUrl: '/view/Hotel/hotelFaq.html',
                data: {title: 'სასტუმროს FAQ'},
                controller: 'HotelFaqController',
                resolve: load([
                    'js/ng/controllers/HotelFaqController.js'
                ])
            })
            // tours state
            .state('app.news', {
                url: '/news',
                template: '<div ui-view></div>'
            })
            // tours state
            .state('app.news.list', {
                url: '/list',
                templateUrl: '/view/News/index.html',
                data: {title: 'სიახლლების ჩამონათვალი'},
                controller: 'NewsController',
                resolve: load([
                    'js/ng/controllers/NewsController.js'
                ])
            })
            .state('app.services', {
                url: '/services',
                templateUrl: '/view/Services/index.html',
                data: {title: 'სერვისების ჩამონათვალი'},
                controller: 'ServicesController',
                resolve: load([
                    'js/ng/controllers/ServicesController.js'
                ])
            })
            .state('app.tours.category', {
                url: '/category',
                templateUrl: '/view/Category/index.html',
                data: {title: 'კატეგორიის ჩამონათვალი'},
                controller: 'CategoryController',
                resolve: load([
                    'js/ng/controllers/CategoryController.js'
                ])
            })
            .state('app.tours.faq', {
                url: '/faq',
                templateUrl: '/view/Tour/tourFaq.html',
                data: {title: 'ტურის FAQ'},
                controller: 'TourFaqController',
                resolve: load([
                    'js/ng/controllers/TourFaqController.js'
                ])
            })
            .state('app.faq', {
                url: '/faq',
                templateUrl: '/view/Faq/index.html',
                data: {title: 'ხ.დ.კ'},
                controller: 'FaqController',
                resolve: load([
                    'js/ng/controllers/FaqController.js'
                ])
            })
            .state('app.contact', {
                url: '/contact',
                templateUrl: '/view/Contact/index.html',
                data: {title: 'კონტაქტი'},
                controller: 'ContactController',
                resolve: {
                    loadMyFiles: function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name: "app",
                            files: [
                                "js/ng/controllers/ContactController.js"
                            ]
                        });
                    }
                }
            })
            // tours state
            .state('app.user', {
                url: '/user',
                template: '<div ui-view></div>'
            })
            .state('app.user.list', {
                url: '/list',
                templateUrl: '/view/User/index.html',
                data: {title: 'მომხმარებლის გვერდი'},
                controller: 'UserController',
                resolve: {
                    loadMyFiles: function ($ocLazyLoad) {
                        return $ocLazyLoad.load({
                            name: "app",
                            files: [
                                "js/ng/controllers/UserController.js"
                            ]
                        });
                    }
                }
            })
            .state('forbidden', {
                url: '/forbidden',
                templateUrl: '/resources/view/Forbidden/index.html'
            })
            // ui router
            .state('app.layout', {
                url: '/layout',
                template: '<div ui-view></div>'
            })
            .state('app.ui', {
                url: '/ui',
                template: '<div ui-view></div>'
            })
            .state('app.form', {
                url: '/form',
                template: '<div ui-view></div>'
            })
            .state('app.table', {
                url: '/table',
                template: '<div ui-view></div>'
            })
            .state('access', {
                url: '/access',
                template: '<div class="dark bg-auto w-full"><div ui-view class="fade-in-right-big smooth pos-rlt"></div></div>'
            })


        function load(srcs, callback) {
            return {
                deps: ['$ocLazyLoad', '$q',
                    function ($ocLazyLoad, $q) {
                        var deferred = $q.defer();
                        var promise = false;
                        srcs = angular.isArray(srcs) ? srcs : srcs.split(/\s+/);
                        if (!promise) {
                            promise = deferred.promise;
                        }
                        angular.forEach(srcs, function (src) {
                            promise = promise.then(function () {
                                angular.forEach(MODULE_CONFIG, function (module) {
                                    if (module.name == src) {
                                        src = module.module ? module.name : module.files;
                                    }
                                });
                                return $ocLazyLoad.load(src);
                            });
                        });
                        deferred.resolve();
                        return callback ? promise.then(function () {
                            return callback();
                        }) : promise;
                    }]
            }
        }
    }
})();
