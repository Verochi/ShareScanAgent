package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public class ContentMetadataMutations {
    public final java.util.Map<java.lang.String, java.lang.Object> a = new java.util.HashMap();
    public final java.util.List<java.lang.String> b = new java.util.ArrayList();

    public static com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations setContentLength(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations, long j) {
        return contentMetadataMutations.set(com.google.android.exoplayer2.upstream.cache.ContentMetadata.KEY_CONTENT_LENGTH, j);
    }

    public static com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations setRedirectedUri(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations, @androidx.annotation.Nullable android.net.Uri uri) {
        return uri == null ? contentMetadataMutations.remove(com.google.android.exoplayer2.upstream.cache.ContentMetadata.KEY_REDIRECTED_URI) : contentMetadataMutations.set(com.google.android.exoplayer2.upstream.cache.ContentMetadata.KEY_REDIRECTED_URI, uri.toString());
    }

    public final com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations a(java.lang.String str, java.lang.Object obj) {
        this.a.put((java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(str), com.google.android.exoplayer2.util.Assertions.checkNotNull(obj));
        this.b.remove(str);
        return this;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getEditedValues() {
        java.util.HashMap hashMap = new java.util.HashMap(this.a);
        for (java.util.Map.Entry entry : hashMap.entrySet()) {
            java.lang.Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(java.util.Arrays.copyOf(bArr, bArr.length));
            }
        }
        return java.util.Collections.unmodifiableMap(hashMap);
    }

    public java.util.List<java.lang.String> getRemovedValues() {
        return java.util.Collections.unmodifiableList(new java.util.ArrayList(this.b));
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations remove(java.lang.String str) {
        this.b.add(str);
        this.a.remove(str);
        return this;
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations set(java.lang.String str, long j) {
        return a(str, java.lang.Long.valueOf(j));
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations set(java.lang.String str, java.lang.String str2) {
        return a(str, str2);
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations set(java.lang.String str, byte[] bArr) {
        return a(str, java.util.Arrays.copyOf(bArr, bArr.length));
    }
}
