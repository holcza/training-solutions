package catalog;

import week06d02.Product;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private String registrationNumber;
    private int price;
    private List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, List<Feature> features) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features = features;
    }

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        for (Feature f: feature){

            features.add(f);
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public List<String> getContributors() {
        List<String> cotributors = new ArrayList<>();
        for (Feature f : features) {
            cotributors.addAll(f.getContributors());
        }
        return cotributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature f : features) {
            titles.add(f.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature() {
        boolean hasAudioFeauture = false;
        for (Feature f : features) {
            if (f instanceof AudioFeatures) {
                hasAudioFeauture = true;
            }
        }
        return hasAudioFeauture;
    }

    public boolean hasPrintedFeature() {
        boolean hasPrintedFeauture = false;
        for (Feature f : features) {
            if (f instanceof PrintedFeatures) {
                hasPrintedFeauture = true;
            }
        }
        return hasPrintedFeauture;
    }

    public int fullLengthAtOneItem() {
        int sum = 0;
        for (Feature f : features) {
            if (f instanceof AudioFeatures) {
                sum += ((AudioFeatures) f).getLength();
            }
        }
        return sum;
    }

    public int numberOfPagesAtOneItem() {
        int sum = 0;
        for (Feature f : features) {
            if (f instanceof PrintedFeatures) {
                sum += ((PrintedFeatures) f).getNumberOfPages();
            }
        }
        return sum;
    }
}
