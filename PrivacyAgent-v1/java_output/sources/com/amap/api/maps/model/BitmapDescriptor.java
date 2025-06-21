package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public final class BitmapDescriptor implements android.os.Parcelable, java.lang.Cloneable {
    public static final com.amap.api.maps.model.BitmapDescriptorCreator CREATOR = new com.amap.api.maps.model.BitmapDescriptorCreator();
    int a;
    int b;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    protected java.lang.Object mBitmap;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.lang.String mId;

    private BitmapDescriptor(android.graphics.Bitmap bitmap, int i, int i2, java.lang.String str) {
        this.a = i;
        this.b = i2;
        this.mBitmap = bitmap;
        this.mId = str;
    }

    public BitmapDescriptor(android.graphics.Bitmap bitmap, java.lang.String str) {
        this.a = 0;
        this.b = 0;
        if (bitmap != null) {
            try {
                this.a = bitmap.getWidth();
                this.b = bitmap.getHeight();
                if (bitmap.getConfig() == null) {
                    this.mBitmap = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
                } else {
                    this.mBitmap = bitmap.copy(bitmap.getConfig(), true);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.dl.a(th);
                return;
            }
        }
        this.mId = str;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.maps.model.BitmapDescriptor m17clone() {
        try {
            java.lang.Object obj = this.mBitmap;
            return new com.amap.api.maps.model.BitmapDescriptor(((android.graphics.Bitmap) obj).copy(((android.graphics.Bitmap) obj).getConfig(), true), this.a, this.b, this.mId);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(java.lang.Object obj) {
        com.amap.api.maps.model.BitmapDescriptor bitmapDescriptor;
        java.lang.Object obj2;
        java.lang.Object obj3 = this.mBitmap;
        if (obj3 == null || ((android.graphics.Bitmap) obj3).isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (com.amap.api.maps.model.BitmapDescriptor.class == obj.getClass() && (obj2 = (bitmapDescriptor = (com.amap.api.maps.model.BitmapDescriptor) obj).mBitmap) != null && !((android.graphics.Bitmap) obj2).isRecycled() && this.a == bitmapDescriptor.getWidth() && this.b == bitmapDescriptor.getHeight()) {
            try {
                return ((android.graphics.Bitmap) this.mBitmap).sameAs((android.graphics.Bitmap) bitmapDescriptor.mBitmap);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.dl.a(th);
            }
        }
        return false;
    }

    public final android.graphics.Bitmap getBitmap() {
        return (android.graphics.Bitmap) this.mBitmap;
    }

    public final int getHeight() {
        return this.b;
    }

    public final java.lang.String getId() {
        return this.mId;
    }

    public final int getWidth() {
        return this.a;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void recycle() {
        try {
            com.amap.api.mapcore.util.dl.a((android.graphics.Bitmap) this.mBitmap);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeParcelable((android.graphics.Bitmap) this.mBitmap, i);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
    }
}
