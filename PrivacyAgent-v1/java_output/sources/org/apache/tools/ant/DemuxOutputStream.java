package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class DemuxOutputStream extends java.io.OutputStream {
    public java.util.WeakHashMap<java.lang.Thread, org.apache.tools.ant.DemuxOutputStream.BufferInfo> n = new java.util.WeakHashMap<>();
    public org.apache.tools.ant.Project t;
    public boolean u;

    public static class BufferInfo {
        public java.io.ByteArrayOutputStream a;
        public boolean b;

        public BufferInfo() {
            this.b = false;
        }

        public /* synthetic */ BufferInfo(org.apache.tools.ant.DemuxOutputStream.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public DemuxOutputStream(org.apache.tools.ant.Project project, boolean z) {
        this.t = project;
        this.u = z;
    }

    public final org.apache.tools.ant.DemuxOutputStream.BufferInfo a() {
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        org.apache.tools.ant.DemuxOutputStream.BufferInfo bufferInfo = this.n.get(currentThread);
        if (bufferInfo != null) {
            return bufferInfo;
        }
        org.apache.tools.ant.DemuxOutputStream.BufferInfo bufferInfo2 = new org.apache.tools.ant.DemuxOutputStream.BufferInfo(null);
        bufferInfo2.a = new java.io.ByteArrayOutputStream(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID);
        bufferInfo2.b = false;
        this.n.put(currentThread, bufferInfo2);
        return bufferInfo2;
    }

    public final void c() {
        this.n.remove(java.lang.Thread.currentThread());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        flush();
        c();
    }

    public final void e() {
        org.apache.tools.ant.DemuxOutputStream.BufferInfo bufferInfo = this.n.get(java.lang.Thread.currentThread());
        org.apache.tools.ant.util.FileUtils.close(bufferInfo.a);
        bufferInfo.a = new java.io.ByteArrayOutputStream();
        bufferInfo.b = false;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        org.apache.tools.ant.DemuxOutputStream.BufferInfo a = a();
        if (a.a.size() > 0) {
            processFlush(a.a);
        }
    }

    public void processBuffer(java.io.ByteArrayOutputStream byteArrayOutputStream) {
        this.t.demuxOutput(byteArrayOutputStream.toString(), this.u);
        e();
    }

    public void processFlush(java.io.ByteArrayOutputStream byteArrayOutputStream) {
        this.t.demuxFlush(byteArrayOutputStream.toString(), this.u);
        e();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        byte b = (byte) i;
        org.apache.tools.ant.DemuxOutputStream.BufferInfo a = a();
        if (b == 10) {
            a.a.write(i);
            processBuffer(a.a);
        } else {
            if (a.b) {
                processBuffer(a.a);
            }
            a.a.write(i);
        }
        a.b = b == 13;
        if (a.b || a.a.size() <= 1024) {
            return;
        }
        processBuffer(a.a);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        byte b;
        org.apache.tools.ant.DemuxOutputStream.BufferInfo a = a();
        while (i2 > 0) {
            int i3 = i;
            while (i2 > 0 && (b = bArr[i3]) != 10 && b != 13) {
                i3++;
                i2--;
            }
            int i4 = i3 - i;
            if (i4 > 0) {
                a.a.write(bArr, i, i4);
            }
            i = i3;
            while (i2 > 0) {
                byte b2 = bArr[i];
                if (b2 == 10 || b2 == 13) {
                    write(b2);
                    i++;
                    i2--;
                }
            }
        }
    }
}
