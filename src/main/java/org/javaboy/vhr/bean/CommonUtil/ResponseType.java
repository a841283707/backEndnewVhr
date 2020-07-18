package org.javaboy.vhr.bean.CommonUtil;


import org.omg.CORBA.TRANSACTION_MODE;

/**
 * 枚举 Web API 响应时可能出现的结果
 *
 * @author BeanYon
 * 2019.07.25
 */
public enum ResponseType {
    // Web API
    SUCCESS(true, 1000, "操作成功"),
    FAILED(false, 1001, "操作失败"),
    ILLEGAL_TEL(false, 1002, "手机号不合法"),
    ILLEGAL_PASSWORD(false, 1003, "密码不合法，请提供散列后的密码"),
    ILLEGAL_ACCOUNT(false, 1004, "账号不存在"),
    PASSWORD_NOT_MATCH(false, 1005, "密码错误"),
    ILLEGAL_NAME(false, 1006, "用户名不能为空"),
    ILLEGAL_CREATE_USER(false, 1007, "创建者id不合法"),
    MISSING_REQUIRED_PARAM(false, 1008, "缺失必要参数"),
    ILLEGAL_EMAIL(false, 1009, "邮箱不合法"),
    ILLEGAL_REQUEST_METHOD(false, 1010, "Request Method不合法"),
    NOTHING_TO_UPDATE(false, 1011, "没有要更新的内容"),
    NOTEXIST(false,1012,"不存在"),
    ILLEGAL_DELETE(false,1013,"删除失败"),
    ILLEGAL_INPUT(false,1014,"必要信息不完整"),
    NOT_EXIST_DZ(false,1015,"找不到档主信息"),
    NOT_EXIST_SJ(false,1016,"找不到司机信息"),
    NOT_EXIST_CX(false,1017,"找不到车型"),
    FAILED_INSERT_YSPCB(false,1018,"运输批次表新增记录失败"),
    FAILED_INSERT_YSPCB_NCP_GXB(false,1019,"运输批次&农产品&关系表，新增记录失败"),
    FAILED_UPLOAD_IMAGES(false,1020,"图片上传失败"),
    FAILED_UPDATE_ZM(false,1021,"凭证更新失败"),
    FAILED_SEREACH(false,1022,"查询失败"),
    SUCCESS_MISSING_NECESSARY_ROLE(true,1023,"登录成功，但必要角色未注册"),
    FAILED_MISSING_NECESSARY_ROLE(false,1024,"必要角色未注册"),
    FAILED_ROLE_EXIST(false,1025,"角色已存在，请勿重复注册"),
    SUCCESS_NOTHING(true,1026,"成功,但没有任何数据"),
    SUCCESS_YSPC_FLAGED(true,1027,"门禁已核验该运输批次"),
    NOT_EXIST_YSPC(false,1028,"运输批次不存在"),
    NOT_EXIST_QDYH(false,1029,"前端用户不存在"),
    FAILED_INSERT_JYDZ2DZZB(false,1030,"插入档主交易总表失败"),
    FAILED_INSERT_JYDZ2DZMXB(false,1031,"插入档主交易明细表失败"),
    FAILED_DUPLICATE_INSERT_FFB(false,1032,"批量插入FF表失败"),
    FAILED_DUPLICATE_INSERT_JYDZ2DZMXB(false,1033,"批量插入JYDZ2DZMXB表失败"),
    FAILED_DUPLICATE_UPDATE_FFB(false,1034,"批量更新FF表失败"),
    NOT_EXIST_FFB_ENTRY(false,1035,"找不到分发表记录"),
    FAILED_SAVE_OR_UPDATE_CZZB(false,1036,"插入或更新处置总表失败"),
    FAILED_INSERT_CZMXB(false,1037,"插入档主处置明细表失败"),
    FAILED_UPDATE_FFB(false,1038,"更新FF表失败"),
    ILLEGAL_INPUT_TIME(false,1039,"错误的时间格式"),
    ILLEGAL_INPUT_WEIGHT(false, 1040, "重量输入有误"),
    ILLEGAL_INPUT_WEIGHT_OR_PRICE(false, 1041, "重量或单价输入有误"),
    NOT_EXIST_XFZ(false,1042,"消费者用户不存在"),
    ILLEGAL_INPUT_NOTHING(false,1043,"输入为空"),
    FAILED_UPDATE_XFZ_JYZT(false,1044,"更新消费者交易状态数据失败"),
    FAILED_UPDATE_DDLB(false,1045,"更新订单列表失败"),
    NOT_EXIST_LDSH(false,1046,"流动商户不存在"),
    FAILED_INSERT_LHBB_LDSH(false,1047,"新增流动商户报备失败"),
    ILLEGAL_YSPC(false,1048,"该批次未通过报备审核"),
    NOT_EXIST_PCNCPGXB_RECORD(false,1049,"批次农产品关系表记录不存在"),
    FAILED_INSERT_FFB(false,1050,"分发表新增记录失败"),
    FAILED_UPDATE_JYPCNCPGXB(false,1051,"更新交易表农产品&运输批次&关系表表失败"),
    NOT_EXIST_NCP(false,1052,"农产品不存在"),
    NOT_EXIST_ENTRY(false,1053,"无记录"),
    NOT_EXIST_ENTRY_NCP_OR_NCPGXB(false,1054,"无关系表或农产品记录"),
    FAILED_INSERT_DDLB_OR_UPDATE_JYZT(false,1055,"新增交易——订单列表 或 更新消费者交易状态 失败！"),
    FAILED_INSERT_JYDD(false,1056,"新增JY_DD数据失败"),
    FAILED_INSERT_JYDDNCPGXB(false,1057,"交易&订单&农产品&关系表数据失败！"),
    FAILED_INSERT_JJTDZB(false,1058,"新增交接退单总表失败"),
    NOT_EXIST_JYDD(false,1059,"交易订单不存在"),
    FAILED_SCZLZERO_JJTH(false,1060,"售出总量为0"),
    ILLEGAL_JJTH_ZT(false,1061,"该商品已经在交接退货处理状态中"),
    EXIST_ENTRY(false,1062,"已存在记录"),
    ILLEGAL_JYTH_ZT(false,1063,"该商品已经在交易退货处理状态中"),
    FAILED_UPDATE_QDYH(false,1064,"更新前端用户信息失败"),
    FAILED_DUPLICATE_INSERT_ZLJC_ZB(false,1065,"批量插入质检总表失败"),
    FAILED_DUPLICATE_INSERT_ZLJC_MXB(false,1066,"批量插入质检明细表失败"),
    NOT_EXIST_HDYH(false,1067,"后端用户不存在"),
    ILLEGAL_YZM(false,1068,"验证码错误"),
    FAILED_SAVE_YSPC_WITH_MULTI_RECORD(false,1069,"无效报备，该时间存在多条记录"),
    FAILED_SAVE_YSPC_WITH_MULTI_CAR_RECORD(false,1070 ,"无效报备，该时间存在多条车辆到达记录" ),
    FAILED_SAVE_YSPC_WITH_CROWDED(false,1071 ,"无效报备，该时间段过于拥挤" ),
    FAILED_CONVERT_JSON(false,1072 ,"JSON格式转换失败" ),
    FAILD_CONVERT_TIME(false,1073,"时间转换失败"),
    //FAILED_SCZLZERO_JJTH
    // 数据库
    DATA_EXIST(false, 2001, "重复添加具有唯一约束的数据"),
    // 未知
    UNKNOWN(false, 3000, "服务器出现未知错误"),
    // 权限
    UNAUTH(false, 4001, "权限不足"),
    NO_LOGIN(false, 4002, "尚未登录"),
    //对接
    NOT_EXIST_BBXX(false,5001,"未报备"),
    SUCCESS_QUERY_BBXX(true,5002,"已报备"),
    SUCCESS_QUERY_BBXX_IMPERFECT(true,5003,"已报备，报备信息不完整");
    /**
     * 是否请求成功
     */
    private boolean result;
    /**
     * 异常标识码
     */
    private int code;
    /**
     * 异常信息
     */
    private String message;

    private ResponseType(boolean result, int code, String message) {
        this.result = result;
        this.code = code;
        this.message = message;
    }

    public boolean getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

