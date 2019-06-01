package librarymanagement.po;

import java.util.List;


public class Menu {
	private int mid;
	private String mtitle;
	private int pid;
	private String path;
	private int display;
	private int morder;
	private List<Menu> list;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public int getMorder() {
		return morder;
	}
	public void setMorder(int morder) {
		this.morder = morder;
	}
	public List<Menu> getList() {
		return list;
	}
	public void setList(List<Menu> list) {
		this.list = list;
	}
	
}
