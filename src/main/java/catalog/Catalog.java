package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem){
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver (int minNumberOfPages){
        int average = 0;
        int count = 0;
        for(CatalogItem c: getPrintedLibraryItems()){
            if (c.numberOfPagesAtOne()>minNumberOfPages){

                average += c.numberOfPagesAtOne();
                count++;
            }
        }
        if (count==0){
            average = 0;
        } else {
            average /=count;
        }
        return average;
    }

    public void deleteItemByRegistrationNumber (String registrationNumber){
        for (CatalogItem c: catalogItems){
            if (c.getRegistrationNumber().equals(registrationNumber)){
                catalogItems.remove(c);
            }
        }
    }

    public List<CatalogItem> findByCriteria (SearchCriteria searchCriteria){
        List<CatalogItem> catalogItems = new ArrayList<>();
        for (CatalogItem c: catalogItems){
            if (c.getTitle().equals(searchCriteria.getTitle())&&c.getContributors().equals(searchCriteria.getContributor())){
                catalogItems.add(c);
            }
        }
        return catalogItems;
    }

    public int getAllPageNumber(){
        int sum = 0;
        for(CatalogItem c: getPrintedLibraryItems()){
            sum += c.numberOfPagesAtOne();
        }
        return sum;
    }

    public int getFullLenght() {
        int sum = 0;
        for (CatalogItem c :getAudioLibraryItems()) {
            sum +=c.fullLenghtAtOne();
        }
        return sum;
    }
    public List<CatalogItem> getAudioLibraryItems(){
        List<CatalogItem> catalogItems = new ArrayList<>();
        for (CatalogItem c: catalogItems){
            if (c.hasAudioFeature()){
                catalogItems.add(c);
            }
        }
        return catalogItems;
    }

    public List<CatalogItem> getPrintedLibraryItems(){
        List<CatalogItem> catalogItems = new ArrayList<>();
        for (CatalogItem c: catalogItems){
        if (c.hasPrintedFeature()){
            catalogItems.add(c);
        }
        }
        return catalogItems;
    }
}
