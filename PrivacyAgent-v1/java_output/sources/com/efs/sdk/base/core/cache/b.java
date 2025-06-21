package com.efs.sdk.base.core.cache;

/* loaded from: classes22.dex */
public final class b extends android.os.Handler implements java.lang.Runnable {
    boolean a;
    boolean b;

    public static class a {
        private static final com.efs.sdk.base.core.cache.b a = new com.efs.sdk.base.core.cache.b((byte) 0);
    }

    private b() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        this.a = true;
        this.b = true;
        sendEmptyMessageDelayed(2, 60000L);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static com.efs.sdk.base.core.cache.b a() {
        return com.efs.sdk.base.core.cache.b.a.a;
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        if (message.what == 2) {
            com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(this);
            return;
        }
        com.efs.sdk.base.core.util.Log.w("efs.cache", "disk listener not support command: " + message.what);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.efs.sdk.base.core.cache.CacheManager.getInstance();
        java.io.File h = com.efs.sdk.base.core.util.a.h(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        if (h.exists()) {
            for (java.io.File file : com.efs.sdk.base.core.util.FileUtil.listFiles(h)) {
                if (com.efs.sdk.base.core.cache.CacheManager.a(file.getName())) {
                    com.efs.sdk.base.core.cache.CacheManager.a(file);
                }
            }
        }
        com.efs.sdk.base.core.cache.CacheManager.getInstance();
        java.io.File i = com.efs.sdk.base.core.util.a.i(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        if (i.exists()) {
            for (java.io.File file2 : com.efs.sdk.base.core.util.FileUtil.listFiles(i)) {
                if (com.efs.sdk.base.core.cache.CacheManager.a(file2.getName())) {
                    com.efs.sdk.base.core.cache.CacheManager.a(file2);
                }
            }
        }
        long parseLong = java.lang.Long.parseLong(com.efs.sdk.base.core.config.remote.b.a().a("disk_bytes", "4194304"));
        long folderSize = com.efs.sdk.base.core.util.FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.h(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid())) + com.efs.sdk.base.core.util.FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.d(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z = folderSize < parseLong;
        this.a = z;
        if (!z) {
            com.efs.sdk.base.core.util.Log.w("efs.cache", "Cache Limited! curr " + folderSize + "byte, max " + parseLong + " byte.");
        }
        long parseLong2 = java.lang.Long.parseLong(com.efs.sdk.base.core.config.remote.b.a().a("apm_codelog_store_max", "5")) * 1024 * 1024;
        long folderSize2 = com.efs.sdk.base.core.util.FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.i(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid())) + com.efs.sdk.base.core.util.FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.e(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z2 = folderSize2 < parseLong2;
        this.b = z2;
        if (!z2) {
            com.efs.sdk.base.core.util.Log.w("efs.cache", "code log. Cache Limited! curr " + folderSize2 + "byte, max " + parseLong2 + " byte.");
        }
        sendEmptyMessageDelayed(2, 600000L);
    }
}
