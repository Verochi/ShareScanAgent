package com.huawei.hms.common.internal.safeparcel;

/* loaded from: classes22.dex */
public class SafeParcelReader {
    private static final int BIT16_MARK = 65535;
    private static final int FIELD_ID_CHECKER = 20293;
    private static final int MAX_ARRAY_LENGTH = 1024;
    private static final int NEGATIVE_MARK = -65536;
    private static final int OFFSET16 = 16;

    public static class ParseException extends java.lang.RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ParseException(java.lang.String str, android.os.Parcel parcel) {
            super(r0.toString());
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(java.lang.String.valueOf(str).length() + 41);
            stringBuffer.append(str);
            stringBuffer.append(" Parcel: pos=");
            stringBuffer.append(parcel.dataPosition());
            stringBuffer.append(" size=");
            stringBuffer.append(parcel.dataSize());
        }
    }

    private SafeParcelReader() {
    }

    public static java.math.BigDecimal createBigDecimal(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(readSize + dataPosition);
        return new java.math.BigDecimal(new java.math.BigInteger(createByteArray), readInt);
    }

    public static java.math.BigDecimal[] createBigDecimalArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new java.math.BigDecimal[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        java.math.BigDecimal[] bigDecimalArr = new java.math.BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigDecimalArr[i2] = new java.math.BigDecimal(new java.math.BigInteger(parcel.createByteArray()), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigDecimalArr;
    }

    public static java.math.BigInteger createBigInteger(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        return new java.math.BigInteger(createByteArray);
    }

    public static java.math.BigInteger[] createBigIntegerArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new java.math.BigInteger[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        java.math.BigInteger[] bigIntegerArr = new java.math.BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new java.math.BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigIntegerArr;
    }

    public static boolean[] createBooleanArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new boolean[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createBooleanArray;
    }

    public static java.util.ArrayList<java.lang.Boolean> createBooleanList(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.util.ArrayList<java.lang.Boolean> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Boolean.valueOf(parcel.readInt() != 0));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static android.os.Bundle createBundle(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.os.Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(readSize + dataPosition);
        return readBundle;
    }

    public static byte[] createByteArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new byte[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createByteArray;
    }

    public static byte[][] createByteArrayArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bArr;
    }

    public static android.util.SparseArray<byte[]> createByteArraySparseArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        android.util.SparseArray<byte[]> sparseArray = new android.util.SparseArray<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static char[] createCharArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new char[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createCharArray;
    }

    public static double[] createDoubleArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new double[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createDoubleArray;
    }

    public static java.util.ArrayList<java.lang.Double> createDoubleList(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.util.ArrayList<java.lang.Double> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static android.util.SparseArray<java.lang.Double> createDoubleSparseArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.util.SparseArray<java.lang.Double> sparseArray = new android.util.SparseArray<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), java.lang.Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static float[] createFloatArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new float[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createFloatArray;
    }

    public static java.util.ArrayList<java.lang.Float> createFloatList(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.util.ArrayList<java.lang.Float> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static android.util.SparseArray<java.lang.Float> createFloatSparseArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.util.SparseArray<java.lang.Float> sparseArray = new android.util.SparseArray<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), java.lang.Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static android.os.IBinder[] createIBinderArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new android.os.IBinder[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.os.IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createBinderArray;
    }

    public static java.util.ArrayList<android.os.IBinder> createIBinderList(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.util.ArrayList<android.os.IBinder> createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        return createBinderArrayList;
    }

    public static android.util.SparseArray<android.os.IBinder> createIBinderSparseArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        android.util.SparseArray<android.os.IBinder> sparseArray = new android.util.SparseArray<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static int[] createIntArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new int[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createIntArray;
    }

    public static java.util.ArrayList<java.lang.Integer> createIntegerList(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.util.ArrayList<java.lang.Integer> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static long[] createLongArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new long[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createLongArray;
    }

    public static java.util.ArrayList<java.lang.Long> createLongList(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.util.ArrayList<java.lang.Long> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static android.os.Parcel createParcel(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.os.Parcel obtain = android.os.Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, readSize);
        parcel.setDataPosition(readSize + dataPosition);
        return obtain;
    }

    public static android.os.Parcel[] createParcelArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new android.os.Parcel[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        android.os.Parcel[] parcelArr = new android.os.Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 == 0) {
                parcelArr[i2] = null;
            } else {
                int dataPosition2 = parcel.dataPosition();
                ensureDataPositionValid(parcel, readInt2, dataPosition2);
                android.os.Parcel obtain = android.os.Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return parcelArr;
    }

    public static java.util.ArrayList<android.os.Parcel> createParcelList(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        java.util.ArrayList<android.os.Parcel> arrayList = new java.util.ArrayList<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 == 0) {
                arrayList.add(null);
            } else {
                int dataPosition2 = parcel.dataPosition();
                ensureDataPositionValid(parcel, readInt2, dataPosition2);
                android.os.Parcel obtain = android.os.Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(readInt2 + dataPosition2);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static android.util.SparseArray<android.os.Parcel> createParcelSparseArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        android.util.SparseArray<android.os.Parcel> sparseArray = new android.util.SparseArray<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 == 0) {
                sparseArray.append(readInt2, null);
            } else {
                int dataPosition2 = parcel.dataPosition();
                ensureDataPositionValid(parcel, readInt3, dataPosition2);
                android.os.Parcel obtain = android.os.Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static <P extends android.os.Parcelable> P createParcelable(android.os.Parcel parcel, int i, android.os.Parcelable.Creator<P> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        P createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(readSize + dataPosition);
        return createFromParcel;
    }

    public static android.util.SparseBooleanArray createSparseBooleanArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.util.SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(readSize + dataPosition);
        return readSparseBooleanArray;
    }

    public static android.util.SparseIntArray createSparseIntArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseIntArray;
    }

    public static android.util.SparseLongArray createSparseLongArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.util.SparseLongArray sparseLongArray = new android.util.SparseLongArray();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseLongArray.append(parcel.readInt(), parcel.readLong());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseLongArray;
    }

    public static java.lang.String createString(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.lang.String readString = parcel.readString();
        parcel.setDataPosition(readSize + dataPosition);
        return readString;
    }

    public static java.lang.String[] createStringArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return new java.lang.String[0];
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.lang.String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(readSize + dataPosition);
        return createStringArray;
    }

    public static java.util.ArrayList<java.lang.String> createStringList(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.util.ArrayList<java.lang.String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(readSize + dataPosition);
        return createStringArrayList;
    }

    public static android.util.SparseArray<java.lang.String> createStringSparseArray(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.util.SparseArray<java.lang.String> sparseArray = new android.util.SparseArray<>();
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static <C> C[] createTypedArray(android.os.Parcel parcel, int i, android.os.Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return creator.newArray(0);
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        C[] cArr = (C[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(readSize + dataPosition);
        return cArr;
    }

    public static <C> java.util.ArrayList<C> createTypedList(android.os.Parcel parcel, int i, android.os.Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        java.util.ArrayList<C> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(readSize + dataPosition);
        return createTypedArrayList;
    }

    public static <C> android.util.SparseArray<C> createTypedSparseArray(android.os.Parcel parcel, int i, android.os.Parcelable.Creator<C> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        int readInt = parcel.readInt();
        ensureArrayLengthValid(parcel, readInt);
        android.util.SparseArray<C> sparseArray = new android.util.SparseArray<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    private static void ensureArrayLengthValid(android.os.Parcel parcel, int i) {
        if (i > 1024) {
            throw new com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException("arraySize cannot be beyond 65535", parcel);
        }
    }

    public static void ensureAtEnd(android.os.Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        throw new com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException("Overread allowed size end=" + i, parcel);
    }

    private static void ensureDataPositionValid(android.os.Parcel parcel, int i, int i2) {
        if (i < 0 || isOutOfIntBoundary(i, i2)) {
            throw new com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException("dataPosition cannot be beyond integer scope", parcel);
        }
    }

    public static int getFieldId(int i) {
        return i & 65535;
    }

    private static boolean isOutOfIntBoundary(int i, int i2) {
        long j = i + i2;
        return j > 2147483647L || j < -2147483648L;
    }

    public static boolean readBoolean(android.os.Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static java.lang.Boolean readBooleanObject(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return java.lang.Boolean.FALSE;
        }
        sizeChecker(parcel, i, readSize, 4);
        return java.lang.Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte readByte(android.os.Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static char readChar(android.os.Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return (char) parcel.readInt();
    }

    public static double readDouble(android.os.Parcel parcel, int i) {
        sizeChecker(parcel, i, 8);
        return parcel.readDouble();
    }

    public static java.lang.Double readDoubleObject(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        sizeChecker(parcel, i, readSize, 8);
        return java.lang.Double.valueOf(parcel.readDouble());
    }

    public static float readFloat(android.os.Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return parcel.readFloat();
    }

    public static java.lang.Float readFloatObject(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        sizeChecker(parcel, i, readSize, 4);
        return java.lang.Float.valueOf(parcel.readFloat());
    }

    public static int readHeader(android.os.Parcel parcel) {
        return parcel.readInt();
    }

    public static android.os.IBinder readIBinder(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ensureDataPositionValid(parcel, readSize, dataPosition);
        android.os.IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(readSize + dataPosition);
        return readStrongBinder;
    }

    public static int readInt(android.os.Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return parcel.readInt();
    }

    public static java.lang.Integer readIntegerObject(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        sizeChecker(parcel, i, readSize, 4);
        return java.lang.Integer.valueOf(parcel.readInt());
    }

    public static void readList(android.os.Parcel parcel, int i, java.util.List list, java.lang.ClassLoader classLoader) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize != 0) {
            ensureDataPositionValid(parcel, readSize, dataPosition);
            parcel.readList(list, classLoader);
            parcel.setDataPosition(readSize + dataPosition);
        }
    }

    public static long readLong(android.os.Parcel parcel, int i) {
        sizeChecker(parcel, i, 8);
        return parcel.readLong();
    }

    public static java.lang.Long readLongObject(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        sizeChecker(parcel, i, readSize, 8);
        return java.lang.Long.valueOf(parcel.readLong());
    }

    public static short readShort(android.os.Parcel parcel, int i) {
        sizeChecker(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int readSize(android.os.Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    private static void sizeChecker(android.os.Parcel parcel, int i, int i2) {
        int readSize = readSize(parcel, i);
        if (readSize == i2) {
            return;
        }
        java.lang.String hexString = java.lang.Integer.toHexString(readSize);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(hexString.length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(readSize);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    private static void sizeChecker(android.os.Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        java.lang.String hexString = java.lang.Integer.toHexString(i2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(hexString.length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    public static void skipUnknownField(android.os.Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        ensureDataPositionValid(parcel, readSize, dataPosition);
        parcel.setDataPosition(readSize + dataPosition);
    }

    public static int validateObjectHeader(android.os.Parcel parcel) {
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int dataPosition = parcel.dataPosition();
        if (getFieldId(readHeader) != FIELD_ID_CHECKER) {
            java.lang.String hexString = java.lang.Integer.toHexString(readHeader);
            throw new com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException(hexString.length() != 0 ? "Expected object header. Got 0x".concat(hexString) : "Expected object header. Got 0x", parcel);
        }
        int i = readSize + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ParseException("invalid start=" + dataPosition + " end=" + i, parcel);
    }
}
