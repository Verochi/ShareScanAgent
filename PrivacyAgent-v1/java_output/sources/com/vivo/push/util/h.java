package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class h implements com.vivo.push.util.BaseNotifyDataAdapter {
    private static int e;
    private static int f;
    private android.content.res.Resources a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;

    private int a(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            java.lang.String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                str = split[0];
            }
            try {
                for (int parseInt = java.lang.Integer.parseInt(str); parseInt > 0; parseInt--) {
                    java.lang.String str3 = "vivo_push_ard" + parseInt + str2;
                    com.vivo.push.util.p.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(java.lang.String.valueOf(str3)));
                    int identifier = this.a.getIdentifier(str3, com.anythink.expressad.foundation.h.i.c, this.b);
                    if (identifier > 0) {
                        com.vivo.push.util.p.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(java.lang.String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (java.lang.Exception e2) {
                com.vivo.push.util.p.a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }

    private static boolean a(int i) {
        return (i == -1 || i == 0) ? false : true;
    }

    private static boolean a(java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        com.vivo.push.util.p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        if (a(e)) {
            return e;
        }
        java.lang.String str = this.d;
        int a = !a(str) ? -1 : a(str, "_notifyicon");
        e = a;
        if (a(a)) {
            return e;
        }
        for (java.lang.String str2 = this.c; !android.text.TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.a.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", com.anythink.expressad.foundation.h.i.c, this.b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.a.getIdentifier("vivo_push_notifyicon", com.anythink.expressad.foundation.h.i.c, this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        if (a(f)) {
            return f;
        }
        java.lang.String str = this.d;
        int a = !a(str) ? -1 : a(str, "_icon");
        f = a;
        if (a(a)) {
            return f;
        }
        for (java.lang.String str2 = this.c; !android.text.TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.a.getIdentifier("vivo_push_rom" + str2 + "_icon", com.anythink.expressad.foundation.h.i.c, this.b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.a.getIdentifier("vivo_push_icon", com.anythink.expressad.foundation.h.i.c, this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(com.vivo.push.model.InsideNotificationItem insideNotificationItem) {
        return 2;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(android.content.Context context) {
        this.b = context.getPackageName();
        this.a = context.getResources();
        this.c = com.vivo.push.util.j.a();
        this.d = android.os.Build.VERSION.RELEASE;
    }
}
