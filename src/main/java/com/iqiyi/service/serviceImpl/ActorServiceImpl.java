package com.iqiyi.service.serviceImpl;

import com.iqiyi.dao.ActorMapper;
import com.iqiyi.domain.Actor;
import com.iqiyi.domain.ActorAndRegion;
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

    /**
     * 添加演员
     * 在actor表中插入新数据
     * 在actor_region表中插入新数据
     * @param actor
     */
    @Override
    public void addActor(Actor actor){
        actorMapper.addActor(actor);
        insertActorAndRegion(actor);
    }

    //在actor_region表中插入新数据
    private  void insertActorAndRegion(Actor actor){
        int actorid=actor.getId();
        //得到的regionStr是逗号连接的字符串
        String regionStr=actor.getRegionStr();
        //需要从字符串中拆分出区域id
        String []idArr=regionStr.split(",");
        for(String regionId:idArr){
            ActorAndRegion actorAndRegion=new ActorAndRegion();
            actorMapper.saveActorAndRegion(actorAndRegion);
        }
    }



    @Override
    public Actor findActorById(int id){
        return actorMapper.findActorById(id);
    }

    @Override
    public Actor findActorByName(String name){
        return actorMapper.findActorByName(name);

    }

    /**
     * 编辑演员
     * 更新actor表中数据
     * 更新actor_region中间表数据
     * @param actor
     */
    @Override
    public void updateActor(Actor actor){
         actorMapper.updateActor(actor);
         //先删除原来的数据，在插入新的数据
         actorMapper.deleteActorAndRegion(actor.getId());
         insertActorAndRegion(actor);
    }

    /**
     * 删除演员信息
     * 删除actor表
     * 删除actor_region表中数据
     * @param id
     */
    @Override
    public void deleteActor(int id){
        actorMapper.deleteActorAndRegion(id);
        actorMapper.deleteActor(id);
    }
}