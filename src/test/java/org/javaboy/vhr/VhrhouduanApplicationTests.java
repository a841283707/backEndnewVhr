package org.javaboy.vhr;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.catalina.User;
import org.javaboy.vhr.TestBean.TestEmployee;
import org.javaboy.vhr.bean.Employee;
import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@SpringBootTest
class VhrhouduanApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMybatisPlus(){
        List<TestEmployee> users = userMapper.selectList(null);
        for (TestEmployee user : users) {

            System.out.println(user);

        }
    }



    /*主键策略：如果主键策略为默认策略，不指定ID会生成Long类型的雪花ID，
    如果指定为Auto类型，那么就不会插入ID，ID由数据库自增生成
    当IdType为INPUT时，SQL里面的ID为null，但是数据库如果设置了自增，会自增
    */
    @Test
    public void testAddUser(){
        TestEmployee user=new TestEmployee();
        user.setAge(12);
        user.setEmail("dsadsa");
        user.setGender(1);
        user.setId("1022");
        userMapper.insert(user);
    }

    /*update操作：*/
    /*updateById：把要处理的id赋值入user，并且把修改的字段也赋值*/
    /*UPDATE tbl_employee SET gender=?, age=?, email=? WHERE id=? 可以自动拼接动态sql*/

    /*阿里巴巴开发手册里面写到的
    * 每个数据库都要有一个修改字段和一个创建字段，可以在数据库里创建dateTime列，默认值，CURRENT_TIMEStamp
    * 并且把更新字段设置alter table tbl_employee modify update_time datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
    *
    * */
    @Test
    public void testUpdate(){
        TestEmployee user=new TestEmployee();
        user.setAge(12);
        user.setEmail("88923221d81@@qq.com");
        user.setGender(1);
        user.setId("1020");
        userMapper.updateById(user);
    }


    @Test
    public void testLock(){
        TestEmployee user=userMapper.selectById(1020);
        user.setAge(12);
        user.setEmail("11d85555@@qq.com");
        user.setGender(0);
        userMapper.updateById(user);
    }

    @Test
    public void testFailture(){
        TestEmployee user=userMapper.selectById(1020);
        user.setAge(12);
        user.setEmail("11d85555@@qq.com");
        TestEmployee user1=userMapper.selectById(1020);
        user.setAge(11);
        user.setEmail("1231f1d85555@@qq.com");
        userMapper.updateById(user1);
        /*此时得到的version值为2，但是上面已经更改了version为3*/
        userMapper.updateById(user);
    }

    /*map 和ids的查询*/
    @Test
    public void testSelect(){
        /*转化为where id in ()*/
        List<TestEmployee> testEmployees=userMapper.selectBatchIds(Arrays.asList(1,2,1020));

        HashMap<String,Object> map=new HashMap<>();

        map.put("age",11);
        map.put("id",1020);
        /*sql拼接为WHERE id = ? AND age = ? */
        List<TestEmployee> employee=userMapper.selectByMap(map);
    }

    /*分页查询插件,前段传来需要获得的页码*/
    @Test
    public void getPage(){
        /*创建page对象*/
        Page<TestEmployee> page=new Page<>(1,3);
        userMapper.selectPage(page,null);
    }

    @Test
    public void getLogicDelete(){
        userMapper.deleteById("1020");
    }


    /*docker run --name myredis1 -p 6379:6379
    * 虚拟机的6379，映射到容器的6379
    * */

    /*注入了两个相同的redisTemplate那么会自动按照name装配*/
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testRedis(){
        /** 对象不序列化会报错需要一个序列化的payloadDefaultSerializer requires a Serializable payload but received an object of type [org.javaboy.vhr.TestBean.TestEmployee]*/
            TestEmployee employee=userMapper.selectById(1020);
           stringRedisTemplate.opsForValue().set("user1","liuxiang");
           redisTemplate.opsForValue().set("qq14",employee);

/*        String qq14 = JSON.toJSONString(redisTemplate.opsForValue().get("qq14"));
        TestEmployee employee = JSON.parseObject(qq14, TestEmployee.class);
        System.out.println(employee.getAge());*/
//            System.out.println(JSON.parseArray(qq14,TestEmployee.class));
    }

}
/*java对象->json对象->json字符串->java对象 or 数组对象->json对象
*       toJSON     toString   parseObject parseArray  toJSON
*               JSON.toJSONString
* */