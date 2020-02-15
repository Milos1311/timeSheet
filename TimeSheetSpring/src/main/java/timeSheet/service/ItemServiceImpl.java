package timeSheet.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.ItemDto;
import model.Item;
import timeSheet.repository.ItemRepo;

@Service
public class ItemServiceImpl  implements ItemService {
	
	private ItemRepo itemRepo;
	
	@Autowired
	public ItemServiceImpl(ItemRepo theItemRepo) {
		itemRepo = theItemRepo;
	}
	
	@Override
	public List<ItemDto> getAllByDate(String date) {
		
		return itemRepo.getAll(date);
	}

	@Override
	public Item saveItem(String title, int hours) {
		
		Date d = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		String s = formatter.format(d);
		
		List<ItemDto> itemDto = itemRepo.getAll(s);
		
		int total = 0;
		
		for(ItemDto dto : itemDto) {
			
			total+= dto.getHours();
		}
		
		if(total + hours > 8) {
			
		Item item = new Item();
		
		item.setTitle("Greska");
		item.setHours(total+hours);
		item.setDate(s);
		
		 return item;	
		}
		
		Item item = new Item();
		
		item.setTitle(title);
		item.setHours(hours);
		item.setDate(s);
		
	    item = itemRepo.save(item);
	
		return item;
		
	}
	
	@Override
	public Item findById(int id) {
		
     Optional<Item> result = itemRepo.findById(id);
		
		Item item = null;
		
		if (result.isPresent()) {
			item = result.get();
		}
		else {
			throw new RuntimeException("Did not find item id - " + id);
		}
		
		return item; 
	}

	

	@Override
	public void deleteById(int id) {
		itemRepo.deleteById(id);
		
	}

	@Override
	public List<Item> findAll() {
		
		List<Item> items = itemRepo.findAll();
		
		return items;
	}

	@Override
	public void updateItem(Item item) {
		
		itemRepo.save(item);
		
	}



}
