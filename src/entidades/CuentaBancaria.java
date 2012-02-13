package entidades;

public class CuentaBancaria {
	protected int id;
	protected double saldo;
	protected int SociedadId;
	
	//sets y gets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getSociedadId() {
		return SociedadId;
	}
	public void setSociedadId(int sociedadId) {
		SociedadId = sociedadId;
	}

}
