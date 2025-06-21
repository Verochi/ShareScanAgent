package com.huawei.agconnect.config;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class LazyInputStream {
    public final android.content.Context a;
    public java.io.InputStream b;

    public LazyInputStream(android.content.Context context) {
        this.a = context;
    }

    public final void close() {
        com.huawei.agconnect.config.impl.Utils.closeQuietly(this.b);
    }

    public abstract java.io.InputStream get(android.content.Context context);

    public java.io.InputStream loadInputStream() {
        if (this.b == null) {
            this.b = get(this.a);
        }
        return this.b;
    }
}
