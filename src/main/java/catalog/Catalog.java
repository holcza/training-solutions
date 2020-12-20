package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    public List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int minNumberOfPages) {
        if (minNumberOfPages<=0){
            throw new IllegalArgumentException("Page number must be positive");
        }
        int average = 0;
        int count = 0;
        for (CatalogItem c : getPrintedLibraryItems()) {
            if (c.numberOfPagesAtOneItem() > minNumberOfPages) {

                average += c.numberOfPagesAtOneItem();
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("No page");
        } else {
            average /= count;
        }
        return average;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        for (CatalogItem c : catalogItems) {
            if (c.getRegistrationNumber().equals(registrationNumber)) {
                catalogItems.remove(c);
                break;
            }
        }
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> catalogItems = new ArrayList<>();
        for (CatalogItem c : this.catalogItems) {
            if ((c.getTitles().contains(searchCriteria.getTitle())||searchCriteria.getTitle()=="")
                    && (c.getContributors().contains(searchCriteria.getContributor())||searchCriteria.getContributor()=="")) {
                catalogItems.add(c);
            }
        }
        return catalogItems;
    }

    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem c : getPrintedLibraryItems()) {
            sum += c.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem c : getAudioLibraryItems()) {
            sum += c.fullLengthAtOneItem();
        }
        return sum;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> catalogItems = new ArrayList<>();
        for (CatalogItem c : this.catalogItems) {
            if (c.hasAudioFeature()) {
                catalogItems.add(c);
            }
        }
        return catalogItems;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> catalogItems = new ArrayList<>();
        for (CatalogItem c : this.catalogItems) {
            if (c.hasPrintedFeature()) {
                catalogItems.add(c);
            }
        }
        return catalogItems;
    }
}
