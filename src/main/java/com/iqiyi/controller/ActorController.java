package com.iqiyi.controller;

import com.iqiyi.domain.Actor;
import com.iqiyi.service.ActorService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private RegionService regionService;

    @Value("${upload.dir}")
    private String uploadDir;

    /**
     * 查询所有演员信息
     * @return
     */
    @GetMapping("/findAllActor")
    public List<Actor> findAllActor(){
        return actorService.findAllActor();
    }

    /**
     * 查询所有的演员区域
     * @return
     */
    @GetMapping("findAllRegion")
    public List<Region> findAllRegion(){
        return regionService.findAllRegion();
    }
    /**
     * 根据演员姓名查询
     * @param name
     * @return
     */
    @GetMapping("/findByActorName/{name}")
    public Actor findByActorName(@PathVariable String name){
        return actorService.findActorByName(name);
    }

    /**
     * 添加演员
     * @param actor
     */
    @PostMapping("/addActor")
    public void addActor(@RequestParam(value = "file") MultipartFile file,Actor actor){
        //如果照片不为空，把图片转成base64的字符串设置给actor的photo属性
        if(file!=null){
            try {
                actor.setPhoto(Base64.encodeBase64String(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //上传图片
        FileLoad.uploadFile(file,uploadDir);
        actorService.addActor(actor);
    }

    /**
     * 根据id查询演员
     * @param id
     * @return
     */
    @PostMapping("/findActorById/")
    public Actor findActorById(int id){
        return actorService.findActorById(id);
    }


    /**
     * 更新演员信息
     * @param actor
     */
    @PostMapping("/updateActor")
    public void updateActor(@RequestParam(value = "file") MultipartFile file, Actor actor){
        //如果照片不为空，把图片转成base64的字符串设置给actor的photo属性
        if(file!=null){
            try {
                actor.setPhoto(Base64.encodeBase64String(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //上传图片
        FileLoad.uploadFile(file,uploadDir);
        //更新演员信息
        actorService.updateActor(actor);
    }


    /**
     * 编辑演员信息
     * @param id 演员Id
     * @return
     */
    @GetMapping("/editActor")
    public Map<String,Object>edictActor(int id){
        Actor actor=actorService.findActorById(id);
        List<Region> regionList=regionService.findAllRegion();
        Map<String,Object> map=new HashMap<>();
        map.put("actor",actor);
        map.put("regionList",regionList);
        return map;
    }


    /**
     * 删除演员
     * @param id
     */
    @PostMapping("deleteActor")
    public void delete(int id){
        actorService.deleteActor(id);
    }


}