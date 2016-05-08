package br.com.xyinc.poi.dao.impl;

import br.com.xyinc.poi.dao.PoiDAO;
import br.com.xyinc.poi.model.Poi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alisson on 5/7/16.
 */
@Repository
public class PoiDAOImpl implements PoiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<Poi> findAll() {
        String sql = "select * from poischema.poi";
        return jdbcTemplate.query(sql, new PoiRowMapper());
    }

    @Transactional(readOnly = true)
    public List<Poi> findByReference(int x, int y, int d) {
        String sql = "select * from poischema.poi where sqrt(power((?-x),2)+power((?-y),2)) <= ?";
        return jdbcTemplate.query(sql, new Object[]{x, y, d}, new PoiRowMapper());
    }

    @Transactional(readOnly = false)
    public Poi addPoi(Poi poi) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withSchemaName("poischema");
        insert.withTableName("poi");
        insert.usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", poi.getName());
        parameters.put("x", poi.getX());
        parameters.put("y", poi.getY());

        Number key = insert.executeAndReturnKey(new MapSqlParameterSource(parameters));


//        String sql = "insert into poischema.poi(name, x, y) values(?, ?, ?)";
//        insert.executeAndReturnKey(sql, new Object[]{poi.getName(), poi.getX(), poi.getY()});
//        jdbcTemplate.update(sql, new Object[]{poi.getName(), poi.getX(), poi.getY()}, holder);
        poi.setId(key.intValue());
        return poi;
    }
}

class PoiRowMapper implements RowMapper<Poi> {
    @Override
    public Poi mapRow(ResultSet rs, int rowNum) throws SQLException {
        Poi poi = new Poi();
        poi.setId(rs.getInt("id"));
        poi.setName(rs.getString("name"));
        poi.setX(rs.getInt("x"));
        poi.setY(rs.getInt("y"));
        return poi;
    }
}
