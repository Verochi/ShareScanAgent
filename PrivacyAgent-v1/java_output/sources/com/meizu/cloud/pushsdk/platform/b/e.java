package com.meizu.cloud.pushsdk.platform.b;

/* loaded from: classes23.dex */
public class e extends com.meizu.cloud.pushsdk.platform.b.c<com.meizu.cloud.pushsdk.platform.message.SubTagsStatus> {
    private java.lang.String h;
    private int i;
    private java.lang.String j;

    public e(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public e(android.content.Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public e(android.content.Context context, java.lang.String str, java.lang.String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.i = 3;
    }

    public e(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.h = str3;
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus) {
        com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a(this.a, !android.text.TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), subTagsStatus);
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
        return 4;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.SubTagsStatus b() {
        java.lang.String str;
        com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus = new com.meizu.cloud.pushsdk.platform.message.SubTagsStatus();
        subTagsStatus.setCode("20001");
        if (android.text.TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else {
            if (!android.text.TextUtils.isEmpty(this.c)) {
                if (android.text.TextUtils.isEmpty(this.h)) {
                    str = "pushId not empty";
                }
                return subTagsStatus;
            }
            str = "appKey not empty";
        }
        subTagsStatus.setMessage(str);
        return subTagsStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.SubTagsStatus e() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus = new com.meizu.cloud.pushsdk.platform.message.SubTagsStatus();
        int i = this.i;
        com.meizu.cloud.pushsdk.c.a.c e = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : this.e.e(this.b, this.c, this.h) : this.e.d(this.b, this.c, this.h) : this.e.b(this.b, this.c, this.h, this.j) : this.e.a(this.b, this.c, this.h, this.j);
        if (e == null) {
            com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "network anResponse is null");
            return null;
        }
        if (e.b()) {
            subTagsStatus = new com.meizu.cloud.pushsdk.platform.message.SubTagsStatus((java.lang.String) e.a());
            sb = new java.lang.StringBuilder();
            str = "network subTagsStatus ";
        } else {
            com.meizu.cloud.pushsdk.c.b.a c = e.c();
            if (c.a() != null) {
                com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
            }
            subTagsStatus.setCode(java.lang.String.valueOf(c.b()));
            subTagsStatus.setMessage(c.c());
            sb = new java.lang.StringBuilder();
            str = "subTagsStatus ";
        }
        sb.append(str);
        sb.append(subTagsStatus);
        com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", sb.toString());
        return subTagsStatus;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.SubTagsStatus f() {
        return null;
    }
}
