package week03;

import org.junit.jupiter.api.Test;
import week03d05.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    void getResultTest(){

        Operation operation = new Operation("   234   +  345 ");

        assertEquals(579, operation.getResult());


    }


}
