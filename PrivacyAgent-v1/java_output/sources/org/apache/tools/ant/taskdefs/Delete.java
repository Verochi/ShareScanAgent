package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Delete extends org.apache.tools.ant.taskdefs.MatchingTask {
    public static final org.apache.tools.ant.types.resources.comparators.ResourceComparator B = new org.apache.tools.ant.types.resources.comparators.Reverse(new org.apache.tools.ant.types.resources.comparators.FileSystem());
    public static final org.apache.tools.ant.types.resources.selectors.ResourceSelector C = new org.apache.tools.ant.types.resources.selectors.Exists();
    public static org.apache.tools.ant.util.FileUtils D = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static org.apache.tools.ant.util.SymbolicLinkUtils E = org.apache.tools.ant.util.SymbolicLinkUtils.getSymbolicLinkUtils();
    protected java.io.File file = null;
    protected java.io.File dir = null;
    protected java.util.Vector<org.apache.tools.ant.types.FileSet> filesets = new java.util.Vector<>();
    protected boolean usedMatchingTask = false;
    protected boolean includeEmpty = false;
    public int u = 3;
    public boolean v = false;
    public boolean w = true;
    public boolean x = false;
    public boolean y = false;
    public org.apache.tools.ant.types.resources.Resources z = null;
    public boolean A = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS);

    /* renamed from: org.apache.tools.ant.taskdefs.Delete$1, reason: invalid class name */
    public class AnonymousClass1 implements org.apache.tools.ant.types.ResourceCollection {
        public final /* synthetic */ java.lang.String[] n;
        public final /* synthetic */ java.io.File t;

        public AnonymousClass1(java.lang.String[] strArr, java.io.File file) {
            this.n = strArr;
            this.t = file;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public boolean isFilesystemOnly() {
            return true;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
        public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
            return new org.apache.tools.ant.types.resources.FileResourceIterator(org.apache.tools.ant.taskdefs.Delete.this.getProject(), this.t, this.n);
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public int size() {
            return this.n.length;
        }
    }

    public static class ReverseDirs implements org.apache.tools.ant.types.ResourceCollection {
        public static final java.util.Comparator<java.lang.Comparable<?>> v = new org.apache.tools.ant.taskdefs.Delete.ReverseDirs.AnonymousClass1();
        public org.apache.tools.ant.Project n;
        public java.io.File t;
        public java.lang.String[] u;

        /* renamed from: org.apache.tools.ant.taskdefs.Delete$ReverseDirs$1, reason: invalid class name */
        public static class AnonymousClass1 implements java.util.Comparator<java.lang.Comparable<?>> {
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(java.lang.Comparable<?> comparable, java.lang.Comparable<?> comparable2) {
                return comparable.compareTo(comparable2) * (-1);
            }
        }

        public ReverseDirs(org.apache.tools.ant.Project project, java.io.File file, java.lang.String[] strArr) {
            this.n = project;
            this.t = file;
            this.u = strArr;
            java.util.Arrays.sort(strArr, v);
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public boolean isFilesystemOnly() {
            return true;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
        public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
            return new org.apache.tools.ant.types.resources.FileResourceIterator(this.n, this.t, this.u);
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public int size() {
            return this.u.length;
        }
    }

    private boolean delete(java.io.File file) {
        if (D.tryHardToDelete(file, this.A)) {
            return true;
        }
        if (!this.x) {
            return false;
        }
        log("Failed to delete " + file + ", calling deleteOnExit. This attempts to delete the file when the Ant jvm has exited and might not succeed.", this.v ? 3 : 2);
        file.deleteOnExit();
        return true;
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection == null) {
            return;
        }
        if (this.z == null) {
            org.apache.tools.ant.types.resources.Resources resources = new org.apache.tools.ant.types.resources.Resources();
            this.z = resources;
            resources.setCache(true);
        }
        this.z.add(resourceCollection);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void add(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        this.usedMatchingTask = true;
        super.add(fileSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addAnd(org.apache.tools.ant.types.selectors.AndSelector andSelector) {
        this.usedMatchingTask = true;
        super.addAnd(andSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addContains(org.apache.tools.ant.types.selectors.ContainsSelector containsSelector) {
        this.usedMatchingTask = true;
        super.addContains(containsSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addContainsRegexp(org.apache.tools.ant.types.selectors.ContainsRegexpSelector containsRegexpSelector) {
        this.usedMatchingTask = true;
        super.addContainsRegexp(containsRegexpSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addCustom(org.apache.tools.ant.types.selectors.ExtendSelector extendSelector) {
        this.usedMatchingTask = true;
        super.addCustom(extendSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDate(org.apache.tools.ant.types.selectors.DateSelector dateSelector) {
        this.usedMatchingTask = true;
        super.addDate(dateSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDepend(org.apache.tools.ant.types.selectors.DependSelector dependSelector) {
        this.usedMatchingTask = true;
        super.addDepend(dependSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDepth(org.apache.tools.ant.types.selectors.DepthSelector depthSelector) {
        this.usedMatchingTask = true;
        super.addDepth(depthSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addFilename(org.apache.tools.ant.types.selectors.FilenameSelector filenameSelector) {
        this.usedMatchingTask = true;
        super.addFilename(filenameSelector);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.filesets.addElement(fileSet);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addMajority(org.apache.tools.ant.types.selectors.MajoritySelector majoritySelector) {
        this.usedMatchingTask = true;
        super.addMajority(majoritySelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addModified(org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector modifiedSelector) {
        this.usedMatchingTask = true;
        super.addModified(modifiedSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addNone(org.apache.tools.ant.types.selectors.NoneSelector noneSelector) {
        this.usedMatchingTask = true;
        super.addNone(noneSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addNot(org.apache.tools.ant.types.selectors.NotSelector notSelector) {
        this.usedMatchingTask = true;
        super.addNot(notSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addOr(org.apache.tools.ant.types.selectors.OrSelector orSelector) {
        this.usedMatchingTask = true;
        super.addOr(orSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addPresent(org.apache.tools.ant.types.selectors.PresentSelector presentSelector) {
        this.usedMatchingTask = true;
        super.addPresent(presentSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addSelector(org.apache.tools.ant.types.selectors.SelectSelector selectSelector) {
        this.usedMatchingTask = true;
        super.addSelector(selectSelector);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask, org.apache.tools.ant.types.selectors.SelectorContainer
    public void addSize(org.apache.tools.ant.types.selectors.SizeSelector sizeSelector) {
        this.usedMatchingTask = true;
        super.addSize(sizeSelector);
    }

    public final void c(java.lang.Exception exc) {
        if (!this.w) {
            log(exc, this.v ? 3 : this.u);
        } else if (!(exc instanceof org.apache.tools.ant.BuildException)) {
            throw new org.apache.tools.ant.BuildException(exc);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public org.apache.tools.ant.types.PatternSet.NameEntry createExclude() {
        this.usedMatchingTask = true;
        return super.createExclude();
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public org.apache.tools.ant.types.PatternSet.NameEntry createExcludesFile() {
        this.usedMatchingTask = true;
        return super.createExcludesFile();
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public org.apache.tools.ant.types.PatternSet.NameEntry createInclude() {
        this.usedMatchingTask = true;
        return super.createInclude();
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public org.apache.tools.ant.types.PatternSet.NameEntry createIncludesFile() {
        this.usedMatchingTask = true;
        return super.createIncludesFile();
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public org.apache.tools.ant.types.PatternSet createPatternSet() {
        this.usedMatchingTask = true;
        return super.createPatternSet();
    }

    public final void d(java.lang.String str) {
        c(new org.apache.tools.ant.BuildException(str));
    }

    public final boolean e(java.io.File file) {
        try {
            return E.isDanglingSymbolicLink(file);
        } catch (java.io.IOException e) {
            log("Error while trying to detect " + file.getAbsolutePath() + " as broken symbolic link. " + e.getMessage(), this.v ? 3 : this.u);
            return false;
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.FileSet fileSet;
        java.io.File file;
        if (this.usedMatchingTask) {
            log("DEPRECATED - Use of the implicit FileSet is deprecated.  Use a nested fileset element instead.", this.v ? 3 : this.u);
        }
        if (this.file == null && this.dir == null && this.filesets.size() == 0 && this.z == null) {
            throw new org.apache.tools.ant.BuildException("At least one of the file or dir attributes, or a nested resource collection, must be set.");
        }
        if (this.v && this.w) {
            throw new org.apache.tools.ant.BuildException("quiet and failonerror cannot both be set to true", getLocation());
        }
        java.io.File file2 = this.file;
        if (file2 != null) {
            if (file2.exists()) {
                if (this.file.isDirectory()) {
                    log("Directory " + this.file.getAbsolutePath() + " cannot be removed using the file attribute.  Use dir instead.", this.v ? 3 : this.u);
                } else {
                    log("Deleting: " + this.file.getAbsolutePath());
                    if (!delete(this.file)) {
                        d("Unable to delete file " + this.file.getAbsolutePath());
                    }
                }
            } else if (e(this.file)) {
                log("Trying to delete file " + this.file.getAbsolutePath() + " which looks like a broken symlink.", this.v ? 3 : this.u);
                if (!delete(this.file)) {
                    d("Unable to delete file " + this.file.getAbsolutePath());
                }
            } else {
                log("Could not find file " + this.file.getAbsolutePath() + " to delete.", this.v ? 3 : this.u);
            }
        }
        java.io.File file3 = this.dir;
        if (file3 != null && !this.usedMatchingTask) {
            if (file3.exists() && this.dir.isDirectory()) {
                if (this.u == 3) {
                    log("Deleting directory " + this.dir.getAbsolutePath());
                }
                removeDir(this.dir);
            } else if (e(this.dir)) {
                log("Trying to delete directory " + this.dir.getAbsolutePath() + " which looks like a broken symlink.", this.v ? 3 : this.u);
                if (!delete(this.dir)) {
                    d("Unable to delete directory " + this.dir.getAbsolutePath());
                }
            }
        }
        org.apache.tools.ant.types.resources.Resources resources = new org.apache.tools.ant.types.resources.Resources();
        resources.setProject(getProject());
        resources.setCache(true);
        org.apache.tools.ant.types.resources.Resources resources2 = new org.apache.tools.ant.types.resources.Resources();
        resources2.setProject(getProject());
        resources2.setCache(true);
        if (this.usedMatchingTask && (file = this.dir) != null && file.isDirectory()) {
            fileSet = getImplicitFileSet();
            fileSet.setProject(getProject());
            this.filesets.add(fileSet);
        } else {
            fileSet = null;
        }
        this.filesets.size();
        java.util.Iterator<org.apache.tools.ant.types.FileSet> it = this.filesets.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.FileSet next = it.next();
            if (next.getProject() == null) {
                log("Deleting fileset with no project specified; assuming executing project", 3);
                next = (org.apache.tools.ant.types.FileSet) next.clone();
                next.setProject(getProject());
            }
            java.io.File dir = next.getDir();
            if (next.getErrorOnMissingDir() || (dir != null && dir.exists())) {
                if (dir == null) {
                    throw new org.apache.tools.ant.BuildException("File or Resource without directory or file specified");
                }
                if (dir.isDirectory()) {
                    org.apache.tools.ant.DirectoryScanner directoryScanner = next.getDirectoryScanner();
                    resources.add(new org.apache.tools.ant.taskdefs.Delete.AnonymousClass1(directoryScanner.getIncludedFiles(), dir));
                    if (this.includeEmpty) {
                        resources2.add(new org.apache.tools.ant.taskdefs.Delete.ReverseDirs(getProject(), dir, directoryScanner.getIncludedDirectories()));
                    }
                    if (this.y) {
                        java.lang.String[] notFollowedSymlinks = directoryScanner.getNotFollowedSymlinks();
                        if (notFollowedSymlinks.length > 0) {
                            int length = notFollowedSymlinks.length;
                            java.lang.String[] strArr = new java.lang.String[length];
                            java.lang.System.arraycopy(notFollowedSymlinks, 0, strArr, 0, notFollowedSymlinks.length);
                            java.util.Arrays.sort(strArr, org.apache.tools.ant.taskdefs.Delete.ReverseDirs.v);
                            for (int i = 0; i < length; i++) {
                                try {
                                    E.deleteSymbolicLink(new java.io.File(strArr[i]), this);
                                } catch (java.io.IOException e) {
                                    c(e);
                                }
                            }
                        }
                    }
                } else {
                    d("Directory does not exist: " + dir);
                }
            }
        }
        resources.add(resources2);
        if (this.z != null) {
            org.apache.tools.ant.types.resources.Restrict restrict = new org.apache.tools.ant.types.resources.Restrict();
            restrict.add(C);
            restrict.add(this.z);
            org.apache.tools.ant.types.resources.Sort sort = new org.apache.tools.ant.types.resources.Sort();
            sort.add(B);
            sort.add(restrict);
            resources.add(sort);
        }
        try {
            try {
                if (resources.isFilesystemOnly()) {
                    java.util.Iterator<org.apache.tools.ant.types.Resource> it2 = resources.iterator();
                    while (it2.hasNext()) {
                        java.io.File file4 = ((org.apache.tools.ant.types.resources.FileProvider) it2.next().as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile();
                        if (file4.exists() && (!file4.isDirectory() || file4.list().length == 0)) {
                            log("Deleting " + file4, this.u);
                            if (!delete(file4) && this.w) {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append("Unable to delete ");
                                sb.append(file4.isDirectory() ? "directory " : "file ");
                                sb.append(file4);
                                d(sb.toString());
                            }
                        }
                    }
                } else {
                    d(getTaskName() + " handles only filesystem resources");
                }
                if (fileSet == null) {
                    return;
                }
            } catch (java.lang.Exception e2) {
                c(e2);
                if (fileSet == null) {
                    return;
                }
            }
            this.filesets.remove(fileSet);
        } catch (java.lang.Throwable th) {
            if (fileSet != null) {
                this.filesets.remove(fileSet);
            }
            throw th;
        }
    }

    public void removeDir(java.io.File file) {
        java.lang.String[] list = file.list();
        if (list == null) {
            list = new java.lang.String[0];
        }
        for (java.lang.String str : list) {
            java.io.File file2 = new java.io.File(file, str);
            if (file2.isDirectory()) {
                removeDir(file2);
            } else {
                log("Deleting " + file2.getAbsolutePath(), this.v ? 3 : this.u);
                if (!delete(file2)) {
                    d("Unable to delete file " + file2.getAbsolutePath());
                }
            }
        }
        log("Deleting directory " + file.getAbsolutePath(), this.u);
        if (delete(file)) {
            return;
        }
        d("Unable to delete directory " + file.getAbsolutePath());
    }

    public void removeFiles(java.io.File file, java.lang.String[] strArr, java.lang.String[] strArr2) {
        int i = 0;
        if (strArr.length > 0) {
            log("Deleting " + strArr.length + " files from " + file.getAbsolutePath(), this.v ? 3 : this.u);
            for (java.lang.String str : strArr) {
                java.io.File file2 = new java.io.File(file, str);
                log("Deleting " + file2.getAbsolutePath(), this.v ? 3 : this.u);
                if (!delete(file2)) {
                    d("Unable to delete file " + file2.getAbsolutePath());
                }
            }
        }
        if (strArr2.length <= 0 || !this.includeEmpty) {
            return;
        }
        for (int length = strArr2.length - 1; length >= 0; length--) {
            java.io.File file3 = new java.io.File(file, strArr2[length]);
            java.lang.String[] list = file3.list();
            if (list == null || list.length == 0) {
                log("Deleting " + file3.getAbsolutePath(), this.v ? 3 : this.u);
                if (delete(file3)) {
                    i++;
                } else {
                    d("Unable to delete directory " + file3.getAbsolutePath());
                }
            }
        }
        if (i > 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Deleted ");
            sb.append(i);
            sb.append(" director");
            sb.append(i == 1 ? "y" : "ies");
            sb.append(" form ");
            sb.append(file.getAbsolutePath());
            log(sb.toString(), this.v ? 3 : this.u);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public void setCaseSensitive(boolean z) {
        this.usedMatchingTask = true;
        super.setCaseSensitive(z);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public void setDefaultexcludes(boolean z) {
        this.usedMatchingTask = true;
        super.setDefaultexcludes(z);
    }

    public void setDeleteOnExit(boolean z) {
        this.x = z;
    }

    public void setDir(java.io.File file) {
        this.dir = file;
        getImplicitFileSet().setDir(file);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public void setExcludes(java.lang.String str) {
        this.usedMatchingTask = true;
        super.setExcludes(str);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public void setExcludesfile(java.io.File file) {
        this.usedMatchingTask = true;
        super.setExcludesfile(file);
    }

    public void setFailOnError(boolean z) {
        this.w = z;
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public void setFollowSymlinks(boolean z) {
        this.usedMatchingTask = true;
        super.setFollowSymlinks(z);
    }

    public void setIncludeEmptyDirs(boolean z) {
        this.includeEmpty = z;
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public void setIncludes(java.lang.String str) {
        this.usedMatchingTask = true;
        super.setIncludes(str);
    }

    @Override // org.apache.tools.ant.taskdefs.MatchingTask
    public void setIncludesfile(java.io.File file) {
        this.usedMatchingTask = true;
        super.setIncludesfile(file);
    }

    public void setPerformGcOnFailedDelete(boolean z) {
        this.A = z;
    }

    public void setQuiet(boolean z) {
        this.v = z;
        if (z) {
            this.w = false;
        }
    }

    public void setRemoveNotFollowedSymlinks(boolean z) {
        this.y = z;
    }

    public void setVerbose(boolean z) {
        if (z) {
            this.u = 2;
        } else {
            this.u = 3;
        }
    }
}
