package controllers;



import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import appModel.CasoAppModel;

import dominio.Lugar;


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
    
    public static Result getPistas(String lugar){
    	response().setContentType("application/json");
    	String pistas = "";
    	for(Lugar l : CasoAppModel.getInstance().getCasoActual().getCiudadActual().getLugaresDeInteres()){
    		if(l.getNombreDelLugar().equals(lugar)){
    			for(String s : l.getOcupante().pista(CasoAppModel.getInstance().getCasoActual().getVillano())){
    				pistas += " "+s;
    			}
    			  
    		}
    	}
    	
    	return ok(Json.toJson(pistas));
    }
    
}
