// @SOURCE:C:/Users/juan/Documents/facultad/eclipse/workspace/CarmenSanDiegoAppWeb/conf/routes
// @HASH:05374eba5630afc7134a3e0d6ed0e991a283d96c
// @DATE:Wed Dec 03 10:19:25 ART 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_iniciarJuego0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("iniciar"))))
private[this] lazy val controllers_Application_iniciarJuego0_invoker = createInvoker(
controllers.Application.iniciarJuego(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "iniciarJuego", Nil,"GET", """ LIBROS""", Routes.prefix + """iniciar"""))
        

// @LINE:7
private[this] lazy val controllers_Application_ordenDeArresto21_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordendearresto/"),DynamicPart("villano", """[^/]+""",true))))
private[this] lazy val controllers_Application_ordenDeArresto21_invoker = createInvoker(
controllers.Application.ordenDeArresto2(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ordenDeArresto2", Seq(classOf[String]),"GET", """""", Routes.prefix + """ordendearresto/$villano<[^/]+>"""))
        

// @LINE:8
private[this] lazy val controllers_Application_viajar22_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("viajar/"),DynamicPart("pais", """[^/]+""",true))))
private[this] lazy val controllers_Application_viajar22_invoker = createInvoker(
controllers.Application.viajar2(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "viajar2", Seq(classOf[String]),"GET", """""", Routes.prefix + """viajar/$pais<[^/]+>"""))
        

// @LINE:9
private[this] lazy val controllers_Application_fin3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("final"))))
private[this] lazy val controllers_Application_fin3_invoker = createInvoker(
controllers.Application.fin(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "fin", Nil,"GET", """""", Routes.prefix + """final"""))
        

// @LINE:10
private[this] lazy val controllers_Application_obtenerPistas24_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("pistas"))))
private[this] lazy val controllers_Application_obtenerPistas24_invoker = createInvoker(
controllers.Application.obtenerPistas2(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "obtenerPistas2", Nil,"GET", """""", Routes.prefix + """pistas"""))
        

// @LINE:11
private[this] lazy val controllers_Application_getConexionesAereas5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("conexiones"))))
private[this] lazy val controllers_Application_getConexionesAereas5_invoker = createInvoker(
controllers.Application.getConexionesAereas(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getConexionesAereas", Nil,"GET", """""", Routes.prefix + """conexiones"""))
        

// @LINE:12
private[this] lazy val controllers_Application_getPaisActualNombre6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paisactual"))))
private[this] lazy val controllers_Application_getPaisActualNombre6_invoker = createInvoker(
controllers.Application.getPaisActualNombre(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getPaisActualNombre", Nil,"GET", """""", Routes.prefix + """paisactual"""))
        

// @LINE:13
private[this] lazy val controllers_Application_getListaIncorrectos7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("listaincorrectos"))))
private[this] lazy val controllers_Application_getListaIncorrectos7_invoker = createInvoker(
controllers.Application.getListaIncorrectos(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getListaIncorrectos", Nil,"GET", """""", Routes.prefix + """listaincorrectos"""))
        

// @LINE:14
private[this] lazy val controllers_Application_getListaCorrectos8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("listacorrectos"))))
private[this] lazy val controllers_Application_getListaCorrectos8_invoker = createInvoker(
controllers.Application.getListaCorrectos(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getListaCorrectos", Nil,"GET", """""", Routes.prefix + """listacorrectos"""))
        

// @LINE:15
private[this] lazy val controllers_Application_getOrdenDeArrestoEmitida9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordenemitida"))))
private[this] lazy val controllers_Application_getOrdenDeArrestoEmitida9_invoker = createInvoker(
controllers.Application.getOrdenDeArrestoEmitida(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getOrdenDeArrestoEmitida", Nil,"GET", """""", Routes.prefix + """ordenemitida"""))
        

// @LINE:16
private[this] lazy val controllers_Application_getVillanos10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("villanos"))))
private[this] lazy val controllers_Application_getVillanos10_invoker = createInvoker(
controllers.Application.getVillanos(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getVillanos", Nil,"GET", """""", Routes.prefix + """villanos"""))
        

// @LINE:17
private[this] lazy val controllers_Application_nuevoCaso11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nuevocaso"))))
private[this] lazy val controllers_Application_nuevoCaso11_invoker = createInvoker(
controllers.Application.nuevoCaso(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "nuevoCaso", Nil,"GET", """""", Routes.prefix + """nuevocaso"""))
        

// @LINE:21
private[this] lazy val controllers_Assets_at12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at12_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """iniciar""","""controllers.Application.iniciarJuego()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordendearresto/$villano<[^/]+>""","""controllers.Application.ordenDeArresto2(villano:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """viajar/$pais<[^/]+>""","""controllers.Application.viajar2(pais:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """final""","""controllers.Application.fin()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """pistas""","""controllers.Application.obtenerPistas2()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """conexiones""","""controllers.Application.getConexionesAereas()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paisactual""","""controllers.Application.getPaisActualNombre()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """listaincorrectos""","""controllers.Application.getListaIncorrectos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """listacorrectos""","""controllers.Application.getListaCorrectos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordenemitida""","""controllers.Application.getOrdenDeArrestoEmitida()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """villanos""","""controllers.Application.getVillanos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nuevocaso""","""controllers.Application.nuevoCaso()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_iniciarJuego0_route(params) => {
   call { 
        controllers_Application_iniciarJuego0_invoker.call(controllers.Application.iniciarJuego())
   }
}
        

// @LINE:7
case controllers_Application_ordenDeArresto21_route(params) => {
   call(params.fromPath[String]("villano", None)) { (villano) =>
        controllers_Application_ordenDeArresto21_invoker.call(controllers.Application.ordenDeArresto2(villano))
   }
}
        

// @LINE:8
case controllers_Application_viajar22_route(params) => {
   call(params.fromPath[String]("pais", None)) { (pais) =>
        controllers_Application_viajar22_invoker.call(controllers.Application.viajar2(pais))
   }
}
        

// @LINE:9
case controllers_Application_fin3_route(params) => {
   call { 
        controllers_Application_fin3_invoker.call(controllers.Application.fin())
   }
}
        

// @LINE:10
case controllers_Application_obtenerPistas24_route(params) => {
   call { 
        controllers_Application_obtenerPistas24_invoker.call(controllers.Application.obtenerPistas2())
   }
}
        

// @LINE:11
case controllers_Application_getConexionesAereas5_route(params) => {
   call { 
        controllers_Application_getConexionesAereas5_invoker.call(controllers.Application.getConexionesAereas())
   }
}
        

// @LINE:12
case controllers_Application_getPaisActualNombre6_route(params) => {
   call { 
        controllers_Application_getPaisActualNombre6_invoker.call(controllers.Application.getPaisActualNombre())
   }
}
        

// @LINE:13
case controllers_Application_getListaIncorrectos7_route(params) => {
   call { 
        controllers_Application_getListaIncorrectos7_invoker.call(controllers.Application.getListaIncorrectos())
   }
}
        

// @LINE:14
case controllers_Application_getListaCorrectos8_route(params) => {
   call { 
        controllers_Application_getListaCorrectos8_invoker.call(controllers.Application.getListaCorrectos())
   }
}
        

// @LINE:15
case controllers_Application_getOrdenDeArrestoEmitida9_route(params) => {
   call { 
        controllers_Application_getOrdenDeArrestoEmitida9_invoker.call(controllers.Application.getOrdenDeArrestoEmitida())
   }
}
        

// @LINE:16
case controllers_Application_getVillanos10_route(params) => {
   call { 
        controllers_Application_getVillanos10_invoker.call(controllers.Application.getVillanos())
   }
}
        

// @LINE:17
case controllers_Application_nuevoCaso11_route(params) => {
   call { 
        controllers_Application_nuevoCaso11_invoker.call(controllers.Application.nuevoCaso())
   }
}
        

// @LINE:21
case controllers_Assets_at12_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at12_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     