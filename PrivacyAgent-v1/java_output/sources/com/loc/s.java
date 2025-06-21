package com.loc;

/* loaded from: classes23.dex */
public abstract class s extends com.loc.bu {
    @Override // com.loc.bu
    public java.lang.String c() {
        android.net.Uri.Builder buildUpon;
        java.lang.String str;
        if (android.text.TextUtils.isEmpty(b())) {
            return b();
        }
        java.lang.String b = b();
        android.net.Uri parse = android.net.Uri.parse(b);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return b;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            buildUpon = parse.buildUpon();
            str = "dualstack-arestapi.amap.com";
        } else {
            buildUpon = parse.buildUpon();
            str = "dualstack-" + parse.getAuthority();
        }
        return buildUpon.authority(str).build().toString();
    }
}
