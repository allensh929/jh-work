(function() {
    'use strict';

    angular
        .module('gatewayApp')
        .factory('CarSearch', CarSearch);

    CarSearch.$inject = ['$resource'];

    function CarSearch($resource) {
        var resourceUrl =  'blogapp/' + 'api/_search/cars/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
