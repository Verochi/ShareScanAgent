package com.huawei.hms.activity.internal;

/* loaded from: classes22.dex */
public interface BusResponseCallback {
    com.huawei.hms.activity.internal.BusResponseResult innerError(android.app.Activity activity, int i, java.lang.String str);

    com.huawei.hms.activity.internal.BusResponseResult succeedReturn(android.app.Activity activity, int i, android.content.Intent intent);
}
