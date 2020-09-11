package com.iqiyi.dao;

import com.iqiyi.domain.Actor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/7 14:45
 */
@Mapper
@Component("actorMapper")
public interface ActorMapper {

    /**
     * 查询演员列表
     * @return
     */
    List<Actor> findAllActor();

    /**
     * 增加演员
     * @param actor
     */
    void addActor(Actor actor);

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    Actor findActorById(int id);

    Actor findActorByName(String name);

    /**
     * 更改演员信息
     * @param actor
     */
    void updateActor(Actor actor);

    void deleteActor(int id);
}
