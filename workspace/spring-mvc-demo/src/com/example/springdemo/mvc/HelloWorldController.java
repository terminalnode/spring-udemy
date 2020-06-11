package com.example.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
  @RequestMapping("/showForm")
  public String showForm() {
    return "helloworld-form";
  }

  @RequestMapping("/processForm")
  public String processForm() {
    return "helloworld";
  }
  
  @RequestMapping("/PROCESSFORM")
  public String letsShoutDude(HttpServletRequest request, Model model) {
    String name = request.getParameter("studentName");
    name = name.toUpperCase();
    model.addAttribute("message", String.format("WHAT'S UP %s?!", name));
    return "helloworld";
  }
}
