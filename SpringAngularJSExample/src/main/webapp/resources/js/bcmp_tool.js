'use strict';

var app = angular.module('bcmp_tool',[]);
var bcmp_tool_controller = function ($scope, $http) {
    $scope.testFunction = function () {
        $http.get('users/userlist.json').success(function (userList) {
            $scope.users = userList;
        });
    };
};


//var UserController = function($scope, $http) {
//    $scope.fetchUsersList = function() {
//        $http.get('users/userlist.json').success(function(userList){
//            $scope.users = userList;
//        });
//    };
//
//    $scope.addNewUser = function(newUser) {
//        $http.post('users/addUser/' + newUser).success(function() {
//            $scope.fetchUsersList();
//        });
//        $scope.userName = '';
//    };
//
//    $scope.removeUser = function(user) {
//        $http.delete('users/removeUser/' + user).success(function() {
//            $scope.fetchUsersList();
//        });
//    };
//
//    $scope.removeAllUsers = function() {
//        $http.delete('users/removeAllUsers').success(function() {
//            $scope.fetchUsersList();
//        });
//
//    };
//
//    $scope.fetchUsersList();
//};