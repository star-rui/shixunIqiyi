package com.iqiyi.service;

import com.iqiyi.domain.Actor;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/7 14:46
 */
public interface ActorService {

    List<Actor> findAllActor();

    void addActor(Actor actor);

    Actor findActorById(int id);

    Actor findActorByName(String name);

    void updateActor(Actor actor);

    void deleteActor(int id);
}
