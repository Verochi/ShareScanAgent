package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class UnicodeCommentExtraField extends org.apache.tools.zip.AbstractUnicodeExtraField {
    public static final org.apache.tools.zip.ZipShort UCOM_ID = new org.apache.tools.zip.ZipShort(25461);

    public UnicodeCommentExtraField() {
    }

    public UnicodeCommentExtraField(java.lang.String str, byte[] bArr) {
        super(str, bArr);
    }

    public UnicodeCommentExtraField(java.lang.String str, byte[] bArr, int i, int i2) {
        super(str, bArr, i, i2);
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getHeaderId() {
        return UCOM_ID;
    }
}
