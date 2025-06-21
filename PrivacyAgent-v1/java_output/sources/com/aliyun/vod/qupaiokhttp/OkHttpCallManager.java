package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
class OkHttpCallManager {
    private static com.aliyun.vod.qupaiokhttp.OkHttpCallManager manager;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, okhttp3.Call> callMap = new java.util.concurrent.ConcurrentHashMap<>();

    private OkHttpCallManager() {
    }

    public static com.aliyun.vod.qupaiokhttp.OkHttpCallManager getInstance() {
        if (manager == null) {
            manager = new com.aliyun.vod.qupaiokhttp.OkHttpCallManager();
        }
        return manager;
    }

    public void addCall(java.lang.String str, okhttp3.Call call) {
        if (call == null || com.aliyun.vod.common.utils.StringUtils.isEmpty(str)) {
            return;
        }
        this.callMap.put(str, call);
    }

    public okhttp3.Call getCall(java.lang.String str) {
        if (com.aliyun.vod.common.utils.StringUtils.isEmpty(str)) {
            return null;
        }
        return this.callMap.get(str);
    }

    public void removeCall(java.lang.String str) {
        if (com.aliyun.vod.common.utils.StringUtils.isEmpty(str)) {
            return;
        }
        this.callMap.remove(str);
    }
}
