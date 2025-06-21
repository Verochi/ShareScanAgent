package com.aliyun.common.qupaiokhttp;

/* loaded from: classes.dex */
public class HttpTaskHandler {
    private static com.aliyun.common.qupaiokhttp.HttpTaskHandler httpTaskHandler;
    private static java.util.Map<java.lang.String, java.util.List<com.aliyun.common.qupaiokhttp.OkHttpTask>> httpTaskMap;

    private HttpTaskHandler() {
        httpTaskMap = new java.util.concurrent.ConcurrentHashMap();
    }

    public static com.aliyun.common.qupaiokhttp.HttpTaskHandler getInstance() {
        if (httpTaskHandler == null) {
            httpTaskHandler = new com.aliyun.common.qupaiokhttp.HttpTaskHandler();
        }
        return httpTaskHandler;
    }

    public synchronized void addTask(java.lang.String str, com.aliyun.common.qupaiokhttp.OkHttpTask okHttpTask) {
        java.util.List<com.aliyun.common.qupaiokhttp.OkHttpTask> arrayList;
        java.util.Map<java.lang.String, java.util.List<com.aliyun.common.qupaiokhttp.OkHttpTask>> map;
        if (httpTaskMap.containsKey(str)) {
            arrayList = httpTaskMap.get(str);
            arrayList.add(okHttpTask);
            map = httpTaskMap;
        } else {
            arrayList = new java.util.ArrayList<>();
            arrayList.add(okHttpTask);
            map = httpTaskMap;
        }
        map.put(str, arrayList);
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
