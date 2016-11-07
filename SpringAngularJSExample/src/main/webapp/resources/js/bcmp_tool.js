'use strict';

var App = angular.module('bcmp_tool', []);

App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/fcr', {
        templateUrl: 'tool/fcr',
        controller: bcmp_tool_controller
    });
    $routeProvider.when('/ics', {
        templateUrl: 'tool/ics',
        controller: bcmp_tool_controller
    });

    $routeProvider.otherwise({redirectTo: '/fcr'});
}]);


var bcmp_tool_controller = function ($scope, $http) {
    $scope.testFunction = function (ywlsh, jylsh) {
        var req = {
            url: "users/userlist.json",
            method: 'GET',
            params: {
                ywlsh: ywlsh,
                jylsh: jylsh
            }
        };
        $http(req).then(function (userList) {
            $scope.users = userList.data;
        }, function () {
        });
    };
};