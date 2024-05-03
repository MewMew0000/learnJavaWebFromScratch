package com.mewmew.Controller;

import com.mewmew.Service.EmpService;
import com.mewmew.pojo.Emp;
import com.mewmew.pojo.PageBean;
import com.mewmew.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("search by page {} size {} name {} gender {} begin {} end {}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("delete ids {}", ids);
        empService.delete(ids);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("add emp {}", emp);
        empService.save(emp);
        return Result.success();
    }
}
