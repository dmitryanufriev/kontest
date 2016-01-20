var autocomplete = angular.module('autocomplete', []);

autocomplete.controller('AutocompleteCtrl', function($scope, wordsSource) {
	$scope.prefix = undefined;
	$scope.words = [];

	$scope.init = function(autocompleteUrl) {
		$scope.autcompleteUrl = autocompleteUrl;
	};
	
	$scope.onedit = function() {
		$scope.words = [];

		wordsSource.get($scope.autcompleteUrl + $scope.prefix).then(function(foundWords) {
			for (var i = 0; i < foundWords.length; i ++) {
				$scope.words.push(foundWords[i]);
			}
		});
	};
	
});

autocomplete.factory('wordsSource', function($http) {
	return {
		get : function(url) {
			return $http.get(url).then(function(response) {
				return response.data;
			});
		}
	};
});
