package com.alimm.tanx.ui.image.glide.signature;

/* loaded from: classes.dex */
public final class EmptySignature implements com.alimm.tanx.ui.image.glide.load.Key {
    private static final com.alimm.tanx.ui.image.glide.signature.EmptySignature EMPTY_KEY = new com.alimm.tanx.ui.image.glide.signature.EmptySignature();

    private EmptySignature() {
    }

    public static com.alimm.tanx.ui.image.glide.signature.EmptySignature obtain() {
        return EMPTY_KEY;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) throws java.io.UnsupportedEncodingException {
    }
}
