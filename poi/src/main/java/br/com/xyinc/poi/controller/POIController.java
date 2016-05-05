package br.com.xyinc.poi.controller;

/**
 * Created by alisson on 5/4/16.
 */
import br.com.xyinc.poi.model.Poi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class POIController {

    @RequestMapping("/")
    public Poi index(@RequestParam(value="name") String name, @RequestParam(value="x") int x, @RequestParam(value="y") int y) {
        return new Poi(name, x, y);
    }

}
