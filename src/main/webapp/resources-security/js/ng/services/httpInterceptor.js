angular.module('app').factory('httpInterceptor', function ($q, $rootScope, $localStorage, ModalManager) {
        var numLoadings = 0;
        return {
            request: function (config) {
                numLoadings++;
                if (config.showLoader != 0) {
                    $('.loader').fadeIn();
                }
                return config;
            },
            response: function (response) {
                errorUtils.handle_error(response.data, ModalManager);
                if ((--numLoadings) === 0) {
                    setTimeout(function(){
                        $('.loader').fadeOut();
                    },1000)
                }
                return response || $q.when(response);
            },
            responseError: function (response) {
                if (!(--numLoadings)) {
                }
                setTimeout(function(){
                    $('.loader').fadeOut();
                },1000)
                //console.error(response.config.url, response.data, response.status);
                return $q.reject(response);
            }
        };
    })
    .config(function ($httpProvider) {
        $httpProvider.interceptors.push('httpInterceptor');
    });