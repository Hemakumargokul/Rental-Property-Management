var app = angular.module('rpm', ['Tenantservices', 'ngRoute']);

//app.controller('TenantComUploadController',function($scope) {
//	$scope.result="hello";
//});

app.config(['$locationProvider', '$routeProvider',
  function config($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');

    $routeProvider.
      when('/', {
        templateUrl: 'HomePage.html'
      }).
      when('/tenant', {
        templateUrl: 'Tenant.html'
      }).
      when('/rpm', {
          templateUrl: 'RPM.html'
        }).
        when('/tenantComplaintList', {
            templateUrl: 'TenantComplaintList.html',
            controller: 'TenantComGetPostController'
          }).
          when('/tenantForm', {
              templateUrl: 'Tenant_Form.html',
            controller: 'TenantComPostController'
            }).
            when('/employeesalarysum', {
                templateUrl: 'EmployeeSalaryReport.html',
              controller: 'EmpSalaryReportController'
              }).
              when('/leaseExpiry', {
                  templateUrl: 'LeaseExpiryReport.html',
                controller: 'LeaseExpiryReportController'
                }).
                when('/owner', {
                    templateUrl: 'Owner.html',
                  controller: 'OwnerController'
                  }).
        when('/tenantComplaintListReport/:name', {
            templateUrl: 'TenantComplaintListReport.html',
            controller:'TenantComlistController'
          });
  }
]);

app.controller('TenantController', ['$scope', 'UserFactory',   function ($scope,UserFactory) {
    
    
        $scope.tenant = UserFactory.query();
            
        
}]);


app.controller('EmpSalaryReportController', ['$scope', 'EmployeeFactory',   function ($scope,EmployeeFactory) {
    
    
    $scope.employee = EmployeeFactory.query();
        
    
}]);

app.controller('LeaseExpiryReportController', ['$scope', 'LeaseFactory',   function ($scope,LeaseFactory) {
    
    
    $scope.lease = LeaseFactory.query();
        
    
}]);

app.controller('OwnerController', ['$scope', 'OwnerFactory',   function ($scope,OwnerFactory) {
    
    
    $scope.owner = OwnerFactory.query();
        
    
}]);

app.factory('TenantService', function(){
    var myjsonObj = null;//the object to hold our data
     return {
     getJson:function(){
       return myjsonObj;
     },
     setJson:function(value){
      myjsonObj = value;
     }
     }
});

 app.controller('TenantComlistController', ['$scope','$http','$location','TenantService','$routeParams',    function ($scope, $http,$location,TenantService,$routeParams) {
	 
	 
	 var method = "";
	    var url = "";
	    var name=$routeParams.name;
	    var nameSplit = name.split("_");
	    method = "GET";
	        
	    

	    $http({
	        method : method,
	        url : '/RPM/rest/getcomplaints/'+nameSplit[0]+'/'+nameSplit[1],
	       // url : '/RPM/rest/tenants',
	        
	        
	    }).then(function(response) {
 		   		
 			$scope.result = response.data;
 			
 			
 			
 	});
	 
 }]);
app.controller('TenantComPostController', ['$scope','$http','$location',    function ($scope, $http,$location) {
    
	/*$scope.submitForm =function(){
		$scope.response = UserFactoryPost.query();	
	} */
	$scope.submitForm = function() {
	    
	    var method = "";
	    var url = "";
	    
	        //Id is absent in form data, it is create new country operation
	        method = "POST";
	        url = '/RPM/rest/tenantforms';
	    

	    $http({
	        method : method,
	        url : url,
	        data : angular.toJson($scope.data),
	        headers : {
	            'Content-Type' : 'application/json'
	        }
	    }).then(function(response) {
    		
    		if(response.data=="200")
    			{
    			$scope.result = "Complaint Successfully Registered";
    			
    			}
    		else
    			{
    			$scope.result = "Complaint Already Registered or Tenant Doesn't Exists";
    			}
    			
    	});
	};
    
    
    
}]);



app.controller('TenantComGetPostController', ['$scope','$http','$location','TenantService',    function ($scope, $http,$location,TenantService) {
    
	/*$scope.submitForm =function(){
		$scope.response = UserFactoryPost.query();	
	} */
	$scope.submitForm = function() {
	    
	    
	        var urlParameter=$scope.data.fname+'_'+$scope.data.lname;
	        
	 
    			$location.path('tenantComplaintListReport/'+urlParameter);
    	
	};
      
}]);


/*app.controller('TenantComUploadController', ['$http','$scope',
	function($http,$scope) {
	

	var values=$scope.data; 
    $scope.submitForm = function(){
    	
    	
    	$scope.result = $scope.values;
    	$http.post('http://localhost:8085/RPM/rest/tenantforms',{data:values}).then(function(response) {
    		$scope.result1 = $scope.fname;
    	});
      
    };
    
	}
	  
	]);*/


		