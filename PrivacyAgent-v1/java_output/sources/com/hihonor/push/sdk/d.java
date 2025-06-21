package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class d {
    public final java.lang.String a;
    public final int b;

    public d(java.lang.String str) {
        this.a = str;
        this.b = a(str);
    }

    public static int a(java.lang.Object... objArr) {
        return java.util.Arrays.hashCode(objArr);
    }

    public static com.hihonor.push.sdk.d a(java.lang.String str) {
        return new com.hihonor.push.sdk.d(str);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.hihonor.push.sdk.d.class != obj.getClass()) {
            return false;
        }
        return android.text.TextUtils.equals(this.a, ((com.hihonor.push.sdk.d) obj).a);
    }

    public final int hashCode() {
        return this.b;
    }
}
