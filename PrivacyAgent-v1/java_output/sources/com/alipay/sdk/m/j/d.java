package com.alipay.sdk.m.j;

/* loaded from: classes.dex */
public class d {
    public static final int a = 1010;
    public static com.alipay.sdk.m.j.d.a b;

    public interface a {
        void a(boolean z, org.json.JSONObject jSONObject, java.lang.String str);
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, int i, int i2, android.content.Intent intent) {
        if (i != 1010 || intent == null) {
            return false;
        }
        com.alipay.sdk.m.j.d.a aVar2 = b;
        if (aVar2 == null) {
            return true;
        }
        b = null;
        if (i2 == -1) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.x0, intent.toUri(1));
            aVar2.a(true, com.alipay.sdk.m.u.n.a(intent), com.baidu.mobads.sdk.internal.bz.k);
        } else if (i2 != 0) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.w0, "" + i2);
        } else {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.v0, intent.toUri(1));
            aVar2.a(false, null, "CANCELED");
        }
        return true;
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, android.app.Activity activity, int i, java.lang.String str, java.lang.String str2, com.alipay.sdk.m.j.d.a aVar2) {
        try {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.u0);
            activity.startActivityForResult(new android.content.Intent(str2, android.net.Uri.parse(str)), i);
            b = aVar2;
            return true;
        } catch (java.lang.Throwable th) {
            aVar2.a(false, null, "UNKNOWN_ERROR");
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.y0, th);
            return false;
        }
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, android.content.Context context) {
        return com.alipay.sdk.m.u.n.a(aVar, context, (java.util.List<com.alipay.sdk.m.m.a.b>) java.util.Collections.singletonList(new com.alipay.sdk.m.m.a.b("com.taobao.taobao", 0, "")), false);
    }
}
