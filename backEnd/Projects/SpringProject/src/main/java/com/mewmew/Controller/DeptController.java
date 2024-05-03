package com.mewmew.Controller;

import com.mewmew.Service.DeptService;
import com.mewmew.pojo.Dept;
import com.mewmew.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list(){
        log.info("all department");
        List<Dept> res = deptService.list();
        return Result.success(res);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("delete dept by id {}", id);
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("add dept {}", dept);
        deptService.add(dept);
        return Result.success();
    }
}
