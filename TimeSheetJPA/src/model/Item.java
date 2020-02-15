package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idItem;

	private String date;

	private int hours;

	private String title;

	public Item() {
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHours() {
		return this.hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}