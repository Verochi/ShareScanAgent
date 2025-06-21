package com.anythink.expressad.a.a;

/* loaded from: classes12.dex */
public final class a {
    public static java.lang.String a = "mtg_retry_report=1";
    public static int b = 10000;
    public static final int c = 1;
    public static final int d = 2;
    public static int e = 3;
    public static int f = 50;
    public static int g = 600000;
    public static int h = 0;
    public static int i = 1;
    public static int j = 2;
    public static int k = 3;
    public static int l = 4;
    public static int m = 5;
    private static java.lang.String n = "RetryReportControl";
    private static int q;
    private static int r;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.a.a.b> o;
    private com.anythink.expressad.a.a.c p;

    /* renamed from: s, reason: collision with root package name */
    private android.content.BroadcastReceiver f193s;
    private final android.os.Handler t;

    /* renamed from: com.anythink.expressad.a.a.a$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                com.anythink.expressad.a.a.a.this.t.sendEmptyMessage(2);
            }
        }
    }

    /* renamed from: com.anythink.expressad.a.a.a$a, reason: collision with other inner class name */
    public static class C0176a {
        private static com.anythink.expressad.a.a.a a = new com.anythink.expressad.a.a.a((byte) 0);

        private C0176a() {
        }
    }

    public static class b extends android.os.Handler {
        public b(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(@androidx.annotation.NonNull android.os.Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                com.anythink.expressad.a.a.a.a(com.anythink.expressad.a.a.a.a());
            } else {
                java.lang.Object obj = message.obj;
                if (obj instanceof java.lang.String) {
                    com.anythink.expressad.a.a.a.a().a((java.lang.String) obj, com.anythink.expressad.a.a.b.a);
                }
            }
        }
    }

    private a() {
        this.o = new java.util.concurrent.ConcurrentHashMap<>();
        this.p = new com.anythink.expressad.a.a.c(f);
        this.t = new com.anythink.expressad.a.a.a.b(android.os.Looper.getMainLooper());
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
        e = b2.U();
        b = b2.W() * 1000;
        g = b2.V() * 1000;
        q = b2.T();
        r = b2.S();
        try {
            if (this.f193s == null) {
                this.f193s = new com.anythink.expressad.a.a.a.AnonymousClass1();
                android.content.Context f2 = com.anythink.core.common.b.o.a().f();
                if (f2 != null) {
                    f2.registerReceiver(this.f193s, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static com.anythink.expressad.a.a.a a() {
        return com.anythink.expressad.a.a.a.C0176a.a;
    }

    public static /* synthetic */ void a(com.anythink.expressad.a.a.a aVar) {
        com.anythink.expressad.a.a.c cVar = aVar.p;
        if (cVar != null) {
            java.util.Iterator<java.lang.String> it = cVar.a().iterator();
            while (it.hasNext()) {
                aVar.a(it.next(), com.anythink.expressad.a.a.b.b);
            }
        }
    }

    private void a(java.lang.String str) {
        android.os.Message obtainMessage = this.t.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.t.sendMessageDelayed(obtainMessage, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, int i2) {
        java.lang.String str2;
        com.anythink.expressad.a.a.c cVar = this.p;
        if (cVar != null) {
            com.anythink.expressad.a.a.b b2 = cVar.b(str);
            this.p.a(str);
            if (b2 == null) {
                com.anythink.expressad.a.a.b bVar = this.o.get(str);
                if (bVar == null || java.lang.System.currentTimeMillis() > bVar.h() + g || bVar.g() >= e || i2 == com.anythink.expressad.a.a.b.b) {
                    return;
                }
                a(str);
                return;
            }
            if (java.lang.System.currentTimeMillis() > b2.h() + g) {
                int i3 = com.anythink.expressad.a.a.b.a;
                return;
            }
            b2.a(i2);
            this.o.put(str, b2);
            if (com.anythink.expressad.foundation.h.x.b(str) == 0) {
                str2 = str + "?" + a;
            } else {
                str2 = str + "&" + a;
            }
            com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), b2.f(), b2.e(), str2, b2.a(), b2.b(), b2.d());
        }
    }

    private void a(java.lang.String str, com.anythink.expressad.a.a.b bVar) {
        if (this.p == null) {
            this.p = new com.anythink.expressad.a.a.c(f);
        }
        this.p.a(str, bVar);
    }

    private static boolean a(int i2) {
        return i2 == l || i2 == k;
    }

    private void b() {
        com.anythink.expressad.a.a.c cVar = this.p;
        if (cVar != null) {
            java.util.Iterator<java.lang.String> it = cVar.a().iterator();
            while (it.hasNext()) {
                a(it.next(), com.anythink.expressad.a.a.b.b);
            }
        }
    }

    private static boolean b(int i2) {
        return i2 == i || i2 == j;
    }

    private void c() {
        try {
            if (this.f193s == null) {
                this.f193s = new com.anythink.expressad.a.a.a.AnonymousClass1();
                android.content.Context f2 = com.anythink.core.common.b.o.a().f();
                if (f2 != null) {
                    f2.registerReceiver(this.f193s, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean c(int i2) {
        return a(i2) || b(i2) || i2 == m;
    }

    private void d() {
        android.content.Context f2;
        if (this.f193s == null || (f2 = com.anythink.core.common.b.o.a().f()) == null) {
            return;
        }
        f2.unregisterReceiver(this.f193s);
    }

    public final void a(java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.d.c cVar, java.lang.String str3, boolean z, boolean z2, int i2) {
        if (!(a(i2) || b(i2) || i2 == m) || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String replace = str.replace("?" + a, "").replace("&" + a, "");
        if (this.o == null) {
            this.o = new java.util.concurrent.ConcurrentHashMap<>();
        }
        com.anythink.expressad.a.a.b remove = this.o.remove(replace);
        if (remove == null) {
            remove = new com.anythink.expressad.a.a.b(str, str2);
            remove.b(i2);
            remove.a(z);
            remove.b(z2);
            remove.a(cVar);
            remove.a(str3);
        } else if (remove.c() != com.anythink.expressad.a.a.b.b) {
            remove.b(str2);
        }
        if ((a(i2) && q != 0) || (b(i2) && r != 0) || i2 == m) {
            if (java.lang.System.currentTimeMillis() >= remove.h() + g) {
                remove.c();
                return;
            }
            if (this.p == null) {
                this.p = new com.anythink.expressad.a.a.c(f);
            }
            this.p.a(replace, remove);
            if (remove.c() != com.anythink.expressad.a.a.b.a || remove.g() > e) {
                return;
            }
            a(replace);
        }
    }
}
