package com.task.accbook.core.orika.mapper;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MapperImpl implements Mapper {

    private MapperFacade mapperFacade;

    @Override
    public <O, T> T map(O o, Class<T> target) {
        return mapperFacade.map(o, target);
    }

    @Override
    public <O, T> List<T> mapAsList(Collection<O> o, Class<T> target) {
        return new ArrayList<>(mapperFacade.mapAsList(o, target));
    }

    public void setMapperFacade(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }
}
