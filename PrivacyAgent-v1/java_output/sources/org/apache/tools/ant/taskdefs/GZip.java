package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class GZip extends org.apache.tools.ant.taskdefs.Pack {
    @Override // org.apache.tools.ant.taskdefs.Pack
    public void pack() {
        java.lang.Throwable th;
        java.io.IOException e;
        try {
            try {
                java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(new java.io.FileOutputStream(this.zipFile));
                try {
                    zipResource(getSrcResource(), gZIPOutputStream);
                    org.apache.tools.ant.util.FileUtils.close(gZIPOutputStream);
                } catch (java.io.IOException e2) {
                    e = e2;
                    throw new org.apache.tools.ant.BuildException("Problem creating gzip " + e.getMessage(), e, getLocation());
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) null);
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
        } catch (java.lang.Throwable th3) {
            th = th3;
            org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) null);
            throw th;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Pack
    public boolean supportsNonFileResources() {
        return getClass().equals(org.apache.tools.ant.taskdefs.GZip.class);
    }
}
