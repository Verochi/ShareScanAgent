package com.google.android.exoplayer2.metadata.icy;

/* loaded from: classes22.dex */
public final class IcyHeaders implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.icy.IcyHeaders> CREATOR = new com.google.android.exoplayer2.metadata.icy.IcyHeaders.AnonymousClass1();
    public static final java.lang.String REQUEST_HEADER_ENABLE_METADATA_NAME = "Icy-MetaData";
    public static final java.lang.String REQUEST_HEADER_ENABLE_METADATA_VALUE = "1";
    private static final java.lang.String RESPONSE_HEADER_BITRATE = "icy-br";
    private static final java.lang.String RESPONSE_HEADER_GENRE = "icy-genre";
    private static final java.lang.String RESPONSE_HEADER_METADATA_INTERVAL = "icy-metaint";
    private static final java.lang.String RESPONSE_HEADER_NAME = "icy-name";
    private static final java.lang.String RESPONSE_HEADER_PUB = "icy-pub";
    private static final java.lang.String RESPONSE_HEADER_URL = "icy-url";
    private static final java.lang.String TAG = "IcyHeaders";
    public final int bitrate;

    @androidx.annotation.Nullable
    public final java.lang.String genre;
    public final boolean isPublic;
    public final int metadataInterval;

    @androidx.annotation.Nullable
    public final java.lang.String name;

    @androidx.annotation.Nullable
    public final java.lang.String url;

    /* renamed from: com.google.android.exoplayer2.metadata.icy.IcyHeaders$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.icy.IcyHeaders> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.icy.IcyHeaders createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.icy.IcyHeaders(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.icy.IcyHeaders[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.icy.IcyHeaders[i];
        }
    }

    public IcyHeaders(int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, boolean z, int i2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i2 == -1 || i2 > 0);
        this.bitrate = i;
        this.genre = str;
        this.name = str2;
        this.url = str3;
        this.isPublic = z;
        this.metadataInterval = i2;
    }

    public IcyHeaders(android.os.Parcel parcel) {
        this.bitrate = parcel.readInt();
        this.genre = parcel.readString();
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.isPublic = com.google.android.exoplayer2.util.Util.readBoolean(parcel);
        this.metadataInterval = parcel.readInt();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0075  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.android.exoplayer2.metadata.icy.IcyHeaders parse(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        boolean z;
        int i;
        java.util.List<java.lang.String> list;
        java.lang.String str;
        java.util.List<java.lang.String> list2;
        java.lang.String str2;
        java.util.List<java.lang.String> list3;
        java.lang.String str3;
        java.util.List<java.lang.String> list4;
        boolean z2;
        java.util.List<java.lang.String> list5;
        int i2;
        java.util.List<java.lang.String> list6 = map.get(RESPONSE_HEADER_BITRATE);
        boolean z3 = true;
        int i3 = -1;
        if (list6 != null) {
            java.lang.String str4 = list6.get(0);
            try {
                i2 = java.lang.Integer.parseInt(str4) * 1000;
                if (i2 > 0) {
                    z = true;
                } else {
                    try {
                        java.lang.String valueOf = java.lang.String.valueOf(str4);
                        com.google.android.exoplayer2.util.Log.w(TAG, valueOf.length() != 0 ? "Invalid bitrate: ".concat(valueOf) : new java.lang.String("Invalid bitrate: "));
                        z = false;
                        i2 = -1;
                    } catch (java.lang.NumberFormatException unused) {
                        java.lang.String valueOf2 = java.lang.String.valueOf(str4);
                        com.google.android.exoplayer2.util.Log.w(TAG, valueOf2.length() != 0 ? "Invalid bitrate header: ".concat(valueOf2) : new java.lang.String("Invalid bitrate header: "));
                        i = i2;
                        z = false;
                        list = map.get(RESPONSE_HEADER_GENRE);
                        if (list == null) {
                        }
                        list2 = map.get(RESPONSE_HEADER_NAME);
                        if (list2 == null) {
                        }
                        list3 = map.get(RESPONSE_HEADER_URL);
                        if (list3 == null) {
                        }
                        list4 = map.get(RESPONSE_HEADER_PUB);
                        if (list4 == null) {
                        }
                        list5 = map.get(RESPONSE_HEADER_METADATA_INTERVAL);
                        if (list5 != null) {
                        }
                        if (z) {
                        }
                    }
                }
                i = i2;
            } catch (java.lang.NumberFormatException unused2) {
                i2 = -1;
            }
        } else {
            z = false;
            i = -1;
        }
        list = map.get(RESPONSE_HEADER_GENRE);
        if (list == null) {
            str = list.get(0);
            z = true;
        } else {
            str = null;
        }
        list2 = map.get(RESPONSE_HEADER_NAME);
        if (list2 == null) {
            str2 = list2.get(0);
            z = true;
        } else {
            str2 = null;
        }
        list3 = map.get(RESPONSE_HEADER_URL);
        if (list3 == null) {
            str3 = list3.get(0);
            z = true;
        } else {
            str3 = null;
        }
        list4 = map.get(RESPONSE_HEADER_PUB);
        if (list4 == null) {
            z2 = list4.get(0).equals("1");
            z = true;
        } else {
            z2 = false;
        }
        list5 = map.get(RESPONSE_HEADER_METADATA_INTERVAL);
        if (list5 != null) {
            java.lang.String str5 = list5.get(0);
            try {
                int parseInt = java.lang.Integer.parseInt(str5);
                if (parseInt > 0) {
                    i3 = parseInt;
                } else {
                    try {
                        java.lang.String valueOf3 = java.lang.String.valueOf(str5);
                        com.google.android.exoplayer2.util.Log.w(TAG, valueOf3.length() != 0 ? "Invalid metadata interval: ".concat(valueOf3) : new java.lang.String("Invalid metadata interval: "));
                        z3 = z;
                    } catch (java.lang.NumberFormatException unused3) {
                        i3 = parseInt;
                        java.lang.String valueOf4 = java.lang.String.valueOf(str5);
                        com.google.android.exoplayer2.util.Log.w(TAG, valueOf4.length() != 0 ? "Invalid metadata interval: ".concat(valueOf4) : new java.lang.String("Invalid metadata interval: "));
                        if (z) {
                        }
                    }
                }
                z = z3;
            } catch (java.lang.NumberFormatException unused4) {
            }
        }
        if (z) {
            return new com.google.android.exoplayer2.metadata.icy.IcyHeaders(i, str, str2, str3, z2, i3);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.icy.IcyHeaders.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.icy.IcyHeaders icyHeaders = (com.google.android.exoplayer2.metadata.icy.IcyHeaders) obj;
        return this.bitrate == icyHeaders.bitrate && com.google.android.exoplayer2.util.Util.areEqual(this.genre, icyHeaders.genre) && com.google.android.exoplayer2.util.Util.areEqual(this.name, icyHeaders.name) && com.google.android.exoplayer2.util.Util.areEqual(this.url, icyHeaders.url) && this.isPublic == icyHeaders.isPublic && this.metadataInterval == icyHeaders.metadataInterval;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return defpackage.kl1.a(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ com.google.android.exoplayer2.Format getWrappedMetadataFormat() {
        return defpackage.kl1.b(this);
    }

    public int hashCode() {
        int i = (527 + this.bitrate) * 31;
        java.lang.String str = this.genre;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.url;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.isPublic ? 1 : 0)) * 31) + this.metadataInterval;
    }

    public java.lang.String toString() {
        java.lang.String str = this.name;
        java.lang.String str2 = this.genre;
        int i = this.bitrate;
        int i2 = this.metadataInterval;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 80 + java.lang.String.valueOf(str2).length());
        sb.append("IcyHeaders: name=\"");
        sb.append(str);
        sb.append("\", genre=\"");
        sb.append(str2);
        sb.append("\", bitrate=");
        sb.append(i);
        sb.append(", metadataInterval=");
        sb.append(i2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.bitrate);
        parcel.writeString(this.genre);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.isPublic);
        parcel.writeInt(this.metadataInterval);
    }
}
