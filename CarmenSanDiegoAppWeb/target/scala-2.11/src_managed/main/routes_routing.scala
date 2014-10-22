// @SOURCE:C:/Users/juan/Documents/facultad/CarmenSanDiegoAppWeb/conf/routes
// @HASH:8989b59e4e202bff8c00ff5bb7b8a186f435157e
// @DATE:Wed Oct 22 01:40:41 ART 2014


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
private[this] lazy val controllers_Application_getOrdenDeArresto1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordendearresto"))))
private[this] lazy val controllers_Application_getOrdenDeArresto1_invoker = createInvoker(
controllers.Application.getOrdenDeArresto(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getOrdenDeArresto", Nil,"GET", """""", Routes.prefix + """ordendearresto"""))
        

// @LINE:8
private[this] lazy val controllers_Application_getPaisAcutal2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paisactual"))))
private[this] lazy val controllers_Application_getPaisAcutal2_invoker = createInvoker(
controllers.Application.getPaisAcutal(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getPaisAcutal", Nil,"GET", """""", Routes.prefix + """paisactual"""))
        

// @LINE:9
private[this] lazy val controllers_Application_ordenDeArresto3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ordendearresto/"),DynamicPart("villano", """[^/]+""",true))))
private[this] lazy val controllers_Application_ordenDeArresto3_invoker = createInvoker(
controllers.Application.ordenDeArresto(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ordenDeArresto", Seq(classOf[String]),"POST", """""", Routes.prefix + """ordendearresto/$villano<[^/]+>"""))
        

// @LINE:10
private[this] lazy val controllers_Application_viajar4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("viajar/"),DynamicPart("pais", """[^/]+""",true))))
private[this] lazy val controllers_Application_viajar4_invoker = createInvoker(
controllers.Application.viajar(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "viajar", Seq(classOf[String]),"POST", """""", Routes.prefix + """viajar/$pais<[^/]+>"""))
        

// @LINE:11
private[this] lazy val controllers_Application_esFinal5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("final"))))
private[this] lazy val controllers_Application_esFinal5_invoker = createInvoker(
controllers.Application.esFinal(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "esFinal", Nil,"GET", """""", Routes.prefix + """final"""))
        

// @LINE:12
private[this] lazy val controllers_Application_getExpedientes6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("expedientes"))))
private[this] lazy val controllers_Application_getExpedientes6_invoker = createInvoker(
controllers.Application.getExpedientes(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getExpedientes", Nil,"GET", """""", Routes.prefix + """expedientes"""))
        

// @LINE:16
private[this] lazy val controllers_Assets_at7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at7_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """iniciar""","""controllers.Application.iniciarJuego()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordendearresto""","""controllers.Application.getOrdenDeArresto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paisactual""","""controllers.Application.getPaisAcutal()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ordendearresto/$villano<[^/]+>""","""controllers.Application.ordenDeArresto(villano:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """viajar/$pais<[^/]+>""","""controllers.Application.viajar(pais:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """final""","""controllers.Application.esFinal()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """expedientes""","""controllers.Application.getExpedientes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_Application_getOrdenDeArresto1_route(params) => {
   call { 
        controllers_Application_getOrdenDeArresto1_invoker.call(controllers.Application.getOrdenDeArresto())
   }
}
        

// @LINE:8
case controllers_Application_getPaisAcutal2_route(params) => {
   call { 
        controllers_Application_getPaisAcutal2_invoker.call(controllers.Application.getPaisAcutal())
   }
}
        

// @LINE:9
case controllers_Application_ordenDeArresto3_route(params) => {
   call(params.fromPath[String]("villano", None)) { (villano) =>
        controllers_Application_ordenDeArresto3_invoker.call(controllers.Application.ordenDeArresto(villano))
   }
}
        

// @LINE:10
case controllers_Application_viajar4_route(params) => {
   call(params.fromPath[String]("pais", None)) { (pais) =>
        controllers_Application_viajar4_invoker.call(controllers.Application.viajar(pais))
   }
}
        

// @LINE:11
case controllers_Application_esFinal5_route(params) => {
   call { 
        controllers_Application_esFinal5_invoker.call(controllers.Application.esFinal())
   }
}
        

// @LINE:12
case controllers_Application_getExpedientes6_route(params) => {
   call { 
        controllers_Application_getExpedientes6_invoker.call(controllers.Application.getExpedientes())
   }
}
        

// @LINE:16
case controllers_Assets_at7_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at7_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     