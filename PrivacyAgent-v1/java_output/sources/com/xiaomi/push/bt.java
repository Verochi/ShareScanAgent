package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class bt {
    java.lang.String a;
    int b;

    private bt(java.lang.String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static com.xiaomi.push.bt a(java.lang.String str, int i) {
        int lastIndexOf = str.lastIndexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        if (lastIndexOf != -1) {
            java.lang.String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = java.lang.Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (java.lang.NumberFormatException unused) {
            }
            str = substring;
        }
        return new com.xiaomi.push.bt(str, i);
    }

    public static java.net.InetSocketAddress b(java.lang.String str, int i) {
        com.xiaomi.push.bt a = a(str, i);
        return new java.net.InetSocketAddress(a.a, a.b);
    }

    public final java.lang.String toString() {
        if (this.b <= 0) {
            return this.a;
        }
        return this.a + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.b;
    }
}
