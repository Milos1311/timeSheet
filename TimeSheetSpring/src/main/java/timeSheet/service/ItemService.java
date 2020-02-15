package timeSheet.service;

import java.util.List;

import dto.ItemDto;
import model.Item;

public interface ItemService {

	List<Item> findAll();

	List<ItemDto> getAllByDate(String date);

	Item saveItem(String title, int hours);

	Item findById(int id);

	void deleteById(int id);
	
	void updateItem (Item item);
}
