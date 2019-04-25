package com.whiskas68.booter.mapper;

import com.whiskas68.booter.entity.User;
import com.whiskas68.booter.mapper.shop.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserMapper {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> list = userMapper.selectAll();
        list.forEach(user -> {
            logger.info("user={}",user);
        });
    }

    @Test
    public void testFindById(){
        logger.info("user={}",userMapper.selectById(1L));
    }
}
