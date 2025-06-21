package com.google.protobuf;

/* loaded from: classes22.dex */
public final class ByteString {
    public static final com.google.protobuf.ByteString EMPTY = new com.google.protobuf.ByteString(new byte[0]);
    private final byte[] bytes;
    private volatile int hash;

    public static final class CodedBuilder {
        private final byte[] buffer;
        private final com.google.protobuf.CodedOutputStream output;

        private CodedBuilder(int i) {
            byte[] bArr = new byte[i];
            this.buffer = bArr;
            this.output = com.google.protobuf.CodedOutputStream.newInstance(bArr);
        }

        public /* synthetic */ CodedBuilder(int i, com.google.protobuf.ByteString.AnonymousClass1 anonymousClass1) {
            this(i);
        }

        public com.google.protobuf.ByteString build() {
            this.output.checkNoSpaceLeft();
            return new com.google.protobuf.ByteString(this.buffer, null);
        }

        public com.google.protobuf.CodedOutputStream getCodedOutput() {
            return this.output;
        }
    }

    public static final class Output extends java.io.FilterOutputStream {
        private final java.io.ByteArrayOutputStream bout;

        private Output(java.io.ByteArrayOutputStream byteArrayOutputStream) {
            super(byteArrayOutputStream);
            this.bout = byteArrayOutputStream;
        }

        public /* synthetic */ Output(java.io.ByteArrayOutputStream byteArrayOutputStream, com.google.protobuf.ByteString.AnonymousClass1 anonymousClass1) {
            this(byteArrayOutputStream);
        }

        public com.google.protobuf.ByteString toByteString() {
            return new com.google.protobuf.ByteString(this.bout.toByteArray(), null);
        }
    }

    private ByteString(byte[] bArr) {
        this.hash = 0;
        this.bytes = bArr;
    }

    public /* synthetic */ ByteString(byte[] bArr, com.google.protobuf.ByteString.AnonymousClass1 anonymousClass1) {
        this(bArr);
    }

    public static com.google.protobuf.ByteString copyFrom(java.lang.String str, java.lang.String str2) throws java.io.UnsupportedEncodingException {
        return new com.google.protobuf.ByteString(str.getBytes(str2));
    }

    public static com.google.protobuf.ByteString copyFrom(java.nio.ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static com.google.protobuf.ByteString copyFrom(java.nio.ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return new com.google.protobuf.ByteString(bArr);
    }

    public static com.google.protobuf.ByteString copyFrom(java.util.List<com.google.protobuf.ByteString> list) {
        if (list.size() == 0) {
            return EMPTY;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        java.util.Iterator<com.google.protobuf.ByteString> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().size();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (com.google.protobuf.ByteString byteString : list) {
            java.lang.System.arraycopy(byteString.bytes, 0, bArr, i2, byteString.size());
            i2 += byteString.size();
        }
        return new com.google.protobuf.ByteString(bArr);
    }

    public static com.google.protobuf.ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static com.google.protobuf.ByteString copyFrom(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        return new com.google.protobuf.ByteString(bArr2);
    }

    public static com.google.protobuf.ByteString copyFromUtf8(java.lang.String str) {
        try {
            return new com.google.protobuf.ByteString(str.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static com.google.protobuf.ByteString.CodedBuilder newCodedBuilder(int i) {
        return new com.google.protobuf.ByteString.CodedBuilder(i, null);
    }

    public static com.google.protobuf.ByteString.Output newOutput() {
        return newOutput(32);
    }

    public static com.google.protobuf.ByteString.Output newOutput(int i) {
        return new com.google.protobuf.ByteString.Output(new java.io.ByteArrayOutputStream(i), null);
    }

    public java.nio.ByteBuffer asReadOnlyByteBuffer() {
        return java.nio.ByteBuffer.wrap(this.bytes).asReadOnlyBuffer();
    }

    public byte byteAt(int i) {
        return this.bytes[i];
    }

    public void copyTo(java.nio.ByteBuffer byteBuffer) {
        byte[] bArr = this.bytes;
        byteBuffer.put(bArr, 0, bArr.length);
    }

    public void copyTo(byte[] bArr, int i) {
        byte[] bArr2 = this.bytes;
        java.lang.System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
    }

    public void copyTo(byte[] bArr, int i, int i2, int i3) {
        java.lang.System.arraycopy(this.bytes, i, bArr, i2, i3);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.ByteString)) {
            return false;
        }
        byte[] bArr = this.bytes;
        int length = bArr.length;
        byte[] bArr2 = ((com.google.protobuf.ByteString) obj).bytes;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            byte[] bArr = this.bytes;
            int length = bArr.length;
            for (byte b : bArr) {
                length = (length * 31) + b;
            }
            i = length == 0 ? 1 : length;
            this.hash = i;
        }
        return i;
    }

    public boolean isEmpty() {
        return this.bytes.length == 0;
    }

    public com.google.protobuf.CodedInputStream newCodedInput() {
        return com.google.protobuf.CodedInputStream.newInstance(this.bytes);
    }

    public java.io.InputStream newInput() {
        return new java.io.ByteArrayInputStream(this.bytes);
    }

    public int size() {
        return this.bytes.length;
    }

    public byte[] toByteArray() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public java.lang.String toString(java.lang.String str) throws java.io.UnsupportedEncodingException {
        return new java.lang.String(this.bytes, str);
    }

    public java.lang.String toStringUtf8() {
        try {
            return new java.lang.String(this.bytes, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("UTF-8 not supported?", e);
        }
    }
}
