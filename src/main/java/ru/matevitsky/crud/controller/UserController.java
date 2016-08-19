package ru.matevitsky.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.matevitsky.crud.domain.User;
import ru.matevitsky.crud.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 13.04.16.
 */
@Controller
@SessionAttributes("filterAtributes")
public class UserController {


    @Autowired
    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static class FilterAtributes{
        private int pageNumber;
        private boolean useFilter;

        @Size(min = 4, message = "Имя болше чем три символа")
        private String filterName;

        public String getFilterName() {
            return filterName;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public boolean isUseFilter() {
            return useFilter;
        }

        public void setUseFilter(boolean useFilter) {
            this.useFilter = useFilter;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public FilterAtributes() {
            this.filterName = "";
            this.pageNumber = 1;
            this.useFilter = false;
        }
    }



    @RequestMapping("form")
    public ModelAndView getForm(@ModelAttribute User user) {
        return new ModelAndView("form");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(Model model) {
        model.addAttribute(new FilterAtributes());
        return new ModelAndView("home");
    }

    @RequestMapping("new")
    public ModelAndView newSession(Model model) {
        model.addAttribute(new FilterAtributes());
        return new ModelAndView("home");
    }

    @RequestMapping("register")
    public ModelAndView registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("form");
        }
        userService.addUser(user);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping("list")
    public ModelAndView getList(@ModelAttribute FilterAtributes filterAtributes) {
        List<User> userList = new ArrayList<User>();
        if (filterAtributes.isUseFilter())
            userList = userService.getList(filterAtributes.getPageNumber(), filterAtributes.getFilterName());
        else
            userList = userService.getList(filterAtributes.getPageNumber());
        return new ModelAndView("list", "userList", userList);
    }

    @RequestMapping("/")
    public ModelAndView firstPage(@ModelAttribute FilterAtributes filterAtributes){
        return new ModelAndView("redirect:list");

    }
    @RequestMapping("delete")
    public ModelAndView deleteUser(@RequestParam int id) {
        userService.removeUser(id);
        return new ModelAndView("redirect:list");
    }


    @RequestMapping("edit")
    public ModelAndView editUser(@RequestParam int id, @ModelAttribute User user) {
        user = userService.getUser(id);
        return new ModelAndView("edit", "user", user);
    }

    @RequestMapping("update")
    public ModelAndView updateUser(@Valid @ModelAttribute User user, BindingResult bindingResult, @RequestParam int id) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("edit", "user", user);
        }
        userService.updateUser(user);
        return new ModelAndView("redirect:list");
    }


    @RequestMapping("previous")
    public ModelAndView previousPage(@ModelAttribute FilterAtributes filterAtributes) {
        if (filterAtributes.getPageNumber() > 1)
            filterAtributes.setPageNumber(filterAtributes.getPageNumber() - 1);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping("next")
    public ModelAndView nextPage(@ModelAttribute FilterAtributes filterAtributes) {
        List<User> userList = new ArrayList<User>();
        if (filterAtributes.isUseFilter())
            userList = userService.getList(filterAtributes.getPageNumber(), filterAtributes.getFilterName());
        else
            userList = userService.getList(filterAtributes.getPageNumber());
        if (!userList.isEmpty()) {
            filterAtributes.setPageNumber(filterAtributes.getPageNumber() + 1);
        }
        return new ModelAndView("redirect:list");
    }
    @RequestMapping("filter")
    public ModelAndView openFilters(@ModelAttribute FilterAtributes filterAtributes) {
        return new ModelAndView("filter");
    }

    @RequestMapping("setFilter")
    public ModelAndView setFilters(@Valid @ModelAttribute FilterAtributes filterAtributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("filter");
        }
        filterAtributes.setPageNumber(1);
        filterAtributes.setUseFilter(true);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping("setNoFilter")
    public ModelAndView setNoFilters(@ModelAttribute FilterAtributes filterAtributes) {
        filterAtributes.setPageNumber(1);
        filterAtributes.setUseFilter(false);
        return new ModelAndView("redirect:list");
    }



    @ExceptionHandler(HttpSessionRequiredException.class)
    public ModelAndView handleHttpSessionRequiredException() {
        return new ModelAndView("exception");
    }




}
