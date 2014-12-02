package com.example.carmensandiegoappandroid

import android.app.Activity
import com.example.acciones.Acciones
import android.os.Bundle

class FinActivity extends Activity{
	
	override onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);		
		contentView = R.layout.dialog_final
		
		Acciones.setTextView(this,R.id.text_final,"PUUTO")
	
		
	}
	
}