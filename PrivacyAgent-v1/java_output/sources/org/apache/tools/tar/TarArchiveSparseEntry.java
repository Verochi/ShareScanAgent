package org.apache.tools.tar;

/* loaded from: classes26.dex */
public class TarArchiveSparseEntry implements org.apache.tools.tar.TarConstants {
    public boolean a;

    public TarArchiveSparseEntry(byte[] bArr) throws java.io.IOException {
        this.a = org.apache.tools.tar.TarUtils.parseBoolean(bArr, 504);
    }

    public boolean isExtended() {
        return this.a;
    }
}
