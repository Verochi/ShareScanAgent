package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public final class Tile implements android.os.Parcelable {
    public static final com.amap.api.maps.model.b CREATOR = new com.amap.api.maps.model.b();
    private static final com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<com.amap.api.maps.model.Tile> M_POOL = new com.autonavi.ae.gmap.maploader.Pools.SynchronizedPool<>(18);

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public final byte[] data;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public final int height;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private final boolean isBitmap;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private final int mVersionCode;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public final int width;

    public Tile(int i, int i2, int i3, byte[] bArr, boolean z) {
        this.mVersionCode = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
        if (bArr != null) {
            try {
                android.graphics.Bitmap decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                this.bitmapDescriptor = com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(decodeByteArray);
                com.amap.api.mapcore.util.dl.a(decodeByteArray);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        this.isBitmap = z;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr, true);
    }

    public Tile(int i, int i2, byte[] bArr, boolean z) {
        this(1, i, i2, bArr, z);
    }

    public static com.amap.api.maps.model.Tile obtain(int i, int i2, byte[] bArr) {
        com.amap.api.maps.model.Tile acquire = M_POOL.acquire();
        return acquire != null ? acquire : new com.amap.api.maps.model.Tile(i, i2, bArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void recycle() {
        M_POOL.release(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
        parcel.writeInt(this.isBitmap ? 1 : 0);
    }
}
