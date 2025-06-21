package com.meizu.cloud.pushsdk.platform.b;

/* loaded from: classes23.dex */
public class a extends com.meizu.cloud.pushsdk.platform.b.c {
    private int[] h;
    private int i;
    private java.lang.String j;

    public a(android.content.Context context, java.lang.String str, java.lang.String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f = com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportSetDrawableSmallIcon();
    }

    public a(android.content.Context context, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, null, null, null, scheduledExecutorService);
        this.g = z;
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus basicPushStatus) {
    }

    public void a(java.lang.String str) {
        this.j = str;
    }

    public void a(int... iArr) {
        this.h = iArr;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        int i = this.i;
        if (i == 0) {
            return true;
        }
        int[] iArr = this.h;
        if (iArr == null || iArr.length <= 0 || i != 1) {
            return i == 2 && !android.text.TextUtils.isEmpty(this.j);
        }
        return true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public com.meizu.cloud.pushsdk.platform.message.BasicPushStatus b() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public android.content.Intent c() {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        int i = this.i;
        if (i == 2) {
            intent.putExtra("strategy_params", this.j);
            return intent;
        }
        if (i == 1) {
            return null;
        }
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public android.content.Intent[] d() {
        int[] iArr = this.h;
        if (iArr == null) {
            return null;
        }
        android.content.Intent[] intentArr = new android.content.Intent[iArr.length];
        for (int i = 0; i < this.h.length; i++) {
            com.meizu.cloud.pushinternal.DebugLogger.i("Strategy", "send notifyId " + this.h[i] + " to PushManagerService");
            android.content.Intent intent = new android.content.Intent();
            intent.putExtra("strategy_package_name", this.a.getPackageName());
            intent.putExtra("strategy_type", g());
            intent.putExtra("strategy_child_type", this.i);
            intent.putExtra("strategy_params", "" + this.h[i]);
            intentArr[i] = intent;
        }
        return intentArr;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public com.meizu.cloud.pushsdk.platform.message.BasicPushStatus e() {
        int i = this.i;
        if (i == 0) {
            if (!com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "android 6.0 blow so cancel all by context");
                com.meizu.cloud.pushsdk.notification.c.b.a(this.a);
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.a, this.d);
            return null;
        }
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.a, this.d, this.j);
            return null;
        }
        int[] iArr = this.h;
        if (iArr == null) {
            return null;
        }
        for (int i2 : iArr) {
            com.meizu.cloud.pushinternal.DebugLogger.e("Strategy", "clear notifyId " + i2);
            com.meizu.cloud.pushsdk.notification.c.b.a(this.a, this.d, i2);
        }
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public com.meizu.cloud.pushsdk.platform.message.BasicPushStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 64;
    }
}
