package org.apache.tools.tar;

/* loaded from: classes26.dex */
public class TarOutputStream extends java.io.FilterOutputStream {
    public static final int BIGNUMBER_ERROR = 0;
    public static final int BIGNUMBER_POSIX = 2;
    public static final int BIGNUMBER_STAR = 1;
    public static final int LONGFILE_ERROR = 0;
    public static final int LONGFILE_GNU = 2;
    public static final int LONGFILE_POSIX = 3;
    public static final int LONGFILE_TRUNCATE = 1;
    public static final org.apache.tools.zip.ZipEncoding y = org.apache.tools.zip.ZipEncodingHelper.getZipEncoding("ASCII");
    protected byte[] assemBuf;
    protected int assemLen;
    protected org.apache.tools.tar.TarBuffer buffer;
    protected long currBytes;
    protected java.lang.String currName;
    protected long currSize;
    protected boolean debug;
    protected int longFileMode;
    public int n;
    protected byte[] oneBuf;
    protected byte[] recordBuf;
    public boolean t;
    public boolean u;
    public boolean v;
    public final org.apache.tools.zip.ZipEncoding w;
    public boolean x;

    public TarOutputStream(java.io.OutputStream outputStream) {
        this(outputStream, 10240, 512);
    }

    public TarOutputStream(java.io.OutputStream outputStream, int i) {
        this(outputStream, i, 512);
    }

    public TarOutputStream(java.io.OutputStream outputStream, int i, int i2) {
        this(outputStream, i, i2, null);
    }

    public TarOutputStream(java.io.OutputStream outputStream, int i, int i2, java.lang.String str) {
        super(outputStream);
        this.longFileMode = 0;
        this.n = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.x = false;
        this.w = org.apache.tools.zip.ZipEncodingHelper.getZipEncoding(str);
        this.buffer = new org.apache.tools.tar.TarBuffer(outputStream, i, i2);
        this.debug = false;
        this.assemLen = 0;
        this.assemBuf = new byte[i2];
        this.recordBuf = new byte[i2];
        this.oneBuf = new byte[1];
    }

    public TarOutputStream(java.io.OutputStream outputStream, int i, java.lang.String str) {
        this(outputStream, i, 512, str);
    }

    public TarOutputStream(java.io.OutputStream outputStream, java.lang.String str) {
        this(outputStream, 10240, 512, str);
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, long j, long j2) {
        if (j < 0 || j > j2) {
            map.put(str, java.lang.String.valueOf(j));
        }
    }

    public final void b(java.util.Map<java.lang.String, java.lang.String> map, org.apache.tools.tar.TarEntry tarEntry) {
        a(map, com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, tarEntry.getSize(), org.apache.tools.tar.TarConstants.MAXSIZE);
        a(map, "gid", tarEntry.getLongGroupId(), org.apache.tools.tar.TarConstants.MAXID);
        a(map, "mtime", tarEntry.getModTime().getTime() / 1000, org.apache.tools.tar.TarConstants.MAXSIZE);
        a(map, "uid", tarEntry.getLongUserId(), org.apache.tools.tar.TarConstants.MAXID);
        a(map, "SCHILY.devmajor", tarEntry.getDevMajor(), org.apache.tools.tar.TarConstants.MAXID);
        a(map, "SCHILY.devminor", tarEntry.getDevMinor(), org.apache.tools.tar.TarConstants.MAXID);
        c("mode", tarEntry.getMode(), org.apache.tools.tar.TarConstants.MAXID);
    }

    public final void c(java.lang.String str, long j, long j2) {
        d(str, j, j2, "");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (!this.v) {
            finish();
        }
        if (this.t) {
            return;
        }
        this.buffer.close();
        ((java.io.FilterOutputStream) this).out.close();
        this.t = true;
    }

