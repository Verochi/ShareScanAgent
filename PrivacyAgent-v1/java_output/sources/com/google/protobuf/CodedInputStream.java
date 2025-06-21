package com.google.protobuf;

/* loaded from: classes22.dex */
public final class CodedInputStream {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private final java.io.InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private int sizeLimit;
    private int totalBytesRetired;

    private CodedInputStream(java.io.InputStream inputStream) {
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
    }

    private CodedInputStream(byte[] bArr, int i, int i2) {
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.buffer = bArr;
        this.bufferSize = i2 + i;
        this.bufferPos = i;
        this.totalBytesRetired = -i;
        this.input = null;
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static com.google.protobuf.CodedInputStream newInstance(java.io.InputStream inputStream) {
        return new com.google.protobuf.CodedInputStream(inputStream);
    }

    public static com.google.protobuf.CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static com.google.protobuf.CodedInputStream newInstance(byte[] bArr, int i, int i2) {
        com.google.protobuf.CodedInputStream codedInputStream = new com.google.protobuf.CodedInputStream(bArr, i, i2);
        try {
            codedInputStream.pushLimit(i2);
            return codedInputStream;
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw new java.lang.IllegalArgumentException(e);
        }
    }

    public static int readRawVarint32(int i, java.io.InputStream inputStream) throws java.io.IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            i2 |= (read & 127) << i3;
            if ((read & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
    }

    public static int readRawVarint32(java.io.InputStream inputStream) throws java.io.IOException {
        int read = inputStream.read();
        if (read != -1) {
            return readRawVarint32(read, inputStream);
        }
        throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
    }

    private void recomputeBufferSizeAfterLimit() {
        int i = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i;
        int i2 = this.totalBytesRetired + i;
        int i3 = this.currentLimit;
        if (i2 <= i3) {
            this.bufferSizeAfterLimit = 0;
            return;
        }
        int i4 = i2 - i3;
        this.bufferSizeAfterLimit = i4;
        this.bufferSize = i - i4;
    }

    private boolean refillBuffer(boolean z) throws java.io.IOException {
        int i = this.bufferPos;
        int i2 = this.bufferSize;
        if (i < i2) {
            throw new java.lang.IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        int i3 = this.totalBytesRetired;
        if (i3 + i2 == this.currentLimit) {
            if (z) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            return false;
        }
        this.totalBytesRetired = i3 + i2;
        this.bufferPos = 0;
        java.io.InputStream inputStream = this.input;
        int read = inputStream == null ? -1 : inputStream.read(this.buffer);
        this.bufferSize = read;
        if (read == 0 || read < -1) {
            throw new java.lang.IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.bufferSize + "\nThe InputStream implementation is buggy.");
        }
        if (read == -1) {
            this.bufferSize = 0;
            if (z) {
                throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
            }
            return false;
        }
        recomputeBufferSizeAfterLimit();
        int i4 = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
        if (i4 > this.sizeLimit || i4 < 0) {
            throw com.google.protobuf.InvalidProtocolBufferException.sizeLimitExceeded();
        }
        return true;
    }

    public void checkLastTagWas(int i) throws com.google.protobuf.InvalidProtocolBufferException {
        if (this.lastTag != i) {
            throw com.google.protobuf.InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        int i = this.currentLimit;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.totalBytesRetired + this.bufferPos);
    }

    public int getTotalBytesRead() {
        return this.totalBytesRetired + this.bufferPos;
    }

    public boolean isAtEnd() throws java.io.IOException {
        return this.bufferPos == this.bufferSize && !refillBuffer(false);
    }

    public void popLimit(int i) {
        this.currentLimit = i;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i) throws com.google.protobuf.InvalidProtocolBufferException {
        if (i < 0) {
            throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
        }
        int i2 = i + this.totalBytesRetired + this.bufferPos;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
        return i3;
    }

    public boolean readBool() throws java.io.IOException {
        return readRawVarint32() != 0;
    }

    public com.google.protobuf.ByteString readBytes() throws java.io.IOException {
        int readRawVarint32 = readRawVarint32();
        if (readRawVarint32 == 0) {
            return com.google.protobuf.ByteString.EMPTY;
        }
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (readRawVarint32 > i - i2 || readRawVarint32 <= 0) {
            return com.google.protobuf.ByteString.copyFrom(readRawBytes(readRawVarint32));
        }
        com.google.protobuf.ByteString copyFrom = com.google.protobuf.ByteString.copyFrom(this.buffer, i2, readRawVarint32);
        this.bufferPos += readRawVarint32;
        return copyFrom;
    }

    public double readDouble() throws java.io.IOException {
        return java.lang.Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws java.io.IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws java.io.IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws java.io.IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws java.io.IOException {
        return java.lang.Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int i, com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        int i2 = this.recursionDepth;
        if (i2 >= this.recursionLimit) {
            throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.recursionDepth = i2 + 1;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(com.google.protobuf.WireFormat.makeTag(i, 4));
        this.recursionDepth--;
    }

    public int readInt32() throws java.io.IOException {
        return readRawVarint32();
    }

    public long readInt64() throws java.io.IOException {
        return readRawVarint64();
    }

    public void readMessage(com.google.protobuf.MessageLite.Builder builder, com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) throws java.io.IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw com.google.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int pushLimit = pushLimit(readRawVarint32);
        this.recursionDepth++;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(pushLimit);
    }

    public byte readRawByte() throws java.io.IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(true);
        }
        byte[] bArr = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = i + 1;
        return bArr[i];
    }

    public byte[] readRawBytes(int i) throws java.io.IOException {
        if (i < 0) {
            throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.totalBytesRetired;
        int i3 = this.bufferPos;
        int i4 = i2 + i3 + i;
        int i5 = this.currentLimit;
        if (i4 > i5) {
            skipRawBytes((i5 - i2) - i3);
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }
        int i6 = this.bufferSize;
        if (i <= i6 - i3) {
            byte[] bArr = new byte[i];
            java.lang.System.arraycopy(this.buffer, i3, bArr, 0, i);
            this.bufferPos += i;
            return bArr;
        }
        if (i >= 4096) {
            this.totalBytesRetired = i2 + i6;
            this.bufferPos = 0;
            this.bufferSize = 0;
            int i7 = i6 - i3;
            int i8 = i - i7;
            java.util.ArrayList<byte[]> arrayList = new java.util.ArrayList();
            while (i8 > 0) {
                int min = java.lang.Math.min(i8, 4096);
                byte[] bArr2 = new byte[min];
                int i9 = 0;
                while (i9 < min) {
                    java.io.InputStream inputStream = this.input;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i9, min - i9);
                    if (read == -1) {
                        throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += read;
                    i9 += read;
                }
                i8 -= min;
                arrayList.add(bArr2);
            }
            byte[] bArr3 = new byte[i];
            java.lang.System.arraycopy(this.buffer, i3, bArr3, 0, i7);
            for (byte[] bArr4 : arrayList) {
                java.lang.System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
                i7 += bArr4.length;
            }
            return bArr3;
        }
        byte[] bArr5 = new byte[i];
        int i10 = i6 - i3;
        java.lang.System.arraycopy(this.buffer, i3, bArr5, 0, i10);
        this.bufferPos = this.bufferSize;
        refillBuffer(true);
        while (true) {
            int i11 = i - i10;
            int i12 = this.bufferSize;
            if (i11 <= i12) {
                java.lang.System.arraycopy(this.buffer, 0, bArr5, i10, i11);
                this.bufferPos = i11;
                return bArr5;
            }
            java.lang.System.arraycopy(this.buffer, 0, bArr5, i10, i12);
            int i13 = this.bufferSize;
            i10 += i13;
            this.bufferPos = i13;
            refillBuffer(true);
        }
    }

    public int readRawLittleEndian32() throws java.io.IOException {
        return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
    }

    public long readRawLittleEndian64() throws java.io.IOException {
        return ((readRawByte() & 255) << 8) | (readRawByte() & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
    }

    public int readRawVarint32() throws java.io.IOException {
        int i;
        byte readRawByte = readRawByte();
        if (readRawByte >= 0) {
            return readRawByte;
        }
        int i2 = readRawByte & Byte.MAX_VALUE;
        byte readRawByte2 = readRawByte();
        if (readRawByte2 >= 0) {
            i = readRawByte2 << 7;
        } else {
            i2 |= (readRawByte2 & Byte.MAX_VALUE) << 7;
            byte readRawByte3 = readRawByte();
            if (readRawByte3 >= 0) {
                i = readRawByte3 << 14;
            } else {
                i2 |= (readRawByte3 & Byte.MAX_VALUE) << 14;
                byte readRawByte4 = readRawByte();
                if (readRawByte4 < 0) {
                    int i3 = i2 | ((readRawByte4 & Byte.MAX_VALUE) << 21);
                    byte readRawByte5 = readRawByte();
                    int i4 = i3 | (readRawByte5 << com.google.common.base.Ascii.FS);
                    if (readRawByte5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (readRawByte() >= 0) {
                            return i4;
                        }
                    }
                    throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
                }
                i = readRawByte4 << com.google.common.base.Ascii.NAK;
            }
        }
        return i2 | i;
    }

    public long readRawVarint64() throws java.io.IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((readRawByte() & 128) == 0) {
                return j;
            }
        }
        throw com.google.protobuf.InvalidProtocolBufferException.malformedVarint();
    }

    public int readSFixed32() throws java.io.IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws java.io.IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws java.io.IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws java.io.IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public java.lang.String readString() throws java.io.IOException {
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (readRawVarint32 > i - i2 || readRawVarint32 <= 0) {
            return new java.lang.String(readRawBytes(readRawVarint32), "UTF-8");
        }
        java.lang.String str = new java.lang.String(this.buffer, i2, readRawVarint32, "UTF-8");
        this.bufferPos += readRawVarint32;
        return str;
    }

    public int readTag() throws java.io.IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.lastTag = readRawVarint32;
        if (com.google.protobuf.WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
            return this.lastTag;
        }
        throw com.google.protobuf.InvalidProtocolBufferException.invalidTag();
    }

