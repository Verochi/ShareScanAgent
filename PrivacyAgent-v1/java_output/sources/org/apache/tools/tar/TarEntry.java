package org.apache.tools.tar;

/* loaded from: classes26.dex */
public class TarEntry implements org.apache.tools.tar.TarConstants {
    public static final int DEFAULT_DIR_MODE = 16877;
    public static final int DEFAULT_FILE_MODE = 33188;
    public static final int MAX_NAMELEN = 31;
    public static final int MILLIS_PER_SECOND = 1000;
    public java.lang.String a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public byte g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k;
    public java.lang.String l;
    public int m;
    public int n;
    public boolean o;
    public long p;
    public java.io.File q;

    public TarEntry() {
        this.i = org.apache.tools.tar.TarConstants.MAGIC_POSIX;
        this.j = org.apache.tools.tar.TarConstants.VERSION_POSIX;
        this.a = "";
        this.h = "";
        java.lang.String property = java.lang.System.getProperty("user.name", "");
        property = property.length() > 31 ? property.substring(0, 31) : property;
        this.c = 0L;
        this.d = 0L;
        this.k = property;
        this.l = "";
        this.q = null;
    }

    public TarEntry(java.io.File file) {
        this(file, file.getPath());
    }

    public TarEntry(java.io.File file, java.lang.String str) {
        this();
        java.lang.String d = d(str, false);
        this.q = file;
        this.h = "";
        if (file.isDirectory()) {
            this.b = 16877;
            this.g = org.apache.tools.tar.TarConstants.LF_DIR;
            int length = d.length();
            if (length == 0 || d.charAt(length - 1) != '/') {
                this.a = d + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            } else {
                this.a = d;
            }
            this.e = 0L;
        } else {
            this.b = 33188;
            this.g = org.apache.tools.tar.TarConstants.LF_NORMAL;
            this.e = file.length();
            this.a = d;
        }
        this.f = file.lastModified() / 1000;
        this.m = 0;
        this.n = 0;
    }

    public TarEntry(java.lang.String str) {
        this(str, false);
    }

    public TarEntry(java.lang.String str, byte b) {
        this(str);
        this.g = b;
        if (b == 76) {
            this.i = org.apache.tools.tar.TarConstants.GNU_TMAGIC;
            this.j = org.apache.tools.tar.TarConstants.VERSION_GNU_SPACE;
        }
    }

    public TarEntry(java.lang.String str, boolean z) {
        this();
        java.lang.String d = d(str, z);
        boolean endsWith = d.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        this.m = 0;
        this.n = 0;
        this.a = d;
        this.b = endsWith ? 16877 : 33188;
        this.g = endsWith ? org.apache.tools.tar.TarConstants.LF_DIR : org.apache.tools.tar.TarConstants.LF_NORMAL;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = new java.util.Date().getTime() / 1000;
        this.h = "";
        this.k = "";
        this.l = "";
    }

    public TarEntry(byte[] bArr) {
        this();
        parseTarHeader(bArr);
    }

    public TarEntry(byte[] bArr, org.apache.tools.zip.ZipEncoding zipEncoding) throws java.io.IOException {
        this();
        parseTarHeader(bArr, zipEncoding);
    }

    public static boolean b(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, boolean z) {
        int i5 = i2 < i4 ? i2 : i4;
        for (int i6 = 0; i6 < i5; i6++) {
            if (bArr[i + i6] != bArr2[i3 + i6]) {
                return false;
            }
        }
        if (i2 == i4) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (i2 > i4) {
            while (i4 < i2) {
                if (bArr[i + i4] != 0) {
                    return false;
                }
                i4++;
            }
        } else {
            while (i2 < i4) {
                if (bArr2[i3 + i2] != 0) {
                    return false;
                }
                i2++;
            }
        }
        return true;
    }

