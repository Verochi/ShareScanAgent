package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class FailedBinderCallBack {
    private static final long AGING_TIME = 10000;
    public static final java.lang.String CALLER_ID = "callId";
    private static final java.lang.String TAG = "FailedBinderCallBack";
    private static com.huawei.hms.api.FailedBinderCallBack instance;
    private static java.util.Map<java.lang.Long, com.huawei.hms.api.FailedBinderCallBack.BinderCallBack> binderCallBackMap = new java.util.concurrent.ConcurrentHashMap();
    private static final java.lang.Object LOCK_OBJECT = new java.lang.Object();

    public interface BinderCallBack {
        void binderCallBack(int i);
    }

    private FailedBinderCallBack() {
    }

    private void agingCheck() {
        long time = new java.sql.Timestamp(java.lang.System.currentTimeMillis()).getTime() - 10000;
        for (java.lang.Long l : binderCallBackMap.keySet()) {
            if (time >= l.longValue()) {
                binderCallBackMap.remove(l);
            }
        }
    }

    public static com.huawei.hms.api.FailedBinderCallBack getInstance() {
        synchronized (LOCK_OBJECT) {
            if (instance == null) {
                instance = new com.huawei.hms.api.FailedBinderCallBack();
            }
        }
        return instance;
    }

    private void putCallBackInMap(java.lang.Long l, com.huawei.hms.api.FailedBinderCallBack.BinderCallBack binderCallBack) {
        if (binderCallBackMap == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "binderCallBackMap is null");
        } else {
            agingCheck();
            binderCallBackMap.put(l, binderCallBack);
        }
    }

    public com.huawei.hms.api.FailedBinderCallBack.BinderCallBack getCallBack(java.lang.Long l) {
        java.util.Map<java.lang.Long, com.huawei.hms.api.FailedBinderCallBack.BinderCallBack> map = binderCallBackMap;
        if (map != null) {
            return map.remove(l);
        }
        com.huawei.hms.support.log.HMSLog.e(TAG, "binderCallBackMap is null");
        return null;
    }

    public void setCallBack(java.lang.Long l, com.huawei.hms.api.FailedBinderCallBack.BinderCallBack binderCallBack) {
        putCallBackInMap(l, binderCallBack);
    }
}
