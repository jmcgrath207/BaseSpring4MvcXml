package controllers;

import dao.Offers;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import service.OffersService;

import javax.annotation.Resource;
import javax.validation.Valid;
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

    @GetMapping("/offers")
    public String showOffers(Model m) {



        List<Offers> offers = offersService.getCurrent();

        m.addAttribute("offers", offers);
        return "offers";
    }

    /* @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseExpection(DataAccessException ex) {
        return "error";
    }
    */

    @GetMapping("/createoffers")
    public String createOffer(Model model) {

        model.addAttribute("offer",new Offers());

        return "createoffer";
    }


    @RequestMapping(value = "/docreate", method=RequestMethod.POST)
    public String doCreate(@ModelAttribute("offer") @Valid Offers offer, BindingResult result) {

        /* if(result.hasErrors()) {

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error: errors) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("offer",new Offers());
            return "createoffer";
        }

        */

        if(result.hasErrors()) {
            return "createoffer";

        }

        offersService.create(offer);


        System.out.println(offer);
        return "offercreated";
    }

}
