package com.google.android.gms.common.internal.safeparcel;

/* loaded from: classes22.dex */
public class SafeParcelReader {

    public static class ParseException extends java.lang.RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ParseException(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.os.Parcel parcel) {
            super(r2.toString());
            int dataPosition = parcel.dataPosition();
            int dataSize = parcel.dataSize();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 41);
            sb.append(str);
            sb.append(" Parcel: pos=");
            sb.append(dataPosition);
            sb.append(" size=");
            sb.append(dataSize);
        }
    }

    public static void a(android.os.Parcel parcel, int i, int i2) {
        int readSize = readSize(parcel, i);
        if (readSize == i2) {
            return;
        }
        java.lang.String hexString = java.lang.Integer.toHexString(readSize);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(readSize);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    public static void b(android.os.Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        java.lang.String hexString = java.lang.Integer.toHexString(i2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @androidx.annotation.RecentlyNonNull
    public static java.math.BigDecimal createBigDecimal(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + readSize);
        return new java.math.BigDecimal(new java.math.BigInteger(createByteArray), readInt);
    }

    @androidx.annotation.RecentlyNonNull
    public static java.math.BigDecimal[] createBigDecimalArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        java.math.BigDecimal[] bigDecimalArr = new java.math.BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new java.math.BigDecimal(new java.math.BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigDecimalArr;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.math.BigInteger createBigInteger(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + readSize);
        return new java.math.BigInteger(createByteArray);
    }

    @androidx.annotation.RecentlyNonNull
    public static java.math.BigInteger[] createBigIntegerArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        java.math.BigInteger[] bigIntegerArr = new java.math.BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new java.math.BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bigIntegerArr;
    }

    @androidx.annotation.RecentlyNonNull
    public static boolean[] createBooleanArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createBooleanArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.util.ArrayList<java.lang.Boolean> createBooleanList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.util.ArrayList<java.lang.Boolean> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Boolean.valueOf(parcel.readInt() != 0));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.os.Bundle createBundle(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.os.Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + readSize);
        return readBundle;
    }

    @androidx.annotation.RecentlyNonNull
    public static byte[] createByteArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createByteArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static byte[][] createByteArrayArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + readSize);
        return bArr;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.util.SparseArray<byte[]> createByteArraySparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        android.util.SparseArray<byte[]> sparseArray = new android.util.SparseArray<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static char[] createCharArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        char[] createCharArray = parcel.createCharArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createCharArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static double[] createDoubleArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createDoubleArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.util.ArrayList<java.lang.Double> createDoubleList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.util.ArrayList<java.lang.Double> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.util.SparseArray<java.lang.Double> createDoubleSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.util.SparseArray<java.lang.Double> sparseArray = new android.util.SparseArray<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), java.lang.Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static float[] createFloatArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createFloatArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.util.ArrayList<java.lang.Float> createFloatList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.util.ArrayList<java.lang.Float> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.util.SparseArray<java.lang.Float> createFloatSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.util.SparseArray<java.lang.Float> sparseArray = new android.util.SparseArray<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), java.lang.Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.os.IBinder[] createIBinderArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.os.IBinder[] createBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createBinderArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.util.ArrayList<android.os.IBinder> createIBinderList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.util.ArrayList<android.os.IBinder> createBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(dataPosition + readSize);
        return createBinderArrayList;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.util.SparseArray<android.os.IBinder> createIBinderSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        android.util.SparseArray<android.os.IBinder> sparseArray = new android.util.SparseArray<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static int[] createIntArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createIntArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.util.ArrayList<java.lang.Integer> createIntegerList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.util.ArrayList<java.lang.Integer> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @androidx.annotation.RecentlyNonNull
    public static long[] createLongArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createLongArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.util.ArrayList<java.lang.Long> createLongList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.util.ArrayList<java.lang.Long> arrayList = new java.util.ArrayList<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(java.lang.Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.os.Parcel createParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.os.Parcel obtain = android.os.Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, readSize);
        parcel.setDataPosition(dataPosition + readSize);
        return obtain;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.os.Parcel[] createParcelArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        android.os.Parcel[] parcelArr = new android.os.Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                android.os.Parcel obtain = android.os.Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return parcelArr;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.util.ArrayList<android.os.Parcel> createParcelList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        java.util.ArrayList<android.os.Parcel> arrayList = new java.util.ArrayList<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                android.os.Parcel obtain = android.os.Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                arrayList.add(obtain);
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                arrayList.add(null);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.util.SparseArray<android.os.Parcel> createParcelSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        android.util.SparseArray<android.os.Parcel> sparseArray = new android.util.SparseArray<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            if (readInt3 != 0) {
                int dataPosition2 = parcel.dataPosition();
                android.os.Parcel obtain = android.os.Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt3);
                sparseArray.append(readInt2, obtain);
                parcel.setDataPosition(dataPosition2 + readInt3);
            } else {
                sparseArray.append(readInt2, null);
            }
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static <T extends android.os.Parcelable> T createParcelable(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + readSize);
        return createFromParcel;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.util.SparseBooleanArray createSparseBooleanArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.util.SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(dataPosition + readSize);
        return readSparseBooleanArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.util.SparseIntArray createSparseIntArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseIntArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.util.SparseLongArray createSparseLongArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.util.SparseLongArray sparseLongArray = new android.util.SparseLongArray();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseLongArray.append(parcel.readInt(), parcel.readLong());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseLongArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.lang.String createString(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.lang.String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + readSize);
        return readString;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.lang.String[] createStringArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.lang.String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createStringArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.util.ArrayList<java.lang.String> createStringList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.util.ArrayList<java.lang.String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + readSize);
        return createStringArrayList;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.util.SparseArray<java.lang.String> createStringSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.util.SparseArray<java.lang.String> sparseArray = new android.util.SparseArray<>();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    @androidx.annotation.RecentlyNonNull
    public static <T> T[] createTypedArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return tArr;
    }

    @androidx.annotation.RecentlyNonNull
    public static <T> java.util.ArrayList<T> createTypedList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        java.util.ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return createTypedArrayList;
    }

    @androidx.annotation.RecentlyNonNull
    public static <T> android.util.SparseArray<T> createTypedSparseArray(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        android.util.SparseArray<T> sparseArray = new android.util.SparseArray<>();
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
        }
        parcel.setDataPosition(dataPosition + readSize);
        return sparseArray;
    }

    public static void ensureAtEnd(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @androidx.annotation.RecentlyNonNull
    public static int getFieldId(@androidx.annotation.RecentlyNonNull int i) {
        return i & 65535;
    }

    @androidx.annotation.RecentlyNonNull
    public static boolean readBoolean(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    @androidx.annotation.RecentlyNonNull
    public static java.lang.Boolean readBooleanObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        b(parcel, i, readSize, 4);
        return java.lang.Boolean.valueOf(parcel.readInt() != 0);
    }

    @androidx.annotation.RecentlyNonNull
    public static byte readByte(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    @androidx.annotation.RecentlyNonNull
    public static char readChar(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        a(parcel, i, 4);
        return (char) parcel.readInt();
    }

    @androidx.annotation.RecentlyNonNull
    public static double readDouble(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        a(parcel, i, 8);
        return parcel.readDouble();
    }

    @androidx.annotation.RecentlyNonNull
    public static java.lang.Double readDoubleObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        b(parcel, i, readSize, 8);
        return java.lang.Double.valueOf(parcel.readDouble());
    }

    @androidx.annotation.RecentlyNonNull
    public static float readFloat(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        a(parcel, i, 4);
        return parcel.readFloat();
    }

    @androidx.annotation.RecentlyNonNull
    public static java.lang.Float readFloatObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        b(parcel, i, readSize, 4);
        return java.lang.Float.valueOf(parcel.readFloat());
    }

    @androidx.annotation.RecentlyNonNull
    public static int readHeader(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel) {
        return parcel.readInt();
    }

    @androidx.annotation.RecentlyNonNull
    public static android.os.IBinder readIBinder(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        android.os.IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + readSize);
        return readStrongBinder;
    }

    @androidx.annotation.RecentlyNonNull
    public static int readInt(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        a(parcel, i, 4);
        return parcel.readInt();
    }

    @androidx.annotation.RecentlyNonNull
    public static java.lang.Integer readIntegerObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        b(parcel, i, readSize, 4);
        return java.lang.Integer.valueOf(parcel.readInt());
    }

    public static void readList(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.util.List list, @androidx.annotation.RecentlyNonNull java.lang.ClassLoader classLoader) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(dataPosition + readSize);
    }

    @androidx.annotation.RecentlyNonNull
    public static long readLong(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        a(parcel, i, 8);
        return parcel.readLong();
    }

    @androidx.annotation.RecentlyNonNull
    public static java.lang.Long readLongObject(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        int readSize = readSize(parcel, i);
        if (readSize == 0) {
            return null;
        }
        b(parcel, i, readSize, 8);
        return java.lang.Long.valueOf(parcel.readLong());
    }

    @androidx.annotation.RecentlyNonNull
    public static short readShort(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    @androidx.annotation.RecentlyNonNull
    public static int readSize(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        return (i & androidx.core.internal.view.SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static void skipUnknownField(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull int i) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i));
    }

    @androidx.annotation.RecentlyNonNull
    public static int validateObjectHeader(@androidx.annotation.RecentlyNonNull android.os.Parcel parcel) {
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int dataPosition = parcel.dataPosition();
        if (getFieldId(readHeader) != 20293) {
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.Integer.toHexString(readHeader));
            throw new com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new java.lang.String("Expected object header. Got 0x"), parcel);
        }
        int i = readSize + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i);
        throw new com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException(sb.toString(), parcel);
    }
}
