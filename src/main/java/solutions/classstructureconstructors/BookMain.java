package solutions.classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book=new Book("Rejtő", "Tizennégykarátos autó");
        book.register("12345");
        System.out.println(book.getAuthor()+" - "+book.getTitle()+" - "+book.getRegNumber());
    }
}
