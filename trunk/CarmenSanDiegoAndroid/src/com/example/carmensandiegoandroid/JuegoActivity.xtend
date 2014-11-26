package com.example.carmensandiegoandroid

import android.app.Activity
import android.os.Bundle
import appModel.CasoAppModel
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.view.View
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.view.View.OnClickListener


class JuegoActivity extends Activity implements OnClickListener, OnItemSelectedListener{
	
	CasoAppModel casoAppModel;
	
	override def onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)
		casoAppModel = CasoAppModel.getInstance()
		
		setContentView(R.layout.activity_juego)
		
		findViewById(R.id.listaDePaises) as Spinner => [
			adapter = new ArrayAdapter(this, R.layout.list_lista_de_paises, R.id.lista_elem, casoAppModel.casoActual.ciudadActual.conexionesAereas)
			onItemSelectedListener = this
		]
		
		findViewById(R.id.btnViajar) as Button => [
			onClickListener = this
		]
		
	}
	
	override onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		val paisSelec = parent.getItemAtPosition(pos) as String
		casoAppModel.paisSeleccionado = paisSelec
	}
		
	override onNothingSelected(AdapterView<?> arg0) {
	}
	
	override onClick(View v) {
		
	}
	
	
}