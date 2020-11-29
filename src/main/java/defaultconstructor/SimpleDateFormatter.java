package defaultconstructor;

public class SimpleDateFormatter {

    private CountryCode defaultCountryCode;

    public SimpleDateFormatter(){
        defaultCountryCode = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate){
        return String.format("%d-%d-%d",simpleDate.getYear(),simpleDate.getMonth(),simpleDate.getDay());
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate){
        if (countryCode==CountryCode.HU){
            return String.format("%d-%d-%d",simpleDate.getYear(),simpleDate.getMonth(),simpleDate.getDay());
        } else if (countryCode==CountryCode.EN){
            return String.format("%d-%d-%d",simpleDate.getDay(),simpleDate.getMonth(),simpleDate.getYear());
        }else{
            return String.format("%d-%d-%d",simpleDate.getMonth(),simpleDate.getDay(),simpleDate.getYear());
        }

    }
}
