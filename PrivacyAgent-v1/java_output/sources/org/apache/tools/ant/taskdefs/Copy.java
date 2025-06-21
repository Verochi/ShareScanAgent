package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Copy extends org.apache.tools.ant.Task {
    public static final java.io.File D = new java.io.File("/NULL_FILE");
    public static final java.lang.String E = java.lang.System.getProperty("line.separator");
    public boolean A;
    public boolean B;
    public org.apache.tools.ant.types.Resource C;
    protected java.util.Hashtable<java.io.File, java.io.File> completeDirMap;
    protected java.util.Hashtable<java.lang.String, java.lang.String[]> dirCopyMap;
    protected boolean failonerror;
    protected java.util.Hashtable<java.lang.String, java.lang.String[]> fileCopyMap;
    protected org.apache.tools.ant.util.FileUtils fileUtils;
    protected java.util.Vector<org.apache.tools.ant.types.ResourceCollection> filesets;
    protected boolean filtering;
    protected boolean flatten;
    protected boolean forceOverwrite;
    protected boolean includeEmpty;
    protected org.apache.tools.ant.types.Mapper mapperElement;
    protected boolean preserveLastModified;
    protected java.util.Vector<org.apache.tools.ant.types.ResourceCollection> rcs;
    public boolean u;
    public final java.util.Vector<org.apache.tools.ant.types.FilterChain> v;
    protected int verbosity;
    public final java.util.Vector<org.apache.tools.ant.types.FilterSet> w;
    public java.lang.String x;
    public java.lang.String y;
    public long z;
    protected java.io.File file = null;
    protected java.io.File destFile = null;
    protected java.io.File destDir = null;

    /* renamed from: org.apache.tools.ant.taskdefs.Copy$1, reason: invalid class name */
    public class AnonymousClass1 implements org.apache.tools.ant.types.ResourceFactory {
        public final /* synthetic */ java.io.File n;

        public AnonymousClass1(java.io.File file) {
            this.n = file;
        }

        @Override // org.apache.tools.ant.types.ResourceFactory
        public org.apache.tools.ant.types.Resource getResource(java.lang.String str) {
            return new org.apache.tools.ant.types.resources.FileResource(this.n, str);
        }
    }

    public Copy() {
        java.util.Vector<org.apache.tools.ant.types.ResourceCollection> vector = new java.util.Vector<>();
        this.rcs = vector;
        this.filesets = vector;
        this.u = false;
        this.filtering = false;
        this.preserveLastModified = false;
        this.forceOverwrite = false;
        this.flatten = false;
        this.verbosity = 3;
        this.includeEmpty = true;
        this.failonerror = true;
        this.fileCopyMap = new org.apache.tools.ant.util.LinkedHashtable();
        this.dirCopyMap = new org.apache.tools.ant.util.LinkedHashtable();
        this.completeDirMap = new org.apache.tools.ant.util.LinkedHashtable();
        this.mapperElement = null;
        this.v = new java.util.Vector<>();
        this.w = new java.util.Vector<>();
        this.x = null;
        this.y = null;
        this.z = 0L;
        this.A = false;
        this.B = false;
        this.C = null;
        org.apache.tools.ant.util.FileUtils fileUtils = org.apache.tools.ant.util.FileUtils.getFileUtils();
        this.fileUtils = fileUtils;
        this.z = fileUtils.getFileTimestampGranularity();
    }

    public static void c(java.io.File file, java.lang.String str, java.util.Map<java.io.File, java.util.List<java.lang.String>> map) {
        if (str != null) {
            d(file, new java.lang.String[]{str}, map);
        }
    }

    public static void d(java.io.File file, java.lang.String[] strArr, java.util.Map<java.io.File, java.util.List<java.lang.String>> map) {
        if (strArr != null) {
            java.io.File g = g(file);
            java.util.List<java.lang.String> list = map.get(g);
            if (list == null) {
                list = new java.util.ArrayList<>(strArr.length);
                map.put(g, list);
            }
            list.addAll(java.util.Arrays.asList(strArr));
        }
    }

    public static java.io.File g(java.io.File file) {
        return file == null ? D : file;
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.rcs.add(resourceCollection);
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        createMapper().add(fileNameMapper);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        add(fileSet);
    }

    public java.util.Map<org.apache.tools.ant.types.Resource, java.lang.String[]> buildMap(org.apache.tools.ant.types.Resource[] resourceArr, java.io.File file, org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        org.apache.tools.ant.types.Resource[] selectOutOfDateSources;
        java.util.HashMap hashMap = new java.util.HashMap();
        if (this.forceOverwrite) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (org.apache.tools.ant.types.Resource resource : resourceArr) {
                if (fileNameMapper.mapFileName(resource.getName()) != null) {
                    arrayList.add(resource);
                }
            }
            selectOutOfDateSources = (org.apache.tools.ant.types.Resource[]) arrayList.toArray(new org.apache.tools.ant.types.Resource[arrayList.size()]);
        } else {
            selectOutOfDateSources = org.apache.tools.ant.util.ResourceUtils.selectOutOfDateSources(this, resourceArr, fileNameMapper, new org.apache.tools.ant.taskdefs.Copy.AnonymousClass1(file), this.z);
        }
        for (org.apache.tools.ant.types.Resource resource2 : selectOutOfDateSources) {
            java.lang.String[] mapFileName = fileNameMapper.mapFileName(resource2.getName());
            if (mapFileName == null || mapFileName.length == 0) {
                throw new org.apache.tools.ant.BuildException("Can't copy a resource without a name if the mapper doesn't provide one.");
            }
            if (this.u) {
                for (int i = 0; i < mapFileName.length; i++) {
                    mapFileName[i] = new java.io.File(file, mapFileName[i]).getAbsolutePath();
                }
                hashMap.put(resource2, mapFileName);
            } else {
                hashMap.put(resource2, new java.lang.String[]{new java.io.File(file, mapFileName[0]).getAbsolutePath()});
            }
        }
        return hashMap;
    }

    public void buildMap(java.io.File file, java.io.File file2, java.lang.String[] strArr, org.apache.tools.ant.util.FileNameMapper fileNameMapper, java.util.Hashtable<java.lang.String, java.lang.String[]> hashtable) {
        java.lang.String[] restrict;
        if (this.forceOverwrite) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str : strArr) {
                if (fileNameMapper.mapFileName(str) != null) {
                    arrayList.add(str);
                }
            }
            restrict = (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
        } else {
            restrict = new org.apache.tools.ant.util.SourceFileScanner(this).restrict(strArr, file, file2, fileNameMapper, this.z);
        }
        for (java.lang.String str2 : restrict) {
            java.io.File file3 = new java.io.File(file, str2);
            java.lang.String[] mapFileName = fileNameMapper.mapFileName(str2);
            if (mapFileName != null && mapFileName.length != 0) {
                if (this.u) {
                    for (int i = 0; i < mapFileName.length; i++) {
                        mapFileName[i] = new java.io.File(file2, mapFileName[i]).getAbsolutePath();
                    }
                    hashtable.put(file3.getAbsolutePath(), mapFileName);
                } else {
                    hashtable.put(file3.getAbsolutePath(), new java.lang.String[]{new java.io.File(file2, mapFileName[0]).getAbsolutePath()});
                }
            }
        }
    }

    public org.apache.tools.ant.types.FilterChain createFilterChain() {
        org.apache.tools.ant.types.FilterChain filterChain = new org.apache.tools.ant.types.FilterChain();
        this.v.addElement(filterChain);
        return filterChain;
    }

    public org.apache.tools.ant.types.FilterSet createFilterSet() {
        org.apache.tools.ant.types.FilterSet filterSet = new org.apache.tools.ant.types.FilterSet();
        this.w.addElement(filterSet);
        return filterSet;
    }

    public org.apache.tools.ant.types.Mapper createMapper() throws org.apache.tools.ant.BuildException {
        if (this.mapperElement != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS, getLocation());
        }
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        this.mapperElement = mapper;
        return mapper;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0171 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doFileOperations() {
        java.lang.String str;
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String[]>> it;
        java.lang.String str2;
        org.apache.tools.ant.types.FilterSetCollection filterSetCollection;
        if (this.fileCopyMap.size() > 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str3 = "Copying ";
            sb.append("Copying ");
            sb.append(this.fileCopyMap.size());
            sb.append(" file");
            sb.append(this.fileCopyMap.size() == 1 ? "" : "s");
            sb.append(" to ");
            sb.append(this.destDir.getAbsolutePath());
            log(sb.toString());
            java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String[]>> it2 = this.fileCopyMap.entrySet().iterator();
            while (it2.hasNext()) {
                java.util.Map.Entry<java.lang.String, java.lang.String[]> next = it2.next();
                java.lang.String key = next.getKey();
                java.lang.String[] value = next.getValue();
                int length = value.length;
                int i = 0;
                while (i < length) {
                    java.lang.String str4 = value[i];
                    if (key.equals(str4)) {
                        log("Skipping self-copy of " + key, this.verbosity);
                        str = str3;
                        it = it2;
                    } else {
                        try {
                            log(str3 + key + " to " + str4, this.verbosity);
                            filterSetCollection = new org.apache.tools.ant.types.FilterSetCollection();
                            if (this.filtering) {
                                filterSetCollection.addFilterSet(getProject().getGlobalFilterSet());
                            }
                            java.util.Iterator<org.apache.tools.ant.types.FilterSet> it3 = this.w.iterator();
                            while (it3.hasNext()) {
                                filterSetCollection.addFilterSet(it3.next());
                            }
                            str = str3;
                        } catch (java.io.IOException e) {
                            e = e;
                            str = str3;
                        }
                        try {
                            it = it2;
                        } catch (java.io.IOException e2) {
                            e = e2;
                            it = it2;
                            str2 = "Failed to copy " + key + " to " + str4 + " due to " + f(e);
                            java.io.File file = new java.io.File(str4);
                            if (!(e instanceof org.apache.tools.ant.util.ResourceUtils.ReadOnlyTargetFileException) && file.exists() && !file.delete()) {
                                str2 = str2 + " and I couldn't delete the corrupt " + str4;
                            }
                            if (!this.failonerror) {
                                throw new org.apache.tools.ant.BuildException(str2, e, getLocation());
                            }
                            log(str2, 0);
                            i++;
                            str3 = str;
                            it2 = it;
                        }
                        try {
                            this.fileUtils.copyFile(new java.io.File(key), new java.io.File(str4), filterSetCollection, this.v, this.forceOverwrite, this.preserveLastModified, false, this.x, this.y, getProject(), getForce());
                        } catch (java.io.IOException e3) {
                            e = e3;
                            str2 = "Failed to copy " + key + " to " + str4 + " due to " + f(e);
                            java.io.File file2 = new java.io.File(str4);
                            if (!(e instanceof org.apache.tools.ant.util.ResourceUtils.ReadOnlyTargetFileException)) {
                                str2 = str2 + " and I couldn't delete the corrupt " + str4;
                            }
                            if (!this.failonerror) {
                            }
                        }
                    }
                    i++;
                    str3 = str;
                    it2 = it;
                }
            }
        }
        if (this.includeEmpty) {
            int i2 = 0;
            for (java.lang.String[] strArr : this.dirCopyMap.values()) {
                int i3 = i2;
                for (java.lang.String str5 : strArr) {
                    java.io.File file3 = new java.io.File(str5);
                    if (!file3.exists()) {
                        if (file3.mkdirs() || file3.isDirectory()) {
                            i3++;
                        } else {
                            log("Unable to create directory " + file3.getAbsolutePath(), 0);
                        }
                    }
                }
                i2 = i3;
            }
            if (i2 > 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Copied ");
                sb2.append(this.dirCopyMap.size());
                sb2.append(" empty director");
                sb2.append(this.dirCopyMap.size() == 1 ? "y" : "ies");
                sb2.append(" to ");
                sb2.append(i2);
                sb2.append(" empty director");
                sb2.append(i2 != 1 ? "ies" : "y");
                sb2.append(" under ");
                sb2.append(this.destDir.getAbsolutePath());
                log(sb2.toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0159 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doResourceOperations(java.util.Map<org.apache.tools.ant.types.Resource, java.lang.String[]> map) {
        java.lang.String str;
        java.lang.String str2;
        int i;
        int i2;
        java.lang.String[] strArr;
        java.lang.String str3;
        if (map.size() > 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str4 = "Copying ";
            sb.append("Copying ");
            sb.append(map.size());
            sb.append(" resource");
            sb.append(map.size() == 1 ? "" : "s");
            sb.append(" to ");
            sb.append(this.destDir.getAbsolutePath());
            log(sb.toString());
            for (java.util.Map.Entry<org.apache.tools.ant.types.Resource, java.lang.String[]> entry : map.entrySet()) {
                org.apache.tools.ant.types.Resource key = entry.getKey();
                java.lang.String[] value = entry.getValue();
                int length = value.length;
                int i3 = 0;
                while (i3 < length) {
                    java.lang.String str5 = value[i3];
                    try {
                        log(str4 + key + " to " + str5, this.verbosity);
                        org.apache.tools.ant.types.FilterSetCollection filterSetCollection = new org.apache.tools.ant.types.FilterSetCollection();
                        if (this.filtering) {
                            filterSetCollection.addFilterSet(getProject().getGlobalFilterSet());
                        }
                        java.util.Iterator<org.apache.tools.ant.types.FilterSet> it = this.w.iterator();
                        while (it.hasNext()) {
                            filterSetCollection.addFilterSet(it.next());
                        }
                        int i4 = i3;
                        try {
                            str = str4;
                            str2 = str5;
                            i = i4;
                            i2 = length;
                            strArr = value;
                        } catch (java.io.IOException e) {
                            e = e;
                            i = i4;
                            str = str4;
                            str2 = str5;
                            i2 = length;
                            strArr = value;
                            str3 = "Failed to copy " + key + " to " + str2 + " due to " + f(e);
                            java.io.File file = new java.io.File(str2);
                            if (!(e instanceof org.apache.tools.ant.util.ResourceUtils.ReadOnlyTargetFileException) && file.exists() && !file.delete()) {
                                str3 = str3 + " and I couldn't delete the corrupt " + str2;
                            }
                            if (!this.failonerror) {
                                throw new org.apache.tools.ant.BuildException(str3, e, getLocation());
                            }
                            log(str3, 0);
                            i3 = i + 1;
                            length = i2;
                            str4 = str;
                            value = strArr;
                        }
                        try {
                            org.apache.tools.ant.util.ResourceUtils.copyResource(key, new org.apache.tools.ant.types.resources.FileResource(this.destDir, str5), filterSetCollection, this.v, this.forceOverwrite, this.preserveLastModified, false, this.x, this.y, getProject(), getForce());
                        } catch (java.io.IOException e2) {
                            e = e2;
                            str3 = "Failed to copy " + key + " to " + str2 + " due to " + f(e);
                            java.io.File file2 = new java.io.File(str2);
                            if (!(e instanceof org.apache.tools.ant.util.ResourceUtils.ReadOnlyTargetFileException)) {
                                str3 = str3 + " and I couldn't delete the corrupt " + str2;
                            }
                            if (!this.failonerror) {
                            }
                        }
                    } catch (java.io.IOException e3) {
                        e = e3;
                        str = str4;
                        str2 = str5;
                        i = i3;
                    }
                    i3 = i + 1;
                    length = i2;
                    str4 = str;
                    value = strArr;
                }
            }
        }
    }

    public final void e() {
        java.io.File file = this.file;
        if (file != null) {
            if (!file.exists()) {
                java.lang.String str = "Warning: Could not find file " + this.file.getAbsolutePath() + " to copy.";
                if (this.failonerror) {
                    throw new org.apache.tools.ant.BuildException(str);
                }
                if (this.B) {
                    return;
                }
                log(str, 0);
                return;
            }
            if (this.destFile == null) {
                this.destFile = new java.io.File(this.destDir, this.file.getName());
            }
            if (this.forceOverwrite || !this.destFile.exists() || this.file.lastModified() - this.z > this.destFile.lastModified()) {
                this.fileCopyMap.put(this.file.getAbsolutePath(), new java.lang.String[]{this.destFile.getAbsolutePath()});
                return;
            }
            log(this.file + " omitted as " + this.destFile + " is up to date.", 3);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:7|8|9|(3:11|(5:56|(3:61|62|63)|64|(4:67|(3:92|93|(2:95|(3:97|98|99)(1:100))(3:101|102|103))(9:69|70|(3:72|(1:74)|75)|76|(3:88|89|90)|81|(1:83)(1:87)|84|85)|86|65)|104)(10:15|16|17|18|19|20|21|(1:29)|30|31)|32)|106|107|108|109|110|(7:112|(1:114)|115|116|(1:118)|119|120)|121|(1:123)|124|125|115|116|(0)|119|120) */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01de, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01e2, code lost:
    
        if (r19.failonerror == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01e6, code lost:
    
        if (r19.B == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01e8, code lost:
    
        log("Warning: " + h(r0), 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0224, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020a  */
    @Override // org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.ResourceCollection resourceCollection;
        org.apache.tools.ant.types.ResourceCollection resourceCollection2;
        int i;
        java.io.File file = this.file;
        java.io.File file2 = this.destFile;
        java.io.File file3 = this.destDir;
        org.apache.tools.ant.types.ResourceCollection elementAt = (file == null && file2 != null && this.rcs.size() == 1) ? this.rcs.elementAt(0) : null;
        try {
            try {
                try {
                    validateAttributes();
                    e();
                    java.util.HashMap<java.io.File, java.util.List<java.lang.String>> hashMap = new java.util.HashMap<>();
                    java.util.HashMap<java.io.File, java.util.List<java.lang.String>> hashMap2 = new java.util.HashMap<>();
                    java.util.HashSet<java.io.File> hashSet = new java.util.HashSet<>();
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    int size = this.rcs.size();
                    int i2 = 0;
                    while (i2 < size) {
                        org.apache.tools.ant.types.ResourceCollection elementAt2 = this.rcs.elementAt(i2);
                        if ((elementAt2 instanceof org.apache.tools.ant.types.FileSet) && elementAt2.isFilesystemOnly()) {
                            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) elementAt2;
                            try {
                                org.apache.tools.ant.DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(getProject());
                                java.io.File dir = fileSet.getDir(getProject());
                                java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
                                i = size;
                                java.lang.String[] includedDirectories = directoryScanner.getIncludedDirectories();
                                resourceCollection2 = elementAt;
                                try {
                                    if (!this.flatten && this.mapperElement == null && directoryScanner.isEverythingIncluded() && !fileSet.hasPatterns()) {
                                        this.completeDirMap.put(dir, this.destDir);
                                    }
                                    d(dir, includedFiles, hashMap);
                                    d(dir, includedDirectories, hashMap2);
                                    hashSet.add(dir);
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    resourceCollection = resourceCollection2;
                                    this.C = null;
                                    this.file = file;
                                    this.destFile = file2;
                                    this.destDir = file3;
                                    if (resourceCollection != null) {
                                        this.rcs.insertElementAt(resourceCollection, 0);
                                    }
                                    this.fileCopyMap.clear();
                                    this.dirCopyMap.clear();
                                    this.completeDirMap.clear();
                                    throw th;
                                }
                            } catch (org.apache.tools.ant.BuildException e) {
                                resourceCollection2 = elementAt;
                                i = size;
                                if (this.failonerror || !h(e).endsWith(org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX)) {
                                    throw e;
                                }
                                if (!this.B) {
                                    log("Warning: " + h(e), 0);
                                }
                            }
                        } else {
                            resourceCollection2 = elementAt;
                            i = size;
                            if (!elementAt2.isFilesystemOnly() && !supportsNonFileResources()) {
                                throw new org.apache.tools.ant.BuildException("Only FileSystem resources are supported.");
                            }
                            for (org.apache.tools.ant.types.Resource resource : elementAt2) {
                                if (resource.isExists()) {
                                    java.io.File file4 = D;
                                    java.lang.String name = resource.getName();
                                    org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
                                    if (fileProvider != null) {
                                        org.apache.tools.ant.types.resources.FileResource asFileResource = org.apache.tools.ant.util.ResourceUtils.asFileResource(fileProvider);
                                        java.io.File g = g(asFileResource.getBaseDir());
                                        if (asFileResource.getBaseDir() == null) {
                                            name = asFileResource.getFile().getAbsolutePath();
                                        }
                                        file4 = g;
                                    }
                                    if (!resource.isDirectory() && fileProvider == null) {
                                        arrayList.add(resource);
                                    }
                                    c(file4, name, resource.isDirectory() ? hashMap2 : hashMap);
                                    hashSet.add(file4);
                                } else {
                                    java.lang.String str = "Warning: Could not find resource " + resource.toLongString() + " to copy.";
                                    if (this.failonerror) {
                                        throw new org.apache.tools.ant.BuildException(str);
                                    }
                                    if (!this.B) {
                                        log(str, 0);
                                    }
                                }
                            }
                        }
                        i2++;
                        size = i;
                        elementAt = resourceCollection2;
                    }
                    resourceCollection2 = elementAt;
                    i(hashSet, hashMap2, hashMap);
                    try {
                        doFileOperations();
                    } catch (org.apache.tools.ant.BuildException e2) {
                        if (this.failonerror) {
                            throw e2;
                        }
                        if (!this.B) {
                            log("Warning: " + h(e2), 0);
                        }
                    }
                    if (arrayList.size() <= 0) {
                        if (this.C != null) {
                        }
                        this.C = null;
                        this.file = file;
                        this.destFile = file2;
                        this.destDir = file3;
                        if (resourceCollection2 != null) {
                            this.rcs.insertElementAt(resourceCollection2, 0);
                        }
                        this.fileCopyMap.clear();
                        this.dirCopyMap.clear();
                        this.completeDirMap.clear();
                    }
                    java.util.Map<org.apache.tools.ant.types.Resource, java.lang.String[]> scan = scan((org.apache.tools.ant.types.Resource[]) arrayList.toArray(new org.apache.tools.ant.types.Resource[arrayList.size()]), this.destDir);
                    org.apache.tools.ant.types.Resource resource2 = this.C;
                    if (resource2 != null) {
                        scan.put(resource2, new java.lang.String[]{this.destFile.getAbsolutePath()});
                    }
                    doResourceOperations(scan);
                    this.C = null;
                    this.file = file;
                    this.destFile = file2;
                    this.destDir = file3;
                    if (resourceCollection2 != null) {
                    }
                    this.fileCopyMap.clear();
                    this.dirCopyMap.clear();
                    this.completeDirMap.clear();
                } catch (org.apache.tools.ant.BuildException e3) {
                    org.apache.tools.ant.types.ResourceCollection resourceCollection3 = elementAt;
                    if (this.failonerror) {
                        throw e3;
                    }
                    if (!h(e3).equals("Cannot perform operation from directory to file.")) {
                        throw e3;
                    }
                    log("Warning: " + h(e3), 0);
                    this.C = null;
                    this.file = file;
                    this.destFile = file2;
                    this.destDir = file3;
                    if (resourceCollection3 != null) {
                        this.rcs.insertElementAt(resourceCollection3, 0);
                    }
                    this.fileCopyMap.clear();
                    this.dirCopyMap.clear();
                    this.completeDirMap.clear();
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            resourceCollection = elementAt;
        }
    }

    public final java.lang.String f(java.lang.Exception exc) {
        boolean z = exc.getClass() == java.io.IOException.class;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (!z || exc.getMessage() == null) {
            stringBuffer.append(exc.getClass().getName());
        }
        if (exc.getMessage() != null) {
            if (!z) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(exc.getMessage());
        }
        if (exc.getClass().getName().contains("MalformedInput")) {
            java.lang.String str = E;
            stringBuffer.append(str);
            stringBuffer.append("This is normally due to the input file containing invalid");
            stringBuffer.append(str);
            stringBuffer.append("bytes for the character encoding used : ");
            java.lang.String str2 = this.x;
            if (str2 == null) {
                str2 = this.fileUtils.getDefaultEncoding();
            }
            stringBuffer.append(str2);
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public java.lang.String getEncoding() {
        return this.x;
    }

    public org.apache.tools.ant.util.FileUtils getFileUtils() {
        return this.fileUtils;
    }

    public java.util.Vector<org.apache.tools.ant.types.FilterChain> getFilterChains() {
        return this.v;
    }

    public java.util.Vector<org.apache.tools.ant.types.FilterSet> getFilterSets() {
        return this.w;
    }

    public boolean getForce() {
        return this.A;
    }

    public final org.apache.tools.ant.util.FileNameMapper getMapper() {
        org.apache.tools.ant.types.Mapper mapper = this.mapperElement;
        return mapper != null ? mapper.getImplementation() : this.flatten ? new org.apache.tools.ant.util.FlatFileNameMapper() : new org.apache.tools.ant.util.IdentityMapper();
    }

    public java.lang.String getOutputEncoding() {
        return this.y;
    }

    public boolean getPreserveLastModified() {
        return this.preserveLastModified;
    }

    public final java.lang.String h(java.lang.Exception exc) {
        return exc.getMessage() == null ? exc.toString() : exc.getMessage();
    }

    public final void i(java.util.HashSet<java.io.File> hashSet, java.util.HashMap<java.io.File, java.util.List<java.lang.String>> hashMap, java.util.HashMap<java.io.File, java.util.List<java.lang.String>> hashMap2) {
        java.util.Iterator<java.io.File> it = hashSet.iterator();
        while (it.hasNext()) {
            java.io.File next = it.next();
            java.util.List<java.lang.String> list = hashMap2.get(next);
            java.util.List<java.lang.String> list2 = hashMap.get(next);
            java.lang.String[] strArr = new java.lang.String[0];
            if (list != null) {
                strArr = (java.lang.String[]) list.toArray(strArr);
            }
            java.lang.String[] strArr2 = new java.lang.String[0];
            if (list2 != null) {
                strArr2 = (java.lang.String[]) list2.toArray(strArr2);
            }
            if (next == D) {
                next = null;
            }
            scan(next, this.destDir, strArr, strArr2);
        }
    }

    public boolean isEnableMultipleMapping() {
        return this.u;
    }

    public java.util.Map<org.apache.tools.ant.types.Resource, java.lang.String[]> scan(org.apache.tools.ant.types.Resource[] resourceArr, java.io.File file) {
        return buildMap(resourceArr, file, getMapper());
    }

    public void scan(java.io.File file, java.io.File file2, java.lang.String[] strArr, java.lang.String[] strArr2) {
        org.apache.tools.ant.util.FileNameMapper mapper = getMapper();
        buildMap(file, file2, strArr, mapper, this.fileCopyMap);
        if (this.includeEmpty) {
            buildMap(file, file2, strArr2, mapper, this.dirCopyMap);
        }
    }

    public void setEnableMultipleMappings(boolean z) {
        this.u = z;
    }

    public void setEncoding(java.lang.String str) {
        this.x = str;
        if (this.y == null) {
            this.y = str;
        }
    }

    public void setFailOnError(boolean z) {
        this.failonerror = z;
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    public void setFiltering(boolean z) {
        this.filtering = z;
    }

    public void setFlatten(boolean z) {
        this.flatten = z;
    }

    public void setForce(boolean z) {
        this.A = z;
    }

    public void setGranularity(long j) {
        this.z = j;
    }

    public void setIncludeEmptyDirs(boolean z) {
        this.includeEmpty = z;
    }

    public void setOutputEncoding(java.lang.String str) {
        this.y = str;
    }

    public void setOverwrite(boolean z) {
        this.forceOverwrite = z;
    }

    @java.lang.Deprecated
    public void setPreserveLastModified(java.lang.String str) {
        setPreserveLastModified(org.apache.tools.ant.Project.toBoolean(str));
    }

    public void setPreserveLastModified(boolean z) {
        this.preserveLastModified = z;
    }

    public void setQuiet(boolean z) {
        this.B = z;
    }

    public void setTodir(java.io.File file) {
        this.destDir = file;
    }

    public void setTofile(java.io.File file) {
        this.destFile = file;
    }

    public void setVerbose(boolean z) {
        this.verbosity = z ? 2 : 3;
    }

    public boolean supportsNonFileResources() {
        return getClass().equals(org.apache.tools.ant.taskdefs.Copy.class);
    }

    public void validateAttributes() throws org.apache.tools.ant.BuildException {
        if (this.file == null && this.rcs.size() == 0) {
            throw new org.apache.tools.ant.BuildException("Specify at least one source--a file or a resource collection.");
        }
        java.io.File file = this.destFile;
        if (file != null && this.destDir != null) {
            throw new org.apache.tools.ant.BuildException("Only one of tofile and todir may be set.");
        }
        if (file == null && this.destDir == null) {
            throw new org.apache.tools.ant.BuildException("One of tofile or todir must be set.");
        }
        java.io.File file2 = this.file;
        if (file2 != null && file2.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("Use a resource collection to copy directories.");
        }
        if (this.destFile != null && this.rcs.size() > 0) {
            if (this.rcs.size() > 1) {
                throw new org.apache.tools.ant.BuildException("Cannot concatenate multiple files into a single file.");
            }
            org.apache.tools.ant.types.ResourceCollection elementAt = this.rcs.elementAt(0);
            if (!elementAt.isFilesystemOnly() && !supportsNonFileResources()) {
                throw new org.apache.tools.ant.BuildException("Only FileSystem resources are supported.");
            }
            if (elementAt.size() == 0) {
                throw new org.apache.tools.ant.BuildException("Cannot perform operation from directory to file.");
            }
            if (elementAt.size() != 1) {
                throw new org.apache.tools.ant.BuildException("Cannot concatenate multiple files into a single file.");
            }
            org.apache.tools.ant.types.Resource next = elementAt.iterator().next();
            org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) next.as(org.apache.tools.ant.types.resources.FileProvider.class);
            if (this.file != null) {
                throw new org.apache.tools.ant.BuildException("Cannot concatenate multiple files into a single file.");
            }
            if (fileProvider != null) {
                this.file = fileProvider.getFile();
            } else {
                this.C = next;
            }
            this.rcs.removeElementAt(0);
        }
        java.io.File file3 = this.destFile;
        if (file3 != null) {
            this.destDir = file3.getParentFile();
        }
    }
}
