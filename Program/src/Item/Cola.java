package Item;

public class Cola {
	private String id, name;
	private int harga, stock;
	
	public Cola(String id, String name, int harga, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.harga = harga;
		this.stock = stock;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getHarga() {
		return harga;
	}
	public int getStock() {
		return stock;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
