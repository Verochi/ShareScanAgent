package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public final class FrameworkMediaCrypto implements com.google.android.exoplayer2.drm.ExoMediaCrypto {
    public static final boolean WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC;
    public final boolean forceAllowInsecureDecoderComponents;
    public final byte[] sessionId;
    public final java.util.UUID uuid;

    static {
        boolean z;
        if ("Amazon".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER)) {
            java.lang.String str = com.google.android.exoplayer2.util.Util.MODEL;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z = true;
                WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC = z;
            }
        }
        z = false;
        WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC = z;
    }

    public FrameworkMediaCrypto(java.util.UUID uuid, byte[] bArr, boolean z) {
        this.uuid = uuid;
        this.sessionId = bArr;
        this.forceAllowInsecureDecoderComponents = z;
    }
}
