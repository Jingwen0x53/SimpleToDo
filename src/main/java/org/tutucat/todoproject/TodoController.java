package org.tutucat.todoproject;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/todo")
public class TodoController {

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    @GetMapping("/init")
    public List<ToDo> getAllTodos() {
        return Arrays.asList(
                new ToDo("Learn Vue.js", true),
                new ToDo("Build a ToDo app", false)
        );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    @GetMapping("/m_init")
    public String getAllTodosMS() {
        Gson gson = new Gson();
        System.out.println("manual serialization");
        return gson.toJson(Arrays.asList(
                new ToDo("Learn Vue.js", true),
                new ToDo("Build a ToDo app", false)
        ));
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    @RequestMapping("/add")
    public void addTask(@RequestBody ToDo toDo) {

        Gson gson = new Gson();
        gson = gson.newBuilder().setPrettyPrinting().create();
        String toDoJsonString = gson.toJson(toDo);
        System.out.println(toDoJsonString);

        String str = "{\n" +
                "  \"taskName\": \"shopping\",\n" +
                "  \"completed\": false\n" +
                "}";
        System.out.println("========================================");
        System.out.println(str);

        ToDo toDo1 = gson.fromJson(str, ToDo.class);

        toDo1.setTaskName("studying");

        str = gson.toJson(toDo1);


    }



}
