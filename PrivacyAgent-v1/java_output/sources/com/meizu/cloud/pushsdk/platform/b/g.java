package com.meizu.cloud.pushsdk.platform.b;

/* loaded from: classes23.dex */
public class g extends com.meizu.cloud.pushsdk.platform.b.c<com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus> {
    public g(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
    }

    public g(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public g(android.content.Context context, java.lang.String str, java.lang.String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus) {
        com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), unRegisterStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (android.text.TextUtils.isEmpty(this.b) || android.text.TextUtils.isEmpty(this.c)) ? false : true;
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
        return 32;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus b() {
        java.lang.String str;
        com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus = new com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus();
        unRegisterStatus.setCode("20001");
        if (!android.text.TextUtils.isEmpty(this.b)) {
            str = android.text.TextUtils.isEmpty(this.c) ? "appKey not empty" : "appId not empty";
            return unRegisterStatus;
        }
        unRegisterStatus.setMessage(str);
        return unRegisterStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus e() {
        com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus = new com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus();
        if (android.text.TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.b.a(this.a, this.d))) {
            unRegisterStatus.setCode(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE);
            unRegisterStatus.setMessage("already unRegister PushId,don't unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
        } else {
            com.meizu.cloud.pushsdk.c.a.c b = this.e.b(this.b, this.c, com.meizu.cloud.pushsdk.b.c.a(this.a));
            if (b.b()) {
                unRegisterStatus = new com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus((java.lang.String) b.a());
                com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "network unRegisterStatus " + unRegisterStatus);
                if (com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(unRegisterStatus.getCode())) {
                    com.meizu.cloud.pushsdk.util.b.g(this.a, "", this.d);
                }
            } else {
                com.meizu.cloud.pushsdk.c.b.a c = b.c();
                if (c.a() != null) {
                    com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                }
                unRegisterStatus.setCode(java.lang.String.valueOf(c.b()));
                unRegisterStatus.setMessage(c.c());
                com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "unRegisterStatus " + unRegisterStatus);
            }
        }
        return unRegisterStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus f() {
        return null;
    }
}
