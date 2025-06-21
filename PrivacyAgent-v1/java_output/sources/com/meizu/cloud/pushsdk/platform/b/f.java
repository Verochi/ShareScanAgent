package com.meizu.cloud.pushsdk.platform.b;

/* loaded from: classes23.dex */
public class f extends com.meizu.cloud.pushsdk.platform.b.c<com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus> {
    private java.lang.String h;
    private int i;
    private boolean j;
    private final java.util.Map<java.lang.String, java.lang.Boolean> k;

    public f(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public f(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public f(android.content.Context context, java.lang.String str, java.lang.String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.i = 0;
        this.k = new java.util.HashMap();
    }

    public f(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.h = str3;
    }

    private com.meizu.cloud.pushsdk.c.a.c<java.lang.String> b(com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
        boolean z;
        boolean r;
        boolean p;
        int i = this.i;
        if (i != 0) {
            if (i == 1) {
                pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
                if (r() != this.j || t()) {
                    f(true);
                    d(this.j);
                    return this.e.a(this.b, this.c, this.h, this.i, this.j);
                }
                p = p();
            } else {
                if (i != 2) {
                    if (i == 3) {
                        pushSwitchStatus.setMessage("SWITCH_ALL");
                        if (p() != this.j || r() != this.j || t()) {
                            f(true);
                            e(this.j);
                            return this.e.a(this.b, this.c, this.h, this.j);
                        }
                        p = this.j;
                    }
                    return null;
                }
                pushSwitchStatus.setMessage("CHECK_PUSH");
                if (!q() || !s() || t()) {
                    f(true);
                    return this.e.c(this.b, this.c, this.h);
                }
                z = p();
                pushSwitchStatus.setSwitchNotificationMessage(z);
                r = r();
            }
            pushSwitchStatus.setSwitchNotificationMessage(p);
            r = this.j;
        } else {
            pushSwitchStatus.setMessage("SWITCH_NOTIFICATION");
            if (p() != this.j || t()) {
                f(true);
                c(this.j);
                return this.e.a(this.b, this.c, this.h, this.i, this.j);
            }
            z = this.j;
            pushSwitchStatus.setSwitchNotificationMessage(z);
            r = r();
        }
        pushSwitchStatus.setSwitchThroughMessage(r);
        return null;
    }

    private void c(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
    }

    private void d(boolean z) {
        com.meizu.cloud.pushsdk.util.b.b(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
    }

    private void e(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
        com.meizu.cloud.pushsdk.util.b.b(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
    }

    private void f(boolean z) {
        this.k.put(this.d + "_" + this.i, java.lang.Boolean.valueOf(z));
    }

    private void o() {
        int i = this.i;
        if (i == 0 || i == 1) {
            com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a(this.a, i, this.j, this.d);
        } else {
            if (i != 3) {
                return;
            }
            com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a(this.a, 0, this.j, this.d);
            com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a(this.a, 1, this.j, this.d);
        }
    }

    private boolean p() {
        return com.meizu.cloud.pushsdk.util.b.e(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean q() {
        return com.meizu.cloud.pushsdk.util.b.f(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean r() {
        return com.meizu.cloud.pushsdk.util.b.h(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean s() {
        return com.meizu.cloud.pushsdk.util.b.i(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean t() {
        java.lang.Boolean bool = this.k.get(this.d + "_" + this.i);
        boolean z = bool == null || bool.booleanValue();
        com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "isSyncPushStatus " + this.d + " switch type->" + this.i + " flag->" + z);
        return z;
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
        com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), pushSwitchStatus);
    }

    public void a(java.lang.String str) {
        this.h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (android.text.TextUtils.isEmpty(this.b) || android.text.TextUtils.isEmpty(this.c) || android.text.TextUtils.isEmpty(this.h)) ? false : true;
    }

    public void b(boolean z) {
        this.j = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public android.content.Intent c() {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra("app_key", this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID, this.h);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        intent.putExtra("strategy_params", this.j ? "1" : "0");
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 16;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus b() {
        java.lang.String str;
        com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus = new com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus();
        pushSwitchStatus.setCode("20001");
        if (android.text.TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else {
            if (!android.text.TextUtils.isEmpty(this.c)) {
                if (android.text.TextUtils.isEmpty(this.h)) {
                    str = "pushId not empty";
                }
                return pushSwitchStatus;
            }
            str = "appKey not empty";
        }
        pushSwitchStatus.setMessage(str);
        return pushSwitchStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus e() {
        com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus = new com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus();
        pushSwitchStatus.setPushId(this.h);
        pushSwitchStatus.setCode(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE);
        com.meizu.cloud.pushsdk.c.a.c<java.lang.String> b = b(pushSwitchStatus);
        if (b != null) {
            if (b.b()) {
                com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus2 = new com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus(b.a());
                com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                if (com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(pushSwitchStatus.getCode())) {
                    f(false);
                    com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "update local switch preference");
                    pushSwitchStatus.setSwitchNotificationMessage(pushSwitchStatus2.isSwitchNotificationMessage());
                    pushSwitchStatus.setSwitchThroughMessage(pushSwitchStatus2.isSwitchThroughMessage());
                    c(pushSwitchStatus2.isSwitchNotificationMessage());
                    d(pushSwitchStatus2.isSwitchThroughMessage());
                }
            } else {
                com.meizu.cloud.pushsdk.c.b.a c = b.c();
                if (c.a() != null) {
                    com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                }
                pushSwitchStatus.setCode(java.lang.String.valueOf(c.b()));
                pushSwitchStatus.setMessage(c.c());
                com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "pushSwitchStatus " + pushSwitchStatus);
            }
        }
        com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "enableRpc " + this.g + " isSupportRemoteInvoke " + this.f);
        if (this.g && !this.f) {
            o();
        }
        return pushSwitchStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus f() {
        int i = this.i;
        if (i == 0) {
            c(this.j);
            return null;
        }
        if (i == 1) {
            d(this.j);
            return null;
        }
        if (i != 2 && i != 3) {
            return null;
        }
        e(this.j);
        return null;
    }
}
