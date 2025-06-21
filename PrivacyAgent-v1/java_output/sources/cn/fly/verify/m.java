package cn.fly.verify;

/* loaded from: classes.dex */
public class m {
    public static android.util.SparseArray<cn.fly.verify.l> a() {
        if (!new java.io.File(cn.fly.verify.ax.g().getFilesDir(), ".preverfy_xhs").exists()) {
            return null;
        }
        long h = cn.fly.verify.aq.h();
        if (java.lang.System.currentTimeMillis() > h) {
            cn.fly.verify.aq.a((java.util.HashMap) null);
            if (h > 0) {
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "file config expire");
            }
            return null;
        }
        android.util.SparseArray<cn.fly.verify.l> sparseArray = new android.util.SparseArray<>();
        cn.fly.verify.l a = a(1);
        if (a != null) {
            sparseArray.append(1, a);
        }
        cn.fly.verify.l a2 = a(2);
        if (a2 != null) {
            sparseArray.append(2, a2);
        }
        cn.fly.verify.l a3 = a(3);
        if (a3 != null) {
            sparseArray.append(3, a3);
        }
        cn.fly.verify.l a4 = a(4);
        if (a4 != null) {
            sparseArray.append(4, a4);
        }
        return sparseArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static cn.fly.verify.l a(int i) {
        int parseInt;
        java.lang.Integer valueOf;
        java.lang.String str;
        java.util.HashMap b = cn.fly.verify.aq.b();
        if (b == null) {
            return null;
        }
        java.lang.String str2 = (java.lang.String) b.get("appId_" + i);
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        java.lang.String str3 = (java.lang.String) b.get("secret_" + i);
        if (android.text.TextUtils.isEmpty(str3)) {
            return null;
        }
        if (b.containsKey("multiFlag_" + i)) {
            try {
                parseInt = java.lang.Integer.parseInt(java.lang.String.valueOf(b.get("multiFlag_" + i)));
            } catch (java.lang.Throwable unused) {
            }
            if (b.containsKey("channel_" + i)) {
                try {
                    valueOf = java.lang.Integer.valueOf(java.lang.Integer.parseInt(java.lang.String.valueOf(b.get("channel_" + i))));
                } catch (java.lang.Throwable unused2) {
                }
                if (b.containsKey("channelAccount_" + i)) {
                    try {
                        str = (java.lang.String) b.get("channelAccount_" + i);
                    } catch (java.lang.Throwable unused3) {
                    }
                    return new cn.fly.verify.l(i, str2, str3, false, parseInt, valueOf, str);
                }
                str = null;
                return new cn.fly.verify.l(i, str2, str3, false, parseInt, valueOf, str);
            }
            valueOf = null;
            if (b.containsKey("channelAccount_" + i)) {
            }
            str = null;
            return new cn.fly.verify.l(i, str2, str3, false, parseInt, valueOf, str);
        }
        parseInt = 0;
        if (b.containsKey("channel_" + i)) {
        }
        valueOf = null;
        if (b.containsKey("channelAccount_" + i)) {
        }
        str = null;
        return new cn.fly.verify.l(i, str2, str3, false, parseInt, valueOf, str);
    }

    public static void a(android.util.SparseArray<cn.fly.verify.l> sparseArray) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            cn.fly.verify.l valueAt = sparseArray.valueAt(i);
            hashMap.put("appId_" + valueAt.a, valueAt.b);
            hashMap.put("secret_" + valueAt.a, valueAt.c);
            hashMap.put("multiFlag_" + valueAt.a, java.lang.String.valueOf(valueAt.d()));
            if (valueAt.e() != null) {
                hashMap.put("channel_" + valueAt.a, java.lang.String.valueOf(valueAt.e()));
            }
            if (!android.text.TextUtils.isEmpty(valueAt.f())) {
                hashMap.put("channelAccount_" + valueAt.a, java.lang.String.valueOf(valueAt.f()));
            }
        }
        cn.fly.verify.aq.a(hashMap);
        cn.fly.verify.aq.a(java.lang.System.currentTimeMillis() + 600000);
    }

    public static boolean b() {
        long h = cn.fly.verify.aq.h();
        boolean j = cn.fly.verify.aq.j();
        if (!j || java.lang.System.currentTimeMillis() <= h) {
            return j;
        }
        cn.fly.verify.aq.b(false);
        return false;
    }
}
