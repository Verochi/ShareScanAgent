package com.bytedance.pangle.plugin;

/* loaded from: classes12.dex */
final class d implements java.lang.Runnable {

    /* renamed from: com.bytedance.pangle.plugin.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.io.FileFilter {
        public AnonymousClass1() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            if (file == null) {
                return false;
            }
            if (file.getName().endsWith(com.anythink.china.common.a.a.g) || com.bytedance.pangle.util.g.b(file) || file.getName().endsWith(".7z.zip") || file.getName().endsWith(".jar")) {
                com.bytedance.pangle.plugin.PluginManager.getInstance().asyncInstall(null, file);
                return true;
            }
            if ((file.getAbsolutePath().endsWith(com.anythink.china.common.a.a.e) || file.getAbsolutePath().endsWith(".tp")) && java.lang.System.currentTimeMillis() - file.lastModified() < 259200000) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(java.lang.String.valueOf(file)));
            } else {
                com.bytedance.pangle.util.g.a(file);
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(java.lang.String.valueOf(file)));
            }
            return false;
        }
    }

    private void a(java.io.File file) {
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(java.lang.String.valueOf(file)));
        file.listFiles(new com.bytedance.pangle.plugin.d.AnonymousClass1());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a(new java.io.File(com.bytedance.pangle.d.c.a()));
        java.lang.String c = com.bytedance.pangle.d.c.c();
        if (android.text.TextUtils.isEmpty(c)) {
            return;
        }
        a(new java.io.File(c));
    }
}
