package L2;
import java.util.ArrayList;
public class Book {
	private String title = "";
	private ArrayList<String> authors = new ArrayList<String>();
	private String genre = "";
	private int isbn = 0;
	private boolean fiction = true;
	
	public Book() {
		
	}
	
	public Book(String t, String a, String g, int i, boolean f) {
		title = t;
		authors.add(a);
		genre = g;
		isbn = i;
		fiction = f;
	}
	
	
	
	public void setTitle(String t) {
		title = t;
	}
	public void setAuthor(String a) {
		authors.add(a);
	}
	public void setGenre(String g) {
		genre = g;
	}
	public void setISBN(int i) {
		isbn = i;
	}
	public void setFiction(boolean f) {
		fiction = f;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public String getGenre() {
		return genre;
	}
	public int getISBN() {
		return isbn;
	}
	public boolean isFiction() {
		return fiction;
	}
}
