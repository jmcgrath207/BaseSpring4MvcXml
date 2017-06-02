package service;

import java.util.List;

import dao.OffersDao;
import dao.Offers;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by root on 6/2/17.
 */

@Service("offersService")
public class OffersService {

    private OffersDao offersDao;

    @Resource(name="offersDao")
    public void setOffersDao(OffersDao offersDao) {
        this.offersDao = offersDao;
    }

    public List<Offers> getCurrent() {
        return offersDao.getOffers();
    }
}