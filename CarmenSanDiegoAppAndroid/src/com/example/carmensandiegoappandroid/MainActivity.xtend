package com.example.carmensandiegoappandroid


import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.AdapterView
import android.view.View
import java.util.List
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import android.util.Log
import com.example.services.PaisesService
import retrofit.RestAdapter
import android.widget.TextView

class MainActivity extends Activity implements OnItemSelectedListener{

	String aux = ""

	override onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		contentView = R.layout.activity_main
		
		actualizarDatos

	}
	
	
	// iniciarApp
	
	def actualizarDatos(){
		//Pais Actual		
		buscarPaisActual		
	
		//Spinner
		buscarPaises
	}
	
	// Metodos que buscan en el servidor
	
	def buscarPaisActual(){
		val paisesService = crearPaiService		
		paisesService.getPaisActual(
			new Callback<String>(){
				override failure(RetrofitError e) {
					Log.e("", e.message)
						e.printStackTrace
				}
				override success(String nombreDelPais, Response arg1) {
					setNombrePaisActual(nombreDelPais)
				}	
		})
	}
	
	def buscarPaises(){
		val paisesService = crearPaiService
		paisesService.getPaises( 
			new Callback<List<String>>() {
				override failure(RetrofitError e) {
					Log.e("", e.message)
					e.printStackTrace
				}
				override success(List<String> paises, Response response) {
					mostrarPaises(paises)
				}
			})	
	}
	
	// Definiciones de vista
	
	def mostrarPaises(List<String> paises){
		findViewById(R.id.lista_paises) as Spinner => [
			adapter = new ArrayAdapter(this, R.layout.lista_view_pais, R.id.paises_text, paises)
			onItemSelectedListener = this
		]
	}

	def setNombrePaisActual(String nombreDelPais){
		val destino = findViewById(R.id.pais_actual) as TextView
		destino.setText(nombreDelPais)
	}

	// Implementacion de OnItemSelectedListener del Spinner
		
	override onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		val paisSelec = parent.getItemAtPosition(position) as String
		aux = paisSelec
	}
	
	override onNothingSelected(AdapterView<?> parent) {
	}
	
	//Creador del Servicio
	
	def crearPaiService(){
		val SERVER_IP = "192.168.1.101"//"localhost"//"127.0.0.1" //"10.0.2.2"//"127.0.0.1"//"10.0.2.2" //"localhost"//
		val API_URL = '''http://«SERVER_IP»:9000/'''
		
		val restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build
		val PaisesService paisesService = restAdapter.create(PaisesService)
		paisesService
		
	}
	
}