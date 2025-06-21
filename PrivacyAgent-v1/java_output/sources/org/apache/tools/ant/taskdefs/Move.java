package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Move extends org.apache.tools.ant.taskdefs.Copy {
    public boolean F = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS);

    public Move() {
        setOverwrite(true);
    }

    public void deleteDir(java.io.File file) {
        deleteDir(file, false);
    }

    public void deleteDir(java.io.File file, boolean z) {
        java.lang.String[] list = file.list();
        if (list == null) {
            return;
        }
        for (java.lang.String str : list) {
            java.io.File file2 = new java.io.File(file, str);
            if (!file2.isDirectory()) {
                if (z && !getFileUtils().tryHardToDelete(file2, this.F)) {
                    throw new org.apache.tools.ant.BuildException("Unable to delete file " + file2.getAbsolutePath());
                }
                throw new org.apache.tools.ant.BuildException("UNEXPECTED ERROR - The file " + file2.getAbsolutePath() + " should not exist!");
            }
            deleteDir(file2);
        }
        log("Deleting directory " + file.getAbsolutePath(), this.verbosity);
        if (getFileUtils().tryHardToDelete(file, this.F)) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Unable to delete directory " + file.getAbsolutePath());
    }

    @Override // org.apache.tools.ant.taskdefs.Copy
    public void doFileOperations() {
        if (this.completeDirMap.size() > 0) {
            for (java.io.File file : this.completeDirMap.keySet()) {
                java.io.File file2 = this.completeDirMap.get(file);
                try {
                    log("Attempting to rename dir: " + file + " to " + file2, this.verbosity);
                    if (!renameFile(file, file2, this.filtering, this.forceOverwrite)) {
                        org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
                        fileSet.setProject(getProject());
                        fileSet.setDir(file);
                        addFileset(fileSet);
                        org.apache.tools.ant.DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(getProject());
                        scan(file, file2, directoryScanner.getIncludedFiles(), directoryScanner.getIncludedDirectories());
                    }
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException("Failed to rename dir " + file + " to " + file2 + " due to " + e.getMessage(), e, getLocation());
                }
            }
        }
        int size = this.fileCopyMap.size();
        if (size > 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Moving ");
            sb.append(size);
            sb.append(" file");
            sb.append(size == 1 ? "" : "s");
            sb.append(" to ");
            sb.append(this.destDir.getAbsolutePath());
            log(sb.toString());
            for (java.lang.String str : this.fileCopyMap.keySet()) {
                java.io.File file3 = new java.io.File(str);
                if (file3.exists()) {
                    java.lang.String[] strArr = this.fileCopyMap.get(str);
                    boolean z = false;
                    for (int i = 0; i < strArr.length; i++) {
                        java.lang.String str2 = strArr[i];
                        if (str.equals(str2)) {
                            log("Skipping self-move of " + str, this.verbosity);
                            z = true;
                        } else {
                            java.io.File file4 = new java.io.File(str2);
                            if (i + 1 != strArr.length || z) {
                                j(file3, file4, this.filtering, this.forceOverwrite);
                            } else {
                                k(file3, file4, this.filtering, this.forceOverwrite);
                            }
                        }
                    }
                }
            }
        }
        if (this.includeEmpty) {
            int i2 = 0;
            for (java.util.Map.Entry<java.lang.String, java.lang.String[]> entry : this.dirCopyMap.entrySet()) {
                java.lang.String key = entry.getKey();
                boolean z2 = false;
                for (java.lang.String str3 : entry.getValue()) {
                    if (key.equals(str3)) {
                        log("Skipping self-move of " + key, this.verbosity);
                        z2 = true;
                    } else {
                        java.io.File file5 = new java.io.File(str3);
                        if (!file5.exists()) {
                            if (file5.mkdirs() || file5.exists()) {
                                i2++;
                            } else {
                                log("Unable to create directory " + file5.getAbsolutePath(), 0);
                            }
                        }
                    }
                }
                java.io.File file6 = new java.io.File(key);
                if (!z2 && okToDelete(file6)) {
                    deleteDir(file6);
                }
            }
            if (i2 > 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Moved ");
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

    public final void j(java.io.File file, java.io.File file2, boolean z, boolean z2) {
        java.lang.String str;
        org.apache.tools.ant.types.FilterSetCollection filterSetCollection;
        try {
            log("Copying " + file + " to " + file2, this.verbosity);
            filterSetCollection = new org.apache.tools.ant.types.FilterSetCollection();
            if (z) {
                filterSetCollection.addFilterSet(getProject().getGlobalFilterSet());
            }
            java.util.Iterator<org.apache.tools.ant.types.FilterSet> it = getFilterSets().iterator();
            while (it.hasNext()) {
                filterSetCollection.addFilterSet(it.next());
            }
            str = " to ";
        } catch (java.io.IOException e) {
            e = e;
            str = " to ";
        }
        try {
            getFileUtils().copyFile(file, file2, filterSetCollection, getFilterChains(), this.forceOverwrite, getPreserveLastModified(), false, getEncoding(), getOutputEncoding(), getProject(), getForce());
        } catch (java.io.IOException e2) {
            e = e2;
            throw new org.apache.tools.ant.BuildException("Failed to copy " + file + str + file2 + " due to " + e.getMessage(), e, getLocation());
        }
    }

    public final void k(java.io.File file, java.io.File file2, boolean z, boolean z2) {
        try {
            log("Attempting to rename: " + file + " to " + file2, this.verbosity);
            if (renameFile(file, file2, z, this.forceOverwrite)) {
                return;
            }
            j(file, file2, z, z2);
            if (getFileUtils().tryHardToDelete(file, this.F)) {
                return;
            }
            throw new org.apache.tools.ant.BuildException("Unable to delete file " + file.getAbsolutePath());
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Failed to rename " + file + " to " + file2 + " due to " + e.getMessage(), e, getLocation());
        }
    }

    public boolean okToDelete(java.io.File file) {
        java.lang.String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (java.lang.String str : list) {
            java.io.File file2 = new java.io.File(file, str);
            if (!file2.isDirectory() || !okToDelete(file2)) {
                return false;
            }
        }
        return true;
    }

    public boolean renameFile(java.io.File file, java.io.File file2, boolean z, boolean z2) throws java.io.IOException, org.apache.tools.ant.BuildException {
        if (file2.isDirectory() || z || getFilterSets().size() > 0 || getFilterChains().size() > 0) {
            return false;
        }
        if (file2.isFile() && !file2.canWrite()) {
            if (!getForce()) {
                throw new java.io.IOException("can't replace read-only destination file " + file2);
            }
            if (!getFileUtils().tryHardToDelete(file2)) {
                throw new java.io.IOException("failed to delete read-only destination file " + file2);
            }
        }
        java.io.File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        } else if (file2.isFile()) {
            file = getFileUtils().normalize(file.getAbsolutePath()).getCanonicalFile();
            file2 = getFileUtils().normalize(file2.getAbsolutePath());
            if (file2.getAbsolutePath().equals(file.getAbsolutePath())) {
                log("Rename of " + file + " to " + file2 + " is a no-op.", 3);
                return true;
            }
            if (!getFileUtils().areSame(file, file2) && !getFileUtils().tryHardToDelete(file2, this.F)) {
                throw new org.apache.tools.ant.BuildException("Unable to remove existing file " + file2);
            }
        }
        return file.renameTo(file2);
    }

    public void setPerformGcOnFailedDelete(boolean z) {
        this.F = z;
    }

    @Override // org.apache.tools.ant.taskdefs.Copy
    public void validateAttributes() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.file;
        if (file == null || !file.isDirectory()) {
            super.validateAttributes();
            return;
        }
        java.io.File file2 = this.destFile;
        if ((file2 != null && this.destDir != null) || (file2 == null && this.destDir == null)) {
            throw new org.apache.tools.ant.BuildException("One and only one of tofile and todir must be set.");
        }
        if (file2 == null) {
            file2 = new java.io.File(this.destDir, this.file.getName());
        }
        this.destFile = file2;
        java.io.File file3 = this.destDir;
        if (file3 == null) {
            file3 = file2.getParentFile();
        }
        this.destDir = file3;
        this.completeDirMap.put(this.file, this.destFile);
        this.file = null;
    }
}
