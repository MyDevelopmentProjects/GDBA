angular.module('app').controller('ServicesController',
    ['$scope', '$http', 'GridManager', 'ModalManager','FileUploader', function ($scope, $http, GridManager, ModalManager, FileUploader) {

        angular.extend($scope, {
            url:'news/services',
            saveURL:'news/put',
            services: [
                "კანონმდებლობა",
                "მთავრობა",
                "კოოპერაცია",
                "კრედიტ ინფო"
            ],
            init:{}
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
            $http.post("news/saveService", copyObject).success(function (response) {
                if (!response.success) {
                    $scope.showErrorModal("Invalid News id. Try again");
                    return;
                }
                $scope.showSuccessAlert("Success");
                $scope.AmfTable.reloadData(true);
                $('#showAddEdit').modal('hide');
            });
        };


    }]);
