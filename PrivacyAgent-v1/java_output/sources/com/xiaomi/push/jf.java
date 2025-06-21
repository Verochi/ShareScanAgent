package com.xiaomi.push;

/* loaded from: classes19.dex */
public abstract class jf implements java.lang.Runnable {
    private android.content.Context a;
    private java.io.File b;
    private java.lang.Runnable c;

    private jf(android.content.Context context, java.io.File file) {
        this.a = context;
        this.b = file;
    }

    public /* synthetic */ jf(android.content.Context context, java.io.File file, byte b) {
        this(context, file);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        com.xiaomi.push.je jeVar = null;
        try {
            try {
                if (this.b == null) {
                    this.b = new java.io.File(this.a.getFilesDir(), "default_locker");
                }
                jeVar = com.xiaomi.push.je.a(this.a, this.b);
                java.lang.Runnable runnable = this.c;
                if (runnable != null) {
                    runnable.run();
                }
                a();
                jeVar.a();
            } catch (java.io.IOException e) {
                e.printStackTrace();
                if (jeVar != null) {
                    jeVar.a();
                }
            }
        } catch (java.lang.Throwable th) {
            if (jeVar != null) {
                jeVar.a();
            }
            throw th;
        }
    }
}
