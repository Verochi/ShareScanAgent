package com.getui.gtc.dim;

/* loaded from: classes22.dex */
public class DimRequest implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.getui.gtc.dim.DimRequest> CREATOR = new com.getui.gtc.dim.DimRequest.AnonymousClass1();
    private com.getui.gtc.dim.AllowSysCall allowSysCall;
    private com.getui.gtc.dim.Caller caller;
    private java.lang.String key;
    private long ramCacheValidTime;
    private boolean skipCache;
    private long storageCacheValidTime;
    private boolean useExpiredCacheForReserve;

    /* renamed from: com.getui.gtc.dim.DimRequest$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.getui.gtc.dim.DimRequest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.getui.gtc.dim.DimRequest createFromParcel(android.os.Parcel parcel) {
            return new com.getui.gtc.dim.DimRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.getui.gtc.dim.DimRequest[] newArray(int i) {
            return new com.getui.gtc.dim.DimRequest[i];
        }
    }

    public static class Builder {
        private com.getui.gtc.dim.AllowSysCall allowSysCall;
        private com.getui.gtc.dim.Caller caller;
        private java.lang.String key;
        private long ramCacheValidTime;
        private boolean skipCache;
        private long storageCacheValidTime;
        private boolean useExpiredCacheForReserve;

        public Builder() {
            this.ramCacheValidTime = 60000L;
            this.storageCacheValidTime = 60000L;
            this.allowSysCall = com.getui.gtc.dim.AllowSysCall.ALL_ALLOW;
            this.useExpiredCacheForReserve = false;
            this.skipCache = false;
        }

        public Builder(com.getui.gtc.dim.DimRequest dimRequest) {
            this.ramCacheValidTime = 60000L;
            this.storageCacheValidTime = 60000L;
            this.allowSysCall = com.getui.gtc.dim.AllowSysCall.ALL_ALLOW;
            this.useExpiredCacheForReserve = false;
            this.skipCache = false;
            this.key = dimRequest.key;
            this.ramCacheValidTime = dimRequest.ramCacheValidTime;
            this.storageCacheValidTime = dimRequest.storageCacheValidTime;
            this.allowSysCall = dimRequest.allowSysCall;
            this.useExpiredCacheForReserve = dimRequest.useExpiredCacheForReserve;
            this.caller = dimRequest.caller;
            this.skipCache = dimRequest.skipCache;
        }

        @java.lang.Deprecated
        public com.getui.gtc.dim.DimRequest.Builder allowSysCall(com.getui.gtc.dim.AllowSysCall allowSysCall) {
            this.allowSysCall = allowSysCall;
            return this;
        }

        @java.lang.Deprecated
        public com.getui.gtc.dim.DimRequest.Builder allowSysCall(boolean z) {
            this.allowSysCall = z ? com.getui.gtc.dim.AllowSysCall.ALL_ALLOW : com.getui.gtc.dim.AllowSysCall.NOT_ALLOW;
            return this;
        }

        public com.getui.gtc.dim.DimRequest build() {
            return new com.getui.gtc.dim.DimRequest(this, null);
        }

        public com.getui.gtc.dim.DimRequest.Builder caller(com.getui.gtc.dim.Caller caller) {
            this.caller = caller;
            return this;
        }

        public com.getui.gtc.dim.DimRequest.Builder key(java.lang.String str) {
            this.key = str;
            return this;
        }

        @java.lang.Deprecated
        public com.getui.gtc.dim.DimRequest.Builder ramCacheValidTime(long j) {
            this.ramCacheValidTime = j;
            return this;
        }

        public com.getui.gtc.dim.DimRequest.Builder skipCache(boolean z) {
            this.skipCache = z;
            return this;
        }

        @java.lang.Deprecated
        public com.getui.gtc.dim.DimRequest.Builder storageCacheValidTime(long j) {
            this.storageCacheValidTime = j;
            return this;
        }

        @java.lang.Deprecated
        public com.getui.gtc.dim.DimRequest.Builder useExpiredCacheForReserve(boolean z) {
            this.useExpiredCacheForReserve = z;
            return this;
        }
    }

    private DimRequest() {
    }

    public DimRequest(android.os.Parcel parcel) {
        this.key = parcel.readString();
        this.ramCacheValidTime = parcel.readLong();
        this.storageCacheValidTime = parcel.readLong();
        this.allowSysCall = com.getui.gtc.dim.AllowSysCall.valueOf(parcel.readInt());
        this.useExpiredCacheForReserve = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            this.caller = com.getui.gtc.dim.Caller.values()[readInt];
        }
        this.skipCache = parcel.readByte() != 0;
    }

    private DimRequest(com.getui.gtc.dim.DimRequest.Builder builder) {
        this.key = builder.key;
        this.ramCacheValidTime = builder.ramCacheValidTime;
        this.storageCacheValidTime = builder.storageCacheValidTime;
        this.allowSysCall = builder.allowSysCall;
        this.useExpiredCacheForReserve = builder.useExpiredCacheForReserve;
        this.caller = builder.caller;
        this.skipCache = builder.skipCache;
    }

    public /* synthetic */ DimRequest(com.getui.gtc.dim.DimRequest.Builder builder, com.getui.gtc.dim.DimRequest.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @java.lang.Deprecated
    public com.getui.gtc.dim.AllowSysCall getAllowSysCall() {
        return this.allowSysCall;
    }

    public com.getui.gtc.dim.Caller getCaller() {
        return this.caller;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    @java.lang.Deprecated
    public long getRamCacheValidTime() {
        return this.ramCacheValidTime;
    }

    @java.lang.Deprecated
    public long getStorageCacheValidTime() {
        return this.storageCacheValidTime;
    }

    public boolean isSkipCache() {
        return this.skipCache;
    }

    @java.lang.Deprecated
    public boolean isUseExpiredCacheForReserve() {
        return this.useExpiredCacheForReserve;
    }

    @java.lang.Deprecated
    public void setAllowSysCall(com.getui.gtc.dim.AllowSysCall allowSysCall) {
        this.allowSysCall = allowSysCall;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    @java.lang.Deprecated
    public void setRamCacheValidTime(long j) {
        this.ramCacheValidTime = j;
    }

    @java.lang.Deprecated
    public void setStorageCacheValidTime(long j) {
        this.storageCacheValidTime = j;
    }

    @java.lang.Deprecated
    public void setUseExpiredCacheForReserve(boolean z) {
        this.useExpiredCacheForReserve = z;
    }

    public java.lang.String toString() {
        return "DimRequest{key='" + this.key + "', ramCacheValidTime=" + this.ramCacheValidTime + ", storageCacheValidTime=" + this.storageCacheValidTime + ", allowSysCall=" + this.allowSysCall + ", useExpiredCacheForReserve=" + this.useExpiredCacheForReserve + ", caller=" + this.caller + ", skipCache=" + this.skipCache + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeLong(this.ramCacheValidTime);
        parcel.writeLong(this.storageCacheValidTime);
        parcel.writeInt(this.allowSysCall.getValue());
        parcel.writeByte(this.useExpiredCacheForReserve ? (byte) 1 : (byte) 0);
        com.getui.gtc.dim.Caller caller = this.caller;
        parcel.writeInt(caller != null ? caller.ordinal() : -1);
        parcel.writeByte(this.skipCache ? (byte) 1 : (byte) 0);
    }
}
