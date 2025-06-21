package org.greenrobot.eventbus.util;

/* loaded from: classes26.dex */
public class ThrowableFailureEvent implements org.greenrobot.eventbus.util.HasExecutionScope {
    public java.lang.Object a;
    protected final boolean suppressErrorUi;
    protected final java.lang.Throwable throwable;

    public ThrowableFailureEvent(java.lang.Throwable th) {
        this.throwable = th;
        this.suppressErrorUi = false;
    }

    public ThrowableFailureEvent(java.lang.Throwable th, boolean z) {
        this.throwable = th;
        this.suppressErrorUi = z;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public java.lang.Object getExecutionScope() {
        return this.a;
    }

    public java.lang.Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSuppressErrorUi() {
        return this.suppressErrorUi;
    }

    @Override // org.greenrobot.eventbus.util.HasExecutionScope
    public void setExecutionScope(java.lang.Object obj) {
        this.a = obj;
    }
}
