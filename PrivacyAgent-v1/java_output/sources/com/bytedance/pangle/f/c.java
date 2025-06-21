package com.bytedance.pangle.f;

/* loaded from: classes12.dex */
public final class c extends com.bytedance.pangle.ZeusPluginStateListener {
    final int a;
    private final com.bytedance.pangle.d b;

    public c(com.bytedance.pangle.d dVar, int i) {
        this.b = dVar;
        this.a = i;
    }

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public final void onStateChangeOnCurThread(java.lang.String str, int i, java.lang.Object... objArr) {
        if (i == 5 || i == 7 || i == 6) {
            java.lang.String str2 = "";
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = java.lang.String.valueOf(objArr[0]);
                    }
                } catch (android.os.RemoteException unused) {
                    return;
                }
            }
            this.b.a(str, i, str2);
        }
    }
}
