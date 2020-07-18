package org.javaboy.vhr.bean.CommonUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;


import org.springframework.util.StringUtils;


/**
 * The type CommUtils.
 * 工具类
 *
 * @author HanJing
 * @date 2019 -10-22
 */
public class CommUtils {

    private static  final String  SPACE = " ";


    /**
     * Is null boolean.
     *
     * @param object the object 判断对象是否为空 空返回false 非空返回true
     * @return the boolean
     */
    public static boolean isNotNull(Object object){
        boolean flag = true;
        if (StringUtils.isEmpty(object) ){
            flag = false;
        }
        return flag;
    }


    /**
     * Is null boolean.
     *
     * @param object the object
     * @return the boolean
     */
    public static boolean isNull(Object object){
        boolean flag = false;
        if (StringUtils.isEmpty(object) ){
            flag = true;
        }
        return flag;
    }

    /**
     * Is not null boolean.
     * 判断字符串是否为空 空返回false 非空返回 true
     *
     * @param s the s
     * @return the boolean
     */
    public static boolean isNotNull(String s){
        boolean flag = true;
        if (s == null || "".equals(s)||s.split(SPACE).length==0){
            flag = false;
        }
        return flag;

    }


    /**
     * Is not null boolean.
     *
     * @param list the list
     * @return the boolean
     */
    public static boolean isNotNull(List  list){
        boolean flag = false;
        if (!StringUtils.isEmpty(list) && list.size() !=0){
            flag = true;
        }
        return  flag;

    }


    /**
     * Get current time timestamp.
     *
     * @return the timestamp
     */
    public  static Timestamp getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        Timestamp ts = Timestamp.valueOf(time);
        return  ts;
    }

    public static List<String> getAllDates(){

        Calendar now = Calendar.getInstance();
        String end= new SimpleDateFormat("yyyy-MM-dd").format(now.getTime());

        now.add(Calendar.DAY_OF_MONTH, -30);
        String start = new SimpleDateFormat("yyyy-MM-dd").format(now.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dStart = null;
        Date dEnd = null;
        try {
            dStart = sdf.parse(start);
            dEnd = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Date> dateList = findDates(dStart, dEnd);
        String str = new String();
        List<String> dates = new ArrayList<>();
        for (Date date:dateList) {
            str=sdf.format(date);
            dates.add(str);
        }
        return  dates;
    }

    public  static  List<Date> findDates(Date dStart, Date dEnd) {
        Calendar cStart = Calendar.getInstance();
        cStart.setTime(dStart);

        List dateList = new ArrayList();
        //别忘了，把起始日期加上
        dateList.add(dStart);
        // 此日期是否在指定日期之后
        while (dEnd.after(cStart.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cStart.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(cStart.getTime());
        }
        return dateList;
    }

/*    public static String getUserId() {
        Subject subject = SecurityUtils.getSubject();
        HdyhDomain user = (HdyhDomain) subject.getPrincipal();
        return user.getHdyhId();
    }

    public static String getUserZh() {
        Subject subject = SecurityUtils.getSubject();
        HdyhDomain user = (HdyhDomain) subject.getPrincipal();
        return user.getHdyhZh();

    }*/

    /**
     *
     * @doc 日期转换星期几
     * @param datetime
     *            日期 例:2017-10-17
     * @return String 例:星期二
     * @history 2017年10月17日 上午9:55:30 Create by 【hsh】
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 指示一个星期中的某天。
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;

        if (w < 0){
            w = 0;
        }
        return weekDays[w];
    }

    public static String getPwd(String xfzHm){
        String pwd = null;
        if(xfzHm.length() ==18){
            if(xfzHm.contains("X")){
                pwd = xfzHm.substring(11,17);
            }else{
                pwd = xfzHm.substring(12,18);
            }
        }else {
            throw new IllegalArgumentException();
        }
        return pwd;
    }


    public static String getDateAndUUID() {
//获取时间格式 时间的完整格式为yyyyMMddHHmmss
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        // 获取当前时间
        String cdtSequen = tempDate.format(new java.util.Date());
        String[] split = cdtSequen.split("-");
        //获取UUID UUID为唯一码，
        String s = UUID.randomUUID().toString().toUpperCase();
        //时间+uuid拼装      截图UUID的前四位，具体根据自己需求来截取
        return split[0].substring(0,2)+split[1]+split[2]+s.substring(0, 4);
    }


    public static HttpResponse setHttpResponseStatus(ResponseType info, Object obj, BiFunction<ResponseType,Object,HttpResponse> function){
        return  function.apply(info,obj);
    }


    /**
     *
     * @param e is params
     * @return String
     */
    public static String buildExceptionKeys(Exception e){
        StringBuilder keys = new StringBuilder();
        String s = new Exception("", e).getCause().toString();
        keys.append("已捕获的异常为:").append(s);
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        keys.append(" \n异常发生在:").append(stackTraceElement.getClassName())
                .append(".java 类中")
                .append("\n 方法名为:")
                .append(stackTraceElement.getMethodName())
                .append("\n 第")
                .append(stackTraceElement.getLineNumber())
                .append("行代码中")
                .append("\n 异常类型为:")
                .append(s);
        return keys.toString();
    }


}
