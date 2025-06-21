package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class LeadPipeInputStream extends java.io.PipedInputStream {
    public org.apache.tools.ant.ProjectComponent n;

    public LeadPipeInputStream() {
    }

    public LeadPipeInputStream(int i) {
        setBufferSize(i);
    }

    public LeadPipeInputStream(java.io.PipedOutputStream pipedOutputStream) throws java.io.IOException {
        super(pipedOutputStream);
    }

    public LeadPipeInputStream(java.io.PipedOutputStream pipedOutputStream, int i) throws java.io.IOException {
        super(pipedOutputStream);
        setBufferSize(i);
    }

    public void log(java.lang.String str, int i) {
        org.apache.tools.ant.ProjectComponent projectComponent = this.n;
        if (projectComponent != null) {
            projectComponent.log(str, i);
        } else if (i > 1) {
            java.lang.System.out.println(str);
        } else {
            java.lang.System.err.println(str);
        }
    }

    @Override // java.io.PipedInputStream, java.io.InputStream
    public synchronized int read() throws java.io.IOException {
        int i;
        try {
            i = super.read();
        } catch (java.io.IOException e) {
            java.lang.String message = e.getMessage();
            if (!"write end dead".equalsIgnoreCase(message) && !"pipe broken".equalsIgnoreCase(message)) {
                log("error at LeadPipeInputStream.read():  " + message, 2);
                i = -1;
            }
            int i2 = ((java.io.PipedInputStream) this).in;
            if (i2 > 0) {
                int i3 = ((java.io.PipedInputStream) this).out;
                byte[] bArr = ((java.io.PipedInputStream) this).buffer;
                if (i3 < bArr.length && i3 > i2) {
                    ((java.io.PipedInputStream) this).out = i3 + 1;
                    i = bArr[i3] & 255;
                }
            }
            i = -1;
        }
        return i;
    }

    public synchronized void setBufferSize(int i) {
        byte[] bArr = ((java.io.PipedInputStream) this).buffer;
        if (i > bArr.length) {
            byte[] bArr2 = new byte[i];
            int i2 = ((java.io.PipedInputStream) this).in;
            if (i2 >= 0) {
                int i3 = ((java.io.PipedInputStream) this).out;
                if (i2 > i3) {
                    java.lang.System.arraycopy(bArr, i3, bArr2, i3, i2 - i3);
                } else {
                    int length = bArr.length - i3;
                    java.lang.System.arraycopy(bArr, i3, bArr2, 0, length);
                    java.lang.System.arraycopy(((java.io.PipedInputStream) this).buffer, 0, bArr2, length, ((java.io.PipedInputStream) this).in);
                    ((java.io.PipedInputStream) this).in += length;
                    ((java.io.PipedInputStream) this).out = 0;
                }
            }
            ((java.io.PipedInputStream) this).buffer = bArr2;
        }
    }

    public void setManagingComponent(org.apache.tools.ant.ProjectComponent projectComponent) {
        this.n = projectComponent;
    }

    public void setManagingTask(org.apache.tools.ant.Task task) {
        setManagingComponent(task);
    }
}
