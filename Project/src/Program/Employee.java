package Program;


public class Employee {
	
	
	public String kode, nama, kelamin;
	int gaji;
	/**
	 * @param kode
	 * @param nama
	 * @param kelamin
	 * @param gaji
	 */
	public Employee(String kode, String nama, String kelamin, int gaji) {
		this.kode = kode;
		this.nama = nama;
		this.kelamin = kelamin;
		this.gaji = gaji;
	}
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getKelamin() {
		return kelamin;
	}
	public void setKelamin(String kelamin) {
		this.kelamin = kelamin;
	}
	public int getGaji() {
		return gaji;
	}
	public void setGaji(int gaji) {
		this.gaji = gaji;
	}
	
	/**
	 * @param kode
	 * @param nama
	 * @param kelamin
	 */
	


}
