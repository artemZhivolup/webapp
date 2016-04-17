package ru.mai.dep806.mvcapp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.mai.dep806.mvcapp.dao.MockUserDao;
import ru.mai.dep806.mvcapp.model.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.stereotype.Controller
public class UserController {
    private MockUserDao userDao = new MockUserDao();

    @RequestMapping("/users.html")
    public ModelAndView listUsers(){
        return new ModelAndView("/WEB-INF/jsp/users.jsp", "users", userDao.getAllUsers());
    }

    @RequestMapping(value = "/addUser.html", method = RequestMethod.GET)
    public String createUser(Model model){
        User user = new User();
        user.setActive(true);
        model.addAttribute("user", user);
        return "WEB-INF/jsp/addEditUser.jsp";
    }

    @RequestMapping(value = "/editUser.html", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long id, Model model){
        model.addAttribute("user", userDao.findUserById(id));
        return "WEB-INF/jsp/addEditUser.jsp";
    }

    @RequestMapping(value = "/addUser.html", method = RequestMethod.POST)
    public ModelAndView saveAddedUser(@RequestParam("login") String login,
                                      @RequestParam("name") String name,
                                      @RequestParam("email") String email,
                                      @RequestParam("birthDate") String birthDate,
                                      @RequestParam("active") Boolean active) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        User newUser = new User(login, name, email, formatter.parse(birthDate), active);
        System.out.println(newUser);
        userDao.saveUser(newUser);
        return new ModelAndView("/WEB-INF/jsp/users.jsp", "users", userDao.getAllUsers());
    }

    @RequestMapping(value = "/editUser.html", method = RequestMethod.POST)
    public ModelAndView saveEditedUser(@RequestParam("id") Long id,
                                       @RequestParam("login") String login,
                                       @RequestParam("name") String name,
                                       @RequestParam("email") String email,
                                       @RequestParam("birthDate") String birthDate,
                                       @RequestParam("active") Boolean active) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        User user = userDao.findUserById(id);
        user.setLogin(login);
        user.setName(name);
        user.setEmail(email);
        user.setBirthDate(formatter.parse(birthDate));
        user.setActive(active);
        return new ModelAndView("/WEB-INF/jsp/users.jsp", "users", userDao.getAllUsers());
    }
}
