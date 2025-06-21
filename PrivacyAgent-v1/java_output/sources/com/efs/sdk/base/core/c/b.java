package com.efs.sdk.base.core.c;

/* loaded from: classes22.dex */
public final class b implements com.efs.sdk.base.processor.action.ILogEncryptAction {
    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] decrypt(java.lang.String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.core.util.secure.a.a(bArr, str);
        } catch (java.lang.Exception e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "aes decrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] encrypt(java.lang.String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.core.util.secure.a.b(bArr, str);
        } catch (java.lang.Exception e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "aes encrypt error", e);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final int getDeVal() {
        return 2;
    }
}
