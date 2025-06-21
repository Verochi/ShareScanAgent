package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class as {
    private android.content.Context a;

    public as(android.content.Context context) {
        this.a = context;
    }

    private static boolean a(java.lang.String str, android.content.Context context, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String b = com.amap.api.mapcore.util.dl.b(context);
        try {
            java.io.File file = new java.io.File(b + str2 + str + ".dat");
            if (file.exists()) {
                if (!com.amap.api.mapcore.util.bj.b(file)) {
                    return false;
                }
            }
            try {
                com.amap.api.mapcore.util.bj.a(b + str2);
                com.amap.api.mapcore.util.bj.b(str, context);
                return true;
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return false;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private boolean b(com.amap.api.mapcore.util.al alVar) {
        if (alVar != null) {
            java.lang.String pinyin = alVar.getPinyin();
            boolean a = a(pinyin, this.a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            boolean z = true;
            boolean z2 = a(pinyin, this.a, "map/") || a;
            if (!b(com.amap.api.mapcore.util.bj.b(alVar.getUrl()), this.a, "map/") && !z2) {
                z = false;
            }
            if (z) {
                alVar.i();
                return z;
            }
            alVar.h();
        }
        return false;
    }

    private static boolean b(java.lang.String str, android.content.Context context, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String a = com.amap.api.mapcore.util.dl.a(context);
        try {
            java.io.File file = new java.io.File(a + str2 + str);
            if (file.exists()) {
                if (!com.amap.api.mapcore.util.bj.b(file)) {
                    return false;
                }
            }
            try {
                com.amap.api.mapcore.util.bj.a(a + str2);
                com.amap.api.mapcore.util.bj.b(str, context);
                return true;
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return false;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final void a(com.amap.api.mapcore.util.al alVar) {
        b(alVar);
    }
}
