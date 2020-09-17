package com.hqc.user;

import com.baomidou.mybatisplus.extension.api.Assert;
import com.hqc.user.entity.HqcDepartmentUser;
import com.hqc.user.mapper.HqcDepartmentUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserApplicationTests {

    @Autowired
    private HqcDepartmentUserMapper hqcDepartmentUserMapper;


    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<HqcDepartmentUser> hqcDepartmentUsers = hqcDepartmentUserMapper.selectList(null);
       // Assert.assertEquals(5, hqcDepartmentUsers.size());

        hqcDepartmentUsers.forEach(System.out::println);
    }
}
