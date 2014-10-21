package controllers;

import dominio.Detective;
import dummyData.DummyData;
import appModel.JuegoAppModel;
import views.html.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    
    public static Result iniciarJuego(){
    	response().setContentType("application/json");
    	Detective d = new DummyData().crearJuegoDummy();
    	//JuegoAppModel juego = new JuegoAppModel(d);
    	JsonNode json = Json.toJson(d);
		return ok(json);
    }
}
