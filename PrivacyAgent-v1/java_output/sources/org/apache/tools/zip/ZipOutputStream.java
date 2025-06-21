package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class ZipOutputStream extends java.io.FilterOutputStream {
    public static final int DEFAULT_COMPRESSION = -1;
    public static final int DEFLATED = 8;

    @java.lang.Deprecated
    public static final int EFS_FLAG = 2048;
    public static final java.lang.String N = null;
    public static final int STORED = 0;
    public long A;
    public long B;
    public long C;
    public final java.util.Map<org.apache.tools.zip.ZipEntry, java.lang.Long> D;
    public java.lang.String E;
    public org.apache.tools.zip.ZipEncoding F;
    public final java.io.RandomAccessFile G;
    public boolean H;
    public boolean I;
    public org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy J;
    public boolean K;
    public org.apache.tools.zip.Zip64Mode L;
    public final java.util.Calendar M;
    protected byte[] buf;
    protected final java.util.zip.Deflater def;
    public boolean n;
    public org.apache.tools.zip.ZipOutputStream.CurrentEntry t;
    public java.lang.String u;
    public int v;
    public boolean w;
    public int x;
    public final java.util.List<org.apache.tools.zip.ZipEntry> y;
    public final java.util.zip.CRC32 z;
    public static final byte[] O = new byte[0];
    public static final byte[] P = {0, 0};
    public static final byte[] Q = {0, 0, 0, 0};
    public static final byte[] R = org.apache.tools.zip.ZipLong.getBytes(1);
    protected static final byte[] LFH_SIG = org.apache.tools.zip.ZipLong.LFH_SIG.getBytes();
    protected static final byte[] DD_SIG = org.apache.tools.zip.ZipLong.DD_SIG.getBytes();
    protected static final byte[] CFH_SIG = org.apache.tools.zip.ZipLong.CFH_SIG.getBytes();
    protected static final byte[] EOCD_SIG = org.apache.tools.zip.ZipLong.getBytes(net.lingala.zip4j.util.InternalZipConstants.ENDSIG);
    public static final byte[] S = org.apache.tools.zip.ZipLong.getBytes(net.lingala.zip4j.util.InternalZipConstants.ZIP64ENDCENDIRREC);
    public static final byte[] T = org.apache.tools.zip.ZipLong.getBytes(net.lingala.zip4j.util.InternalZipConstants.ZIP64ENDCENDIRLOC);

    public static final class CurrentEntry {
        public final org.apache.tools.zip.ZipEntry a;
        public long b;
        public long c;
        public long d;
        public boolean e;
        public boolean f;

        public CurrentEntry(org.apache.tools.zip.ZipEntry zipEntry) {
            this.b = 0L;
            this.c = 0L;
            this.d = 0L;
            this.e = false;
            this.a = zipEntry;
        }

        public /* synthetic */ CurrentEntry(org.apache.tools.zip.ZipEntry zipEntry, org.apache.tools.zip.ZipOutputStream.AnonymousClass1 anonymousClass1) {
            this(zipEntry);
        }
    }

    public static final class UnicodeExtraFieldPolicy {
        public static final org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy ALWAYS = new org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy("always");
        public static final org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy NEVER = new org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy("never");
        public static final org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy NOT_ENCODEABLE = new org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy("not encodeable");
        public final java.lang.String a;

        public UnicodeExtraFieldPolicy(java.lang.String str) {
            this.a = str;
        }

        public java.lang.String toString() {
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZipOutputStream(java.io.File file) throws java.io.IOException {
        super(null);
        java.io.RandomAccessFile randomAccessFile;
        java.io.RandomAccessFile randomAccessFile2 = null;
        this.n = false;
        this.u = "";
        this.v = -1;
        this.w = false;
        this.x = 8;
        this.y = new java.util.LinkedList();
        this.z = new java.util.zip.CRC32();
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = new java.util.HashMap();
        this.E = null;
        this.F = org.apache.tools.zip.ZipEncodingHelper.getZipEncoding(N);
        this.def = new java.util.zip.Deflater(this.v, true);
        this.buf = new byte[512];
        this.H = true;
        this.I = false;
        this.J = org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy.NEVER;
        this.K = false;
        this.L = org.apache.tools.zip.Zip64Mode.AsNeeded;
        this.M = java.util.Calendar.getInstance();
        try {
            randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                randomAccessFile.setLength(0L);
            } catch (java.io.IOException unused) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException unused2) {
                    }
                } else {
                    randomAccessFile2 = randomAccessFile;
                }
                ((java.io.FilterOutputStream) this).out = new java.io.FileOutputStream(file);
                randomAccessFile = randomAccessFile2;
                this.G = randomAccessFile;
            }
        } catch (java.io.IOException unused3) {
            randomAccessFile = null;
        }
        this.G = randomAccessFile;
    }

    public ZipOutputStream(java.io.OutputStream outputStream) {
        super(outputStream);
        this.n = false;
        this.u = "";
        this.v = -1;
        this.w = false;
        this.x = 8;
        this.y = new java.util.LinkedList();
        this.z = new java.util.zip.CRC32();
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = new java.util.HashMap();
        this.E = null;
        this.F = org.apache.tools.zip.ZipEncodingHelper.getZipEncoding(N);
        this.def = new java.util.zip.Deflater(this.v, true);
        this.buf = new byte[512];
        this.H = true;
        this.I = false;
        this.J = org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy.NEVER;
        this.K = false;
        this.L = org.apache.tools.zip.Zip64Mode.AsNeeded;
        this.M = java.util.Calendar.getInstance();
        this.G = null;
    }

    @java.lang.Deprecated
    public static long adjustToLong(int i) {
        return org.apache.tools.zip.ZipUtil.adjustToLong(i);
    }

    @java.lang.Deprecated
    public static org.apache.tools.zip.ZipLong toDosTime(java.util.Date date) {
        return org.apache.tools.zip.ZipUtil.toDosTime(date);
    }

    @java.lang.Deprecated
    public static byte[] toDosTime(long j) {
        return org.apache.tools.zip.ZipUtil.toDosTime(j);
    }

    public final void A(org.apache.tools.zip.Zip64Mode zip64Mode) throws java.util.zip.ZipException {
        if (this.t.a.getMethod() == 0 && this.G == null) {
            if (this.t.a.getSize() == -1) {
                throw new java.util.zip.ZipException("uncompressed size is required for STORED method when not writing to a file");
            }
            if (this.t.a.getCrc() == -1) {
                throw new java.util.zip.ZipException("crc checksum is required for STORED method when not writing to a file");
            }
            this.t.a.setCompressedSize(this.t.a.getSize());
        }
        if ((this.t.a.getSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || this.t.a.getCompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) && zip64Mode == org.apache.tools.zip.Zip64Mode.Never) {
            throw new org.apache.tools.zip.Zip64RequiredException(org.apache.tools.zip.Zip64RequiredException.getEntryTooBigMessage(this.t.a));
        }
    }

    public final int B(int i, boolean z) {
        if (z) {
            return 45;
        }
        return t(i) ? 20 : 10;
    }

    public final void C() throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(70000);
        java.util.Iterator<org.apache.tools.zip.ZipEntry> it = this.y.iterator();
        while (true) {
            int i = 0;
            while (it.hasNext()) {
                byteArrayOutputStream.write(d(it.next()));
                i++;
                if (i > 1000) {
                    break;
                }
            }
            D(byteArrayOutputStream.toByteArray());
            return;
            D(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.reset();
        }
    }

    public final void D(byte[] bArr) throws java.io.IOException {
        E(bArr, 0, bArr.length);
    }

    public final void E(byte[] bArr, int i, int i2) throws java.io.IOException {
        writeOut(bArr, i, i2);
        this.A += i2;
    }

    public final void F(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (i2 <= 0 || this.def.finished()) {
            return;
        }
        this.t.d += i2;
        if (i2 <= 8192) {
            this.def.setInput(bArr, i, i2);
            g();
            return;
        }
        int i3 = i2 / 8192;
        for (int i4 = 0; i4 < i3; i4++) {
            this.def.setInput(bArr, (i4 * 8192) + i, 8192);
            g();
        }
        int i5 = i3 * 8192;
        if (i5 < i2) {
            this.def.setInput(bArr, i + i5, i2 - i5);
            g();
        }
    }

    public final void a(org.apache.tools.zip.ZipEntry zipEntry, boolean z, java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy unicodeExtraFieldPolicy = this.J;
        org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy unicodeExtraFieldPolicy2 = org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy.ALWAYS;
        if (unicodeExtraFieldPolicy == unicodeExtraFieldPolicy2 || !z) {
            zipEntry.addExtraField(new org.apache.tools.zip.UnicodePathExtraField(zipEntry.getName(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
        }
        java.lang.String comment = zipEntry.getComment();
        if (comment == null || "".equals(comment)) {
            return;
        }
        boolean canEncode = this.F.canEncode(comment);
        if (this.J == unicodeExtraFieldPolicy2 || !canEncode) {
            java.nio.ByteBuffer encode = m(zipEntry).encode(comment);
            zipEntry.addExtraField(new org.apache.tools.zip.UnicodeCommentExtraField(comment, encode.array(), encode.arrayOffset(), encode.limit() - encode.position()));
        }
    }

    public final boolean b(org.apache.tools.zip.Zip64Mode zip64Mode) throws java.util.zip.ZipException {
        boolean v = v(this.t.a, zip64Mode);
        if (v && zip64Mode == org.apache.tools.zip.Zip64Mode.Never) {
            throw new org.apache.tools.zip.Zip64RequiredException(org.apache.tools.zip.Zip64RequiredException.getEntryTooBigMessage(this.t.a));
        }
        return v;
    }

    public final void c(boolean z) throws java.io.IOException {
        if (this.G != null) {
            x(z);
        }
        writeDataDescriptor(this.t.a);
        this.t = null;
    }

    public boolean canWriteEntryData(org.apache.tools.zip.ZipEntry zipEntry) {
        return org.apache.tools.zip.ZipUtil.a(zipEntry);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (!this.n) {
            finish();
        }
        j();
    }

    public void closeEntry() throws java.io.IOException {
        w();
        k();
        org.apache.tools.zip.Zip64Mode l = l(this.t.a);
        long j = this.A - this.t.c;
        long value = this.z.getValue();
        this.z.reset();
        c(q(j, value, l));
    }

    public final byte[] d(org.apache.tools.zip.ZipEntry zipEntry) throws java.io.IOException {
        long longValue = this.D.get(zipEntry).longValue();
        boolean z = s(zipEntry) || zipEntry.getCompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || zipEntry.getSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || longValue >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        if (z && this.L == org.apache.tools.zip.Zip64Mode.Never) {
            throw new org.apache.tools.zip.Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
        }
        r(zipEntry, longValue, z);
        return e(zipEntry, o(zipEntry), longValue, z);
    }

    public final void deflate() throws java.io.IOException {
        java.util.zip.Deflater deflater = this.def;
        byte[] bArr = this.buf;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            E(this.buf, 0, deflate);
        }
    }

    public final byte[] e(org.apache.tools.zip.ZipEntry zipEntry, java.nio.ByteBuffer byteBuffer, long j, boolean z) throws java.io.IOException {
        byte[] centralDirectoryExtra = zipEntry.getCentralDirectoryExtra();
        java.lang.String comment = zipEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        java.nio.ByteBuffer encode = m(zipEntry).encode(comment);
        int limit = byteBuffer.limit() - byteBuffer.position();
        int limit2 = encode.limit() - encode.position();
        int i = limit + 46;
        byte[] bArr = new byte[centralDirectoryExtra.length + i + limit2];
        java.lang.System.arraycopy(CFH_SIG, 0, bArr, 0, 4);
        org.apache.tools.zip.ZipShort.putShort((zipEntry.getPlatform() << 8) | (!this.K ? 20 : 45), bArr, 4);
        int method = zipEntry.getMethod();
        boolean canEncode = this.F.canEncode(zipEntry.getName());
        org.apache.tools.zip.ZipShort.putShort(B(method, z), bArr, 6);
        n(method, !canEncode && this.I).encode(bArr, 8);
        org.apache.tools.zip.ZipShort.putShort(method, bArr, 10);
        org.apache.tools.zip.ZipUtil.h(this.M, zipEntry.getTime(), bArr, 12);
        org.apache.tools.zip.ZipLong.putLong(zipEntry.getCrc(), bArr, 16);
        if (zipEntry.getCompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || zipEntry.getSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) {
            org.apache.tools.zip.ZipLong zipLong = org.apache.tools.zip.ZipLong.t;
            zipLong.putLong(bArr, 20);
            zipLong.putLong(bArr, 24);
        } else {
            org.apache.tools.zip.ZipLong.putLong(zipEntry.getCompressedSize(), bArr, 20);
            org.apache.tools.zip.ZipLong.putLong(zipEntry.getSize(), bArr, 24);
        }
        org.apache.tools.zip.ZipShort.putShort(limit, bArr, 28);
        org.apache.tools.zip.ZipShort.putShort(centralDirectoryExtra.length, bArr, 30);
        org.apache.tools.zip.ZipShort.putShort(limit2, bArr, 32);
        java.lang.System.arraycopy(P, 0, bArr, 34, 2);
        org.apache.tools.zip.ZipShort.putShort(zipEntry.getInternalAttributes(), bArr, 36);
        org.apache.tools.zip.ZipLong.putLong(zipEntry.getExternalAttributes(), bArr, 38);
        org.apache.tools.zip.ZipLong.putLong(java.lang.Math.min(j, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT), bArr, 42);
        java.lang.System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 46, limit);
        java.lang.System.arraycopy(centralDirectoryExtra, 0, bArr, i, centralDirectoryExtra.length);
        java.lang.System.arraycopy(encode.array(), encode.arrayOffset(), bArr, i + centralDirectoryExtra.length, limit2);
        return bArr;
    }

    public final byte[] f(org.apache.tools.zip.ZipEntry zipEntry, java.nio.ByteBuffer byteBuffer, boolean z) {
        byte[] localFileDataExtra = zipEntry.getLocalFileDataExtra();
        int limit = byteBuffer.limit() - byteBuffer.position();
        int i = limit + 30;
        byte[] bArr = new byte[localFileDataExtra.length + i];
        java.lang.System.arraycopy(LFH_SIG, 0, bArr, 0, 4);
        int method = zipEntry.getMethod();
        org.apache.tools.zip.ZipShort.putShort(B(method, s(zipEntry)), bArr, 4);
        n(method, !z && this.I).encode(bArr, 6);
        org.apache.tools.zip.ZipShort.putShort(method, bArr, 8);
        org.apache.tools.zip.ZipUtil.h(this.M, zipEntry.getTime(), bArr, 10);
        if (method == 8 || this.G != null) {
            java.lang.System.arraycopy(Q, 0, bArr, 14, 4);
        } else {
            org.apache.tools.zip.ZipLong.putLong(zipEntry.getCrc(), bArr, 14);
        }
        if (s(this.t.a)) {
            org.apache.tools.zip.ZipLong zipLong = org.apache.tools.zip.ZipLong.t;
            zipLong.putLong(bArr, 18);
            zipLong.putLong(bArr, 22);
        } else if (method == 8 || this.G != null) {
            byte[] bArr2 = Q;
            java.lang.System.arraycopy(bArr2, 0, bArr, 18, 4);
            java.lang.System.arraycopy(bArr2, 0, bArr, 22, 4);
        } else {
            org.apache.tools.zip.ZipLong.putLong(zipEntry.getSize(), bArr, 18);
            org.apache.tools.zip.ZipLong.putLong(zipEntry.getSize(), bArr, 22);
        }
        org.apache.tools.zip.ZipShort.putShort(limit, bArr, 26);
        org.apache.tools.zip.ZipShort.putShort(localFileDataExtra.length, bArr, 28);
        java.lang.System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 30, limit);
        java.lang.System.arraycopy(localFileDataExtra, 0, bArr, i, localFileDataExtra.length);
        return bArr;
    }

    public void finish() throws java.io.IOException {
        if (this.n) {
            throw new java.io.IOException("This archive has already been finished");
        }
        if (this.t != null) {
            closeEntry();
        }
        this.B = this.A;
        C();
        this.C = this.A - this.B;
        writeZip64CentralDirectory();
        writeCentralDirectoryEnd();
        this.D.clear();
        this.y.clear();
        this.def.end();
        this.n = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        java.io.OutputStream outputStream = ((java.io.FilterOutputStream) this).out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public final void g() throws java.io.IOException {
        while (!this.def.needsInput()) {
            deflate();
        }
    }

    public byte[] getBytes(java.lang.String str) throws java.util.zip.ZipException {
        try {
            java.nio.ByteBuffer encode = org.apache.tools.zip.ZipEncodingHelper.getZipEncoding(this.E).encode(str);
            int limit = encode.limit();
            byte[] bArr = new byte[limit];
            java.lang.System.arraycopy(encode.array(), encode.arrayOffset(), bArr, 0, limit);
            return bArr;
        } catch (java.io.IOException e) {
            throw new java.util.zip.ZipException("Failed to encode name: " + e.getMessage());
        }
    }

    public java.lang.String getEncoding() {
        return this.E;
    }

    public boolean isSeekable() {
        return this.G != null;
    }

    public void j() throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = this.G;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        java.io.OutputStream outputStream = ((java.io.FilterOutputStream) this).out;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public final void k() throws java.io.IOException {
        if (this.t.a.getMethod() == 8) {
            this.def.finish();
            while (!this.def.finished()) {
                deflate();
            }
        }
    }

    public final org.apache.tools.zip.Zip64Mode l(org.apache.tools.zip.ZipEntry zipEntry) {
        return (this.L == org.apache.tools.zip.Zip64Mode.AsNeeded && this.G == null && zipEntry.getMethod() == 8 && zipEntry.getSize() == -1) ? org.apache.tools.zip.Zip64Mode.Never : this.L;
    }

    public final org.apache.tools.zip.ZipEncoding m(org.apache.tools.zip.ZipEntry zipEntry) {
        return (this.F.canEncode(zipEntry.getName()) || !this.I) ? this.F : org.apache.tools.zip.ZipEncodingHelper.c;
    }

    public final org.apache.tools.zip.GeneralPurposeBit n(int i, boolean z) {
        org.apache.tools.zip.GeneralPurposeBit generalPurposeBit = new org.apache.tools.zip.GeneralPurposeBit();
        generalPurposeBit.useUTF8ForNames(this.H || z);
        if (t(i)) {
            generalPurposeBit.useDataDescriptor(true);
        }
        return generalPurposeBit;
    }

    public final java.nio.ByteBuffer o(org.apache.tools.zip.ZipEntry zipEntry) throws java.io.IOException {
        return m(zipEntry).encode(zipEntry.getName());
    }

    public final org.apache.tools.zip.Zip64ExtendedInformationExtraField p(org.apache.tools.zip.ZipEntry zipEntry) {
        org.apache.tools.zip.ZipOutputStream.CurrentEntry currentEntry = this.t;
        if (currentEntry != null) {
            currentEntry.e = !this.K;
        }
        this.K = true;
        org.apache.tools.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (org.apache.tools.zip.Zip64ExtendedInformationExtraField) zipEntry.getExtraField(org.apache.tools.zip.Zip64ExtendedInformationExtraField.x);
        if (zip64ExtendedInformationExtraField == null) {
            zip64ExtendedInformationExtraField = new org.apache.tools.zip.Zip64ExtendedInformationExtraField();
        }
        zipEntry.addAsFirstExtraField(zip64ExtendedInformationExtraField);
        return zip64ExtendedInformationExtraField;
    }

    public void putNextEntry(org.apache.tools.zip.ZipEntry zipEntry) throws java.io.IOException {
        if (this.n) {
            throw new java.io.IOException("Stream has already been finished");
        }
        if (this.t != null) {
            closeEntry();
        }
        org.apache.tools.zip.ZipOutputStream.CurrentEntry currentEntry = new org.apache.tools.zip.ZipOutputStream.CurrentEntry(zipEntry, null);
        this.t = currentEntry;
        this.y.add(currentEntry.a);
        y(this.t.a);
        org.apache.tools.zip.Zip64Mode l = l(this.t.a);
        A(l);
        if (z(this.t.a, l)) {
            org.apache.tools.zip.Zip64ExtendedInformationExtraField p = p(this.t.a);
            org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger = org.apache.tools.zip.ZipEightByteInteger.ZERO;
            if (this.t.a.getMethod() == 0 && this.t.a.getSize() != -1) {
                zipEightByteInteger = new org.apache.tools.zip.ZipEightByteInteger(this.t.a.getSize());
            }
            p.setSize(zipEightByteInteger);
            p.setCompressedSize(zipEightByteInteger);
            this.t.a.setExtra();
        }
        if (this.t.a.getMethod() == 8 && this.w) {
            this.def.setLevel(this.v);
            this.w = false;
        }
        writeLocalFileHeader(this.t.a);
    }

    public final boolean q(long j, long j2, org.apache.tools.zip.Zip64Mode zip64Mode) throws java.util.zip.ZipException {
        if (this.t.a.getMethod() == 8) {
            this.t.a.setSize(this.t.d);
            this.t.a.setCompressedSize(j);
            this.t.a.setCrc(j2);
            this.def.reset();
        } else if (this.G != null) {
            this.t.a.setSize(j);
            this.t.a.setCompressedSize(j);
            this.t.a.setCrc(j2);
        } else {
            if (this.t.a.getCrc() != j2) {
                throw new java.util.zip.ZipException("bad CRC checksum for entry " + this.t.a.getName() + ": " + java.lang.Long.toHexString(this.t.a.getCrc()) + " instead of " + java.lang.Long.toHexString(j2));
            }
            if (this.t.a.getSize() != j) {
                throw new java.util.zip.ZipException("bad size for entry " + this.t.a.getName() + ": " + this.t.a.getSize() + " instead of " + j);
            }
        }
        return b(zip64Mode);
    }

    public final void r(org.apache.tools.zip.ZipEntry zipEntry, long j, boolean z) {
        if (z) {
            org.apache.tools.zip.Zip64ExtendedInformationExtraField p = p(zipEntry);
            if (zipEntry.getCompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || zipEntry.getSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) {
                p.setCompressedSize(new org.apache.tools.zip.ZipEightByteInteger(zipEntry.getCompressedSize()));
                p.setSize(new org.apache.tools.zip.ZipEightByteInteger(zipEntry.getSize()));
            } else {
                p.setCompressedSize(null);
                p.setSize(null);
            }
            if (j >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) {
                p.setRelativeHeaderOffset(new org.apache.tools.zip.ZipEightByteInteger(j));
            }
            zipEntry.setExtra();
        }
    }

    public final boolean s(org.apache.tools.zip.ZipEntry zipEntry) {
        return zipEntry.getExtraField(org.apache.tools.zip.Zip64ExtendedInformationExtraField.x) != null;
    }

    public void setComment(java.lang.String str) {
        this.u = str;
    }

    public void setCreateUnicodeExtraFields(org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy unicodeExtraFieldPolicy) {
        this.J = unicodeExtraFieldPolicy;
    }

    public void setEncoding(java.lang.String str) {
        this.E = str;
        this.F = org.apache.tools.zip.ZipEncodingHelper.getZipEncoding(str);
        if (!this.H || org.apache.tools.zip.ZipEncodingHelper.c(str)) {
            return;
        }
        this.H = false;
    }

    public void setFallbackToUTF8(boolean z) {
        this.I = z;
    }

    public void setLevel(int i) {
        if (i < -1 || i > 9) {
            throw new java.lang.IllegalArgumentException("Invalid compression level: " + i);
        }
        if (this.v == i) {
            return;
        }
        this.w = true;
        this.v = i;
    }

    public void setMethod(int i) {
        this.x = i;
    }

    public void setUseLanguageEncodingFlag(boolean z) {
        this.H = z && org.apache.tools.zip.ZipEncodingHelper.c(this.E);
    }

    public void setUseZip64(org.apache.tools.zip.Zip64Mode zip64Mode) {
        this.L = zip64Mode;
    }

    public final boolean t(int i) {
        return i == 8 && this.G == null;
    }

    public final boolean u(org.apache.tools.zip.ZipEntry zipEntry) {
        return zipEntry.getSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || zipEntry.getCompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
    }

    public final boolean v(org.apache.tools.zip.ZipEntry zipEntry, org.apache.tools.zip.Zip64Mode zip64Mode) {
        return zip64Mode == org.apache.tools.zip.Zip64Mode.Always || u(zipEntry);
    }

    public final void w() throws java.io.IOException {
        if (this.n) {
            throw new java.io.IOException("Stream has already been finished");
        }
        org.apache.tools.zip.ZipOutputStream.CurrentEntry currentEntry = this.t;
        if (currentEntry == null) {
            throw new java.io.IOException("No current entry to close");
        }
        if (currentEntry.f) {
            return;
        }
        write(O, 0, 0);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        org.apache.tools.zip.ZipOutputStream.CurrentEntry currentEntry = this.t;
        if (currentEntry == null) {
            throw new java.lang.IllegalStateException("No current entry");
        }
        org.apache.tools.zip.ZipUtil.b(currentEntry.a);
        this.t.f = true;
        if (this.t.a.getMethod() == 8) {
            F(bArr, i, i2);
        } else {
            E(bArr, i, i2);
        }
        this.z.update(bArr, i, i2);
    }

    public void writeCentralDirectoryEnd() throws java.io.IOException {
        D(EOCD_SIG);
        byte[] bArr = P;
        D(bArr);
        D(bArr);
        int size = this.y.size();
        if (size > 65535 && this.L == org.apache.tools.zip.Zip64Mode.Never) {
            throw new org.apache.tools.zip.Zip64RequiredException("archive contains more than 65535 entries.");
        }
        if (this.B > net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT && this.L == org.apache.tools.zip.Zip64Mode.Never) {
            throw new org.apache.tools.zip.Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
        }
        byte[] bytes = org.apache.tools.zip.ZipShort.getBytes(java.lang.Math.min(size, 65535));
        D(bytes);
        D(bytes);
        D(org.apache.tools.zip.ZipLong.getBytes(java.lang.Math.min(this.C, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT)));
        D(org.apache.tools.zip.ZipLong.getBytes(java.lang.Math.min(this.B, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT)));
        java.nio.ByteBuffer encode = this.F.encode(this.u);
        int limit = encode.limit() - encode.position();
        D(org.apache.tools.zip.ZipShort.getBytes(limit));
        E(encode.array(), encode.arrayOffset(), limit);
    }

    public void writeCentralFileHeader(org.apache.tools.zip.ZipEntry zipEntry) throws java.io.IOException {
        D(d(zipEntry));
    }

    public void writeDataDescriptor(org.apache.tools.zip.ZipEntry zipEntry) throws java.io.IOException {
        if (zipEntry.getMethod() == 8 && this.G == null) {
            D(DD_SIG);
            D(org.apache.tools.zip.ZipLong.getBytes(zipEntry.getCrc()));
            if (s(zipEntry)) {
                D(org.apache.tools.zip.ZipEightByteInteger.getBytes(zipEntry.getCompressedSize()));
                D(org.apache.tools.zip.ZipEightByteInteger.getBytes(zipEntry.getSize()));
            } else {
                D(org.apache.tools.zip.ZipLong.getBytes(zipEntry.getCompressedSize()));
                D(org.apache.tools.zip.ZipLong.getBytes(zipEntry.getSize()));
            }
        }
    }

    public void writeLocalFileHeader(org.apache.tools.zip.ZipEntry zipEntry) throws java.io.IOException {
        boolean canEncode = this.F.canEncode(zipEntry.getName());
        java.nio.ByteBuffer o = o(zipEntry);
        if (this.J != org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy.NEVER) {
            a(zipEntry, canEncode, o);
        }
        byte[] f = f(zipEntry, o, canEncode);
        long j = this.A;
        this.D.put(zipEntry, java.lang.Long.valueOf(j));
        this.t.b = j + 14;
        D(f);
        this.t.c = this.A;
    }

    public final void writeOut(byte[] bArr) throws java.io.IOException {
        writeOut(bArr, 0, bArr.length);
    }

    public final void writeOut(byte[] bArr, int i, int i2) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = this.G;
        if (randomAccessFile != null) {
            randomAccessFile.write(bArr, i, i2);
        } else {
            ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
        }
    }

    public void writeZip64CentralDirectory() throws java.io.IOException {
        if (this.L == org.apache.tools.zip.Zip64Mode.Never) {
            return;
        }
        if (!this.K && (this.B >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || this.C >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || this.y.size() >= 65535)) {
            this.K = true;
        }
        if (this.K) {
            long j = this.A;
            writeOut(S);
            writeOut(org.apache.tools.zip.ZipEightByteInteger.getBytes(44L));
            writeOut(org.apache.tools.zip.ZipShort.getBytes(45));
            writeOut(org.apache.tools.zip.ZipShort.getBytes(45));
            byte[] bArr = Q;
            writeOut(bArr);
            writeOut(bArr);
            byte[] bytes = org.apache.tools.zip.ZipEightByteInteger.getBytes(this.y.size());
            writeOut(bytes);
            writeOut(bytes);
            writeOut(org.apache.tools.zip.ZipEightByteInteger.getBytes(this.C));
            writeOut(org.apache.tools.zip.ZipEightByteInteger.getBytes(this.B));
            writeOut(T);
            writeOut(bArr);
            writeOut(org.apache.tools.zip.ZipEightByteInteger.getBytes(j));
            writeOut(R);
        }
    }

    public final void x(boolean z) throws java.io.IOException {
        long filePointer = this.G.getFilePointer();
        this.G.seek(this.t.b);
        writeOut(org.apache.tools.zip.ZipLong.getBytes(this.t.a.getCrc()));
        if (s(this.t.a) && z) {
            org.apache.tools.zip.ZipLong zipLong = org.apache.tools.zip.ZipLong.t;
            writeOut(zipLong.getBytes());
            writeOut(zipLong.getBytes());
        } else {
            writeOut(org.apache.tools.zip.ZipLong.getBytes(this.t.a.getCompressedSize()));
            writeOut(org.apache.tools.zip.ZipLong.getBytes(this.t.a.getSize()));
        }
        if (s(this.t.a)) {
            this.G.seek(this.t.b + 12 + 4 + o(this.t.a).limit() + 4);
            writeOut(org.apache.tools.zip.ZipEightByteInteger.getBytes(this.t.a.getSize()));
            writeOut(org.apache.tools.zip.ZipEightByteInteger.getBytes(this.t.a.getCompressedSize()));
            if (!z) {
                this.G.seek(this.t.b - 10);
                writeOut(org.apache.tools.zip.ZipShort.getBytes(10));
                this.t.a.removeExtraField(org.apache.tools.zip.Zip64ExtendedInformationExtraField.x);
                this.t.a.setExtra();
                if (this.t.e) {
                    this.K = false;
                }
            }
        }
        this.G.seek(filePointer);
    }

    public final void y(org.apache.tools.zip.ZipEntry zipEntry) {
        if (zipEntry.getMethod() == -1) {
            zipEntry.setMethod(this.x);
        }
        if (zipEntry.getTime() == -1) {
            zipEntry.setTime(java.lang.System.currentTimeMillis());
        }
    }

    public final boolean z(org.apache.tools.zip.ZipEntry zipEntry, org.apache.tools.zip.Zip64Mode zip64Mode) {
        return zip64Mode == org.apache.tools.zip.Zip64Mode.Always || zipEntry.getSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || zipEntry.getCompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT || !(zipEntry.getSize() != -1 || this.G == null || zip64Mode == org.apache.tools.zip.Zip64Mode.Never);
    }
}
