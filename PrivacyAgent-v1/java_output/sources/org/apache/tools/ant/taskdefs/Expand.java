package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Expand extends org.apache.tools.ant.Task {
    public static final java.lang.String ERROR_MULTIPLE_MAPPERS = "Cannot define more than one mapper";
    public static final org.apache.tools.ant.util.FileUtils G = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final java.lang.String NATIVE_ENCODING = "native-encoding";
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public java.lang.Boolean E;
    public java.lang.String F;
    public java.io.File u;
    public java.io.File v;
    public boolean w;
    public org.apache.tools.ant.types.Mapper x;
    public java.util.Vector<org.apache.tools.ant.types.PatternSet> y;
    public org.apache.tools.ant.types.resources.Union z;

    public Expand() {
        this(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8);
    }

    public Expand(java.lang.String str) {
        this.w = true;
        this.x = null;
        this.y = new java.util.Vector<>();
        this.z = new org.apache.tools.ant.types.resources.Union();
        this.A = false;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = null;
        this.F = str;
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.A = true;
        this.z.add(resourceCollection);
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        createMapper().add(fileNameMapper);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        add(fileSet);
    }

    public void addPatternset(org.apache.tools.ant.types.PatternSet patternSet) {
        this.y.addElement(patternSet);
    }

    public org.apache.tools.ant.types.Mapper createMapper() throws org.apache.tools.ant.BuildException {
        if (this.x != null) {
            throw new org.apache.tools.ant.BuildException(ERROR_MULTIPLE_MAPPERS, getLocation());
        }
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        this.x = mapper;
        return mapper;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if ("expand".equals(getTaskType())) {
            log("!! expand is deprecated. Use unzip instead. !!");
        }
        if (this.v == null && !this.A) {
            throw new org.apache.tools.ant.BuildException("src attribute and/or resources must be specified");
        }
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("Dest attribute must be specified");
        }
        if (file.exists() && !this.u.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("Dest must be a directory.", getLocation());
        }
        java.io.File file2 = this.v;
        if (file2 != null) {
            if (file2.isDirectory()) {
                throw new org.apache.tools.ant.BuildException("Src must not be a directory. Use nested filesets instead.", getLocation());
            }
            if (!this.v.exists()) {
                throw new org.apache.tools.ant.BuildException("src '" + this.v + "' doesn't exist.");
            }
            if (!this.v.canRead()) {
                throw new org.apache.tools.ant.BuildException("src '" + this.v + "' cannot be read.");
            }
            expandFile(G, this.v, this.u);
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.z.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.Resource next = it.next();
            if (next.isExists()) {
                org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) next.as(org.apache.tools.ant.types.resources.FileProvider.class);
                if (fileProvider != null) {
                    expandFile(G, fileProvider.getFile(), this.u);
                } else {
                    expandResource(next, this.u);
                }
            } else {
                log("Skipping '" + next.getName() + "' because it doesn't exist.");
            }
        }
    }

    public void expandFile(org.apache.tools.ant.util.FileUtils fileUtils, java.io.File file, java.io.File file2) {
        org.apache.tools.zip.ZipFile zipFile;
        log("Expanding: " + file + " into " + file2, 2);
        org.apache.tools.ant.util.FileNameMapper mapper = getMapper();
        if (!file.exists()) {
            throw new org.apache.tools.ant.BuildException("Unable to expand " + file + " as the file does not exist", getLocation());
        }
        org.apache.tools.zip.ZipFile zipFile2 = null;
        java.io.InputStream inputStream = null;
        zipFile2 = null;
        try {
            try {
                zipFile = new org.apache.tools.zip.ZipFile(file, this.F, this.D);
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            java.util.Enumeration<org.apache.tools.zip.ZipEntry> entries = zipFile.getEntries();
            boolean z = true;
            while (entries.hasMoreElements()) {
                org.apache.tools.zip.ZipEntry nextElement = entries.nextElement();
                log("extracting " + nextElement.getName(), 4);
                try {
                    java.io.InputStream inputStream2 = zipFile.getInputStream(nextElement);
                    try {
                        extractFile(fileUtils, file, file2, inputStream2, nextElement.getName(), new java.util.Date(nextElement.getTime()), nextElement.isDirectory(), mapper);
                        org.apache.tools.ant.util.FileUtils.close(inputStream2);
                        z = false;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        org.apache.tools.ant.util.FileUtils.close(inputStream);
                        throw th;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            }
            if (z && getFailOnEmptyArchive()) {
                throw new org.apache.tools.ant.BuildException("archive '" + file + "' is empty");
            }
            log("expand complete", 3);
            org.apache.tools.zip.ZipFile.closeQuietly(zipFile);
        } catch (java.io.IOException e2) {
            e = e2;
            zipFile2 = zipFile;
            throw new org.apache.tools.ant.BuildException("Error while expanding " + file.getPath() + "\n" + e.toString(), e);
        } catch (java.lang.Throwable th4) {
            th = th4;
            zipFile2 = zipFile;
            org.apache.tools.zip.ZipFile.closeQuietly(zipFile2);
            throw th;
        }
    }

    public void expandResource(org.apache.tools.ant.types.Resource resource, java.io.File file) {
        throw new org.apache.tools.ant.BuildException("only filesystem based resources are supported by this task.");
    }

    public void extractFile(org.apache.tools.ant.util.FileUtils fileUtils, java.io.File file, java.io.File file2, java.io.InputStream inputStream, java.lang.String str, java.util.Date date, boolean z, org.apache.tools.ant.util.FileNameMapper fileNameMapper) throws java.io.IOException {
        boolean z2;
        java.lang.String[] strArr;
        char c;
        java.lang.String str2 = str;
        char c2 = '/';
        boolean z3 = str.length() > 0 && (str2.charAt(0) == java.io.File.separatorChar || str2.charAt(0) == '/' || str2.charAt(0) == '\\');
        if (this.C && z3) {
            log("stripped absolute path spec from " + str2, 3);
            str2 = str2.substring(1);
        }
        boolean z4 = java.lang.Boolean.TRUE == getAllowFilesToEscapeDest() || (getAllowFilesToEscapeDest() == null && !this.C && z3);
        java.util.Vector<org.apache.tools.ant.types.PatternSet> vector = this.y;
        if (vector != null && vector.size() > 0) {
            java.lang.String replace = str2.replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
            java.util.HashSet hashSet = new java.util.HashSet();
            java.util.HashSet hashSet2 = new java.util.HashSet();
            java.util.Iterator<org.apache.tools.ant.types.PatternSet> it = this.y.iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.types.PatternSet next = it.next();
                java.lang.String[] includePatterns = next.getIncludePatterns(getProject());
                if (includePatterns == null || includePatterns.length == 0) {
                    includePatterns = new java.lang.String[]{org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH};
                }
                int length = includePatterns.length;
                int i = 0;
                while (i < length) {
                    int i2 = length;
                    java.lang.String[] strArr2 = includePatterns;
                    java.lang.String replace2 = includePatterns[i].replace(c2, java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
                    if (replace2.endsWith(java.io.File.separator)) {
                        replace2 = replace2 + org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH;
                    }
                    hashSet.add(replace2);
                    i++;
                    length = i2;
                    includePatterns = strArr2;
                    c2 = '/';
                }
                java.lang.String[] excludePatterns = next.getExcludePatterns(getProject());
                if (excludePatterns != null) {
                    int length2 = excludePatterns.length;
                    int i3 = 0;
                    while (i3 < length2) {
                        java.lang.String[] strArr3 = excludePatterns;
                        java.lang.String replace3 = excludePatterns[i3].replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
                        if (replace3.endsWith(java.io.File.separator)) {
                            replace3 = replace3 + org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH;
                        }
                        hashSet2.add(replace3);
                        i3++;
                        excludePatterns = strArr3;
                    }
                }
                c2 = '/';
            }
            java.util.Iterator it2 = hashSet.iterator();
            boolean z5 = false;
            while (!z5 && it2.hasNext()) {
                z5 = org.apache.tools.ant.types.selectors.SelectorUtils.matchPath((java.lang.String) it2.next(), replace);
            }
            java.util.Iterator it3 = hashSet2.iterator();
            while (z5 && it3.hasNext()) {
                z5 = !org.apache.tools.ant.types.selectors.SelectorUtils.matchPath((java.lang.String) it3.next(), replace);
            }
            if (!z5) {
                log("skipping " + str2 + " as it is excluded or not included.", 3);
                return;
            }
        }
        java.lang.String[] mapFileName = fileNameMapper.mapFileName(str2);
        if (mapFileName == null || mapFileName.length == 0) {
            z2 = true;
            c = 0;
            strArr = new java.lang.String[]{str2};
        } else {
            strArr = mapFileName;
            z2 = true;
            c = 0;
        }
        java.io.File resolveFile = fileUtils.resolveFile(file2, strArr[c]);
        if (!z4 && !fileUtils.isLeadingPath(file2, resolveFile, z2)) {
            log("skipping " + str2 + " as its target " + resolveFile.getCanonicalPath() + " is outside of " + file2.getCanonicalPath() + ".", 3);
            return;
        }
        try {
            if (!this.w && resolveFile.exists() && resolveFile.lastModified() >= date.getTime()) {
                log("Skipping " + resolveFile + " as it is up-to-date", 4);
                return;
            }
            log("expanding " + str2 + " to " + resolveFile, 3);
            java.io.File parentFile = resolveFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            if (z) {
                resolveFile.mkdirs();
            } else {
                byte[] bArr = new byte[1024];
                java.io.FileOutputStream fileOutputStream = null;
                try {
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(resolveFile);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read < 0) {
                                break;
                            } else {
                                fileOutputStream2.write(bArr, 0, read);
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) null);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
            fileUtils.setFileLastModified(resolveFile, date.getTime());
        } catch (java.io.FileNotFoundException e) {
            log("Unable to expand to file " + resolveFile.getPath(), e, 1);
        }
    }

    public java.lang.Boolean getAllowFilesToEscapeDest() {
        return this.E;
    }

    public java.lang.String getEncoding() {
        return this.F;
    }

    public boolean getFailOnEmptyArchive() {
        return this.B;
    }

    public org.apache.tools.ant.util.FileNameMapper getMapper() {
        org.apache.tools.ant.types.Mapper mapper = this.x;
        return mapper != null ? mapper.getImplementation() : new org.apache.tools.ant.util.IdentityMapper();
    }

    public boolean getScanForUnicodeExtraFields() {
        return this.D;
    }

    public void internalSetEncoding(java.lang.String str) {
        if (NATIVE_ENCODING.equals(str)) {
            str = null;
        }
        this.F = str;
    }

    public void internalSetScanForUnicodeExtraFields(boolean z) {
        this.D = z;
    }

    public void setAllowFilesToEscapeDest(boolean z) {
        this.E = java.lang.Boolean.valueOf(z);
    }

    public void setDest(java.io.File file) {
        this.u = file;
    }

    public void setEncoding(java.lang.String str) {
        internalSetEncoding(str);
    }

    public void setFailOnEmptyArchive(boolean z) {
        this.B = z;
    }

    public void setOverwrite(boolean z) {
        this.w = z;
    }

    public void setScanForUnicodeExtraFields(boolean z) {
        internalSetScanForUnicodeExtraFields(z);
    }

    public void setSrc(java.io.File file) {
        this.v = file;
    }

    public void setStripAbsolutePathSpec(boolean z) {
        this.C = z;
    }
}
