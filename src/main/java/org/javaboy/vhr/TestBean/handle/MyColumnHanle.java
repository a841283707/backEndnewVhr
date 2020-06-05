package org.javaboy.vhr.TestBean.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/*这是mybatis的填充策略类*/
@Slf4j
@Component
public class MyColumnHanle implements MetaObjectHandler {

    /**    default MetaObjectHandler setFieldValByName(String fieldName, Object fieldVal,
            MetaObject metaObject, FieldFill fieldFill)
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
