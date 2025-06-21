package org.apache.tools.tar;

/* loaded from: classes26.dex */
public class TarInputStream extends java.io.FilterInputStream {
    protected org.apache.tools.tar.TarBuffer buffer;
    protected org.apache.tools.tar.TarEntry currEntry;
    protected boolean debug;
    protected long entryOffset;
    protected long entrySize;
    protected boolean hasHitEOF;
    public final byte[] n;
    protected byte[] oneBuf;
    protected byte[] readBuf;
    public final byte[] t;
    public final org.apache.tools.zip.ZipEncoding u;

    public TarInputStream(java.io.InputStream inputStream) {
        this(inputStream, 10240, 512);
    }

    public TarInputStream(java.io.InputStream inputStream, int i) {
        this(inputStream, i, 512);
    }

    public TarInputStream(java.io.InputStream inputStream, int i, int i2) {
        this(inputStream, i, i2, null);
    }

    public TarInputStream(java.io.InputStream inputStream, int i, int i2, java.lang.String str) {
        super(inputStream);
        this.n = new byte[8192];
        this.t = new byte[256];
        this.buffer = new org.apache.tools.tar.TarBuffer(inputStream, i, i2);
        this.readBuf = null;
        this.oneBuf = new byte[1];
        this.debug = false;
        this.hasHitEOF = false;
        this.u = org.apache.tools.zip.ZipEncodingHelper.getZipEncoding(str);
    }

    public TarInputStream(java.io.InputStream inputStream, int i, java.lang.String str) {
        this(inputStream, i, 512, str);
    }

