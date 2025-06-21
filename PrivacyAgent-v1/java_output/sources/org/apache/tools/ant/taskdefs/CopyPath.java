package org.apache.tools.ant.taskdefs;

@java.lang.Deprecated
/* loaded from: classes25.dex */
public class CopyPath extends org.apache.tools.ant.Task {
    public static final java.lang.String ERROR_NO_DESTDIR = "No destDir specified";
    public static final java.lang.String ERROR_NO_MAPPER = "No mapper specified";
    public static final java.lang.String ERROR_NO_PATH = "No path specified";
    public static final org.apache.tools.ant.util.FileUtils z = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public org.apache.tools.ant.util.FileNameMapper u;
    public org.apache.tools.ant.types.Path v;
    public java.io.File w;
    public long x = z.getFileTimestampGranularity();
    public boolean y = false;

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        if (this.u != null) {
            throw new org.apache.tools.ant.BuildException("Only one mapper allowed");
        }
        this.u = fileNameMapper;
    }

    public org.apache.tools.ant.types.Path createPath() {
        if (this.v == null) {
            this.v = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.v;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File file;
        java.io.File file2;
        int i;
        int i2;
        java.lang.String[] strArr;
        log("This task should have never been released and was obsoleted by ResourceCollection support in <copy> available since Ant 1.7.0.  Don't use it.", 0);
        validateAttributes();
        java.lang.String[] list = this.v.list();
        int i3 = 3;
        if (list.length == 0) {
            log("Path is empty", 3);
            return;
        }
        int length = list.length;
        int i4 = 0;
        while (i4 < length) {
            java.lang.String str = list[i4];
            java.io.File file3 = new java.io.File(str);
            java.lang.String[] mapFileName = this.u.mapFileName(str);
            if (mapFileName != null) {
                int length2 = mapFileName.length;
                int i5 = 0;
                while (i5 < length2) {
                    java.io.File file4 = new java.io.File(this.w, mapFileName[i5]);
                    if (file3.equals(file4)) {
                        log("Skipping self-copy of " + str, i3);
                    } else if (file3.isDirectory()) {
                        log("Skipping directory " + str);
                    } else {
                        try {
                            log("Copying " + file3 + " to " + file4, i3);
                            file = file4;
                            i = i5;
                            i2 = length2;
                            strArr = mapFileName;
                            file2 = file3;
                        } catch (java.io.IOException e) {
                            e = e;
                            file = file4;
                            file2 = file3;
                        }
                        try {
                            z.copyFile(file3, file4, (org.apache.tools.ant.types.FilterSetCollection) null, (java.util.Vector) null, false, this.y, (java.lang.String) null, (java.lang.String) null, getProject());
                            i5 = i + 1;
                            file3 = file2;
                            mapFileName = strArr;
                            length2 = i2;
                            i3 = 3;
                        } catch (java.io.IOException e2) {
                            e = e2;
                            java.lang.String str2 = "Failed to copy " + file2 + " to " + file + " due to " + e.getMessage();
                            if (file.exists() && !file.delete()) {
                                str2 = str2 + " and I couldn't delete the corrupt " + file;
                            }
                            throw new org.apache.tools.ant.BuildException(str2, e, getLocation());
                        }
                    }
                    i = i5;
                    i2 = length2;
                    strArr = mapFileName;
                    file2 = file3;
                    i5 = i + 1;
                    file3 = file2;
                    mapFileName = strArr;
                    length2 = i2;
                    i3 = 3;
                }
            }
            i4++;
            i3 = 3;
        }
    }

    public void setDestDir(java.io.File file) {
        this.w = file;
    }

    public void setGranularity(long j) {
        this.x = j;
    }

    public void setPath(org.apache.tools.ant.types.Path path) {
        createPath().append(path);
    }

    public void setPathRef(org.apache.tools.ant.types.Reference reference) {
        createPath().setRefid(reference);
    }

    public void setPreserveLastModified(boolean z2) {
        this.y = z2;
    }

    public void validateAttributes() throws org.apache.tools.ant.BuildException {
        if (this.w == null) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_DESTDIR);
        }
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_MAPPER);
        }
        if (this.v == null) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_PATH);
        }
    }
}
