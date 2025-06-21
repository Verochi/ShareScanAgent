package org.apache.tools.ant.types.selectors.modifiedselector;

/* loaded from: classes26.dex */
public class DigestAlgorithm implements org.apache.tools.ant.types.selectors.modifiedselector.Algorithm {
    public java.lang.String a = "MD5";
    public java.lang.String b = null;
    public java.security.MessageDigest c = null;
    public int d = 8192;

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Algorithm
    public java.lang.String getValue(java.io.File file) {
        int i;
        if (!file.canRead()) {
            return null;
        }
        initMessageDigest();
        try {
            byte[] bArr = new byte[this.d];
            this.c.reset();
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            java.security.DigestInputStream digestInputStream = new java.security.DigestInputStream(fileInputStream, this.c);
            do {
            } while (digestInputStream.read(bArr, 0, this.d) != -1);
            digestInputStream.close();
            fileInputStream.close();
            byte[] digest = this.c.digest();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (byte b : digest) {
                java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public void initMessageDigest() {
        if (this.c != null) {
            return;
        }
        java.lang.String str = this.b;
        if (str == null || "".equals(str) || com.igexin.push.core.b.m.equals(this.b)) {
            try {
                this.c = java.security.MessageDigest.getInstance(this.a);
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new org.apache.tools.ant.BuildException(e);
            }
        } else {
            try {
                this.c = java.security.MessageDigest.getInstance(this.a, this.b);
            } catch (java.security.NoSuchAlgorithmException e2) {
                throw new org.apache.tools.ant.BuildException(e2);
            } catch (java.security.NoSuchProviderException e3) {
                throw new org.apache.tools.ant.BuildException(e3);
            }
        }
    }

    @Override // org.apache.tools.ant.types.selectors.modifiedselector.Algorithm
    public boolean isValid() {
        return com.huawei.secure.android.common.encrypt.hash.SHA.a.equals(this.a) || "MD5".equals(this.a);
    }

    public void setAlgorithm(java.lang.String str) {
        this.a = str != null ? str.toUpperCase(java.util.Locale.ENGLISH) : null;
    }

    public void setProvider(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String toString() {
        return "<DigestAlgorithm:algorithm=" + this.a + ";provider=" + this.b + ">";
    }
}
