package com.alimm.tanx.ui.image.glide.load;

/* loaded from: classes.dex */
public interface Key {
    public static final java.lang.String STRING_CHARSET_NAME = "UTF-8";

    boolean equals(java.lang.Object obj);

    int hashCode();

    void updateDiskCacheKey(java.security.MessageDigest messageDigest) throws java.io.UnsupportedEncodingException;
}
