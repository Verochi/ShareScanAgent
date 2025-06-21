package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
final class FullSegmentEncryptionKeyCache {
    public final java.util.LinkedHashMap<android.net.Uri, byte[]> a;

    /* renamed from: com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.LinkedHashMap<android.net.Uri, byte[]> {
        final /* synthetic */ int val$maxSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache fullSegmentEncryptionKeyCache, int i, float f, boolean z, int i2) {
            super(i, f, z);
            this.val$maxSize = i2;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(java.util.Map.Entry<android.net.Uri, byte[]> entry) {
            return size() > this.val$maxSize;
        }
    }

    public FullSegmentEncryptionKeyCache(int i) {
        this.a = new com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache.AnonymousClass1(this, i + 1, 1.0f, false, i);
    }

    @androidx.annotation.Nullable
    public byte[] a(@androidx.annotation.Nullable android.net.Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.a.get(uri);
    }

    @androidx.annotation.Nullable
    public byte[] b(android.net.Uri uri, byte[] bArr) {
        return this.a.put((android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(uri), (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr));
    }

    @androidx.annotation.Nullable
    public byte[] c(android.net.Uri uri) {
        return this.a.remove(com.google.android.exoplayer2.util.Assertions.checkNotNull(uri));
    }
}
