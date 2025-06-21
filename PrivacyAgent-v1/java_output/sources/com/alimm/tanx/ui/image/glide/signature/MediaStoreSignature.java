package com.alimm.tanx.ui.image.glide.signature;

/* loaded from: classes.dex */
public class MediaStoreSignature implements com.alimm.tanx.ui.image.glide.load.Key {
    private final long dateModified;
    private final java.lang.String mimeType;
    private final int orientation;

    public MediaStoreSignature(java.lang.String str, long j, int i) {
        this.mimeType = str;
        this.dateModified = j;
        this.orientation = i;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.alimm.tanx.ui.image.glide.signature.MediaStoreSignature.class != obj.getClass()) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.signature.MediaStoreSignature mediaStoreSignature = (com.alimm.tanx.ui.image.glide.signature.MediaStoreSignature) obj;
        if (this.dateModified != mediaStoreSignature.dateModified || this.orientation != mediaStoreSignature.orientation) {
            return false;
        }
        java.lang.String str = this.mimeType;
        java.lang.String str2 = mediaStoreSignature.mimeType;
        return str == null ? str2 == null : str.equals(str2);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        java.lang.String str = this.mimeType;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.dateModified;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.orientation;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) throws java.io.UnsupportedEncodingException {
        messageDigest.update(java.nio.ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest.update(this.mimeType.getBytes("UTF-8"));
    }
}
