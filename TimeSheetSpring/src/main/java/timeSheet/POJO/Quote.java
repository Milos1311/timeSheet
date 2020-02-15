package timeSheet.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"quote",
"author"
})
public class Quote {

	@JsonProperty("quote")
	private String quote;
	
	@JsonProperty("author")
	private String author;
	

	public Quote() {
	}

	@JsonProperty("quote")
	public String getQuote() {
		return quote;
	}

	@JsonProperty("quote")
	public void setQuote(String quote) {
		this.quote = quote;
	}

	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	@JsonProperty("author")
	public void setAuthor(String author) {
		this.author = author;
	}

}
