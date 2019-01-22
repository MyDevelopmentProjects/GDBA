angular.module('app').controller('AboutController',
    ['$scope', '$http', 'GridManager', 'ModalManager','FileUploader', function ($scope, $http, GridManager, ModalManager,FileUploader) {

        angular.extend($scope, {
            url:'about-us/first',
            saveURL:'about-us/put',
            uploadPath:"/upload/files/",
            init:{},
            options:{
                height: 300,
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
                    ['insert', ['link','picture','video','hr']],
                    ['view', ['fullscreen', 'codeview']],
                    ['help', ['help']]
                ]
            }
        });

        ModalManager.enableModals($scope);

        $scope.loadAbout = function(){
            $scope.object = {};
            $http.get($scope.url).success(function (data) {
                if(data.id != undefined){
                    $scope.object = data;
                }
            });
        };

        $scope.save = function () {
            var copyObject = angular.copy($scope.object);
            //copyObject.details = {};
            $http.post($scope.saveURL, copyObject).success(function (response) {
                if (!response.success) {
                    return;
                }
                $scope.showSuccessAlert("Success");
                $scope.AmfTable.reloadData(true);
            });
        };

        $scope.loadAbout();


        var AboutUploader = $scope.uploader = new FileUploader({
            url: 'upload/file'
        });

        // CALLBACKS
        AboutUploader.onBeforeUploadItem = function(item) {
            item.formData.push({type: 'GENERAL'});
        };

        $scope.imageUploadEN = function(files, editor) {
            for(var i in files){
                AboutUploader.addToQueue(files[i]);
            }
            AboutUploader.uploadAll();
            AboutUploader.onCompleteItem = function(fileItem, response, status, headers) {
                if(response.success){
                    if(response.source.length > 0){
                        for(var file in response.source){
                            var fileName = response.source[file];
                            editor.insertImage($scope.editableEN, $scope.uploadPath+fileName, fileName);
                        }
                    }
                }
            };
        };

        $scope.imageUploadRU = function(files, editor) {
            for(var i in files){
                AboutUploader.addToQueue(files[i]);
            }
            AboutUploader.uploadAll();
            AboutUploader.onCompleteItem = function(fileItem, response, status, headers) {
                if(response.success){
                    if(response.source.length > 0){
                        for(var file in response.source){
                            var fileName = response.source[file];
                            editor.insertImage($scope.editableRU, $scope.uploadPath+fileName, fileName);
                        }
                    }
                }
            };
        };

    }]);
