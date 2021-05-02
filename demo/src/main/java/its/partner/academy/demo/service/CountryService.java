package its.partner.academy.demo.service;

import its.partner.academy.demo.dao.CountryDao;
import its.partner.academy.demo.model.Country;
import its.partner.academy.demo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private CountryDao countryDao;

    @Autowired
    public CountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public CountryService(String nameCountry) {
    }

    public List<Country> findAll() {
        return countryDao.findAll();
    }

}
