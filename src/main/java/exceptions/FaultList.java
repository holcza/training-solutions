package exceptions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public List<String> processLines(List<String> lines){
        if(lines==null){
            throw new IllegalArgumentException();
        }

        List<String> processLines = new ArrayList<>();

        for (String l: lines){
            String[] line = l.split(",");
            ProcessingResult fault = process(line);
            if (fault != ProcessingResult.COMMENT && fault != ProcessingResult.NO_ERROR){

                String s = line[0] +","+fault.getCode();
                processLines.add(s);
            }
        }
        return processLines;
    }

    public ProcessingResult process (String[] line){

        if (line.length!=3){
            return ProcessingResult.WORD_COUNT_ERROR;
        }

        boolean isComment = isValidInteger(line[0]);


        boolean isValidDouble = isValidDouble(line [1]);


        boolean isValidDate = isValidDate(line[2]);

        if (!isComment){
            return ProcessingResult.COMMENT;
        }

        if (!isValidDate&&!isValidDouble){
            return ProcessingResult.VALUE_AND_DATE_ERROR;
        }

        if(!isValidDouble){
            return ProcessingResult.VALUE_ERROR;
        }

        if(!isValidDate){
            return ProcessingResult.DATE_ERROR;
        }

        return ProcessingResult.NO_ERROR;
    }


    private boolean isValidDate(String word) {
        try {
            DateFormat date = new SimpleDateFormat("yyyy.MM.dd.");
            date.parse(word);
            return true;
        } catch (Exception e){

            return false;
        }
    }

    private boolean isValidDouble(String word) {
        try {
            double value = Double.parseDouble(word);
            return true;
        } catch (Exception e){

            return false;
        }

    }


    private boolean isValidInteger(String word) {
        try{
            int raw = Integer.parseInt(word);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
