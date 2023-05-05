package com.solars.SolarWeb.Controllers;

import com.solars.SolarWeb.Domain.Contact;
import com.solars.SolarWeb.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/sendMail")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @PostMapping(value = "/send")
    public void submit(@Validated @ModelAttribute Contact contact, ModelMap model) {
        Contact s = new Contact();
        model.addAttribute("contact", new Contact() );
        s.setEmail(contact.getEmail());
        s.setText(contact.getText());
        s.setPhone(contact.getPhone());
        s.setSubject(contact.getSubject());
       contactRepository.save(s);
    }


        @RequestMapping(value = "/list", method = RequestMethod.GET)
        @ResponseBody
        public ModelAndView showList(Model model) {
            model.addAttribute("contact", contactRepository.findAll());
            return new ModelAndView("admin");
        }

}
