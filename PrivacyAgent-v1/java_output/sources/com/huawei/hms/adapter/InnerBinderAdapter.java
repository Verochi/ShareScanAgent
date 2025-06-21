package com.huawei.hms.adapter;

/* loaded from: classes22.dex */
public class InnerBinderAdapter extends com.huawei.hms.adapter.BinderAdapter {
    private static final int INNER_MSG_CONN_TIMEOUT = 2001;
    private static final int INNER_MSG_DELAY_DISCONNECT = 2002;
    private static final java.lang.Object LOCK_OBJECT_INIT = new java.lang.Object();
    private static final java.lang.String TAG = "InnerBinderAdapter";
    private static com.huawei.hms.adapter.BinderAdapter innerAdapter;

    private InnerBinderAdapter(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, str, str2);
    }

    public static com.huawei.hms.adapter.BinderAdapter getInstance(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.huawei.hms.adapter.BinderAdapter binderAdapter;
        com.huawei.hms.support.log.HMSLog.i(TAG, "InnerBinderAdapter getInstance.");
        synchronized (LOCK_OBJECT_INIT) {
            if (innerAdapter == null) {
                innerAdapter = new com.huawei.hms.adapter.InnerBinderAdapter(context, str, str2);
            }
            binderAdapter = innerAdapter;
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        return 2001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        return 2002;
    }
}
