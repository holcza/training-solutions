package week15d04;

public enum CharType {
    CONSONANT ("aáeéiíoóöőuúüű"), VOWEL ("bcdfghjklmnpqrstvwxyz"), OTHER("");

    private String chars;

    CharType(String chars) {
        this.chars = chars;
    }

    public static CharType getType (int c){
        if (CONSONANT.chars.contains(String.valueOf((char)c))){
            return CONSONANT;
        } else if (VOWEL.chars.contains(String.valueOf((char)c))){
            return VOWEL;
        } else {
            return OTHER;
        }
    }


}
