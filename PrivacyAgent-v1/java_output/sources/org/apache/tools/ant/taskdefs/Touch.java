package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Touch extends org.apache.tools.ant.Task {
    public static final org.apache.tools.ant.taskdefs.Touch.DateFormatFactory DEFAULT_DF_FACTORY = new org.apache.tools.ant.taskdefs.Touch.AnonymousClass1();
    public static final org.apache.tools.ant.util.FileUtils E = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public boolean A;
    public java.io.File u;
    public java.lang.String w;
    public org.apache.tools.ant.types.resources.Union y;
    public boolean z;
    public long v = -1;
    public java.util.Vector x = new java.util.Vector();
    public boolean B = true;
    public org.apache.tools.ant.util.FileNameMapper C = null;
    public org.apache.tools.ant.taskdefs.Touch.DateFormatFactory D = DEFAULT_DF_FACTORY;

    /* renamed from: org.apache.tools.ant.taskdefs.Touch$1, reason: invalid class name */
    public static class AnonymousClass1 implements org.apache.tools.ant.taskdefs.Touch.DateFormatFactory {
        @Override // org.apache.tools.ant.taskdefs.Touch.DateFormatFactory
        public java.text.DateFormat getFallbackFormat() {
            return org.apache.tools.ant.util.DateUtils.EN_US_DATE_FORMAT_SEC.get();
        }

        @Override // org.apache.tools.ant.taskdefs.Touch.DateFormatFactory
        public java.text.DateFormat getPrimaryFormat() {
            return org.apache.tools.ant.util.DateUtils.EN_US_DATE_FORMAT_MIN.get();
        }
    }

    /* renamed from: org.apache.tools.ant.taskdefs.Touch$2, reason: invalid class name */
    public class AnonymousClass2 implements org.apache.tools.ant.taskdefs.Touch.DateFormatFactory {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // org.apache.tools.ant.taskdefs.Touch.DateFormatFactory
        public java.text.DateFormat getFallbackFormat() {
            return null;
        }

        @Override // org.apache.tools.ant.taskdefs.Touch.DateFormatFactory
        public java.text.DateFormat getPrimaryFormat() {
            return new java.text.SimpleDateFormat(this.a);
        }
    }

    public interface DateFormatFactory {
        java.text.DateFormat getFallbackFormat();

        java.text.DateFormat getPrimaryFormat();
    }

    public synchronized void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        org.apache.tools.ant.types.resources.Union union = this.y;
        if (union == null) {
            union = new org.apache.tools.ant.types.resources.Union();
        }
        this.y = union;
        union.add(resourceCollection);
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) throws org.apache.tools.ant.BuildException {
        if (this.C == null) {
            this.C = fileNameMapper;
            return;
        }
        throw new org.apache.tools.ant.BuildException("Only one mapper may be added to the " + getTaskName() + " task.");
    }

    public void addConfiguredMapper(org.apache.tools.ant.types.Mapper mapper) {
        add(mapper.getImplementation());
    }

    public void addFilelist(org.apache.tools.ant.types.FileList fileList) {
        add(fileList);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.x.add(fileSet);
        add(fileSet);
    }

    public final long c() {
        long j = this.v;
        return j < 0 ? java.lang.System.currentTimeMillis() : j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        if (r0.exists() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if (r8.u.isDirectory() != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        throw new org.apache.tools.ant.BuildException("Use a resource collection to touch directories.");
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc A[Catch: all -> 0x00cc, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000a, B:9:0x0011, B:12:0x0014, B:14:0x001a, B:17:0x0023, B:18:0x002a, B:19:0x002b, B:21:0x002f, B:23:0x0033, B:25:0x003f, B:26:0x0075, B:29:0x0094, B:31:0x0044, B:34:0x004b, B:39:0x009e, B:40:0x00bb, B:41:0x00bc, B:42:0x00c9, B:45:0x0057, B:49:0x0061), top: B:2:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void checkConfiguration() throws org.apache.tools.ant.BuildException {
        long j;
        java.io.File file = this.u;
        if (file == null && this.y == null) {
            throw new org.apache.tools.ant.BuildException("Specify at least one source--a file or resource collection.");
        }
        java.lang.String str = this.w;
        if (str != null && !this.z) {
            long j2 = this.v;
            if ("now".equalsIgnoreCase(str)) {
                j = java.lang.System.currentTimeMillis();
            } else {
                java.text.ParseException parseException = null;
                try {
                    j2 = this.D.getPrimaryFormat().parse(this.w).getTime();
                } catch (java.text.ParseException e) {
                    e = e;
                    java.text.DateFormat fallbackFormat = this.D.getFallbackFormat();
                    if (fallbackFormat != null) {
                        try {
                            j2 = fallbackFormat.parse(this.w).getTime();
                        } catch (java.text.ParseException e2) {
                            e = e2;
                            parseException = e;
                            if (parseException == null) {
                            }
                        }
                    }
                    parseException = e;
                }
                if (parseException == null) {
                    throw new org.apache.tools.ant.BuildException(parseException.getMessage(), parseException, getLocation());
                }
                if (j2 < 0) {
                    throw new org.apache.tools.ant.BuildException("Date of " + this.w + " results in negative milliseconds value relative to epoch (January 1, 1970, 00:00:00 GMT).");
                }
                j = j2;
            }
            log("Setting millis to " + j + " from datetime attribute", this.v < 0 ? 4 : 3);
            setMillis(j);
            this.z = true;
        }
    }

    public final void d(java.io.File file, long j) {
        if (!file.exists()) {
            log("Creating " + file, this.B ? 2 : 3);
            try {
                E.createNewFile(file, this.A);
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("Could not create " + file, e, getLocation());
            }
        }
        if (file.canWrite()) {
            E.setFileLastModified(file, j);
            return;
        }
        throw new org.apache.tools.ant.BuildException("Can not change modification date of read-only file " + file);
    }

    public final void e(org.apache.tools.ant.types.Resource resource, long j) {
        org.apache.tools.ant.util.FileNameMapper fileNameMapper = this.C;
        if (fileNameMapper == null) {
            org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
            if (fileProvider != null) {
                d(fileProvider.getFile(), j);
                return;
            } else {
                ((org.apache.tools.ant.types.resources.Touchable) resource.as(org.apache.tools.ant.types.resources.Touchable.class)).touch(j);
                return;
            }
        }
        java.lang.String[] mapFileName = fileNameMapper.mapFileName(resource.getName());
        if (mapFileName == null || mapFileName.length <= 0) {
            return;
        }
        if (this.v < 0 && resource.isExists()) {
            j = resource.getLastModified();
        }
        for (java.lang.String str : mapFileName) {
            d(getProject().resolveFile(str), j);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        checkConfiguration();
        touch();
    }

    public void setDatetime(java.lang.String str) {
        if (this.w != null) {
            log("Resetting datetime attribute to " + str, 3);
        }
        this.w = str;
        this.z = false;
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public void setMillis(long j) {
        this.v = j;
    }

    public void setMkdirs(boolean z) {
        this.A = z;
    }

    public void setPattern(java.lang.String str) {
        this.D = new org.apache.tools.ant.taskdefs.Touch.AnonymousClass2(str);
    }

    public void setVerbose(boolean z) {
        this.B = z;
    }

    public void touch() throws org.apache.tools.ant.BuildException {
        long c = c();
        if (this.u != null) {
            e(new org.apache.tools.ant.types.resources.FileResource(this.u.getParentFile(), this.u.getName()), c);
        }
        org.apache.tools.ant.types.resources.Union union = this.y;
        if (union == null) {
            return;
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = union.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.Resource next = it.next();
            if (((org.apache.tools.ant.types.resources.Touchable) next.as(org.apache.tools.ant.types.resources.Touchable.class)) == null) {
                throw new org.apache.tools.ant.BuildException("Can't touch " + next);
            }
            e(next, c);
        }
        int size = this.x.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) this.x.elementAt(i);
            org.apache.tools.ant.DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(getProject());
            java.io.File dir = fileSet.getDir(getProject());
            for (java.lang.String str : directoryScanner.getIncludedDirectories()) {
                e(new org.apache.tools.ant.types.resources.FileResource(dir, str), c);
            }
        }
    }

    public void touch(java.io.File file) {
        d(file, c());
    }
}
