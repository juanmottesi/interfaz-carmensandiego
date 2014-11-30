package controllers;

import java.util.List;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import appModel.CasoAppModel;

public class Application extends Controller {
    
    public static Result iniciarJuego(){
    	response().setContentType("application/json");
    	CasoAppModel caso = CasoAppModel.getInstance();
		return ok(Json.toJson(caso));
    }
        
    public static Result viajar(String pais){
    	CasoAppModel caso = CasoAppModel.getInstance().viajar(pais);
		return ok(Json.toJson(caso));
    }
    
    public static Result ordenDeArresto(String villano){
    	CasoAppModel.getInstance().ordenDeArresto(villano);
    	return ok();
    }
    
    public static Result fin(){
    	return ok(CasoAppModel.getInstance().esFinal());
    }
    
    public static Result obtenerPistas(){
    	response().setContentType("application/json");
    	List<List<String>> pistas = CasoAppModel.getInstance().generarPistas();
    	return ok(Json.toJson(pistas));
    }
    
    public static Result getConexionesAereas(){
    	response().setContentType("application/json");
    	List<String> paises = CasoAppModel.getInstance().getCasoActual().getCiudadActual().getConexionesAereas();
    	return ok(Json.toJson(paises));
    }
    
    public static Result getPaisActualNombre(){
    	response().setContentType("application/json");
    	String nombreDelPais = CasoAppModel.getInstance().getCasoActual().getCiudadActual().getNombreDelPais();
    	return ok(Json.toJson(nombreDelPais));
    }
    
    public static Result viajar2(String pais){
    	CasoAppModel.getInstance().viajar(pais);
		return ok(Json.toJson("ok"));
    }
    
    public static Result getListaCorrectos(){
    	response().setContentType("application/json");
    	String listaCorrectos= CasoAppModel.getInstance().getStringPaisesVisitadosCorrectos();
    	return ok(Json.toJson(listaCorrectos));
    }
    
    public static Result getListaIncorrectos(){
    	response().setContentType("application/json");
    	String listaIncorrectos= CasoAppModel.getInstance().getStringPaisesVisitadosIncorrectos();
    	return ok(Json.toJson(listaIncorrectos));
    }
    
}
