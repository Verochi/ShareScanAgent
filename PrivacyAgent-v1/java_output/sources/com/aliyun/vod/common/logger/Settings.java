package com.aliyun.vod.common.logger;

/* loaded from: classes12.dex */
public final class Settings {
    private com.aliyun.vod.common.logger.LogTool logTool;
    private int methodCount = 2;
    private boolean showThreadInfo = true;
    private int methodOffset = 0;
    private com.aliyun.vod.common.logger.LogLevel logLevel = com.aliyun.vod.common.logger.LogLevel.FULL;

    public com.aliyun.vod.common.logger.LogLevel getLogLevel() {
        return this.logLevel;
    }

    public com.aliyun.vod.common.logger.LogTool getLogTool() {
        if (this.logTool == null) {
            this.logTool = new com.aliyun.vod.common.logger.AndroidLogTool();
        }
        return this.logTool;
    }

    public int getMethodCount() {
        return this.methodCount;
    }

    public int getMethodOffset() {
        return this.methodOffset;
    }

    public com.aliyun.vod.common.logger.Settings hideThreadInfo() {
        this.showThreadInfo = false;
        return this;
    }

    public boolean isShowThreadInfo() {
        return this.showThreadInfo;
    }

    public com.aliyun.vod.common.logger.Settings logLevel(com.aliyun.vod.common.logger.LogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    public com.aliyun.vod.common.logger.Settings logTool(com.aliyun.vod.common.logger.LogTool logTool) {
        this.logTool = logTool;
        return this;
    }

    public com.aliyun.vod.common.logger.Settings methodCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.methodCount = i;
        return this;
    }

    public com.aliyun.vod.common.logger.Settings methodOffset(int i) {
        this.methodOffset = i;
        return this;
    }

    @java.lang.Deprecated
    public com.aliyun.vod.common.logger.Settings setLogLevel(com.aliyun.vod.common.logger.LogLevel logLevel) {
        return logLevel(logLevel);
    }

    @java.lang.Deprecated
    public com.aliyun.vod.common.logger.Settings setMethodCount(int i) {
        return methodCount(i);
    }

    @java.lang.Deprecated
    public com.aliyun.vod.common.logger.Settings setMethodOffset(int i) {
        return methodOffset(i);
    }
}
