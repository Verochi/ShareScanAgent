package com.bumptech.glide.load;

/* loaded from: classes.dex */
public interface Key {
    public static final java.nio.charset.Charset CHARSET = java.nio.charset.Charset.forName("UTF-8");
    public static final java.lang.String STRING_CHARSET_NAME = "UTF-8";

    boolean equals(java.lang.Object obj);

    int hashCode();

    void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest);
}
