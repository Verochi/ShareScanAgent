package com.anythink.core.common;

/* loaded from: classes12.dex */
public final class o {
    public static final java.lang.String b = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9PUEVORUQ=";
    public static final java.lang.String c = "Y29tLnhpYW9taS5tYXJrZXQuRE1fUEFHRV9DTE9TRUQ=";
    public static final java.lang.String d = "Y29tLnhpYW9taS5tYXJrZXQuRElSRUNUX01BSUxfU1RBVFVT";
    public static final java.lang.String e = "Y29udGVudDovL2NvbS54aWFvbWkubWFya2V0LnByb3ZpZGVyLkRpcmVjdE1haWxQcm92aWRlcg==";
    private static final java.lang.String f = "code";
    private static final java.lang.String g = "packageName";
    private static volatile java.lang.String j;
    private static volatile com.anythink.core.common.o n;
    android.content.BroadcastReceiver a;
    private java.util.concurrent.CopyOnWriteArrayList<com.anythink.core.common.f.l> h = new java.util.concurrent.CopyOnWriteArrayList<>();
    private final java.util.concurrent.atomic.AtomicBoolean i = new java.util.concurrent.atomic.AtomicBoolean(false);
    private volatile java.lang.Boolean k;
    private com.anythink.core.common.f.l l;
    private android.content.Context m;

    /* renamed from: com.anythink.core.common.o$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        private com.anythink.core.common.f.l a(java.lang.String str) {
            if (com.anythink.core.common.o.this.l != null && android.text.TextUtils.equals(com.anythink.core.common.o.this.l.E(), str)) {
                return com.anythink.core.common.o.this.l;
            }
            if (com.anythink.core.common.o.this.h == null || com.anythink.core.common.o.this.h.size() <= 0) {
                return null;
            }
            java.util.Iterator it = com.anythink.core.common.o.this.h.iterator();
            while (it.hasNext()) {
                com.anythink.core.common.f.l lVar = (com.anythink.core.common.f.l) it.next();
                if (lVar != null && android.text.TextUtils.equals(lVar.E(), str)) {
                    return lVar;
                }
            }
            return null;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            android.os.Bundle extras;
            com.anythink.core.common.f.l lVar;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            java.lang.String action = intent.getAction();
            if (android.text.TextUtils.isEmpty(action) || action.equals(com.anythink.core.common.o.d.b(com.anythink.core.common.o.b)) || action.equals(com.anythink.core.common.o.d.b(com.anythink.core.common.o.c)) || !action.equals(com.anythink.core.common.o.d.b(com.anythink.core.common.o.d)) || (extras = intent.getExtras()) == null) {
                return;
            }
            int i = extras.getInt("code", -1);
            java.lang.String string = extras.getString("packageName", "");
            if (i == -1 || android.text.TextUtils.isEmpty(string)) {
                return;
            }
            if (com.anythink.core.common.o.this.l == null || !android.text.TextUtils.equals(com.anythink.core.common.o.this.l.E(), string)) {
                if (com.anythink.core.common.o.this.h != null && com.anythink.core.common.o.this.h.size() > 0) {
                    java.util.Iterator it = com.anythink.core.common.o.this.h.iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.f.l lVar2 = (com.anythink.core.common.f.l) it.next();
                        if (lVar2 != null && android.text.TextUtils.equals(lVar2.E(), string)) {
                            lVar = lVar2;
                            break;
                        }
                    }
                }
                lVar = null;
            } else {
                lVar = com.anythink.core.common.o.this.l;
            }
            if (lVar == null) {
                return;
            }
            if (i == 4) {
                com.anythink.core.common.o.this.b(lVar);
            }
            com.anythink.core.common.n.c.a(lVar.m(), lVar.s(), "", i, "", 0L, 0L);
        }
    }

    private o() {
    }

    public static com.anythink.core.common.o a() {
        if (n == null) {
            synchronized (com.anythink.core.common.o.class) {
                if (n == null) {
                    n = new com.anythink.core.common.o();
                }
            }
        }
        return n;
    }

    public static java.lang.String b() {
        try {
            return j == null ? "" : java.lang.String.format("[%s]", j);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private void b(android.content.Context context) {
        android.content.BroadcastReceiver broadcastReceiver = this.a;
        if (broadcastReceiver == null || context == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (java.lang.Throwable unused) {
        }
        this.l = null;
        this.h.clear();
        this.h = null;
        this.a = null;
        this.m = null;
    }

    private com.anythink.core.common.f.l d() {
        return this.l;
    }

    private void e() {
        if (this.k == null || !this.k.booleanValue() || this.m == null) {
            return;
        }
        try {
            this.a = new com.anythink.core.common.o.AnonymousClass1();
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.anythink.core.common.o.d.b(b));
            intentFilter.addAction(com.anythink.core.common.o.d.b(c));
            intentFilter.addAction(com.anythink.core.common.o.d.b(d));
            this.m.registerReceiver(this.a, intentFilter);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static java.lang.Boolean f() {
        android.database.Cursor cursor;
        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
        java.lang.Boolean bool = null;
        if (f2 != null && f2.getContentResolver() != null) {
            try {
                cursor = f2.getContentResolver().query(android.net.Uri.parse(com.anythink.core.common.o.d.b(e)), null, null, null, null);
            } catch (java.lang.Throwable unused) {
                cursor = null;
            }
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        java.lang.String string = cursor.getString(cursor.getColumnIndex("support"));
                        if (!android.text.TextUtils.isEmpty(string) && !string.equalsIgnoreCase(com.igexin.push.core.b.m) && (string.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE) || string.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE))) {
                            bool = java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean(string));
                        }
                    } catch (java.lang.Throwable unused2) {
                    }
                    try {
                        j = cursor.getString(cursor.getColumnIndex("detailStyle"));
                    } catch (java.lang.Exception unused3) {
                    }
                }
                try {
                    cursor.close();
                } catch (java.lang.Throwable unused4) {
                }
            }
        }
        return bool;
    }

    public final void a(android.content.Context context) {
        this.m = context;
        if (this.i.compareAndSet(false, true)) {
            try {
                this.k = f();
                if (this.k == null || !this.k.booleanValue() || this.m == null) {
                    return;
                }
                this.a = new com.anythink.core.common.o.AnonymousClass1();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction(com.anythink.core.common.o.d.b(b));
                intentFilter.addAction(com.anythink.core.common.o.d.b(c));
                intentFilter.addAction(com.anythink.core.common.o.d.b(d));
                this.m.registerReceiver(this.a, intentFilter);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public final void a(com.anythink.core.common.f.l lVar) {
        if (this.k == null || lVar == null || !this.k.booleanValue()) {
            return;
        }
        this.l = lVar;
        this.h.add(lVar);
    }

    public final void b(com.anythink.core.common.f.l lVar) {
        if (this.k == null || lVar == null || !this.k.booleanValue()) {
            return;
        }
        this.l = null;
        try {
            this.h.remove(lVar);
        } catch (java.lang.Exception unused) {
        }
    }

    public final int c() {
        if (this.k != null) {
            return this.k.booleanValue() ? 1 : 0;
        }
        return -1;
    }
}
