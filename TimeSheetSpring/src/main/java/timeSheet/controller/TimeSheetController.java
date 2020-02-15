package timeSheet.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.ItemDto;
import model.Item;
import timeSheet.POJO.Quote;
import timeSheet.POJO.Quotes;
import timeSheet.service.ItemService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class TimeSheetController {
	
	
	private ItemService itemService;
	
	
	@Autowired
	public TimeSheetController(ItemService itemService) {
		this.itemService = itemService;
	}
	

	@GetMapping("/quotes")
	public Quote getRandomQuote() {

		ObjectMapper mapper = new ObjectMapper();
		Quote pom = null;
		
		try {
			Quotes quotes = mapper.readValue(new File("data/quotes.json"), Quotes.class);
			List<Quote> quote = quotes.getQuotes();

			int j = (int) (Math.random() * (quote.size() - 1));
			pom = quote.get(j);

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return pom;
	}

	
	
	@GetMapping("/items/{date}")
	public List<ItemDto> getAllByDate( @PathVariable String date) {
		
		List<ItemDto> items = itemService.getAllByDate(date);
		
       return  items;

	}
	
	@GetMapping("/items")
	public List<Item> getAllItems() {
		
		List<Item> items = itemService.findAll();
		
       return  items;

	}
	
	
	
	@PostMapping("/saveItem/{title}/{hours}")
	public  Item saveItem(@PathVariable String title, @PathVariable int hours) {
		
	    Item item = itemService.saveItem(title, hours);
	    
		return item ;
	}
	
	
	
	 @DeleteMapping("/deleteItem/{idItem}")
      public String deleteItem(@PathVariable int idItem) {
		
		Item tempItem = itemService.findById(idItem);
		
		if (tempItem == null) {
			throw new RuntimeException("Item id not found - " + idItem);
		}
		
		itemService.deleteById(idItem);
		
		return "Deleted item id - " + idItem;
	}
	
	
	@PutMapping("/updateItemHours/{idItem}/{hours}")
	public String updateHours(@PathVariable int idItem , @PathVariable int hours) {
		Item item = itemService.findById(idItem);
		
		item.setHours(hours);
		
	    itemService.updateItem(item);
	    
		return "Update hours for item id - " + idItem;
	}
	
	
	@PutMapping("/updateItemTitle/{idItem}/{title}")
	public String updateTitle(@PathVariable int idItem , @PathVariable String title) {
		Item item = itemService.findById(idItem);
		
		item.setTitle(title);
		
	    itemService.updateItem(item);
	    
		return  "Update title for item id - " + idItem;
	}
	
	
	
	
//  @GetMapping("/items")
//	public List<Item> getAllItems(Model model, HttpServletRequest request) {
//		@SuppressWarnings("unchecked")
//		List<Item> item = (List<Item>) request.getSession().getAttribute("item");
//		
//
//		if (item == null) {
//			item = new ArrayList<>();
//		}
//	
//		model.addAttribute("sessionMessages", item);
//		
//		System.out.println(item);
//
//		return item;
//
//	}
	
//	@RequestMapping(value = "/saveItem/{title}/{hours}", method = RequestMethod.POST)
//	public  List<Item> saveItem(@PathVariable String title, @PathVariable int hours, HttpServletRequest request) {
//
//		@SuppressWarnings("unchecked")
//		List<Item> item = (List<Item>) request.getSession().getAttribute("item");
//		if (item == null) {
//			item = new ArrayList<>();
//			request.getSession().setAttribute("item", item);
//		}
//		
//		Item i = new Item();
//		i.setTitle(title);
//		i.setHours(hours);
//		Date d = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		String s = formatter.format(d);
//		i.setDate(s);
//		
//		item.add(i);
//		request.getSession().setAttribute("item",item);
//		return item;
//	}
	
	
}
