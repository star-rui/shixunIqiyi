package com.iqiyi.controller;

import com.iqiyi.domain.Movie;
import com.iqiyi.domain.Movietype;
import com.iqiyi.service.MovieService;
import com.iqiyi.service.MovietypeService;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/7 14:46
 */
@RestController
@CrossOrigin(value = "http://localhost:8080")//
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovietypeService movietypeService;

    @Value("${upload.dir}")
    private String uploadDir;

    @GetMapping("/findAllMovie")
    public List<Movie> findAll(){
        return movieService.findAllMovie();
    }

    @GetMapping("/findMovieById/{id}")
    public Movie findMovieById(@PathVariable int id){
        return movieService.findMovieById(id);
    }

    @GetMapping("/findMovieByName/{name}")
    public Movie findMovieByName(@PathVariable String name){
        return movieService.findMovieByName(name);
    }

    /**
     * ?
     * 新增电影
     * @param movie
     * @return
     */
    @ApiOperation("选择上传的文件")
    @PostMapping(value="/addMovie")
    public String addMovie(@RequestParam(value = "file")MultipartFile file, Movie movie){
        if(file!=null){
     //1.在服务器上创建一个新的文件
            System.out.println("uploadDir:"+uploadDir);
            //1.1创建日期目录
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String dir=sdf.format(new Date());
            //1.2创建目录E:\movie\images
            //创建文件名
            System.out.println("dir="+dir);
            File parentDir=new File(uploadDir,dir);
            if(!parentDir.exists()){
                parentDir.mkdirs();
            }
            //1.3得到上传文件的扩展名
            //1.3.1得到上传的文件的名字：
            String uuid= UUID.randomUUID().toString();
            //得到文件原来的名字
            String originalFilename=file.getOriginalFilename();
            //得到扩展名
            int index=originalFilename.lastIndexOf(".");
            String fileExter=originalFilename.substring(index);
            //新的文件名：uuid+fileExter
            String fileName=uuid+fileExter;
            //创建新文件
            File newFie=new File(parentDir,fileName);
    //2.把piic文件中的数据写道新的文件中
            try {
                //把图片转成base64编码的字符串
                String base64Str= Base64.encodeBase64String(file.getBytes());
                //把base64编码的字符串保存到对象中，会插入到表的photo字段
                movie.setPhoto(base64Str);
                //把图片的数据写到新文件中
                file.transferTo(newFie);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("controller movie="+movie);
        movieService.addMovie(movie);
        return "提交成功";
    }

    @PostMapping("/deleteMovie")
    public void deleteMovieById( int id){
        //因为电影有两个关联表，关联表中的数据都要删除
        movieService.deleteMovieById(id);
    }

    @GetMapping("/updateMovie")
    public Map<String,Object> updateMovie(int id){
        //1.得到这个电影的基本信息
        Movie movie=movieService.findMovieById(id);
        //2.所有的电影类型
        List<Movietype> allMovietype=movietypeService.findAllMovietype();
        //定义一个map用来封装返回的数据
        Map<String,Object> dataMap=new HashMap<String,Object>();
        dataMap.put("movie",movie);
        dataMap.put("allMovietype",allMovietype);
        return dataMap;
        }



}