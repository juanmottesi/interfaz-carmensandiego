// @SOURCE:C:/Users/juan/Documents/facultad/eclipse/workspace/CarmenSanDiegoAppWeb/conf/routes
// @HASH:6da7218ed508a2dc5dce4a72a6acfad8ed67ab8b
// @DATE:Tue Dec 02 00:22:19 ART 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:21
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:21
class ReverseAssets {


// @LINE:21
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:16
def getVillanos(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "villanos")
}
                        

// @LINE:10
def obtenerPistas2(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "pistas")
}
                        

// @LINE:14
def getListaCorrectos(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "listacorrectos")
}
                        

// @LINE:12
def getPaisActualNombre(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "paisactual")
}
                        

// @LINE:7
def ordenDeArresto(villano:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ordendearresto/" + implicitly[PathBindable[String]].unbind("villano", dynamicString(villano)))
}
                        

// @LINE:17
def nuevoCaso(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "nuevocaso")
}
                        

// @LINE:13
def getListaIncorrectos(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "listaincorrectos")
}
                        

// @LINE:6
def iniciarJuego(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "iniciar")
}
                        

// @LINE:9
def fin(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "final")
}
                        

// @LINE:11
def getConexionesAereas(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "conexiones")
}
                        

// @LINE:8
def viajar2(pais:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "viajar/" + implicitly[PathBindable[String]].unbind("pais", dynamicString(pais)))
}
                        

// @LINE:15
def getOrdenDeArrestoEmitida(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ordenemitida")
}
                        

}
                          
}
                  


// @LINE:21
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:21
class ReverseAssets {


// @LINE:21
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:16
def getVillanos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getVillanos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "villanos"})
      }
   """
)
                        

// @LINE:10
def obtenerPistas2 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.obtenerPistas2",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pistas"})
      }
   """
)
                        

// @LINE:14
def getListaCorrectos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getListaCorrectos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "listacorrectos"})
      }
   """
)
                        

// @LINE:12
def getPaisActualNombre : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getPaisActualNombre",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paisactual"})
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
                        

// @LINE:17
def nuevoCaso : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.nuevoCaso",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nuevocaso"})
      }
   """
)
                        

// @LINE:13
def getListaIncorrectos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getListaIncorrectos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "listaincorrectos"})
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
                        

// @LINE:9
def fin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.fin",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "final"})
      }
   """
)
                        

// @LINE:11
def getConexionesAereas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getConexionesAereas",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "conexiones"})
      }
   """
)
                        

// @LINE:8
def viajar2 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.viajar2",
   """
      function(pais) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "viajar/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("pais", encodeURIComponent(pais))})
      }
   """
)
                        

// @LINE:15
def getOrdenDeArrestoEmitida : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getOrdenDeArrestoEmitida",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenemitida"})
      }
   """
)
                        

}
              
}
        


// @LINE:21
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:21
class ReverseAssets {


// @LINE:21
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:16
def getVillanos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getVillanos(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getVillanos", Seq(), "GET", """""", _prefix + """villanos""")
)
                      

// @LINE:10
def obtenerPistas2(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.obtenerPistas2(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "obtenerPistas2", Seq(), "GET", """""", _prefix + """pistas""")
)
                      

// @LINE:14
def getListaCorrectos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getListaCorrectos(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getListaCorrectos", Seq(), "GET", """""", _prefix + """listacorrectos""")
)
                      

// @LINE:12
def getPaisActualNombre(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getPaisActualNombre(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getPaisActualNombre", Seq(), "GET", """""", _prefix + """paisactual""")
)
                      

// @LINE:7
def ordenDeArresto(villano:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.ordenDeArresto(villano), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ordenDeArresto", Seq(classOf[String]), "GET", """""", _prefix + """ordendearresto/$villano<[^/]+>""")
)
                      

// @LINE:17
def nuevoCaso(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.nuevoCaso(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "nuevoCaso", Seq(), "GET", """""", _prefix + """nuevocaso""")
)
                      

// @LINE:13
def getListaIncorrectos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getListaIncorrectos(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getListaIncorrectos", Seq(), "GET", """""", _prefix + """listaincorrectos""")
)
                      

// @LINE:6
def iniciarJuego(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.iniciarJuego(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "iniciarJuego", Seq(), "GET", """ LIBROS""", _prefix + """iniciar""")
)
                      

// @LINE:9
def fin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.fin(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "fin", Seq(), "GET", """""", _prefix + """final""")
)
                      

// @LINE:11
def getConexionesAereas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getConexionesAereas(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getConexionesAereas", Seq(), "GET", """""", _prefix + """conexiones""")
)
                      

// @LINE:8
def viajar2(pais:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.viajar2(pais), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "viajar2", Seq(classOf[String]), "GET", """""", _prefix + """viajar/$pais<[^/]+>""")
)
                      

// @LINE:15
def getOrdenDeArrestoEmitida(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getOrdenDeArrestoEmitida(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getOrdenDeArrestoEmitida", Seq(), "GET", """""", _prefix + """ordenemitida""")
)
                      

}
                          
}
        
    