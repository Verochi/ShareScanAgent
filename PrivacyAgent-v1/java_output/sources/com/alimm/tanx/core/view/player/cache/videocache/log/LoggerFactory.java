package com.alimm.tanx.core.view.player.cache.videocache.log;

/* loaded from: classes.dex */
public class LoggerFactory {
    public static com.alimm.tanx.core.view.player.cache.videocache.log.Logger getLogger(java.lang.String str) {
        return new com.alimm.tanx.core.view.player.cache.videocache.log.Logger(str);
    }

    public static void log(java.lang.String... strArr) {
        com.alimm.tanx.core.utils.LogUtils.d("VideoCache", strArr);
    }
}
