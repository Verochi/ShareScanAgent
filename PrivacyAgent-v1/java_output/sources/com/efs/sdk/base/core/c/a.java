package com.efs.sdk.base.core.c;

/* loaded from: classes22.dex */
public abstract class a {
    private com.efs.sdk.base.core.c.a.a a;

    public abstract com.efs.sdk.base.core.c.a.a a();

    public final void a(com.efs.sdk.base.core.model.LogDto logDto) {
        try {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        com.efs.sdk.base.core.c.a.a a = a();
                        this.a = a;
                        if (a == null) {
                            return;
                        }
                    }
                }
            }
            this.a.a(logDto);
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.processor", "log handle error", th);
        }
    }
}
