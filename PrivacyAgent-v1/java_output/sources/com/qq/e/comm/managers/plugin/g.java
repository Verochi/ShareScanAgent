package com.qq.e.comm.managers.plugin;

/* loaded from: classes19.dex */
class g {
    private final java.io.File a;
    private final java.io.File b;
    private java.lang.String c;
    private int d;
    private java.lang.String e;

    public g(java.io.File file, java.io.File file2) {
        this.a = file;
        this.b = file2;
    }

    public java.lang.String a() {
        return this.c;
    }

    public boolean a(android.content.Context context, boolean z) {
        int i;
        try {
            if (this.b.exists() && this.a.exists()) {
                java.lang.String a = com.qq.e.comm.managers.plugin.h.a(this.b);
                this.e = a;
                if (android.text.TextUtils.isEmpty(a)) {
                    return false;
                }
                java.lang.String[] split = this.e.split("#####");
                if (split.length == 2) {
                    java.lang.String str = split[1];
                    try {
                        i = java.lang.Integer.parseInt(split[0]);
                    } catch (java.lang.Throwable unused) {
                        i = 0;
                    }
                    if (com.qq.e.comm.managers.plugin.c.b.a.a(str, this.a)) {
                        this.c = str;
                        this.d = i;
                        if (android.os.Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34 || !z) {
                            return true;
                        }
                        if (!this.a.canWrite() && !this.a.canExecute()) {
                            return this.a.canRead();
                        }
                        return this.a.setReadOnly();
                    }
                }
            }
            return false;
        } catch (java.lang.Throwable unused2) {
            com.qq.e.comm.util.GDTLogger.d("Exception while checking plugin");
            return false;
        }
    }

    public boolean a(java.io.File file, java.io.File file2, android.content.Context context) {
        if (file.equals(this.a) || com.qq.e.comm.managers.plugin.h.a(this.a, file, context, true)) {
            return file2.equals(this.b) || com.qq.e.comm.managers.plugin.h.a(this.b, file2, context, false);
        }
        return false;
    }

    public int b() {
        return this.d;
    }

    public java.lang.String c() {
        return this.e;
    }
}
