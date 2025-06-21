package com.bumptech.glide.signature;

/* loaded from: classes.dex */
public final class AndroidResourceSignature implements com.bumptech.glide.load.Key {
    private final com.bumptech.glide.load.Key applicationVersion;
    private final int nightMode;

    private AndroidResourceSignature(int i, com.bumptech.glide.load.Key key) {
        this.nightMode = i;
        this.applicationVersion = key;
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.Key obtain(@androidx.annotation.NonNull android.content.Context context) {
        return new com.bumptech.glide.signature.AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, com.bumptech.glide.signature.ApplicationVersionSignature.obtain(context));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.bumptech.glide.signature.AndroidResourceSignature)) {
            return false;
        }
        com.bumptech.glide.signature.AndroidResourceSignature androidResourceSignature = (com.bumptech.glide.signature.AndroidResourceSignature) obj;
        return this.nightMode == androidResourceSignature.nightMode && this.applicationVersion.equals(androidResourceSignature.applicationVersion);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return com.bumptech.glide.util.Util.hashCode(this.applicationVersion, this.nightMode);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        this.applicationVersion.updateDiskCacheKey(messageDigest);
        messageDigest.update(java.nio.ByteBuffer.allocate(4).putInt(this.nightMode).array());
    }
}
