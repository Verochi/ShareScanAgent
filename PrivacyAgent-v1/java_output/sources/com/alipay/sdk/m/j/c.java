package com.alipay.sdk.m.j;

/* loaded from: classes.dex */
public enum c {
    SUCCEEDED(9000, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.WAITING_CONNECT, "用户取消"),
    NETWORK_ERROR(com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, "网络连接异常"),
    ACTIVITY_NOT_START_EXIT(6007, "支付未完成"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");

    public int a;
    public java.lang.String b;

    c(int i, java.lang.String str) {
        this.a = i;
        this.b = str;
    }

    public static com.alipay.sdk.m.j.c b(int i) {
        return i != 4001 ? i != 5000 ? i != 8000 ? i != 9000 ? i != 6001 ? i != 6002 ? FAILED : NETWORK_ERROR : CANCELED : SUCCEEDED : PAY_WAITTING : DOUBLE_REQUEST : PARAMS_ERROR;
    }

    public java.lang.String a() {
        return this.b;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public int b() {
        return this.a;
    }
}