    public static boolean c(java.lang.String str, byte[] bArr, int i, int i2) {
        try {
            byte[] bytes = str.getBytes("ASCII");
            return b(bytes, 0, bytes.length, bArr, i, i2, false);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static java.lang.String d(java.lang.String str, boolean z) {
        int indexOf;
        java.lang.String lowerCase = java.lang.System.getProperty("os.name").toLowerCase(java.util.Locale.ENGLISH);
        if (lowerCase != null) {
            if (lowerCase.startsWith(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS)) {
                if (str.length() > 2) {
                    char charAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_NETWARE) && (indexOf = str.indexOf(58)) != -1) {
                str = str.substring(indexOf + 1);
            }
        }
        java.lang.String replace = str.replace(java.io.File.separatorChar, '/');
        while (!z && replace.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            replace = replace.substring(1);
        }
        return replace;
    }

    public final int a(byte[] bArr) {
        if (c(org.apache.tools.tar.TarConstants.GNU_TMAGIC, bArr, 257, 6)) {
            return 2;
        }
        return c(org.apache.tools.tar.TarConstants.MAGIC_POSIX, bArr, 257, 6) ? 3 : 0;
    }

    public final void e(byte[] bArr, org.apache.tools.zip.ZipEncoding zipEncoding, boolean z) throws java.io.IOException {
        this.a = z ? org.apache.tools.tar.TarUtils.parseName(bArr, 0, 100) : org.apache.tools.tar.TarUtils.parseName(bArr, 0, 100, zipEncoding);
        this.b = (int) org.apache.tools.tar.TarUtils.parseOctalOrBinary(bArr, 100, 8);
        this.c = (int) org.apache.tools.tar.TarUtils.parseOctalOrBinary(bArr, 108, 8);
        this.d = (int) org.apache.tools.tar.TarUtils.parseOctalOrBinary(bArr, 116, 8);
        this.e = org.apache.tools.tar.TarUtils.parseOctalOrBinary(bArr, 124, 12);
        this.f = org.apache.tools.tar.TarUtils.parseOctalOrBinary(bArr, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 12);
        this.g = bArr[156];
        this.h = z ? org.apache.tools.tar.TarUtils.parseName(bArr, 157, 100) : org.apache.tools.tar.TarUtils.parseName(bArr, 157, 100, zipEncoding);
        this.i = org.apache.tools.tar.TarUtils.parseName(bArr, 257, 6);
        this.j = org.apache.tools.tar.TarUtils.parseName(bArr, org.apache.tools.tar.TarConstants.VERSION_OFFSET, 2);
        this.k = z ? org.apache.tools.tar.TarUtils.parseName(bArr, 265, 32) : org.apache.tools.tar.TarUtils.parseName(bArr, 265, 32, zipEncoding);
        this.l = z ? org.apache.tools.tar.TarUtils.parseName(bArr, com.anythink.expressad.foundation.g.a.aV, 32) : org.apache.tools.tar.TarUtils.parseName(bArr, com.anythink.expressad.foundation.g.a.aV, 32, zipEncoding);
        this.m = (int) org.apache.tools.tar.TarUtils.parseOctalOrBinary(bArr, 329, 8);
        this.n = (int) org.apache.tools.tar.TarUtils.parseOctalOrBinary(bArr, 337, 8);
        if (a(bArr) == 2) {
            this.o = org.apache.tools.tar.TarUtils.parseBoolean(bArr, 482);
            this.p = org.apache.tools.tar.TarUtils.parseOctal(bArr, 483, 12);
            return;
        }
        java.lang.String parseName = z ? org.apache.tools.tar.TarUtils.parseName(bArr, 345, org.apache.tools.tar.TarConstants.PREFIXLEN) : org.apache.tools.tar.TarUtils.parseName(bArr, 345, org.apache.tools.tar.TarConstants.PREFIXLEN, zipEncoding);
        if (isDirectory() && !this.a.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            this.a += net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        if (parseName.length() > 0) {
            this.a = parseName + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.a;
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return equals((org.apache.tools.tar.TarEntry) obj);
    }

    public boolean equals(org.apache.tools.tar.TarEntry tarEntry) {
        return tarEntry != null && getName().equals(tarEntry.getName());
    }

    public final int f(long j, byte[] bArr, int i, int i2, boolean z) {
        return (z || (j >= 0 && j < (1 << ((i2 + (-1)) * 3)))) ? org.apache.tools.tar.TarUtils.formatLongOctalOrBinaryBytes(j, bArr, i, i2) : org.apache.tools.tar.TarUtils.formatLongOctalBytes(0L, bArr, i, i2);
    }

    public int getDevMajor() {
        return this.m;
    }

    public int getDevMinor() {
        return this.n;
    }

    public org.apache.tools.tar.TarEntry[] getDirectoryEntries() {
        java.io.File file = this.q;
        if (file == null || !file.isDirectory()) {
            return new org.apache.tools.tar.TarEntry[0];
        }
        java.lang.String[] list = this.q.list();
        org.apache.tools.tar.TarEntry[] tarEntryArr = new org.apache.tools.tar.TarEntry[list.length];
        for (int i = 0; i < list.length; i++) {
            tarEntryArr[i] = new org.apache.tools.tar.TarEntry(new java.io.File(this.q, list[i]));
        }
        return tarEntryArr;
    }

    public java.io.File getFile() {
        return this.q;
    }

    @java.lang.Deprecated
    public int getGroupId() {
        return (int) (this.d & (-1));
    }

    public java.lang.String getGroupName() {
        return this.l.toString();
    }

    public java.lang.String getLinkName() {
        return this.h.toString();
    }

    public long getLongGroupId() {
        return this.d;
    }

    public long getLongUserId() {
        return this.c;
    }

    public java.util.Date getModTime() {
        return new java.util.Date(this.f * 1000);
    }

    public int getMode() {
        return this.b;
    }

    public java.lang.String getName() {
        return this.a.toString();
    }

    public long getRealSize() {
        return this.p;
    }

    public long getSize() {
        return this.e;
    }

    @java.lang.Deprecated
    public int getUserId() {
        return (int) (this.c & (-1));
    }

    public java.lang.String getUserName() {
        return this.k.toString();
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isBlockDevice() {
        return this.g == 52;
    }

    public boolean isCharacterDevice() {
        return this.g == 51;
    }

    public boolean isDescendent(org.apache.tools.tar.TarEntry tarEntry) {
        return tarEntry.getName().startsWith(getName());
    }

    public boolean isDirectory() {
        java.io.File file = this.q;
        return file != null ? file.isDirectory() : this.g == 53 || getName().endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
    }

    public boolean isExtended() {
        return this.o;
    }

    public boolean isFIFO() {
        return this.g == 54;
    }

    public boolean isFile() {
        java.io.File file = this.q;
        if (file != null) {
            return file.isFile();
        }
        byte b = this.g;
        if (b == 0 || b == 48) {
            return true;
        }
        return !getName().endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
    }

    public boolean isGNULongLinkEntry() {
        return this.g == 75;
    }

    public boolean isGNULongNameEntry() {
        return this.g == 76;
    }

    public boolean isGNUSparse() {
        return this.g == 83;
    }

    public boolean isGlobalPaxHeader() {
        return this.g == 103;
    }

    public boolean isLink() {
        return this.g == 49;
    }

    public boolean isPaxHeader() {
        byte b = this.g;
        return b == 120 || b == 88;
    }

    public boolean isSymbolicLink() {
        return this.g == 50;
    }

    public void parseTarHeader(byte[] bArr) {
        try {
            try {
                parseTarHeader(bArr, org.apache.tools.tar.TarUtils.a);
            } catch (java.io.IOException unused) {
                e(bArr, org.apache.tools.tar.TarUtils.a, true);
            }
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public void parseTarHeader(byte[] bArr, org.apache.tools.zip.ZipEncoding zipEncoding) throws java.io.IOException {
        e(bArr, zipEncoding, false);
    }

    public void setDevMajor(int i) {
        if (i >= 0) {
            this.m = i;
            return;
        }
        throw new java.lang.IllegalArgumentException("Major device number is out of range: " + i);
    }

    public void setDevMinor(int i) {
        if (i >= 0) {
            this.n = i;
            return;
        }
        throw new java.lang.IllegalArgumentException("Minor device number is out of range: " + i);
    }

    public void setGroupId(int i) {
        setGroupId(i);
    }

    public void setGroupId(long j) {
        this.d = j;
    }

    public void setGroupName(java.lang.String str) {
        this.l = str;
    }

    public void setIds(int i, int i2) {
        setUserId(i);
        setGroupId(i2);
    }

    public void setLinkName(java.lang.String str) {
        this.h = str;
    }

    public void setModTime(long j) {
        this.f = j / 1000;
    }

    public void setModTime(java.util.Date date) {
        this.f = date.getTime() / 1000;
    }

    public void setMode(int i) {
        this.b = i;
    }

    public void setName(java.lang.String str) {
        this.a = d(str, false);
    }

    public void setNames(java.lang.String str, java.lang.String str2) {
        setUserName(str);
        setGroupName(str2);
    }

    public void setSize(long j) {
        if (j >= 0) {
            this.e = j;
            return;
        }
        throw new java.lang.IllegalArgumentException("Size is out of range: " + j);
    }

    public void setUserId(int i) {
        setUserId(i);
    }

    public void setUserId(long j) {
        this.c = j;
    }

    public void setUserName(java.lang.String str) {
        this.k = str;
    }

    public void writeEntryHeader(byte[] bArr) {
        try {
            try {
                writeEntryHeader(bArr, org.apache.tools.tar.TarUtils.a, false);
            } catch (java.io.IOException unused) {
                writeEntryHeader(bArr, org.apache.tools.tar.TarUtils.b, false);
            }
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public void writeEntryHeader(byte[] bArr, org.apache.tools.zip.ZipEncoding zipEncoding, boolean z) throws java.io.IOException {
        int f = f(this.f, bArr, f(this.e, bArr, f(this.d, bArr, f(this.c, bArr, f(this.b, bArr, org.apache.tools.tar.TarUtils.formatNameBytes(this.a, bArr, 0, 100, zipEncoding), 8, z), 8, z), 8, z), 12, z), 12, z);
        int i = f;
        int i2 = 0;
        while (i2 < 8) {
            bArr[i] = 32;
            i2++;
            i++;
        }
        bArr[i] = this.g;
        for (int f2 = f(this.n, bArr, f(this.m, bArr, org.apache.tools.tar.TarUtils.formatNameBytes(this.l, bArr, org.apache.tools.tar.TarUtils.formatNameBytes(this.k, bArr, org.apache.tools.tar.TarUtils.formatNameBytes(this.j, bArr, org.apache.tools.tar.TarUtils.formatNameBytes(this.i, bArr, org.apache.tools.tar.TarUtils.formatNameBytes(this.h, bArr, i + 1, 100, zipEncoding), 6), 2), 32, zipEncoding), 32, zipEncoding), 8, z), 8, z); f2 < bArr.length; f2++) {
            bArr[f2] = 0;
        }
        org.apache.tools.tar.TarUtils.formatCheckSumOctalBytes(org.apache.tools.tar.TarUtils.computeCheckSum(bArr), bArr, f, 8);
    }
}
