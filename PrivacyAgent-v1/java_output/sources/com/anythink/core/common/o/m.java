package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class m {
    public static void a(android.content.Context context, java.lang.String str) {
        try {
            com.anythink.core.basead.ui.web.WebLandPageActivity.a(context, str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
            intent.addFlags(268468224);
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            if (f != null) {
                f.startActivity(intent);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
