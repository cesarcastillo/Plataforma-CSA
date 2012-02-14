package entidades;
import java.util.Date;

public class Evento {
	
	protected int id;;
	protected int sociedadId;
	protected String nombre;
	protected String descripcion;
	protected Date fechaInicio;
	protected Date fechaFin;
	
	//gets y sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSociedadId() {
		return sociedadId;
	}
	public void setSociedadId(int sociedadId) {
		this.sociedadId = sociedadId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
