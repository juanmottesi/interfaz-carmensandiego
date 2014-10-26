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
    
}
