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

    List<Actor> findAllActor();

    void addActor(Actor actor);

    Actor findActorById(int id);

    Actor findActorByName(String name);

    void updateActor(Actor actor);

    void deleteActor(int id);
}
