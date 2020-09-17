package com.iqiyi.dao;

import com.iqiyi.domain.Actor;
import com.iqiyi.domain.ActorAndRegion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *对演员的数据操作
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

    /**
     * 删除演员
     * @param id
     */
    void deleteActor(int id);

    /**
     * 保存演员与区域关联记录
     * 向actor_region中间表插入数据
     * @param actorAndRegion
     */
    void saveActorAndRegion(ActorAndRegion actorAndRegion);

    /**
     * 删除actor_region中间表中的数据
     * @param id 演员id
     */
    void deleteActorAndRegion(int id);
}
