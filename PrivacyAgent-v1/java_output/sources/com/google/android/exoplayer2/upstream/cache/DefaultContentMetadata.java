package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public final class DefaultContentMetadata implements com.google.android.exoplayer2.upstream.cache.ContentMetadata {
    public static final com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata EMPTY = new com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata(java.util.Collections.emptyMap());
    public int a;
    public final java.util.Map<java.lang.String, byte[]> b;

    public DefaultContentMetadata() {
        this(java.util.Collections.emptyMap());
    }

    public DefaultContentMetadata(java.util.Map<java.lang.String, byte[]> map) {
        this.b = java.util.Collections.unmodifiableMap(map);
    }

    public static void a(java.util.HashMap<java.lang.String, byte[]> hashMap, java.util.Map<java.lang.String, java.lang.Object> map) {
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), c(entry.getValue()));
        }
    }

    public static java.util.Map<java.lang.String, byte[]> b(java.util.Map<java.lang.String, byte[]> map, com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        java.util.HashMap hashMap = new java.util.HashMap(map);
        e(hashMap, contentMetadataMutations.getRemovedValues());
        a(hashMap, contentMetadataMutations.getEditedValues());
        return hashMap;
    }

    public static byte[] c(java.lang.Object obj) {
        if (obj instanceof java.lang.Long) {
            return java.nio.ByteBuffer.allocate(8).putLong(((java.lang.Long) obj).longValue()).array();
        }
        if (obj instanceof java.lang.String) {
            return ((java.lang.String) obj).getBytes(com.google.common.base.Charsets.UTF_8);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new java.lang.IllegalArgumentException();
    }

    public static boolean d(java.util.Map<java.lang.String, byte[]> map, java.util.Map<java.lang.String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (java.util.Map.Entry<java.lang.String, byte[]> entry : map.entrySet()) {
            if (!java.util.Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void e(java.util.HashMap<java.lang.String, byte[]> hashMap, java.util.List<java.lang.String> list) {
        for (int i = 0; i < list.size(); i++) {
            hashMap.remove(list.get(i));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final boolean contains(java.lang.String str) {
        return this.b.containsKey(str);
    }

    public com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata copyWithMutationsApplied(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        java.util.Map<java.lang.String, byte[]> b = b(this.b, contentMetadataMutations);
        return d(this.b, b) ? this : new com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata(b);
    }

    public java.util.Set<java.util.Map.Entry<java.lang.String, byte[]>> entrySet() {
        return this.b.entrySet();
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return d(this.b, ((com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata) obj).b);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final long get(java.lang.String str, long j) {
        byte[] bArr = this.b.get(str);
        return bArr != null ? java.nio.ByteBuffer.wrap(bArr).getLong() : j;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    @androidx.annotation.Nullable
    public final java.lang.String get(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        byte[] bArr = this.b.get(str);
        return bArr != null ? new java.lang.String(bArr, com.google.common.base.Charsets.UTF_8) : str2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    @androidx.annotation.Nullable
    public final byte[] get(java.lang.String str, @androidx.annotation.Nullable byte[] bArr) {
        byte[] bArr2 = this.b.get(str);
        return bArr2 != null ? java.util.Arrays.copyOf(bArr2, bArr2.length) : bArr;
    }

    public int hashCode() {
        if (this.a == 0) {
            int i = 0;
            for (java.util.Map.Entry<java.lang.String, byte[]> entry : this.b.entrySet()) {
                i += java.util.Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.a = i;
        }
        return this.a;
    }
}
