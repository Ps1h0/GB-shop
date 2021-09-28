angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/shop';

    $scope.fillTable = function () {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        });
    };

    $scope.submitCreateNewProduct = function () {
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function () {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    };

    $scope.deleteProduct = function () {
        $http.delete(contextPath + 'products')
        $scope.fillTable();
    }

    $scope.fillTable();
});