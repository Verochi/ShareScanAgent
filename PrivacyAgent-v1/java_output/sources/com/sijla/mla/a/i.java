package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class i extends java.lang.RuntimeException {
    protected int a;
    protected java.lang.String b;
    protected java.lang.String c;
    private java.lang.Throwable d;
    private com.sijla.mla.a.r e;

    public i(com.sijla.mla.a.r rVar) {
        super(rVar.g());
        this.e = rVar;
        this.a = 1;
    }

    public i(java.lang.String str) {
        super(str);
        this.a = 1;
    }

    public i(java.lang.String str, int i) {
        super(str);
        this.a = i;
    }

    public i(java.lang.Throwable th) {
        super("vm error: ".concat(java.lang.String.valueOf(th)));
        this.d = th;
        this.a = 1;
    }

    public final com.sijla.mla.a.r a() {
        com.sijla.mla.a.r rVar = this.e;
        if (rVar != null) {
            return rVar;
        }
        java.lang.String message = getMessage();
        if (message != null) {
            return com.sijla.mla.a.r.h(message);
        }
        return null;
    }

    @Override // java.lang.Throwable
    public final java.lang.Throwable getCause() {
        return this.d;
    }

    @Override // java.lang.Throwable
    public final java.lang.String getMessage() {
        java.lang.String str = this.c;
        if (str != null) {
            return str;
        }
        java.lang.String message = super.getMessage();
        if (message == null) {
            return null;
        }
        if (this.b == null) {
            return message;
        }
        return this.b + " " + message;
    }
}
