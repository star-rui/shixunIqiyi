package com.iqiyi.service.serviceImpl;

import com.iqiyi.dao.ActorMapper;
import com.iqiyi.domain.Actor;
import com.iqiyi.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/7 14:46
 */
@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    private ActorMapper actorMapper;

    @Override
    public List<Actor> findAllActor(){
        return actorMapper.findAllActor();
    }

    @Override
    public void addActor(Actor actor){
        actorMapper.addActor(actor);
    }

    @Override
    public Actor findActorById(int id){
        return actorMapper.findActorById(id);
    }

    @Override
    public Actor findActorByName(String name){
        return actorMapper.findActorByName(name);

    }

    @Override
    public void updateActor(Actor actor){
         actorMapper.updateActor(actor);
    }

    @Override
    public void deleteActor(int id){
        actorMapper.deleteActor(id);
    }
}