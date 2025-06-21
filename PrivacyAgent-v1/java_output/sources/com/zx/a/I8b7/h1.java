package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class h1 {
    public static volatile com.zx.a.I8b7.y1 i;
    public static volatile com.zx.a.I8b7.y1 j;
    public java.util.Timer a;
    public java.util.TimerTask b;
    public volatile int c;
    public volatile int d;
    public final java.util.concurrent.atomic.AtomicBoolean e = new java.util.concurrent.atomic.AtomicBoolean(false);
    public volatile java.lang.String f;
    public volatile long g;
    public com.zx.a.I8b7.z1 h;

    public class a implements android.app.Application.ActivityLifecycleCallbacks {

        /* renamed from: com.zx.a.I8b7.h1$a$a, reason: collision with other inner class name */
        public class RunnableC0537a implements java.lang.Runnable {
            public RunnableC0537a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.zx.a.I8b7.h1.a(com.zx.a.I8b7.h1.this);
                } catch (java.lang.Throwable unused) {
                }
            }
        }

        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            try {
                com.zx.a.I8b7.v3.f.a.e.execute(new com.zx.a.I8b7.h1.a.RunnableC0537a());
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            try {
                com.zx.a.I8b7.h1 h1Var = com.zx.a.I8b7.h1.this;
                h1Var.g = h1Var.a();
                com.zx.a.I8b7.h1.this.f = activity.getClass().getName();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.h1 a = new com.zx.a.I8b7.h1();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008c A[Catch: all -> 0x00bc, TryCatch #0 {all -> 0x00bc, blocks: (B:3:0x0003, B:8:0x001a, B:10:0x0031, B:11:0x007b, B:13:0x008c, B:14:0x0091, B:16:0x00a3, B:21:0x0049, B:22:0x005d, B:23:0x0061), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3 A[Catch: all -> 0x00bc, TRY_LEAVE, TryCatch #0 {all -> 0x00bc, blocks: (B:3:0x0003, B:8:0x001a, B:10:0x0031, B:11:0x007b, B:13:0x008c, B:14:0x0091, B:16:0x00a3, B:21:0x0049, B:22:0x005d, B:23:0x0061), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.zx.a.I8b7.h1 h1Var) throws java.lang.Throwable {
        com.zx.a.I8b7.y1 y1Var;
        java.lang.String str;
        int length;
        com.zx.a.I8b7.y1 y1Var2;
        h1Var.getClass();
        try {
            java.lang.Object opt = h1Var.h.opt(h1Var.f);
            long a2 = h1Var.a() - h1Var.g;
            if (opt == null || !(opt instanceof com.zx.a.I8b7.y1)) {
                y1Var = new com.zx.a.I8b7.y1();
                str = h1Var.g + "#" + a2;
            } else {
                y1Var = (com.zx.a.I8b7.y1) opt;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(h1Var.g);
                int a3 = y1Var.a(sb.toString());
                if (a3 != -1) {
                    y1Var.put(a3, h1Var.g + "#" + a2);
                    h1Var.h.put(h1Var.f, y1Var);
                    length = j.length() - 1;
                    if (length >= 0) {
                        j.remove(length);
                    }
                    j.put(h1Var.h);
                    com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
                    com.zx.a.I8b7.u3 u3Var = l2Var.a;
                    y1Var2 = j;
                    u3Var.getClass();
                    if (y1Var2 == null) {
                        l2Var.a.a(62, y1Var2.toString(), true);
                        com.zx.a.I8b7.r2.a("TABRt had changed refresh:".concat(java.lang.String.valueOf(y1Var2)));
                        return;
                    }
                    return;
                }
                str = h1Var.g + "#" + a2;
            }
            y1Var.put(str);
            h1Var.h.put(h1Var.f, y1Var);
            length = j.length() - 1;
            if (length >= 0) {
            }
            j.put(h1Var.h);
            com.zx.a.I8b7.l2 l2Var2 = com.zx.a.I8b7.l2.a.a;
            com.zx.a.I8b7.u3 u3Var2 = l2Var2.a;
            y1Var2 = j;
            u3Var2.getClass();
            if (y1Var2 == null) {
            }
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder a4 = com.zx.a.I8b7.f3.a("dealTabRT ex:");
            a4.append(th.getMessage());
            com.zx.a.I8b7.r2.b(a4.toString());
        }
    }

    public static void a(com.zx.a.I8b7.h1 h1Var, long j2) throws java.lang.Throwable {
        h1Var.getClass();
        try {
            long a2 = h1Var.a() - j2;
            int length = i.length() - 1;
            if (length >= 0) {
                i.put(length, j2 + "#" + a2);
            }
            com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
            com.zx.a.I8b7.u3 u3Var = l2Var.a;
            com.zx.a.I8b7.y1 y1Var = i;
            u3Var.getClass();
            if (y1Var != null) {
                l2Var.a.a(61, y1Var.toString(), true);
                com.zx.a.I8b7.r2.a("appRt had changed refresh:".concat(java.lang.String.valueOf(y1Var)));
            }
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder a3 = com.zx.a.I8b7.f3.a("dealAppRT ex:");
            a3.append(th.getMessage());
            com.zx.a.I8b7.r2.b(a3.toString());
        }
    }

    public final long a() {
        return java.lang.System.currentTimeMillis() / 1000;
    }

    public final void a(long j2) throws org.json.JSONException {
        java.lang.String a2 = com.zx.a.I8b7.l2.a.a.a.a(61);
        if (android.text.TextUtils.isEmpty(a2)) {
            i = new com.zx.a.I8b7.y1();
        } else {
            i = new com.zx.a.I8b7.y1(a2);
        }
        java.lang.StringBuilder a3 = com.zx.a.I8b7.f3.a("read appRt = ");
        a3.append(i);
        com.zx.a.I8b7.r2.a(a3.toString());
        i.put(j2 + "#0");
        this.c = i.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() throws org.json.JSONException {
        java.lang.String str;
        java.lang.String a2;
        java.util.List<android.content.pm.ResolveInfo> queryIntentActivities;
        if (com.zx.a.I8b7.m3.a.getApplicationContext() instanceof android.app.Application) {
            android.app.Application application = (android.app.Application) com.zx.a.I8b7.m3.a.getApplicationContext();
            this.h = new com.zx.a.I8b7.z1();
            this.g = a();
            try {
                android.content.pm.PackageManager c = com.zx.a.I8b7.w3.c(com.zx.a.I8b7.m3.a);
                android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN", (android.net.Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(com.zx.a.I8b7.m3.g);
                queryIntentActivities = c.queryIntentActivities(intent, 0);
            } catch (java.lang.Exception e) {
                com.zx.a.I8b7.r2.a(e);
            }
            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentActivities.iterator();
                if (it.hasNext()) {
                    str = it.next().activityInfo.name;
                    this.f = str;
                    a2 = com.zx.a.I8b7.l2.a.a.a.a(62);
                    if (android.text.TextUtils.isEmpty(a2)) {
                        j = new com.zx.a.I8b7.y1(a2);
                    } else {
                        j = new com.zx.a.I8b7.y1();
                    }
                    java.lang.StringBuilder a3 = com.zx.a.I8b7.f3.a("read tabRT = ");
                    a3.append(j);
                    com.zx.a.I8b7.r2.a(a3.toString());
                    j.put(this.h);
                    this.d = j.length();
                    application.registerActivityLifecycleCallbacks(new com.zx.a.I8b7.h1.a());
                }
            }
            str = "ZX_MainActivity";
            this.f = str;
            a2 = com.zx.a.I8b7.l2.a.a.a.a(62);
            if (android.text.TextUtils.isEmpty(a2)) {
            }
            java.lang.StringBuilder a32 = com.zx.a.I8b7.f3.a("read tabRT = ");
            a32.append(j);
            com.zx.a.I8b7.r2.a(a32.toString());
            j.put(this.h);
            this.d = j.length();
            application.registerActivityLifecycleCallbacks(new com.zx.a.I8b7.h1.a());
        }
    }
}
