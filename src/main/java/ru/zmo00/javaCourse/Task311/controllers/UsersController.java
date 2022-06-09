package ru.zmo00.javaCourse.Task311.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zmo00.javaCourse.Task311.models.User;
import ru.zmo00.javaCourse.Task311.services.UserServiceInterface;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserServiceInterface userService;

    @Autowired
    public UsersController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("userList", userService.readAll());
        return "views/users/index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "views/users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "views/users/new";
        }

        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.read(id));
        return "views/users/showUser";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.read(id));
        return "views/users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "views/users/edit";
        }

        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(userService.read(id));
        return "redirect:/users";
    }

}
