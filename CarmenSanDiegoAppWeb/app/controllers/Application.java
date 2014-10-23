package controllers;

import java.util.Collection;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import appModel.CasoAppModel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


import dominio.Expediente;
import dominio.Villano;

public class Application extends Controller {
    
    public static Result iniciarJuego(){
    	response().setContentType("application/json");
    	CasoAppModel caso = CasoAppModel.getInstance();
		return ok(Json.toJson(caso));
    }
        
    public static Result getOrdenDeArresto(){
    	return ok(CasoAppModel.getInstance().ordenDeArresto());    	
    }
    
    public static Result getPaisAcutal(){
    	return ok(CasoAppModel.getInstance().paisActual());
    }
    
    public static Result viajar(String pais){
    	CasoAppModel caso = CasoAppModel.getInstance().viajar(pais);
		return ok(Json.toJson(caso));
    	
    }
    
    public static Result ordenDeArresto(String villano){
    	CasoAppModel.getInstance().ordenDeArresto(villano);
    	return ok();
    }
    
    public static Result esFinal(){
    	//return ok(CasoAppModel.getInstance().esFinal());
    	return ok();
    }
        
    public static Result getExpedientes(){
    	response().setContentType("application/json");
    	Collection<Villano> villanos = Expediente.getInstance().getVillanos();
    	return ok(Json.toJson(villanos));
    }
    
}
