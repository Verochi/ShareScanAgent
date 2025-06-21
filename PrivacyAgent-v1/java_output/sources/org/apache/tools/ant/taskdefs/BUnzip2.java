package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class BUnzip2 extends org.apache.tools.ant.taskdefs.Unpack {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [long] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // org.apache.tools.ant.taskdefs.Unpack
    public void extract() {
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Throwable th;
        java.io.IOException e;
        long lastModified = this.srcResource.getLastModified();
        ?? lastModified2 = this.dest.lastModified();
        ?? r4 = (lastModified > lastModified2 ? 1 : (lastModified == lastModified2 ? 0 : -1));
        if (r4 <= 0) {
            return;
        }
        ?? sb = new java.lang.StringBuilder();
        sb.append("Expanding ");
        sb.append(this.srcResource.getName());
        sb.append(" to ");
        ?? absolutePath = this.dest.getAbsolutePath();
        sb.append(absolutePath);
        log(sb.toString());
        try {
            try {
                absolutePath = new java.io.FileOutputStream(this.dest);
                try {
                    lastModified2 = this.srcResource.getInputStream();
                    try {
                        bufferedInputStream = new java.io.BufferedInputStream(lastModified2);
                    } catch (java.io.IOException e2) {
                        e = e2;
                    } catch (java.lang.Throwable th2) {
                        r4 = 0;
                        th = th2;
                        bufferedInputStream = null;
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                } catch (java.lang.Throwable th3) {
                    bufferedInputStream = null;
                    r4 = 0;
                    th = th3;
                    lastModified2 = 0;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
            try {
                if (bufferedInputStream.read() != 66) {
                    throw new org.apache.tools.ant.BuildException("Invalid bz2 file.", getLocation());
                }
                if (bufferedInputStream.read() != 90) {
                    throw new org.apache.tools.ant.BuildException("Invalid bz2 file.", getLocation());
                }
                org.apache.tools.bzip2.CBZip2InputStream cBZip2InputStream = new org.apache.tools.bzip2.CBZip2InputStream(bufferedInputStream, true);
                try {
                    byte[] bArr = new byte[8192];
                    int i = 0;
                    do {
                        absolutePath.write(bArr, 0, i);
                        i = cBZip2InputStream.read(bArr, 0, 8192);
                    } while (i != -1);
                    org.apache.tools.ant.util.FileUtils.close(bufferedInputStream);
                    org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) lastModified2);
                    org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) absolutePath);
                    org.apache.tools.ant.util.FileUtils.close(cBZip2InputStream);
                } catch (java.io.IOException e4) {
                    e = e4;
                    throw new org.apache.tools.ant.BuildException("Problem expanding bzip2 " + e.getMessage(), e, getLocation());
                }
            } catch (java.io.IOException e5) {
                e = e5;
            } catch (java.lang.Throwable th5) {
                r4 = 0;
                th = th5;
                org.apache.tools.ant.util.FileUtils.close(bufferedInputStream);
                org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) lastModified2);
                org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) absolutePath);
                org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) r4);
                throw th;
            }
        } catch (java.io.IOException e6) {
            e = e6;
        } catch (java.lang.Throwable th6) {
            lastModified2 = 0;
            bufferedInputStream = null;
            r4 = 0;
            th = th6;
            absolutePath = 0;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Unpack
    public java.lang.String getDefaultExtension() {
        return ".bz2";
    }

    @Override // org.apache.tools.ant.taskdefs.Unpack
    public boolean supportsNonFileResources() {
        return getClass().equals(org.apache.tools.ant.taskdefs.BUnzip2.class);
    }
}
