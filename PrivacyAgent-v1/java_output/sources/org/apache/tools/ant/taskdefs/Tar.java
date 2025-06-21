package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Tar extends org.apache.tools.ant.taskdefs.MatchingTask {

    @java.lang.Deprecated
    public static final java.lang.String FAIL = "fail";

    @java.lang.Deprecated
    public static final java.lang.String GNU = "gnu";

    @java.lang.Deprecated
    public static final java.lang.String OMIT = "omit";

    @java.lang.Deprecated
    public static final java.lang.String TRUNCATE = "truncate";

    @java.lang.Deprecated
    public static final java.lang.String WARN = "warn";
    public java.lang.String B;
    public java.io.File u;
    public java.io.File v;
    public org.apache.tools.ant.taskdefs.Tar.TarLongFileMode w = new org.apache.tools.ant.taskdefs.Tar.TarLongFileMode();
    public java.util.Vector<org.apache.tools.ant.taskdefs.Tar.TarFileSet> x = new java.util.Vector<>();
    public final java.util.Vector<org.apache.tools.ant.types.ResourceCollection> y = new java.util.Vector<>();
    public boolean z = false;
    public org.apache.tools.ant.taskdefs.Tar.TarCompressionMethod A = new org.apache.tools.ant.taskdefs.Tar.TarCompressionMethod();

    public static final class TarCompressionMethod extends org.apache.tools.ant.types.EnumeratedAttribute {
        public TarCompressionMethod() {
            setValue("none");
        }

        public final java.io.OutputStream b(java.io.OutputStream outputStream) throws java.io.IOException {
            java.lang.String value = getValue();
            if ("gzip".equals(value)) {
                return new java.util.zip.GZIPOutputStream(outputStream);
            }
            if (!"bzip2".equals(value)) {
                return outputStream;
            }
            outputStream.write(66);
            outputStream.write(90);
            return new org.apache.tools.bzip2.CBZip2OutputStream(outputStream);
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"none", "gzip", "bzip2"};
        }
    }

    public static class TarFileSet extends org.apache.tools.ant.types.TarFileSet {
        public java.lang.String[] V;
        public boolean W;

        public TarFileSet() {
            this.V = null;
            this.W = false;
        }

        public TarFileSet(org.apache.tools.ant.types.FileSet fileSet) {
            super(fileSet);
            this.V = null;
            this.W = false;
        }

        public java.lang.String[] getFiles(org.apache.tools.ant.Project project) {
            if (this.V == null) {
                this.V = org.apache.tools.ant.taskdefs.Tar.getFileNames(this);
            }
            return this.V;
        }

        public int getMode() {
            return getFileMode(getProject());
        }

        public boolean getPreserveLeadingSlashes() {
            return this.W;
        }

        public void setMode(java.lang.String str) {
            setFileMode(str);
        }

        public void setPreserveLeadingSlashes(boolean z) {
            this.W = z;
        }
    }

    public static class TarLongFileMode extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String FAIL = "fail";
        public static final java.lang.String GNU = "gnu";
        public static final java.lang.String OMIT = "omit";
        public static final java.lang.String POSIX = "posix";
        public static final java.lang.String TRUNCATE = "truncate";
        public static final java.lang.String WARN = "warn";
        public final java.lang.String[] b = {"warn", "fail", "truncate", "gnu", POSIX, "omit"};

        public TarLongFileMode() {
            setValue("warn");
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return this.b;
        }

        public boolean isFailMode() {
            return "fail".equalsIgnoreCase(getValue());
        }

        public boolean isGnuMode() {
            return "gnu".equalsIgnoreCase(getValue());
        }

        public boolean isOmitMode() {
            return "omit".equalsIgnoreCase(getValue());
        }

        public boolean isPosixMode() {
            return POSIX.equalsIgnoreCase(getValue());
        }

        public boolean isTruncateMode() {
            return "truncate".equalsIgnoreCase(getValue());
        }

        public boolean isWarnMode() {
            return "warn".equalsIgnoreCase(getValue());
        }
    }

    public static java.lang.String[] getFileNames(org.apache.tools.ant.types.FileSet fileSet) {
        org.apache.tools.ant.DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(fileSet.getProject());
        java.lang.String[] includedDirectories = directoryScanner.getIncludedDirectories();
        java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
        java.lang.String[] strArr = new java.lang.String[includedDirectories.length + includedFiles.length];
        java.lang.System.arraycopy(includedDirectories, 0, strArr, 0, includedDirectories.length);
        java.lang.System.arraycopy(includedFiles, 0, strArr, includedDirectories.length, includedFiles.length);
        return strArr;
    }

    public static boolean isFileFileSet(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        return (resourceCollection instanceof org.apache.tools.ant.types.FileSet) && resourceCollection.isFilesystemOnly();
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.y.add(resourceCollection);
    }

    public boolean archiveIsUpToDate(org.apache.tools.ant.types.Resource resource) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.isOutOfDate(new org.apache.tools.ant.types.resources.FileResource(this.u), resource, org.apache.tools.ant.util.FileUtils.getFileUtils().getFileTimestampGranularity());
    }

    @java.lang.Deprecated
    public boolean archiveIsUpToDate(java.lang.String[] strArr) {
        return archiveIsUpToDate(strArr, this.v);
    }

    public boolean archiveIsUpToDate(java.lang.String[] strArr, java.io.File file) {
        org.apache.tools.ant.util.SourceFileScanner sourceFileScanner = new org.apache.tools.ant.util.SourceFileScanner(this);
        org.apache.tools.ant.util.MergingMapper mergingMapper = new org.apache.tools.ant.util.MergingMapper();
        mergingMapper.setTo(this.u.getAbsolutePath());
        return sourceFileScanner.restrict(strArr, file, null, mergingMapper).length == 0;
    }

    public org.apache.tools.ant.taskdefs.Tar.TarFileSet asTarFileSet(org.apache.tools.ant.types.ArchiveFileSet archiveFileSet) {
        if (archiveFileSet != null && (archiveFileSet instanceof org.apache.tools.ant.taskdefs.Tar.TarFileSet)) {
            return (org.apache.tools.ant.taskdefs.Tar.TarFileSet) archiveFileSet;
        }
        org.apache.tools.ant.taskdefs.Tar.TarFileSet tarFileSet = new org.apache.tools.ant.taskdefs.Tar.TarFileSet();
        tarFileSet.setProject(getProject());
        if (archiveFileSet != null) {
            tarFileSet.setPrefix(archiveFileSet.getPrefix(getProject()));
            tarFileSet.setFullpath(archiveFileSet.getFullpath(getProject()));
            if (archiveFileSet.hasFileModeBeenSet()) {
                tarFileSet.integerSetFileMode(archiveFileSet.getFileMode(getProject()));
            }
            if (archiveFileSet.hasDirModeBeenSet()) {
                tarFileSet.integerSetDirMode(archiveFileSet.getDirMode(getProject()));
            }
            if (archiveFileSet instanceof org.apache.tools.ant.types.TarFileSet) {
                org.apache.tools.ant.types.TarFileSet tarFileSet2 = (org.apache.tools.ant.types.TarFileSet) archiveFileSet;
                if (tarFileSet2.hasUserNameBeenSet()) {
                    tarFileSet.setUserName(tarFileSet2.getUserName());
                }
                if (tarFileSet2.hasGroupBeenSet()) {
                    tarFileSet.setGroup(tarFileSet2.getGroup());
                }
                if (tarFileSet2.hasUserIdBeenSet()) {
                    tarFileSet.setUid(tarFileSet2.getUid());
                }
                if (tarFileSet2.hasGroupIdBeenSet()) {
                    tarFileSet.setGid(tarFileSet2.getGid());
                }
            }
        }
        return tarFileSet;
    }

    public boolean check(java.io.File file, java.util.Collection<java.lang.String> collection) {
        return check(file, (java.lang.String[]) collection.toArray(new java.lang.String[collection.size()]));
    }

    public boolean check(java.io.File file, java.lang.String[] strArr) {
        boolean archiveIsUpToDate = archiveIsUpToDate(strArr, file);
        for (java.lang.String str : strArr) {
            if (this.u.equals(new java.io.File(file, str))) {
                throw new org.apache.tools.ant.BuildException("A tar file cannot include itself", getLocation());
            }
        }
        return archiveIsUpToDate;
    }

    public boolean check(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (isFileFileSet(resourceCollection)) {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) resourceCollection;
            return check(fileSet.getDir(getProject()), getFileNames(fileSet));
        }
        if (!resourceCollection.isFilesystemOnly() && !supportsNonFileResources()) {
            throw new org.apache.tools.ant.BuildException("only filesystem resources are supported");
        }
        boolean z = true;
        if (resourceCollection.isFilesystemOnly()) {
            java.util.HashSet<java.io.File> hashSet = new java.util.HashSet();
            java.util.HashMap hashMap = new java.util.HashMap();
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = resourceCollection.iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.types.resources.FileResource asFileResource = org.apache.tools.ant.util.ResourceUtils.asFileResource((org.apache.tools.ant.types.resources.FileProvider) it.next().as(org.apache.tools.ant.types.resources.FileProvider.class));
                java.io.File baseDir = asFileResource.getBaseDir();
                if (baseDir == null) {
                    baseDir = org.apache.tools.ant.taskdefs.Copy.D;
                }
                hashSet.add(baseDir);
                java.util.List list = (java.util.List) hashMap.get(baseDir);
                if (list == null) {
                    list = new java.util.Vector();
                    hashMap.put(baseDir, list);
                }
                if (baseDir == org.apache.tools.ant.taskdefs.Copy.D) {
                    list.add(asFileResource.getFile().getAbsolutePath());
                } else {
                    list.add(asFileResource.getName());
                }
            }
            for (java.io.File file : hashSet) {
                z &= check(file == org.apache.tools.ant.taskdefs.Copy.D ? null : file, (java.util.List) hashMap.get(file));
            }
        } else {
            java.util.Iterator<org.apache.tools.ant.types.Resource> it2 = resourceCollection.iterator();
            while (z && it2.hasNext()) {
                z = archiveIsUpToDate(it2.next());
            }
        }
        return z;
    }

    public org.apache.tools.ant.taskdefs.Tar.TarFileSet createTarFileSet() {
        org.apache.tools.ant.taskdefs.Tar.TarFileSet tarFileSet = new org.apache.tools.ant.taskdefs.Tar.TarFileSet();
        tarFileSet.setProject(getProject());
        this.x.addElement(tarFileSet);
        return tarFileSet;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.tar.TarOutputStream tarOutputStream;
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("tarfile attribute must be set!", getLocation());
        }
        if (file.exists() && this.u.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("tarfile is a directory!", getLocation());
        }
        if (this.u.exists() && !this.u.canWrite()) {
            throw new org.apache.tools.ant.BuildException("Can not write to the specified tarfile!", getLocation());
        }
        java.util.Vector<org.apache.tools.ant.taskdefs.Tar.TarFileSet> vector = (java.util.Vector) this.x.clone();
        try {
            java.io.File file2 = this.v;
            if (file2 != null) {
                if (!file2.exists()) {
                    throw new org.apache.tools.ant.BuildException("basedir does not exist!", getLocation());
                }
                org.apache.tools.ant.taskdefs.Tar.TarFileSet tarFileSet = new org.apache.tools.ant.taskdefs.Tar.TarFileSet(this.fileset);
                tarFileSet.setDir(this.v);
                this.x.addElement(tarFileSet);
            }
            if (this.x.size() == 0 && this.y.size() == 0) {
                throw new org.apache.tools.ant.BuildException("You must supply either a basedir attribute or some nested resource collections.", getLocation());
            }
            java.util.Iterator<org.apache.tools.ant.taskdefs.Tar.TarFileSet> it = this.x.iterator();
            boolean z = true;
            while (it.hasNext()) {
                z &= check(it.next());
            }
            java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> it2 = this.y.iterator();
            while (it2.hasNext()) {
                z &= check(it2.next());
            }
            if (z) {
                log("Nothing to do: " + this.u.getAbsolutePath() + " is up to date.", 2);
                return;
            }
            java.io.File parentFile = this.u.getParentFile();
            if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new org.apache.tools.ant.BuildException("Failed to create missing parent directory for " + this.u);
            }
            log("Building tar: " + this.u.getAbsolutePath(), 2);
            org.apache.tools.tar.TarOutputStream tarOutputStream2 = null;
            try {
                try {
                    tarOutputStream = new org.apache.tools.tar.TarOutputStream(this.A.b(new java.io.BufferedOutputStream(new java.io.FileOutputStream(this.u))), this.B);
                } catch (java.io.IOException e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                tarOutputStream.setDebug(true);
                if (this.w.isTruncateMode()) {
                    tarOutputStream.setLongFileMode(1);
                } else {
                    if (!this.w.isFailMode() && !this.w.isOmitMode()) {
                        if (this.w.isPosixMode()) {
                            tarOutputStream.setLongFileMode(3);
                        } else {
                            tarOutputStream.setLongFileMode(2);
                        }
                    }
                    tarOutputStream.setLongFileMode(0);
                }
                this.z = false;
                java.util.Iterator<org.apache.tools.ant.taskdefs.Tar.TarFileSet> it3 = this.x.iterator();
                while (it3.hasNext()) {
                    tar(it3.next(), tarOutputStream);
                }
                java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> it4 = this.y.iterator();
                while (it4.hasNext()) {
                    tar(it4.next(), tarOutputStream);
                }
                org.apache.tools.ant.util.FileUtils.close(tarOutputStream);
            } catch (java.io.IOException e2) {
                e = e2;
                tarOutputStream2 = tarOutputStream;
                throw new org.apache.tools.ant.BuildException("Problem creating TAR: " + e.getMessage(), e, getLocation());
            } catch (java.lang.Throwable th2) {
                th = th2;
                tarOutputStream2 = tarOutputStream;
                org.apache.tools.ant.util.FileUtils.close(tarOutputStream2);
                throw th;
            }
        } finally {
            this.x = vector;
        }
    }

    public void setBasedir(java.io.File file) {
        this.v = file;
    }

    public void setCompression(org.apache.tools.ant.taskdefs.Tar.TarCompressionMethod tarCompressionMethod) {
        this.A = tarCompressionMethod;
    }

    public void setDestFile(java.io.File file) {
        this.u = file;
    }

    public void setEncoding(java.lang.String str) {
        this.B = str;
    }

    @java.lang.Deprecated
    public void setLongfile(java.lang.String str) {
        log("DEPRECATED - The setLongfile(String) method has been deprecated. Use setLongfile(Tar.TarLongFileMode) instead.");
        org.apache.tools.ant.taskdefs.Tar.TarLongFileMode tarLongFileMode = new org.apache.tools.ant.taskdefs.Tar.TarLongFileMode();
        this.w = tarLongFileMode;
        tarLongFileMode.setValue(str);
    }

    public void setLongfile(org.apache.tools.ant.taskdefs.Tar.TarLongFileMode tarLongFileMode) {
        this.w = tarLongFileMode;
    }

    @java.lang.Deprecated
    public void setTarfile(java.io.File file) {
        this.u = file;
    }

    public boolean supportsNonFileResources() {
        return getClass().equals(org.apache.tools.ant.taskdefs.Tar.class);
    }

    public void tar(org.apache.tools.ant.types.ResourceCollection resourceCollection, org.apache.tools.tar.TarOutputStream tarOutputStream) throws java.io.IOException {
        org.apache.tools.ant.types.ArchiveFileSet archiveFileSet = resourceCollection instanceof org.apache.tools.ant.types.ArchiveFileSet ? (org.apache.tools.ant.types.ArchiveFileSet) resourceCollection : null;
        if (archiveFileSet != null && archiveFileSet.size() > 1 && archiveFileSet.getFullpath(getProject()).length() > 0) {
            throw new org.apache.tools.ant.BuildException("fullpath attribute may only be specified for filesets that specify a single file.");
        }
        org.apache.tools.ant.taskdefs.Tar.TarFileSet asTarFileSet = asTarFileSet(archiveFileSet);
        if (isFileFileSet(resourceCollection)) {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) resourceCollection;
            java.lang.String[] fileNames = getFileNames(fileSet);
            for (int i = 0; i < fileNames.length; i++) {
                tarFile(new java.io.File(fileSet.getDir(getProject()), fileNames[i]), tarOutputStream, fileNames[i].replace(java.io.File.separatorChar, '/'), asTarFileSet);
            }
            return;
        }
        if (resourceCollection.isFilesystemOnly()) {
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = resourceCollection.iterator();
            while (it.hasNext()) {
                java.io.File file = ((org.apache.tools.ant.types.resources.FileProvider) it.next().as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile();
                tarFile(file, tarOutputStream, file.getName(), asTarFileSet);
            }
            return;
        }
        for (org.apache.tools.ant.types.Resource resource : resourceCollection) {
            tarResource(resource, tarOutputStream, resource.getName(), asTarFileSet);
        }
    }

    public void tarFile(java.io.File file, org.apache.tools.tar.TarOutputStream tarOutputStream, java.lang.String str, org.apache.tools.ant.taskdefs.Tar.TarFileSet tarFileSet) throws java.io.IOException {
        if (file.equals(this.u)) {
            return;
        }
        tarResource(new org.apache.tools.ant.types.resources.FileResource(file), tarOutputStream, str, tarFileSet);
    }

    public void tarResource(org.apache.tools.ant.types.Resource resource, org.apache.tools.tar.TarOutputStream tarOutputStream, java.lang.String str, org.apache.tools.ant.taskdefs.Tar.TarFileSet tarFileSet) throws java.io.IOException {
        boolean z;
        if (resource.isExists()) {
            if (tarFileSet != null) {
                java.lang.String fullpath = tarFileSet.getFullpath(getProject());
                if (fullpath.length() > 0) {
                    str = fullpath;
                } else {
                    if (str.length() <= 0) {
                        return;
                    }
                    java.lang.String prefix = tarFileSet.getPrefix(getProject());
                    if (prefix.length() > 0 && !prefix.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                        prefix = prefix + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
                    }
                    str = prefix + str;
                }
                z = tarFileSet.getPreserveLeadingSlashes();
                if (str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) && !z) {
                    int length = str.length();
                    if (length <= 1) {
                        return;
                    } else {
                        str = str.substring(1, length);
                    }
                }
            } else {
                z = false;
            }
            if (resource.isDirectory() && !str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                str = str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            }
            if (str.length() >= 100) {
                if (this.w.isOmitMode()) {
                    log("Omitting: " + str, 2);
                    return;
                }
                if (this.w.isWarnMode()) {
                    log("Entry: " + str + " longer than 100 characters.", 1);
                    if (!this.z) {
                        log("Resulting tar file can only be processed successfully by GNU compatible tar commands", 1);
                        this.z = true;
                    }
                } else if (this.w.isFailMode()) {
                    throw new org.apache.tools.ant.BuildException("Entry: " + str + " longer than 100characters.", getLocation());
                }
            }
            org.apache.tools.tar.TarEntry tarEntry = new org.apache.tools.tar.TarEntry(str, z);
            tarEntry.setModTime(resource.getLastModified());
            if (resource instanceof org.apache.tools.ant.types.resources.ArchiveResource) {
                tarEntry.setMode(((org.apache.tools.ant.types.resources.ArchiveResource) resource).getMode());
                if (resource instanceof org.apache.tools.ant.types.resources.TarResource) {
                    org.apache.tools.ant.types.resources.TarResource tarResource = (org.apache.tools.ant.types.resources.TarResource) resource;
                    tarEntry.setUserName(tarResource.getUserName());
                    tarEntry.setUserId(tarResource.getUid());
                    tarEntry.setGroupName(tarResource.getGroup());
                    tarEntry.setGroupId(tarResource.getGid());
                }
            }
            if (resource.isDirectory()) {
                if (tarFileSet != null && tarFileSet.hasDirModeBeenSet()) {
                    tarEntry.setMode(tarFileSet.getDirMode(getProject()));
                }
            } else {
                if (resource.size() > org.apache.tools.tar.TarConstants.MAXSIZE) {
                    throw new org.apache.tools.ant.BuildException("Resource: " + resource + " larger than " + org.apache.tools.tar.TarConstants.MAXSIZE + " bytes.");
                }
                tarEntry.setSize(resource.getSize());
                if (tarFileSet != null && tarFileSet.hasFileModeBeenSet()) {
                    tarEntry.setMode(tarFileSet.getMode());
                }
            }
            if (tarFileSet != null) {
                if (tarFileSet.hasUserNameBeenSet()) {
                    tarEntry.setUserName(tarFileSet.getUserName());
                }
                if (tarFileSet.hasGroupBeenSet()) {
                    tarEntry.setGroupName(tarFileSet.getGroup());
                }
                if (tarFileSet.hasUserIdBeenSet()) {
                    tarEntry.setUserId(tarFileSet.getUid());
                }
                if (tarFileSet.hasGroupIdBeenSet()) {
                    tarEntry.setGroupId(tarFileSet.getGid());
                }
            }
            java.io.InputStream inputStream = null;
            try {
                tarOutputStream.putNextEntry(tarEntry);
                if (!resource.isDirectory()) {
                    inputStream = resource.getInputStream();
                    byte[] bArr = new byte[8192];
                    int i = 0;
                    do {
                        tarOutputStream.write(bArr, 0, i);
                        i = inputStream.read(bArr, 0, 8192);
                    } while (i != -1);
                }
                tarOutputStream.closeEntry();
            } finally {
                org.apache.tools.ant.util.FileUtils.close(inputStream);
            }
        }
    }
}
