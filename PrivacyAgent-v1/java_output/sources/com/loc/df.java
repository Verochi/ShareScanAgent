package com.loc;

/* loaded from: classes23.dex */
public final class df {
    public static boolean a(byte[] bArr) {
        java.lang.String str;
        if (bArr == null) {
            return false;
        }
        try {
            com.loc.em emVar = new com.loc.em();
            emVar.b.put("Content-Type", com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
            emVar.b.put("aps_c_src", android.util.Base64.encodeToString(com.loc.em.a().getBytes(), 2));
            emVar.b.put("aps_c_key", android.util.Base64.encodeToString(com.loc.em.b().getBytes(), 2));
            emVar.d = bArr;
            if (com.loc.cw.a) {
                str = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            } else {
                str = (com.loc.cw.b ? "https://" : "http://") + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            }
            emVar.a = str;
            com.loc.en a = com.loc.ea.b().a(emVar);
            byte[] bArr2 = (a == null || a.a != 200) ? null : a.c;
            if (bArr2 != null) {
                return com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(new java.lang.String(bArr2, java.nio.charset.StandardCharsets.UTF_8));
            }
            return false;
        } catch (java.lang.Exception e) {
            com.loc.el.a(e);
            return false;
        }
    }
}
