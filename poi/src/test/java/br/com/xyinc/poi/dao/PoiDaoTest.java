package br.com.xyinc.poi.dao;

import br.com.xyinc.poi.Application;
import br.com.xyinc.poi.model.Poi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * Created by alisson on 5/7/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@TestPropertySource(locations="classpath:test.properties")
public class PoiDaoTest {
    @Autowired
    private PoiDAO poiDAO;

    @Test
    public void findAllPois() {
        List<Poi> pois = poiDAO.findAll();
        System.out.println("FindALL:" + pois);
        assertNotNull(pois);
        assertTrue(!pois.isEmpty());
    }

    @Test
    public void findByReference() {
        List<Poi> pois = poiDAO.findByReference(20, 10, 10);
        System.out.println("FindByReference" + pois);
        assertNotNull(pois);
        assertTrue(!pois.isEmpty());
        assertTrue(containsPoi(pois, "Lanchonete"));
        assertTrue(containsPoi(pois, "Joalheria"));
        assertTrue(containsPoi(pois, "Pub"));
        assertTrue(containsPoi(pois, "Supermercado"));
    }

    private boolean containsPoi(List<Poi> pois, String poiName) {
        for (Poi p : pois) {
            if (p.getName().equalsIgnoreCase(poiName))
                return true;
        }

        return false;
    }

    @Test
    public void addPoi() {
        Poi poi = new Poi("Padaria", 0, 0);

        poiDAO.addPoi(poi);
        System.out.println("Add POI: " + poi);
        assertNotNull(poi.getId());
    }
}
