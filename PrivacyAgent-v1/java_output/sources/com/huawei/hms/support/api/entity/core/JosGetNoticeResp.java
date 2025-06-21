package com.huawei.hms.support.api.entity.core;

/* loaded from: classes22.dex */
public class JosGetNoticeResp extends com.huawei.hms.support.api.entity.core.JosBaseResp {

    @com.huawei.hms.core.aidl.annotation.Packed
    private android.content.Intent noticeIntent;

    private static <T> T get(T t) {
        return t;
    }

    public android.content.Intent getNoticeIntent() {
        return (android.content.Intent) get(this.noticeIntent);
    }

    public void setNoticeIntent(android.content.Intent intent) {
        this.noticeIntent = intent;
    }
}
