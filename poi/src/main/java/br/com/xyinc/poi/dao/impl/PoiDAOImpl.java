package br.com.xyinc.poi.dao.impl;

import br.com.xyinc.poi.dao.PoiDAO;
import br.com.xyinc.poi.model.Poi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alisson on 5/7/16.
 */
@Repository
public class PoiDAOImpl implements PoiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<Poi> findAll() {
        return jdbcTemplate.query("select * from poischema.poi", new PoiRowMapper());
    }
}

class PoiRowMapper implements RowMapper<Poi>
{
    @Override
    public Poi mapRow(ResultSet rs, int rowNum) throws SQLException {
        Poi poi = new Poi();
        poi.setName(rs.getString("name"));
        poi.setX(rs.getInt("x"));
        poi.setY(rs.getInt("y"));
        return poi;
    }
}
