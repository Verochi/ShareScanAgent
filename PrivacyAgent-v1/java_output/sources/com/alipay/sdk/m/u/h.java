package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class h {
    public static final java.lang.String j = "failed";
    public static final java.lang.String k = "scheme_failed";
    public android.app.Activity a;
    public volatile com.alipay.android.app.IAlixPay b;
    public boolean d;
    public com.alipay.sdk.m.u.h.g e;
    public final com.alipay.sdk.m.s.a f;
    public final java.lang.Object c = com.alipay.android.app.IAlixPay.class;
    public boolean g = false;
    public java.lang.String h = null;
    public java.lang.String i = null;

    public class a implements com.alipay.sdk.app.AlipayResultActivity.a {
        public final /* synthetic */ java.util.concurrent.CountDownLatch a;

        public a(java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.a
        public void a(int i, java.lang.String str, java.lang.String str2) {
            com.alipay.sdk.m.u.h.this.h = com.alipay.sdk.m.j.b.a(i, str, str2);
            this.a.countDown();
        }
    }

    public class b implements com.alipay.sdk.app.APayEntranceActivity.a {
        public final /* synthetic */ java.lang.Object a;

        public b(java.lang.Object obj) {
            this.a = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(java.lang.String str) {
            com.alipay.sdk.m.u.h.this.i = str;
            synchronized (this.a) {
                try {
                    this.a.notify();
                } finally {
                }
            }
        }
    }

    public class c implements java.lang.Runnable {
        public final /* synthetic */ com.alipay.sdk.app.APayEntranceActivity.a a;

        public c(com.alipay.sdk.app.APayEntranceActivity.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.alipay.sdk.m.u.h.this.f == null || com.alipay.sdk.m.u.h.this.f.d()) {
                return;
            }
            com.alipay.sdk.m.k.a.b(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.e0, "");
            if (com.alipay.sdk.m.m.a.D().w()) {
                com.alipay.sdk.m.u.h.this.f.b(true);
                this.a.a(com.alipay.sdk.m.j.b.a());
            }
        }
    }

    public class d implements java.lang.Runnable {
        public final /* synthetic */ android.content.Intent a;
        public final /* synthetic */ java.lang.Object b;

        public d(android.content.Intent intent, java.lang.Object obj) {
            this.a = intent;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.alipay.sdk.m.u.h.this.a != null) {
                    com.alipay.sdk.m.u.h.this.a.startActivity(this.a);
                } else {
                    com.alipay.sdk.m.k.a.b(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.c0, "");
                    android.content.Context a = com.alipay.sdk.m.u.h.this.f.a();
                    if (a != null) {
                        a.startActivity(this.a);
                    }
                }
            } finally {
            }
        }
    }

    public class e extends com.alipay.android.app.IRemoteServiceCallback.Stub {
        public e() {
        }

        public /* synthetic */ e(com.alipay.sdk.m.u.h hVar, com.alipay.sdk.m.u.h.a aVar) {
            this();
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws android.os.RemoteException {
            return 4;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws android.os.RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(java.lang.String str, java.lang.String str2, java.util.Map map) throws android.os.RemoteException {
            com.alipay.sdk.m.k.a.a(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.p, str, str2);
            if (android.text.TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (com.alipay.sdk.m.u.h.this.e != null) {
                    com.alipay.sdk.m.u.h.this.e.a();
                }
                if (com.alipay.sdk.m.u.h.this.f != null) {
                    com.alipay.sdk.m.u.h.this.f.c(true);
                }
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(java.lang.String str, java.lang.String str2, int i, android.os.Bundle bundle) throws android.os.RemoteException {
            android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN", (android.net.Uri) null);
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (java.lang.Exception e) {
                com.alipay.sdk.m.k.a.a(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Z, e);
            }
            intent.setClassName(str, str2);
            try {
                android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new android.app.ActivityManager.RunningAppProcessInfo();
                android.app.ActivityManager.getMyMemoryState(runningAppProcessInfo);
                com.alipay.sdk.m.k.a.a(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.l, "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
            } catch (java.lang.Throwable unused) {
            }
            try {
                if (com.alipay.sdk.m.u.h.this.a == null) {
                    com.alipay.sdk.m.k.a.b(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                    android.content.Context a = com.alipay.sdk.m.u.h.this.f.a();
                    if (a != null) {
                        a.startActivity(intent);
                        return;
                    }
                    return;
                }
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                com.alipay.sdk.m.u.h.this.a.startActivity(intent);
                com.alipay.sdk.m.k.a.a(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.l, "stAct2", "" + (android.os.SystemClock.elapsedRealtime() - elapsedRealtime));
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.k.a.a(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th);
                throw th;
            }
        }
    }

    public class f implements android.content.ServiceConnection {
        public f() {
        }

        public /* synthetic */ f(com.alipay.sdk.m.u.h hVar, com.alipay.sdk.m.u.h.a aVar) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.alipay.sdk.m.k.a.a(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.l, "srvCon");
            synchronized (com.alipay.sdk.m.u.h.this.c) {
                com.alipay.sdk.m.u.h.this.b = com.alipay.android.app.IAlixPay.Stub.asInterface(iBinder);
                com.alipay.sdk.m.u.h.this.c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.alipay.sdk.m.k.a.a(com.alipay.sdk.m.u.h.this.f, com.alipay.sdk.m.k.b.l, "srvDis");
            com.alipay.sdk.m.u.h.this.b = null;
        }
    }

    public interface g {
        void a();

        void b();
    }

    public h(android.app.Activity activity, com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.u.h.g gVar) {
        this.a = activity;
        this.f = aVar;
        this.e = gVar;
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "alipaySdk");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private android.util.Pair<java.lang.String, java.lang.Boolean> a(java.lang.String str, java.lang.String str2, com.alipay.sdk.m.s.a aVar) {
        int i;
        com.alipay.sdk.m.u.h.f fVar;
        com.alipay.android.app.IRemoteServiceCallback iRemoteServiceCallback;
        android.app.Activity activity;
        int i2;
        java.lang.String a2;
        android.app.Activity activity2;
        android.app.Activity activity3;
        java.lang.String Pay;
        android.app.Activity activity4;
        android.content.Intent intent = new android.content.Intent();
        intent.setPackage(str2);
        intent.setAction(com.alipay.sdk.m.u.n.c(str2));
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("");
        sb.append(elapsedRealtime);
        sb.append("|");
        sb.append(str != null ? str.length() : 0);
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.R, sb.toString());
        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
        try {
            try {
                if (com.alipay.sdk.m.m.a.D().f()) {
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "stSrv", "skipped");
                } else {
                    android.content.ComponentName startService = this.a.getApplication().startService(intent);
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "stSrv", startService != null ? startService.getPackageName() : com.igexin.push.core.b.m);
                }
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.J, th);
                com.alipay.sdk.m.u.n.a("alipaySdk", com.alipay.sdk.m.l.b.n, this.a, this.f);
                return new android.util.Pair<>(j, java.lang.Boolean.TRUE);
            }
        } catch (java.lang.Throwable th2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.K, th2);
        }
        if (com.alipay.sdk.m.m.a.D().b()) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "bindFlg", com.umeng.analytics.pro.ay.c);
            i = 65;
        } else {
            i = 1;
        }
        com.alipay.sdk.m.u.h.f fVar2 = new com.alipay.sdk.m.u.h.f(this, null);
        if (!this.a.getApplicationContext().bindService(intent, fVar2, i)) {
            throw new java.lang.Throwable("bindService fail");
        }
        synchronized (this.c) {
            if (this.b == null) {
                try {
                    this.c.wait(com.alipay.sdk.m.m.a.D().k());
                } catch (java.lang.InterruptedException e2) {
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.L, e2);
                }
            }
        }
        com.alipay.android.app.IAlixPay iAlixPay = this.b;
        try {
            if (iAlixPay == null) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, "");
                com.alipay.sdk.m.u.n.a("alipaySdk", com.alipay.sdk.m.l.b.o, this.a, this.f);
                android.util.Pair<java.lang.String, java.lang.Boolean> pair = new android.util.Pair<>(j, java.lang.Boolean.TRUE);
                try {
                    this.a.getApplicationContext().unbindService(fVar2);
                } catch (java.lang.Throwable th3) {
                    com.alipay.sdk.m.u.e.a(th3);
                }
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + android.os.SystemClock.elapsedRealtime());
                com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                this.b = null;
                if (this.d && (activity4 = this.a) != null) {
                    activity4.setRequestedOrientation(0);
                    this.d = false;
                }
                return pair;
            }
            long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.S, "" + elapsedRealtime2);
            com.alipay.sdk.m.u.h.g gVar = this.e;
            if (gVar != null) {
                gVar.b();
            }
            if (this.a.getRequestedOrientation() == 0) {
                this.a.setRequestedOrientation(1);
                this.d = true;
            }
            try {
                i2 = iAlixPay.getVersion();
            } catch (java.lang.Throwable th4) {
                com.alipay.sdk.m.u.e.a(th4);
                i2 = 0;
            }
            iRemoteServiceCallback = new com.alipay.sdk.m.u.h.e(this, null);
            try {
                if (i2 >= 3) {
                    iAlixPay.registerCallback03(iRemoteServiceCallback, str, null);
                } else {
                    iAlixPay.registerCallback(iRemoteServiceCallback);
                }
                long elapsedRealtime3 = android.os.SystemClock.elapsedRealtime();
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                try {
                    sb2.append("");
                    sb2.append(elapsedRealtime3);
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.U, sb2.toString());
                    if (i2 >= 3) {
                        iAlixPay.r03(com.alipay.sdk.m.k.b.l, "bind_pay", null);
                    }
                    try {
                        if (i2 >= 2) {
                            java.util.Map a3 = com.alipay.sdk.m.s.a.a(aVar);
                            a3.put("ts_bind", java.lang.String.valueOf(elapsedRealtime));
                            a3.put("ts_bend", java.lang.String.valueOf(elapsedRealtime2));
                            a3.put("ts_pay", java.lang.String.valueOf(elapsedRealtime3));
                            Pay = iAlixPay.pay02(str, a3);
                        } else {
                            Pay = iAlixPay.Pay(str);
                        }
                        a2 = Pay;
                        fVar = fVar2;
                    } catch (java.lang.Throwable th5) {
                        com.alipay.sdk.m.s.a aVar2 = this.f;
                        if (aVar2 != null && !aVar2.f()) {
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.H, th5);
                            com.alipay.sdk.m.u.n.a("alipaySdk", com.alipay.sdk.m.l.b.p, this.a, this.f);
                            if (com.alipay.sdk.m.m.a.D().u()) {
                                android.util.Pair<java.lang.String, java.lang.Boolean> pair2 = new android.util.Pair<>(j, java.lang.Boolean.FALSE);
                                try {
                                    iAlixPay.unregisterCallback(iRemoteServiceCallback);
                                } catch (java.lang.Throwable th6) {
                                    com.alipay.sdk.m.u.e.a(th6);
                                }
                                try {
                                    this.a.getApplicationContext().unbindService(fVar2);
                                } catch (java.lang.Throwable th7) {
                                    com.alipay.sdk.m.u.e.a(th7);
                                }
                                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + android.os.SystemClock.elapsedRealtime());
                                com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                                this.b = null;
                                if (this.d && (activity2 = this.a) != null) {
                                    activity2.setRequestedOrientation(0);
                                    this.d = false;
                                }
                                return pair2;
                            }
                        }
                        fVar = fVar2;
                        try {
                            a2 = com.alipay.sdk.m.j.b.a();
                        } catch (java.lang.Throwable th8) {
                            th = th8;
                            try {
                                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, th, "in_bind");
                                android.util.Pair<java.lang.String, java.lang.Boolean> pair3 = new android.util.Pair<>(j, java.lang.Boolean.TRUE);
                                if (iRemoteServiceCallback != null) {
                                    try {
                                        iAlixPay.unregisterCallback(iRemoteServiceCallback);
                                    } catch (java.lang.Throwable th9) {
                                        com.alipay.sdk.m.u.e.a(th9);
                                    }
                                }
                                try {
                                    this.a.getApplicationContext().unbindService(fVar);
                                } catch (java.lang.Throwable th10) {
                                    com.alipay.sdk.m.u.e.a(th10);
                                }
                                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + android.os.SystemClock.elapsedRealtime());
                                com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                                this.b = null;
                                if (this.d && (activity = this.a) != null) {
                                    activity.setRequestedOrientation(0);
                                    this.d = false;
                                }
                                return pair3;
                            } finally {
                            }
                        }
                    }
                    try {
                        iAlixPay.unregisterCallback(iRemoteServiceCallback);
                    } catch (java.lang.Throwable th11) {
                        com.alipay.sdk.m.u.e.a(th11);
                    }
                    try {
                        this.a.getApplicationContext().unbindService(fVar);
                    } catch (java.lang.Throwable th12) {
                        com.alipay.sdk.m.u.e.a(th12);
                    }
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + android.os.SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    this.b = null;
                    if (this.d && (activity3 = this.a) != null) {
                        activity3.setRequestedOrientation(0);
                        this.d = false;
                    }
                    return new android.util.Pair<>(a2, java.lang.Boolean.FALSE);
                } catch (java.lang.Throwable th13) {
                    th = th13;
                    fVar = fVar2;
                }
            } catch (java.lang.Throwable th14) {
                th = th14;
                fVar = fVar2;
            }
        } catch (java.lang.Throwable th15) {
            th = th15;
            fVar = fVar2;
            iRemoteServiceCallback = null;
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, th, "in_bind");
            android.util.Pair<java.lang.String, java.lang.Boolean> pair32 = new android.util.Pair<>(j, java.lang.Boolean.TRUE);
            if (iRemoteServiceCallback != null) {
            }
            this.a.getApplicationContext().unbindService(fVar);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + android.os.SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
            this.b = null;
            if (this.d) {
                activity.setRequestedOrientation(0);
                this.d = false;
            }
            return pair32;
        }
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        java.lang.String a2 = com.alipay.sdk.m.u.n.a(32);
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPStart", a2 + "|" + elapsedRealtime);
        com.alipay.sdk.m.s.a.C0043a.a(this.f, a2);
        com.alipay.sdk.app.AlipayResultActivity.a.put(a2, new com.alipay.sdk.m.u.h.a(countDownLatch));
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("sourcePid", android.os.Binder.getCallingPid());
            jSONObject.put(com.alipay.sdk.m.l.b.d, str);
            jSONObject.put(com.vivo.push.PushClientConstants.TAG_PKG_NAME, this.a.getPackageName());
            jSONObject.put(com.umeng.analytics.pro.f.aC, a2);
            java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 2);
            android.net.Uri.Builder appendQueryParameter = new android.net.Uri.Builder().scheme("alipays").authority("platformapi").path(com.igexin.push.core.b.p).appendQueryParameter(com.anythink.expressad.videocommon.e.b.u, "20000125");
            appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
            try {
                java.util.HashMap<java.lang.String, java.lang.String> a3 = com.alipay.sdk.m.s.a.a(this.f);
                a3.put("ts_scheme", java.lang.String.valueOf(elapsedRealtime));
                appendQueryParameter.appendQueryParameter("mqpLoc", new org.json.JSONObject(a3).toString());
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPLocEx", th);
            }
            java.lang.String uri = appendQueryParameter.build().toString();
            android.content.Intent intent = new android.content.Intent();
            intent.setPackage(str2);
            intent.addFlags(268435456);
            intent.setData(android.net.Uri.parse(uri));
            android.app.Activity activity = this.a;
            com.alipay.sdk.m.s.a aVar = this.f;
            com.alipay.sdk.m.k.a.a(activity, aVar, str, aVar.d);
            this.a.startActivity(intent);
            com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay scheme waiting " + uri);
            countDownLatch.await();
            java.lang.String str4 = this.h;
            try {
                str3 = com.alipay.sdk.m.u.l.a(this.f, str4).get(com.alipay.sdk.m.u.l.a);
                if (str3 == null) {
                    str3 = com.igexin.push.core.b.m;
                }
            } catch (java.lang.Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPStatEx", th2);
                str3 = "unknown";
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPDone-" + str3);
            if (!android.text.TextUtils.isEmpty(str4)) {
                return str4;
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPEmpty");
            return k;
        } catch (java.lang.InterruptedException e2) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPWaiting", e2);
            com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
            return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
        } catch (java.lang.Throwable th3) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPEx", th3);
            return k;
        }
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2, android.content.pm.PackageInfo packageInfo) {
        java.lang.String str3 = packageInfo != null ? packageInfo.versionName : "";
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay payInvokeAct");
        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.X, str2 + "|" + str3);
        android.app.Activity activity = this.a;
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(activity, aVar, str, aVar.d);
        return b(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String a(java.lang.String str, java.lang.String str2, android.content.pm.PackageInfo packageInfo, com.alipay.sdk.m.u.n.c cVar) {
        java.lang.String str3;
        com.alipay.sdk.m.s.a aVar;
        android.app.Activity activity;
        boolean z = false;
        int i = packageInfo != null ? packageInfo.versionCode : 0;
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay bind or scheme");
        com.alipay.sdk.m.s.a aVar2 = this.f;
        if (aVar2 != null && !android.text.TextUtils.isEmpty(aVar2.g)) {
            z = this.f.g.toLowerCase().contains(com.alipay.sdk.m.k.b.n);
        }
        if (!z && com.alipay.sdk.m.u.n.i()) {
            if (cVar != null) {
                try {
                    if (com.alipay.sdk.m.m.a.D().B()) {
                        a(cVar);
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindSkipByModel");
        } else {
            if (z || !com.alipay.sdk.m.u.n.d(this.f, str2)) {
                if (cVar != null) {
                    try {
                        if (!com.alipay.sdk.m.m.a.D().p()) {
                            a(cVar);
                        }
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                android.util.Pair<java.lang.String, java.lang.Boolean> a2 = a(str, str2, this.f);
                str3 = (java.lang.String) a2.first;
                try {
                    if (j.equals(str3) && ((java.lang.Boolean) a2.second).booleanValue() && com.alipay.sdk.m.m.a.D().n()) {
                        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindRetry");
                        str3 = (java.lang.String) a(str, str2, this.f).first;
                    }
                } catch (java.lang.Throwable th) {
                    com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindRetryEx", th);
                }
                com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay bind result: " + str3);
                android.app.Activity activity2 = this.a;
                com.alipay.sdk.m.s.a aVar3 = this.f;
                com.alipay.sdk.m.k.a.a(activity2, aVar3, str, aVar3.d);
                if (j.equals(str3)) {
                    return str3;
                }
                if (!com.alipay.sdk.m.u.n.b.equals(str2)) {
                    com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPNotStartByAlipay", str2 + "|" + i);
                    return str3;
                }
                boolean q = com.alipay.sdk.m.m.a.D().q();
                if (i >= 460 && q && !z && (activity = this.a) != null && b(str2, activity, this.f)) {
                    return a(str, str2, packageInfo);
                }
                if (!com.alipay.sdk.m.m.a.D().i()) {
                    com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPNotStartByConfig", "");
                    return str3;
                }
                if (i <= 125) {
                    com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPNotStartByPkg", str2 + "|" + i);
                    return str3;
                }
                if (!com.alipay.sdk.m.m.a.D().m() || (aVar = this.f) == null || com.alipay.sdk.m.u.n.b(aVar.f) == 0) {
                    android.app.Activity activity3 = this.a;
                    return (activity3 == null || !a(str2, activity3, this.f)) ? k : a(str, str2);
                }
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSPNotStartByUsr");
                return str3;
            }
            if (cVar != null) {
                try {
                    if (com.alipay.sdk.m.m.a.D().B()) {
                        a(cVar);
                    }
                } catch (java.lang.Throwable unused3) {
                }
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindSkipByL");
        }
        str3 = j;
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "pay bind result: " + str3);
        android.app.Activity activity22 = this.a;
        com.alipay.sdk.m.s.a aVar32 = this.f;
        com.alipay.sdk.m.k.a.a(activity22, aVar32, str, aVar32.d);
        if (j.equals(str3)) {
        }
    }

    private void a(com.alipay.sdk.m.u.n.c cVar) throws java.lang.InterruptedException {
        android.content.pm.PackageInfo packageInfo;
        if (cVar == null || (packageInfo = cVar.a) == null) {
            return;
        }
        java.lang.String str = packageInfo.packageName;
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.a.startActivity(intent);
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.g0, th);
        }
        java.lang.Thread.sleep(200L);
    }

    public static boolean a(java.lang.String str, android.content.Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN", (android.net.Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPDetectFail");
            return false;
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPDetectFail", th);
            return false;
        }
    }

    private java.lang.String b(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject;
        java.lang.Object obj = new java.lang.Object();
        java.lang.String a2 = com.alipay.sdk.m.u.n.a(32);
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAStart", a2 + "|" + elapsedRealtime);
        com.alipay.sdk.m.s.a.C0043a.a(this.f, a2);
        com.alipay.sdk.m.u.h.b bVar = new com.alipay.sdk.m.u.h.b(obj);
        com.alipay.sdk.app.APayEntranceActivity.h.put(a2, bVar);
        try {
            java.util.HashMap<java.lang.String, java.lang.String> a3 = com.alipay.sdk.m.s.a.a(this.f);
            a3.put("ts_intent", java.lang.String.valueOf(elapsedRealtime));
            jSONObject = new org.json.JSONObject(a3);
        } catch (java.lang.Throwable th) {
            try {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSALocEx", th);
                jSONObject = null;
            } catch (java.lang.InterruptedException e2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAWaiting", e2);
                com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
                return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
            } catch (java.lang.Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEx", th2);
                com.alipay.sdk.m.u.n.a("alipaySdk", com.alipay.sdk.m.l.b.q, this.a, this.f);
                return k;
            }
        }
        android.content.Intent intent = new android.content.Intent(this.a, (java.lang.Class<?>) com.alipay.sdk.app.APayEntranceActivity.class);
        intent.putExtra(com.alipay.sdk.app.APayEntranceActivity.d, str);
        intent.putExtra(com.alipay.sdk.app.APayEntranceActivity.e, str2);
        intent.putExtra(com.alipay.sdk.app.APayEntranceActivity.f, a2);
        if (jSONObject != null) {
            intent.putExtra(com.alipay.sdk.app.APayEntranceActivity.g, jSONObject.toString());
        }
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.alipay.sdk.m.u.h.c(bVar), com.alipay.sdk.m.m.a.D().k());
        android.app.Activity activity = this.a;
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(activity, aVar, str, aVar.d);
        if (com.alipay.sdk.m.m.a.D().z()) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.alipay.sdk.m.u.h.d(intent, obj));
        } else {
            try {
                android.app.Activity activity2 = this.a;
                if (activity2 != null) {
                    activity2.startActivity(intent);
                } else {
                    com.alipay.sdk.m.k.a.b(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                    android.content.Context a4 = this.f.a();
                    if (a4 != null) {
                        a4.startActivity(intent);
                    }
                }
            } catch (java.lang.Throwable th3) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th3);
                throw th3;
            }
        }
        synchronized (obj) {
            obj.wait();
        }
        java.lang.String str3 = this.i;
        java.lang.String str4 = "unknown";
        try {
            java.lang.String str5 = com.alipay.sdk.m.u.l.a(this.f, str3).get(com.alipay.sdk.m.u.l.a);
            str4 = str5 == null ? com.igexin.push.core.b.m : str5;
        } catch (java.lang.Throwable th4) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAStatEx", th4);
        }
        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSADone-" + str4);
        if (!android.text.TextUtils.isEmpty(str3)) {
            return str3;
        }
        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEmpty");
        return k;
    }

    public static boolean b(java.lang.String str, android.content.Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail");
            return false;
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail", th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #3 {all -> 0x00ad, blocks: (B:12:0x0023, B:14:0x002b, B:17:0x0033, B:20:0x003c, B:23:0x0042, B:26:0x004b, B:27:0x0054, B:30:0x0059, B:32:0x0063, B:73:0x0050), top: B:11:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(java.lang.String str, boolean z) {
        com.alipay.sdk.m.u.n.c cVar;
        java.lang.String c2;
        java.lang.String str2 = "";
        try {
            java.util.List<com.alipay.sdk.m.m.a.b> l = com.alipay.sdk.m.m.a.D().l();
            if (!com.alipay.sdk.m.m.a.D().h || l == null) {
                l = com.alipay.sdk.m.j.a.d;
            }
            cVar = com.alipay.sdk.m.u.n.a(this.f, this.a, l);
        } catch (java.lang.Throwable th) {
            th = th;
            cVar = null;
        }
        if (cVar != null) {
            try {
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.N, th);
                if (z) {
                }
            }
            if (cVar.a(this.f) || cVar.a() || com.alipay.sdk.m.u.n.a(cVar.a)) {
                return j;
            }
            android.content.pm.PackageInfo packageInfo = cVar.a;
            if (packageInfo != null && !com.alipay.sdk.m.u.n.b.equals(packageInfo.packageName)) {
                str2 = cVar.a.packageName;
                android.content.pm.PackageInfo packageInfo2 = cVar.a;
                r1 = packageInfo2 != null ? packageInfo2 : null;
                c2 = com.alipay.sdk.m.m.a.D().c();
                if (c2 != null) {
                    if (c2.length() > 0) {
                        try {
                            org.json.JSONObject optJSONObject = new org.json.JSONObject(c2).optJSONObject(str2);
                            if (optJSONObject != null && optJSONObject.length() > 0) {
                                java.util.Iterator<java.lang.String> keys = optJSONObject.keys();
                                while (keys.hasNext()) {
                                    java.lang.String next = keys.next();
                                    int parseInt = java.lang.Integer.parseInt(next);
                                    if (r1 != null && r1.versionCode >= parseInt) {
                                        try {
                                            boolean a2 = com.alipay.sdk.m.m.a.D().a(this.a, java.lang.Integer.parseInt(optJSONObject.getString(next)));
                                            this.g = a2;
                                            if (a2) {
                                                break;
                                            }
                                        } catch (java.lang.Exception unused) {
                                            continue;
                                        }
                                    }
                                }
                            }
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                }
                return ((!z || this.g) && !com.alipay.sdk.m.u.n.b(this.f) && b(str2, this.a, this.f)) ? a(str, str2, r1) : a(str, str2, r1, cVar);
            }
            str2 = com.alipay.sdk.m.u.n.b();
            android.content.pm.PackageInfo packageInfo22 = cVar.a;
            if (packageInfo22 != null) {
            }
            c2 = com.alipay.sdk.m.m.a.D().c();
            if (c2 != null) {
            }
            if (z) {
            }
        }
        return j;
    }

    public void a() {
        this.a = null;
        this.e = null;
    }
}
