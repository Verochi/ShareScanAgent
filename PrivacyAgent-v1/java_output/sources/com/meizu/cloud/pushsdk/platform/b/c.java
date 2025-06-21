package com.meizu.cloud.pushsdk.platform.b;

/* loaded from: classes23.dex */
public abstract class c<T extends com.meizu.cloud.pushsdk.platform.message.BasicPushStatus> {
    protected final android.content.Context a;
    protected java.lang.String b;
    protected java.lang.String c;
    protected java.lang.String d;
    protected final com.meizu.cloud.pushsdk.platform.a.a e;
    private java.util.concurrent.ScheduledExecutorService h;
    protected boolean f = true;
    protected boolean g = true;
    private java.lang.String i = null;

    /* renamed from: com.meizu.cloud.pushsdk.platform.b.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.meizu.cloud.pushsdk.platform.b.c.this.n();
        }
    }

    public c(android.content.Context context, java.lang.String str, java.lang.String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this.h = scheduledExecutorService;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.e = aVar;
    }

    private boolean a(int i) {
        return i >= 110000 && i <= 200000;
    }

    private boolean b(T t) {
        int intValue = java.lang.Integer.valueOf(t.getCode()).intValue();
        return (intValue > 200 && intValue < 600) || (intValue > 1000 && intValue < 2000) || intValue == 0;
    }

    private boolean h() {
        return this.g && !this.a.getPackageName().equals(this.i);
    }

    public java.lang.String a(android.content.Context context, java.lang.String str) {
        java.lang.String str2 = null;
        if (!android.text.TextUtils.isEmpty(str)) {
            java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new android.content.Intent(str), 0);
            if (queryIntentServices != null) {
                java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentServices.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    android.content.pm.ResolveInfo next = it.next();
                    if (com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME.equals(next.serviceInfo.packageName)) {
                        android.content.pm.ServiceInfo serviceInfo = next.serviceInfo;
                        this.i = serviceInfo.packageName;
                        str2 = serviceInfo.name;
                        break;
                    }
                }
                if (android.text.TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                    this.i = queryIntentServices.get(0).serviceInfo.packageName;
                    str2 = queryIntentServices.get(0).serviceInfo.name;
                }
            }
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("Strategy", "current process packageName " + this.i);
        return str2;
    }

    public void a(android.content.Intent intent) {
        try {
            intent.setPackage(this.i);
            intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION);
            this.a.startService(intent);
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "start RemoteService error " + e.getMessage());
        }
    }

    public abstract void a(T t);

    public void a(boolean z) {
        this.f = z;
    }

    public abstract boolean a();

    public abstract T b();

    public void b(java.lang.String str) {
        this.b = str;
    }

    public abstract android.content.Intent c();

    public void c(java.lang.String str) {
        this.c = str;
    }

    public void d(java.lang.String str) {
        this.d = str;
    }

    public android.content.Intent[] d() {
        return null;
    }

    public abstract T e();

    public abstract T f();

    public abstract int g();

    public boolean k() {
        return this.g && this.f && !android.text.TextUtils.isEmpty(a(this.a, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION));
    }

    public boolean l() {
        return 2 == g() || 32 == g();
    }

    public boolean m() {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.h;
        if (scheduledExecutorService == null) {
            return n();
        }
        scheduledExecutorService.execute(new com.meizu.cloud.pushsdk.platform.b.c.AnonymousClass1());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n() {
        T t;
        java.lang.String str;
        if (a()) {
            if (k()) {
                com.meizu.cloud.pushinternal.DebugLogger.i("Strategy", "send message to remote service");
                if (l()) {
                    t = null;
                } else {
                    t = f();
                    if (t != null) {
                        com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "local response " + t);
                        a((com.meizu.cloud.pushsdk.platform.b.c<T>) t);
                    }
                }
                android.content.Intent c = c();
                if (c != null) {
                    a(c);
                }
                android.content.Intent[] d = d();
                if (d != null) {
                    com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "send sendRpcRequests length " + d.length);
                    for (android.content.Intent intent : d) {
                        a(intent);
                    }
                }
                com.meizu.cloud.pushsdk.a.a(this.a);
            } else {
                t = e();
                com.meizu.cloud.pushinternal.DebugLogger.i("Strategy", "real response status " + t);
                if (t != null) {
                    if (l() && com.igexin.sdk.PushConsts.SEND_MESSAGE_ERROR.equals(t.getCode())) {
                        return true;
                    }
                    if (!h()) {
                        java.lang.String code = t.getCode();
                        if (android.text.TextUtils.isEmpty(code)) {
                            code = "0";
                        }
                        if (com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(t.getCode())) {
                            a((com.meizu.cloud.pushsdk.platform.b.c<T>) t);
                        }
                        int intValue = java.lang.Integer.valueOf(code).intValue();
                        str = a(intValue) ? "service error so notify pushManager invoker code=" + intValue + " message " + t.getMessage() : "response all request in local app";
                    }
                    com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", str);
                }
            }
            if (t != null) {
                return true;
            }
            com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "current status code " + t.getCode());
            return true ^ b((com.meizu.cloud.pushsdk.platform.b.c<T>) t);
        }
        com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "Missing required parameters");
        t = b();
        a((com.meizu.cloud.pushsdk.platform.b.c<T>) t);
        if (t != null) {
        }
    }
}
