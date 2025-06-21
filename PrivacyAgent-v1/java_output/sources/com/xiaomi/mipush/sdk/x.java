package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
class x {
    int a = 0;

    /* renamed from: a, reason: collision with other field name */
    java.lang.String f60a = "";

    public boolean equals(java.lang.Object obj) {
        if (obj == null || !(obj instanceof com.xiaomi.mipush.sdk.x)) {
            return false;
        }
        com.xiaomi.mipush.sdk.x xVar = (com.xiaomi.mipush.sdk.x) obj;
        return !android.text.TextUtils.isEmpty(xVar.f60a) && xVar.f60a.equals(this.f60a);
    }
}
