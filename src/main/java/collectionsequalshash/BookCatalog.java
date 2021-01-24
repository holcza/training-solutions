package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author){
        for (Book b: books){
            if (b.getAuthor().equals(author)&&b.getTitle().equals(title)){
                return new Book(b.getRegNumber(),b.getTitle(),b.getAuthor());
            }
        }
        return null;
    }

    public Book findBook(List<Book> books, Book book){
        for (Book b: books){
            if (b.equals(book)){
                return b;
            }
        }
        return null;
    }

    public Set<Book> addBooksToSet(Book[] books){
        Set<Book> setBooks = new HashSet<>();
        for (Book b: books){
            setBooks.add(b);
        }
        return setBooks;
    }
}
