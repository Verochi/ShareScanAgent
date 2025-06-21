package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
public class HttpTaskHandler {
    private static com.aliyun.vod.qupaiokhttp.HttpTaskHandler httpTaskHandler;
    private static java.util.Map<java.lang.String, java.util.List<com.aliyun.vod.qupaiokhttp.OkHttpTask>> httpTaskMap;

    private HttpTaskHandler() {
        httpTaskMap = new java.util.concurrent.ConcurrentHashMap();
    }

    public static com.aliyun.vod.qupaiokhttp.HttpTaskHandler getInstance() {
        if (httpTaskHandler == null) {
            httpTaskHandler = new com.aliyun.vod.qupaiokhttp.HttpTaskHandler();
        }
        return httpTaskHandler;
    }

    public synchronized void addTask(java.lang.String str, com.aliyun.vod.qupaiokhttp.OkHttpTask okHttpTask) {
        if (httpTaskMap.containsKey(str)) {
            java.util.List<com.aliyun.vod.qupaiokhttp.OkHttpTask> list = httpTaskMap.get(str);
            list.add(okHttpTask);
            httpTaskMap.put(str, list);
        } else {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(okHttpTask);
            httpTaskMap.put(str, arrayList);
        }
    }

    public boolean contains(java.lang.String str) {
        return httpTaskMap.containsKey(str);
    }

    public synchronized void removeTask(java.lang.String str) {
        if (httpTaskMap.containsKey(str)) {
            httpTaskMap.remove(str);
        }
    }
}
