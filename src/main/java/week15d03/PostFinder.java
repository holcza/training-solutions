package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PostFinder {

    private List<Post> postList = new ArrayList<>();

    public PostFinder(List<Post> postList) {
        this.postList = postList;
    }

    public List<Post> findPosts(String user){
        return postList.stream()
                .filter(post -> post.getPublishedAt().isBefore(LocalDate.now())||post.getOwner().equals(user))
                .filter(post -> post.getContent() != null && !post.getContent().isBlank())
                .filter(post -> post.getTitle() != null && !post.getTitle().isBlank())
                .filter(post -> post.getDeletedAt() == null || post.getDeletedAt().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Post> postList = new ArrayList<>();
        postList.add(new Post("aaa",LocalDate.of(1990,11,11),LocalDate.of(1990,11,20),"bb","cc"));
        postList.add(new Post("aaa",LocalDate.of(1990,11,11),null,"","cc"));
        postList.add(new Post("",LocalDate.of(1990,11,11),null,"bb","cc"));
        postList.add(new Post("aaa",LocalDate.of(1990,11,11),null,"bb","cc"));
        postList.add(new Post("aaa",LocalDate.of(2023,11,11),LocalDate.of(2023,11,20),"bb","cc"));

        System.out.println(new PostFinder(postList).findPosts("cc"));
        System.out.println(new PostFinder(postList).findPosts("dd"));
    }
}
