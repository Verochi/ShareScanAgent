package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public class GlideUrl {
    private static final java.lang.String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    private final com.alimm.tanx.ui.image.glide.load.model.Headers headers;
    private java.lang.String safeStringUrl;
    private java.net.URL safeUrl;
    private final java.lang.String stringUrl;
    private final java.net.URL url;

    public GlideUrl(java.lang.String str) {
        this(str, com.alimm.tanx.ui.image.glide.load.model.Headers.DEFAULT);
    }

    public GlideUrl(java.lang.String str, com.alimm.tanx.ui.image.glide.load.model.Headers headers) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("String url must not be empty or null: " + str);
        }
        if (headers == null) {
            throw new java.lang.IllegalArgumentException("Headers must not be null");
        }
        this.stringUrl = str;
        this.url = null;
        this.headers = headers;
    }

    public GlideUrl(java.net.URL url) {
        this(url, com.alimm.tanx.ui.image.glide.load.model.Headers.DEFAULT);
    }

    public GlideUrl(java.net.URL url, com.alimm.tanx.ui.image.glide.load.model.Headers headers) {
        if (url == null) {
            throw new java.lang.IllegalArgumentException("URL must not be null!");
        }
        if (headers == null) {
            throw new java.lang.IllegalArgumentException("Headers must not be null");
        }
        this.url = url;
        this.stringUrl = null;
        this.headers = headers;
    }

    private java.lang.String getSafeStringUrl() {
        if (android.text.TextUtils.isEmpty(this.safeStringUrl)) {
            java.lang.String str = this.stringUrl;
            if (android.text.TextUtils.isEmpty(str)) {
                str = this.url.toString();
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

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.alimm.tanx.ui.image.glide.load.model.GlideUrl)) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl = (com.alimm.tanx.ui.image.glide.load.model.GlideUrl) obj;
        return getCacheKey().equals(glideUrl.getCacheKey()) && this.headers.equals(glideUrl.headers);
    }

    public java.lang.String getCacheKey() {
        java.lang.String str = this.stringUrl;
        return str != null ? str : this.url.toString();
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.headers.getHeaders();
    }

    public int hashCode() {
        return this.headers.hashCode() + (getCacheKey().hashCode() * 31);
    }

    public java.lang.String toString() {
        return getCacheKey() + '\n' + this.headers.toString();
    }

    public java.lang.String toStringUrl() {
        return getSafeStringUrl();
    }

    public java.net.URL toURL() throws java.net.MalformedURLException {
        return getSafeUrl();
    }
}
