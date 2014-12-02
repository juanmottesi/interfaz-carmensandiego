package appModel

import java.util.List

class Tupla {
	
	@Property List<String> info
	@Property Boolean estaElVillano
	
	new(List<String> inf , Boolean estaV){
		info = inf
		estaElVillano = estaV
	}
	
}