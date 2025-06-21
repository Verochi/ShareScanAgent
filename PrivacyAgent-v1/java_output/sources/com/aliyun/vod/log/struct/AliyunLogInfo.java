package com.aliyun.vod.log.struct;

/* loaded from: classes12.dex */
public class AliyunLogInfo {
    private java.lang.String mLoggerTag;

    public AliyunLogInfo(java.lang.String str) {
        this.mLoggerTag = str;
    }

    public java.lang.String getRequestID() {
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(this.mLoggerTag);
        if (logger != null) {
            return logger.getRequestID();
        }
        return null;
    }
}
