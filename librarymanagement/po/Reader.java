package librarymanagement.po;

public class Reader {

	private int Reader_id;
	private int Library_id;
	private String Rname;
	private String Sex;
	private String Depart;

	public int getReader_id() {
		return Reader_id;
	}

	public void setReader_id(int reader_id) {
		Reader_id = reader_id;
	}

	public int getLibrary_id() {
		return Library_id;
	}

	public void setLibrary_id(int library_id) {
		Library_id = library_id;
	}

	public String getRname() {
		return Rname;
	}

	public void setRname(String rname) {
		Rname = rname;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getDepart() {
		return Depart;
	}

	public void setDepart(String depart) {
		Depart = depart;
	}

}
