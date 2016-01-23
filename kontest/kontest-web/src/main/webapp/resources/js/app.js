(function() {

	var AutocompleteCtrl = function($scope, wordsSource) {

		$scope.onedit = function(autocompleteUrl) {
			
			wordsSource.getWords(autocompleteUrl + $scope.prefix)
			           .then(function(foundWords) {
			        	   $scope.words = foundWords;
			           });
		};

		$scope.prefix = undefined;
		$scope.words = [];
	};

	// application
	var autocomplete = angular.module('autocomplete', []);

	// controller
	autocomplete.controller('AutocompleteCtrl', [ '$scope', 'wordsSource', AutocompleteCtrl ]);

	// service
	autocomplete.factory('wordsSource', function($http) {
		var getWords = function(url) {
			return $http.get(url)
			            .then(function(response) {
			            	return response.data;
			            });
		};
		
		return {
			getWords: getWords
		};
	});

}());
