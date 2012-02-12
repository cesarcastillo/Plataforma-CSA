package entidades;

public class Usuario {

	protected int id;
	protected int tipo;
	protected int sociedadId;
	protected String matricula;
	protected String password;
	protected String nombre;
	protected String permisos;
	
	
	//setters y getters (autogenerados)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getSociedadId() {
		return sociedadId;
	}
	public void setSociedadId(int sociedadId) {
		this.sociedadId = sociedadId;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}
	
	
}
