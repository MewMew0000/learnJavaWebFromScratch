package com.mewmew.Service;

import com.mewmew.pojo.Emp;
import com.mewmew.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    public void delete(List<Integer> ids);

    public void save(Emp emp);
}
