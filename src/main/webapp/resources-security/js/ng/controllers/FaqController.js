angular.module('app').controller('FaqController',
    ['$scope', '$http', 'GridManager', 'ModalManager','FileUploader', function ($scope, $http, GridManager, ModalManager,FileUploader) {

        angular.extend($scope, {
            url:'faq/list',
            saveURL:'faq/put',
            deleteURL:'faq/delete',
            init:{},
            faqCategory:[
                {name:"NONE",title:"სერთო"},
                {name:"HOTEL", title:"სასტუმრო"},
                {name:"TOUR", title:"ტურები"}
            ],
            options:{
                height: 150,
                toolbar: [
                  ['edit',['undo','redo']],
                    ['headline', ['style']],
                    ['style', ['bold', 'italic', 'underline', 'superscript', 'subscript', 'strikethrough', 'clear']],
                    ['fontface', ['fontname']],
                    ['textsize', ['fontsize']],
                    ['fontclr', ['color']],
                    ['alignment', ['ul', 'ol', 'paragraph', 'lineheight']],
                    ['height', ['height']],
                    ['table', ['table']],
                    ['insert', ['link','picture','video','hr' , 'gallery']],
                    ['view', ['fullscreen', 'codeview']],
                    ['help', ['help']],
                ]
            }
        });

        GridManager.givePowerTo($scope);
        ModalManager.enableModals($scope);
        $scope.AmfTable.openPage(0);

        $scope.showAddEdit = function (item) {
            $scope.init.action = item ? 'რედაქტირება' : 'დამატება';
            $scope.object = {};
            if (item) {
                $scope.object = angular.copy(item);
            }
            $('#showAddEdit').modal('show');
        };

        $scope.save = function () {
            var copyObject = angular.copy($scope.object);
            $http.post($scope.saveURL, copyObject).success(function (response) {
                if (!response.success) {
                    return;
                }
                $scope.showSuccessAlert("Success");
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

        $scope.createFabMenuItems = function () {
            setTimeout(function () {
                var add = $scope.showAddEdit;
                var scope = angular.element($(".fabmenu")).scope();
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
            }, 1000);
        };
        $scope.createFabMenuItems();

        var uploader = $scope.uploader = new FileUploader({
            url: 'upload/file'
        });

        // CALLBACKS
        uploader.onBeforeUploadItem = function(item) {
            item.formData.push({type: 'GENERAL'});
        };

        // FILTERS
        uploader.filters.push({
            name: 'imageFilter',
            fn: function(item /*{File|FileLikeObject}*/, options) {
                var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
        });

        $scope.imageUploadEN = function(files, editor, lang) {
            for(var i in files){
                uploader.addToQueue(files[i]);
            }
            uploader.uploadAll();
            uploader.onCompleteItem = function(fileItem, response, status, headers) {
                if(response.success){
                    if(response.source.length > 0){
                        for(var file in response.source){
                            var fileName = response.source[file];
                            var uploadPath = "/upload/files/";
                            editor.insertImage($scope.editableEN, uploadPath+fileName, fileName);
                        }
                    }
                }
            };
        };

        $scope.imageUploadRU = function(files, editor, lang) {
            for(var i in files){
                uploader.addToQueue(files[i]);
            }
            uploader.uploadAll();
            uploader.onCompleteItem = function(fileItem, response, status, headers) {
                if(response.success){
                    if(response.source.length > 0){
                        for(var file in response.source){
                            var fileName = response.source[file];
                            var uploadPath = "/upload/files/";
                            editor.insertImage($scope.editableRU, uploadPath+fileName, fileName);
                        }
                    }
                }
            };
        };

    }]);
