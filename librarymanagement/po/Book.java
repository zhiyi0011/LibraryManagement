package librarymanagement.po;

public class Book {
	private int book_id;
	private String bname;
	private String bauthor;
	private String borrow;
	private String btype;
	private String Inventory;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBorrow() {
		return borrow;
	}
	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getInventory() {
		return Inventory;
	}
	public void setInventory(String inventory) {
		Inventory = inventory;
	}
	
}
