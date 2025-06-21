package com.aliyun.common.logger;

/* loaded from: classes.dex */
public class AndroidLogTool implements com.aliyun.common.logger.LogTool {
    @Override // com.aliyun.common.logger.LogTool
    public void d(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.common.logger.LogTool
    public void e(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.common.logger.LogTool
    public void i(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.common.logger.LogTool
    public void v(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.common.logger.LogTool
    public void w(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.aliyun.common.logger.LogTool
    public void wtf(java.lang.String str, java.lang.String str2) {
        android.util.Log.wtf(str, str2);
    }
}
