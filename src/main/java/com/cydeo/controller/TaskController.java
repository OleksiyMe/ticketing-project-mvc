package com.cydeo.controller;


import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final ProjectService projectService;
    private final UserService userService;

    private final TaskService taskService;
    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String taskCreate(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());

        return "/task/create";
    }

    @PostMapping("/create")
public String insertTask(@ModelAttribute TaskDTO task){

        taskService.save(task);

        return "redirect:/task/create";
    }



    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){

        taskService.deleteById(id);

        return "redirect:/task/create";
    }


    @GetMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") Long taskId, Model model){

        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());


        return "/task/update";
    }

   /* @PostMapping("/update/{taskId}")
    public String updateTask1(@PathVariable("taskId") Long taskId, @ModelAttribute TaskDTO task){
        task.setId(taskId);

        taskService.save(task);
        return "redirect:/task/create";
    }*/

    @PostMapping("/update/{ID}")
    public String updateTask1(TaskDTO task){


        taskService.save(task);
        return "redirect:/task/create";
    }

}
