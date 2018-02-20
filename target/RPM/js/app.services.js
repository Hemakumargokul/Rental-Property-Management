/* Services */

var services = angular.module('Tenantservices', ['ngResource']);

/*services.factory('UserFactory', function ($resource) {
    return $resource('/RPM/rest/tenants', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});
*/
services.factory('UserFactory', ['$resource',
  function($resource) {
    return $resource('/RPM/rest/tenants', {}, {
      query: {
        method: 'GET',
        params: {},
        isArray: true
      }
    });
  }
]);

services.factory('UserFactoryPost', ['$resource',
	  function($resource) {
	    return $resource('/RPM/rest/tenantforms', {}, {
	      query: {
	        method: 'POST',
	        params: {},
	        isArray: true
	      }
	    });
	  }
	]);

services.factory('EmployeeFactory', ['$resource',
	  function($resource) {
	    return $resource('/RPM/rest/employeeSalary', {}, {
	      query: {
	        method: 'GET',
	        params: {},
	        isArray: true
	      }
	    });
	  }
	]);
services.factory('LeaseFactory', ['$resource',
	  function($resource) {
	    return $resource('/RPM/rest/leaseExpiry', {}, {
	      query: {
	        method: 'GET',
	        params: {},
	        isArray: true
	      }
	    });
	  }
	]);

services.factory('OwnerFactory', ['$resource',
	  function($resource) {
	    return $resource('/RPM/rest/owner', {}, {
	      query: {
	        method: 'GET',
	        params: {},
	        isArray: true
	      }
	    });
	  }
	]);
