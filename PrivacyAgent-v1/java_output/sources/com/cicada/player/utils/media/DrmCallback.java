package com.cicada.player.utils.media;

/* loaded from: classes22.dex */
public interface DrmCallback {
    byte[] requestKey(java.lang.String str, byte[] bArr);

    byte[] requestProvision(java.lang.String str, byte[] bArr);
}
