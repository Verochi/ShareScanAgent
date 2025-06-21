package com.huawei.hms.common;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public class Feature extends com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable {
    public static final int ARGS_NAME = 1;
    public static final int ARGS_SVC_VER = 2;
    public static final int ARGS_VER = 3;
    public static final android.os.Parcelable.Creator<com.huawei.hms.common.Feature> CREATOR = new com.huawei.hms.common.FeatureCreator();
    private static final int SVC_VER = -1;
    private final long apiVersion;
    private final java.lang.String name;

    @java.lang.Deprecated
    private final int serviceVersion;

    public Feature(java.lang.String str, int i, long j) {
        this.name = str;
        this.serviceVersion = i;
        this.apiVersion = j;
    }

    public Feature(java.lang.String str, long j) {
        this(str, -1, j);
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.huawei.hms.common.Feature)) {
            return false;
        }
        com.huawei.hms.common.Feature feature = (com.huawei.hms.common.Feature) obj;
        return this.name.equals(feature.getName()) && getVersion() == feature.getVersion();
    }

    public java.lang.String getName() {
        return this.name;
    }

    public long getVersion() {
        long j = this.apiVersion;
        return -1 == j ? this.serviceVersion : j;
    }

    public int hashCode() {
        return com.huawei.hms.common.internal.Objects.hashCode(getName(), java.lang.Long.valueOf(getVersion()));
    }

    public java.lang.String toString() {
        return com.huawei.hms.common.internal.Objects.toStringHelper(this).add("name", getName()).add("version", java.lang.Long.valueOf(getVersion())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        int beginObjectHeader = com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeString(parcel, 1, getName(), false);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 2, this.serviceVersion);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeLong(parcel, 3, getVersion());
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
