package com.igexin.c.a.c.a;

/* loaded from: classes22.dex */
public class d extends android.os.Handler {
    public static final int b = 1;
    public static final int c = 2;
    public static final java.lang.String d = "log_data";
    private static final java.lang.String e = "d";
    public final android.os.Messenger a;
    private final java.lang.StringBuffer f;
    private android.os.Messenger g;

    public static class a {
        private static final com.igexin.c.a.c.a.d a = new com.igexin.c.a.c.a.d((byte) 0);

        private a() {
        }
    }

    private d() {
        super(android.os.Looper.getMainLooper());
        this.a = new android.os.Messenger(this);
        this.f = new java.lang.StringBuffer();
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    public static com.igexin.c.a.c.a.d a() {
        return com.igexin.c.a.c.a.d.a.a;
    }

    private void a(android.os.Message message) {
        this.g = message.replyTo;
        try {
            if (this.f.length() > 0) {
                b(this.f.toString());
                this.f.setLength(0);
                this.f.trimToSize();
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void b(java.lang.String str) {
        try {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 2;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(d, str);
            obtain.setData(bundle);
            this.g.send(obtain);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private boolean b() {
        return this.f.length() > 0;
    }

    private android.os.IBinder c() {
        return this.a.getBinder();
    }

    public final void a(java.lang.String str) {
        if (com.igexin.push.h.c.a(com.igexin.push.core.ServiceManager.b)) {
            if (this.g != null) {
                b(str);
                return;
            }
            if (this.f.length() + str.length() < 2560) {
                java.lang.StringBuffer stringBuffer = this.f;
                stringBuffer.append(str);
                stringBuffer.append("\n");
            } else {
                if (this.f.length() > 2560 || this.f.length() + 135 <= 2560) {
                    return;
                }
                java.lang.StringBuffer stringBuffer2 = this.f;
                stringBuffer2.append("Warning! the log cache is too long to show the full content,we suggest you call initialize and setDebugLogger in a short time interval.");
                stringBuffer2.append("\n");
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        boolean z = true;
        if (message.what != 1) {
            super.handleMessage(message);
            return;
        }
        this.g = message.replyTo;
        try {
            if (this.f.length() <= 0) {
                z = false;
            }
            if (z) {
                b(this.f.toString());
                this.f.setLength(0);
                this.f.trimToSize();
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
