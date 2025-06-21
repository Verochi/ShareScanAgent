package com.aliyun.vod.common.logger;

/* loaded from: classes12.dex */
public class AndroidLogTool implements com.aliyun.vod.common.logger.LogTool {
    @Override // com.aliyun.vod.common.logger.LogTool
    public void d(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void e(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void i(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void v(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void w(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.vod.common.logger.LogTool
    public void wtf(java.lang.String str, java.lang.String str2) {
        android.util.Log.wtf(str, str2);
    }
}
