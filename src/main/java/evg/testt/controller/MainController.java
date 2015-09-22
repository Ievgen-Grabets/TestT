package evg.testt.controller;

import evg.testt.model.Contact;
import evg.testt.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 9/10/15.
 */
@Controller
public class MainController {

    @Autowired
    private ContactService contactService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("all");

        modelAndView.addObject("contacts", contactService.getAll());
        System.out.println("before  a.hashCode();");
        //System.out.println("a.hashCode()" + a.hashCode());
        System.out.println("after  a.hashCode();");

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddForm() {
        return new ModelAndView("add_form", "contact", new Contact());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewOne(@ModelAttribute Contact contact) {
        contactService.save(contact);
        return "redirect:/success";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView showSuccess(@ModelAttribute Contact contact) {
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showEditForm(@RequestParam(required = true) Long id) {
        return new ModelAndView("add_form", "contact", contactService.get(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteContact(@RequestParam(required = true) Long id) {
        contactService.remove(id);

        return "redirect:/";
    }

}
