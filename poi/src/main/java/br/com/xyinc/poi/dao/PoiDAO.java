package br.com.xyinc.poi.dao;

import br.com.xyinc.poi.model.Poi;

import java.util.List;

/**
 * Created by alisson on 5/7/16.
 */
public interface PoiDAO {

    List<Poi> findAll();

    List<Poi> findByReference(int x, int y, int d);

    Poi addPoi(Poi poi);

 }
