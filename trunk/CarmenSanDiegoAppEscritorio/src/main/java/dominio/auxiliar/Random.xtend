package dominio.auxiliar

class Random {
	
	def static int obtenerRandom(int min, int max){
		if(min < max){
			var nRandom = (Math.random * max) as int
			if (nRandom >= min){
				nRandom
			}
			else{
				obtenerRandom(min, max)
			}
		}
		else{
			min
		}
	}
	
}