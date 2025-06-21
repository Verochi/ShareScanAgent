package com.loc;

/* loaded from: classes23.dex */
public final class aj {
    public static final java.lang.String a = com.loc.y.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    private static com.loc.aj f;
    private java.util.List<java.lang.String> b;
    private java.lang.String c;
    private final android.content.Context d;
    private final android.os.Handler e;

    /* renamed from: com.loc.aj$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;

        public AnonymousClass1(java.lang.String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            android.content.ContentResolver contentResolver;
            java.lang.String str;
            boolean canWrite;
            java.lang.String b = com.loc.ap.b(this.a);
            if (android.text.TextUtils.isEmpty(b)) {
                return;
            }
            if ((this.b & 1) > 0) {
                try {
                    if (android.os.Build.VERSION.SDK_INT >= 23) {
                        canWrite = android.provider.Settings.System.canWrite(com.loc.aj.this.d);
                        if (canWrite) {
                            contentResolver = com.loc.aj.this.d.getContentResolver();
                            str = com.loc.aj.this.c;
                        }
                    } else {
                        contentResolver = com.loc.aj.this.d.getContentResolver();
                        str = com.loc.aj.this.c;
                    }
                    android.provider.Settings.System.putString(contentResolver, str, b);
                } catch (java.lang.Exception unused) {
                }
            }
            if ((this.b & 16) > 0) {
                com.loc.al.a(com.loc.aj.this.d, com.loc.aj.this.c, b);
            }
            if ((this.b & 256) > 0) {
                android.content.SharedPreferences.Editor edit = com.loc.aj.this.d.getSharedPreferences(com.loc.aj.a, 0).edit();
                edit.putString(com.loc.aj.this.c, b);
                edit.apply();
            }
        }
    }

    public static final class a extends android.os.Handler {
        private final java.lang.ref.WeakReference<com.loc.aj> a;

        public a(android.os.Looper looper, com.loc.aj ajVar) {
            super(looper);
            this.a = new java.lang.ref.WeakReference<>(ajVar);
        }

        public a(com.loc.aj ajVar) {
            this.a = new java.lang.ref.WeakReference<>(ajVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            java.lang.Object obj;
            com.loc.aj ajVar = this.a.get();
            if (ajVar == null || message == null || (obj = message.obj) == null) {
                return;
            }
            ajVar.a((java.lang.String) obj, message.what);
        }
    }

    private aj(android.content.Context context) {
        this.d = context.getApplicationContext();
        this.e = android.os.Looper.myLooper() == null ? new com.loc.aj.a(android.os.Looper.getMainLooper(), this) : new com.loc.aj.a(this);
    }

    public static com.loc.aj a(android.content.Context context) {
        if (f == null) {
            synchronized (com.loc.aj.class) {
                if (f == null) {
                    f = new com.loc.aj(context);
                }
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(java.lang.String str, int i) {
        android.content.ContentResolver contentResolver;
        java.lang.String str2;
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            new com.loc.aj.AnonymousClass1(str, i).start();
            return;
        }
        java.lang.String b = com.loc.ap.b(str);
        if (!android.text.TextUtils.isEmpty(b)) {
            if ((i & 1) > 0) {
                try {
                    if (android.os.Build.VERSION.SDK_INT >= 23) {
                        contentResolver = this.d.getContentResolver();
                        str2 = this.c;
                    } else {
                        contentResolver = this.d.getContentResolver();
                        str2 = this.c;
                    }
                    android.provider.Settings.System.putString(contentResolver, str2, b);
                } catch (java.lang.Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                com.loc.al.a(this.d, this.c, b);
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
