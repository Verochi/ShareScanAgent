package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class fc extends com.amap.api.mapcore.util.hi {
    @Override // com.amap.api.mapcore.util.hi
    public java.lang.String getIPV6URL() {
        if (android.text.TextUtils.isEmpty(getURL())) {
            return getURL();
        }
        java.lang.String url = getURL();
        android.net.Uri parse = android.net.Uri.parse(url);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return url;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
    }

    @Override // com.amap.api.mapcore.util.hi
    public boolean isSupportIPV6() {
        return true;
    }
}
