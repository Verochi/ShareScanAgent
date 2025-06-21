package com.alimm.tanx.core.view.player.cache.videocache.log;

/* loaded from: classes.dex */
public class Logger {
    private final java.lang.String tag;

    public Logger(java.lang.String str) {
        this.tag = str;
    }

    public void debug(java.lang.String... strArr) {
        com.alimm.tanx.core.utils.LogUtils.d(this.tag, strArr);
    }

    public void error(java.lang.String str) {
        com.alimm.tanx.core.utils.LogUtils.e(this.tag, str);
    }

    public void error(java.lang.String str, java.lang.Throwable th) {
        com.alimm.tanx.core.utils.LogUtils.e(this.tag, str, th);
    }

    public void info(java.lang.String... strArr) {
        com.alimm.tanx.core.utils.LogUtils.i(this.tag, strArr);
    }

    public void warn(java.lang.String str, java.lang.Exception exc) {
        com.alimm.tanx.core.utils.LogUtils.w(this.tag, str, exc.getMessage());
    }

    public void warn(java.lang.String... strArr) {
        com.alimm.tanx.core.utils.LogUtils.w(this.tag, strArr);
    }
}
