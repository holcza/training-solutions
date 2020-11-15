package intormethods;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TodoListMain {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        todoList.addTodo("vásárlás");
        todoList.addTodo("Java tanulás");
        todoList.addTodo("Java gyakorlás");
        todoList.addTodo("munka");

        todoList.finishTodos("munka");

        todoList.finishAllTodos(Arrays.asList("Java tanulás", "Java gyakorlás"));

        System.out.println(todoList.todosToFinish());
        System.out.println(todoList.numberOfFinishedTodos());

    }


}
