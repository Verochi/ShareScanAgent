package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class jd {

    public static class a {
        private final java.lang.StringBuilder a;
        private final java.lang.String b;
        private final java.lang.String c;

        public a() {
            this(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, ",");
        }

        public a(java.lang.String str, java.lang.String str2) {
            this.a = new java.lang.StringBuilder();
            this.b = str;
            this.c = str2;
        }

        public final com.xiaomi.push.jd.a a(java.lang.String str, java.lang.Object obj) {
            if (!android.text.TextUtils.isEmpty(str)) {
                if (this.a.length() > 0) {
                    this.a.append(this.c);
                }
                java.lang.StringBuilder sb = this.a;
                sb.append(str);
                sb.append(this.b);
                sb.append(obj);
            }
            return this;
        }

        public final java.lang.String toString() {
            return this.a.toString();
        }
    }

    public static int a(java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static boolean a() {
        return java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread();
    }

    public static boolean a(android.content.Context context) {
        android.os.PowerManager powerManager = (android.os.PowerManager) context.getSystemService("power");
        return powerManager != null && powerManager.isInteractive();
    }

    public static boolean a(java.util.Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
