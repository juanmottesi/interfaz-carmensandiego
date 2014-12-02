package com.example.acciones

import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.example.services.PaisesService
import java.util.List
import retrofit.RestAdapter
import android.app.Activity

class Acciones {
	// Crear servicio
	def static crearServicio(){
		val SERVER_IP = "192.168.1.102"//"localhost"//"127.0.0.1" //"10.0.2.2"//"127.0.0.1"//"10.0.2.2" //"localhost"//
		val API_URL = '''http://«SERVER_IP»:9000/'''
		
		val restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build
		val PaisesService paisesService = restAdapter.create(PaisesService)
		paisesService
	}
	
	
	// Views de TextView
	
	def static setTextView(Activity activity, int id, String texto) {
		activity.findViewById(id) as TextView => [text = texto]
	}

	def static setTextView(Activity activity, int id, List<String> lista) {
		var aux = lista.toString
		aux = aux.substring(1,aux.length-1)
		aux.replace(",", "\n")
		val ret = aux
		activity.findViewById(id) as TextView => [text = ret]
	}

	// View de Spinner
	
	def static setSpinnerView(ActivityAbstract activity, int idView, int idVista, int id, List<String> lista) {
		activity.findViewById(idView) as Spinner => [
			adapter = new ArrayAdapter(activity, idVista, id, lista)
			onItemSelectedListener = activity
		]
	}
	
	// View de Button
	
	def static setButtonView(Activity activity, int id, (Object)=>void block){
			activity.findViewById(id) as Button =>[
				onClickListener = new View.OnClickListener(){
					override onClick(View v) {
						 activity => block
					}	
				}
		]
	}
	
	def static setButtonView(Activity activity, int id,String nombreButton ,(Object)=>void block){
			activity.findViewById(id) as Button =>[
				text = nombreButton
				onClickListener = new View.OnClickListener(){
					override onClick(View v) {
						 activity => block
					}	
				}
		]
	}
		
}