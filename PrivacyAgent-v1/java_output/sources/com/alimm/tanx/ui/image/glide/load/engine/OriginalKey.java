package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
class OriginalKey implements com.alimm.tanx.ui.image.glide.load.Key {
    private final java.lang.String id;
    private final com.alimm.tanx.ui.image.glide.load.Key signature;

    public OriginalKey(java.lang.String str, com.alimm.tanx.ui.image.glide.load.Key key) {
        this.id = str;
        this.signature = key;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.alimm.tanx.ui.image.glide.load.engine.OriginalKey.class != obj.getClass()) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.load.engine.OriginalKey originalKey = (com.alimm.tanx.ui.image.glide.load.engine.OriginalKey) obj;
        return this.id.equals(originalKey.id) && this.signature.equals(originalKey.signature);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode() + (this.id.hashCode() * 31);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) throws java.io.UnsupportedEncodingException {
        messageDigest.update(this.id.getBytes("UTF-8"));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
