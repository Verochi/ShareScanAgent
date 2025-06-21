package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public final class TileOverlayOptions extends com.amap.api.maps.model.BaseOptions implements android.os.Parcelable {
    public static final com.amap.api.maps.model.TileOverlayOptionsCreator CREATOR = new com.amap.api.maps.model.TileOverlayOptionsCreator();
    private com.amap.api.maps.model.TileProvider _tileProvider;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.lang.String diskCacheDir;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean diskCacheEnabled;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private long diskCacheSize;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.autonavi.base.ae.gmap.bean.TileProviderInner mTileProvider;
    private final int mVersionCode;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean mVisible;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private float mZIndex;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int memCacheSize;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private boolean memoryCacheEnabled;

    public TileOverlayOptions() {
        this.mVisible = true;
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = 1;
        this.type = "TileOverlayOptions";
    }

    public TileOverlayOptions(int i, boolean z, float f) {
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = i;
        this.mVisible = z;
        this.mZIndex = f;
        this.type = "TileOverlayOptions";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final com.amap.api.maps.model.TileOverlayOptions diskCacheDir(java.lang.String str) {
        this.diskCacheDir = str;
        return this;
    }

    public final com.amap.api.maps.model.TileOverlayOptions diskCacheEnabled(boolean z) {
        this.diskCacheEnabled = z;
        return this;
    }

    public final com.amap.api.maps.model.TileOverlayOptions diskCacheSize(int i) {
        this.diskCacheSize = i * 1024;
        return this;
    }

    public final java.lang.String getDiskCacheDir() {
        return this.diskCacheDir;
    }

    public final boolean getDiskCacheEnabled() {
        return this.diskCacheEnabled;
    }

    public final long getDiskCacheSize() {
        return this.diskCacheSize;
    }

    public final int getMemCacheSize() {
        return this.memCacheSize;
    }

    public final boolean getMemoryCacheEnabled() {
        return this.memoryCacheEnabled;
    }

    public final com.amap.api.maps.model.TileProvider getTileProvider() {
        return this._tileProvider;
    }

    public final com.autonavi.base.ae.gmap.bean.TileProviderInner getTileProviderInner() {
        return this.mTileProvider;
    }

    public final float getZIndex() {
        return this.mZIndex;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    public final com.amap.api.maps.model.TileOverlayOptions memCacheSize(int i) {
        this.memCacheSize = i;
        return this;
    }

    public final com.amap.api.maps.model.TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.memoryCacheEnabled = z;
        return this;
    }

    public final com.amap.api.maps.model.TileOverlayOptions tileProvider(com.amap.api.maps.model.TileProvider tileProvider) {
        this._tileProvider = tileProvider;
        this.mTileProvider = new com.autonavi.base.ae.gmap.bean.TileProviderInner(tileProvider);
        return this;
    }

    public final com.amap.api.maps.model.TileOverlayOptions visible(boolean z) {
        this.mVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeValue(this.mTileProvider);
        parcel.writeByte(this.mVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.mZIndex);
        parcel.writeInt(this.memCacheSize);
        parcel.writeLong(this.diskCacheSize);
        parcel.writeString(this.diskCacheDir);
        parcel.writeByte(this.memoryCacheEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.diskCacheEnabled ? (byte) 1 : (byte) 0);
    }

    public final com.amap.api.maps.model.TileOverlayOptions zIndex(float f) {
        this.mZIndex = f;
        return this;
    }
}
