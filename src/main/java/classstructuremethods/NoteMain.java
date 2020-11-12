package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {
        Note note=new Note();
        note.setName("Ági");
        note.setTopic("bevásárlás");
        note.setText("tojás, alma, kenyér, tej");
        note.getNoteText();
    }
}
