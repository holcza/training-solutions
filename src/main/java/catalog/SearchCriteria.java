package catalog;

public class SearchCriteria {

    private String contributor;
    private String title;

    private SearchCriteria(String title, String contributor) {
        this.contributor = contributor;
        this.title = title;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    static public SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(contributor)||Validators.isBlank(title)){
            throw new IllegalArgumentException();
        }
        return new SearchCriteria( title, contributor);
    }

    static public SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)){
            throw new IllegalArgumentException();
        }
        return new SearchCriteria("", contributor);
    }

    static public SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)){
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(title,"");
    }

    public boolean hasContributor() {
        if (Validators.isBlank(contributor)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasTitle() {
        if (Validators.isBlank(title)) {
            return false;
        } else {
            return true;
        }
    }

}
