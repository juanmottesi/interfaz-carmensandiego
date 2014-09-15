package dominio

import java.util.List

interface Ocupante {
	
}

class Cuidador implements Ocupante {
	
}

class Informante implements Ocupante{
	@Property List<String> informacion
	
	new(List<String> info) {
		informacion = info
	}
	
}