package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class BZip2 extends org.apache.tools.ant.taskdefs.Pack {
    @Override // org.apache.tools.ant.taskdefs.Pack
    public void pack() {
        org.apache.tools.bzip2.CBZip2OutputStream cBZip2OutputStream;
        java.lang.Throwable th;
        java.io.IOException e;
        try {
            java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(this.zipFile));
            bufferedOutputStream.write(66);
            bufferedOutputStream.write(90);
            cBZip2OutputStream = new org.apache.tools.bzip2.CBZip2OutputStream(bufferedOutputStream);
            try {
                try {
                    zipResource(getSrcResource(), cBZip2OutputStream);
                    org.apache.tools.ant.util.FileUtils.close(cBZip2OutputStream);
                } catch (java.io.IOException e2) {
                    e = e2;
                    throw new org.apache.tools.ant.BuildException("Problem creating bzip2 " + e.getMessage(), e, getLocation());
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                org.apache.tools.ant.util.FileUtils.close(cBZip2OutputStream);
                throw th;
            }
        } catch (java.io.IOException e3) {
            cBZip2OutputStream = null;
            e = e3;
        } catch (java.lang.Throwable th3) {
            cBZip2OutputStream = null;
            th = th3;
            org.apache.tools.ant.util.FileUtils.close(cBZip2OutputStream);
            throw th;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Pack
    public boolean supportsNonFileResources() {
        return getClass().equals(org.apache.tools.ant.taskdefs.BZip2.class);
    }
}
