package com.bench.shoppingcart.controller;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/home")
    public String get(Model model) {

        model.addAttribute("Items",homeService.getAllItems());
        return "homePage";
    }
    @GetMapping("/items/add")
    public String addItemToList() {
        return "addItem";
    }
    @PostMapping("/items/add")
    public String addItem(@Valid Item item, Model model){
        homeService.addItem(item);
        return "redirect:/items/add";
    }
}