    public TarInputStream(java.io.InputStream inputStream, java.lang.String str) {
        this(inputStream, 10240, 512, str);
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.String value = entry.getValue();
            if ("path".equals(key)) {
                this.currEntry.setName(value);
            } else if ("linkpath".equals(key)) {
                this.currEntry.setLinkName(value);
            } else if ("gid".equals(key)) {
                this.currEntry.setGroupId(java.lang.Long.parseLong(value));
            } else if ("gname".equals(key)) {
                this.currEntry.setGroupName(value);
            } else if ("uid".equals(key)) {
                this.currEntry.setUserId(java.lang.Long.parseLong(value));
            } else if ("uname".equals(key)) {
                this.currEntry.setUserName(value);
            } else if (com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE.equals(key)) {
                this.currEntry.setSize(java.lang.Long.parseLong(value));
            } else if ("mtime".equals(key)) {
                this.currEntry.setModTime((long) (java.lang.Double.parseDouble(value) * 1000.0d));
            } else if ("SCHILY.devminor".equals(key)) {
                this.currEntry.setDevMinor(java.lang.Integer.parseInt(value));
            } else if ("SCHILY.devmajor".equals(key)) {
                this.currEntry.setDevMajor(java.lang.Integer.parseInt(value));
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws java.io.IOException {
        if (e()) {
            return 0;
        }
        long j = this.entrySize;
        long j2 = this.entryOffset;
        if (j - j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j - j2);
    }

    public final byte[] c() throws java.io.IOException {
        if (this.hasHitEOF) {
            return null;
        }
        byte[] readRecord = this.buffer.readRecord();
        if (readRecord == null) {
            if (this.debug) {
                java.lang.System.err.println("READ NULL RECORD");
            }
            this.hasHitEOF = true;
        } else if (this.buffer.isEOFRecord(readRecord)) {
            if (this.debug) {
                java.lang.System.err.println("READ EOF RECORD");
            }
            this.hasHitEOF = true;
        }
        if (this.hasHitEOF) {
            return null;
        }
        return readRecord;
    }

    public boolean canReadEntryData(org.apache.tools.tar.TarEntry tarEntry) {
        return !tarEntry.isGNUSparse();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.buffer.close();
    }

    public void copyEntryContents(java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int read = read(bArr, 0, 32768);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public final boolean e() {
        org.apache.tools.tar.TarEntry tarEntry = this.currEntry;
        return tarEntry != null && tarEntry.isDirectory();
    }

    public java.util.Map<java.lang.String, java.lang.String> f(java.io.InputStream inputStream) throws java.io.IOException {
        int read;
        int read2;
        java.util.HashMap hashMap = new java.util.HashMap();
        do {
            int i = 0;
            int i2 = 0;
            while (true) {
                read = inputStream.read();
                if (read == -1) {
                    break;
                }
                i++;
                if (read == 32) {
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        read2 = inputStream.read();
                        if (read2 == -1) {
                            break;
                        }
                        i++;
                        if (read2 == 61) {
                            java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                            int i3 = i2 - i;
                            java.io.ByteArrayOutputStream byteArrayOutputStream3 = new java.io.ByteArrayOutputStream();
                            int i4 = 0;
                            while (i4 < i3) {
                                read2 = inputStream.read();
                                if (read2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream3.write((byte) read2);
                                i4++;
                            }
                            byteArrayOutputStream3.close();
                            if (i4 != i3) {
                                throw new java.io.IOException("Failed to read Paxheader. Expected " + i3 + " bytes, read " + i4);
                            }
                            hashMap.put(byteArrayOutputStream2, new java.lang.String(byteArrayOutputStream3.toByteArray(), 0, i3 - 1, "UTF-8"));
                        } else {
                            byteArrayOutputStream.write((byte) read2);
                        }
                    }
                    read = read2;
                } else {
                    i2 = (i2 * 10) + (read - 48);
                }
            }
        } while (read != -1);
        return hashMap;
    }

    public final void g() throws java.io.IOException {
        java.util.Map<java.lang.String, java.lang.String> f = f(this);
        getNextEntry();
        a(f);
    }

    public byte[] getLongNameData() throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int read = read(this.t);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(this.t, 0, read);
        }
        getNextEntry();
        if (this.currEntry == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length == byteArray.length) {
            return byteArray;
        }
        byte[] bArr = new byte[length];
        java.lang.System.arraycopy(byteArray, 0, bArr, 0, length);
        return bArr;
    }

    public org.apache.tools.tar.TarEntry getNextEntry() throws java.io.IOException {
        if (this.hasHitEOF) {
            return null;
        }
        if (this.currEntry != null) {
            long j = this.entrySize - this.entryOffset;
            if (this.debug) {
                java.lang.System.err.println("TarInputStream: SKIP currENTRY '" + this.currEntry.getName() + "' SZ " + this.entrySize + " OFF " + this.entryOffset + "  skipping " + j + " bytes");
            }
            while (j > 0) {
                long skip = skip(j);
                if (skip <= 0) {
                    throw new java.io.IOException("failed to skip current tar entry");
                }
                j -= skip;
            }
            this.readBuf = null;
        }
        byte[] c = c();
        if (this.hasHitEOF) {
            this.currEntry = null;
            return null;
        }
        try {
            this.currEntry = new org.apache.tools.tar.TarEntry(c, this.u);
            if (this.debug) {
                java.lang.System.err.println("TarInputStream: SET CURRENTRY '" + this.currEntry.getName() + "' size = " + this.currEntry.getSize());
            }
            this.entryOffset = 0L;
            this.entrySize = this.currEntry.getSize();
            if (this.currEntry.isGNULongLinkEntry()) {
                byte[] longNameData = getLongNameData();
                if (longNameData == null) {
                    return null;
                }
                this.currEntry.setLinkName(this.u.decode(longNameData));
            }
            if (this.currEntry.isGNULongNameEntry()) {
                byte[] longNameData2 = getLongNameData();
                if (longNameData2 == null) {
                    return null;
                }
                this.currEntry.setName(this.u.decode(longNameData2));
            }
            if (this.currEntry.isPaxHeader()) {
                g();
            }
            if (this.currEntry.isGNUSparse()) {
                j();
            }
            this.entrySize = this.currEntry.getSize();
            return this.currEntry;
        } catch (java.lang.IllegalArgumentException e) {
            java.io.IOException iOException = new java.io.IOException("Error detected parsing the header");
            iOException.initCause(e);
            throw iOException;
        }
    }

    public int getRecordSize() {
        return this.buffer.getRecordSize();
    }

    public final void j() throws java.io.IOException {
        byte[] c;
        if (this.currEntry.isExtended()) {
            do {
                c = c();
                if (this.hasHitEOF) {
                    this.currEntry = null;
                    return;
                }
            } while (new org.apache.tools.tar.TarArchiveSparseEntry(c).isExtended());
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        if (read(this.oneBuf, 0, 1) == -1) {
            return -1;
        }
        return this.oneBuf[0] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3;
        if (this.entryOffset >= this.entrySize || e()) {
            return -1;
        }
        long j = this.entryOffset;
        long j2 = i2 + j;
        long j3 = this.entrySize;
        if (j2 > j3) {
            i2 = (int) (j3 - j);
        }
        byte[] bArr2 = this.readBuf;
        if (bArr2 != null) {
            int length = i2 > bArr2.length ? bArr2.length : i2;
            java.lang.System.arraycopy(bArr2, 0, bArr, i, length);
            byte[] bArr3 = this.readBuf;
            if (length >= bArr3.length) {
                this.readBuf = null;
            } else {
                int length2 = bArr3.length - length;
                byte[] bArr4 = new byte[length2];
                java.lang.System.arraycopy(bArr3, length, bArr4, 0, length2);
                this.readBuf = bArr4;
            }
            i3 = length + 0;
            i2 -= length;
            i += length;
        } else {
            i3 = 0;
        }
        while (i2 > 0) {
            byte[] readRecord = this.buffer.readRecord();
            if (readRecord == null) {
                throw new java.io.IOException("unexpected EOF with " + i2 + " bytes unread");
            }
            int length3 = readRecord.length;
            if (length3 > i2) {
                java.lang.System.arraycopy(readRecord, 0, bArr, i, i2);
                int i4 = length3 - i2;
                byte[] bArr5 = new byte[i4];
                this.readBuf = bArr5;
                java.lang.System.arraycopy(readRecord, i2, bArr5, 0, i4);
                length3 = i2;
            } else {
                java.lang.System.arraycopy(readRecord, 0, bArr, i, length3);
            }
            i3 += length3;
            i2 -= length3;
            i += length3;
        }
        this.entryOffset += i3;
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
    }

    public void setDebug(boolean z) {
        this.debug = z;
        this.buffer.setDebug(z);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        if (j <= 0 || e()) {
            return 0L;
        }
        long j2 = j;
        while (j2 > 0) {
            byte[] bArr = this.n;
            int read = read(bArr, 0, (int) (j2 > ((long) bArr.length) ? bArr.length : j2));
            if (read == -1) {
                break;
            }
            j2 -= read;
        }
        return j - j2;
    }
}
