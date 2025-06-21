package com.google.android.gms.common.internal.safeparcel;

/* loaded from: classes22.dex */
public class SafeParcelWriter {
    public static int a(android.os.Parcel parcel, int i) {
        parcel.writeInt(i | androidx.core.internal.view.SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void b(android.os.Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt(i | (i2 << 16));
        } else {
            parcel.writeInt(i | androidx.core.internal.view.SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i2);
        }
    }

    @androidx.annotation.RecentlyNonNull
    public static int beginObjectHeader(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel) {
        return a(parcel, 20293);
    }

    public static <T extends android.os.Parcelable> void c(android.os.Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void d(android.os.Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void finishObjectHeader(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        d(parcel, i);
    }

    public static void writeBigDecimal(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.math.BigDecimal bigDecimal, @androidx.annotation.RecentlyNonNull boolean z) {
        if (bigDecimal == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            d(parcel, a);
        }
    }

    public static void writeBigDecimalArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.math.BigDecimal[] bigDecimalArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (bigDecimalArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i2 = 0; i2 < length; i2++) {
            parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i2].scale());
        }
        d(parcel, a);
    }

    public static void writeBigInteger(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.math.BigInteger bigInteger, @androidx.annotation.RecentlyNonNull boolean z) {
        if (bigInteger == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeByteArray(bigInteger.toByteArray());
            d(parcel, a);
        }
    }

