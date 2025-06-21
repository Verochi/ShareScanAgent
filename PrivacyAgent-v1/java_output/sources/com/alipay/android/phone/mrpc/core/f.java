package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class f implements org.apache.http.conn.ConnectionKeepAliveStrategy {
    public final /* synthetic */ com.alipay.android.phone.mrpc.core.d a;

    public f(com.alipay.android.phone.mrpc.core.d dVar) {
        this.a = dVar;
    }

    @Override // org.apache.http.conn.ConnectionKeepAliveStrategy
    public final long getKeepAliveDuration(org.apache.http.HttpResponse httpResponse, org.apache.http.protocol.HttpContext httpContext) {
        return org.apache.tools.ant.taskdefs.WaitFor.DEFAULT_MAX_WAIT_MILLIS;
    }
}
