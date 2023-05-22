package com.solars.SolarWeb.Controllers;

import com.solars.SolarWeb.Domain.AuthenticationRequest;
import com.solars.SolarWeb.Domain.Contact;
import com.solars.SolarWeb.Domain.PromoForm;
import com.solars.SolarWeb.Repositories.ContactRepository;
import com.solars.SolarWeb.Repositories.PromoFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageController {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    PromoFormRepository promoFormRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showHome() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showAbout() {
        return new ModelAndView("about");
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showAdmin(Model model) {
        model.addAttribute("contact", contactRepository.findAll());
        return new ModelAndView("admin");
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showContact(Model model) {
        model.addAttribute("contact", new Contact());
        return new ModelAndView("contact");
    }

    @RequestMapping(value = "/product-list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showProducts(Model model) {
        return new ModelAndView("product-list");
    }

    @RequestMapping(value = "/typical_systems", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showSystems() {
        return new ModelAndView("typical_systems");
    }

    @RequestMapping(value = "/typical_systems2", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showSystems2() {
        return new ModelAndView("typical_systems2");
    }

    @RequestMapping(value = "/promo_form", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showForm(Model model) {
        model.addAttribute("promoForm", new PromoForm());
        return new ModelAndView("promo_form");
    }

    @RequestMapping(value = "/promotions", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showPromotions(Model model) {
        model.addAttribute("promoForm", promoFormRepository.findAll());
        return new ModelAndView("promotions");
    }

    @RequestMapping(value = "/typical_systems3", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showSystems3() {
        return new ModelAndView("typical_systems3");
    }

    @RequestMapping(value = "/typical_systems4", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showSystems4() {
        return new ModelAndView("typical_systems4");
    }

    @RequestMapping(value = "/typical_systems5", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showSystems5() {
        return new ModelAndView("typical_systems5");
    }

    @RequestMapping(value = "/typical_systems6", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showSystems6() {
        return new ModelAndView("typical_systems6");
    }

    @RequestMapping(value = "/typical_systems7", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showSystems7() {
        return new ModelAndView("typical_systems7");
    }

    @RequestMapping(value = "/facthub", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showFacts() {
        return new ModelAndView("facthub");
    }

    @RequestMapping(value = "/accessories", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showAccessories() {
        return new ModelAndView("accessories");
    }

    @RequestMapping(value = "/inverters", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showInverters() {
        return new ModelAndView("inverters");
    }

    @RequestMapping(value = "/promotionsList", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView promoList(Model model) {
        model.addAttribute("promoForm", promoFormRepository.findAll());
        return new ModelAndView("promotionsList");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView login(Model model) {
        model.addAttribute("authenticationRequest", new AuthenticationRequest());
        return new ModelAndView("login");
    }
}
