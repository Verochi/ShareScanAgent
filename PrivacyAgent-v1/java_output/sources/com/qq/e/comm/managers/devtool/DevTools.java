package com.qq.e.comm.managers.devtool;

/* loaded from: classes19.dex */
public class DevTools {
    private java.lang.String a;

    public java.lang.String getDemoGameUrl() {
        java.lang.String str = this.a;
        this.a = null;
        return str;
    }

    public void testDemoGame(android.content.Context context, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.a = str;
        }
    }
}
