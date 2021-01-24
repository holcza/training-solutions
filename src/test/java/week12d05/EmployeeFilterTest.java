package week12d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeFilterTest {

    @Test
    public void countSeniorDevsTest(){
        EmployeeFilter ef = new EmployeeFilter();
        List<Employee> el = new ArrayList<>();
        el.add(new Employee(22,1,"Gábor",List.of("programming")));
        el.add(new Employee(30,3,"Ági",List.of("programming")));
        el.add(new Employee(32,3,"László",List.of("programming")));
        el.add(new Employee(33,3,"Lilla",List.of("HR")));
        el.add(new Employee(25,1,"Anna",List.of("programming")));

        List<Employee> employees = ef.countSeniorDevs(el);

        assertEquals(employees.get(0).getName(),"Ági");
        assertEquals(employees.get(1).getName(),"László");
    }
}
