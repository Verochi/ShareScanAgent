package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fl {
    public static final java.lang.String a = com.amap.api.mapcore.util.fi.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    private static com.amap.api.mapcore.util.fl f;
    private java.util.List<java.lang.String> b;
    private java.lang.String c;
    private final android.content.Context d;
    private final android.os.Handler e;

    /* renamed from: com.amap.api.mapcore.util.fl$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;

        public AnonymousClass1(java.lang.String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            java.lang.String b = com.amap.api.mapcore.util.fr.b(this.a);
            if (android.text.TextUtils.isEmpty(b)) {
                return;
            }
            if ((this.b & 1) > 0) {
                try {
                    if (android.os.Build.VERSION.SDK_INT >= 23) {
                        android.provider.Settings.System.putString(com.amap.api.mapcore.util.fl.this.d.getContentResolver(), com.amap.api.mapcore.util.fl.this.c, b);
                    } else {
                        android.provider.Settings.System.putString(com.amap.api.mapcore.util.fl.this.d.getContentResolver(), com.amap.api.mapcore.util.fl.this.c, b);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            if ((this.b & 16) > 0) {
                com.amap.api.mapcore.util.fn.a(com.amap.api.mapcore.util.fl.this.d, com.amap.api.mapcore.util.fl.this.c, b);
            }
            if ((this.b & 256) > 0) {
                android.content.SharedPreferences.Editor edit = com.amap.api.mapcore.util.fl.this.d.getSharedPreferences(com.amap.api.mapcore.util.fl.a, 0).edit();
                edit.putString(com.amap.api.mapcore.util.fl.this.c, b);
                edit.apply();
            }
        }
    }

    public static final class a extends android.os.Handler {
        private final java.lang.ref.WeakReference<com.amap.api.mapcore.util.fl> a;

        public a(android.os.Looper looper, com.amap.api.mapcore.util.fl flVar) {
            super(looper);
            this.a = new java.lang.ref.WeakReference<>(flVar);
        }

        public a(com.amap.api.mapcore.util.fl flVar) {
            this.a = new java.lang.ref.WeakReference<>(flVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            java.lang.Object obj;
            com.amap.api.mapcore.util.fl flVar = this.a.get();
            if (flVar == null || message == null || (obj = message.obj) == null) {
                return;
            }
            flVar.a((java.lang.String) obj, message.what);
        }
    }

    private fl(android.content.Context context) {
        this.d = context.getApplicationContext();
        if (android.os.Looper.myLooper() == null) {
            this.e = new com.amap.api.mapcore.util.fl.a(android.os.Looper.getMainLooper(), this);
        } else {
            this.e = new com.amap.api.mapcore.util.fl.a(this);
        }
    }

    public static com.amap.api.mapcore.util.fl a(android.content.Context context) {
        if (f == null) {
            synchronized (com.amap.api.mapcore.util.fl.class) {
                if (f == null) {
                    f = new com.amap.api.mapcore.util.fl(context);
                }
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(java.lang.String str, int i) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            new com.amap.api.mapcore.util.fl.AnonymousClass1(str, i).start();
            return;
        }
        java.lang.String b = com.amap.api.mapcore.util.fr.b(str);
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
                com.amap.api.mapcore.util.fn.a(this.d, this.c, b);
            }
            if ((i & 256) > 0) {
                android.content.SharedPreferences.Editor edit = this.d.getSharedPreferences(a, 0).edit();
                edit.putString(this.c, b);
                edit.apply();
            }
        }
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
        a(str, 273);
    }
}
