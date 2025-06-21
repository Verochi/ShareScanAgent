package com.google.android.gms.common.util;

@com.google.android.gms.common.util.VisibleForTesting
@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class ArrayUtils {
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> T[] appendToArray(@androidx.annotation.RecentlyNonNull T[] tArr, @androidx.annotation.RecentlyNonNull T t) {
        if (tArr == null && t == null) {
            throw new java.lang.IllegalArgumentException("Cannot generate array of generic type w/o class info");
        }
        T[] tArr2 = tArr == null ? (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(t.getClass(), 1)) : (T[]) java.util.Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr2.length - 1] = t;
        return tArr2;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> T[] concat(@androidx.annotation.RecentlyNonNull T[]... tArr) {
        if (tArr.length == 0) {
            return (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass(), 0));
        }
        int i = 0;
        for (T[] tArr2 : tArr) {
            i += tArr2.length;
        }
        T[] tArr3 = (T[]) java.util.Arrays.copyOf(tArr[0], i);
        int length = tArr[0].length;
        for (int i2 = 1; i2 < tArr.length; i2++) {
            T[] tArr4 = tArr[i2];
            java.lang.System.arraycopy(tArr4, 0, tArr3, length, tArr4.length);
            length += tArr4.length;
        }
        return tArr3;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static byte[] concatByteArrays(@androidx.annotation.RecentlyNonNull byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i = 0;
        for (byte[] bArr2 : bArr) {
            i += bArr2.length;
        }
        byte[] copyOf = java.util.Arrays.copyOf(bArr[0], i);
        int length = bArr[0].length;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            byte[] bArr3 = bArr[i2];
            java.lang.System.arraycopy(bArr3, 0, copyOf, length, bArr3.length);
            length += bArr3.length;
        }
        return copyOf;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean contains(@androidx.annotation.RecentlyNonNull int[] iArr, @androidx.annotation.RecentlyNonNull int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> boolean contains(@androidx.annotation.RecentlyNonNull T[] tArr, @androidx.annotation.RecentlyNonNull T t) {
        int length = tArr != null ? tArr.length : 0;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (com.google.android.gms.common.internal.Objects.equal(tArr[i], t)) {
                break;
            }
            i++;
        }
        return i >= 0;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> java.util.ArrayList<T> newArrayList() {
        return new java.util.ArrayList<>();
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> T[] removeAll(@androidx.annotation.RecentlyNonNull T[] tArr, @androidx.annotation.RecentlyNonNull T... tArr2) {
        int i;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || tArr2.length == 0) {
            return (T[]) java.util.Arrays.copyOf(tArr, tArr.length);
        }
        T[] tArr3 = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr2.getClass().getComponentType(), tArr.length));
        if (tArr2.length == 1) {
            i = 0;
            for (T t : tArr) {
                if (!com.google.android.gms.common.internal.Objects.equal(tArr2[0], t)) {
                    tArr3[i] = t;
                    i++;
                }
            }
        } else {
            int i2 = 0;
            for (T t2 : tArr) {
                if (!contains(tArr2, t2)) {
                    tArr3[i2] = t2;
                    i2++;
                }
            }
            i = i2;
        }
        if (tArr3 == null) {
            return null;
        }
        return i != tArr3.length ? (T[]) java.util.Arrays.copyOf(tArr3, i) : tArr3;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> java.util.ArrayList<T> toArrayList(@androidx.annotation.RecentlyNonNull T[] tArr) {
        java.util.ArrayList<T> arrayList = new java.util.ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int[] toPrimitiveArray(@androidx.annotation.RecentlyNonNull java.util.Collection<java.lang.Integer> collection) {
        int i = 0;
        if (collection == null || collection.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        java.util.Iterator<java.lang.Integer> it = collection.iterator();
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.Integer[] toWrapperArray(@androidx.annotation.RecentlyNonNull int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        java.lang.Integer[] numArr = new java.lang.Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = java.lang.Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void writeArray(@androidx.annotation.RecentlyNonNull java.lang.StringBuilder sb, @androidx.annotation.RecentlyNonNull double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(java.lang.Double.toString(dArr[i]));
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void writeArray(@androidx.annotation.RecentlyNonNull java.lang.StringBuilder sb, @androidx.annotation.RecentlyNonNull float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(java.lang.Float.toString(fArr[i]));
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void writeArray(@androidx.annotation.RecentlyNonNull java.lang.StringBuilder sb, @androidx.annotation.RecentlyNonNull int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(java.lang.Integer.toString(iArr[i]));
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void writeArray(@androidx.annotation.RecentlyNonNull java.lang.StringBuilder sb, @androidx.annotation.RecentlyNonNull long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(java.lang.Long.toString(jArr[i]));
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> void writeArray(@androidx.annotation.RecentlyNonNull java.lang.StringBuilder sb, @androidx.annotation.RecentlyNonNull T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(tArr[i]);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void writeArray(@androidx.annotation.RecentlyNonNull java.lang.StringBuilder sb, @androidx.annotation.RecentlyNonNull boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(java.lang.Boolean.toString(zArr[i]));
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void writeStringArray(@androidx.annotation.RecentlyNonNull java.lang.StringBuilder sb, @androidx.annotation.RecentlyNonNull java.lang.String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i]);
            sb.append("\"");
        }
    }
}
