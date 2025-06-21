package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Files extends org.apache.tools.ant.types.selectors.AbstractSelectorContainer implements org.apache.tools.ant.types.ResourceCollection {
    public static final java.util.Iterator<org.apache.tools.ant.types.Resource> z = java.util.Collections.emptySet().iterator();
    public org.apache.tools.ant.types.PatternSet t;
    public java.util.Vector<org.apache.tools.ant.types.PatternSet> u;
    public boolean v;
    public boolean w;
    public boolean x;
    public org.apache.tools.ant.DirectoryScanner y;

    public Files() {
        this.t = new org.apache.tools.ant.types.PatternSet();
        this.u = new java.util.Vector<>();
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = null;
    }

    public Files(org.apache.tools.ant.types.resources.Files files) {
        this.t = new org.apache.tools.ant.types.PatternSet();
        this.u = new java.util.Vector<>();
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = null;
        this.t = files.t;
        this.u = files.u;
        this.v = files.v;
        this.w = files.w;
        this.x = files.x;
        this.y = files.y;
        setProject(files.getProject());
    }

    public synchronized void appendExcludes(java.lang.String[] strArr) {
        checkAttributesAllowed();
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                this.t.createExclude().setName(str);
            }
            this.y = null;
        }
    }

    public synchronized void appendIncludes(java.lang.String[] strArr) {
        checkAttributesAllowed();
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                this.t.createInclude().setName(str);
            }
            this.y = null;
        }
    }

    @Override // org.apache.tools.ant.types.selectors.AbstractSelectorContainer, org.apache.tools.ant.types.selectors.SelectorContainer
    public synchronized void appendSelector(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        super.appendSelector(fileSelector);
        this.y = null;
    }

    public final synchronized void b() {
        dieOnCircularReference();
        if (this.y == null) {
            this.y = new org.apache.tools.ant.DirectoryScanner();
            org.apache.tools.ant.types.PatternSet mergePatterns = mergePatterns(getProject());
            this.y.setIncludes(mergePatterns.getIncludePatterns(getProject()));
            this.y.setExcludes(mergePatterns.getExcludePatterns(getProject()));
            this.y.setSelectors(getSelectors(getProject()));
            if (this.v) {
                this.y.addDefaultExcludes();
            }
            this.y.setCaseSensitive(this.w);
            this.y.setFollowSymlinks(this.x);
        }
    }

    public final boolean c(org.apache.tools.ant.types.PatternSet patternSet) {
        java.lang.String[] includePatterns = patternSet.getIncludePatterns(getProject());
        java.lang.String[] excludePatterns = patternSet.getExcludePatterns(getProject());
        return (includePatterns != null && includePatterns.length > 0) || (excludePatterns != null && excludePatterns.length > 0);
    }

    @Override // org.apache.tools.ant.types.selectors.AbstractSelectorContainer, org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public synchronized java.lang.Object clone() {
        if (isReference()) {
            return getRef().clone();
        }
        org.apache.tools.ant.types.resources.Files files = (org.apache.tools.ant.types.resources.Files) super.clone();
        files.t = (org.apache.tools.ant.types.PatternSet) this.t.clone();
        files.u = new java.util.Vector<>(this.u.size());
        java.util.Iterator<org.apache.tools.ant.types.PatternSet> it = this.u.iterator();
        while (it.hasNext()) {
            files.u.add((org.apache.tools.ant.types.PatternSet) it.next().clone());
        }
        return files;
    }

    public synchronized org.apache.tools.ant.types.PatternSet.NameEntry createExclude() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.y = null;
        return this.t.createExclude();
    }

    public synchronized org.apache.tools.ant.types.PatternSet.NameEntry createExcludesFile() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.y = null;
        return this.t.createExcludesFile();
    }

    public synchronized org.apache.tools.ant.types.PatternSet.NameEntry createInclude() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.y = null;
        return this.t.createInclude();
    }

    public synchronized org.apache.tools.ant.types.PatternSet.NameEntry createIncludesFile() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.y = null;
        return this.t.createIncludesFile();
    }

    public synchronized org.apache.tools.ant.types.PatternSet createPatternSet() {
        org.apache.tools.ant.types.PatternSet patternSet;
        if (isReference()) {
            throw noChildrenAllowed();
        }
        patternSet = new org.apache.tools.ant.types.PatternSet();
        this.u.addElement(patternSet);
        this.y = null;
        setChecked(false);
        return patternSet;
    }

    public synchronized boolean getDefaultexcludes() {
        return isReference() ? getRef().getDefaultexcludes() : this.v;
    }

    public org.apache.tools.ant.types.resources.Files getRef() {
        return (org.apache.tools.ant.types.resources.Files) getCheckedRef();
    }

    public synchronized boolean hasPatterns() {
        if (isReference()) {
            return getRef().hasPatterns();
        }
        dieOnCircularReference();
        if (c(this.t)) {
            return true;
        }
        java.util.Iterator<org.apache.tools.ant.types.PatternSet> it = this.u.iterator();
        while (it.hasNext()) {
            if (c(it.next())) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isCaseSensitive() {
        return isReference() ? getRef().isCaseSensitive() : this.w;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        return true;
    }

    public synchronized boolean isFollowSymlinks() {
        return isReference() ? getRef().isFollowSymlinks() : this.x;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public synchronized java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return getRef().iterator();
        }
        b();
        this.y.scan();
        int includedFilesCount = this.y.getIncludedFilesCount();
        int includedDirsCount = this.y.getIncludedDirsCount();
        if (includedFilesCount + includedDirsCount == 0) {
            return z;
        }
        org.apache.tools.ant.types.resources.FileResourceIterator fileResourceIterator = new org.apache.tools.ant.types.resources.FileResourceIterator(getProject());
        if (includedFilesCount > 0) {
            fileResourceIterator.addFiles(this.y.getIncludedFiles());
        }
        if (includedDirsCount > 0) {
            fileResourceIterator.addFiles(this.y.getIncludedDirectories());
        }
        return fileResourceIterator;
    }

    public java.lang.String[] mergeExcludes(org.apache.tools.ant.Project project) {
        return mergePatterns(project).getExcludePatterns(project);
    }

    public java.lang.String[] mergeIncludes(org.apache.tools.ant.Project project) {
        return mergePatterns(project).getIncludePatterns(project);
    }

    public synchronized org.apache.tools.ant.types.PatternSet mergePatterns(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return getRef().mergePatterns(project);
        }
        dieOnCircularReference();
        org.apache.tools.ant.types.PatternSet patternSet = new org.apache.tools.ant.types.PatternSet();
        patternSet.append(this.t, project);
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            patternSet.append(this.u.elementAt(i), project);
        }
        return patternSet;
    }

    public synchronized void setCaseSensitive(boolean z2) {
        checkAttributesAllowed();
        this.w = z2;
        this.y = null;
    }

    public synchronized void setDefaultexcludes(boolean z2) {
        checkAttributesAllowed();
        this.v = z2;
        this.y = null;
    }

    public synchronized void setExcludes(java.lang.String str) {
        checkAttributesAllowed();
        this.t.setExcludes(str);
        this.y = null;
    }

    public synchronized void setExcludesfile(java.io.File file) throws org.apache.tools.ant.BuildException {
        checkAttributesAllowed();
        this.t.setExcludesfile(file);
        this.y = null;
    }

    public synchronized void setFollowSymlinks(boolean z2) {
        checkAttributesAllowed();
        this.x = z2;
        this.y = null;
    }

    public synchronized void setIncludes(java.lang.String str) {
        checkAttributesAllowed();
        this.t.setIncludes(str);
        this.y = null;
    }

    public synchronized void setIncludesfile(java.io.File file) throws org.apache.tools.ant.BuildException {
        checkAttributesAllowed();
        this.t.setIncludesfile(file);
        this.y = null;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (c(this.t)) {
            throw tooManyAttributes();
        }
        if (!this.u.isEmpty()) {
            throw noChildrenAllowed();
        }
        if (hasSelectors()) {
            throw noChildrenAllowed();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized int size() {
        if (isReference()) {
            return getRef().size();
        }
        b();
        this.y.scan();
        return this.y.getIncludedFilesCount() + this.y.getIncludedDirsCount();
    }

    @Override // org.apache.tools.ant.types.selectors.AbstractSelectorContainer, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        if (isReference()) {
            return getRef().toString();
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = iterator();
        if (!it.hasNext()) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (it.hasNext()) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(java.io.File.pathSeparatorChar);
            }
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }
}
