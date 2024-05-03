package com.mewmew.Service;

import com.mewmew.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {
    public List<Dept> list();
    public void delete(Integer id);
    public void add(Dept dept);
}
