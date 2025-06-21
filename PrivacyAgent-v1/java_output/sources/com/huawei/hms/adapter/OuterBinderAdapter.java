package com.huawei.hms.adapter;

/* loaded from: classes22.dex */
public class OuterBinderAdapter extends com.huawei.hms.adapter.BinderAdapter {
    private static final java.lang.Object LOCK_OBJECT_INIT = new java.lang.Object();
    private static final int MSG_CONN_TIMEOUT = 1001;
    private static final int MSG_DELAY_DISCONNECT = 1002;
    private static final java.lang.String TAG = "OuterBinderAdapter";
    private static com.huawei.hms.adapter.BinderAdapter adapter;
    private static java.lang.String sActionName;
    private static java.lang.String sServiceName;

    private OuterBinderAdapter(android.content.Context context, java.lang.String str, java.lang.String str2) {
        super(context, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0030 A[Catch: all -> 0x004b, TryCatch #0 {, blocks: (B:4:0x000a, B:6:0x000e, B:7:0x0047, B:8:0x0049, B:12:0x001a, B:14:0x0022, B:19:0x0030), top: B:3:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.huawei.hms.adapter.BinderAdapter getInstance(android.content.Context context, java.lang.String str, java.lang.String str2) {
        boolean z;
        com.huawei.hms.adapter.BinderAdapter binderAdapter;
        com.huawei.hms.support.log.HMSLog.i(TAG, "OuterBinderAdapter getInstance.");
        synchronized (LOCK_OBJECT_INIT) {
            if (adapter == null) {
                sActionName = str;
                sServiceName = str2;
                adapter = new com.huawei.hms.adapter.OuterBinderAdapter(context, str, str2);
            } else {
                if (com.huawei.hms.common.internal.Objects.equal(sActionName, str) && com.huawei.hms.common.internal.Objects.equal(sServiceName, str2)) {
                    z = false;
                    if (z) {
                        com.huawei.hms.support.log.HMSLog.i(TAG, "OuterBinderAdapter getInstance refresh adapter");
                        sActionName = str;
                        sServiceName = str2;
                        adapter.unBind();
                        adapter = new com.huawei.hms.adapter.OuterBinderAdapter(context, str, str2);
                    }
                }
                z = true;
                if (z) {
                }
            }
            binderAdapter = adapter;
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        return 1001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        return 1002;
    }
}
