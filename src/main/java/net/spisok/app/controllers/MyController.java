package net.spisok.app.controllers;

import net.spisok.app.dao.DaoThings;
import net.spisok.app.model.NameProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
    @Autowired
    private DaoThings dao;
//    @GetMapping("/new")
//    public String newThing(Model model,@ModelAttribute("thing") Thing thing){
//        return "new";
//
//    }
    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("things",dao.index());
        return "show";
    }

    @GetMapping("/new")
    public String NewProduct(@ModelAttribute("thing") NameProduct thing){
        return "/new";
    }

    @PostMapping("/create")
    public String createThing(@ModelAttribute("thing") NameProduct thing ){
        dao.save(thing.getName());
        return "redirect:/show";
    }
    @GetMapping("/del/{id}")
    public String delThing(@PathVariable("id") int id){
        dao.delete(id);
        return "redirect:/show";
    }
    @GetMapping("/change/{id}")
    public String change(@PathVariable("id") int id){
        dao.changeStatus(id);
        return "redirect:/show";
    }

}
