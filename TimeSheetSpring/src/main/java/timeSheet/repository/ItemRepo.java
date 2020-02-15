package timeSheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dto.ItemDto;
import model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {
	
	
	@Query(" select new dto.ItemDto( i.idItem , i.title , i.hours)  from Item i where i.date = :d")
	List<ItemDto> getAll( @Param("d") String d);

}
