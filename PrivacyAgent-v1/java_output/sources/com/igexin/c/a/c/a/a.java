package com.igexin.c.a.c.a;

/* loaded from: classes22.dex */
public final class a implements com.igexin.c.a.c.a.b {
    public static final java.lang.String a = "[GT-PUSH] ";
    private com.igexin.sdk.IUserLoggerInterface b;
    private final java.lang.StringBuffer c = new java.lang.StringBuffer();

    private void b() {
        if (this.c.length() > 0) {
            if (this.c.toString().contains("\n")) {
                for (java.lang.String str : this.c.toString().split("\n")) {
                    com.igexin.sdk.IUserLoggerInterface iUserLoggerInterface = this.b;
                    if (iUserLoggerInterface != null) {
                        iUserLoggerInterface.log(a.concat(java.lang.String.valueOf(str)));
                    }
                }
            } else {
                this.b.log(a + this.c.toString());
            }
            this.c.setLength(0);
        }
    }

    @Override // com.igexin.c.a.c.a.b
    public final void a() {
        if (this.b != null) {
            b();
        }
    }

    @Override // com.igexin.c.a.c.a.b
    public final void a(com.igexin.sdk.IUserLoggerInterface iUserLoggerInterface) {
        if (iUserLoggerInterface != null) {
            this.b = iUserLoggerInterface;
        }
    }

    @Override // com.igexin.c.a.c.a.b
    public final void a(java.lang.String str) {
        if (this.b != null) {
            b();
            this.b.log(a.concat(java.lang.String.valueOf(str)));
            return;
        }
        if (this.c.length() + str.length() < 5120) {
            java.lang.StringBuffer stringBuffer = this.c;
            stringBuffer.append(str);
            stringBuffer.append("\n");
        } else {
            if (this.c.length() > 5120 || this.c.length() + 135 <= 5120) {
                return;
            }
            java.lang.StringBuffer stringBuffer2 = this.c;
            stringBuffer2.append("Warning! the log cache is too long to show the full content,we suggest you call initialize and setDebugLogger in a short time interval.");
            stringBuffer2.append("\n");
        }
    }

    @Override // com.igexin.c.a.c.a.b
    public final void b(java.lang.String str) {
        if (this.c.length() + str.length() < 5120) {
            java.lang.StringBuffer stringBuffer = this.c;
            stringBuffer.append(str);
            stringBuffer.append("\n");
        } else {
            if (this.c.length() > 5120 || this.c.length() + 135 <= 5120) {
                return;
            }
            java.lang.StringBuffer stringBuffer2 = this.c;
            stringBuffer2.append("Warning! the log cache is too long to show the full content,we suggest you call initialize and setDebugLogger in a short time interval.");
            stringBuffer2.append("\n");
        }
    }
}
