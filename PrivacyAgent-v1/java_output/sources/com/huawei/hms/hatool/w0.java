package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class w0 {
    public static com.huawei.hms.hatool.w0 c = new com.huawei.hms.hatool.w0();
    public boolean a = false;
    public android.content.Context b = com.huawei.hms.hatool.b.i();

    public static com.huawei.hms.hatool.w0 b() {
        return c;
    }

    @android.annotation.TargetApi(24)
    public boolean a() {
        boolean z;
        if (!this.a) {
            android.content.Context context = this.b;
            if (context == null) {
                return false;
            }
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                android.os.UserManager userManager = (android.os.UserManager) context.getSystemService(com.umeng.analytics.pro.ay.m);
                if (userManager != null) {
                    z = userManager.isUserUnlocked();
                } else {
                    this.a = false;
                }
            } else {
                z = true;
            }
            this.a = z;
        }
        return this.a;
    }
}
