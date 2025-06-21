package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class DemuxInputStream extends java.io.InputStream {
    public org.apache.tools.ant.Project n;

    public DemuxInputStream(org.apache.tools.ant.Project project) {
        this.n = project;
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        byte[] bArr = new byte[1];
        if (this.n.demuxInput(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        return this.n.demuxInput(bArr, i, i2);
    }
}
