package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class ZipParameters implements java.lang.Cloneable {
    public java.lang.String A;
    public int C;
    public java.lang.String D;
    public java.lang.String E;
    public boolean F;
    public int t;
    public char[] x;
    public int n = 8;
    public boolean u = false;
    public boolean w = true;
    public int v = -1;
    public int y = -1;
    public boolean z = true;
    public java.util.TimeZone B = java.util.TimeZone.getDefault();

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return super.clone();
    }

    public int getAesKeyStrength() {
        return this.y;
    }

    public int getCompressionLevel() {
        return this.t;
    }

    public int getCompressionMethod() {
        return this.n;
    }

    public java.lang.String getDefaultFolderPath() {
        return this.D;
    }

    public int getEncryptionMethod() {
        return this.v;
    }

    public java.lang.String getFileNameInZip() {
        return this.E;
    }

    public char[] getPassword() {
        return this.x;
    }

    public java.lang.String getRootFolderInZip() {
        return this.A;
    }

    public int getSourceFileCRC() {
        return this.C;
    }

    public java.util.TimeZone getTimeZone() {
        return this.B;
    }

    public boolean isEncryptFiles() {
        return this.u;
    }

    public boolean isIncludeRootFolder() {
        return this.z;
    }

    public boolean isReadHiddenFiles() {
        return this.w;
    }

    public boolean isSourceExternalStream() {
        return this.F;
    }

    public void setAesKeyStrength(int i) {
        this.y = i;
    }

    public void setCompressionLevel(int i) {
        this.t = i;
    }

    public void setCompressionMethod(int i) {
        this.n = i;
    }

    public void setDefaultFolderPath(java.lang.String str) {
        this.D = str;
    }

    public void setEncryptFiles(boolean z) {
        this.u = z;
    }

    public void setEncryptionMethod(int i) {
        this.v = i;
    }

    public void setFileNameInZip(java.lang.String str) {
        this.E = str;
    }

    public void setIncludeRootFolder(boolean z) {
        this.z = z;
    }

    public void setPassword(java.lang.String str) {
        if (str == null) {
            return;
        }
        setPassword(str.toCharArray());
    }

    public void setPassword(char[] cArr) {
        this.x = cArr;
    }

    public void setReadHiddenFiles(boolean z) {
        this.w = z;
    }

    public void setRootFolderInZip(java.lang.String str) {
        if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            if (!str.endsWith("\\") && !str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                str = str + net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR;
            }
            str = str.replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        }
        this.A = str;
    }

    public void setSourceExternalStream(boolean z) {
        this.F = z;
    }

    public void setSourceFileCRC(int i) {
        this.C = i;
    }

    public void setTimeZone(java.util.TimeZone timeZone) {
        this.B = timeZone;
    }
}
