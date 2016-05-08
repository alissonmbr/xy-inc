package br.com.xyinc.poi.controller;

/**
 * Created by alisson on 5/4/16.
 */
import br.com.xyinc.poi.dao.PoiDAO;
import br.com.xyinc.poi.model.Poi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class POIController {

    @Autowired
    private PoiDAO poiDAO;

    @RequestMapping("/add")
    public Poi addPoi(@RequestParam(value="name") String name, @RequestParam(value="x") int x, @RequestParam(value="y") int y) {
        return poiDAO.addPoi(new Poi(name, x, y));
    }

    @RequestMapping("/all")
    public List<Poi> listAll() {
        return poiDAO.findAll();
    }

    @RequestMapping("/reference")
    public List<Poi> listByReference(@RequestParam(value="x") int x, @RequestParam(value="y") int y, @RequestParam(value="d") int d) {
        return poiDAO.findByReference(x, y, d);
    }

}
