package com.bytedance.pangle.plugin;

/* loaded from: classes12.dex */
final class a implements java.lang.Runnable {
    private java.io.File a;
    private final java.lang.String b;

    public a(java.lang.String str, java.io.File file) {
        this.a = file;
        this.b = str;
    }

    private static java.io.File a(java.io.File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        java.io.File[] listFiles = new java.io.File(file.getParent()).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (java.io.File file2 : listFiles) {
            if (file2.exists() && file2.getName().endsWith(com.anythink.china.common.a.a.g)) {
                return file2;
            }
        }
        return file;
    }

    private static void a(java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2, long j, java.lang.String str3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        try {
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(java.lang.Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a((java.lang.Object) 0));
            jSONObject3.putOpt("duration", java.lang.Integer.valueOf(com.bytedance.pangle.log.b.b(java.lang.Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    private void b() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                java.io.File file = new java.io.File(this.a.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                com.bytedance.pangle.util.g.b(this.a.getAbsolutePath(), file.getAbsolutePath());
                java.io.File[] listFiles = file.listFiles();
                java.io.File file2 = this.a;
                if (listFiles != null && listFiles.length > 0) {
                    file2 = listFiles[0];
                }
                java.io.File a = a(file2);
                if (a != null && a.exists() && a.isFile()) {
                    this.a = a;
                    com.bytedance.pangle.log.ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (java.lang.Exception e) {
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                e.printStackTrace();
            }
        }
    }

    public final boolean a() {
        if (com.bytedance.pangle.util.g.b(this.a)) {
            com.bytedance.pangle.log.ZeusLogger.d("Plugin install : start unZip file ~~~~");
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            b();
            a(com.bytedance.pangle.c.b.h, com.bytedance.pangle.c.b.a.G, this.b, android.os.SystemClock.elapsedRealtime() - elapsedRealtime, "");
            com.bytedance.pangle.log.ZeusLogger.d("Plugin install : start install from unZip ~~~~");
        } else {
            com.bytedance.pangle.log.ZeusLogger.d("Plugin install : start install without unZip ~~~~");
        }
        com.bytedance.pangle.f.a.e a = com.bytedance.pangle.f.a.d.a(this.a);
        if (a == null) {
            com.bytedance.pangle.ZeusPluginStateListener.postStateChange(this.b, 7, " read local file package info failed !!! pluginPkg = " + this.b + " mApkFile.exists = " + this.a.exists());
            java.lang.StringBuilder sb = new java.lang.StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.b);
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        com.bytedance.pangle.plugin.Plugin plugin = com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(a.a);
        if (plugin != null) {
            boolean install = plugin.install(this.a, a);
            if (install) {
                com.bytedance.pangle.ZeusPluginStateListener.postStateChange(a.a, 6, new java.lang.Object[0]);
            } else {
                com.bytedance.pangle.ZeusPluginStateListener.postStateChange(a.a, 7, "Internal error.");
            }
            return install;
        }
        com.bytedance.pangle.ZeusPluginStateListener.postStateChange(this.b, 7, " plugin == null !!! pluginPkg = " + this.b);
        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a.a);
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }
}
