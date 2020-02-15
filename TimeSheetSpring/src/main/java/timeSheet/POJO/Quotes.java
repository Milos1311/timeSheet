package timeSheet.POJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"quotes"
})
public class Quotes {

	@JsonProperty("quotes")
	private List<Quote> quotes;
	
	public Quotes() {
		
	}

	@JsonProperty("quotes")
	public List<Quote> getQuotes() {
		return quotes;
	}

	@JsonProperty("quotes")
	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	@Override
	public String toString() {
		return String.format("Quotes [quotes=%s]", quotes);
	}

	
	
}
