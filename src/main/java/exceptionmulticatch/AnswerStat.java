package exceptionmulticatch;

public class AnswerStat {
    BinaryStringConverter binaryStringConverter = new BinaryStringConverter();

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert (String s){
        try{
            return binaryStringConverter.binaryStringToBooleanArray(s);
        } catch (NullPointerException | IllegalArgumentException exception){

            throw new InvalidBinaryStringException("binaryString not valid",exception);
        }
    }

    public int answerTruePercent(String answers){
        boolean[] answerInArray =convert(answers);
        int count = 0;
        int countOfTrue =0;
        for (boolean a: answerInArray){
            count++;
            if (a==true){
                countOfTrue++;
            }
        }

        return count == 0 ? 0 : (int)Math.round((double)countOfTrue/count*100);
    }
}
