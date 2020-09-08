package com.iqiyi.controller;

import com.iqiyi.domain.Actor;
import com.iqiyi.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/7 14:32
 */
@RestController
@RequestMapping("actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    /**
     * 查询所有演员信息
     * @return
     */
    @GetMapping("/findAllActor")
    public List<Actor> findAllActor(){
        return actorService.findAllActor();
    }

    /**
     * 根据演员姓名查询
     * @param name
     * @return
     */
    @GetMapping("/findByActorName/{name}")
    public Actor findByActorName(@PathVariable String name){
        return actorService.findByActorName(name);
    }

    /**
     * 添加演员
     * @param actor
     */

    @PostMapping("/addActor")
    public void addActor(Actor actor){
         actorService.addActor(actor);
    }

    /**
     * 根据id查询演员
     * @param id
     * @return
     */
    @GetMapping("/findActorById/{id}")
    public Actor findActorById(int id){
        return actorService.findByActorId(id);
    }


    /**
     * 修改演员信息
     * @param actor
     */
    @PostMapping("/updateActor")
    public void updateActor(Actor actor){
        actorService.updateActor(actor);
    }

    /**
     * 删除演员
     * @param id
     */
    @GetMapping("delActor/{id}")
    public void delete(@PathVariable int id){
        actorService.deleteActor(id);
    }


}