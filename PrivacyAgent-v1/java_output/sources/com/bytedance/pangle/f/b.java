package com.bytedance.pangle.f;

/* loaded from: classes12.dex */
public final class b extends com.bytedance.pangle.d.a {
    private final com.bytedance.pangle.ZeusPluginInstallListener a;

    public b(com.bytedance.pangle.ZeusPluginInstallListener zeusPluginInstallListener) {
        this.a = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.d
    public final void a(java.lang.String str, int i, java.lang.String str2) {
        com.bytedance.pangle.ZeusPluginInstallListener zeusPluginInstallListener = this.a;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i, str2);
        }
    }
}
