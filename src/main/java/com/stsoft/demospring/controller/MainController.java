package com.stsoft.demospring.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import com.stsoft.demospring.entity.Role;
import com.stsoft.demospring.entity.Task;
import com.stsoft.demospring.entity.User;
import com.stsoft.demospring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

@Controller
public class MainController {

    @Autowired
    private TaskService taskService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/index")
    public String getAll(Model model, @AuthenticationPrincipal User user) {
//        List<Task> taskList = taskService.getAll();
        List<Task> taskList = null;
        System.out.println(user.getUsername());
        if (user.getRoles().contains(Role.ADMIN)) {
            taskList = taskService.getAll();
        } else {
            taskList = taskService.getAllUserRecords(user);
        }
        // List<Task>
        model.addAttribute("taskList", taskList);
        model.addAttribute("taskSize", taskList.size());
        return "index";
    }

    @GetMapping("/")
    public String startPage(Model model) {
        return "home";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.delete(id);
        return "redirect:/index";
    }

    @RequestMapping("/edit/{id}")
    public String editTask(@PathVariable int id, Model model) {
        taskService.edit(id);
        Optional<Task> task1 = taskService.getAll().stream().filter(find -> find.getId() == id).findFirst();
        Task task2 = task1.get();
        model.addAttribute("task2", task2);
        return "edit";
//        return "redirect:/";
    }

    @GetMapping("/hello")
    public String helloPage(Model model, Principal principal) {
        String userName = principal.getName();
        model.addAttribute("name", userName);
        // taskService.save(task);
        return "hello";
    }

    @PostMapping("/add")
    public String addTask(@AuthenticationPrincipal User user, @RequestParam("file") MultipartFile file,
            @ModelAttribute Task task) throws IllegalStateException, IOException {
        if (file != null  && !file.isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            task.setFilename(resultFilename);
        }
        task.setUser(user);
        taskService.save(task);
        return "redirect:/index";
//        return "/index";
    }

    @PostMapping("/change")
    public String changeTask(@ModelAttribute Task task, @AuthenticationPrincipal User user) {
        task.setUser(user);
        taskService.save(task);
        return "redirect:/index";
    }
}