package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.example3_sem3_hometask.services.RegistrationService;
import ru.gb.example3_sem3_hometask.domain.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "User added from body!";
    }
    @PostMapping("/params")
    public String userAddFromParam(@RequestParam(name = "name") String name,
                                   @RequestParam(name = "age") int age,
                                   @RequestParam(name = "email") String email){
        service.processRegistration(name,age,email);
        return "User added from params";
    }
}
