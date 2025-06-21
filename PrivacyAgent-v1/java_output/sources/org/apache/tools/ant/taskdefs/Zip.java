package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Zip extends org.apache.tools.ant.taskdefs.MatchingTask {
    public static final long S = new java.util.zip.CRC32().getValue();
    public static final org.apache.tools.ant.types.resources.selectors.ResourceSelector T = new org.apache.tools.ant.taskdefs.Zip.AnonymousClass1();
    public static final org.apache.tools.ant.util.ResourceUtils.ResourceSelectorProvider U = new org.apache.tools.ant.taskdefs.Zip.AnonymousClass2();
    public static final org.apache.tools.ant.util.FileUtils V = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final java.lang.ThreadLocal<java.lang.Boolean> W = new org.apache.tools.ant.taskdefs.Zip.AnonymousClass3();
    public static final java.lang.ThreadLocal<org.apache.tools.zip.ZipExtraField[]> X = new java.lang.ThreadLocal<>();
    public java.lang.String I;
    public org.apache.tools.ant.types.ZipScanner u;
    public java.io.File v;
    protected java.io.File zipFile;
    protected java.util.Hashtable<java.lang.String, java.lang.String> entries = new java.util.Hashtable<>();
    public final java.util.Vector<org.apache.tools.ant.types.FileSet> w = new java.util.Vector<>();
    public final java.util.Vector<org.apache.tools.ant.types.ZipFileSet> x = new java.util.Vector<>();
    protected java.lang.String duplicate = com.anythink.expressad.d.a.b.ay;
    public boolean y = true;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    protected java.lang.String archiveType = "zip";
    protected java.lang.String emptyBehavior = org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP;
    public final java.util.Vector<org.apache.tools.ant.types.ResourceCollection> C = new java.util.Vector<>();
    protected java.util.Hashtable<java.lang.String, java.lang.String> addedDirs = new java.util.Hashtable<>();
    public final java.util.Vector<java.lang.String> D = new java.util.Vector<>();
    public java.lang.String E = null;
    public long F = 0;
    protected boolean doubleFilePass = false;
    protected boolean skipWriting = false;
    public boolean G = false;
    public boolean H = false;
    public boolean J = false;
    public boolean K = true;
    public java.lang.String L = "";
    public int M = -1;
    public boolean N = false;
    public boolean O = true;
    public org.apache.tools.ant.taskdefs.Zip.UnicodeExtraField P = org.apache.tools.ant.taskdefs.Zip.UnicodeExtraField.NEVER;
    public boolean Q = false;
    public org.apache.tools.ant.taskdefs.Zip.Zip64ModeAttribute R = org.apache.tools.ant.taskdefs.Zip.Zip64ModeAttribute.AS_NEEDED;

    /* renamed from: org.apache.tools.ant.taskdefs.Zip$1, reason: invalid class name */
    public static class AnonymousClass1 implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
        @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
        public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
            return !resource.isExists();
        }
    }

    /* renamed from: org.apache.tools.ant.taskdefs.Zip$2, reason: invalid class name */
    public static class AnonymousClass2 implements org.apache.tools.ant.util.ResourceUtils.ResourceSelectorProvider {
        @Override // org.apache.tools.ant.util.ResourceUtils.ResourceSelectorProvider
        public org.apache.tools.ant.types.resources.selectors.ResourceSelector getTargetSelectorForSource(org.apache.tools.ant.types.Resource resource) {
            return org.apache.tools.ant.taskdefs.Zip.T;
        }
    }

    /* renamed from: org.apache.tools.ant.taskdefs.Zip$3, reason: invalid class name */
    public static class AnonymousClass3 extends java.lang.ThreadLocal<java.lang.Boolean> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Boolean initialValue() {
            return java.lang.Boolean.FALSE;
        }
    }

    /* renamed from: org.apache.tools.ant.taskdefs.Zip$4, reason: invalid class name */
    public class AnonymousClass4 implements java.util.Comparator<org.apache.tools.ant.types.Resource> {
        public AnonymousClass4() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
            return resource.getName().compareTo(resource2.getName());
        }
    }

    /* renamed from: org.apache.tools.ant.taskdefs.Zip$5, reason: invalid class name */
    public class AnonymousClass5 implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
        public AnonymousClass5() {
        }

        @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
        public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
            if (!resource.isDirectory()) {
                return true;
            }
            if (!org.apache.tools.ant.taskdefs.Zip.this.B) {
                return false;
            }
            org.apache.tools.ant.taskdefs.Zip.this.logWhenWriting("Ignoring directory " + resource.getName() + " as only files will be added.", 3);
            return false;
        }
    }

    /* renamed from: org.apache.tools.ant.taskdefs.Zip$6, reason: invalid class name */
    public class AnonymousClass6 implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
        public AnonymousClass6() {
        }

        @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
        public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
            return resource.isDirectory();
        }
    }

    public static class ArchiveState {
        public final boolean a;
        public final org.apache.tools.ant.types.Resource[][] b;

        public ArchiveState(boolean z, org.apache.tools.ant.types.Resource[][] resourceArr) {
            this.a = z;
            this.b = resourceArr;
        }

        public org.apache.tools.ant.types.Resource[][] getResourcesToAdd() {
            return this.b;
        }

        public boolean isOutOfDate() {
            return this.a;
        }

        public boolean isWithoutAnyResources() {
            if (this.b == null) {
                return true;
            }
            int i = 0;
            while (true) {
                org.apache.tools.ant.types.Resource[][] resourceArr = this.b;
                if (i >= resourceArr.length) {
                    return true;
                }
                org.apache.tools.ant.types.Resource[] resourceArr2 = resourceArr[i];
                if (resourceArr2 != null && resourceArr2.length > 0) {
                    return false;
                }
                i++;
            }
        }
    }

    public static class Duplicate extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{com.anythink.expressad.d.a.b.ay, "preserve", "fail"};
        }
    }

    public static final class UnicodeExtraField extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final org.apache.tools.ant.taskdefs.Zip.UnicodeExtraField NEVER;
        public static final java.util.Map<java.lang.String, org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy> b;

        static {
            java.util.HashMap hashMap = new java.util.HashMap();
            b = hashMap;
            hashMap.put("never", org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy.NEVER);
            hashMap.put("always", org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy.ALWAYS);
            hashMap.put("not-encodeable", org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy.NOT_ENCODEABLE);
            NEVER = new org.apache.tools.ant.taskdefs.Zip.UnicodeExtraField("never");
        }

        public UnicodeExtraField() {
        }

        public UnicodeExtraField(java.lang.String str) {
            setValue(str);
        }

        public org.apache.tools.zip.ZipOutputStream.UnicodeExtraFieldPolicy getPolicy() {
            return b.get(getValue());
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"never", "always", "not-encodeable"};
        }
    }

    public static class WhenEmpty extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"fail", org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP, "create"};
        }
    }

    public static final class Zip64ModeAttribute extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final org.apache.tools.ant.taskdefs.Zip.Zip64ModeAttribute AS_NEEDED;
        public static final org.apache.tools.ant.taskdefs.Zip.Zip64ModeAttribute NEVER;
        public static final java.util.Map<java.lang.String, org.apache.tools.zip.Zip64Mode> b;

        static {
            java.util.HashMap hashMap = new java.util.HashMap();
            b = hashMap;
            hashMap.put("never", org.apache.tools.zip.Zip64Mode.Never);
            hashMap.put("always", org.apache.tools.zip.Zip64Mode.Always);
            hashMap.put("as-needed", org.apache.tools.zip.Zip64Mode.AsNeeded);
            NEVER = new org.apache.tools.ant.taskdefs.Zip.Zip64ModeAttribute("never");
            AS_NEEDED = new org.apache.tools.ant.taskdefs.Zip.Zip64ModeAttribute("as-needed");
        }

        public Zip64ModeAttribute() {
        }

        public Zip64ModeAttribute(java.lang.String str) {
            setValue(str);
        }

        public org.apache.tools.zip.Zip64Mode getMode() {
            return b.get(getValue());
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"never", "always", "as-needed"};
        }
    }

    public static final boolean isEmpty(org.apache.tools.ant.types.Resource[][] resourceArr) {
        for (org.apache.tools.ant.types.Resource[] resourceArr2 : resourceArr) {
            if (resourceArr2.length > 0) {
                return false;
            }
        }
        return true;
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.C.add(resourceCollection);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        add(fileSet);
    }

    public final void addParentDirs(java.io.File file, java.lang.String str, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str2, int i) throws java.io.IOException {
        if (this.B) {
            return;
        }
        java.util.Stack stack = new java.util.Stack();
        int length = str.length();
        while (true) {
            length = str.lastIndexOf(47, length - 1);
            if (length == -1) {
                break;
            }
            java.lang.String substring = str.substring(0, length + 1);
            if (this.addedDirs.get(str2 + substring) != null) {
                break;
            } else {
                stack.push(substring);
            }
        }
        while (!stack.isEmpty()) {
            java.lang.String str3 = (java.lang.String) stack.pop();
            zipDir(file != null ? new java.io.File(file, str3) : new java.io.File(str3), zipOutputStream, str2 + str3, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9 A[Catch: all -> 0x01c1, TryCatch #0 {all -> 0x01c1, blocks: (B:31:0x00d6, B:33:0x00d9, B:36:0x00e7, B:41:0x00ff, B:43:0x0107, B:47:0x010e, B:50:0x011f, B:60:0x0117, B:77:0x00e1), top: B:30:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void addResources(org.apache.tools.ant.types.FileSet fileSet, org.apache.tools.ant.types.Resource[] resourceArr, org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException {
        java.lang.String str;
        java.lang.String str2;
        int i;
        org.apache.tools.ant.types.ArchiveFileSet archiveFileSet;
        int i2;
        java.lang.String str3;
        org.apache.tools.zip.ZipFile zipFile;
        java.io.File file;
        org.apache.tools.zip.ZipFile zipFile2;
        boolean z;
        int i3;
        org.apache.tools.zip.ZipFile zipFile3;
        int i4;
        java.lang.String str4;
        int i5;
        java.lang.String str5;
        java.lang.String str6 = "";
        if (fileSet instanceof org.apache.tools.ant.types.ArchiveFileSet) {
            org.apache.tools.ant.types.ArchiveFileSet archiveFileSet2 = (org.apache.tools.ant.types.ArchiveFileSet) fileSet;
            str = archiveFileSet2.getPrefix(getProject());
            archiveFileSet = archiveFileSet2;
            str2 = archiveFileSet2.getFullpath(getProject());
            i2 = archiveFileSet2.getDirMode(getProject());
            i = archiveFileSet2.getFileMode(getProject());
        } else {
            str = "";
            str2 = str;
            i = 33188;
            archiveFileSet = null;
            i2 = 16877;
        }
        if (str.length() > 0 && str2.length() > 0) {
            throw new org.apache.tools.ant.BuildException("Both prefix and fullpath attributes must not be set on the same fileset.");
        }
        if (resourceArr.length != 1 && str2.length() > 0) {
            throw new org.apache.tools.ant.BuildException("fullpath attribute may only be specified for filesets that specify a single file.");
        }
        if (str.length() > 0) {
            if (!str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) && !str.endsWith("\\")) {
                str = str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            }
            java.lang.String str7 = str;
            addParentDirs(null, str7, zipOutputStream, "", i2);
            str3 = str7;
        } else {
            str3 = str;
        }
        if (archiveFileSet != null) {
            try {
                if (archiveFileSet.getSrc(getProject()) != null) {
                    if (archiveFileSet instanceof org.apache.tools.ant.types.ZipFileSet) {
                        zipFile2 = new org.apache.tools.zip.ZipFile(archiveFileSet.getSrc(getProject()), this.I);
                        file = null;
                    } else {
                        file = null;
                        zipFile2 = null;
                    }
                    z = false;
                    i3 = 0;
                    while (i3 < resourceArr.length) {
                        try {
                            java.lang.String replace = (str2.length() > 0 ? str2 : resourceArr[i3].getName()).replace(java.io.File.separatorChar, '/');
                            if (!str6.equals(replace)) {
                                if (!resourceArr[i3].isDirectory()) {
                                    i4 = i3;
                                    java.lang.String str8 = str3;
                                    zipFile = zipFile2;
                                    str4 = str6;
                                    i5 = i;
                                    addParentDirs(file, replace, zipOutputStream, str8, i2);
                                    if (z) {
                                        zipFile(V.resolveFile(file, resourceArr[i4].getName()), zipOutputStream, str8 + replace, i5);
                                        str5 = str8;
                                    } else {
                                        str5 = str8;
                                        f(resourceArr[i4], replace, str8, zipOutputStream, (archiveFileSet == null || !archiveFileSet.hasFileModeBeenSet()) ? i(resourceArr[i4], zipFile, i5) : i5, zipFile, archiveFileSet == null ? null : archiveFileSet.getSrc(getProject()));
                                    }
                                } else if (!this.B) {
                                    i4 = i3;
                                    java.lang.String str9 = str3;
                                    zipFile = zipFile2;
                                    str4 = str6;
                                    i5 = i;
                                    try {
                                        e(resourceArr[i3], replace, str3, file, zipOutputStream, i2, (archiveFileSet == null || !archiveFileSet.hasDirModeBeenSet()) ? i(resourceArr[i3], zipFile2, i2) : i2);
                                        str5 = str9;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        if (zipFile != null) {
                                        }
                                        throw th;
                                    }
                                }
                                i3 = i4 + 1;
                                i = i5;
                                zipFile2 = zipFile;
                                str3 = str5;
                                str6 = str4;
                            }
                            i4 = i3;
                            str5 = str3;
                            zipFile = zipFile2;
                            str4 = str6;
                            i5 = i;
                            i3 = i4 + 1;
                            i = i5;
                            zipFile2 = zipFile;
                            str3 = str5;
                            str6 = str4;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            zipFile = zipFile2;
                        }
                    }
                    zipFile3 = zipFile2;
                    if (zipFile3 == null) {
                        zipFile3.close();
                        return;
                    }
                    return;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                zipFile = null;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        }
        file = fileSet.getDir(getProject());
        zipFile2 = null;
        z = true;
        i3 = 0;
        while (i3 < resourceArr.length) {
        }
        zipFile3 = zipFile2;
        if (zipFile3 == null) {
        }
    }

    public final void addResources(org.apache.tools.ant.types.ResourceCollection resourceCollection, org.apache.tools.ant.types.Resource[] resourceArr, org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException {
        if (resourceCollection instanceof org.apache.tools.ant.types.FileSet) {
            addResources((org.apache.tools.ant.types.FileSet) resourceCollection, resourceArr, zipOutputStream);
            return;
        }
        for (org.apache.tools.ant.types.Resource resource : resourceArr) {
            java.lang.String name = resource.getName();
            if (name != null) {
                java.lang.String replace = name.replace(java.io.File.separatorChar, '/');
                if (!"".equals(replace) && (!resource.isDirectory() || !this.B)) {
                    org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
                    java.io.File baseDir = fileProvider != null ? org.apache.tools.ant.util.ResourceUtils.asFileResource(fileProvider).getBaseDir() : null;
                    if (resource.isDirectory()) {
                        e(resource, replace, "", baseDir, zipOutputStream, 16877, 16877);
                    } else {
                        addParentDirs(baseDir, replace, zipOutputStream, "", 16877);
                        if (fileProvider != null) {
                            zipFile(fileProvider.getFile(), zipOutputStream, replace, 33188);
                        } else {
                            f(resource, replace, "", zipOutputStream, 33188, null, null);
                        }
                    }
                }
            }
        }
    }

    public void addZipGroupFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.w.addElement(fileSet);
    }

    public void addZipfileset(org.apache.tools.ant.types.ZipFileSet zipFileSet) {
        add(zipFileSet);
    }

    public void cleanUp() {
        this.addedDirs.clear();
        this.D.removeAllElements();
        this.entries.clear();
        this.H = false;
        this.z = this.A;
        java.util.Enumeration<org.apache.tools.ant.types.ZipFileSet> elements = this.x.elements();
        while (elements.hasMoreElements()) {
            this.C.removeElement(elements.nextElement());
        }
        this.x.removeAllElements();
        W.set(java.lang.Boolean.FALSE);
    }

    public boolean createEmptyZip(java.io.File file) throws org.apache.tools.ant.BuildException {
        java.io.FileOutputStream fileOutputStream;
        if (!this.skipWriting) {
            log("Note: creating empty " + this.archiveType + " archive " + file, 2);
        }
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[22];
            bArr[0] = 80;
            bArr[1] = org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK;
            bArr[2] = 5;
            bArr[3] = 6;
            fileOutputStream.write(bArr);
            org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
            return true;
        } catch (java.io.IOException e2) {
            e = e2;
            throw new org.apache.tools.ant.BuildException("Could not create empty ZIP archive (" + e.getMessage() + ")", e, getLocation());
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            org.apache.tools.ant.util.FileUtils.close(fileOutputStream2);
            throw th;
        }
    }

    public final void e(org.apache.tools.ant.types.Resource resource, java.lang.String str, java.lang.String str2, java.io.File file, org.apache.tools.zip.ZipOutputStream zipOutputStream, int i, int i2) throws java.io.IOException {
        if (!str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        int lastIndexOf = str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, str.length() - 2);
        if (lastIndexOf != -1) {
            addParentDirs(file, str.substring(0, lastIndexOf + 1), zipOutputStream, str2, i);
        }
        zipDir(resource, zipOutputStream, str2 + str, i2, resource instanceof org.apache.tools.ant.types.resources.ZipResource ? ((org.apache.tools.ant.types.resources.ZipResource) resource).getExtraFields() : null);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (!this.doubleFilePass) {
            executeMain();
            return;
        }
        this.skipWriting = true;
        executeMain();
        this.skipWriting = false;
        executeMain();
    }

    public void executeMain() throws org.apache.tools.ant.BuildException {
        g();
        this.H = true;
        k();
        l();
        java.util.Vector vector = new java.util.Vector();
        if (this.v != null) {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) getImplicitFileSet().clone();
            fileSet.setDir(this.v);
            vector.addElement(fileSet);
        }
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            vector.addElement(this.C.elementAt(i));
        }
        int size2 = vector.size();
        org.apache.tools.ant.types.ResourceCollection[] resourceCollectionArr = new org.apache.tools.ant.types.ResourceCollection[size2];
        vector.copyInto(resourceCollectionArr);
        java.io.File file = null;
        r2 = null;
        org.apache.tools.zip.ZipOutputStream zipOutputStream = null;
        try {
            try {
                org.apache.tools.ant.taskdefs.Zip.ArchiveState resourcesToAdd = getResourcesToAdd(resourceCollectionArr, this.zipFile, false);
                if (!resourcesToAdd.isOutOfDate()) {
                    return;
                }
                java.io.File parentFile = this.zipFile.getParentFile();
                if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new org.apache.tools.ant.BuildException("Failed to create missing parent directory for " + this.zipFile);
                }
                this.G = true;
                if (!this.zipFile.exists() && resourcesToAdd.isWithoutAnyResources()) {
                    createEmptyZip(this.zipFile);
                    return;
                }
                org.apache.tools.ant.types.Resource[][] resourcesToAdd2 = resourcesToAdd.getResourcesToAdd();
                java.io.File m = this.z ? m() : null;
                try {
                    java.lang.String str = this.z ? "Updating " : "Building ";
                    if (!this.skipWriting) {
                        log(str + this.archiveType + ": " + this.zipFile.getAbsolutePath());
                    }
                    try {
                        if (!this.skipWriting) {
                            org.apache.tools.zip.ZipOutputStream zipOutputStream2 = new org.apache.tools.zip.ZipOutputStream(this.zipFile);
                            try {
                                zipOutputStream2.setEncoding(this.I);
                                zipOutputStream2.setUseLanguageEncodingFlag(this.O);
                                zipOutputStream2.setCreateUnicodeExtraFields(this.P.getPolicy());
                                zipOutputStream2.setFallbackToUTF8(this.Q);
                                zipOutputStream2.setMethod(this.y ? 8 : 0);
                                zipOutputStream2.setLevel(this.M);
                                zipOutputStream2.setUseZip64(this.R.getMode());
                                zipOutputStream = zipOutputStream2;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                zipOutputStream = zipOutputStream2;
                                h(zipOutputStream, false);
                                throw th;
                            }
                        }
                        initZipOutputStream(zipOutputStream);
                        for (int i2 = 0; i2 < size2; i2++) {
                            org.apache.tools.ant.types.Resource[] resourceArr = resourcesToAdd2[i2];
                            if (resourceArr.length != 0) {
                                addResources(resourceCollectionArr[i2], resourceArr, zipOutputStream);
                            }
                        }
                        if (this.z) {
                            this.H = false;
                            org.apache.tools.ant.types.ZipFileSet zipFileSet = new org.apache.tools.ant.types.ZipFileSet();
                            zipFileSet.setProject(getProject());
                            zipFileSet.setSrc(m);
                            zipFileSet.setDefaultexcludes(false);
                            int size3 = this.D.size();
                            for (int i3 = 0; i3 < size3; i3++) {
                                zipFileSet.createExclude().setName(this.D.elementAt(i3));
                            }
                            org.apache.tools.ant.DirectoryScanner directoryScanner = zipFileSet.getDirectoryScanner(getProject());
                            ((org.apache.tools.ant.types.ZipScanner) directoryScanner).setEncoding(this.I);
                            java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
                            int length = includedFiles.length;
                            org.apache.tools.ant.types.Resource[] resourceArr2 = new org.apache.tools.ant.types.Resource[length];
                            for (int i4 = 0; i4 < includedFiles.length; i4++) {
                                resourceArr2[i4] = directoryScanner.getResource(includedFiles[i4]);
                            }
                            if (!this.B) {
                                java.lang.String[] includedDirectories = directoryScanner.getIncludedDirectories();
                                int length2 = includedDirectories.length;
                                org.apache.tools.ant.types.Resource[] resourceArr3 = new org.apache.tools.ant.types.Resource[length2];
                                for (int i5 = 0; i5 < includedDirectories.length; i5++) {
                                    resourceArr3[i5] = directoryScanner.getResource(includedDirectories[i5]);
                                }
                                org.apache.tools.ant.types.Resource[] resourceArr4 = new org.apache.tools.ant.types.Resource[length + length2];
                                java.lang.System.arraycopy(resourceArr3, 0, resourceArr4, 0, length2);
                                java.lang.System.arraycopy(resourceArr2, 0, resourceArr4, length2, length);
                                resourceArr2 = resourceArr4;
                            }
                            addResources((org.apache.tools.ant.types.FileSet) zipFileSet, resourceArr2, zipOutputStream);
                        }
                        if (zipOutputStream != null) {
                            zipOutputStream.setComment(this.L);
                        }
                        finalizeZipOutputStream(zipOutputStream);
                        if (this.z && !m.delete()) {
                            log("Warning: unable to delete temporary file " + m.getName(), 1);
                        }
                        h(zipOutputStream, true);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                } catch (java.io.IOException e) {
                    e = e;
                    file = m;
                    java.lang.String str2 = "Problem creating " + this.archiveType + ": " + e.getMessage();
                    if ((!this.z || file != null) && !this.zipFile.delete()) {
                        str2 = str2 + " (and the archive is probably corrupt but I could not delete it)";
                    }
                    if (this.z && file != null) {
                        try {
                            V.rename(file, this.zipFile);
                        } catch (java.io.IOException unused) {
                            str2 = str2 + " (and I couldn't rename the temporary file " + file.getName() + " back)";
                        }
                    }
                    throw new org.apache.tools.ant.BuildException(str2, e, getLocation());
                }
            } finally {
                cleanUp();
            }
        } catch (java.io.IOException e2) {
            e = e2;
        }
    }

    public final void f(org.apache.tools.ant.types.Resource resource, java.lang.String str, java.lang.String str2, org.apache.tools.zip.ZipOutputStream zipOutputStream, int i, org.apache.tools.zip.ZipFile zipFile, java.io.File file) throws java.io.IOException {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        if (zipFile == null) {
            try {
                bufferedInputStream = new java.io.BufferedInputStream(resource.getInputStream());
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                zipFile(bufferedInputStream, zipOutputStream, str2 + str, resource.getLastModified(), file, i, resource instanceof org.apache.tools.ant.types.resources.ZipResource ? ((org.apache.tools.ant.types.resources.ZipResource) resource).getExtraFields() : null);
                org.apache.tools.ant.util.FileUtils.close(bufferedInputStream);
                return;
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                org.apache.tools.ant.util.FileUtils.close(bufferedInputStream2);
                throw th;
            }
        }
        org.apache.tools.zip.ZipEntry entry = zipFile.getEntry(resource.getName());
        if (entry == null) {
            return;
        }
        boolean z = this.y;
        if (this.J) {
            this.y = entry.getMethod() == 8;
        }
        try {
            java.io.BufferedInputStream bufferedInputStream3 = new java.io.BufferedInputStream(zipFile.getInputStream(entry));
            try {
                zipFile(bufferedInputStream3, zipOutputStream, str2 + str, entry.getTime(), file, i, entry.getExtraFields(true));
                this.y = z;
                org.apache.tools.ant.util.FileUtils.close(bufferedInputStream3);
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedInputStream2 = bufferedInputStream3;
                this.y = z;
                org.apache.tools.ant.util.FileUtils.close(bufferedInputStream2);
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    public void finalizeZipOutputStream(org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException, org.apache.tools.ant.BuildException {
    }

    public final void g() {
        if (this.v == null && this.C.size() == 0 && this.w.size() == 0 && "zip".equals(this.archiveType)) {
            throw new org.apache.tools.ant.BuildException("basedir attribute must be set, or at least one resource collection must be given!");
        }
        if (this.zipFile == null) {
            throw new org.apache.tools.ant.BuildException("You must specify the " + this.archiveType + " file to create!");
        }
        java.lang.String str = this.E;
        if (str != null) {
            try {
                long time = org.apache.tools.ant.util.DateUtils.parseLenientDateTime(str).getTime();
                this.F = time;
                if (this.K) {
                    this.F = time + 1999;
                }
            } catch (java.text.ParseException unused) {
                throw new org.apache.tools.ant.BuildException("Failed to parse date string " + this.E + ".");
            }
        }
        if (this.zipFile.exists() && !this.zipFile.isFile()) {
            throw new org.apache.tools.ant.BuildException(this.zipFile + " is not a file.");
        }
        if (!this.zipFile.exists() || this.zipFile.canWrite()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException(this.zipFile + " is read-only.");
    }

    public java.lang.String getComment() {
        return this.L;
    }

    public org.apache.tools.ant.taskdefs.Zip.UnicodeExtraField getCreateUnicodeExtraFields() {
        return this.P;
    }

    public final org.apache.tools.zip.ZipExtraField[] getCurrentExtraFields() {
        return X.get();
    }

    public java.io.File getDestFile() {
        return this.zipFile;
    }

    public java.lang.String getEncoding() {
        return this.I;
    }

    public boolean getFallBackToUTF8() {
        return this.Q;
    }

    public int getLevel() {
        return this.M;
    }

    public java.lang.String getModificationtime() {
        return this.E;
    }

    public org.apache.tools.ant.taskdefs.Zip.ArchiveState getNonFileSetResourcesToAdd(org.apache.tools.ant.types.ResourceCollection[] resourceCollectionArr, java.io.File file, boolean z) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Resource[][] grabNonFileSetResources = grabNonFileSetResources(resourceCollectionArr);
        boolean isEmpty = isEmpty(grabNonFileSetResources);
        W.set(java.lang.Boolean.valueOf(!isEmpty));
        if (isEmpty) {
            return new org.apache.tools.ant.taskdefs.Zip.ArchiveState(z, grabNonFileSetResources);
        }
        if (!file.exists()) {
            return new org.apache.tools.ant.taskdefs.Zip.ArchiveState(true, grabNonFileSetResources);
        }
        if (z && !this.z) {
            return new org.apache.tools.ant.taskdefs.Zip.ArchiveState(true, grabNonFileSetResources);
        }
        org.apache.tools.ant.types.Resource[][] resourceArr = new org.apache.tools.ant.types.Resource[resourceCollectionArr.length][];
        for (int i = 0; i < resourceCollectionArr.length; i++) {
            if (grabNonFileSetResources[i].length != 0) {
                int i2 = 0;
                while (true) {
                    org.apache.tools.ant.types.Resource[] resourceArr2 = grabNonFileSetResources[i];
                    if (i2 >= resourceArr2.length) {
                        org.apache.tools.ant.types.Resource[] n = n(resourceArr2, new org.apache.tools.ant.util.IdentityMapper());
                        resourceArr[i] = n;
                        z = z || n.length > 0;
                        if (z && !this.z) {
                            break;
                        }
                    } else {
                        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resourceArr2[i2].as(org.apache.tools.ant.types.resources.FileProvider.class);
                        if (fileProvider != null && file.equals(fileProvider.getFile())) {
                            throw new org.apache.tools.ant.BuildException("A zip file cannot include itself", getLocation());
                        }
                        i2++;
                    }
                }
            } else {
                resourceArr[i] = new org.apache.tools.ant.types.Resource[0];
            }
        }
        return (!z || this.z) ? new org.apache.tools.ant.taskdefs.Zip.ArchiveState(z, resourceArr) : new org.apache.tools.ant.taskdefs.Zip.ArchiveState(true, grabNonFileSetResources);
    }

    public boolean getPreserve0Permissions() {
        return this.N;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0118, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public org.apache.tools.ant.taskdefs.Zip.ArchiveState getResourcesToAdd(org.apache.tools.ant.types.FileSet[] fileSetArr, java.io.File file, boolean z) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Resource[][] grabResources = grabResources(fileSetArr);
        if (isEmpty(grabResources)) {
            if (java.lang.Boolean.FALSE.equals(W.get())) {
                if (z && this.z) {
                    return new org.apache.tools.ant.taskdefs.Zip.ArchiveState(true, grabResources);
                }
                if (!this.emptyBehavior.equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP)) {
                    if (this.emptyBehavior.equals("fail")) {
                        throw new org.apache.tools.ant.BuildException("Cannot create " + this.archiveType + " archive " + file + ": no files were included.", getLocation());
                    }
                    if (!file.exists()) {
                        z = true;
                    }
                } else if (this.z) {
                    logWhenWriting(this.archiveType + " archive " + file + " not updated because no new files were included.", 3);
                } else {
                    logWhenWriting("Warning: skipping " + this.archiveType + " archive " + file + " because no files were included.", 1);
                }
            }
            return new org.apache.tools.ant.taskdefs.Zip.ArchiveState(z, grabResources);
        }
        if (!file.exists()) {
            return new org.apache.tools.ant.taskdefs.Zip.ArchiveState(true, grabResources);
        }
        if (z && !this.z) {
            return new org.apache.tools.ant.taskdefs.Zip.ArchiveState(true, grabResources);
        }
        org.apache.tools.ant.types.Resource[][] resourceArr = new org.apache.tools.ant.types.Resource[fileSetArr.length][];
        for (int i = 0; i < fileSetArr.length; i++) {
            org.apache.tools.ant.types.FileSet fileSet = this.fileset;
            if (!(fileSet instanceof org.apache.tools.ant.types.ZipFileSet) || ((org.apache.tools.ant.types.ZipFileSet) fileSet).getSrc(getProject()) == null) {
                java.io.File dir = fileSetArr[i].getDir(getProject());
                int i2 = 0;
                while (true) {
                    org.apache.tools.ant.types.Resource[] resourceArr2 = grabResources[i];
                    if (i2 < resourceArr2.length) {
                        if (V.resolveFile(dir, resourceArr2[i2].getName()).equals(file)) {
                            throw new org.apache.tools.ant.BuildException("A zip file cannot include itself", getLocation());
                        }
                        i2++;
                    }
                }
            }
        }
        for (int i3 = 0; i3 < fileSetArr.length; i3++) {
            if (grabResources[i3].length != 0) {
                org.apache.tools.ant.util.FileNameMapper identityMapper = new org.apache.tools.ant.util.IdentityMapper();
                org.apache.tools.ant.types.FileSet fileSet2 = fileSetArr[i3];
                if (fileSet2 instanceof org.apache.tools.ant.types.ZipFileSet) {
                    org.apache.tools.ant.types.ZipFileSet zipFileSet = (org.apache.tools.ant.types.ZipFileSet) fileSet2;
                    if (zipFileSet.getFullpath(getProject()) != null && !zipFileSet.getFullpath(getProject()).equals("")) {
                        identityMapper = new org.apache.tools.ant.util.MergingMapper();
                        identityMapper.setTo(zipFileSet.getFullpath(getProject()));
                    } else if (zipFileSet.getPrefix(getProject()) != null && !zipFileSet.getPrefix(getProject()).equals("")) {
                        identityMapper = new org.apache.tools.ant.util.GlobPatternMapper();
                        identityMapper.setFrom("*");
                        java.lang.String prefix = zipFileSet.getPrefix(getProject());
                        if (!prefix.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) && !prefix.endsWith("\\")) {
                            prefix = prefix + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
                        }
                        identityMapper.setTo(prefix + "*");
                    }
                }
                org.apache.tools.ant.types.Resource[] n = n(grabResources[i3], identityMapper);
                resourceArr[i3] = n;
                z = z || n.length > 0;
                if (z && !this.z) {
                    break;
                }
            } else {
                resourceArr[i3] = new org.apache.tools.ant.types.Resource[0];
            }
        }
        return (!z || this.z) ? new org.apache.tools.ant.taskdefs.Zip.ArchiveState(z, resourceArr) : new org.apache.tools.ant.taskdefs.Zip.ArchiveState(true, grabResources);
    }

    public org.apache.tools.ant.taskdefs.Zip.ArchiveState getResourcesToAdd(org.apache.tools.ant.types.ResourceCollection[] resourceCollectionArr, java.io.File file, boolean z) throws org.apache.tools.ant.BuildException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (org.apache.tools.ant.types.ResourceCollection resourceCollection : resourceCollectionArr) {
            if (resourceCollection instanceof org.apache.tools.ant.types.FileSet) {
                arrayList.add(resourceCollection);
            } else {
                arrayList2.add(resourceCollection);
            }
        }
        org.apache.tools.ant.types.ResourceCollection[] resourceCollectionArr2 = (org.apache.tools.ant.types.ResourceCollection[]) arrayList2.toArray(new org.apache.tools.ant.types.ResourceCollection[arrayList2.size()]);
        org.apache.tools.ant.taskdefs.Zip.ArchiveState nonFileSetResourcesToAdd = getNonFileSetResourcesToAdd(resourceCollectionArr2, file, z);
        org.apache.tools.ant.taskdefs.Zip.ArchiveState resourcesToAdd = getResourcesToAdd((org.apache.tools.ant.types.FileSet[]) arrayList.toArray(new org.apache.tools.ant.types.FileSet[arrayList.size()]), file, nonFileSetResourcesToAdd.isOutOfDate());
        if (!nonFileSetResourcesToAdd.isOutOfDate() && resourcesToAdd.isOutOfDate()) {
            nonFileSetResourcesToAdd = getNonFileSetResourcesToAdd(resourceCollectionArr2, file, true);
        }
        org.apache.tools.ant.types.Resource[][] resourceArr = new org.apache.tools.ant.types.Resource[resourceCollectionArr.length][];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < resourceCollectionArr.length; i3++) {
            if (resourceCollectionArr[i3] instanceof org.apache.tools.ant.types.FileSet) {
                resourceArr[i3] = resourcesToAdd.getResourcesToAdd()[i2];
                i2++;
            } else {
                resourceArr[i3] = nonFileSetResourcesToAdd.getResourcesToAdd()[i];
                i++;
            }
        }
        return new org.apache.tools.ant.taskdefs.Zip.ArchiveState(resourcesToAdd.isOutOfDate(), resourceArr);
    }

    public boolean getUseLanguageEnodingFlag() {
        return this.O;
    }

    public org.apache.tools.ant.taskdefs.Zip.Zip64ModeAttribute getZip64Mode() {
        return this.R;
    }

    public org.apache.tools.ant.types.Resource[][] grabNonFileSetResources(org.apache.tools.ant.types.ResourceCollection[] resourceCollectionArr) {
        org.apache.tools.ant.types.Resource[][] resourceArr = new org.apache.tools.ant.types.Resource[resourceCollectionArr.length][];
        for (int i = 0; i < resourceCollectionArr.length; i++) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (org.apache.tools.ant.types.Resource resource : resourceCollectionArr[i]) {
                if (resource.isExists()) {
                    if (resource.isDirectory()) {
                        arrayList.add(resource);
                    } else {
                        arrayList2.add(resource);
                    }
                }
            }
            java.util.Collections.sort(arrayList, new org.apache.tools.ant.taskdefs.Zip.AnonymousClass4());
            java.util.ArrayList arrayList3 = new java.util.ArrayList(arrayList);
            arrayList3.addAll(arrayList2);
            resourceArr[i] = (org.apache.tools.ant.types.Resource[]) arrayList3.toArray(new org.apache.tools.ant.types.Resource[arrayList3.size()]);
        }
        return resourceArr;
    }

    public org.apache.tools.ant.types.Resource[][] grabResources(org.apache.tools.ant.types.FileSet[] fileSetArr) {
        org.apache.tools.ant.types.Resource[][] resourceArr = new org.apache.tools.ant.types.Resource[fileSetArr.length][];
        for (int i = 0; i < fileSetArr.length; i++) {
            org.apache.tools.ant.types.FileSet fileSet = fileSetArr[i];
            boolean z = true;
            if (fileSet instanceof org.apache.tools.ant.types.ZipFileSet) {
                org.apache.tools.ant.types.ZipFileSet zipFileSet = (org.apache.tools.ant.types.ZipFileSet) fileSet;
                if (!zipFileSet.getPrefix(getProject()).equals("") || !zipFileSet.getFullpath(getProject()).equals("")) {
                    z = false;
                }
            }
            org.apache.tools.ant.DirectoryScanner directoryScanner = fileSetArr[i].getDirectoryScanner(getProject());
            if (directoryScanner instanceof org.apache.tools.ant.types.ZipScanner) {
                ((org.apache.tools.ant.types.ZipScanner) directoryScanner).setEncoding(this.I);
            }
            java.util.Vector vector = new java.util.Vector();
            if (!this.B) {
                java.lang.String[] includedDirectories = directoryScanner.getIncludedDirectories();
                for (int i2 = 0; i2 < includedDirectories.length; i2++) {
                    if (!"".equals(includedDirectories[i2]) || !z) {
                        vector.addElement(directoryScanner.getResource(includedDirectories[i2]));
                    }
                }
            }
            java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
            for (int i3 = 0; i3 < includedFiles.length; i3++) {
                if (!"".equals(includedFiles[i3]) || !z) {
                    vector.addElement(directoryScanner.getResource(includedFiles[i3]));
                }
            }
            org.apache.tools.ant.types.Resource[] resourceArr2 = new org.apache.tools.ant.types.Resource[vector.size()];
            resourceArr[i] = resourceArr2;
            vector.copyInto(resourceArr2);
        }
        return resourceArr;
    }

    public final void h(org.apache.tools.zip.ZipOutputStream zipOutputStream, boolean z) throws java.io.IOException {
        if (zipOutputStream == null) {
            return;
        }
        try {
            zipOutputStream.close();
        } catch (java.io.IOException e) {
            if (z) {
                throw e;
            }
        }
    }

    public boolean hasUpdatedFile() {
        return this.G;
    }

    public final int i(org.apache.tools.ant.types.Resource resource, org.apache.tools.zip.ZipFile zipFile, int i) {
        if (zipFile == null) {
            return resource instanceof org.apache.tools.ant.types.resources.ArchiveResource ? ((org.apache.tools.ant.types.resources.ArchiveResource) resource).getMode() : i;
        }
        int unixMode = zipFile.getEntry(resource.getName()).getUnixMode();
        return ((unixMode == 0 || unixMode == 16384) && !this.N) ? i : unixMode;
    }

    public void initZipOutputStream(org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException, org.apache.tools.ant.BuildException {
    }

    public final boolean isAddingNewFiles() {
        return this.H;
    }

    public boolean isCompress() {
        return this.y;
    }

    public final boolean isFirstPass() {
        return !this.doubleFilePass || this.skipWriting;
    }

    public boolean isInUpdateMode() {
        return this.z;
    }

    public final synchronized org.apache.tools.ant.types.ZipScanner j() {
        if (this.u == null) {
            org.apache.tools.ant.types.ZipScanner zipScanner = new org.apache.tools.ant.types.ZipScanner();
            this.u = zipScanner;
            zipScanner.setEncoding(this.I);
            this.u.setSrc(this.zipFile);
        }
        return this.u;
    }

    public final void k() {
        if (!this.z || this.zipFile.exists()) {
            return;
        }
        this.z = false;
        logWhenWriting("ignoring update attribute as " + this.archiveType + " doesn't exist.", 4);
    }

    public final void l() {
        int size = this.w.size();
        for (int i = 0; i < size; i++) {
            logWhenWriting("Processing groupfileset ", 3);
            org.apache.tools.ant.DirectoryScanner directoryScanner = this.w.elementAt(i).getDirectoryScanner(getProject());
            java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
            java.io.File basedir = directoryScanner.getBasedir();
            for (int i2 = 0; i2 < includedFiles.length; i2++) {
                logWhenWriting("Adding file " + includedFiles[i2] + " to fileset", 3);
                org.apache.tools.ant.types.ZipFileSet zipFileSet = new org.apache.tools.ant.types.ZipFileSet();
                zipFileSet.setProject(getProject());
                zipFileSet.setSrc(new java.io.File(basedir, includedFiles[i2]));
                add(zipFileSet);
                this.x.addElement(zipFileSet);
            }
        }
    }

    public void logWhenWriting(java.lang.String str, int i) {
        if (this.skipWriting) {
            return;
        }
        log(str, i);
    }

    public final java.io.File m() {
        org.apache.tools.ant.util.FileUtils fileUtils = V;
        java.io.File createTempFile = fileUtils.createTempFile(getProject(), "zip", com.baidu.mobads.sdk.internal.al.k, this.zipFile.getParentFile(), true, false);
        try {
            fileUtils.rename(this.zipFile, createTempFile);
            return createTempFile;
        } catch (java.io.IOException unused) {
            throw new org.apache.tools.ant.BuildException("Unable to rename old file (" + this.zipFile.getAbsolutePath() + ") to temporary file");
        } catch (java.lang.SecurityException unused2) {
            throw new org.apache.tools.ant.BuildException("Not allowed to rename old file (" + this.zipFile.getAbsolutePath() + ") to temporary file");
        }
    }

    public final org.apache.tools.ant.types.Resource[] n(org.apache.tools.ant.types.Resource[] resourceArr, org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        org.apache.tools.ant.types.Resource[] selectOutOfDateSources = org.apache.tools.ant.util.ResourceUtils.selectOutOfDateSources(this, selectFileResources(resourceArr), fileNameMapper, j(), 2000L);
        if (this.B) {
            return selectOutOfDateSources;
        }
        org.apache.tools.ant.types.resources.Union union = new org.apache.tools.ant.types.resources.Union();
        union.addAll(java.util.Arrays.asList(selectDirectoryResources(resourceArr)));
        org.apache.tools.ant.types.ResourceCollection selectSources = org.apache.tools.ant.util.ResourceUtils.selectSources(this, union, fileNameMapper, j(), U);
        if (selectSources.size() <= 0) {
            return selectOutOfDateSources;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(java.util.Arrays.asList(((org.apache.tools.ant.types.resources.Union) selectSources).listResources()));
        arrayList.addAll(java.util.Arrays.asList(selectOutOfDateSources));
        return (org.apache.tools.ant.types.Resource[]) arrayList.toArray(selectOutOfDateSources);
    }

    public void reset() {
        this.C.removeAllElements();
        this.zipFile = null;
        this.v = null;
        this.w.removeAllElements();
        this.duplicate = com.anythink.expressad.d.a.b.ay;
        this.archiveType = "zip";
        this.y = true;
        this.emptyBehavior = org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP;
        this.z = false;
        this.B = false;
        this.I = null;
    }

    public org.apache.tools.ant.types.Resource[] selectDirectoryResources(org.apache.tools.ant.types.Resource[] resourceArr) {
        return selectResources(resourceArr, new org.apache.tools.ant.taskdefs.Zip.AnonymousClass6());
    }

    public org.apache.tools.ant.types.Resource[] selectFileResources(org.apache.tools.ant.types.Resource[] resourceArr) {
        return selectResources(resourceArr, new org.apache.tools.ant.taskdefs.Zip.AnonymousClass5());
    }

    public org.apache.tools.ant.types.Resource[] selectResources(org.apache.tools.ant.types.Resource[] resourceArr, org.apache.tools.ant.types.resources.selectors.ResourceSelector resourceSelector) {
        if (resourceArr.length == 0) {
            return resourceArr;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(resourceArr.length);
        for (int i = 0; i < resourceArr.length; i++) {
            if (resourceSelector.isSelected(resourceArr[i])) {
                arrayList.add(resourceArr[i]);
            }
        }
        return arrayList.size() != resourceArr.length ? (org.apache.tools.ant.types.Resource[]) arrayList.toArray(new org.apache.tools.ant.types.Resource[arrayList.size()]) : resourceArr;
    }

    public void setBasedir(java.io.File file) {
        this.v = file;
    }

    public void setComment(java.lang.String str) {
        this.L = str;
    }

    public void setCompress(boolean z) {
        this.y = z;
    }

    public void setCreateUnicodeExtraFields(org.apache.tools.ant.taskdefs.Zip.UnicodeExtraField unicodeExtraField) {
        this.P = unicodeExtraField;
    }

    public final void setCurrentExtraFields(org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr) {
        X.set(zipExtraFieldArr);
    }

    public void setDestFile(java.io.File file) {
        this.zipFile = file;
    }

    public void setDuplicate(org.apache.tools.ant.taskdefs.Zip.Duplicate duplicate) {
        this.duplicate = duplicate.getValue();
    }

    public void setEncoding(java.lang.String str) {
        this.I = str;
    }

    public void setFallBackToUTF8(boolean z) {
        this.Q = z;
    }

    @java.lang.Deprecated
    public void setFile(java.io.File file) {
        setDestFile(file);
    }

    public void setFilesonly(boolean z) {
        this.B = z;
    }

    public void setKeepCompression(boolean z) {
        this.J = z;
    }

    public void setLevel(int i) {
        this.M = i;
    }

    public void setModificationtime(java.lang.String str) {
        this.E = str;
    }

    public void setPreserve0Permissions(boolean z) {
        this.N = z;
    }

    public void setRoundUp(boolean z) {
        this.K = z;
    }

    public void setUpdate(boolean z) {
        this.z = z;
        this.A = z;
    }

    public void setUseLanguageEncodingFlag(boolean z) {
        this.O = z;
    }

    public void setWhenempty(org.apache.tools.ant.taskdefs.Zip.WhenEmpty whenEmpty) {
        this.emptyBehavior = whenEmpty.getValue();
    }

    public void setZip64Mode(org.apache.tools.ant.taskdefs.Zip.Zip64ModeAttribute zip64ModeAttribute) {
        this.R = zip64ModeAttribute;
    }

    @java.lang.Deprecated
    public void setZipfile(java.io.File file) {
        setDestFile(file);
    }

    public void zipDir(java.io.File file, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str, int i) throws java.io.IOException {
        zipDir(file, zipOutputStream, str, i, (org.apache.tools.zip.ZipExtraField[]) null);
    }

    public void zipDir(java.io.File file, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str, int i, org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr) throws java.io.IOException {
        zipDir(file == null ? null : new org.apache.tools.ant.types.resources.FileResource(file), zipOutputStream, str, i, zipExtraFieldArr);
    }

    public void zipDir(org.apache.tools.ant.types.Resource resource, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str, int i, org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr) throws java.io.IOException {
        if (this.B) {
            logWhenWriting("skipping directory " + str + " for file-only archive", 3);
            return;
        }
        if (this.addedDirs.get(str) != null) {
            return;
        }
        logWhenWriting("adding directory " + str, 3);
        this.addedDirs.put(str, str);
        if (this.skipWriting) {
            return;
        }
        org.apache.tools.zip.ZipEntry zipEntry = new org.apache.tools.zip.ZipEntry(str);
        int i2 = this.K ? 1999 : 0;
        if (this.E != null) {
            zipEntry.setTime(this.F);
        } else if (resource == null || !resource.isExists()) {
            zipEntry.setTime(java.lang.System.currentTimeMillis() + i2);
        } else {
            zipEntry.setTime(resource.getLastModified() + i2);
        }
        zipEntry.setSize(0L);
        zipEntry.setMethod(0);
        zipEntry.setCrc(S);
        zipEntry.setUnixMode(i);
        if (zipExtraFieldArr != null) {
            zipEntry.setExtraFields(zipExtraFieldArr);
        }
        zipOutputStream.putNextEntry(zipEntry);
    }

    public void zipFile(java.io.File file, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str, int i) throws java.io.IOException {
        if (file.equals(this.zipFile)) {
            throw new org.apache.tools.ant.BuildException("A zip file cannot include itself", getLocation());
        }
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
        try {
            zipFile(bufferedInputStream, zipOutputStream, str, file.lastModified() + (this.K ? 1999 : 0), null, i);
        } finally {
            bufferedInputStream.close();
        }
    }

    public void zipFile(java.io.InputStream inputStream, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str, long j, java.io.File file, int i) throws java.io.IOException {
        if (!this.entries.containsKey(str)) {
            logWhenWriting("adding entry " + str, 3);
        } else {
            if (this.duplicate.equals("preserve")) {
                logWhenWriting(str + " already added, skipping", 2);
                return;
            }
            if (this.duplicate.equals("fail")) {
                throw new org.apache.tools.ant.BuildException("Duplicate file " + str + " was found and the duplicate attribute is 'fail'.");
            }
            logWhenWriting("duplicate file " + str + " found, adding.", 3);
        }
        this.entries.put(str, str);
        if (!this.skipWriting) {
            org.apache.tools.zip.ZipEntry zipEntry = new org.apache.tools.zip.ZipEntry(str);
            if (this.E != null) {
                j = this.F;
            }
            zipEntry.setTime(j);
            zipEntry.setMethod(this.y ? 8 : 0);
            if (!inputStream.markSupported()) {
                inputStream = new java.io.BufferedInputStream(inputStream);
            }
            if (!zipOutputStream.isSeekable() && !this.y) {
                java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                inputStream.mark(Integer.MAX_VALUE);
                byte[] bArr = new byte[8192];
                long j2 = 0;
                int i2 = 0;
                do {
                    j2 += i2;
                    crc32.update(bArr, 0, i2);
                    i2 = inputStream.read(bArr, 0, 8192);
                } while (i2 != -1);
                inputStream.reset();
                zipEntry.setSize(j2);
                zipEntry.setCrc(crc32.getValue());
            }
            zipEntry.setUnixMode(i);
            org.apache.tools.zip.ZipExtraField[] currentExtraFields = getCurrentExtraFields();
            if (currentExtraFields != null) {
                zipEntry.setExtraFields(currentExtraFields);
            }
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr2 = new byte[8192];
            int i3 = 0;
            do {
                if (i3 != 0) {
                    zipOutputStream.write(bArr2, 0, i3);
                }
                i3 = inputStream.read(bArr2, 0, 8192);
            } while (i3 != -1);
        }
        this.D.addElement(str);
    }

    public final void zipFile(java.io.InputStream inputStream, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str, long j, java.io.File file, int i, org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr) throws java.io.IOException {
        try {
            setCurrentExtraFields(zipExtraFieldArr);
            zipFile(inputStream, zipOutputStream, str, j, file, i);
        } finally {
            setCurrentExtraFields(null);
        }
    }
}
