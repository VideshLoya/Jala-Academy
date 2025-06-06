
// Define an AngularJS module
var app = angular.module("myApp", []);

// 1. Controller to evaluate expressions and change textbox background
app.controller("ColorCtrl", function($scope) {
    $scope.color = "";
});

// 2. External directive and controller inclusion
// Directive
app.directive("myDirective", function() {
    return {
        template: "<h3>This is a custom directive!</h3>"
    };
});

// Controller
app.controller("ExternalCtrl", function($scope) {
    $scope.message = "This controller is included from an external JS file!";
});

// 3. ng-model, ng-init, ng-repeat, ng-include example
app.controller("BindingCtrl", function($scope) {
    $scope.username = "";
    $scope.names = ["Alice", "Bob", "Charlie"];
    $scope.dynamicTemplate = "template.html";
});

// 4. $scope vs $rootScope example
app.run(function($rootScope) {
    $rootScope.globalMessage = "This is from $rootScope";
});

app.controller("ScopeCtrl", function($scope) {
    $scope.localMessage = "This is from $scope";
});
