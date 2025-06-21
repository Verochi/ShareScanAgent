package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class bp extends com.amap.api.col.s.dd {
    @Override // com.amap.api.col.s.dd
    public java.lang.String a() {
        if (android.text.TextUtils.isEmpty(h())) {
            return h();
        }
        java.lang.String h = h();
        android.net.Uri parse = android.net.Uri.parse(h);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return h;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
    }
}
