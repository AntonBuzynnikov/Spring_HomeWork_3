package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public void processRegistration(String name, int age, String email){
        User user = userService.createUser(name,age,email);
        dataProcessingService.addUser(user);
        notificationService.sendNotification("Пользователь " + user + " зарегистрирован!");
    }

}
