package week06d02;

public class CountByCategory {
    private final Category category;
    private final int count;

    public CountByCategory(Category category, int count) {
        this.category = category;
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public int getCount() {
        return count;
    }
}
