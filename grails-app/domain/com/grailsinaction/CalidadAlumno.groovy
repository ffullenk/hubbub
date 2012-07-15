package com.grailsinaction

class CalidadAlumno {

	static mapping = {
		table 'calidad_alumno'
		id column:'alu_rut'
		version false
   }
   Integer cod_carrera
   
   
   
    static constraints = {
    }
}

