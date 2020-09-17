package com.iqiyi.dao;

import com.iqiyi.domain.Movietype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO
 *电影类型的数据操作接口
 * @auothor asus
 * @date 2020/9/8 15:03
 */
@Mapper
public interface MovieTypeMapper {

     /**
      * 查找movietype表中的所有数据
      * @return
      */
     List<Movietype> findAllMovietype();
}
