package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class ZipFile implements java.io.Closeable {
    public static final long F = org.apache.tools.zip.ZipLong.getValue(org.apache.tools.zip.ZipOutputStream.CFH_SIG);
    public final byte[] A;
    public final byte[] B;
    public final byte[] C;
    public final byte[] D;
    public final java.util.Comparator<org.apache.tools.zip.ZipEntry> E;
    public final java.util.List<org.apache.tools.zip.ZipEntry> n;
    public final java.util.Map<java.lang.String, java.util.LinkedList<org.apache.tools.zip.ZipEntry>> t;
    public final java.lang.String u;
    public final org.apache.tools.zip.ZipEncoding v;
    public final java.lang.String w;
    public final java.io.RandomAccessFile x;
    public final boolean y;
    public volatile boolean z;

    /* renamed from: org.apache.tools.zip.ZipFile$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.zip.InflaterInputStream {
        public final /* synthetic */ java.util.zip.Inflater n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.io.InputStream inputStream, java.util.zip.Inflater inflater, java.util.zip.Inflater inflater2) {
            super(inputStream, inflater);
            this.n = inflater2;
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            super.close();
            this.n.end();
        }
    }

    /* renamed from: org.apache.tools.zip.ZipFile$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<org.apache.tools.zip.ZipEntry> {
        public AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(org.apache.tools.zip.ZipEntry zipEntry, org.apache.tools.zip.ZipEntry zipEntry2) {
            if (zipEntry == zipEntry2) {
                return 0;
            }
            org.apache.tools.zip.ZipFile.Entry entry = zipEntry instanceof org.apache.tools.zip.ZipFile.Entry ? (org.apache.tools.zip.ZipFile.Entry) zipEntry : null;
            org.apache.tools.zip.ZipFile.Entry entry2 = zipEntry2 instanceof org.apache.tools.zip.ZipFile.Entry ? (org.apache.tools.zip.ZipFile.Entry) zipEntry2 : null;
            if (entry == null) {
                return 1;
            }
            if (entry2 == null) {
                return -1;
            }
            long j = entry.j().a - entry2.j().a;
            if (j == 0) {
                return 0;
            }
            return j < 0 ? -1 : 1;
        }
    }

    public class BoundedInputStream extends java.io.InputStream {
        public long n;
        public long t;
        public boolean u = false;

        public BoundedInputStream(long j, long j2) {
            this.n = j2;
            this.t = j;
        }

        public void a() {
            this.u = true;
        }

        @Override // java.io.InputStream
        public int read() throws java.io.IOException {
            int read;
            long j = this.n;
            this.n = j - 1;
            if (j <= 0) {
                if (!this.u) {
                    return -1;
                }
                this.u = false;
                return 0;
            }
            synchronized (org.apache.tools.zip.ZipFile.this.x) {
                java.io.RandomAccessFile randomAccessFile = org.apache.tools.zip.ZipFile.this.x;
                long j2 = this.t;
                this.t = 1 + j2;
                randomAccessFile.seek(j2);
                read = org.apache.tools.zip.ZipFile.this.x.read();
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
            int read;
            long j = this.n;
            if (j <= 0) {
                if (!this.u) {
                    return -1;
                }
                this.u = false;
                bArr[i] = 0;
                return 1;
            }
            if (i2 <= 0) {
                return 0;
            }
            if (i2 > j) {
                i2 = (int) j;
            }
            synchronized (org.apache.tools.zip.ZipFile.this.x) {
                org.apache.tools.zip.ZipFile.this.x.seek(this.t);
                read = org.apache.tools.zip.ZipFile.this.x.read(bArr, i, i2);
            }
            if (read > 0) {
                long j2 = read;
                this.t += j2;
                this.n -= j2;
            }
            return read;
        }
    }

    public static class Entry extends org.apache.tools.zip.ZipEntry {
        public final org.apache.tools.zip.ZipFile.OffsetEntry E;

        public Entry(org.apache.tools.zip.ZipFile.OffsetEntry offsetEntry) {
            this.E = offsetEntry;
        }

        @Override // org.apache.tools.zip.ZipEntry
        public boolean equals(java.lang.Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            org.apache.tools.zip.ZipFile.Entry entry = (org.apache.tools.zip.ZipFile.Entry) obj;
            return this.E.a == entry.E.a && this.E.b == entry.E.b;
        }

        @Override // org.apache.tools.zip.ZipEntry, java.util.zip.ZipEntry
        public int hashCode() {
            return (super.hashCode() * 3) + ((int) (this.E.a % 2147483647L));
        }

        public org.apache.tools.zip.ZipFile.OffsetEntry j() {
            return this.E;
        }
    }

    public static final class NameAndComment {
        public final byte[] a;
        public final byte[] b;

        public NameAndComment(byte[] bArr, byte[] bArr2) {
            this.a = bArr;
            this.b = bArr2;
        }

        public /* synthetic */ NameAndComment(byte[] bArr, byte[] bArr2, org.apache.tools.zip.ZipFile.AnonymousClass1 anonymousClass1) {
            this(bArr, bArr2);
        }
    }

    public static final class OffsetEntry {
        public long a;
        public long b;

        public OffsetEntry() {
            this.a = -1L;
            this.b = -1L;
        }

        public /* synthetic */ OffsetEntry(org.apache.tools.zip.ZipFile.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public ZipFile(java.io.File file) throws java.io.IOException {
        this(file, (java.lang.String) null);
    }

    public ZipFile(java.io.File file, java.lang.String str) throws java.io.IOException {
        this(file, str, true);
    }

    public ZipFile(java.io.File file, java.lang.String str, boolean z) throws java.io.IOException {
        this.n = new java.util.LinkedList();
        this.t = new java.util.HashMap(509);
        this.A = new byte[8];
        this.B = new byte[4];
        this.C = new byte[42];
        this.D = new byte[2];
        this.E = new org.apache.tools.zip.ZipFile.AnonymousClass2();
        this.w = file.getAbsolutePath();
        this.u = str;
        this.v = org.apache.tools.zip.ZipEncodingHelper.getZipEncoding(str);
        this.y = z;
        this.x = new java.io.RandomAccessFile(file, "r");
        try {
            l(c());
            this.z = false;
        } catch (java.lang.Throwable th) {
            this.z = true;
            try {
                this.x.close();
            } catch (java.io.IOException unused) {
            }
            throw th;
        }
    }

    public ZipFile(java.lang.String str) throws java.io.IOException {
        this(new java.io.File(str), (java.lang.String) null);
    }

    public ZipFile(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        this(new java.io.File(str), str2, true);
    }

    public static void closeQuietly(org.apache.tools.zip.ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public final java.util.Map<org.apache.tools.zip.ZipEntry, org.apache.tools.zip.ZipFile.NameAndComment> c() throws java.io.IOException {
        java.util.HashMap hashMap = new java.util.HashMap();
        e();
        this.x.readFully(this.B);
        long value = org.apache.tools.zip.ZipLong.getValue(this.B);
        if (value != F && o()) {
            throw new java.io.IOException("central directory is empty, can't expand corrupt archive.");
        }
        while (value == F) {
            k(hashMap);
            this.x.readFully(this.B);
            value = org.apache.tools.zip.ZipLong.getValue(this.B);
        }
        return hashMap;
    }

    public boolean canReadEntryData(org.apache.tools.zip.ZipEntry zipEntry) {
        return org.apache.tools.zip.ZipUtil.a(zipEntry);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.z = true;
        this.x.close();
    }

    public final void e() throws java.io.IOException {
        j();
        boolean z = false;
        boolean z2 = this.x.getFilePointer() > 20;
        if (z2) {
            java.io.RandomAccessFile randomAccessFile = this.x;
            randomAccessFile.seek(randomAccessFile.getFilePointer() - 20);
            this.x.readFully(this.B);
            z = java.util.Arrays.equals(org.apache.tools.zip.ZipOutputStream.T, this.B);
        }
        if (z) {
            g();
            return;
        }
        if (z2) {
            n(16);
        }
        f();
    }

    public final void f() throws java.io.IOException {
        n(16);
        this.x.readFully(this.B);
        this.x.seek(org.apache.tools.zip.ZipLong.getValue(this.B));
    }

    public void finalize() throws java.lang.Throwable {
        try {
            if (!this.z) {
                java.lang.System.err.println("Cleaning up unclosed ZipFile for archive " + this.w);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public final void g() throws java.io.IOException {
        n(4);
        this.x.readFully(this.A);
        this.x.seek(org.apache.tools.zip.ZipEightByteInteger.getLongValue(this.A));
        this.x.readFully(this.B);
        if (!java.util.Arrays.equals(this.B, org.apache.tools.zip.ZipOutputStream.S)) {
            throw new java.util.zip.ZipException("archive's ZIP64 end of central directory locator is corrupt.");
        }
        n(44);
        this.x.readFully(this.A);
        this.x.seek(org.apache.tools.zip.ZipEightByteInteger.getLongValue(this.A));
    }

    public java.lang.String getEncoding() {
        return this.u;
    }

    public java.lang.Iterable<org.apache.tools.zip.ZipEntry> getEntries(java.lang.String str) {
        java.util.LinkedList<org.apache.tools.zip.ZipEntry> linkedList = this.t.get(str);
        return linkedList != null ? linkedList : java.util.Collections.emptyList();
    }

    public java.util.Enumeration<org.apache.tools.zip.ZipEntry> getEntries() {
        return java.util.Collections.enumeration(this.n);
    }

    public java.lang.Iterable<org.apache.tools.zip.ZipEntry> getEntriesInPhysicalOrder(java.lang.String str) {
        org.apache.tools.zip.ZipEntry[] zipEntryArr = new org.apache.tools.zip.ZipEntry[0];
        if (this.t.containsKey(str)) {
            zipEntryArr = (org.apache.tools.zip.ZipEntry[]) this.t.get(str).toArray(zipEntryArr);
            java.util.Arrays.sort(zipEntryArr, this.E);
        }
        return java.util.Arrays.asList(zipEntryArr);
    }

    public java.util.Enumeration<org.apache.tools.zip.ZipEntry> getEntriesInPhysicalOrder() {
        org.apache.tools.zip.ZipEntry[] zipEntryArr = (org.apache.tools.zip.ZipEntry[]) this.n.toArray(new org.apache.tools.zip.ZipEntry[0]);
        java.util.Arrays.sort(zipEntryArr, this.E);
        return java.util.Collections.enumeration(java.util.Arrays.asList(zipEntryArr));
    }

    public org.apache.tools.zip.ZipEntry getEntry(java.lang.String str) {
        java.util.LinkedList<org.apache.tools.zip.ZipEntry> linkedList = this.t.get(str);
        if (linkedList != null) {
            return linkedList.getFirst();
        }
        return null;
    }

    public java.io.InputStream getInputStream(org.apache.tools.zip.ZipEntry zipEntry) throws java.io.IOException, java.util.zip.ZipException {
        if (!(zipEntry instanceof org.apache.tools.zip.ZipFile.Entry)) {
            return null;
        }
        org.apache.tools.zip.ZipFile.OffsetEntry j = ((org.apache.tools.zip.ZipFile.Entry) zipEntry).j();
        org.apache.tools.zip.ZipUtil.b(zipEntry);
        org.apache.tools.zip.ZipFile.BoundedInputStream boundedInputStream = new org.apache.tools.zip.ZipFile.BoundedInputStream(j.b, zipEntry.getCompressedSize());
        int method = zipEntry.getMethod();
        if (method == 0) {
            return boundedInputStream;
        }
        if (method == 8) {
            boundedInputStream.a();
            java.util.zip.Inflater inflater = new java.util.zip.Inflater(true);
            return new org.apache.tools.zip.ZipFile.AnonymousClass1(boundedInputStream, inflater, inflater);
        }
        throw new java.util.zip.ZipException("Found unsupported compression method " + zipEntry.getMethod());
    }

    public final void j() throws java.io.IOException {
        if (!p(22L, 65557L, org.apache.tools.zip.ZipOutputStream.EOCD_SIG)) {
            throw new java.util.zip.ZipException("archive is not a ZIP archive");
        }
    }

    public final void k(java.util.Map<org.apache.tools.zip.ZipEntry, org.apache.tools.zip.ZipFile.NameAndComment> map) throws java.io.IOException {
        this.x.readFully(this.C);
        org.apache.tools.zip.ZipFile.OffsetEntry offsetEntry = new org.apache.tools.zip.ZipFile.OffsetEntry(null);
        org.apache.tools.zip.ZipFile.Entry entry = new org.apache.tools.zip.ZipFile.Entry(offsetEntry);
        entry.setPlatform((org.apache.tools.zip.ZipShort.getValue(this.C, 0) >> 8) & 15);
        org.apache.tools.zip.GeneralPurposeBit parse = org.apache.tools.zip.GeneralPurposeBit.parse(this.C, 4);
        boolean usesUTF8ForNames = parse.usesUTF8ForNames();
        org.apache.tools.zip.ZipEncoding zipEncoding = usesUTF8ForNames ? org.apache.tools.zip.ZipEncodingHelper.c : this.v;
        entry.setGeneralPurposeBit(parse);
        entry.setMethod(org.apache.tools.zip.ZipShort.getValue(this.C, 6));
        entry.setTime(org.apache.tools.zip.ZipUtil.dosToJavaTime(org.apache.tools.zip.ZipLong.getValue(this.C, 8)));
        entry.setCrc(org.apache.tools.zip.ZipLong.getValue(this.C, 12));
        entry.setCompressedSize(org.apache.tools.zip.ZipLong.getValue(this.C, 16));
        entry.setSize(org.apache.tools.zip.ZipLong.getValue(this.C, 20));
        int value = org.apache.tools.zip.ZipShort.getValue(this.C, 24);
        int value2 = org.apache.tools.zip.ZipShort.getValue(this.C, 26);
        int value3 = org.apache.tools.zip.ZipShort.getValue(this.C, 28);
        int value4 = org.apache.tools.zip.ZipShort.getValue(this.C, 30);
        entry.setInternalAttributes(org.apache.tools.zip.ZipShort.getValue(this.C, 32));
        entry.setExternalAttributes(org.apache.tools.zip.ZipLong.getValue(this.C, 34));
        if (this.x.length() - this.x.getFilePointer() < value) {
            throw new java.io.EOFException();
        }
        byte[] bArr = new byte[value];
        this.x.readFully(bArr);
        entry.setName(zipEncoding.decode(bArr), bArr);
        offsetEntry.a = org.apache.tools.zip.ZipLong.getValue(this.C, 38);
        this.n.add(entry);
        if (this.x.length() - this.x.getFilePointer() < value2) {
            throw new java.io.EOFException();
        }
        byte[] bArr2 = new byte[value2];
        this.x.readFully(bArr2);
        entry.setCentralDirectoryExtra(bArr2);
        m(entry, offsetEntry, value4);
        if (this.x.length() - this.x.getFilePointer() < value3) {
            throw new java.io.EOFException();
        }
        byte[] bArr3 = new byte[value3];
        this.x.readFully(bArr3);
        entry.setComment(zipEncoding.decode(bArr3));
        if (usesUTF8ForNames || !this.y) {
            return;
        }
        map.put(entry, new org.apache.tools.zip.ZipFile.NameAndComment(bArr, bArr3, null));
    }

    public final void l(java.util.Map<org.apache.tools.zip.ZipEntry, org.apache.tools.zip.ZipFile.NameAndComment> map) throws java.io.IOException {
        java.util.Iterator<org.apache.tools.zip.ZipEntry> it = this.n.iterator();
        while (it.hasNext()) {
            org.apache.tools.zip.ZipFile.Entry entry = (org.apache.tools.zip.ZipFile.Entry) it.next();
            org.apache.tools.zip.ZipFile.OffsetEntry j = entry.j();
            long j2 = j.a + 26;
            this.x.seek(j2);
            this.x.readFully(this.D);
            int value = org.apache.tools.zip.ZipShort.getValue(this.D);
            this.x.readFully(this.D);
            int value2 = org.apache.tools.zip.ZipShort.getValue(this.D);
            int i = value;
            while (i > 0) {
                int skipBytes = this.x.skipBytes(i);
                if (skipBytes <= 0) {
                    throw new java.io.IOException("failed to skip file name in local file header");
                }
                i -= skipBytes;
            }
            long j3 = value2;
            if (this.x.length() - this.x.getFilePointer() < j3) {
                throw new java.io.EOFException();
            }
            byte[] bArr = new byte[value2];
            this.x.readFully(bArr);
            try {
                entry.setExtra(bArr);
                j.b = j2 + 2 + 2 + value + j3;
                if (map.containsKey(entry)) {
                    org.apache.tools.zip.ZipFile.NameAndComment nameAndComment = map.get(entry);
                    org.apache.tools.zip.ZipUtil.e(entry, nameAndComment.a, nameAndComment.b);
                }
                java.lang.String name = entry.getName();
                java.util.LinkedList<org.apache.tools.zip.ZipEntry> linkedList = this.t.get(name);
                if (linkedList == null) {
                    linkedList = new java.util.LinkedList<>();
                    this.t.put(name, linkedList);
                }
                linkedList.addLast(entry);
            } catch (java.lang.RuntimeException e) {
                java.util.zip.ZipException zipException = new java.util.zip.ZipException("Invalid extra data in entry " + entry.getName());
                zipException.initCause(e);
                throw zipException;
            }
        }
    }

    public final void m(org.apache.tools.zip.ZipEntry zipEntry, org.apache.tools.zip.ZipFile.OffsetEntry offsetEntry, int i) throws java.io.IOException {
        org.apache.tools.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (org.apache.tools.zip.Zip64ExtendedInformationExtraField) zipEntry.getExtraField(org.apache.tools.zip.Zip64ExtendedInformationExtraField.x);
        if (zip64ExtendedInformationExtraField != null) {
            boolean z = zipEntry.getSize() == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
            boolean z2 = zipEntry.getCompressedSize() == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
            boolean z3 = offsetEntry.a == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
            zip64ExtendedInformationExtraField.reparseCentralDirectoryData(z, z2, z3, i == 65535);
            if (z) {
                zipEntry.setSize(zip64ExtendedInformationExtraField.getSize().getLongValue());
            } else if (z2) {
                zip64ExtendedInformationExtraField.setSize(new org.apache.tools.zip.ZipEightByteInteger(zipEntry.getSize()));
            }
            if (z2) {
                zipEntry.setCompressedSize(zip64ExtendedInformationExtraField.getCompressedSize().getLongValue());
            } else if (z) {
                zip64ExtendedInformationExtraField.setCompressedSize(new org.apache.tools.zip.ZipEightByteInteger(zipEntry.getCompressedSize()));
            }
            if (z3) {
                offsetEntry.a = zip64ExtendedInformationExtraField.getRelativeHeaderOffset().getLongValue();
            }
        }
    }

    public final void n(int i) throws java.io.IOException {
        int i2 = 0;
        while (i2 < i) {
            int skipBytes = this.x.skipBytes(i - i2);
            if (skipBytes <= 0) {
                throw new java.io.EOFException();
            }
            i2 += skipBytes;
        }
    }

    public final boolean o() throws java.io.IOException {
        this.x.seek(0L);
        this.x.readFully(this.B);
        return java.util.Arrays.equals(this.B, org.apache.tools.zip.ZipOutputStream.LFH_SIG);
    }

    public final boolean p(long j, long j2, byte[] bArr) throws java.io.IOException {
        long length = this.x.length() - j;
        long max = java.lang.Math.max(0L, this.x.length() - j2);
        boolean z = false;
        if (length >= 0) {
            while (true) {
                if (length < max) {
                    break;
                }
                this.x.seek(length);
                int read = this.x.read();
                if (read == -1) {
                    break;
                }
                if (read == bArr[0] && this.x.read() == bArr[1] && this.x.read() == bArr[2] && this.x.read() == bArr[3]) {
                    z = true;
                    break;
                }
                length--;
            }
        }
        if (z) {
            this.x.seek(length);
        }
        return z;
    }
}
