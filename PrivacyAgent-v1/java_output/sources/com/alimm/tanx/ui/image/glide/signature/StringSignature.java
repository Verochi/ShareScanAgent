package com.alimm.tanx.ui.image.glide.signature;

/* loaded from: classes.dex */
public class StringSignature implements com.alimm.tanx.ui.image.glide.load.Key {
    private final java.lang.String signature;

    public StringSignature(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("Signature cannot be null!");
        }
        this.signature = str;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.alimm.tanx.ui.image.glide.signature.StringSignature.class != obj.getClass()) {
            return false;
        }
        return this.signature.equals(((com.alimm.tanx.ui.image.glide.signature.StringSignature) obj).signature);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("StringSignature{signature='");
        tanxu_do2.append(this.signature);
        tanxu_do2.append('\'');
        tanxu_do2.append('}');
        return tanxu_do2.toString();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) throws java.io.UnsupportedEncodingException {
        messageDigest.update(this.signature.getBytes("UTF-8"));
    }
}
