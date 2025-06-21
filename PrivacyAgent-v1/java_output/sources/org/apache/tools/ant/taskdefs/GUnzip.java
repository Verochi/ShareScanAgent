package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class GUnzip extends org.apache.tools.ant.taskdefs.Unpack {
    @Override // org.apache.tools.ant.taskdefs.Unpack
    public void extract() {
        java.io.InputStream inputStream;
        java.util.zip.GZIPInputStream gZIPInputStream;
        java.lang.Throwable th;
        java.io.FileOutputStream fileOutputStream;
        java.io.IOException e;
        if (this.srcResource.getLastModified() <= this.dest.lastModified()) {
            return;
        }
        log("Expanding " + this.srcResource.getName() + " to " + this.dest.getAbsolutePath());
        try {
            fileOutputStream = new java.io.FileOutputStream(this.dest);
            try {
                inputStream = this.srcResource.getInputStream();
            } catch (java.io.IOException e2) {
                gZIPInputStream = null;
                e = e2;
                inputStream = null;
            } catch (java.lang.Throwable th2) {
                gZIPInputStream = null;
                th = th2;
                inputStream = null;
            }
            try {
                gZIPInputStream = new java.util.zip.GZIPInputStream(inputStream);
                try {
                    try {
                        byte[] bArr = new byte[8192];
                        int i = 0;
                        do {
                            fileOutputStream.write(bArr, 0, i);
                            i = gZIPInputStream.read(bArr, 0, 8192);
                        } while (i != -1);
                        org.apache.tools.ant.util.FileUtils.close(inputStream);
                        org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                        org.apache.tools.ant.util.FileUtils.close(gZIPInputStream);
                    } catch (java.io.IOException e3) {
                        e = e3;
                        throw new org.apache.tools.ant.BuildException("Problem expanding gzip " + e.getMessage(), e, getLocation());
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    org.apache.tools.ant.util.FileUtils.close(inputStream);
                    org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                    org.apache.tools.ant.util.FileUtils.close(gZIPInputStream);
                    throw th;
                }
            } catch (java.io.IOException e4) {
                gZIPInputStream = null;
                e = e4;
            } catch (java.lang.Throwable th4) {
                gZIPInputStream = null;
                th = th4;
                org.apache.tools.ant.util.FileUtils.close(inputStream);
                org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                org.apache.tools.ant.util.FileUtils.close(gZIPInputStream);
                throw th;
            }
        } catch (java.io.IOException e5) {
            inputStream = null;
            gZIPInputStream = null;
            e = e5;
            fileOutputStream = null;
        } catch (java.lang.Throwable th5) {
            inputStream = null;
            gZIPInputStream = null;
            th = th5;
            fileOutputStream = null;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Unpack
    public java.lang.String getDefaultExtension() {
        return ".gz";
    }

    @Override // org.apache.tools.ant.taskdefs.Unpack
    public boolean supportsNonFileResources() {
        return getClass().equals(org.apache.tools.ant.taskdefs.GUnzip.class);
    }
}
