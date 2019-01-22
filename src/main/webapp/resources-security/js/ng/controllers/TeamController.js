angular.module('app').controller('TeamController',
    ['$scope', '$http', 'GridManager', 'ModalManager','FileUploader', function ($scope, $http, GridManager, ModalManager, FileUploader) {

        angular.extend($scope, {
            url:'team/list',
            saveURL:'team/put',
            deleteURL:'team/delete',
            init:{}
        });

        GridManager.givePowerTo($scope);
        ModalManager.enableModals($scope);
        $scope.AmfTable.openPage(0);


        $scope.showAddEdit = function (item) {
            $scope.init.action = item ? 'რედაქტირება' : 'დამატება';
            $scope.object = {};
            $scope.imageUploaded = false;
            if (item) {
                $scope.object = angular.copy(item);
            }
            $('#showAddEdit').modal('show');
        };

        $scope.save = function () {
            if(!$scope.imageUploaded && $("input[type='file']")[0].files.length > 0){
                uploader.uploadAll();
            } else {
                if($scope.object.imageURL == undefined || $scope.object.imageURL == null){
                    $scope.showErrorModal("Please select image.");
                    return
                }
                $scope.saveLazy();
            }

        };

        $scope.saveLazy = function(){
            var objectCopy = angular.copy($scope.object);
            $http.post($scope.saveURL, objectCopy).success(function (response) {
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

        var uploader = $scope.uploader = new FileUploader({
            url: 'upload/file'
        });

        // FILTERS
        uploader.filters.push({
            name: 'imageFilter',
            fn: function(item /*{File|FileLikeObject}*/, options) {
                var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
        });

        // CALLBACKS
        uploader.onBeforeUploadItem = function(item) {
            item.formData.push({type: 'TEAM_IMG'});
        };

        uploader.onCompleteItem = function(fileItem, response, status, headers) {
            if(response.success){
                if(response.source.length > 0){
                    $scope.object.imageURL = response.source[0];
                }
            }
        };

        uploader.onCompleteAll = function() {
            // Clear File Input
            $("input[type='file']").val('').clone(true);
            $scope.imageUploaded = true;
            $scope.saveLazy();
        };

        $('#showAddEdit').on("hidden.bs.modal", function(){
            uploader.queue = [];
            // Clear File Input
            $("input[type='file']").val('').clone(true);
        });


        $scope.createFabMenuItems = function () {
            setTimeout(function () {
                var add = $scope.showAddEdit;
                var scope = angular.element($(".fabmenu")).scope();
                if(scope !== undefined){
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


    }]);
