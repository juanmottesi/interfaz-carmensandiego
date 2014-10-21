package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import appModel.CasoAppModel;

import com.fasterxml.jackson.databind.JsonNode;

import dominio.Pais;
import dominio.Villano;

public class Application extends Controller {
    
    public static Result iniciarJuego(){
    	response().setContentType("application/json");
    	CasoAppModel caso = CasoAppModel.getInstance();
    	JsonNode json = Json.toJson(caso);
		return ok(json);
    }
    
    public static Result ordenDeArresto(){
    	return ok(CasoAppModel.getInstance().getOrdenDeArresto());    	
    }
    
    public static Result paisAcutal(){
    	return ok(CasoAppModel.getInstance().paisActual());
    }
    
    public static Result viajar(Pais pais){
    	response().setContentType("application/json");
    	CasoAppModel caso = CasoAppModel.getInstance().viajar(pais);
    	JsonNode json = Json.toJson(caso);
    	return ok(json);
    }
    
    public static Result ordenDeArresto(Villano villano){
    	CasoAppModel.getInstance().setOrdenDeArresto(villano);
    	return ok();
    }
    
}
