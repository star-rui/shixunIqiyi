package com.iqiyi.dao;

import com.iqiyi.domain.Movietype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/8 15:03
 */
@Mapper
public interface MovieTypeMapper {

     List<Movietype> findAllMovietype();
}
