// @SOURCE:C:/Users/juan/Documents/facultad/CarmenSanDiegoAppWeb/conf/routes
// @HASH:73672cc86628dcaba8d0b9b84c5d8a4016c8c08f
// @DATE:Fri Oct 24 23:29:46 ART 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:14
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:14
class ReverseAssets {


// @LINE:14
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def viajar(pais:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "viajar/" + implicitly[PathBindable[String]].unbind("pais", dynamicString(pais)))
}
                        

// @LINE:7
def ordenDeArresto(villano:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ordendearresto/" + implicitly[PathBindable[String]].unbind("villano", dynamicString(villano)))
}
                        

// @LINE:9
def fin(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "final")
}
                        

// @LINE:6
def iniciarJuego(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "iniciar")
}
                        

}
                          
}
                  


// @LINE:14
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:14
class ReverseAssets {


// @LINE:14
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def viajar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.viajar",
   """
      function(pais) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "viajar/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("pais", encodeURIComponent(pais))})
      }
   """
)
                        

// @LINE:7
def ordenDeArresto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.ordenDeArresto",
   """
      function(villano) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordendearresto/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("villano", encodeURIComponent(villano))})
      }
   """
)
                        

// @LINE:9
def fin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.fin",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "final"})
      }
   """
)
                        

// @LINE:6
def iniciarJuego : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.iniciarJuego",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "iniciar"})
      }
   """
)
                        

}
              
}
        


// @LINE:14
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:14
class ReverseAssets {


// @LINE:14
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def viajar(pais:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.viajar(pais), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "viajar", Seq(classOf[String]), "GET", """""", _prefix + """viajar/$pais<[^/]+>""")
)
                      

// @LINE:7
def ordenDeArresto(villano:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.ordenDeArresto(villano), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ordenDeArresto", Seq(classOf[String]), "GET", """""", _prefix + """ordendearresto/$villano<[^/]+>""")
)
                      

// @LINE:9
def fin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.fin(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "fin", Seq(), "GET", """""", _prefix + """final""")
)
                      

// @LINE:6
def iniciarJuego(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.iniciarJuego(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "iniciarJuego", Seq(), "GET", """ LIBROS""", _prefix + """iniciar""")
)
                      

}
                          
}
        
    