package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public final class DrmInitData implements java.util.Comparator<com.google.android.exoplayer2.drm.DrmInitData.SchemeData>, android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.drm.DrmInitData> CREATOR = new com.google.android.exoplayer2.drm.DrmInitData.AnonymousClass1();
    private int hashCode;
    public final int schemeDataCount;
    private final com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] schemeDatas;

    @androidx.annotation.Nullable
    public final java.lang.String schemeType;

    /* renamed from: com.google.android.exoplayer2.drm.DrmInitData$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.drm.DrmInitData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.drm.DrmInitData createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.drm.DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.drm.DrmInitData[] newArray(int i) {
            return new com.google.android.exoplayer2.drm.DrmInitData[i];
        }
    }

    public static final class SchemeData implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> CREATOR = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData.AnonymousClass1();

        @androidx.annotation.Nullable
        public final byte[] data;
        private int hashCode;

        @androidx.annotation.Nullable
        public final java.lang.String licenseServerUrl;
        public final java.lang.String mimeType;
        public final java.util.UUID uuid;

        /* renamed from: com.google.android.exoplayer2.drm.DrmInitData$SchemeData$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.android.exoplayer2.drm.DrmInitData.SchemeData createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] newArray(int i) {
                return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[i];
            }
        }

        public SchemeData(android.os.Parcel parcel) {
            this.uuid = new java.util.UUID(parcel.readLong(), parcel.readLong());
            this.licenseServerUrl = parcel.readString();
            this.mimeType = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
            this.data = parcel.createByteArray();
        }

        public SchemeData(java.util.UUID uuid, @androidx.annotation.Nullable java.lang.String str, java.lang.String str2, @androidx.annotation.Nullable byte[] bArr) {
            this.uuid = (java.util.UUID) com.google.android.exoplayer2.util.Assertions.checkNotNull(uuid);
            this.licenseServerUrl = str;
            this.mimeType = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(str2);
            this.data = bArr;
        }

        public SchemeData(java.util.UUID uuid, java.lang.String str, @androidx.annotation.Nullable byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        public boolean canReplace(com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData) {
            return hasData() && !schemeData.hasData() && matches(schemeData.uuid);
        }

        public com.google.android.exoplayer2.drm.DrmInitData.SchemeData copyWithData(@androidx.annotation.Nullable byte[] bArr) {
            return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(this.uuid, this.licenseServerUrl, this.mimeType, bArr);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (!(obj instanceof com.google.android.exoplayer2.drm.DrmInitData.SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData) obj;
            return com.google.android.exoplayer2.util.Util.areEqual(this.licenseServerUrl, schemeData.licenseServerUrl) && com.google.android.exoplayer2.util.Util.areEqual(this.mimeType, schemeData.mimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.uuid, schemeData.uuid) && java.util.Arrays.equals(this.data, schemeData.data);
        }

        public boolean hasData() {
            return this.data != null;
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                int hashCode = this.uuid.hashCode() * 31;
                java.lang.String str = this.licenseServerUrl;
                this.hashCode = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.mimeType.hashCode()) * 31) + java.util.Arrays.hashCode(this.data);
            }
            return this.hashCode;
        }

        public boolean matches(java.util.UUID uuid) {
            return com.google.android.exoplayer2.C.UUID_NIL.equals(this.uuid) || uuid.equals(this.uuid);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.licenseServerUrl);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
        }
    }

    public DrmInitData(android.os.Parcel parcel) {
        this.schemeType = parcel.readString();
        com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] schemeDataArr = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) com.google.android.exoplayer2.util.Util.castNonNull((com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) parcel.createTypedArray(com.google.android.exoplayer2.drm.DrmInitData.SchemeData.CREATOR));
        this.schemeDatas = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
    }

    public DrmInitData(@androidx.annotation.Nullable java.lang.String str, java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list) {
        this(str, false, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) list.toArray(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[0]));
    }

    private DrmInitData(@androidx.annotation.Nullable java.lang.String str, boolean z, com.google.android.exoplayer2.drm.DrmInitData.SchemeData... schemeDataArr) {
        this.schemeType = str;
        schemeDataArr = z ? (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.schemeDatas = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
        java.util.Arrays.sort(schemeDataArr, this);
    }

    public DrmInitData(@androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.drm.DrmInitData.SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list) {
        this(null, false, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) list.toArray(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[0]));
    }

    public DrmInitData(com.google.android.exoplayer2.drm.DrmInitData.SchemeData... schemeDataArr) {
        this((java.lang.String) null, schemeDataArr);
    }

    private static boolean containsSchemeDataWithUuid(java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList, int i, java.util.UUID uuid) {
        for (int i2 = 0; i2 < i; i2++) {
            if (arrayList.get(i2).uuid.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.drm.DrmInitData createSessionCreationData(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmInitData drmInitData2) {
        java.lang.String str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (drmInitData != null) {
            str = drmInitData.schemeType;
            for (com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData : drmInitData.schemeDatas) {
                if (schemeData.hasData()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.schemeType;
            }
            int size = arrayList.size();
            for (com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData2 : drmInitData2.schemeDatas) {
                if (schemeData2.hasData() && !containsSchemeDataWithUuid(arrayList, size, schemeData2.uuid)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(str, arrayList);
    }

    @Override // java.util.Comparator
    public int compare(com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData, com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData2) {
        java.util.UUID uuid = com.google.android.exoplayer2.C.UUID_NIL;
        return uuid.equals(schemeData.uuid) ? uuid.equals(schemeData2.uuid) ? 0 : 1 : schemeData.uuid.compareTo(schemeData2.uuid);
    }

    public com.google.android.exoplayer2.drm.DrmInitData copyWithSchemeType(@androidx.annotation.Nullable java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.areEqual(this.schemeType, str) ? this : new com.google.android.exoplayer2.drm.DrmInitData(str, false, this.schemeDatas);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.drm.DrmInitData.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.drm.DrmInitData drmInitData = (com.google.android.exoplayer2.drm.DrmInitData) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.schemeType, drmInitData.schemeType) && java.util.Arrays.equals(this.schemeDatas, drmInitData.schemeDatas);
    }

    public com.google.android.exoplayer2.drm.DrmInitData.SchemeData get(int i) {
        return this.schemeDatas[i];
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public com.google.android.exoplayer2.drm.DrmInitData.SchemeData get(java.util.UUID uuid) {
        for (com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData : this.schemeDatas) {
            if (schemeData.matches(uuid)) {
                return schemeData;
            }
        }
        return null;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            java.lang.String str = this.schemeType;
            this.hashCode = ((str == null ? 0 : str.hashCode()) * 31) + java.util.Arrays.hashCode(this.schemeDatas);
        }
        return this.hashCode;
    }

    public com.google.android.exoplayer2.drm.DrmInitData merge(com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        java.lang.String str;
        java.lang.String str2 = this.schemeType;
        com.google.android.exoplayer2.util.Assertions.checkState(str2 == null || (str = drmInitData.schemeType) == null || android.text.TextUtils.equals(str2, str));
        java.lang.String str3 = this.schemeType;
        if (str3 == null) {
            str3 = drmInitData.schemeType;
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(str3, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) com.google.android.exoplayer2.util.Util.nullSafeArrayConcatenation(this.schemeDatas, drmInitData.schemeDatas));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.schemeType);
        parcel.writeTypedArray(this.schemeDatas, 0);
    }
}
