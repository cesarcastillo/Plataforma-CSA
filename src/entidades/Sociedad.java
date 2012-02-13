package entidades;

import java.sql.Date;

public class Sociedad {
	
	protected int id;
	protected String nombre;
	protected String nombreMesa;
	protected Date fechaInicio;
	protected Date fechaFin;
	
	//gets y sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreMesa() {
		return nombreMesa;
	}
	public void setNombreMesa(String nombreMesa) {
		this.nombreMesa = nombreMesa;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
