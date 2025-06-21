package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class UnicodePathExtraField extends org.apache.tools.zip.AbstractUnicodeExtraField {
    public static final org.apache.tools.zip.ZipShort UPATH_ID = new org.apache.tools.zip.ZipShort(28789);

    public UnicodePathExtraField() {
    }

    public UnicodePathExtraField(java.lang.String str, byte[] bArr) {
        super(str, bArr);
    }

    public UnicodePathExtraField(java.lang.String str, byte[] bArr, int i, int i2) {
        super(str, bArr, i, i2);
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getHeaderId() {
        return UPATH_ID;
    }
}
