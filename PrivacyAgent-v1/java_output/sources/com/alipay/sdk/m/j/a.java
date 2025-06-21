package com.alipay.sdk.m.j;

/* loaded from: classes.dex */
public class a {
    public static java.lang.String a = "";
    public static final com.alipay.sdk.m.m.a.b b;
    public static final com.alipay.sdk.m.m.a.b c;
    public static java.util.List<com.alipay.sdk.m.m.a.b> d;

    static {
        com.alipay.sdk.m.m.a.b bVar = new com.alipay.sdk.m.m.a.b(com.alipay.sdk.m.u.n.b, 73, com.alipay.sdk.m.l.a.k);
        b = bVar;
        c = new com.alipay.sdk.m.m.a.b(com.alipay.sdk.app.PayResultActivity.d, 40, "e6b1bdcb890370f2f2419fe06d0fdf7628ad0083d52da1ecfe991164711bbf9297e75353de96f1740695d07610567b1240549af9cbd87d06919ac31c859ad37ab6907c311b4756e1e208775989a4f691bff4bbbc58174d2a96b1d0d970a05114d7ee57dfc33b1bafaf6e0d820e838427018b6435f903df04ba7fd34d73f843df9434b164e0220baabb10c8978c3f4c6b7da79d8220a968356d15090dea07df9606f665cbec14d218dd3d691cce2866a58840971b6a57b76af88b1a65fdffd2c080281a6ab20be5879e0330eb7ff70871ce684e7174ada5dc3159c461375a0796b17ce7beca83cf34f65976d237aee993db48d34a4e344f4d8b7e99119168bdd7");
        d = java.util.Collections.singletonList(bVar);
    }

    public static java.lang.String a() {
        return a;
    }

    public static void a(java.lang.String str) {
        a = str;
        str.hashCode();
        if (str.equals("hk")) {
            d = java.util.Collections.singletonList(c);
        } else {
            d = java.util.Collections.singletonList(b);
        }
    }

    public static boolean b() {
        return android.text.TextUtils.isEmpty(a) || android.text.TextUtils.equals(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION, a);
    }
}
