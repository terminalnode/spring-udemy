package com.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Adding a new controller with duplicate showForm mapping in order
 * to introduce an ambiguous mapping, which will be resolved in the
 * original HelloWorldController.
 */
@Controller
public class SillyController {
  @RequestMapping("/showForm")
  public String showForm() {
    return "helloworld-form";
  }
}
