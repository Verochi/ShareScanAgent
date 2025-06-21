package com.bytedance.pangle.g;

/* loaded from: classes12.dex */
public final class e {
    public static boolean a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.bytedance.pangle.g.o a = com.bytedance.pangle.util.i.a() ? com.bytedance.pangle.g.d.a(str) : com.bytedance.pangle.g.a.a(str);
            android.content.pm.Signature[] signatureArr = a != null ? a.b : null;
            byte[] decode = android.util.Base64.decode(com.bytedance.pangle.Zeus.getPlugin(str2).mSignature, 0);
            if (decode == null || decode.length == 0) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(java.lang.String.valueOf(str)));
                return false;
            }
            int i = 0;
            for (android.content.pm.Signature signature : signatureArr) {
                i += signature.toByteArray().length;
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (android.content.pm.Signature signature2 : signatureArr) {
                java.lang.System.arraycopy(signature2.toByteArray(), 0, bArr, i2, signature2.toByteArray().length);
                i2 += signature2.toByteArray().length;
            }
            boolean a2 = com.bytedance.pangle.g.o.a(bArr, decode);
            if (!a2) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(java.lang.String.valueOf(str)));
            }
            return a2;
        } catch (com.bytedance.pangle.g.q e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(java.lang.String.valueOf(str)), e);
            return false;
        }
    }
}
