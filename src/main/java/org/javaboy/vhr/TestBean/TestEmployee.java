package org.javaboy.vhr.TestBean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 *
 * @Data：注解在类上，其中包含了@Getter、@Setter、@ToString、@EqualsAndHashCode、@RequiredArgsConstructor等；
 *
 * 如果属性为final修饰的属性，则不会为该属性生成setter方法。
 *
 * @Getter：注解可以写在类上或具体的属性上，为类中所有属性或具体的属性提供 getter 方法；
 *
 * @Setter：注解可以写在类上或具体的属性上，为类中所有非final修饰的属性或具体的非final修饰的属性提供 setter 方法；
 *
 * @ToString：注解写在类上，Lombok会生成一个toString()方法，默认情况下，会输出类名、所有属性(会按照属性定义顺序)，用逗号来分割；
 *
 * @EqualsAndHashCode：默认情况下，会使用所有非静态（non-static）和非瞬态（non-transient）属性来生成equals()和hasCode()，也能通过exclude注解来排除一些属性；
 *
 * @NonNull：该注解用在属性或构造器上，Lombok会生成一个非空的声明，可用于校验参数，能帮助避免空指针；
 *
 * @Slf4j ：注解写在类上，根据用户实际使用的日志框架生成log日志对象；
 *
 * @Log4j ：注解写在类上；为类提供一个 属性名为log 的 log4j 日志对象；
 *
 *
 * */
/**
 * javaBean
 *
 * 定义JavaBean中成员变量时所使用的类型:
 * 	 因为每个基本类型都有一个默认值:
 * 	   int ==> 0
 * 	   boolean ==> false
 *
 */

/*
 * MybatisPlus会默认使用实体类的类名到数据中找对应的表.
 *
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="tbl_employee")
public class TestEmployee {
    /*
     * @TableId:
     * 	 value: 指定表中的主键列的列名， 如果实体属性名与列名一致，可以省略不指定.
     *   type: 指定主键策略.
     */

    @TableId(value="id" , type = IdType.INPUT)
    private String id ;

    @TableField(value = "last_name")
    private String  lastName;
    private String  email ;
    private Integer gender;
    private Integer age ;

    /** mybatis的逻辑删除设置*/
    @TableLogic
    private Integer deleted;
    /** mybatis 乐观锁设置的字段*/
    @Version
    private Integer version;
    @TableField(exist=false)

    private Double salary ;

    /** mybatisPlus设置插入处理字段 */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** mybatisPlus设置插入和更新都处理字段 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
