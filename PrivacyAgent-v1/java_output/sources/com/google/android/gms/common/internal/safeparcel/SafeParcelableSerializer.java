package com.google.android.gms.common.internal.safeparcel;

@com.google.android.gms.common.util.VisibleForTesting
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class SafeParcelableSerializer {
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> T deserializeFromBytes(@androidx.annotation.RecentlyNonNull byte[] bArr, @androidx.annotation.RecentlyNonNull android.os.Parcelable.Creator<T> creator) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(creator);
        android.os.Parcel obtain = android.os.Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> T deserializeFromIntentExtra(@androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.os.Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (T) deserializeFromBytes(byteArrayExtra, creator);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> T deserializeFromString(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.os.Parcelable.Creator<T> creator) {
        return (T) deserializeFromBytes(com.google.android.gms.common.util.Base64Utils.decodeUrlSafe(str), creator);
    }

    @androidx.annotation.RecentlyNullable
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> java.util.ArrayList<T> deserializeIterableFromBundle(@androidx.annotation.RecentlyNonNull android.os.Bundle bundle, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.os.Parcelable.Creator<T> creator) {
        java.util.ArrayList arrayList = (java.util.ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        com.xiaomi.push.service.cd cdVar = (java.util.ArrayList<T>) new java.util.ArrayList(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            cdVar.add(deserializeFromBytes((byte[]) obj, creator));
        }
        return cdVar;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> java.util.ArrayList<T> deserializeIterableFromIntentExtra(@androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.os.Parcelable.Creator<T> creator) {
        java.util.ArrayList arrayList = (java.util.ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        com.xiaomi.push.service.cd cdVar = (java.util.ArrayList<T>) new java.util.ArrayList(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            cdVar.add(deserializeFromBytes((byte[]) obj, creator));
        }
        return cdVar;
    }

    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> void serializeIterableToBundle(@androidx.annotation.RecentlyNonNull java.lang.Iterable<T> iterable, @androidx.annotation.RecentlyNonNull android.os.Bundle bundle, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        bundle.putSerializable(str, arrayList);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> void serializeIterableToIntentExtra(@androidx.annotation.RecentlyNonNull java.lang.Iterable<T> iterable, @androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes(it.next()));
        }
        intent.putExtra(str, arrayList);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> byte[] serializeToBytes(@androidx.annotation.RecentlyNonNull T t) {
        android.os.Parcel obtain = android.os.Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> void serializeToIntentExtra(@androidx.annotation.RecentlyNonNull T t, @androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        intent.putExtra(str, serializeToBytes(t));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> java.lang.String serializeToString(@androidx.annotation.RecentlyNonNull T t) {
        return com.google.android.gms.common.util.Base64Utils.encodeUrlSafe(serializeToBytes(t));
    }
}
