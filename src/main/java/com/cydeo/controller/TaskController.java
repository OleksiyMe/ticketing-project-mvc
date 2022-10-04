package com.cydeo.controller;


import com.cydeo.dto.TaskDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/create")
    public String taskCreate(Model model){
        model.addAttribute("task", new TaskDTO());

        return "/task/create";
    }

}
