package com.efs.sdk.base.processor.action;

/* loaded from: classes22.dex */
public interface ILogEncryptAction {
    byte[] decrypt(java.lang.String str, byte[] bArr);

    byte[] encrypt(java.lang.String str, byte[] bArr);

    int getDeVal();
}
