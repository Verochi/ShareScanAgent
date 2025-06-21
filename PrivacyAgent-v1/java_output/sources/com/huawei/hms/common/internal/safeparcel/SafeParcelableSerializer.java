package com.huawei.hms.common.internal.safeparcel;

/* loaded from: classes22.dex */
public final class SafeParcelableSerializer {
    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> S deserializeFromBytes(byte[] bArr, android.os.Parcelable.Creator<S> creator) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(creator);
        android.os.Parcel obtain = android.os.Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        S createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> S deserializeFromIntentExtra(android.content.Intent intent, java.lang.String str, android.os.Parcelable.Creator<S> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (S) deserializeFromBytes(byteArrayExtra, creator);
    }

    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> S deserializeFromString(java.lang.String str, android.os.Parcelable.Creator<S> creator) {
        return (S) deserializeFromBytes(com.huawei.hms.common.util.Base64Utils.decodeUrlSafe(str), creator);
    }

    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> java.util.ArrayList<S> deserializeIterableFromBundle(android.os.Bundle bundle, java.lang.String str, android.os.Parcelable.Creator<S> creator) {
        java.util.ArrayList arrayList;
        if (bundle == null || (arrayList = (java.util.ArrayList) bundle.getSerializable(str)) == null) {
            return null;
        }
        com.xiaomi.push.service.cd cdVar = (java.util.ArrayList<S>) new java.util.ArrayList(arrayList.size());
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cdVar.add(deserializeFromBytes((byte[]) it.next(), creator));
        }
        return cdVar;
    }

    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> java.util.ArrayList<S> deserializeIterableFromIntentExtra(android.content.Intent intent, java.lang.String str, android.os.Parcelable.Creator<S> creator) {
        java.util.ArrayList arrayList = (java.util.ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        com.xiaomi.push.service.cd cdVar = (java.util.ArrayList<S>) new java.util.ArrayList(arrayList.size());
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cdVar.add(deserializeFromBytes((byte[]) it.next(), creator));
        }
        return cdVar;
    }

    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> void serializeIterableToBundle(java.lang.Iterable<S> iterable, android.os.Bundle bundle, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<S> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        bundle.putSerializable(str, arrayList);
    }

    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> void serializeIterableToIntentExtra(java.lang.Iterable<S> iterable, android.content.Intent intent, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<S> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        intent.putExtra(str, arrayList);
    }

    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> byte[] serializeToBytes(S s2) {
        android.os.Parcel obtain = android.os.Parcel.obtain();
        s2.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> void serializeToIntentExtra(S s2, android.content.Intent intent, java.lang.String str) {
        intent.putExtra(str, serializeToBytes(s2));
    }

    public static <S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> java.lang.String serializeToString(S s2) {
        return com.huawei.hms.common.util.Base64Utils.encodeUrlSafe(serializeToBytes(s2));
    }
}
