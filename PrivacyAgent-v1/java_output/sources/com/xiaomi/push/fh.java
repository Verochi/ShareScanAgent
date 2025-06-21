package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class fh extends java.lang.Exception {
    java.lang.Throwable a;
    private com.xiaomi.push.fq b;
    private com.xiaomi.push.fr c;

    public fh() {
        this.b = null;
        this.c = null;
        this.a = null;
    }

    public fh(com.xiaomi.push.fq fqVar) {
        this.c = null;
        this.a = null;
        this.b = fqVar;
    }

    public fh(java.lang.String str) {
        super(str);
        this.b = null;
        this.c = null;
        this.a = null;
    }

    public fh(java.lang.String str, java.lang.Throwable th) {
        super(str);
        this.b = null;
        this.c = null;
        this.a = th;
    }

    public fh(java.lang.Throwable th) {
        this.b = null;
        this.c = null;
        this.a = th;
    }

    @Override // java.lang.Throwable
    public final java.lang.String getMessage() {
        com.xiaomi.push.fq fqVar;
        com.xiaomi.push.fr frVar;
        java.lang.String message = super.getMessage();
        return (message != null || (frVar = this.c) == null) ? (message != null || (fqVar = this.b) == null) ? message : fqVar.toString() : frVar.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        printStackTrace(java.lang.System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(java.io.PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.a != null) {
            printStream.println("Nested Exception: ");
            this.a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(java.io.PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.a != null) {
            printWriter.println("Nested Exception: ");
            this.a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        com.xiaomi.push.fr frVar = this.c;
        if (frVar != null) {
            sb.append(frVar);
        }
        com.xiaomi.push.fq fqVar = this.b;
        if (fqVar != null) {
            sb.append(fqVar);
        }
        if (this.a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.a);
        }
        return sb.toString();
    }
}
