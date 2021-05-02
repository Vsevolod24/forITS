package its.partner.academy.demo.service;

import its.partner.academy.demo.dao.LightDao;
import its.partner.academy.demo.model.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LightService {

    private LightDao lightDao;

    @Autowired
    public LightService(LightDao lightDao) {
        this.lightDao = lightDao;
    }

    public LightService(String status) {
    }

    public List<Light> findAll() {
        return lightDao.findAll();
    }

    public Light findById(Integer id) {
        return lightDao.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }
}
