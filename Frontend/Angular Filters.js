<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body ng-controller="MainCtrl">

    <!-- 1. Filters Section -->
    <h2>Filters Demo</h2>
    <p>Date: {{ today | date:'fullDate' }}</p>
    <p>Uppercase: {{ message | uppercase }}</p>
    <p>Lowercase: {{ message | lowercase }}</p>
    <p>Number: {{ price | number:2 }}</p>
    <p>Custom Filter: {{ message | prefix:'Important: ' }}</p>

    <!-- 3. HTTP Methods Section -->
    <h2>HTTP Methods</h2>
    <button ng-click="getPost()">GET Request</button>
    <button ng-click="createPost()">POST Request</button>
    <div ng-if="response">
        <p>Status: {{ response.status }}</p>
        <pre>Data: {{ response.data | json }}</pre>
    </div>

    <script>
        angular.module('myApp', [])
        
        // 1. Filters
        .filter('prefix', () => (input, prefix) => prefix + input)
        
        // 2. Services
        .service('customService', ['$http', '$timeout', function($http, $timeout) {
            this.processData = (data) => $timeout(() => data.toUpperCase(), 1000);
        }])
        
        .controller('MainCtrl', ['$scope', '$location', '$http', 'customService', 
        function($scope, $location, $http, customService) {
            
            // 1. Filters Data
            $scope.today = new Date();
            $scope.message = "AngularJS Demo";
            $scope.price = 1234.5678;

            // 2. Services Usage
            $scope.currentUrl = $location.absUrl();
            
            customService.processData('service data').then(result => {
                $scope.serviceResult = result;
            });

            // 3. HTTP Methods
            $scope.getPost = () => {
                $http.get('https://jsonplaceholder.typicode.com/posts/1')
                    .then(res => $scope.response = res)
                    .catch(err => console.error(err));
            };

            $scope.createPost = () => {
                $http.post('https://jsonplaceholder.typicode.com/posts', {
                    title: 'foo',
                    body: 'bar',
                    userId: 1
                }).then(res => $scope.response = res);
            };

            // 4. Angular APIs
            $scope.original = "Angular Utilities";
            $scope.lower = angular.lowercase($scope.original);
            $scope.upper = angular.uppercase($scope.original);
        }]);
    </script>
</body>
</html>
