package br.com.xyinc.poi.controller;

/**
 * Created by alisson on 5/4/16.
 */

import br.com.xyinc.poi.dao.PoiDAO;
import br.com.xyinc.poi.exception.PoiControllerErrorException;
import br.com.xyinc.poi.model.Poi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class POIController {

    @Autowired
    private PoiDAO poiDAO;

    @RequestMapping("/add/{name}/{x}/{y}")
    public Poi addPoi(@PathVariable(value = "name") String name, @PathVariable(value = "x") int x, @PathVariable(value = "y") int y) {
        if (x < 0 || y < 0) {
            throw new PoiControllerErrorException("X and Y must be nonnegative integer numbers!");
        }
        return poiDAO.addPoi(new Poi(name, x, y));
    }

    @RequestMapping("/all")
    public List<Poi> listAll() {
        return poiDAO.findAll();
    }

    @RequestMapping("/reference/{x}/{y}/{d}")
    public List<Poi> listByReference(@PathVariable(value = "x") int x, @PathVariable(value = "y") int y, @PathVariable(value = "d") int d) {
        if (x < 0 || y < 0 || d < 0) {
            throw new PoiControllerErrorException("X and Y and d must be nonnegative integer numbers!");
        }
        return poiDAO.findByReference(x, y, d);
    }

}
