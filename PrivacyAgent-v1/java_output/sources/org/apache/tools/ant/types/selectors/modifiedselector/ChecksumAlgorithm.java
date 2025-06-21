package org.apache.tools.ant.types.selectors.modifiedselector;

/* loaded from: classes26.dex */
public class ChecksumAlgorithm implements org.apache.tools.ant.types.selectors.modifiedselector.Algorithm {
    public java.lang.String a = "CRC";
    public java.util.zip.Checksum b = null;

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Algorithm
    public java.lang.String getValue(java.io.File file) {
        initChecksum();
        try {
            if (!file.canRead()) {
                return null;
            }
            this.b.reset();
            java.util.zip.CheckedInputStream checkedInputStream = new java.util.zip.CheckedInputStream(new java.io.FileInputStream(file), this.b);
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(checkedInputStream);
            while (bufferedInputStream.read() != -1) {
            }
            java.lang.String l = java.lang.Long.toString(checkedInputStream.getChecksum().getValue());
            bufferedInputStream.close();
            return l;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public void initChecksum() {
        if (this.b != null) {
            return;
        }
        if ("CRC".equals(this.a)) {
            this.b = new java.util.zip.CRC32();
        } else {
            if (!"ADLER".equals(this.a)) {
                throw new org.apache.tools.ant.BuildException(new java.security.NoSuchAlgorithmException());
            }
            this.b = new java.util.zip.Adler32();
        }
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Algorithm
    public boolean isValid() {
        return "CRC".equals(this.a) || "ADLER".equals(this.a);
    }

    public void setAlgorithm(java.lang.String str) {
        this.a = str != null ? str.toUpperCase(java.util.Locale.ENGLISH) : null;
    }

    public java.lang.String toString() {
        return "<ChecksumAlgorithm:algorithm=" + this.a + ">";
    }
}
