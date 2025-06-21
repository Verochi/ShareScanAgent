package androidx.versionedparcelable;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class VersionedParcelStream extends androidx.versionedparcelable.VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final java.nio.charset.Charset UTF_16 = java.nio.charset.Charset.forName("UTF-16");
    int mCount;
    private java.io.DataInputStream mCurrentInput;
    private java.io.DataOutputStream mCurrentOutput;
    private androidx.versionedparcelable.VersionedParcelStream.FieldBuffer mFieldBuffer;
    private int mFieldId;
    int mFieldSize;
    private boolean mIgnoreParcelables;
    private final java.io.DataInputStream mMasterInput;
    private final java.io.DataOutputStream mMasterOutput;

    /* renamed from: androidx.versionedparcelable.VersionedParcelStream$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.FilterInputStream {
        public AnonymousClass1(java.io.InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws java.io.IOException {
            androidx.versionedparcelable.VersionedParcelStream versionedParcelStream = androidx.versionedparcelable.VersionedParcelStream.this;
            int i = versionedParcelStream.mFieldSize;
            if (i != -1 && versionedParcelStream.mCount >= i) {
                throw new java.io.IOException();
            }
            int read = super.read();
            androidx.versionedparcelable.VersionedParcelStream.this.mCount++;
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
            androidx.versionedparcelable.VersionedParcelStream versionedParcelStream = androidx.versionedparcelable.VersionedParcelStream.this;
            int i3 = versionedParcelStream.mFieldSize;
            if (i3 != -1 && versionedParcelStream.mCount >= i3) {
                throw new java.io.IOException();
            }
            int read = super.read(bArr, i, i2);
            if (read > 0) {
                androidx.versionedparcelable.VersionedParcelStream.this.mCount += read;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws java.io.IOException {
            androidx.versionedparcelable.VersionedParcelStream versionedParcelStream = androidx.versionedparcelable.VersionedParcelStream.this;
            int i = versionedParcelStream.mFieldSize;
            if (i != -1 && versionedParcelStream.mCount >= i) {
                throw new java.io.IOException();
            }
            long skip = super.skip(j);
            if (skip > 0) {
                androidx.versionedparcelable.VersionedParcelStream.this.mCount += (int) skip;
            }
            return skip;
        }
    }

    public static class FieldBuffer {
        final java.io.DataOutputStream mDataStream;
        private final int mFieldId;
        final java.io.ByteArrayOutputStream mOutput;
        private final java.io.DataOutputStream mTarget;

        public FieldBuffer(int i, java.io.DataOutputStream dataOutputStream) {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            this.mOutput = byteArrayOutputStream;
            this.mDataStream = new java.io.DataOutputStream(byteArrayOutputStream);
            this.mFieldId = i;
            this.mTarget = dataOutputStream;
        }

        public void flushField() throws java.io.IOException {
            this.mDataStream.flush();
            int size = this.mOutput.size();
            this.mTarget.writeInt((this.mFieldId << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.mTarget.writeInt(size);
            }
            this.mOutput.writeTo(this.mTarget);
        }
    }

    public VersionedParcelStream(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        this(inputStream, outputStream, new androidx.collection.ArrayMap(), new androidx.collection.ArrayMap(), new androidx.collection.ArrayMap());
    }

    private VersionedParcelStream(java.io.InputStream inputStream, java.io.OutputStream outputStream, androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> arrayMap, androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> arrayMap2, androidx.collection.ArrayMap<java.lang.String, java.lang.Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        java.io.DataInputStream dataInputStream = inputStream != null ? new java.io.DataInputStream(new androidx.versionedparcelable.VersionedParcelStream.AnonymousClass1(inputStream)) : null;
        this.mMasterInput = dataInputStream;
        java.io.DataOutputStream dataOutputStream = outputStream != null ? new java.io.DataOutputStream(outputStream) : null;
        this.mMasterOutput = dataOutputStream;
        this.mCurrentInput = dataInputStream;
        this.mCurrentOutput = dataOutputStream;
    }

    private void readObject(int i, java.lang.String str, android.os.Bundle bundle) {
        switch (i) {
            case 0:
                bundle.putParcelable(str, null);
                return;
            case 1:
                bundle.putBundle(str, readBundle());
                return;
            case 2:
                bundle.putBundle(str, readBundle());
                return;
            case 3:
                bundle.putString(str, readString());
                return;
            case 4:
                bundle.putStringArray(str, (java.lang.String[]) readArray(new java.lang.String[0]));
                return;
            case 5:
                bundle.putBoolean(str, readBoolean());
                return;
            case 6:
                bundle.putBooleanArray(str, readBooleanArray());
                return;
            case 7:
                bundle.putDouble(str, readDouble());
                return;
            case 8:
                bundle.putDoubleArray(str, readDoubleArray());
                return;
            case 9:
                bundle.putInt(str, readInt());
                return;
            case 10:
                bundle.putIntArray(str, readIntArray());
                return;
            case 11:
                bundle.putLong(str, readLong());
                return;
            case 12:
                bundle.putLongArray(str, readLongArray());
                return;
            case 13:
                bundle.putFloat(str, readFloat());
                return;
            case 14:
                bundle.putFloatArray(str, readFloatArray());
                return;
            default:
                throw new java.lang.RuntimeException("Unknown type " + i);
        }
    }

    private void writeObject(java.lang.Object obj) {
        if (obj == null) {
            writeInt(0);
            return;
        }
        if (obj instanceof android.os.Bundle) {
            writeInt(1);
            writeBundle((android.os.Bundle) obj);
            return;
        }
        if (obj instanceof java.lang.String) {
            writeInt(3);
            writeString((java.lang.String) obj);
            return;
        }
        if (obj instanceof java.lang.String[]) {
            writeInt(4);
            writeArray((java.lang.String[]) obj);
            return;
        }
        if (obj instanceof java.lang.Boolean) {
            writeInt(5);
            writeBoolean(((java.lang.Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
            return;
        }
        if (obj instanceof java.lang.Double) {
            writeInt(7);
            writeDouble(((java.lang.Double) obj).doubleValue());
            return;
        }
        if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
            return;
        }
        if (obj instanceof java.lang.Integer) {
            writeInt(9);
            writeInt(((java.lang.Integer) obj).intValue());
            return;
        }
        if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
            return;
        }
        if (obj instanceof java.lang.Long) {
            writeInt(11);
            writeLong(((java.lang.Long) obj).longValue());
            return;
        }
        if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
            return;
        }
        if (obj instanceof java.lang.Float) {
            writeInt(13);
            writeFloat(((java.lang.Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            writeFloatArray((float[]) obj);
        } else {
            throw new java.lang.IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        androidx.versionedparcelable.VersionedParcelStream.FieldBuffer fieldBuffer = this.mFieldBuffer;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.mOutput.size() != 0) {
                    this.mFieldBuffer.flushField();
                }
                this.mFieldBuffer = null;
            } catch (java.io.IOException e) {
                throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public androidx.versionedparcelable.VersionedParcel createSubParcel() {
        return new androidx.versionedparcelable.VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        try {
            return this.mCurrentInput.readBoolean();
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public android.os.Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        for (int i = 0; i < readInt; i++) {
            readObject(readInt(), readString(), bundle);
        }
        return bundle;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.mCurrentInput.readFully(bArr);
            return bArr;
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public java.lang.CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        try {
            return this.mCurrentInput.readDouble();
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i) {
        while (true) {
            try {
                int i2 = this.mFieldId;
                if (i2 == i) {
                    return true;
                }
                if (java.lang.String.valueOf(i2).compareTo(java.lang.String.valueOf(i)) > 0) {
                    return false;
                }
                if (this.mCount < this.mFieldSize) {
                    this.mMasterInput.skip(r2 - r1);
                }
                this.mFieldSize = -1;
                int readInt = this.mMasterInput.readInt();
                this.mCount = 0;
                int i3 = readInt & 65535;
                if (i3 == 65535) {
                    i3 = this.mMasterInput.readInt();
                }
                this.mFieldId = (readInt >> 16) & 65535;
                this.mFieldSize = i3;
            } catch (java.io.IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        try {
            return this.mCurrentInput.readFloat();
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        try {
            return this.mCurrentInput.readInt();
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        try {
            return this.mCurrentInput.readLong();
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends android.os.Parcelable> T readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public java.lang.String readString() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.mCurrentInput.readFully(bArr);
            return new java.lang.String(bArr, UTF_16);
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public android.os.IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i) {
        closeField();
        androidx.versionedparcelable.VersionedParcelStream.FieldBuffer fieldBuffer = new androidx.versionedparcelable.VersionedParcelStream.FieldBuffer(i, this.mMasterOutput);
        this.mFieldBuffer = fieldBuffer;
        this.mCurrentOutput = fieldBuffer.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean z, boolean z2) {
        if (!z) {
            throw new java.lang.RuntimeException("Serialization of this object is not allowed");
        }
        this.mIgnoreParcelables = z2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z) {
        try {
            this.mCurrentOutput.writeBoolean(z);
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(android.os.Bundle bundle) {
        try {
            if (bundle == null) {
                this.mCurrentOutput.writeInt(-1);
                return;
            }
            java.util.Set<java.lang.String> keySet = bundle.keySet();
            this.mCurrentOutput.writeInt(keySet.size());
            for (java.lang.String str : keySet) {
                writeString(str);
                writeObject(bundle.get(str));
            }
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        try {
            if (bArr != null) {
                this.mCurrentOutput.writeInt(bArr.length);
                this.mCurrentOutput.write(bArr);
            } else {
                this.mCurrentOutput.writeInt(-1);
            }
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i, int i2) {
        try {
            if (bArr != null) {
                this.mCurrentOutput.writeInt(i2);
                this.mCurrentOutput.write(bArr, i, i2);
            } else {
                this.mCurrentOutput.writeInt(-1);
            }
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(java.lang.CharSequence charSequence) {
        if (!this.mIgnoreParcelables) {
            throw new java.lang.RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d) {
        try {
            this.mCurrentOutput.writeDouble(d);
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f) {
        try {
            this.mCurrentOutput.writeFloat(f);
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i) {
        try {
            this.mCurrentOutput.writeInt(i);
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j) {
        try {
            this.mCurrentOutput.writeLong(j);
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(android.os.Parcelable parcelable) {
        if (!this.mIgnoreParcelables) {
            throw new java.lang.RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(java.lang.String str) {
        try {
            if (str != null) {
                byte[] bytes = str.getBytes(UTF_16);
                this.mCurrentOutput.writeInt(bytes.length);
                this.mCurrentOutput.write(bytes);
            } else {
                this.mCurrentOutput.writeInt(-1);
            }
        } catch (java.io.IOException e) {
            throw new androidx.versionedparcelable.VersionedParcel.ParcelException(e);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(android.os.IBinder iBinder) {
        if (!this.mIgnoreParcelables) {
            throw new java.lang.RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(android.os.IInterface iInterface) {
        if (!this.mIgnoreParcelables) {
            throw new java.lang.RuntimeException("Binders cannot be written to an OutputStream");
        }
    }
}
