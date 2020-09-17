package com.iqiyi.service.serviceImpl;

import com.iqiyi.dao.MovieTypeMapper;
import com.iqiyi.domain.Movietype;
import com.iqiyi.service.MovietypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *电影类型的服务类
 * @auothor asus
 * @date 2020/9/10 18:44
 */
@Service
public class MovietypeServiceImpl implements MovietypeService{

    @Autowired
    private MovieTypeMapper movieTypeMapper;

    @Override
    public List<Movietype> findAllMovietype(){
        return movieTypeMapper.findAllMovietype();
    }
}