angular.module('app').controller('SliderController',
    ['$scope', '$http', 'GridManager', 'ModalManager', 'FileUploader', '$sce',
        function ($scope, $http, GridManager, ModalManager, FileUploader, $sce) {

            angular.extend($scope, {
                url: 'slider/list',
                saveURL: 'slider/put',
                deleteURL: 'slider/delete',
                init: {},
                sections: [
                    {name: "MAIN_PAGE_TOP_SECTION", title: "მთავარი გვერდი > Top Slider"},
                    {name: "MAIN_PAGE_NEWS_SECTION", title: "მთავარი გვერდი > News"},
                    {name: "MAIN_PAGE_PARTNERS_SECTION", title: "მთავარი გვერდი > Partners"},
                    {name: "ABOUT_PAGE_TOP_SECTION", title: "ჩვენს შესახებ > Top Slider"},
                    {name: "NEWS_PAGE_TOP_SECTION", title: "სიახლეები > Top Slider"},
                    {name: "MEMBERS_PAGE_TOP_SECTION", title: "პარტნიორები > Top Slider"}
                ]
            });

            GridManager.givePowerTo($scope);
            ModalManager.enableModals($scope);

            $scope.getSlides = function () {

                $http({
                    url: $scope.url,
                    method: 'GET',
                    /*params: query,*/
                    cache: true
                }).success(function (data) {
                    $scope.data = $scope.groupBy(data.results, 'section')
                    $scope.keys = Object.keys($scope.data);
                })

            };

            $scope.groupBy = function (xs, key) {
                return xs.reduce(function (rv, x) {
                    (rv[x[key]] = rv[x[key]] || []).push(x);
                    return rv;
                }, {});
            };

            $scope.getTitle = function (key) {
                var title = "UNKNOWN"
                for (var i = 0; i < $scope.sections.length; i++) {
                    if (key === $scope.sections[i].name) {
                        title = $scope.sections[i].title;
                        break;
                    }
                }
                return title
            };

            $scope.getSlides();

            $scope.showAddEdit = function (item) {
                $scope.init.action = item ? 'რედაქტირება' : 'დამატება';
                $scope.object = {};
                if (item) {
                    $scope.object = angular.copy(item);
                    if ($scope.object.bgColor) {
                        $scope.object.bgColor = "#"+ $scope.object.bgColor
                    }
                }
                $('#showAddEdit').modal('show');
            };

            $scope.save = function () {
                if ($scope.uploader.queue.length > 0) {
                    uploader.uploadAll();
                } else {
                    if ($scope.object.image === undefined || $scope.object.image === null) {
                        $scope.showErrorModal("Please upload image.");
                        return
                    }
                    $scope.saveLazy();
                }
            };

            $scope.saveLazy = function () {

                var obj = angular.copy($scope.object)
                if (obj.bgColor) {
                    obj.bgColor = obj.bgColor.replace('#','')
                }
                $http.post($scope.saveURL, obj).success(function (response) {
                    if (!response.success) {
                        $scope.showErrorModal("მოცემული ჩანაწერის დამატება შეუძლებელია");
                        return;
                    }
                    $scope.object = response.source;
                    $scope.AmfTable.reloadData(true);
                    $('#showAddEdit').modal('hide');
                });
            };

            $scope.delete = function (itemId) {
                swal({
                        title: "ნამდვილად გსურთ წაშლა?",
                        text: "თქვენ ვეღარ შეძლებთ ინფორმაციის უკან დაბრუნებას.",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonClass: "btn-danger",
                        confirmButtonText: "დიახ !",
                        cancelButtonText: "არა",
                        closeOnConfirm: false,
                        closeOnCancel: false
                    },
                    function (isConfirm) {
                        if (isConfirm) {
                            $http.post($scope.deleteURL, itemId).success(function (data) {
                                if (!data.success) {
                                    if (response.errorMessage == "RECORD_IS_USED_IN_OTHER_TABLES") {
                                        $scope.showErrorModal("მოცემული ჩანაწერის წაშლა შეუძლებელია რადგან ის ფიქსირდება სხვა ცხრილშიც.")
                                    }
                                    return;
                                }
                                $scope.AmfTable.reloadData(true);
                            });
                            swal("Deleted!", "თქვენი მოთხოვნა წარმატებით შესრულდა", "success");
                        } else {
                            swal("Cancelled", "მოთხოვნა შეწყვეტილია", "error");
                        }
                    });
            };


            var uploader = $scope.uploader = new FileUploader({
                url: 'upload/file'
            });

            // FILTERS
            uploader.filters.push({
                name: 'imageFilter',
                fn: function (item /*{File|FileLikeObject}*/, options) {
                    var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                    return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
                }
            });

            // CALLBACKS
            uploader.onBeforeUploadItem = function (item) {
                item.formData.push({type: 'SLIDER_IMG'});
            };

            uploader.onCompleteItem = function (fileItem, response, status, headers) {
                if (response.success) {
                    if (response.source.length > 0) {
                        $scope.object.image = response.source[0];
                    }
                }
            };

            uploader.onCompleteAll = function () {
                $("input[type='file']").val('').clone(true);
                $scope.saveLazy();
            };

            $('#showAddEdit').on("hidden.bs.modal", function () {
                uploader.queue = [];
                // Clear File Input
                $("input[type='file']").val('').clone(true);
            });

            $scope.createFabMenuItems = function () {
                setTimeout(function () {
                    var add = $scope.showAddEdit;
                    var scope = angular.element($(".fabmenu")).scope();
                    if (scope !== undefined) {
                        scope.$apply(function () {
                            scope.app.fabScope = $scope;
                            $scope.fabMenuItems = scope.app.fabMenuItems = [
                                {
                                    callback: add,
                                    "fa": "plus",
                                    "title": "დამატება"
                                }
                            ];
                        });
                    }
                }, 1000);
            };

            $scope.createFabMenuItems();

            $scope.parseURI = function (url) {
                if (!$scope.validateYouTubeUrl(url)) {
                    return
                }
                var video_id = url.split('v=')[1].split('&')[0];
                return $sce.trustAsResourceUrl("https://www.youtube.com/embed/" + video_id);
            };

            $scope.validateYouTubeUrl = function (url) {
                if (url !== undefined || url !== '') {
                    var regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|\&v=|\?v=)([^#\&\?]*).*/;
                    var match = url.match(regExp);
                    return match && match[2].length === 11
                }
                return false
            }

        }]);