    public static void writeBigIntegerArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.math.BigInteger[] bigIntegerArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (bigIntegerArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        parcel.writeInt(bigIntegerArr.length);
        for (java.math.BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        d(parcel, a);
    }

    public static void writeBoolean(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull boolean z) {
        b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void writeBooleanArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull boolean[] zArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (zArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeBooleanArray(zArr);
            d(parcel, a);
        }
    }

    public static void writeBooleanList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.Boolean> list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).booleanValue() ? 1 : 0);
        }
        d(parcel, a);
    }

    public static void writeBooleanObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.Boolean bool, @androidx.annotation.RecentlyNonNull boolean z) {
        if (bool != null) {
            b(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void writeBundle(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Bundle bundle, @androidx.annotation.RecentlyNonNull boolean z) {
        if (bundle == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeBundle(bundle);
            d(parcel, a);
        }
    }

    public static void writeByte(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull byte b) {
        b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void writeByteArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull byte[] bArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (bArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeByteArray(bArr);
            d(parcel, a);
        }
    }

    public static void writeByteArrayArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull byte[][] bArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (bArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        d(parcel, a);
    }

    public static void writeByteArraySparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseArray<byte[]> sparseArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseArray == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeByteArray(sparseArray.valueAt(i2));
        }
        d(parcel, a);
    }

    public static void writeChar(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull char c) {
        b(parcel, i, 4);
        parcel.writeInt(c);
    }

    public static void writeCharArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull char[] cArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (cArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeCharArray(cArr);
            d(parcel, a);
        }
    }

    public static void writeDouble(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull double d) {
        b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void writeDoubleArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull double[] dArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (dArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeDoubleArray(dArr);
            d(parcel, a);
        }
    }

    public static void writeDoubleList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.Double> list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeDouble(list.get(i2).doubleValue());
        }
        d(parcel, a);
    }

    public static void writeDoubleObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.Double d, @androidx.annotation.RecentlyNonNull boolean z) {
        if (d != null) {
            b(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void writeDoubleSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseArray<java.lang.Double> sparseArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseArray == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeDouble(sparseArray.valueAt(i2).doubleValue());
        }
        d(parcel, a);
    }

    public static void writeFloat(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull float f) {
        b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void writeFloatArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull float[] fArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (fArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeFloatArray(fArr);
            d(parcel, a);
        }
    }

    public static void writeFloatList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.Float> list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeFloat(list.get(i2).floatValue());
        }
        d(parcel, a);
    }

    public static void writeFloatObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.Float f, @androidx.annotation.RecentlyNonNull boolean z) {
        if (f != null) {
            b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void writeFloatSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseArray<java.lang.Float> sparseArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseArray == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeFloat(sparseArray.valueAt(i2).floatValue());
        }
        d(parcel, a);
    }

    public static void writeIBinder(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.IBinder iBinder, @androidx.annotation.RecentlyNonNull boolean z) {
        if (iBinder == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeStrongBinder(iBinder);
            d(parcel, a);
        }
    }

    public static void writeIBinderArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.IBinder[] iBinderArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (iBinderArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeBinderArray(iBinderArr);
            d(parcel, a);
        }
    }

    public static void writeIBinderList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<android.os.IBinder> list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeBinderList(list);
            d(parcel, a);
        }
    }

    public static void writeIBinderSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseArray<android.os.IBinder> sparseArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseArray == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeStrongBinder(sparseArray.valueAt(i2));
        }
        d(parcel, a);
    }

    public static void writeInt(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull int i2) {
        b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void writeIntArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull int[] iArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (iArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeIntArray(iArr);
            d(parcel, a);
        }
    }

    public static void writeIntegerList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.Integer> list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).intValue());
        }
        d(parcel, a);
    }

    public static void writeIntegerObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.Integer num, @androidx.annotation.RecentlyNonNull boolean z) {
        if (num != null) {
            b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void writeList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeList(list);
            d(parcel, a);
        }
    }

    public static void writeLong(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull long j) {
        b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void writeLongArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull long[] jArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (jArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeLongArray(jArr);
            d(parcel, a);
        }
    }

    public static void writeLongList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.Long> list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeLong(list.get(i2).longValue());
        }
        d(parcel, a);
    }

    public static void writeLongObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.Long l, @androidx.annotation.RecentlyNonNull boolean z) {
        if (l != null) {
            b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            b(parcel, i, 0);
        }
    }

    public static void writeParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcel parcel2, @androidx.annotation.RecentlyNonNull boolean z) {
        if (parcel2 == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            d(parcel, a);
        }
    }

    public static void writeParcelArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcel[] parcelArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (parcelArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        parcel.writeInt(parcelArr.length);
        for (android.os.Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        d(parcel, a);
    }

    public static void writeParcelList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<android.os.Parcel> list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            android.os.Parcel parcel2 = list.get(i2);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        d(parcel, a);
    }

    public static void writeParcelSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseArray<android.os.Parcel> sparseArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseArray == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            android.os.Parcel valueAt = sparseArray.valueAt(i2);
            if (valueAt != null) {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        d(parcel, a);
    }

    public static void writeParcelable(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcelable parcelable, @androidx.annotation.RecentlyNonNull int i2, @androidx.annotation.RecentlyNonNull boolean z) {
        if (parcelable == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            d(parcel, a);
        }
    }

    public static void writeShort(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull short s2) {
        b(parcel, i, 4);
        parcel.writeInt(s2);
    }

    public static void writeSparseBooleanArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseBooleanArray sparseBooleanArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseBooleanArray == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            d(parcel, a);
        }
    }

    public static void writeSparseIntArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseIntArray sparseIntArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseIntArray == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseIntArray.keyAt(i2));
            parcel.writeInt(sparseIntArray.valueAt(i2));
        }
        d(parcel, a);
    }

    public static void writeSparseLongArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseLongArray sparseLongArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseLongArray == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseLongArray.keyAt(i2));
            parcel.writeLong(sparseLongArray.valueAt(i2));
        }
        d(parcel, a);
    }

    public static void writeString(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull boolean z) {
        if (str == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeString(str);
            d(parcel, a);
        }
    }

    public static void writeStringArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.String[] strArr, @androidx.annotation.RecentlyNonNull boolean z) {
        if (strArr == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeStringArray(strArr);
            d(parcel, a);
        }
    }

    public static void writeStringList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.String> list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
            }
        } else {
            int a = a(parcel, i);
            parcel.writeStringList(list);
            d(parcel, a);
        }
    }

    public static void writeStringSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseArray<java.lang.String> sparseArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseArray == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeString(sparseArray.valueAt(i2));
        }
        d(parcel, a);
    }

    public static <T extends android.os.Parcelable> void writeTypedArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull T[] tArr, @androidx.annotation.RecentlyNonNull int i2, @androidx.annotation.RecentlyNonNull boolean z) {
        if (tArr == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                c(parcel, t, i2);
            }
        }
        d(parcel, a);
    }

    public static <T extends android.os.Parcelable> void writeTypedList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List<T> list, @androidx.annotation.RecentlyNonNull boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                c(parcel, t, 0);
            }
        }
        d(parcel, a);
    }

    public static <T extends android.os.Parcelable> void writeTypedSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.util.SparseArray<T> sparseArray, @androidx.annotation.RecentlyNonNull boolean z) {
        if (sparseArray == null) {
            if (z) {
                b(parcel, i, 0);
                return;
            }
            return;
        }
        int a = a(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            T valueAt = sparseArray.valueAt(i2);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                c(parcel, valueAt, 0);
            }
        }
        d(parcel, a);
    }
}
