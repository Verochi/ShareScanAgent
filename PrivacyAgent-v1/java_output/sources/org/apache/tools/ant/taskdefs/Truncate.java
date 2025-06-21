package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Truncate extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.types.Path u;
    public boolean v = true;
    public boolean w = false;
    public java.lang.Long x;
    public java.lang.Long y;
    public static final java.lang.Long z = new java.lang.Long(0);
    public static final org.apache.tools.ant.util.FileUtils A = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final byte[] B = new byte[1024];

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        getPath().add(resourceCollection);
    }

    public final void c(java.io.File file) {
        long length = file.length();
        java.lang.Long l = this.x;
        long longValue = l == null ? this.y.longValue() + length : l.longValue();
        if (length == longValue) {
            return;
        }
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                try {
                    if (longValue > length) {
                        randomAccessFile.seek(length);
                        while (length < longValue) {
                            byte[] bArr = B;
                            long min = java.lang.Math.min(bArr.length, longValue - length);
                            randomAccessFile.write(bArr, 0, (int) min);
                            length += min;
                        }
                    } else {
                        randomAccessFile.setLength(longValue);
                    }
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException e) {
                        log("Caught " + e + " closing " + randomAccessFile, 1);
                    }
                } catch (java.lang.Throwable th) {
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException e2) {
                        log("Caught " + e2 + " closing " + randomAccessFile, 1);
                    }
                    throw th;
                }
            } catch (java.io.IOException e3) {
                throw new org.apache.tools.ant.BuildException("Exception working with " + randomAccessFile, e3);
            }
        } catch (java.lang.Exception e4) {
            throw new org.apache.tools.ant.BuildException("Could not open " + file + " for writing", e4);
        }
    }

    public final boolean d(java.io.File file) {
        if (file.isFile()) {
            return true;
        }
        if (!this.v) {
            return false;
        }
        try {
        } catch (java.io.IOException e) {
            e = e;
        }
        if (A.createNewFile(file, this.w)) {
            return true;
        }
        e = null;
        java.lang.String str = "Unable to create " + file;
        if (e != null) {
            throw new org.apache.tools.ant.BuildException(str, e);
        }
        log(str, 1);
        return false;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        java.lang.Long l = this.x;
        if (l != null && this.y != null) {
            throw new org.apache.tools.ant.BuildException("length and adjust are mutually exclusive options");
        }
        if (l == null && this.y == null) {
            this.x = z;
        }
        org.apache.tools.ant.types.Path path = this.u;
        if (path == null) {
            throw new org.apache.tools.ant.BuildException("No files specified.");
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = path.iterator();
        while (it.hasNext()) {
            java.io.File file = ((org.apache.tools.ant.types.resources.FileProvider) it.next().as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile();
            if (d(file)) {
                c(file);
            }
        }
    }

    public final synchronized org.apache.tools.ant.types.Path getPath() {
        if (this.u == null) {
            this.u = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.u;
    }

    public void setAdjust(java.lang.Long l) {
        this.y = l;
    }

    public void setCreate(boolean z2) {
        this.v = z2;
    }

    public void setFile(java.io.File file) {
        add(new org.apache.tools.ant.types.resources.FileResource(file));
    }

    public void setLength(java.lang.Long l) {
        this.x = l;
        if (l == null || l.longValue() >= 0) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Cannot truncate to length " + l);
    }

    public void setMkdirs(boolean z2) {
        this.w = z2;
    }
}
