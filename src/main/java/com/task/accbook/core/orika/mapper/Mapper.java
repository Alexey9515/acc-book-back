package com.task.accbook.core.orika.mapper;

import java.util.Collection;
import java.util.List;

public interface Mapper {

    <O,T> T map(O o, Class<T> target);

    <O,T> List<T> mapAsList(Collection<O> o, Class<T> target);
}
