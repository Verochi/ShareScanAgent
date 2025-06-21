package com.anythink.core.basead.a;

/* loaded from: classes12.dex */
public final class a {
    public static final java.lang.String a = "play.google.com";
    public static final java.lang.String b = "market.android.com";
    public static final java.lang.String c = "details?";
    public static final java.lang.String d = "market";
    public static final java.lang.String e = "market://";

    /* renamed from: com.anythink.core.basead.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.widget.Toast.makeText(this.a, "Detect that the App Market is not installed and cannot be opened through the App Market.", 1).show();
        }
    }

    public static com.anythink.core.common.f.ba a(android.content.Context context, java.lang.String str) {
        com.anythink.core.common.f.ba baVar = new com.anythink.core.common.f.ba();
        baVar.n = !str.startsWith(com.alipay.sdk.m.l.a.q);
        baVar.o = str;
        if (d(str)) {
            baVar.o = str;
            boolean equals = android.text.TextUtils.equals(com.anythink.core.d.b.a(context).b(com.anythink.core.common.b.o.a().o()).t(), "1");
            if (a(context, str, false, equals)) {
                baVar.m = true;
                if (equals) {
                    baVar.l = 3;
                } else {
                    baVar.l = 4;
                }
            } else if (a(context, str, false, false)) {
                baVar.m = true;
                baVar.l = 4;
            }
            return baVar;
        }
        if (!str.startsWith(com.alipay.sdk.m.l.a.q)) {
            baVar.o = str;
            if (a(context, str, false, false)) {
                baVar.m = true;
                baVar.l = 5;
            }
            return baVar;
        }
        if (b(str)) {
            java.lang.String f = f(str);
            baVar.n = true;
            baVar.o = f;
            if (a(context, f, false, true)) {
                baVar.m = true;
                baVar.l = 1;
            } else if (a(context, f, false, false)) {
                baVar.m = true;
                baVar.l = 2;
            }
        }
        return baVar;
    }

    public static com.anythink.core.common.f.ba a(java.lang.String str) {
        com.anythink.core.common.f.ba baVar = new com.anythink.core.common.f.ba();
        baVar.l = 8;
        baVar.n = false;
        baVar.m = true;
        baVar.o = str;
        try {
            if (android.net.Uri.parse(str).getScheme().equals(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
                android.content.Intent parseUri = android.content.Intent.parseUri(str, 1);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                java.lang.String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                if (!android.text.TextUtils.isEmpty(stringExtra) && stringExtra.startsWith(com.alipay.sdk.m.l.a.q)) {
                    baVar.l = 10;
                    baVar.o = stringExtra;
                    return baVar;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        if (d(str)) {
            java.lang.String e2 = e(str);
            baVar.l = 9;
            baVar.o = e2;
        }
        return baVar;
    }

    public static boolean a(android.content.Context context, java.lang.String str, boolean z) {
        if (b(str)) {
            return a(context, f(str), z, true);
        }
        java.lang.String scheme = android.net.Uri.parse(str).getScheme();
        if (scheme == null || scheme.startsWith(com.alipay.sdk.m.l.a.q)) {
            return false;
        }
        return a(context, str, z, scheme.startsWith("market") && android.text.TextUtils.equals(com.anythink.core.d.b.a(context).b(com.anythink.core.common.b.o.a().o()).t(), "1"));
    }

    private static boolean a(android.content.Context context, java.lang.String str, boolean z, boolean z2) {
        android.content.Intent intent;
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            if (parse.getScheme().equals(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
                intent = android.content.Intent.parseUri(str, 1);
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
            } else {
                intent = new android.content.Intent("android.intent.action.VIEW", parse);
                intent.setData(parse);
            }
            if (z2 && android.text.TextUtils.isEmpty(intent.getPackage())) {
                intent.setPackage("com.android.vending");
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (java.lang.Throwable unused) {
            if (!z) {
                return false;
            }
            com.anythink.core.common.b.o.a().b(new com.anythink.core.basead.a.a.AnonymousClass1(context));
            return false;
        }
    }

    public static boolean b(java.lang.String str) {
        android.net.Uri parse;
        try {
            if (!android.text.TextUtils.isEmpty(str) && (parse = android.net.Uri.parse(str)) != null && parse.getHost() != null) {
                if (parse.getHost().equals("play.google.com")) {
                    return true;
                }
                return parse.getHost().equals("market.android.com");
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    private static void c(java.lang.String str) {
        com.anythink.core.common.o.m.a(str);
    }

    private static boolean d(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            return android.net.Uri.parse(str).getScheme().equals("market");
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static java.lang.String e(java.lang.String str) {
        try {
            return "https://play.google.com/store/apps/details?id=".concat(java.lang.String.valueOf(str.replace("market://details?id=", "")));
        } catch (java.lang.Throwable unused) {
            return str;
        }
    }

    private static java.lang.String f(java.lang.String str) {
        try {
            return "market://".concat(java.lang.String.valueOf(str.substring(str.indexOf(c))));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
