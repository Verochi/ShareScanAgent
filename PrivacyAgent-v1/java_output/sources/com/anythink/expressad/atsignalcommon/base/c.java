package com.anythink.expressad.atsignalcommon.base;

/* loaded from: classes12.dex */
public final class c implements com.anythink.expressad.atsignalcommon.base.a {
    @Override // com.anythink.expressad.atsignalcommon.base.a
    public final boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String scheme = android.net.Uri.parse(str).getScheme();
        if (android.text.TextUtils.isEmpty(scheme)) {
            return false;
        }
        scheme.equals(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        return false;
    }
}
