(function() {
  var app = angular.module('juegoAppModel', []);

  app.controller('juegoCtrl', ['$http', '$scope', function($http, $scope){
    
	  $scope.siguientePais = null;
	  $scope.ordenSinEmitir = null;
	  $scope.casoAppModel = [];
	  $scope.pistas = [];
	  
	  $scope.iniciarJuego = function(){
		  $http.get('/iniciar').success(function(data){
			  $scope.casoAppModel = data;
		  	})
	  };
	  
	  $scope.iniciarJuego();
	  
	  $scope.paisActual = function(){
		return $scope.casoAppModel.casoActual.ciudadActual.nombreDelPais;
	  };
	  
	  $scope.setSiguientePais = function(newValue){
		  $scope.siguientePais = newValue;
	  };
	    
	  $scope.getSiguientePais = function(){
	      return $scope.siguientePais;
	  };
	    
	  $scope.isSetSiguientePais = function(value){
	      return $scope.siguientePais === value;
	  };
	  
	  $scope.setOrdenDeArresto = function(){
	      $http.get('/ordendearresto/' + $scope.ordenSinEmitir.nombre).success(function(){
	      		$scope.iniciarJuego();
	       	})
	  };
	      
	  $scope.orden = function(){
		  if($scope.casoAppModel.ordenEmitida.nombre === 'null'){
			  return null
		  }
		  return $scope.casoAppModel.ordenEmitida.nombre
	  };
	     	    
	  $scope.viajar = function(){
		  $http.get('/viajar/' + $scope.siguientePais).success(function(){
			  $scope.iniciarJuego();  
			  $scope.siguientePais = null;
		  })
	  };
	  
	  $scope.setOrdenSinEmitir = function(newValue){
		  $scope.ordenSinEmitir = newValue;
	  };
	      
	  $scope.getOrdenSinEmitir = function(){
	      return $scope.ordenSinEmitir;
	  };
	      
	  $scope.isSetOrdenSinEmitir = function(newValue){
	      return $scope.ordenSinEmitir === newValue;
	  };
	  	  
	  $scope.fin = function(){
		  $http.get('/final').success(function(data){
			  $scope.esFin = data
		  })
	  };
	  
	  $scope.esFin = function(){
		  return $scope.esFin
	  }
	  $scope.paises = function(){
		 return $scope.casoAppModel.casoActual.ciudadActual.conexionesAereas;
	  };
	  
	  $scope.getPaisesVisitadosCorrectos = function(){
		  return $scope.casoAppModel.paisesVisitadosCorrectos;
	  };
	  
	  $scope.getPaisesVisitadosIncorrectos = function(){
		  return $scope.casoAppModel.paisesVisitadosIncorrectos;
	  };
	  	    
	  $scope.lugares = function(value){
		  return $scope.casoAppModel.casoActual.ciudadActual.lugaresDeInteres[value];
	  }
	  
	  $scope.expedientes = function(){
		  return $scope.casoAppModel.villanos
	  }
	  
	  $scope.obtenerPistas = function(){
		  $http.get('/pistas').success(function(data){
			  $scope.pistas = data
		  })
	  }
	  
	  $scope.pistasDelLugar = function(value){
		  return $scope.pistas[value]
	  }
	  
	  $scope.mostrarBoton = function(value){
		  return $scope.pistasDelLugar(value)[0].search("Alto!!!") == -1
	  }
	  
  }]);

 //controller de las tabs
  
 app.controller('TabController', function(){
    this.tab = 1;

    this.setTab = function(newValue){
      this.tab = newValue;
    };

    this.isSet = function(tabName){
      return this.tab === tabName;
    };
  });

  app.controller('ModalController', function($scope){
    $scope.showModal = false;
    $scope.toggleModal = function(){
      $scope.showModal = !$scope.showModal;
    };
  });


// directiva del modal
  
  app.directive('modal', function () {
    return {
      template: '<div class="modal fade">' + 
          '<div class="modal-dialog">' + 
            '<div class="modal-content">' + 
              '<div class="modal-header">' + 
                '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' + 
                '<h4 class="modal-title">{{ title }}</h4>' + 
              '</div>' + 
              '<div class="modal-body" ng-transclude></div>' + 
            '</div>' + 
          '</div>' + 
        '</div>',
      restrict: 'E',
      transclude: true,
      replace:true,
      scope:true,
      link: function postLink(scope, element, attrs) {
        scope.title = attrs.title;

        scope.$watch(attrs.visible, function(value){
          if(value == true)
            $(element).modal('show');
          else
            $(element).modal('hide');
        });

        $(element).on('shown.bs.modal', function(){
          scope.$apply(function(){
            scope.$parent[attrs.visible] = true;
          });
        });

        $(element).on('hidden.bs.modal', function(){
          scope.$apply(function(){
            scope.$parent[attrs.visible] = false;
          });
        });
      }
    };
  });

})();
