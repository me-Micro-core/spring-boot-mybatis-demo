package com.winter.classes;

import com.google.gson.Gson;
import com.winter.mapper.ClassesMapper;
import com.winter.model.Classes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassesTest {

    @Autowired
    private ClassesMapper classesMapper;

    @Test
    public void getAllClasses(){
        List<Classes> classesList = classesMapper.getAll();
        Gson gson = new Gson();
        System.out.println(gson.toJson(classesList));
    }
}
