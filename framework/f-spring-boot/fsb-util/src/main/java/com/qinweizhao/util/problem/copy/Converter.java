package com.qinweizhao.util.problem.copy;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author qinweizhao
 * @since 2022/2/21
 */
@Mapper
public interface Converter {

    Converter INSTANCE = Mappers.getMapper(Converter.class);

    /**
     *  A 转为 B
     * @param a a
     * @return B
     */
    B aToB(A a);
}
