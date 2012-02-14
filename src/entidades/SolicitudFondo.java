package entidades;

public class SolicitudFondo {
	
	protected int id;
	protected int sociedadId;
	protected int cuentaId;
	protected String concepto;
	protected double monto;
	protected double interes;
	
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
	public int getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(int cuentaId) {
		this.cuentaId = cuentaId;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}	
	
	}
	
	