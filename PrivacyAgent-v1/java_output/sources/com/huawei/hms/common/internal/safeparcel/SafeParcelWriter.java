package com.huawei.hms.common.internal.safeparcel;

/* loaded from: classes22.dex */
public class SafeParcelWriter {
    private static final int BIT16_MARK = 65535;
    private static final int FIELD_ID_CHECKER = 20293;
    private static final int NEGATIVE_MARK = -65536;
    private static final int OFFSET16 = 16;

    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(android.os.Parcel parcel) {
        return getStartPosition(parcel, FIELD_ID_CHECKER);
    }

    public static void finishObjectHeader(android.os.Parcel parcel, int i) {
        handleDataOver(parcel, i);
    }

    private static int getStartPosition(android.os.Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void handleDataOver(android.os.Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    private static void setHeader(android.os.Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt(i | (i2 << 16));
        } else {
            parcel.writeInt(i | (-65536));
            parcel.writeInt(i2);
        }
    }

    private static <P extends android.os.Parcelable> void setSizeOfData(android.os.Parcel parcel, P p, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        p.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void writeBigDecimal(android.os.Parcel parcel, int i, java.math.BigDecimal bigDecimal, boolean z) {
        if (bigDecimal == null) {
            if (z) {
                setHeader(parcel, i, 0);
            }
        } else {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            handleDataOver(parcel, startPosition);
        }
    }

    public static void writeBigDecimalArray(android.os.Parcel parcel, int i, java.math.BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i2 = 0; i2 < length; i2++) {
            parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i2].scale());
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeBigInteger(android.os.Parcel parcel, int i, java.math.BigInteger bigInteger, boolean z) {
        if (bigInteger != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeByteArray(bigInteger.toByteArray());
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeBigIntegerArray(android.os.Parcel parcel, int i, java.math.BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        parcel.writeInt(bigIntegerArr.length);
        for (java.math.BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeBoolean(android.os.Parcel parcel, int i, boolean z) {
        setHeader(parcel, i, 4);
        if (z) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }

    public static void writeBooleanArray(android.os.Parcel parcel, int i, boolean[] zArr, boolean z) {
        if (zArr != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeBooleanArray(zArr);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeBooleanList(android.os.Parcel parcel, int i, java.util.List<java.lang.Boolean> list, boolean z) {
        if (list == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).booleanValue() ? 1 : 0);
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeBooleanObject(android.os.Parcel parcel, int i, java.lang.Boolean bool, boolean z) {
        if (bool != null) {
            setHeader(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeBundle(android.os.Parcel parcel, int i, android.os.Bundle bundle, boolean z) {
        if (bundle != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeBundle(bundle);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeByte(android.os.Parcel parcel, int i, byte b) {
        setHeader(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void writeByteArray(android.os.Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeByteArray(bArr);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeByteArrayArray(android.os.Parcel parcel, int i, byte[][] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeByteArraySparseArray(android.os.Parcel parcel, int i, android.util.SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeByteArray(sparseArray.valueAt(i2));
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeChar(android.os.Parcel parcel, int i, char c) {
        setHeader(parcel, i, 4);
        parcel.writeInt(c);
    }

    public static void writeCharArray(android.os.Parcel parcel, int i, char[] cArr, boolean z) {
        if (cArr != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeCharArray(cArr);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeDouble(android.os.Parcel parcel, int i, double d) {
        setHeader(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void writeDoubleArray(android.os.Parcel parcel, int i, double[] dArr, boolean z) {
        if (dArr != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeDoubleArray(dArr);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeDoubleList(android.os.Parcel parcel, int i, java.util.List<java.lang.Double> list, boolean z) {
        if (list == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeDouble(list.get(i2).doubleValue());
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeDoubleObject(android.os.Parcel parcel, int i, java.lang.Double d, boolean z) {
        if (d != null) {
            setHeader(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeDoubleSparseArray(android.os.Parcel parcel, int i, android.util.SparseArray<java.lang.Double> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeDouble(sparseArray.valueAt(i2).doubleValue());
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeFloat(android.os.Parcel parcel, int i, float f) {
        setHeader(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void writeFloatArray(android.os.Parcel parcel, int i, float[] fArr, boolean z) {
        if (fArr != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeFloatArray(fArr);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeFloatList(android.os.Parcel parcel, int i, java.util.List<java.lang.Float> list, boolean z) {
        if (list == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeFloat(list.get(i2).floatValue());
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeFloatObject(android.os.Parcel parcel, int i, java.lang.Float f, boolean z) {
        if (f != null) {
            setHeader(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeFloatSparseArray(android.os.Parcel parcel, int i, android.util.SparseArray<java.lang.Float> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeFloat(sparseArray.valueAt(i2).floatValue());
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeIBinder(android.os.Parcel parcel, int i, android.os.IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeStrongBinder(iBinder);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeIBinderArray(android.os.Parcel parcel, int i, android.os.IBinder[] iBinderArr, boolean z) {
        if (iBinderArr != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeBinderArray(iBinderArr);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeIBinderList(android.os.Parcel parcel, int i, java.util.List<android.os.IBinder> list, boolean z) {
        if (list != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeBinderList(list);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeIBinderSparseArray(android.os.Parcel parcel, int i, android.util.SparseArray<android.os.IBinder> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeStrongBinder(sparseArray.valueAt(i2));
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeInt(android.os.Parcel parcel, int i, int i2) {
        setHeader(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void writeIntArray(android.os.Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeIntArray(iArr);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeIntegerList(android.os.Parcel parcel, int i, java.util.List<java.lang.Integer> list, boolean z) {
        if (list == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(list.get(i2).intValue());
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeIntegerObject(android.os.Parcel parcel, int i, java.lang.Integer num, boolean z) {
        if (num != null) {
            setHeader(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeList(android.os.Parcel parcel, int i, java.util.List list, boolean z) {
        if (list != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeList(list);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeLong(android.os.Parcel parcel, int i, long j) {
        setHeader(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void writeLongArray(android.os.Parcel parcel, int i, long[] jArr, boolean z) {
        if (jArr != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeLongArray(jArr);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeLongList(android.os.Parcel parcel, int i, java.util.List<java.lang.Long> list, boolean z) {
        if (list == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeLong(list.get(i2).longValue());
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeLongObject(android.os.Parcel parcel, int i, java.lang.Long l, boolean z) {
        if (l != null) {
            setHeader(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeParcel(android.os.Parcel parcel, int i, android.os.Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeParcelArray(android.os.Parcel parcel, int i, android.os.Parcel[] parcelArr, boolean z) {
        if (parcelArr == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int length = parcelArr.length;
        parcel.writeInt(length);
        for (int i2 = 0; i2 < length; i2++) {
            android.os.Parcel parcel2 = parcelArr[i2];
            if (parcel2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcel2.dataSize());
                android.os.Parcel parcel3 = parcelArr[i2];
                parcel.appendFrom(parcel3, 0, parcel3.dataSize());
            }
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeParcelList(android.os.Parcel parcel, int i, java.util.List<android.os.Parcel> list, boolean z) {
        if (list == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            android.os.Parcel parcel2 = list.get(i2);
            if (parcel2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            }
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeParcelSparseArray(android.os.Parcel parcel, int i, android.util.SparseArray<android.os.Parcel> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            android.os.Parcel valueAt = sparseArray.valueAt(i2);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            }
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeParcelable(android.os.Parcel parcel, int i, android.os.Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int startPosition = getStartPosition(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeShort(android.os.Parcel parcel, int i, short s2) {
        setHeader(parcel, i, 4);
        parcel.writeInt(s2);
    }

    public static void writeSparseBooleanArray(android.os.Parcel parcel, int i, android.util.SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeSparseIntArray(android.os.Parcel parcel, int i, android.util.SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseIntArray.keyAt(i2));
            parcel.writeInt(sparseIntArray.valueAt(i2));
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeSparseLongArray(android.os.Parcel parcel, int i, android.util.SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseLongArray.keyAt(i2));
            parcel.writeLong(sparseLongArray.valueAt(i2));
        }
        handleDataOver(parcel, startPosition);
    }

    public static void writeString(android.os.Parcel parcel, int i, java.lang.String str, boolean z) {
        if (str != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeString(str);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeStringArray(android.os.Parcel parcel, int i, java.lang.String[] strArr, boolean z) {
        if (strArr != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeStringArray(strArr);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeStringList(android.os.Parcel parcel, int i, java.util.List<java.lang.String> list, boolean z) {
        if (list != null) {
            int startPosition = getStartPosition(parcel, i);
            parcel.writeStringList(list);
            handleDataOver(parcel, startPosition);
        } else if (z) {
            setHeader(parcel, i, 0);
        }
    }

    public static void writeStringSparseArray(android.os.Parcel parcel, int i, android.util.SparseArray<java.lang.String> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            parcel.writeString(sparseArray.valueAt(i2));
        }
        handleDataOver(parcel, startPosition);
    }

    public static <P extends android.os.Parcelable> void writeTypedArray(android.os.Parcel parcel, int i, P[] pArr, int i2, boolean z) {
        if (pArr == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        parcel.writeInt(startPosition);
        for (P p : pArr) {
            if (p != null) {
                setSizeOfData(parcel, p, i2);
            } else {
                parcel.writeInt(0);
            }
        }
        handleDataOver(parcel, startPosition);
    }

    public static <T extends android.os.Parcelable> void writeTypedList(android.os.Parcel parcel, int i, java.util.List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t != null) {
                setSizeOfData(parcel, t, 0);
            } else {
                parcel.writeInt(0);
            }
        }
        handleDataOver(parcel, startPosition);
    }

    public static <T extends android.os.Parcelable> void writeTypedSparseArray(android.os.Parcel parcel, int i, android.util.SparseArray<T> sparseArray, boolean z) {
        if (sparseArray == null) {
            if (z) {
                setHeader(parcel, i, 0);
                return;
            }
            return;
        }
        int startPosition = getStartPosition(parcel, i);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            T valueAt = sparseArray.valueAt(i2);
            if (valueAt != null) {
                setSizeOfData(parcel, valueAt, 0);
            } else {
                parcel.writeInt(0);
            }
        }
        handleDataOver(parcel, startPosition);
    }
}
