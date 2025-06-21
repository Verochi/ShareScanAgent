package com.meizu.cloud.pushsdk.platform.b;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.platform.b.c<com.meizu.cloud.pushsdk.platform.message.RegisterStatus> {
    private android.os.Handler h;
    private java.util.concurrent.ScheduledExecutorService i;
    private int j;

    /* renamed from: com.meizu.cloud.pushsdk.platform.b.b$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 0) {
                com.meizu.cloud.pushsdk.platform.b.b.this.m();
            }
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.platform.b.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.meizu.cloud.pushsdk.b.c.a(com.meizu.cloud.pushsdk.platform.b.b.this.a);
            com.meizu.cloud.pushsdk.platform.b.b.this.h.sendEmptyMessage(0);
        }
    }

    public b(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
        this.i = (java.util.concurrent.ScheduledExecutorService) com.meizu.cloud.pushsdk.d.b.a.b.a();
        this.h = new com.meizu.cloud.pushsdk.platform.b.b.AnonymousClass1(context.getMainLooper());
    }

    public b(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public b(android.content.Context context, java.lang.String str, java.lang.String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.j = 0;
    }

    private boolean a(java.lang.String str, java.lang.String str2, int i) {
        return android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || !str2.startsWith(str) || java.lang.System.currentTimeMillis() / 1000 > ((long) i);
    }

    public void a(long j) {
        this.i.schedule(new com.meizu.cloud.pushsdk.platform.b.b.AnonymousClass2(), j, java.util.concurrent.TimeUnit.SECONDS);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
        com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "isBrandMeizu " + com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(this.a));
        return (android.text.TextUtils.isEmpty(this.b) || android.text.TextUtils.isEmpty(this.c)) ? false : true;
    }

    public boolean a(java.lang.String str, int i) {
        java.lang.String a = com.meizu.cloud.pushsdk.b.c.a(this.a);
        boolean a2 = a(a, str, i);
        return a2 ? a(a, com.meizu.cloud.pushsdk.platform.a.a(str), i) : a2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public android.content.Intent c() {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra("app_key", this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.RegisterStatus b() {
        java.lang.String str;
        com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus = new com.meizu.cloud.pushsdk.platform.message.RegisterStatus();
        registerStatus.setCode("20001");
        if (!android.text.TextUtils.isEmpty(this.b)) {
            str = android.text.TextUtils.isEmpty(this.c) ? "appKey not empty" : "appId not empty";
            return registerStatus;
        }
        registerStatus.setMessage(str);
        return registerStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.RegisterStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.RegisterStatus e() {
        com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus = new com.meizu.cloud.pushsdk.platform.message.RegisterStatus();
        java.lang.String a = com.meizu.cloud.pushsdk.util.b.a(this.a, this.d);
        int b = com.meizu.cloud.pushsdk.util.b.b(this.a, this.d);
        if (a(a, b)) {
            com.meizu.cloud.pushsdk.util.b.g(this.a, "", this.d);
            java.lang.String a2 = com.meizu.cloud.pushsdk.b.c.a(this.a);
            if (!android.text.TextUtils.isEmpty(a2) || this.j >= 3) {
                this.j = 0;
                com.meizu.cloud.pushsdk.c.a.c a3 = this.e.a(this.b, this.c, a2);
                if (a3.b()) {
                    registerStatus = new com.meizu.cloud.pushsdk.platform.message.RegisterStatus((java.lang.String) a3.a());
                    com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "registerStatus " + registerStatus);
                    if (!android.text.TextUtils.isEmpty(registerStatus.getPushId())) {
                        com.meizu.cloud.pushsdk.util.b.g(this.a, registerStatus.getPushId(), this.d);
                        com.meizu.cloud.pushsdk.util.b.a(this.a, (int) ((java.lang.System.currentTimeMillis() / 1000) + registerStatus.getExpireTime()), this.d);
                    }
                } else {
                    com.meizu.cloud.pushsdk.c.b.a c = a3.c();
                    if (c.a() != null) {
                        com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                    }
                    registerStatus.setCode(java.lang.String.valueOf(c.b()));
                    registerStatus.setMessage(c.c());
                    com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "registerStatus " + registerStatus);
                }
            } else {
                com.meizu.cloud.pushinternal.DebugLogger.i("Strategy", "after " + (this.j * 10) + " seconds start register");
                a((long) (this.j * 10));
                this.j = this.j + 1;
                registerStatus.setCode(com.igexin.sdk.PushConsts.SEND_MESSAGE_ERROR);
                registerStatus.setMessage("deviceId is empty");
            }
        } else {
            registerStatus.setCode(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE);
            registerStatus.setMessage("already register PushId,don't register frequently");
            registerStatus.setPushId(a);
            registerStatus.setExpireTime((int) (b - (java.lang.System.currentTimeMillis() / 1000)));
        }
        return registerStatus;
    }
}
