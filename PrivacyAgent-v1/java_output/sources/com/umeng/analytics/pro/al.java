package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class al {
    private java.lang.String a;
    private boolean e = false;
    private int d = -1;
    private int c = -1;
    private int b = -1;

    public al(java.lang.String str) {
        this.a = str;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.a.contains(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                this.d = java.lang.Integer.valueOf(this.a).intValue();
                this.e = false;
                return;
            }
            java.lang.String[] split = this.a.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                this.b = java.lang.Integer.valueOf(split[0]).intValue();
                int intValue = java.lang.Integer.valueOf(split[1]).intValue();
                this.c = intValue;
                if (this.b < 1) {
                    this.b = 1;
                }
                if (intValue > 24) {
                    this.c = 24;
                }
            }
            this.e = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public boolean a(int i) {
        int i2;
        if (this.e) {
            int i3 = this.b;
            if (i3 != -1 && (i2 = this.c) != -1 && i >= i3 && i <= i2) {
                return true;
            }
        } else {
            int i4 = this.d;
            if (i4 != -1 && i == i4) {
                return true;
            }
        }
        return false;
    }
}
