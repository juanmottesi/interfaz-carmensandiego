package controllers;

import java.util.ArrayList;
import java.util.List;

import dominio.Expediente;
import dominio.Villano;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import appModel.CasoAppModel;
import appModel.PistaAppModel;

public class Application extends Controller {
    
    public static Result iniciarJuego(){
    	response().setContentType("application/json");
    	CasoAppModel caso = CasoAppModel.getInstance();
		return ok(Json.toJson(caso));
    }
        
    public static Result viajar(String pais){
    	response().setContentType("application/json");
    	CasoAppModel caso = CasoAppModel.getInstance().viajar(pais);
		return ok(Json.toJson(caso));
    }
    
    public static Result ordenDeArresto(String villano){
    	response().setContentType("application/json");
    	CasoAppModel.getInstance().ordenDeArresto(villano);
    	return ok(Json.toJson(CasoAppModel.getInstance()));
    }
    
    public static Result fin(){
    	response().setContentType("application/json");
    	String  s = CasoAppModel.getInstance().esFinal(); 
    	return ok(Json.toJson(s));
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
    
    public static Result getOrdenDeArrestoEmitida(){
    	response().setContentType("application/json");
    	String ordenEmitida = CasoAppModel.getInstance().getOrdenEmitida().getNombre();
    	if(!ordenEmitida.equals("null")){
    		return ok(Json.toJson(ordenEmitida));
    	}
    	else{
    		return badRequest();
    	}
    	
    }
    
    public static Result getVillanos(){
    	response().setContentType("application/json");
    	List<Villano> villanos = Expediente.getInstance().getVillanos();
    	List<String> aux = new ArrayList<String>();
    	for(Villano v : villanos){
    		aux.add(v.getNombre());
    	}
    	return ok(Json.toJson(aux));
    }
    
    public static Result obtenerPistas2(){
    	response().setContentType("application/json");
    	List<PistaAppModel> pistas = CasoAppModel.getInstance().generarPistasAppModel();
    	return ok(Json.toJson(pistas));
    }
    
    public static Result nuevoCaso(){
    	response().setContentType("application/json");
    	CasoAppModel.getInstance().nuevoCaso();
    	return ok(Json.toJson("ok"));
    }
    
    public static Result obtenerPistas(String pais){
    	response().setContentType("application/json");
    	List<PistaAppModel> pistas = CasoAppModel.getInstance().generarPistasAppModel(pais);
    	return ok(Json.toJson(pistas));
    }
    
    public static Result ordenDeArresto2(String villano){
    	response().setContentType("application/json");
    	CasoAppModel.getInstance().ordenDeArresto(villano);
    	return ok(Json.toJson("ok"));
    }
    
    
}
