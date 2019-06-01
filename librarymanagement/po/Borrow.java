package librarymanagement.po;

public class Borrow {

	private int Borrow_id;
	private int Reader_id;
	private int book_id;
	private String Borrow_date;
	private String Send_date;
	private String Continue_send;

	public int getBorrow_id() {
		return Borrow_id;
	}

	public void setBorrow_id(int borrow_id) {
		Borrow_id = borrow_id;
	}

	public int getReader_id() {
		return Reader_id;
	}

	public void setReader_id(int reader_id) {
		Reader_id = reader_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBorrow_date() {
		return Borrow_date;
	}

	public void setBorrow_date(String borrow_date) {
		Borrow_date = borrow_date;
	}

	public String getSend_date() {
		return Send_date;
	}

	public void setSend_date(String send_date) {
		Send_date = send_date;
	}

	public String getContinue_send() {
		return Continue_send;
	}

	public void setContinue_send(String continue_send) {
		Continue_send = continue_send;
	}

}