    public int readUInt32() throws java.io.IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws java.io.IOException {
        return readRawVarint64();
    }

    @java.lang.Deprecated
    public void readUnknownGroup(int i, com.google.protobuf.MessageLite.Builder builder) throws java.io.IOException {
        readGroup(i, builder, null);
    }

    public void resetSizeCounter() {
        this.totalBytesRetired = -this.bufferPos;
    }

    public int setRecursionLimit(int i) {
        if (i >= 0) {
            int i2 = this.recursionLimit;
            this.recursionLimit = i;
            return i2;
        }
        throw new java.lang.IllegalArgumentException("Recursion limit cannot be negative: " + i);
    }

    public int setSizeLimit(int i) {
        if (i >= 0) {
            int i2 = this.sizeLimit;
            this.sizeLimit = i;
            return i2;
        }
        throw new java.lang.IllegalArgumentException("Size limit cannot be negative: " + i);
    }

    public boolean skipField(int i) throws java.io.IOException {
        int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            readInt32();
            return true;
        }
        if (tagWireType == 1) {
            readRawLittleEndian64();
            return true;
        }
        if (tagWireType == 2) {
            skipRawBytes(readRawVarint32());
            return true;
        }
        if (tagWireType == 3) {
            skipMessage();
            checkLastTagWas(com.google.protobuf.WireFormat.makeTag(com.google.protobuf.WireFormat.getTagFieldNumber(i), 4));
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType != 5) {
            throw com.google.protobuf.InvalidProtocolBufferException.invalidWireType();
        }
        readRawLittleEndian32();
        return true;
    }

    public void skipMessage() throws java.io.IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag));
    }

    public void skipRawBytes(int i) throws java.io.IOException {
        if (i < 0) {
            throw com.google.protobuf.InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.totalBytesRetired;
        int i3 = this.bufferPos;
        int i4 = i2 + i3 + i;
        int i5 = this.currentLimit;
        if (i4 > i5) {
            skipRawBytes((i5 - i2) - i3);
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
        }
        int i6 = this.bufferSize;
        if (i <= i6 - i3) {
            this.bufferPos = i3 + i;
            return;
        }
        int i7 = i6 - i3;
        this.bufferPos = i6;
        refillBuffer(true);
        while (true) {
            int i8 = i - i7;
            int i9 = this.bufferSize;
            if (i8 <= i9) {
                this.bufferPos = i8;
                return;
            } else {
                i7 += i9;
                this.bufferPos = i9;
                refillBuffer(true);
            }
        }
    }
}
