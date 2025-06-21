package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Sync extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.taskdefs.Sync.MyCopy u;
    public org.apache.tools.ant.taskdefs.Sync.SyncTarget v;
    public org.apache.tools.ant.types.resources.Resources w = null;

    public static class MyCopy extends org.apache.tools.ant.taskdefs.Copy {
        public java.util.Set F = new java.util.HashSet();

        public boolean getIncludeEmptyDirs() {
            return this.includeEmpty;
        }

        public java.io.File getToDir() {
            return this.destDir;
        }

        @Override // org.apache.tools.ant.taskdefs.Copy
        public java.util.Map scan(org.apache.tools.ant.types.Resource[] resourceArr, java.io.File file) {
            org.apache.tools.ant.taskdefs.Sync.d("No mapper", this.mapperElement == null);
            for (org.apache.tools.ant.types.Resource resource : resourceArr) {
                this.F.add(resource.getName());
            }
            return super.scan(resourceArr, file);
        }

        @Override // org.apache.tools.ant.taskdefs.Copy
        public void scan(java.io.File file, java.io.File file2, java.lang.String[] strArr, java.lang.String[] strArr2) {
            org.apache.tools.ant.taskdefs.Sync.d("No mapper", this.mapperElement == null);
            super.scan(file, file2, strArr, strArr2);
            for (java.lang.String str : strArr) {
                this.F.add(str);
            }
            for (java.lang.String str2 : strArr2) {
                this.F.add(str2);
            }
        }

        @Override // org.apache.tools.ant.taskdefs.Copy
        public boolean supportsNonFileResources() {
            return true;
        }
    }

    public static class SyncTarget extends org.apache.tools.ant.types.AbstractFileSet {
        public java.lang.Boolean D;

        public final org.apache.tools.ant.types.FileSet d(boolean z) {
            org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
            fileSet.setCaseSensitive(isCaseSensitive());
            fileSet.setFollowSymlinks(isFollowSymlinks());
            fileSet.setMaxLevelsOfSymlinks(getMaxLevelsOfSymlinks());
            fileSet.setProject(getProject());
            if (z) {
                org.apache.tools.ant.types.PatternSet mergePatterns = mergePatterns(getProject());
                fileSet.appendIncludes(mergePatterns.getIncludePatterns(getProject()));
                fileSet.appendExcludes(mergePatterns.getExcludePatterns(getProject()));
                java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements = selectorElements();
                while (selectorElements.hasMoreElements()) {
                    fileSet.appendSelector(selectorElements.nextElement());
                }
                fileSet.setDefaultexcludes(getDefaultexcludes());
            }
            return fileSet;
        }

        public java.lang.Boolean getPreserveEmptyDirs() {
            return this.D;
        }

        @Override // org.apache.tools.ant.types.AbstractFileSet
        public void setDir(java.io.File file) throws org.apache.tools.ant.BuildException {
            throw new org.apache.tools.ant.BuildException("preserveintarget doesn't support the dir attribute");
        }

        public void setPreserveEmptyDirs(boolean z) {
            this.D = java.lang.Boolean.valueOf(z);
        }
    }

    public static void d(java.lang.String str, boolean z) {
        if (z) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Assertion Error: " + str);
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if ((resourceCollection instanceof org.apache.tools.ant.types.FileSet) && resourceCollection.isFilesystemOnly()) {
            this.u.add(resourceCollection);
            return;
        }
        if (this.w == null) {
            org.apache.tools.ant.types.resources.Restrict restrict = new org.apache.tools.ant.types.resources.Restrict();
            restrict.add(new org.apache.tools.ant.types.resources.selectors.Exists());
            org.apache.tools.ant.types.resources.Resources resources = new org.apache.tools.ant.types.resources.Resources();
            this.w = resources;
            restrict.add(resources);
            this.u.add(restrict);
        }
        this.w.add(resourceCollection);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        add(fileSet);
    }

    public void addPreserveInTarget(org.apache.tools.ant.taskdefs.Sync.SyncTarget syncTarget) {
        if (this.v != null) {
            throw new org.apache.tools.ant.BuildException("you must not specify multiple preserveintarget elements.");
        }
        this.v = syncTarget;
    }

    public final void e(org.apache.tools.ant.Task task) {
        task.setProject(getProject());
        task.setTaskName(getTaskName());
        task.setOwningTarget(getOwningTarget());
        task.init();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File toDir = this.u.getToDir();
        java.util.Set set = this.u.F;
        boolean z = !toDir.exists() || toDir.list().length < 1;
        log("PASS#1: Copying files to " + toDir, 4);
        this.u.execute();
        if (z) {
            log("NO removing necessary in " + toDir, 4);
            return;
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        log("PASS#2: Removing orphan files from " + toDir, 4);
        int[] j = j(set, toDir, linkedHashSet);
        g(j[0], "dangling director", "y", "ies");
        g(j[1], "dangling file", "", "s");
        if (!this.u.getIncludeEmptyDirs() || f() == java.lang.Boolean.FALSE) {
            log("PASS#3: Removing empty directories from " + toDir, 4);
            g(!this.u.getIncludeEmptyDirs() ? h(toDir, false, linkedHashSet) : i(linkedHashSet), "empty director", "y", "ies");
        }
    }

    public final java.lang.Boolean f() {
        org.apache.tools.ant.taskdefs.Sync.SyncTarget syncTarget = this.v;
        if (syncTarget == null) {
            return null;
        }
        return syncTarget.getPreserveEmptyDirs();
    }

    public final void g(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.io.File toDir = this.u.getToDir();
        if (str == null) {
            str = "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        if (i >= 2) {
            str2 = str3;
        }
        sb.append(str2);
        java.lang.String sb2 = sb.toString();
        if (i <= 0) {
            log("NO " + sb2 + " to remove from " + toDir, 3);
            return;
        }
        log("Removed " + i + " " + sb2 + " from " + toDir, 2);
    }

    public final int h(java.io.File file, boolean z, java.util.Set set) {
        if (!file.isDirectory()) {
            return 0;
        }
        java.io.File[] listFiles = file.listFiles();
        int i = 0;
        for (java.io.File file2 : listFiles) {
            if (file2.isDirectory()) {
                i += h(file2, true, set);
            }
        }
        if (listFiles.length > 0) {
            listFiles = file.listFiles();
        }
        if (listFiles.length >= 1 || !z || set.contains(file)) {
            return i;
        }
        log("Removing empty directory: " + file, 4);
        file.delete();
        return i + 1;
    }

    public final int i(java.util.Set set) {
        java.util.Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            java.io.File file = (java.io.File) it.next();
            java.lang.String[] list = file.list();
            if (list == null || list.length == 0) {
                log("Removing empty directory: " + file, 4);
                file.delete();
                i++;
            }
        }
        return i;
    }

    @Override // org.apache.tools.ant.Task
    public void init() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.Sync.MyCopy myCopy = new org.apache.tools.ant.taskdefs.Sync.MyCopy();
        this.u = myCopy;
        e(myCopy);
        this.u.setFiltering(false);
        this.u.setIncludeEmptyDirs(false);
        this.u.setPreserveLastModified(true);
    }

    public final int[] j(java.util.Set set, java.io.File file, java.util.Set set2) {
        org.apache.tools.ant.DirectoryScanner directoryScanner;
        int[] iArr = {0, 0};
        java.lang.String[] strArr = (java.lang.String[]) set.toArray(new java.lang.String[set.size() + 1]);
        strArr[set.size()] = "";
        org.apache.tools.ant.taskdefs.Sync.SyncTarget syncTarget = this.v;
        if (syncTarget != null) {
            org.apache.tools.ant.types.FileSet d = syncTarget.d(false);
            d.setDir(file);
            org.apache.tools.ant.types.PatternSet mergePatterns = this.v.mergePatterns(getProject());
            d.appendExcludes(mergePatterns.getIncludePatterns(getProject()));
            d.appendIncludes(mergePatterns.getExcludePatterns(getProject()));
            d.setDefaultexcludes(!this.v.getDefaultexcludes());
            org.apache.tools.ant.types.selectors.FileSelector[] selectors = this.v.getSelectors(getProject());
            if (selectors.length > 0) {
                org.apache.tools.ant.types.selectors.NoneSelector noneSelector = new org.apache.tools.ant.types.selectors.NoneSelector();
                for (org.apache.tools.ant.types.selectors.FileSelector fileSelector : selectors) {
                    noneSelector.appendSelector(fileSelector);
                }
                d.appendSelector(noneSelector);
            }
            directoryScanner = d.getDirectoryScanner(getProject());
        } else {
            directoryScanner = new org.apache.tools.ant.DirectoryScanner();
            directoryScanner.setBasedir(file);
        }
        directoryScanner.addExcludes(strArr);
        directoryScanner.scan();
        for (java.lang.String str : directoryScanner.getIncludedFiles()) {
            java.io.File file2 = new java.io.File(file, str);
            log("Removing orphan file: " + file2, 4);
            file2.delete();
            iArr[1] = iArr[1] + 1;
        }
        java.lang.String[] includedDirectories = directoryScanner.getIncludedDirectories();
        for (int length = includedDirectories.length - 1; length >= 0; length--) {
            java.io.File file3 = new java.io.File(file, includedDirectories[length]);
            java.lang.String[] list = file3.list();
            if (list == null || list.length < 1) {
                log("Removing orphan directory: " + file3, 4);
                file3.delete();
                iArr[0] = iArr[0] + 1;
            }
        }
        java.lang.Boolean f = f();
        if (f != null && f.booleanValue() != this.u.getIncludeEmptyDirs()) {
            org.apache.tools.ant.types.FileSet d2 = this.v.d(true);
            d2.setDir(file);
            java.lang.String[] includedDirectories2 = d2.getDirectoryScanner(getProject()).getIncludedDirectories();
            for (int length2 = includedDirectories2.length - 1; length2 >= 0; length2--) {
                set2.add(new java.io.File(file, includedDirectories2[length2]));
            }
        }
        return iArr;
    }

    public void setFailOnError(boolean z) {
        this.u.setFailOnError(z);
    }

    public void setGranularity(long j) {
        this.u.setGranularity(j);
    }

    public void setIncludeEmptyDirs(boolean z) {
        this.u.setIncludeEmptyDirs(z);
    }

    public void setOverwrite(boolean z) {
        this.u.setOverwrite(z);
    }

    public void setTodir(java.io.File file) {
        this.u.setTodir(file);
    }

    public void setVerbose(boolean z) {
        this.u.setVerbose(z);
    }
}
