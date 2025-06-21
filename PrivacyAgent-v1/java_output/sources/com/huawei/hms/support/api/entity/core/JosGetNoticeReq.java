package com.huawei.hms.support.api.entity.core;

/* loaded from: classes22.dex */
public class JosGetNoticeReq extends com.huawei.hms.support.api.entity.core.JosBaseReq {
    public static final int NOTICE_TYPE_CONN = 0;
    public static final int NOTICE_TYPE_SIGN = 1;

    @com.huawei.hms.core.aidl.annotation.Packed
    private int noticeType;

    private static <T> T get(T t) {
        return t;
    }

    public int getNoticeType() {
        return ((java.lang.Integer) get(java.lang.Integer.valueOf(this.noticeType))).intValue();
    }

    public void setNoticeType(int i) {
        this.noticeType = i;
    }
}
