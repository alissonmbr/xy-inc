package br.com.xyinc.poi.controller;

/**
 * Created by alisson on 5/4/16.
 */
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class POIController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
