package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public class GlideUrl implements com.bumptech.glide.load.Key {
    private static final java.lang.String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";

    @androidx.annotation.Nullable
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final com.bumptech.glide.load.model.Headers headers;

    @androidx.annotation.Nullable
    private java.lang.String safeStringUrl;

    @androidx.annotation.Nullable
    private java.net.URL safeUrl;

    @androidx.annotation.Nullable
    private final java.lang.String stringUrl;

    @androidx.annotation.Nullable
    private final java.net.URL url;

    public GlideUrl(java.lang.String str) {
        this(str, com.bumptech.glide.load.model.Headers.DEFAULT);
    }

    public GlideUrl(java.lang.String str, com.bumptech.glide.load.model.Headers headers) {
        this.url = null;
        this.stringUrl = com.bumptech.glide.util.Preconditions.checkNotEmpty(str);
        this.headers = (com.bumptech.glide.load.model.Headers) com.bumptech.glide.util.Preconditions.checkNotNull(headers);
    }

    public GlideUrl(java.net.URL url) {
        this(url, com.bumptech.glide.load.model.Headers.DEFAULT);
    }

    public GlideUrl(java.net.URL url, com.bumptech.glide.load.model.Headers headers) {
        this.url = (java.net.URL) com.bumptech.glide.util.Preconditions.checkNotNull(url);
        this.stringUrl = null;
        this.headers = (com.bumptech.glide.load.model.Headers) com.bumptech.glide.util.Preconditions.checkNotNull(headers);
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes == null) {
            this.cacheKeyBytes = getCacheKey().getBytes(com.bumptech.glide.load.Key.CHARSET);
        }
        return this.cacheKeyBytes;
    }

    private java.lang.String getSafeStringUrl() {
        if (android.text.TextUtils.isEmpty(this.safeStringUrl)) {
            java.lang.String str = this.stringUrl;
            if (android.text.TextUtils.isEmpty(str)) {
                str = ((java.net.URL) com.bumptech.glide.util.Preconditions.checkNotNull(this.url)).toString();
            }
            this.safeStringUrl = android.net.Uri.encode(str, ALLOWED_URI_CHARS);
        }
        return this.safeStringUrl;
    }

    private java.net.URL getSafeUrl() throws java.net.MalformedURLException {
        if (this.safeUrl == null) {
            this.safeUrl = new java.net.URL(getSafeStringUrl());
        }
        return this.safeUrl;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.bumptech.glide.load.model.GlideUrl)) {
            return false;
        }
        com.bumptech.glide.load.model.GlideUrl glideUrl = (com.bumptech.glide.load.model.GlideUrl) obj;
        return getCacheKey().equals(glideUrl.getCacheKey()) && this.headers.equals(glideUrl.headers);
    }

    public java.lang.String getCacheKey() {
        java.lang.String str = this.stringUrl;
        return str != null ? str : ((java.net.URL) com.bumptech.glide.util.Preconditions.checkNotNull(this.url)).toString();
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.headers.getHeaders();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = getCacheKey().hashCode();
            this.hashCode = hashCode;
            this.hashCode = (hashCode * 31) + this.headers.hashCode();
        }
        return this.hashCode;
    }

    public java.lang.String toString() {
        return getCacheKey();
    }

    public java.lang.String toStringUrl() {
        return getSafeStringUrl();
    }

    public java.net.URL toURL() throws java.net.MalformedURLException {
        return getSafeUrl();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        messageDigest.update(getCacheKeyBytes());
    }
}