    public void closeEntry() throws java.io.IOException {
        byte[] bArr;
        if (this.v) {
            throw new java.io.IOException("Stream has already been finished");
        }
        if (!this.u) {
            throw new java.io.IOException("No current entry to close");
        }
        int i = this.assemLen;
        if (i > 0) {
            while (true) {
                bArr = this.assemBuf;
                if (i >= bArr.length) {
                    break;
                }
                bArr[i] = 0;
                i++;
            }
            this.buffer.writeRecord(bArr);
            this.currBytes += this.assemLen;
            this.assemLen = 0;
        }
        if (this.currBytes >= this.currSize) {
            this.u = false;
            return;
        }
        throw new java.io.IOException("entry '" + this.currName + "' closed at '" + this.currBytes + "' before the '" + this.currSize + "' bytes specified in the header were written");
    }

    public final void d(java.lang.String str, long j, long j2, java.lang.String str2) {
        if (j < 0 || j > j2) {
            throw new java.lang.RuntimeException(str + " '" + j + "' is too big ( > " + j2 + " )");
        }
    }

    public final void e(java.lang.String str, long j, long j2) {
        d(str, j, j2, " Use STAR or POSIX extensions to overcome this limit");
    }

    public final void f(org.apache.tools.tar.TarEntry tarEntry) {
        c("entry size", tarEntry.getSize(), org.apache.tools.tar.TarConstants.MAXSIZE);
        e("group id", tarEntry.getLongGroupId(), org.apache.tools.tar.TarConstants.MAXID);
        c("last modification time", tarEntry.getModTime().getTime() / 1000, org.apache.tools.tar.TarConstants.MAXSIZE);
        c("user id", tarEntry.getLongUserId(), org.apache.tools.tar.TarConstants.MAXID);
        c("mode", tarEntry.getMode(), org.apache.tools.tar.TarConstants.MAXID);
        c("major device number", tarEntry.getDevMajor(), org.apache.tools.tar.TarConstants.MAXID);
        c("minor device number", tarEntry.getDevMinor(), org.apache.tools.tar.TarConstants.MAXID);
    }

    public void finish() throws java.io.IOException {
        if (this.v) {
            throw new java.io.IOException("This archive has already been finished");
        }
        if (this.u) {
            throw new java.io.IOException("This archives contains unclosed entries.");
        }
        j();
        j();
        this.buffer.a();
        this.v = true;
    }

    public final boolean g(org.apache.tools.tar.TarEntry tarEntry, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2, byte b, java.lang.String str3) throws java.io.IOException {
        java.nio.ByteBuffer encode = this.w.encode(str);
        int limit = encode.limit() - encode.position();
        if (limit >= 100) {
            int i = this.longFileMode;
            if (i == 3) {
                map.put(str2, str);
                return true;
            }
            if (i == 2) {
                org.apache.tools.tar.TarEntry tarEntry2 = new org.apache.tools.tar.TarEntry(org.apache.tools.tar.TarConstants.GNU_LONGLINK, b);
                tarEntry2.setSize(limit + 1);
                i(tarEntry, tarEntry2);
                putNextEntry(tarEntry2);
                write(encode.array(), encode.arrayOffset(), limit);
                write(0);
                closeEntry();
            } else if (i != 1) {
                throw new java.lang.RuntimeException(str3 + " '" + str + "' is too long ( > 100 bytes)");
            }
        }
        return false;
    }

    public int getRecordSize() {
        return this.buffer.getRecordSize();
    }

