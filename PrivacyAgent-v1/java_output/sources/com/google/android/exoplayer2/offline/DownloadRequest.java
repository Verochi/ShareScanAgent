package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final class DownloadRequest implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.offline.DownloadRequest> CREATOR = new com.google.android.exoplayer2.offline.DownloadRequest.AnonymousClass1();

    @androidx.annotation.Nullable
    public final java.lang.String customCacheKey;
    public final byte[] data;
    public final java.lang.String id;

    @androidx.annotation.Nullable
    public final byte[] keySetId;

    @androidx.annotation.Nullable
    public final java.lang.String mimeType;
    public final java.util.List<com.google.android.exoplayer2.offline.StreamKey> streamKeys;
    public final android.net.Uri uri;

    /* renamed from: com.google.android.exoplayer2.offline.DownloadRequest$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.offline.DownloadRequest> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.offline.DownloadRequest createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.offline.DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.offline.DownloadRequest[] newArray(int i) {
            return new com.google.android.exoplayer2.offline.DownloadRequest[i];
        }
    }

    public static class Builder {
        public final java.lang.String a;
        public final android.net.Uri b;

        @androidx.annotation.Nullable
        public java.lang.String c;

        @androidx.annotation.Nullable
        public java.util.List<com.google.android.exoplayer2.offline.StreamKey> d;

        @androidx.annotation.Nullable
        public byte[] e;

        @androidx.annotation.Nullable
        public java.lang.String f;

        @androidx.annotation.Nullable
        public byte[] g;

        public Builder(java.lang.String str, android.net.Uri uri) {
            this.a = str;
            this.b = uri;
        }

        public com.google.android.exoplayer2.offline.DownloadRequest build() {
            java.lang.String str = this.a;
            android.net.Uri uri = this.b;
            java.lang.String str2 = this.c;
            java.util.List list = this.d;
            if (list == null) {
                list = com.google.common.collect.ImmutableList.of();
            }
            return new com.google.android.exoplayer2.offline.DownloadRequest(str, uri, str2, list, this.e, this.f, this.g, null);
        }

        public com.google.android.exoplayer2.offline.DownloadRequest.Builder setCustomCacheKey(@androidx.annotation.Nullable java.lang.String str) {
            this.f = str;
            return this;
        }

        public com.google.android.exoplayer2.offline.DownloadRequest.Builder setData(@androidx.annotation.Nullable byte[] bArr) {
            this.g = bArr;
            return this;
        }

        public com.google.android.exoplayer2.offline.DownloadRequest.Builder setKeySetId(@androidx.annotation.Nullable byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public com.google.android.exoplayer2.offline.DownloadRequest.Builder setMimeType(@androidx.annotation.Nullable java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.google.android.exoplayer2.offline.DownloadRequest.Builder setStreamKeys(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
            this.d = list;
            return this;
        }
    }

    public static class UnsupportedRequestException extends java.io.IOException {
    }

    public DownloadRequest(android.os.Parcel parcel) {
        this.id = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.uri = android.net.Uri.parse((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString()));
        this.mimeType = parcel.readString();
        int readInt = parcel.readInt();
        java.util.ArrayList arrayList = new java.util.ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((com.google.android.exoplayer2.offline.StreamKey) parcel.readParcelable(com.google.android.exoplayer2.offline.StreamKey.class.getClassLoader()));
        }
        this.streamKeys = java.util.Collections.unmodifiableList(arrayList);
        this.keySetId = parcel.createByteArray();
        this.customCacheKey = parcel.readString();
        this.data = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
    }

    private DownloadRequest(java.lang.String str, android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str2, java.util.List<com.google.android.exoplayer2.offline.StreamKey> list, @androidx.annotation.Nullable byte[] bArr, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable byte[] bArr2) {
        int inferContentTypeForUriAndMimeType = com.google.android.exoplayer2.util.Util.inferContentTypeForUriAndMimeType(uri, str2);
        if (inferContentTypeForUriAndMimeType == 0 || inferContentTypeForUriAndMimeType == 2 || inferContentTypeForUriAndMimeType == 1) {
            boolean z = str3 == null;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(49);
            sb.append("customCacheKey must be null for type: ");
            sb.append(inferContentTypeForUriAndMimeType);
            com.google.android.exoplayer2.util.Assertions.checkArgument(z, sb.toString());
        }
        this.id = str;
        this.uri = uri;
        this.mimeType = str2;
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.Collections.sort(arrayList);
        this.streamKeys = java.util.Collections.unmodifiableList(arrayList);
        this.keySetId = bArr != null ? java.util.Arrays.copyOf(bArr, bArr.length) : null;
        this.customCacheKey = str3;
        this.data = bArr2 != null ? java.util.Arrays.copyOf(bArr2, bArr2.length) : com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
    }

    public /* synthetic */ DownloadRequest(java.lang.String str, android.net.Uri uri, java.lang.String str2, java.util.List list, byte[] bArr, java.lang.String str3, byte[] bArr2, com.google.android.exoplayer2.offline.DownloadRequest.AnonymousClass1 anonymousClass1) {
        this(str, uri, str2, list, bArr, str3, bArr2);
    }

    public com.google.android.exoplayer2.offline.DownloadRequest copyWithId(java.lang.String str) {
        return new com.google.android.exoplayer2.offline.DownloadRequest(str, this.uri, this.mimeType, this.streamKeys, this.keySetId, this.customCacheKey, this.data);
    }

    public com.google.android.exoplayer2.offline.DownloadRequest copyWithKeySetId(@androidx.annotation.Nullable byte[] bArr) {
        return new com.google.android.exoplayer2.offline.DownloadRequest(this.id, this.uri, this.mimeType, this.streamKeys, bArr, this.customCacheKey, this.data);
    }

    public com.google.android.exoplayer2.offline.DownloadRequest copyWithMergedRequest(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest) {
        java.util.List emptyList;
        com.google.android.exoplayer2.util.Assertions.checkArgument(this.id.equals(downloadRequest.id));
        if (this.streamKeys.isEmpty() || downloadRequest.streamKeys.isEmpty()) {
            emptyList = java.util.Collections.emptyList();
        } else {
            emptyList = new java.util.ArrayList(this.streamKeys);
            for (int i = 0; i < downloadRequest.streamKeys.size(); i++) {
                com.google.android.exoplayer2.offline.StreamKey streamKey = downloadRequest.streamKeys.get(i);
                if (!emptyList.contains(streamKey)) {
                    emptyList.add(streamKey);
                }
            }
        }
        return new com.google.android.exoplayer2.offline.DownloadRequest(this.id, downloadRequest.uri, downloadRequest.mimeType, emptyList, downloadRequest.keySetId, downloadRequest.customCacheKey, downloadRequest.data);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (!(obj instanceof com.google.android.exoplayer2.offline.DownloadRequest)) {
            return false;
        }
        com.google.android.exoplayer2.offline.DownloadRequest downloadRequest = (com.google.android.exoplayer2.offline.DownloadRequest) obj;
        return this.id.equals(downloadRequest.id) && this.uri.equals(downloadRequest.uri) && com.google.android.exoplayer2.util.Util.areEqual(this.mimeType, downloadRequest.mimeType) && this.streamKeys.equals(downloadRequest.streamKeys) && java.util.Arrays.equals(this.keySetId, downloadRequest.keySetId) && com.google.android.exoplayer2.util.Util.areEqual(this.customCacheKey, downloadRequest.customCacheKey) && java.util.Arrays.equals(this.data, downloadRequest.data);
    }

    public final int hashCode() {
        int hashCode = ((this.id.hashCode() * 31 * 31) + this.uri.hashCode()) * 31;
        java.lang.String str = this.mimeType;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.streamKeys.hashCode()) * 31) + java.util.Arrays.hashCode(this.keySetId)) * 31;
        java.lang.String str2 = this.customCacheKey;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + java.util.Arrays.hashCode(this.data);
    }

    public com.google.android.exoplayer2.MediaItem toMediaItem() {
        return new com.google.android.exoplayer2.MediaItem.Builder().setMediaId(this.id).setUri(this.uri).setCustomCacheKey(this.customCacheKey).setMimeType(this.mimeType).setStreamKeys(this.streamKeys).setDrmKeySetId(this.keySetId).build();
    }

    public java.lang.String toString() {
        java.lang.String str = this.mimeType;
        java.lang.String str2 = this.id;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 1 + java.lang.String.valueOf(str2).length());
        sb.append(str);
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.uri.toString());
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.streamKeys.size());
        for (int i2 = 0; i2 < this.streamKeys.size(); i2++) {
            parcel.writeParcelable(this.streamKeys.get(i2), 0);
        }
        parcel.writeByteArray(this.keySetId);
        parcel.writeString(this.customCacheKey);
        parcel.writeByteArray(this.data);
    }
}
