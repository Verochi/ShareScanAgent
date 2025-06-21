package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class v0 implements java.lang.Runnable {
    public final /* synthetic */ com.zx.module.base.Callback a;

    public v0(com.zx.module.base.Callback callback) {
        this.a = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.media.MediaDrm mediaDrm;
        java.lang.Throwable th;
        try {
            try {
                mediaDrm = new android.media.MediaDrm(new java.util.UUID(-1301668207276963122L, -6645017420763422227L));
                try {
                    java.lang.String str = new java.lang.String(android.util.Base64.encode(mediaDrm.getPropertyByteArray("deviceUniqueId"), 2), java.nio.charset.StandardCharsets.UTF_8);
                    if (android.os.Build.VERSION.SDK_INT >= 28) {
                        mediaDrm.close();
                    } else {
                        mediaDrm.release();
                    }
                    this.a.callback(str);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    try {
                        com.zx.a.I8b7.r2.a(th);
                        if (android.os.Build.VERSION.SDK_INT >= 28) {
                            if (mediaDrm != null) {
                                mediaDrm.close();
                            }
                        } else if (mediaDrm != null) {
                            mediaDrm.release();
                        }
                        this.a.callback("");
                    } catch (java.lang.Throwable th3) {
                        try {
                            if (android.os.Build.VERSION.SDK_INT >= 28) {
                                if (mediaDrm != null) {
                                    mediaDrm.close();
                                }
                            } else if (mediaDrm != null) {
                                mediaDrm.release();
                            }
                            this.a.callback("");
                        } catch (java.lang.Throwable unused) {
                        }
                        throw th3;
                    }
                }
            } catch (java.lang.Throwable unused2) {
            }
        } catch (java.lang.Throwable th4) {
            mediaDrm = null;
            th = th4;
        }
    }
}
