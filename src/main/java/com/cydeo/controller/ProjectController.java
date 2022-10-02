package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.ProjectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createProject(Model model) {


        model.addAttribute("project", new ProjectDTO());

        model.addAttribute("managers", userService.findAll());

        model.addAttribute("projects", projectService.findAll());


        return "/project/create";
    }

    @PostMapping("/create")
    public String createProject1(@ModelAttribute("project") ProjectDTO project, Model model) {

        projectService.save(project);

        return "redirect:/project/create";
    }


    @GetMapping("/delete/{projeCtcode}")
    public String deleteProject(@PathVariable String projeCtcode) {
        projectService.deleteById(projeCtcode);

        return "redirect:/project/create";
    }


}
