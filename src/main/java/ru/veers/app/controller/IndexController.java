package ru.veers.app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController implements ErrorController {

    @Override
    @RequestMapping("/error")
    @ResponseBody
    public String getErrorPath() {
        return "No Mapping Found";
    }

}