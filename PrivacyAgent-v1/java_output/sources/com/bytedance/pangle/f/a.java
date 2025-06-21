package com.bytedance.pangle.f;

/* loaded from: classes12.dex */
public class a extends com.bytedance.pangle.c.a {
    private static volatile com.bytedance.pangle.f.a a;

    public static com.bytedance.pangle.f.a b() {
        if (a == null) {
            synchronized (com.bytedance.pangle.f.a.class) {
                if (a == null) {
                    a = new com.bytedance.pangle.f.a();
                }
            }
        }
        return a;
    }

    @Override // com.bytedance.pangle.c
    public final void a(int i) {
        com.bytedance.pangle.ZeusPluginStateListener zeusPluginStateListener;
        java.util.List<com.bytedance.pangle.ZeusPluginStateListener> list = com.bytedance.pangle.i.a().b;
        java.util.Iterator<com.bytedance.pangle.ZeusPluginStateListener> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                zeusPluginStateListener = null;
                break;
            }
            zeusPluginStateListener = it.next();
            if ((zeusPluginStateListener instanceof com.bytedance.pangle.f.c) && ((com.bytedance.pangle.f.c) zeusPluginStateListener).a == i) {
                break;
            }
        }
        if (zeusPluginStateListener != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    @Override // com.bytedance.pangle.c
    public final void a(int i, com.bytedance.pangle.d dVar) {
        com.bytedance.pangle.Zeus.registerPluginStateListener(new com.bytedance.pangle.f.c(dVar, i));
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(java.lang.String str) {
        return com.bytedance.pangle.plugin.PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(java.lang.String str, java.lang.String str2) {
        com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start install pkg:" + str + ", path:" + str2);
        return com.bytedance.pangle.plugin.PluginManager.getInstance().syncInstall(str, new java.io.File(str2));
    }

    @Override // com.bytedance.pangle.c
    public final int b(java.lang.String str) {
        return com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
