// @SOURCE:/home/juan3/Documentos/Facultad/workspace2/CarmenSanDiegoAppWeb/conf/routes
// @HASH:fff8d9dfbe1bf692c6b4c24c74aaba2ae3faaa3c
// @DATE:Wed Oct 22 20:42:58 ART 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:16
class ReverseAssets {


// @LINE:16
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:12
def getExpedientes(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "expedientes")
}
                        

// @LINE:7
def getOrdenDeArresto(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ordendearresto")
}
                        

// @LINE:10
def viajar(pais:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "viajar/" + implicitly[PathBindable[String]].unbind("pais", dynamicString(pais)))
}
                        

// @LINE:11
def esFinal(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "final")
}
                        

// @LINE:9
def ordenDeArresto(villano:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ordendearresto/" + implicitly[PathBindable[String]].unbind("villano", dynamicString(villano)))
}
                        

// @LINE:8
def getPaisAcutal(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "paisactual")
}
                        

// @LINE:6
def iniciarJuego(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "iniciar")
}
                        

}
                          
}
                  


// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:16
class ReverseAssets {


// @LINE:16
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:12
def getExpedientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getExpedientes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expedientes"})
      }
   """
)
                        

// @LINE:7
def getOrdenDeArresto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getOrdenDeArresto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordendearresto"})
      }
   """
)
                        

// @LINE:10
def viajar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.viajar",
   """
      function(pais) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "viajar/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("pais", encodeURIComponent(pais))})
      }
   """
)
                        

// @LINE:11
def esFinal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.esFinal",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "final"})
      }
   """
)
                        

// @LINE:9
def ordenDeArresto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.ordenDeArresto",
   """
      function(villano) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordendearresto/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("villano", encodeURIComponent(villano))})
      }
   """
)
                        

// @LINE:8
def getPaisAcutal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getPaisAcutal",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paisactual"})
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
        


// @LINE:16
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:16
class ReverseAssets {


// @LINE:16
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:12
def getExpedientes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getExpedientes(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getExpedientes", Seq(), "GET", """""", _prefix + """expedientes""")
)
                      

// @LINE:7
def getOrdenDeArresto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getOrdenDeArresto(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getOrdenDeArresto", Seq(), "GET", """""", _prefix + """ordendearresto""")
)
                      

// @LINE:10
def viajar(pais:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.viajar(pais), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "viajar", Seq(classOf[String]), "GET", """""", _prefix + """viajar/$pais<[^/]+>""")
)
                      

// @LINE:11
def esFinal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.esFinal(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "esFinal", Seq(), "GET", """""", _prefix + """final""")
)
                      

// @LINE:9
def ordenDeArresto(villano:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.ordenDeArresto(villano), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ordenDeArresto", Seq(classOf[String]), "GET", """""", _prefix + """ordendearresto/$villano<[^/]+>""")
)
                      

// @LINE:8
def getPaisAcutal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getPaisAcutal(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getPaisAcutal", Seq(), "GET", """""", _prefix + """paisactual""")
)
                      

// @LINE:6
def iniciarJuego(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.iniciarJuego(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "iniciarJuego", Seq(), "GET", """ LIBROS""", _prefix + """iniciar""")
)
                      

}
                          
}
        
    