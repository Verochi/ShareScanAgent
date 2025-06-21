package com.meizu.cloud.pushsdk.platform.b;

/* loaded from: classes23.dex */
public class d extends com.meizu.cloud.pushsdk.platform.b.c<com.meizu.cloud.pushsdk.platform.message.SubAliasStatus> {
    private java.lang.String h;
    private int i;
    private java.lang.String j;
    private final java.util.Map<java.lang.String, java.lang.Boolean> k;

    public d(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public d(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public d(android.content.Context context, java.lang.String str, java.lang.String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.k = new java.util.HashMap();
    }

    public d(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.h = str3;
    }

    private void b(boolean z) {
        this.k.put(this.d + "_" + this.i, java.lang.Boolean.valueOf(z));
    }

    private void f(java.lang.String str) {
        com.meizu.cloud.pushsdk.util.b.h(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), str);
    }

    private java.lang.String o() {
        return com.meizu.cloud.pushsdk.util.b.g(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean p() {
        java.lang.Boolean bool = this.k.get(this.d + "_" + this.i);
        return bool == null || bool.booleanValue();
    }

    private boolean q() {
        return !this.f && com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME.equals(this.d);
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus) {
        com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), subAliasStatus);
    }

    public void a(java.lang.String str) {
        this.j = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (android.text.TextUtils.isEmpty(this.b) || android.text.TextUtils.isEmpty(this.c) || android.text.TextUtils.isEmpty(this.h)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public android.content.Intent c() {
        if (this.i == 2) {
            return null;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra("app_key", this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID, this.h);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        intent.putExtra("strategy_params", this.j);
        return intent;
    }

    public void e(java.lang.String str) {
        this.h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 8;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.SubAliasStatus b() {
        java.lang.String str;
        com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus = new com.meizu.cloud.pushsdk.platform.message.SubAliasStatus();
        subAliasStatus.setCode("20001");
        if (android.text.TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else {
            if (!android.text.TextUtils.isEmpty(this.c)) {
                if (android.text.TextUtils.isEmpty(this.h)) {
                    str = "pushId not empty";
                }
                return subAliasStatus;
            }
            str = "appKey not empty";
        }
        subAliasStatus.setMessage(str);
        return subAliasStatus;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0090  */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.meizu.cloud.pushsdk.platform.message.SubAliasStatus e() {
        com.meizu.cloud.pushsdk.c.a.c c;
        com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus = new com.meizu.cloud.pushsdk.platform.message.SubAliasStatus();
        subAliasStatus.setPushId(this.h);
        java.lang.String str = "";
        subAliasStatus.setMessage("");
        int i = this.i;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    subAliasStatus.setAlias(o());
                    subAliasStatus.setCode(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE);
                }
            } else {
                if (!android.text.TextUtils.isEmpty(o()) || p()) {
                    b(true);
                    if (q()) {
                        f("");
                    }
                    c = this.e.d(this.b, this.c, this.h, this.j);
                    if (c != null) {
                        if (c.b()) {
                            subAliasStatus = new com.meizu.cloud.pushsdk.platform.message.SubAliasStatus((java.lang.String) c.a());
                            com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "network subAliasStatus " + subAliasStatus);
                            if (com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(subAliasStatus.getCode())) {
                                b(false);
                            }
                        } else {
                            com.meizu.cloud.pushsdk.c.b.a c2 = c.c();
                            if (c2.a() != null) {
                                com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                            }
                            subAliasStatus.setCode(java.lang.String.valueOf(c2.b()));
                            subAliasStatus.setMessage(c2.c());
                            com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "subAliasStatus " + subAliasStatus);
                        }
                    }
                    return subAliasStatus;
                }
                subAliasStatus.setCode(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE);
                subAliasStatus.setAlias(str);
            }
        } else {
            if (!this.j.equals(o()) || p()) {
                b(true);
                if (q()) {
                    f(this.j);
                }
                c = this.e.c(this.b, this.c, this.h, this.j);
                if (c != null) {
                }
                return subAliasStatus;
            }
            subAliasStatus.setCode(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE);
            str = this.j;
            subAliasStatus.setAlias(str);
        }
        c = null;
        if (c != null) {
        }
        return subAliasStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.SubAliasStatus f() {
        if (this.i != 2) {
            return null;
        }
        com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus = new com.meizu.cloud.pushsdk.platform.message.SubAliasStatus();
        subAliasStatus.setCode(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE);
        subAliasStatus.setPushId(this.h);
        subAliasStatus.setAlias(o());
        subAliasStatus.setMessage("check alias success");
        return subAliasStatus;
    }
}
