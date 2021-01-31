package week13d03;

import java.util.*;

public class BookAnalyser {


    public void mapAuthors (List<Book> bookList){
        Map<String, Integer> authorsWithNumberOfPages = createMapOfAuthorsWithSumPages(bookList);

        findAuthorWithMaxPages(authorsWithNumberOfPages);
    }

    private Map<String, Integer> createMapOfAuthorsWithSumPages(List<Book> bookList) {
        Map<String, Integer> authorsWithNumberOfPages = new HashMap<>();
        if (bookList !=null){

            for (Book b: bookList){

                authorsWithNumberOfPages.merge(b.getAuthor(),b.getNumberOfPages(),
                        Integer::sum);
            }
        }
        return authorsWithNumberOfPages;
    }

    private void findAuthorWithMaxPages(Map<String, Integer> authorsWithNumberOfPages) {
        int max = 0;
        String authorWithMaxPages = null;
        for (Map.Entry<String,Integer> a: authorsWithNumberOfPages.entrySet()){
            if (a.getValue()>max){
                max = a.getValue();
                authorWithMaxPages = a.getKey();
            }
        }

        System.out.println(authorWithMaxPages);
    }

    public static void main(String[] args) {
        BookAnalyser bookAnalyser = new BookAnalyser();
        List<Book> books = new ArrayList<>();
        books.add(new Book("aa","xx",3));
        books.add(new Book("aa","xx",3));
        books.add(new Book("bb","xx",10));
        books.add(new Book("cc","xx",3));
        books.add(new Book("cc","xx",30));
        bookAnalyser.mapAuthors(books);
    }


}
