package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
class SafeKeyGenerator {
    private final com.alimm.tanx.ui.image.glide.util.LruCache<com.alimm.tanx.ui.image.glide.load.Key, java.lang.String> loadIdToSafeHash = new com.alimm.tanx.ui.image.glide.util.LruCache<>(1000);

    public java.lang.String getSafeKey(com.alimm.tanx.ui.image.glide.load.Key key) {
        java.lang.String str;
        synchronized (this.loadIdToSafeHash) {
            str = this.loadIdToSafeHash.get(key);
        }
        if (str == null) {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
                key.updateDiskCacheKey(messageDigest);
                str = com.alimm.tanx.ui.image.glide.util.Util.sha256BytesToHex(messageDigest.digest());
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (java.security.NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            synchronized (this.loadIdToSafeHash) {
                this.loadIdToSafeHash.put(key, str);
            }
        }
        return str;
    }
}
