package com.shdev.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    @RequestMapping
    public String getIndexPage() {
//        return "index";
        return "redirect:/tool";
    }
}
