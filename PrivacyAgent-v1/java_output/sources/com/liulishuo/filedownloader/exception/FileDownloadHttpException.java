package com.liulishuo.filedownloader.exception;

/* loaded from: classes23.dex */
public class FileDownloadHttpException extends java.io.IOException {
    private final int mCode;
    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> mRequestHeaderMap;
    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> mResponseHeaderMap;

    public FileDownloadHttpException(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map2) {
        super(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("response code error: %d, \n request headers: %s \n response headers: %s", java.lang.Integer.valueOf(i), map, map2));
        this.mCode = i;
        this.mRequestHeaderMap = cloneSerializableMap(map);
        this.mResponseHeaderMap = cloneSerializableMap(map);
    }

    private static java.util.Map<java.lang.String, java.util.List<java.lang.String>> cloneSerializableMap(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), new java.util.ArrayList(entry.getValue()));
        }
        return hashMap;
    }

    public int getCode() {
        return this.mCode;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getRequestHeader() {
        return this.mRequestHeaderMap;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeader() {
        return this.mResponseHeaderMap;
    }
}
