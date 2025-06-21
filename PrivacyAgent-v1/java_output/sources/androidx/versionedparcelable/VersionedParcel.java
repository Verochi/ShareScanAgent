package androidx.versionedparcelable;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final java.lang.String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final androidx.collection.ArrayMap<java.lang.String, java.lang.Class> mParcelizerCache;
    protected final androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> mReadCache;
    protected final androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> mWriteCache;

    /* renamed from: androidx.versionedparcelable.VersionedParcel$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.ObjectInputStream {
        public AnonymousClass1(java.io.InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        public java.lang.Class<?> resolveClass(java.io.ObjectStreamClass objectStreamClass) throws java.io.IOException, java.lang.ClassNotFoundException {
            java.lang.Class<?> cls = java.lang.Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
            return cls != null ? cls : super.resolveClass(objectStreamClass);
        }
    }

    public static class ParcelException extends java.lang.RuntimeException {
        public ParcelException(java.lang.Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> arrayMap, androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> arrayMap2, androidx.collection.ArrayMap<java.lang.String, java.lang.Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private java.lang.Exception createException(int i, java.lang.String str) {
        switch (i) {
            case -9:
                return (java.lang.Exception) readParcelable();
            case -8:
            default:
                return new java.lang.RuntimeException("Unknown exception code: " + i + " msg " + str);
            case -7:
                return new java.lang.UnsupportedOperationException(str);
            case -6:
                return new android.os.NetworkOnMainThreadException();
            case -5:
                return new java.lang.IllegalStateException(str);
            case -4:
                return new java.lang.NullPointerException(str);
            case -3:
                return new java.lang.IllegalArgumentException(str);
            case -2:
                return new android.os.BadParcelableException(str);
            case -1:
                return new java.lang.SecurityException(str);
        }
    }

    private java.lang.Class findParcelClass(java.lang.Class<? extends androidx.versionedparcelable.VersionedParcelable> cls) throws java.lang.ClassNotFoundException {
        java.lang.Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        java.lang.Class<?> cls3 = java.lang.Class.forName(java.lang.String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    private java.lang.reflect.Method getReadMethod(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        java.lang.reflect.Method method = this.mReadCache.get(str);
        if (method != null) {
            return method;
        }
        java.lang.System.currentTimeMillis();
        java.lang.reflect.Method declaredMethod = java.lang.Class.forName(str, true, androidx.versionedparcelable.VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", androidx.versionedparcelable.VersionedParcel.class);
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    @androidx.annotation.NonNull
    public static java.lang.Throwable getRootCause(@androidx.annotation.NonNull java.lang.Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T> int getType(T t) {
        if (t instanceof java.lang.String) {
            return 4;
        }
        if (t instanceof android.os.Parcelable) {
            return 2;
        }
        if (t instanceof androidx.versionedparcelable.VersionedParcelable) {
            return 1;
        }
        if (t instanceof java.io.Serializable) {
            return 3;
        }
        if (t instanceof android.os.IBinder) {
            return 5;
        }
        if (t instanceof java.lang.Integer) {
            return 7;
        }
        if (t instanceof java.lang.Float) {
            return 8;
        }
        throw new java.lang.IllegalArgumentException(t.getClass().getName() + " cannot be VersionedParcelled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private java.lang.reflect.Method getWriteMethod(java.lang.Class cls) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
        java.lang.reflect.Method method = this.mWriteCache.get(cls.getName());
        if (method != null) {
            return method;
        }
        java.lang.Class findParcelClass = findParcelClass(cls);
        java.lang.System.currentTimeMillis();
        java.lang.reflect.Method declaredMethod = findParcelClass.getDeclaredMethod("write", cls, androidx.versionedparcelable.VersionedParcel.class);
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private <T, S extends java.util.Collection<T>> S readCollection(S s2) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    s2.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    s2.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    s2.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    s2.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    s2.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return s2;
    }

    private java.lang.Exception readException(int i, java.lang.String str) {
        return createException(i, str);
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(java.util.Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    java.util.Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        writeVersionedParcelable((androidx.versionedparcelable.VersionedParcelable) it.next());
                    }
                    break;
                case 2:
                    java.util.Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        writeParcelable((android.os.Parcelable) it2.next());
                    }
                    break;
                case 3:
                    java.util.Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        writeSerializable((java.io.Serializable) it3.next());
                    }
                    break;
                case 4:
                    java.util.Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        writeString((java.lang.String) it4.next());
                    }
                    break;
                case 5:
                    java.util.Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        writeStrongBinder((android.os.IBinder) it5.next());
                    }
                    break;
                case 7:
                    java.util.Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        writeInt(((java.lang.Integer) it6.next()).intValue());
                    }
                    break;
                case 8:
                    java.util.Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        writeFloat(((java.lang.Float) it7.next()).floatValue());
                    }
                    break;
            }
        }
    }

    private <T> void writeCollection(java.util.Collection<T> collection, int i) {
        setOutputField(i);
        writeCollection(collection);
    }

    private void writeSerializable(java.io.Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        java.lang.String name = serializable.getClass().getName();
        writeString(name);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(androidx.versionedparcelable.VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public abstract void closeField();

    public abstract androidx.versionedparcelable.VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public <T> T[] readArray(T[] tArr, int i) {
        return !readField(i) ? tArr : (T[]) readArray(tArr);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z, int i) {
        return !readField(i) ? z : readBoolean();
    }

    public boolean[] readBooleanArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i = 0; i < readInt; i++) {
            zArr[i] = readInt() != 0;
        }
        return zArr;
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i) {
        return !readField(i) ? zArr : readBooleanArray();
    }

    public abstract android.os.Bundle readBundle();

    public android.os.Bundle readBundle(android.os.Bundle bundle, int i) {
        return !readField(i) ? bundle : readBundle();
    }

    public byte readByte(byte b, int i) {
        return !readField(i) ? b : (byte) (readInt() & 255);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i) {
        return !readField(i) ? bArr : readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i) {
        if (!readField(i)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            cArr2[i2] = (char) readInt();
        }
        return cArr2;
    }

    public abstract java.lang.CharSequence readCharSequence();

    public java.lang.CharSequence readCharSequence(java.lang.CharSequence charSequence, int i) {
        return !readField(i) ? charSequence : readCharSequence();
    }

    public abstract double readDouble();

    public double readDouble(double d, int i) {
        return !readField(i) ? d : readDouble();
    }

    public double[] readDoubleArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i = 0; i < readInt; i++) {
            dArr[i] = readDouble();
        }
        return dArr;
    }

    public double[] readDoubleArray(double[] dArr, int i) {
        return !readField(i) ? dArr : readDoubleArray();
    }

    public java.lang.Exception readException(java.lang.Exception exc, int i) {
        int readExceptionCode;
        return (readField(i) && (readExceptionCode = readExceptionCode()) != 0) ? readException(readExceptionCode, readString()) : exc;
    }

    public abstract boolean readField(int i);

    public abstract float readFloat();

    public float readFloat(float f, int i) {
        return !readField(i) ? f : readFloat();
    }

    public float[] readFloatArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i = 0; i < readInt; i++) {
            fArr[i] = readFloat();
        }
        return fArr;
    }

    public float[] readFloatArray(float[] fArr, int i) {
        return !readField(i) ? fArr : readFloatArray();
    }

    public <T extends androidx.versionedparcelable.VersionedParcelable> T readFromParcel(java.lang.String str, androidx.versionedparcelable.VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (java.lang.IllegalAccessException e2) {
            throw new java.lang.RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (java.lang.NoSuchMethodException e3) {
            throw new java.lang.RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            if (e4.getCause() instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) e4.getCause());
            }
            throw new java.lang.RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public abstract int readInt();

    public int readInt(int i, int i2) {
        return !readField(i2) ? i : readInt();
    }

    public int[] readIntArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i = 0; i < readInt; i++) {
            iArr[i] = readInt();
        }
        return iArr;
    }

    public int[] readIntArray(int[] iArr, int i) {
        return !readField(i) ? iArr : readIntArray();
    }

    public <T> java.util.List<T> readList(java.util.List<T> list, int i) {
        return !readField(i) ? list : (java.util.List) readCollection(new java.util.ArrayList());
    }

    public abstract long readLong();

    public long readLong(long j, int i) {
        return !readField(i) ? j : readLong();
    }

    public long[] readLongArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i = 0; i < readInt; i++) {
            jArr[i] = readLong();
        }
        return jArr;
    }

    public long[] readLongArray(long[] jArr, int i) {
        return !readField(i) ? jArr : readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> java.util.Map<K, V> readMap(java.util.Map<K, V> map, int i) {
        if (!readField(i)) {
            return map;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
        if (readInt == 0) {
            return arrayMap;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        readCollection(arrayList);
        readCollection(arrayList2);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayMap.put(arrayList.get(i2), arrayList2.get(i2));
        }
        return arrayMap;
    }

    public abstract <T extends android.os.Parcelable> T readParcelable();

    public <T extends android.os.Parcelable> T readParcelable(T t, int i) {
        return !readField(i) ? t : (T) readParcelable();
    }

    public java.io.Serializable readSerializable() {
        java.lang.String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (java.io.Serializable) new androidx.versionedparcelable.VersionedParcel.AnonymousClass1(new java.io.ByteArrayInputStream(readByteArray())).readObject();
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + readString + ")", e);
        } catch (java.lang.ClassNotFoundException e2) {
            throw new java.lang.RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e2);
        }
    }

    public <T> java.util.Set<T> readSet(java.util.Set<T> set, int i) {
        return !readField(i) ? set : (java.util.Set) readCollection(new androidx.collection.ArraySet());
    }

    @androidx.annotation.RequiresApi(api = 21)
    public android.util.Size readSize(android.util.Size size, int i) {
        if (!readField(i)) {
            return size;
        }
        if (readBoolean()) {
            return new android.util.Size(readInt(), readInt());
        }
        return null;
    }

    @androidx.annotation.RequiresApi(api = 21)
    public android.util.SizeF readSizeF(android.util.SizeF sizeF, int i) {
        if (!readField(i)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new android.util.SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public android.util.SparseBooleanArray readSparseBooleanArray(android.util.SparseBooleanArray sparseBooleanArray, int i) {
        if (!readField(i)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        android.util.SparseBooleanArray sparseBooleanArray2 = new android.util.SparseBooleanArray(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    public abstract java.lang.String readString();

    public java.lang.String readString(java.lang.String str, int i) {
        return !readField(i) ? str : readString();
    }

    public abstract android.os.IBinder readStrongBinder();

    public android.os.IBinder readStrongBinder(android.os.IBinder iBinder, int i) {
        return !readField(i) ? iBinder : readStrongBinder();
    }

    public <T extends androidx.versionedparcelable.VersionedParcelable> T readVersionedParcelable() {
        java.lang.String readString = readString();
        if (readString == null) {
            return null;
        }
        return (T) readFromParcel(readString, createSubParcel());
    }

    public <T extends androidx.versionedparcelable.VersionedParcelable> T readVersionedParcelable(T t, int i) {
        return !readField(i) ? t : (T) readVersionedParcelable();
    }

    public abstract void setOutputField(int i);

    public void setSerializationFlags(boolean z, boolean z2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void writeArray(T[] tArr) {
        if (tArr == 0) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i < length) {
                    writeVersionedParcelable((androidx.versionedparcelable.VersionedParcelable) tArr[i]);
                    i++;
                }
                return;
            }
            if (type == 2) {
                while (i < length) {
                    writeParcelable((android.os.Parcelable) tArr[i]);
                    i++;
                }
                return;
            }
            if (type == 3) {
                while (i < length) {
                    writeSerializable((java.io.Serializable) tArr[i]);
                    i++;
                }
            } else if (type == 4) {
                while (i < length) {
                    writeString((java.lang.String) tArr[i]);
                    i++;
                }
            } else {
                if (type != 5) {
                    return;
                }
                while (i < length) {
                    writeStrongBinder((android.os.IBinder) tArr[i]);
                    i++;
                }
            }
        }
    }

    public <T> void writeArray(T[] tArr, int i) {
        setOutputField(i);
        writeArray(tArr);
    }

    public abstract void writeBoolean(boolean z);

    public void writeBoolean(boolean z, int i) {
        setOutputField(i);
        writeBoolean(z);
    }

    public void writeBooleanArray(boolean[] zArr) {
        if (zArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(zArr.length);
        for (boolean z : zArr) {
            writeInt(z ? 1 : 0);
        }
    }

    public void writeBooleanArray(boolean[] zArr, int i) {
        setOutputField(i);
        writeBooleanArray(zArr);
    }

    public abstract void writeBundle(android.os.Bundle bundle);

    public void writeBundle(android.os.Bundle bundle, int i) {
        setOutputField(i);
        writeBundle(bundle);
    }

    public void writeByte(byte b, int i) {
        setOutputField(i);
        writeInt(b);
    }

    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i) {
        setOutputField(i);
        writeByteArray(bArr);
    }

    public abstract void writeByteArray(byte[] bArr, int i, int i2);

    public void writeByteArray(byte[] bArr, int i, int i2, int i3) {
        setOutputField(i3);
        writeByteArray(bArr, i, i2);
    }

    public void writeCharArray(char[] cArr, int i) {
        setOutputField(i);
        if (cArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(cArr.length);
        for (char c : cArr) {
            writeInt(c);
        }
    }

    public abstract void writeCharSequence(java.lang.CharSequence charSequence);

    public void writeCharSequence(java.lang.CharSequence charSequence, int i) {
        setOutputField(i);
        writeCharSequence(charSequence);
    }

    public abstract void writeDouble(double d);

    public void writeDouble(double d, int i) {
        setOutputField(i);
        writeDouble(d);
    }

    public void writeDoubleArray(double[] dArr) {
        if (dArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(dArr.length);
        for (double d : dArr) {
            writeDouble(d);
        }
    }

    public void writeDoubleArray(double[] dArr, int i) {
        setOutputField(i);
        writeDoubleArray(dArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(java.lang.Exception exc, int i) {
        setOutputField(i);
        if (exc == 0) {
            writeNoException();
            return;
        }
        int i2 = ((exc instanceof android.os.Parcelable) && exc.getClass().getClassLoader() == android.os.Parcelable.class.getClassLoader()) ? -9 : exc instanceof java.lang.SecurityException ? -1 : exc instanceof android.os.BadParcelableException ? -2 : exc instanceof java.lang.IllegalArgumentException ? -3 : exc instanceof java.lang.NullPointerException ? -4 : exc instanceof java.lang.IllegalStateException ? -5 : exc instanceof android.os.NetworkOnMainThreadException ? -6 : exc instanceof java.lang.UnsupportedOperationException ? -7 : 0;
        writeInt(i2);
        if (i2 == 0) {
            if (!(exc instanceof java.lang.RuntimeException)) {
                throw new java.lang.RuntimeException(exc);
            }
            throw ((java.lang.RuntimeException) exc);
        }
        writeString(exc.getMessage());
        if (i2 != -9) {
            return;
        }
        writeParcelable((android.os.Parcelable) exc);
    }

    public abstract void writeFloat(float f);

    public void writeFloat(float f, int i) {
        setOutputField(i);
        writeFloat(f);
    }

    public void writeFloatArray(float[] fArr) {
        if (fArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(fArr.length);
        for (float f : fArr) {
            writeFloat(f);
        }
    }

    public void writeFloatArray(float[] fArr, int i) {
        setOutputField(i);
        writeFloatArray(fArr);
    }

    public abstract void writeInt(int i);

    public void writeInt(int i, int i2) {
        setOutputField(i2);
        writeInt(i);
    }

    public void writeIntArray(int[] iArr) {
        if (iArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(iArr.length);
        for (int i : iArr) {
            writeInt(i);
        }
    }

    public void writeIntArray(int[] iArr, int i) {
        setOutputField(i);
        writeIntArray(iArr);
    }

    public <T> void writeList(java.util.List<T> list, int i) {
        writeCollection(list, i);
    }

    public abstract void writeLong(long j);

    public void writeLong(long j, int i) {
        setOutputField(i);
        writeLong(j);
    }

    public void writeLongArray(long[] jArr) {
        if (jArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(jArr.length);
        for (long j : jArr) {
            writeLong(j);
        }
    }

    public void writeLongArray(long[] jArr, int i) {
        setOutputField(i);
        writeLongArray(jArr);
    }

    public <K, V> void writeMap(java.util.Map<K, V> map, int i) {
        setOutputField(i);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    public void writeNoException() {
        writeInt(0);
    }

    public abstract void writeParcelable(android.os.Parcelable parcelable);

    public void writeParcelable(android.os.Parcelable parcelable, int i) {
        setOutputField(i);
        writeParcelable(parcelable);
    }

    public void writeSerializable(java.io.Serializable serializable, int i) {
        setOutputField(i);
        writeSerializable(serializable);
    }

    public <T> void writeSet(java.util.Set<T> set, int i) {
        writeCollection(set, i);
    }

    @androidx.annotation.RequiresApi(api = 21)
    public void writeSize(android.util.Size size, int i) {
        setOutputField(i);
        writeBoolean(size != null);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @androidx.annotation.RequiresApi(api = 21)
    public void writeSizeF(android.util.SizeF sizeF, int i) {
        setOutputField(i);
        writeBoolean(sizeF != null);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(android.util.SparseBooleanArray sparseBooleanArray, int i) {
        setOutputField(i);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            writeInt(sparseBooleanArray.keyAt(i2));
            writeBoolean(sparseBooleanArray.valueAt(i2));
        }
    }

    public abstract void writeString(java.lang.String str);

    public void writeString(java.lang.String str, int i) {
        setOutputField(i);
        writeString(str);
    }

    public abstract void writeStrongBinder(android.os.IBinder iBinder);

    public void writeStrongBinder(android.os.IBinder iBinder, int i) {
        setOutputField(i);
        writeStrongBinder(iBinder);
    }

    public abstract void writeStrongInterface(android.os.IInterface iInterface);

    public void writeStrongInterface(android.os.IInterface iInterface, int i) {
        setOutputField(i);
        writeStrongInterface(iInterface);
    }

    public <T extends androidx.versionedparcelable.VersionedParcelable> void writeToParcel(T t, androidx.versionedparcelable.VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t.getClass()).invoke(null, t, versionedParcel);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (java.lang.IllegalAccessException e2) {
            throw new java.lang.RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (java.lang.NoSuchMethodException e3) {
            throw new java.lang.RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            if (!(e4.getCause() instanceof java.lang.RuntimeException)) {
                throw new java.lang.RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((java.lang.RuntimeException) e4.getCause());
        }
    }

    public void writeVersionedParcelable(androidx.versionedparcelable.VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        androidx.versionedparcelable.VersionedParcel createSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, createSubParcel);
        createSubParcel.closeField();
    }

    public void writeVersionedParcelable(androidx.versionedparcelable.VersionedParcelable versionedParcelable, int i) {
        setOutputField(i);
        writeVersionedParcelable(versionedParcelable);
    }
}
