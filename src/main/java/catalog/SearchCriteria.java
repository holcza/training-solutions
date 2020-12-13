package catalog;

public class SearchCriteria {

    private String contributor;
    private String title;

    private SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public SearchCriteria createByBoth (String contributor,String title){
        return new SearchCriteria(contributor,title);
    }

    public SearchCriteria createByContributor (String contributor){
        return new SearchCriteria(contributor,"");
    }

    public SearchCriteria createByTitle (String title){
        return new SearchCriteria("",title);
    }

    public boolean hasContributor (){
        if (Validators.isBlank(contributor)){
            return false;
        }else {
            return true;
        }
    }

    public boolean hasTitle (){
        if (Validators.isBlank(title)){
            return false;
        }else {
            return true;
        }
    }

}
