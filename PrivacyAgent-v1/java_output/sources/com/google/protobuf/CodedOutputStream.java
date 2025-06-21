package com.google.protobuf;

/* loaded from: classes22.dex */
public final class CodedOutputStream {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    private final byte[] buffer;
    private final int limit;
    private final java.io.OutputStream output;
    private int position;

    public static class OutOfSpaceException extends java.io.IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(java.io.OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
    }

    private CodedOutputStream(byte[] bArr, int i, int i2) {
        this.output = null;
        this.buffer = bArr;
        this.position = i;
        this.limit = i + i2;
    }

    public static int computeBoolSize(int i, boolean z) {
        return computeTagSize(i) + computeBoolSizeNoTag(z);
    }

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeBytesSize(int i, com.google.protobuf.ByteString byteString) {
        return computeTagSize(i) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(com.google.protobuf.ByteString byteString) {
        return computeRawVarint32Size(byteString.size()) + byteString.size();
    }

    public static int computeDoubleSize(int i, double d) {
        return computeTagSize(i) + computeDoubleSizeNoTag(d);
    }

    public static int computeDoubleSizeNoTag(double d) {
        return 8;
    }

    public static int computeEnumSize(int i, int i2) {
        return computeTagSize(i) + computeEnumSizeNoTag(i2);
    }

    public static int computeEnumSizeNoTag(int i) {
        return computeInt32SizeNoTag(i);
    }

    public static int computeFixed32Size(int i, int i2) {
        return computeTagSize(i) + computeFixed32SizeNoTag(i2);
    }

    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeFixed64Size(int i, long j) {
        return computeTagSize(i) + computeFixed64SizeNoTag(j);
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSize(int i, float f) {
        return computeTagSize(i) + computeFloatSizeNoTag(f);
    }

    public static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    public static int computeGroupSize(int i, com.google.protobuf.MessageLite messageLite) {
        return (computeTagSize(i) * 2) + computeGroupSizeNoTag(messageLite);
    }

    public static int computeGroupSizeNoTag(com.google.protobuf.MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i, int i2) {
        return computeTagSize(i) + computeInt32SizeNoTag(i2);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeRawVarint32Size(i);
        }
        return 10;
    }

    public static int computeInt64Size(int i, long j) {
        return computeTagSize(i) + computeInt64SizeNoTag(j);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    public static int computeMessageSetExtensionSize(int i, com.google.protobuf.MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i, com.google.protobuf.MessageLite messageLite) {
        return computeTagSize(i) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(com.google.protobuf.MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computePreferredBufferSize(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int computeRawMessageSetExtensionSize(int i, com.google.protobuf.ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeBytesSize(3, byteString);
    }

    public static int computeRawVarint32Size(int i) {
        if ((i & com.alipay.sdk.m.n.a.g) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeRawVarint64Size(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32Size(int i, int i2) {
        return computeTagSize(i) + computeSFixed32SizeNoTag(i2);
    }

    public static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeSFixed64Size(int i, long j) {
        return computeTagSize(i) + computeSFixed64SizeNoTag(j);
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeSInt32Size(int i, int i2) {
        return computeTagSize(i) + computeSInt32SizeNoTag(i2);
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeRawVarint32Size(encodeZigZag32(i));
    }

    public static int computeSInt64Size(int i, long j) {
        return computeTagSize(i) + computeSInt64SizeNoTag(j);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeRawVarint64Size(encodeZigZag64(j));
    }

    public static int computeStringSize(int i, java.lang.String str) {
        return computeTagSize(i) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(java.lang.String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static int computeTagSize(int i) {
        return computeRawVarint32Size(com.google.protobuf.WireFormat.makeTag(i, 0));
    }

    public static int computeUInt32Size(int i, int i2) {
        return computeTagSize(i) + computeUInt32SizeNoTag(i2);
    }

    public static int computeUInt32SizeNoTag(int i) {
        return computeRawVarint32Size(i);
    }

    public static int computeUInt64Size(int i, long j) {
        return computeTagSize(i) + computeUInt64SizeNoTag(j);
    }

    public static int computeUInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    @java.lang.Deprecated
    public static int computeUnknownGroupSize(int i, com.google.protobuf.MessageLite messageLite) {
        return computeGroupSize(i, messageLite);
    }

    @java.lang.Deprecated
    public static int computeUnknownGroupSizeNoTag(com.google.protobuf.MessageLite messageLite) {
        return computeGroupSizeNoTag(messageLite);
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static com.google.protobuf.CodedOutputStream newInstance(java.io.OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static com.google.protobuf.CodedOutputStream newInstance(java.io.OutputStream outputStream, int i) {
        return new com.google.protobuf.CodedOutputStream(outputStream, new byte[i]);
    }

    public static com.google.protobuf.CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static com.google.protobuf.CodedOutputStream newInstance(byte[] bArr, int i, int i2) {
        return new com.google.protobuf.CodedOutputStream(bArr, i, i2);
    }

    private void refreshBuffer() throws java.io.IOException {
        java.io.OutputStream outputStream = this.output;
        if (outputStream == null) {
            throw new com.google.protobuf.CodedOutputStream.OutOfSpaceException();
        }
        outputStream.write(this.buffer, 0, this.position);
        this.position = 0;
    }

    public void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new java.lang.IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void flush() throws java.io.IOException {
        if (this.output != null) {
            refreshBuffer();
        }
    }

    public int spaceLeft() {
        if (this.output == null) {
            return this.limit - this.position;
        }
        throw new java.lang.UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void writeBool(int i, boolean z) throws java.io.IOException {
        writeTag(i, 0);
        writeBoolNoTag(z);
    }

    public void writeBoolNoTag(boolean z) throws java.io.IOException {
        writeRawByte(z ? 1 : 0);
    }

    public void writeBytes(int i, com.google.protobuf.ByteString byteString) throws java.io.IOException {
        writeTag(i, 2);
        writeBytesNoTag(byteString);
    }

    public void writeBytesNoTag(com.google.protobuf.ByteString byteString) throws java.io.IOException {
        writeRawVarint32(byteString.size());
        writeRawBytes(byteString);
    }

    public void writeDouble(int i, double d) throws java.io.IOException {
        writeTag(i, 1);
        writeDoubleNoTag(d);
    }

    public void writeDoubleNoTag(double d) throws java.io.IOException {
        writeRawLittleEndian64(java.lang.Double.doubleToRawLongBits(d));
    }

    public void writeEnum(int i, int i2) throws java.io.IOException {
        writeTag(i, 0);
        writeEnumNoTag(i2);
    }

    public void writeEnumNoTag(int i) throws java.io.IOException {
        writeInt32NoTag(i);
    }

    public void writeFixed32(int i, int i2) throws java.io.IOException {
        writeTag(i, 5);
        writeFixed32NoTag(i2);
    }

    public void writeFixed32NoTag(int i) throws java.io.IOException {
        writeRawLittleEndian32(i);
    }

    public void writeFixed64(int i, long j) throws java.io.IOException {
        writeTag(i, 1);
        writeFixed64NoTag(j);
    }

    public void writeFixed64NoTag(long j) throws java.io.IOException {
        writeRawLittleEndian64(j);
    }

    public void writeFloat(int i, float f) throws java.io.IOException {
        writeTag(i, 5);
        writeFloatNoTag(f);
    }

    public void writeFloatNoTag(float f) throws java.io.IOException {
        writeRawLittleEndian32(java.lang.Float.floatToRawIntBits(f));
    }

    public void writeGroup(int i, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        writeTag(i, 3);
        writeGroupNoTag(messageLite);
        writeTag(i, 4);
    }

    public void writeGroupNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        messageLite.writeTo(this);
    }

    public void writeInt32(int i, int i2) throws java.io.IOException {
        writeTag(i, 0);
        writeInt32NoTag(i2);
    }

    public void writeInt32NoTag(int i) throws java.io.IOException {
        if (i >= 0) {
            writeRawVarint32(i);
        } else {
            writeRawVarint64(i);
        }
    }

    public void writeInt64(int i, long j) throws java.io.IOException {
        writeTag(i, 0);
        writeInt64NoTag(j);
    }

    public void writeInt64NoTag(long j) throws java.io.IOException {
        writeRawVarint64(j);
    }

    public void writeMessage(int i, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        writeTag(i, 2);
        writeMessageNoTag(messageLite);
    }

    public void writeMessageNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeMessageSetExtension(int i, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        writeTag(1, 3);
        writeUInt32(2, i);
        writeMessage(3, messageLite);
        writeTag(1, 4);
    }

    public void writeRawByte(byte b) throws java.io.IOException {
        if (this.position == this.limit) {
            refreshBuffer();
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public void writeRawByte(int i) throws java.io.IOException {
        writeRawByte((byte) i);
    }

    public void writeRawBytes(com.google.protobuf.ByteString byteString) throws java.io.IOException {
        writeRawBytes(byteString, 0, byteString.size());
    }

    public void writeRawBytes(com.google.protobuf.ByteString byteString, int i, int i2) throws java.io.IOException {
        int i3 = this.limit;
        int i4 = this.position;
        if (i3 - i4 >= i2) {
            byteString.copyTo(this.buffer, i, i4, i2);
            this.position += i2;
            return;
        }
        int i5 = i3 - i4;
        byteString.copyTo(this.buffer, i, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.position = this.limit;
        refreshBuffer();
        if (i7 <= this.limit) {
            byteString.copyTo(this.buffer, i6, 0, i7);
            this.position = i7;
            return;
        }
        java.io.InputStream newInput = byteString.newInput();
        long j = i6;
        if (j != newInput.skip(j)) {
            throw new java.lang.IllegalStateException("Skip failed? Should never happen.");
        }
        while (i7 > 0) {
            int min = java.lang.Math.min(i7, this.limit);
            int read = newInput.read(this.buffer, 0, min);
            if (read != min) {
                throw new java.lang.IllegalStateException("Read failed? Should never happen");
            }
            this.output.write(this.buffer, 0, read);
            i7 -= read;
        }
    }

    public void writeRawBytes(byte[] bArr) throws java.io.IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = this.limit;
        int i4 = this.position;
        if (i3 - i4 >= i2) {
            java.lang.System.arraycopy(bArr, i, this.buffer, i4, i2);
            this.position += i2;
            return;
        }
        int i5 = i3 - i4;
        java.lang.System.arraycopy(bArr, i, this.buffer, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.position = this.limit;
        refreshBuffer();
        if (i7 > this.limit) {
            this.output.write(bArr, i6, i7);
        } else {
            java.lang.System.arraycopy(bArr, i6, this.buffer, 0, i7);
            this.position = i7;
        }
    }

    public void writeRawLittleEndian32(int i) throws java.io.IOException {
        writeRawByte(i & 255);
        writeRawByte((i >> 8) & 255);
        writeRawByte((i >> 16) & 255);
        writeRawByte((i >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j) throws java.io.IOException {
        writeRawByte(((int) j) & 255);
        writeRawByte(((int) (j >> 8)) & 255);
        writeRawByte(((int) (j >> 16)) & 255);
        writeRawByte(((int) (j >> 24)) & 255);
        writeRawByte(((int) (j >> 32)) & 255);
        writeRawByte(((int) (j >> 40)) & 255);
        writeRawByte(((int) (j >> 48)) & 255);
        writeRawByte(((int) (j >> 56)) & 255);
    }

    public void writeRawMessageSetExtension(int i, com.google.protobuf.ByteString byteString) throws java.io.IOException {
        writeTag(1, 3);
        writeUInt32(2, i);
        writeBytes(3, byteString);
        writeTag(1, 4);
    }

    public void writeRawVarint32(int i) throws java.io.IOException {
        while ((i & com.alipay.sdk.m.n.a.g) != 0) {
            writeRawByte((i & 127) | 128);
            i >>>= 7;
        }
        writeRawByte(i);
    }

    public void writeRawVarint64(long j) throws java.io.IOException {
        while (((-128) & j) != 0) {
            writeRawByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    public void writeSFixed32(int i, int i2) throws java.io.IOException {
        writeTag(i, 5);
        writeSFixed32NoTag(i2);
    }

    public void writeSFixed32NoTag(int i) throws java.io.IOException {
        writeRawLittleEndian32(i);
    }

    public void writeSFixed64(int i, long j) throws java.io.IOException {
        writeTag(i, 1);
        writeSFixed64NoTag(j);
    }

    public void writeSFixed64NoTag(long j) throws java.io.IOException {
        writeRawLittleEndian64(j);
    }

    public void writeSInt32(int i, int i2) throws java.io.IOException {
        writeTag(i, 0);
        writeSInt32NoTag(i2);
    }

    public void writeSInt32NoTag(int i) throws java.io.IOException {
        writeRawVarint32(encodeZigZag32(i));
    }

    public void writeSInt64(int i, long j) throws java.io.IOException {
        writeTag(i, 0);
        writeSInt64NoTag(j);
    }

    public void writeSInt64NoTag(long j) throws java.io.IOException {
        writeRawVarint64(encodeZigZag64(j));
    }

    public void writeString(int i, java.lang.String str) throws java.io.IOException {
        writeTag(i, 2);
        writeStringNoTag(str);
    }

    public void writeStringNoTag(java.lang.String str) throws java.io.IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i, int i2) throws java.io.IOException {
        writeRawVarint32(com.google.protobuf.WireFormat.makeTag(i, i2));
    }

    public void writeUInt32(int i, int i2) throws java.io.IOException {
        writeTag(i, 0);
        writeUInt32NoTag(i2);
    }

    public void writeUInt32NoTag(int i) throws java.io.IOException {
        writeRawVarint32(i);
    }

    public void writeUInt64(int i, long j) throws java.io.IOException {
        writeTag(i, 0);
        writeUInt64NoTag(j);
    }

    public void writeUInt64NoTag(long j) throws java.io.IOException {
        writeRawVarint64(j);
    }

    @java.lang.Deprecated
    public void writeUnknownGroup(int i, com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        writeGroup(i, messageLite);
    }

    @java.lang.Deprecated
    public void writeUnknownGroupNoTag(com.google.protobuf.MessageLite messageLite) throws java.io.IOException {
        writeGroupNoTag(messageLite);
    }
}
