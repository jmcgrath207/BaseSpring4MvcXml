package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import service.OffersService;
import dao.Offers;

import java.util.List;


/**
 * Created by root on 5/23/17.
 */

@Controller
public class IndexController {

    private OffersService offersService;


    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }

    @GetMapping("/")
    public String index(Model m) {

        List<Offers> offers = offersService.getCurrent();

        m.addAttribute("offers", "offers");
        return "index";
    }
}
