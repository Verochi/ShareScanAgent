package org.apache.tools.zip;

/* loaded from: classes26.dex */
class Simple8BitZipEncoding implements org.apache.tools.zip.ZipEncoding {
    public final char[] a;
    public final java.util.List<org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar> b;

    public static final class Simple8BitChar implements java.lang.Comparable<org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar> {
        public final char n;
        public final byte t;

        public Simple8BitChar(byte b, char c) {
            this.t = b;
            this.n = c;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar simple8BitChar) {
            return this.n - simple8BitChar.n;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar)) {
                return false;
            }
            org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar simple8BitChar = (org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar) obj;
            return this.n == simple8BitChar.n && this.t == simple8BitChar.t;
        }

        public int hashCode() {
            return this.n;
        }

        public java.lang.String toString() {
            return "0x" + java.lang.Integer.toHexString(65535 & this.n) + "->0x" + java.lang.Integer.toHexString(this.t & 255);
        }
    }

    public Simple8BitZipEncoding(char[] cArr) {
        char[] cArr2 = (char[]) cArr.clone();
        this.a = cArr2;
        java.util.ArrayList arrayList = new java.util.ArrayList(cArr2.length);
        byte b = Byte.MAX_VALUE;
        for (char c : cArr2) {
            b = (byte) (b + 1);
            arrayList.add(new org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar(b, c));
        }
        java.util.Collections.sort(arrayList);
        this.b = java.util.Collections.unmodifiableList(arrayList);
    }

    public boolean a(char c) {
        return (c >= 0 && c < 128) || c(c) != null;
    }

    public char b(byte b) {
        return b >= 0 ? (char) b : this.a[b + 128];
    }

    public final org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar c(char c) {
        int size = this.b.size();
        int i = 0;
        while (size > i) {
            int i2 = ((size - i) / 2) + i;
            org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar simple8BitChar = this.b.get(i2);
            char c2 = simple8BitChar.n;
            if (c2 == c) {
                return simple8BitChar;
            }
            if (c2 < c) {
                i = i2 + 1;
            } else {
                size = i2;
            }
        }
        if (i >= this.b.size()) {
            return null;
        }
        org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar simple8BitChar2 = this.b.get(i);
        if (simple8BitChar2.n != c) {
            return null;
        }
        return simple8BitChar2;
    }

    @Override // org.apache.tools.zip.ZipEncoding
    public boolean canEncode(java.lang.String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean d(java.nio.ByteBuffer byteBuffer, char c) {
        if (c >= 0 && c < 128) {
            byteBuffer.put((byte) c);
            return true;
        }
        org.apache.tools.zip.Simple8BitZipEncoding.Simple8BitChar c2 = c(c);
        if (c2 == null) {
            return false;
        }
        byteBuffer.put(c2.t);
        return true;
    }

    @Override // org.apache.tools.zip.ZipEncoding
    public java.lang.String decode(byte[] bArr) throws java.io.IOException {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i] = b(bArr[i]);
        }
        return new java.lang.String(cArr);
    }

    @Override // org.apache.tools.zip.ZipEncoding
    public java.nio.ByteBuffer encode(java.lang.String str) {
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(str.length() + 6 + ((str.length() + 1) / 2));
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (allocate.remaining() < 6) {
                allocate = org.apache.tools.zip.ZipEncodingHelper.b(allocate, allocate.position() + 6);
            }
            if (!d(allocate, charAt)) {
                org.apache.tools.zip.ZipEncodingHelper.a(allocate, charAt);
            }
        }
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }
}
