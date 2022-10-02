package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {

        UserDTO userDTO = new UserDTO();
        userDTO.setGender(Gender.MALE);

        model.addAttribute("user", userDTO);
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/create";
    }


    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user) {

        userService.save(user);

        return "redirect:/user/create";

    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable String username, Model model) {


        model.addAttribute("user", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());


        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO user) {
        //      public String updateUser( UserDTO user){    can be put this way
        userService.update(user);
        return "redirect:/user/create";
    }





   @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username, Model model) {
        userService.deleteById(username);

        return "redirect:/user/create";
    }


}

