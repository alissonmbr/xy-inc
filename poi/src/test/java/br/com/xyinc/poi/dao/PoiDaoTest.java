package br.com.xyinc.poi.dao;

import br.com.xyinc.poi.Application;
import br.com.xyinc.poi.model.Poi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * Created by alisson on 5/7/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class PoiDaoTest {
    @Autowired
    private PoiDAO poiDAO;

    @Test
    public void findAllPois() {
        List<Poi> pois = poiDAO.findAll();
        assertNotNull(pois);
        assertTrue(!pois.isEmpty());
    }
}
