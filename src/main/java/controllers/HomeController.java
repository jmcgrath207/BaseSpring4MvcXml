package controllers;

import dao.Offers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.OffersService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 6/3/17.
 */

@Controller("homeController")
public class HomeController {


    private OffersService offersService;


    @Resource(name="offersService")
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }

    @GetMapping("/offers")
    public String showOffers(Model m) {

        List<Offers> offers = offersService.getCurrent();

        m.addAttribute("offers", offers);
        return "offers";
    }

    @GetMapping("/createoffers")
    public String createOffer(Model m) {


        return "create";
    }


}
