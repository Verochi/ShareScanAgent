package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public abstract class BaseFilterReader extends java.io.FilterReader {
    public boolean n;
    public org.apache.tools.ant.Project t;

    public BaseFilterReader() {
        super(new java.io.StringReader(""));
        this.n = false;
        this.t = null;
        org.apache.tools.ant.util.FileUtils.close(this);
    }

    public BaseFilterReader(java.io.Reader reader) {
        super(reader);
        this.n = false;
        this.t = null;
    }

    public final boolean getInitialized() {
        return this.n;
    }

    public final org.apache.tools.ant.Project getProject() {
        return this.t;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public final int read(char[] cArr, int i, int i2) throws java.io.IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            int read = read();
            if (read == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            cArr[i + i3] = (char) read;
        }
        return i2;
    }

    public final java.lang.String readFully() throws java.io.IOException {
        return org.apache.tools.ant.util.FileUtils.readFully(((java.io.FilterReader) this).in, 8192);
    }

    public final java.lang.String readLine() throws java.io.IOException {
        int read = ((java.io.FilterReader) this).in.read();
        if (read == -1) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (read != -1) {
            stringBuffer.append((char) read);
            if (read == 10) {
                break;
            }
            read = ((java.io.FilterReader) this).in.read();
        }
        return stringBuffer.toString();
    }

    public final void setInitialized(boolean z) {
        this.n = z;
    }

    public final void setProject(org.apache.tools.ant.Project project) {
        this.t = project;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public final long skip(long j) throws java.io.IOException, java.lang.IllegalArgumentException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("skip value is negative");
        }
        for (long j2 = 0; j2 < j; j2++) {
            if (read() == -1) {
                return j2;
            }
        }
        return j;
    }
}