    public final java.lang.String h(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            char c2 = (char) (c & com.google.common.base.Ascii.MAX);
            if (c2 != 0) {
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    public final void i(org.apache.tools.tar.TarEntry tarEntry, org.apache.tools.tar.TarEntry tarEntry2) {
        java.util.Date modTime = tarEntry.getModTime();
        long time = modTime.getTime() / 1000;
        if (time < 0 || time > org.apache.tools.tar.TarConstants.MAXSIZE) {
            modTime = new java.util.Date(0L);
        }
        tarEntry2.setModTime(modTime);
    }

    public final void j() throws java.io.IOException {
        int i = 0;
        while (true) {
            byte[] bArr = this.recordBuf;
            if (i >= bArr.length) {
                this.buffer.writeRecord(bArr);
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }

    public void k(org.apache.tools.tar.TarEntry tarEntry, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException {
        java.lang.String str2 = "./PaxHeaders.X/" + h(str);
        if (str2.length() >= 100) {
            str2 = str2.substring(0, 99);
        }
        while (str2.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        org.apache.tools.tar.TarEntry tarEntry2 = new org.apache.tools.tar.TarEntry(str2, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC);
        i(tarEntry, tarEntry2);
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.String value = entry.getValue();
            int length = key.length() + value.length() + 3 + 2;
            java.lang.String str3 = length + " " + key + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + value + "\n";
            int length2 = str3.getBytes("UTF-8").length;
            while (length != length2) {
                str3 = length2 + " " + key + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + value + "\n";
                int i = length2;
                length2 = str3.getBytes("UTF-8").length;
                length = i;
            }
            stringWriter.write(str3);
        }
        byte[] bytes = stringWriter.toString().getBytes("UTF-8");
        tarEntry2.setSize(bytes.length);
        putNextEntry(tarEntry2);
        write(bytes);
        closeEntry();
    }

    public void putNextEntry(org.apache.tools.tar.TarEntry tarEntry) throws java.io.IOException {
        if (this.v) {
            throw new java.io.IOException("Stream has already been finished");
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String name = tarEntry.getName();
        boolean g = g(tarEntry, name, hashMap, "path", org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, "file name");
        java.lang.String linkName = tarEntry.getLinkName();
        boolean z = linkName != null && linkName.length() > 0 && g(tarEntry, linkName, hashMap, "linkpath", org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, "link name");
        int i = this.n;
        if (i == 2) {
            b(hashMap, tarEntry);
        } else if (i != 1) {
            f(tarEntry);
        }
        if (this.x && !g && !y.canEncode(name)) {
            hashMap.put("path", name);
        }
        if (this.x && !z && ((tarEntry.isLink() || tarEntry.isSymbolicLink()) && !y.canEncode(linkName))) {
            hashMap.put("linkpath", linkName);
        }
        if (hashMap.size() > 0) {
            k(tarEntry, name, hashMap);
        }
        tarEntry.writeEntryHeader(this.recordBuf, this.w, this.n == 1);
        this.buffer.writeRecord(this.recordBuf);
        this.currBytes = 0L;
        if (tarEntry.isDirectory()) {
            this.currSize = 0L;
        } else {
            this.currSize = tarEntry.getSize();
        }
        this.currName = name;
        this.u = true;
    }

    public void setAddPaxHeadersForNonAsciiNames(boolean z) {
        this.x = z;
    }

    public void setBigNumberMode(int i) {
        this.n = i;
    }

    public void setBufferDebug(boolean z) {
        this.buffer.setDebug(z);
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setLongFileMode(int i) {
        this.longFileMode = i;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        byte[] bArr = this.oneBuf;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.currBytes + i2 > this.currSize) {
            throw new java.io.IOException("request to write '" + i2 + "' bytes exceeds size in header of '" + this.currSize + "' bytes for entry '" + this.currName + "'");
        }
        int i3 = this.assemLen;
        if (i3 > 0) {
            int i4 = i3 + i2;
            byte[] bArr2 = this.recordBuf;
            if (i4 >= bArr2.length) {
                int length = bArr2.length - i3;
                java.lang.System.arraycopy(this.assemBuf, 0, bArr2, 0, i3);
                java.lang.System.arraycopy(bArr, i, this.recordBuf, this.assemLen, length);
                this.buffer.writeRecord(this.recordBuf);
                this.currBytes += this.recordBuf.length;
                i += length;
                i2 -= length;
                this.assemLen = 0;
            } else {
                java.lang.System.arraycopy(bArr, i, this.assemBuf, i3, i2);
                i += i2;
                this.assemLen += i2;
                i2 = 0;
            }
        }
        while (i2 > 0) {
            if (i2 < this.recordBuf.length) {
                java.lang.System.arraycopy(bArr, i, this.assemBuf, this.assemLen, i2);
                this.assemLen += i2;
                return;
            } else {
                this.buffer.writeRecord(bArr, i);
                int length2 = this.recordBuf.length;
                this.currBytes += length2;
                i2 -= length2;
                i += length2;
            }
        }
    }
}
