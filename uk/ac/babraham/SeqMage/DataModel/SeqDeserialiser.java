/*package uk.ac.babraham.SeqMage.DataModel;
import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class SeqDeserialiser {

	@Override
	public Seq deserialise (final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
		      throws JsonParseException {
		
		 final JsonObject jsonObject = json.getAsJsonObject();

		    final String title = jsonObject.get("title").getAsString();
		    final String isbn10 = jsonObject.get("isbn-10").getAsString();
		    final String isbn13 = jsonObject.get("isbn-13").getAsString();

		    // Delegate the deserialization to the context
		    Author[] authors = context.deserialize(jsonObject.get("authors"), Author[].class);

		    final Book book = new Book();
		    book.setTitle(title);
		    book.setIsbn10(isbn10);
		    book.setIsbn13(isbn13);
		    book.setAuthors(authors);
		    return book;
	}
}
*/