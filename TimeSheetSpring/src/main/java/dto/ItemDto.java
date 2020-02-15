package dto;

public class ItemDto {

	private int idItem;
	private String title;
	private int hours;
	
	public ItemDto(int idItem, String title, int hours) {
		this.idItem = idItem;
		this.title = title;
		this.hours = hours;
	}
	
	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
