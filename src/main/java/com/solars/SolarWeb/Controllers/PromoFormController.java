package com.solars.SolarWeb.Controllers;

import com.solars.SolarWeb.Domain.Contact;
import com.solars.SolarWeb.Domain.PromoForm;
import com.solars.SolarWeb.Repositories.ContactRepository;
import com.solars.SolarWeb.Repositories.PromoFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PromoFormController {

    @Autowired
    PromoFormRepository promoFormRepository;

    @PostMapping(value = "/save")
    public void submit(@Validated @ModelAttribute PromoForm promoForm, ModelMap model) {
        PromoForm s = new PromoForm();
        model.addAttribute("promoForm", new PromoForm() );
       s.setPromotionName(promoForm.getPromotionName());
       s.setDetails(promoForm.getDetails());
       promoFormRepository.save(s);
    }

    @Transactional
    @GetMapping(value = "/deleteC/{id}")
    public ModelAndView deleteRecord(@PathVariable Long id, ModelMap model) {
        promoFormRepository.deleteC(id);
        model.addAttribute("promoForm", promoFormRepository.findAll());
        return new ModelAndView("promotions");
    }
}
