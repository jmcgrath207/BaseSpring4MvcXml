package controllers;

import dao.Offers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.OffersService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 6/3/17.
 */

@Controller("offerController")
public class OffersController {
    private OffersService offersService;


    @Resource(name="offersService")
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String index(Model m, @RequestParam("id") String id) {

        System.out.println("Id is: "+ id);
        return "home";


    }
}
