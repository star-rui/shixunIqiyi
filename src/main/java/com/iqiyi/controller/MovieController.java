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
    public List<Movie> findAll() {
        return movieService.findAllMovie();
    }

    @GetMapping("/findMovieById/{id}")
    public Movie findMovieById(@PathVariable int id) {
        return movieService.findMovieById(id);
    }

    @GetMapping("/findMovieByName/{name}")
    public Movie findMovieByName(@PathVariable String name) {
        return movieService.findMovieByName(name);
    }

    /**
     * ?
     * 新增电影
     *
     * @param movie
     * @return
     */
    @ApiOperation("选择上传的文件")
    @PostMapping(value = "/addMovie")
    public String addMovie(@RequestParam(value = "file") MultipartFile file, Movie movie) {

        //把piic文件中的数据写道新的文件中
        try {
            if (file != null) {
                //把图片转成base64编码的字符串
                String base64Str = Base64.encodeBase64String(file.getBytes());
                //把base64编码的字符串保存到对象中，会插入到表的photo字段
                movie.setPhoto(base64Str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("controller movie=" + movie);
        movieService.addMovie(movie);
        //抽出为工具类
        FileLoad.upLoad(file, uploadDir);
        return "提交成功";
    }


    @PostMapping("/deleteMovie")
    public void deleteMovieById(int id) {
        //因为电影有两个关联表，关联表中的数据都要删除
        movieService.deleteMovieById(id);
    }

    /**
     * 给编辑电影页面提供数据，
     * 编辑电影页面要首先显示出该电影的类型信息，
     * 需要从movie_type中间表查询
     *
     * @param id 电影的id
     * @return
     */
    @GetMapping("/editMovie")
    public Map<String, Object> editMovie(int id) {
        Movie movie = movieService.findMovieById(id);
        List<Movietype> typeList = movietypeService.findAllMovietype();
        //同样定义map来封装数据,并且返回
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("movie", movie);
        dataMap.put("typeList", typeList);
        return dataMap;
    }

    /**
     * 更新movie电影表中的数据，编辑电影页面要进行更新操作
     *
     * @param file 要上传的图片
     * @return
     */
    @GetMapping("/updateMovie")
    public String updateMovie(@RequestParam(value = "file", required = false) MultipartFile file, Movie movie) {

        //1.在数据库中更新这个电影的数据
        if (file != null) {
            //1.1在服务器上创建一个新文件
            System.out.println("uploadDir:" + uploadDir);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dir = sdf.format(new Date());
            //1.2创建目录E:\movie\images
            File parentDir = new File(uploadDir, dir);
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            //1.3得到上传文件的扩展名
            String uuid = UUID.randomUUID().toString();
            // 得到文件原来的名字
            String originalFilename = file.getOriginalFilename();
            // 得到扩展名
            int index = originalFilename.lastIndexOf(".");
            String fileExter = originalFilename.substring(index);
            // 新的文件名: uuid + fileExter
            String fileName = uuid + fileExter;
            // 创建新文件
            File newFile = new File(parentDir, fileName);
            // 2.把pic文件中数据写到 新的文件中
            try {
                // 把图片转成base64编码的字符串
                String base64Str = Base64.encodeBase64String(file.getBytes());
                // 把base64编码的字符串保存到对象中, 会插入到表的pic字段中
                movie.setPhoto(base64Str);
                // 把图片的数据写到新文件中
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //完成上面两部此时movie的photo属性存储的就是上传图片的编码
        movieService.updateMovie(movie);
        return "提交成功";
    }
}