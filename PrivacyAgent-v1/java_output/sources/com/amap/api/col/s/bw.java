package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bw {
    public static final java.lang.String a = com.amap.api.col.s.bu.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    public static com.amap.api.col.s.bw f;
    public java.util.List<java.lang.String> b;
    public java.lang.String c;
    public final android.content.Context d;
    public final android.os.Handler e;

    /* renamed from: com.amap.api.col.s.bw$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public final /* synthetic */ java.lang.String n;
        public final /* synthetic */ int t;

        public AnonymousClass1(java.lang.String str, int i) {
            this.n = str;
            this.t = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            java.lang.String b = com.amap.api.col.s.cc.b(this.n);
            if (android.text.TextUtils.isEmpty(b)) {
                return;
            }
            if ((this.t & 1) > 0) {
                try {
                    if (android.os.Build.VERSION.SDK_INT >= 23) {
                        android.provider.Settings.System.putString(com.amap.api.col.s.bw.this.d.getContentResolver(), com.amap.api.col.s.bw.this.c, b);
                    } else {
                        android.provider.Settings.System.putString(com.amap.api.col.s.bw.this.d.getContentResolver(), com.amap.api.col.s.bw.this.c, b);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            if ((this.t & 16) > 0) {
                com.amap.api.col.s.by.a(com.amap.api.col.s.bw.this.d, com.amap.api.col.s.bw.this.c, b);
            }
            if ((this.t & 256) > 0) {
                android.content.SharedPreferences.Editor edit = com.amap.api.col.s.bw.this.d.getSharedPreferences(com.amap.api.col.s.bw.a, 0).edit();
                edit.putString(com.amap.api.col.s.bw.this.c, b);
                edit.apply();
            }
        }
    }

    public static final class a extends android.os.Handler {
        public final java.lang.ref.WeakReference<com.amap.api.col.s.bw> a;

        public a(android.os.Looper looper, com.amap.api.col.s.bw bwVar) {
            super(looper);
            this.a = new java.lang.ref.WeakReference<>(bwVar);
        }

        public a(com.amap.api.col.s.bw bwVar) {
            this.a = new java.lang.ref.WeakReference<>(bwVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            java.lang.Object obj;
            com.amap.api.col.s.bw bwVar = this.a.get();
            if (bwVar == null || message == null || (obj = message.obj) == null) {
                return;
            }
            bwVar.c((java.lang.String) obj, message.what);
        }
    }

    public bw(android.content.Context context) {
        this.d = context.getApplicationContext();
        if (android.os.Looper.myLooper() == null) {
            this.e = new com.amap.api.col.s.bw.a(android.os.Looper.getMainLooper(), this);
        } else {
            this.e = new com.amap.api.col.s.bw.a(this);
        }
    }

    public static com.amap.api.col.s.bw a(android.content.Context context) {
        if (f == null) {
            synchronized (com.amap.api.col.s.bw.class) {
                if (f == null) {
                    f = new com.amap.api.col.s.bw(context);
                }
            }
        }
        return f;
    }

    public final void a(java.lang.String str) {
        this.c = str;
    }

    public final void b(java.lang.String str) {
        java.util.List<java.lang.String> list = this.b;
        if (list != null) {
            list.clear();
            this.b.add(str);
        }
        c(str, 273);
    }

    public final synchronized void c(java.lang.String str, int i) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            new com.amap.api.col.s.bw.AnonymousClass1(str, i).start();
            return;
        }
        java.lang.String b = com.amap.api.col.s.cc.b(str);
        if (!android.text.TextUtils.isEmpty(b)) {
            if ((i & 1) > 0) {
                try {
                    if (android.os.Build.VERSION.SDK_INT >= 23) {
                        android.provider.Settings.System.putString(this.d.getContentResolver(), this.c, b);
                    } else {
                        android.provider.Settings.System.putString(this.d.getContentResolver(), this.c, b);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                com.amap.api.col.s.by.a(this.d, this.c, b);
            }
            if ((i & 256) > 0) {
                android.content.SharedPreferences.Editor edit = this.d.getSharedPreferences(a, 0).edit();
                edit.putString(this.c, b);
                edit.apply();
            }
        }
    }
}
