package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public abstract class AbstractFileSet extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.selectors.SelectorContainer {
    public boolean A;
    public int B;
    public org.apache.tools.ant.DirectoryScanner C;
    public org.apache.tools.ant.types.PatternSet n;
    public java.util.List<org.apache.tools.ant.types.PatternSet> t;
    public java.util.List<org.apache.tools.ant.types.selectors.FileSelector> u;
    public java.io.File v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public AbstractFileSet() {
        this.n = new org.apache.tools.ant.types.PatternSet();
        this.t = new java.util.ArrayList();
        this.u = new java.util.ArrayList();
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = true;
        this.B = 5;
        this.C = null;
    }

    public AbstractFileSet(org.apache.tools.ant.types.AbstractFileSet abstractFileSet) {
        this.n = new org.apache.tools.ant.types.PatternSet();
        this.t = new java.util.ArrayList();
        this.u = new java.util.ArrayList();
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = true;
        this.B = 5;
        this.C = null;
        this.v = abstractFileSet.v;
        this.n = abstractFileSet.n;
        this.t = abstractFileSet.t;
        this.u = abstractFileSet.u;
        this.x = abstractFileSet.x;
        this.y = abstractFileSet.y;
        this.z = abstractFileSet.z;
        this.A = abstractFileSet.A;
        this.B = abstractFileSet.B;
        setProject(abstractFileSet.getProject());
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void add(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        appendSelector(fileSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addAnd(org.apache.tools.ant.types.selectors.AndSelector andSelector) {
        appendSelector(andSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addContains(org.apache.tools.ant.types.selectors.ContainsSelector containsSelector) {
        appendSelector(containsSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addContainsRegexp(org.apache.tools.ant.types.selectors.ContainsRegexpSelector containsRegexpSelector) {
        appendSelector(containsRegexpSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addCustom(org.apache.tools.ant.types.selectors.ExtendSelector extendSelector) {
        appendSelector(extendSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDate(org.apache.tools.ant.types.selectors.DateSelector dateSelector) {
        appendSelector(dateSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDepend(org.apache.tools.ant.types.selectors.DependSelector dependSelector) {
        appendSelector(dependSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDepth(org.apache.tools.ant.types.selectors.DepthSelector depthSelector) {
        appendSelector(depthSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDifferent(org.apache.tools.ant.types.selectors.DifferentSelector differentSelector) {
        appendSelector(differentSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addFilename(org.apache.tools.ant.types.selectors.FilenameSelector filenameSelector) {
        appendSelector(filenameSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addMajority(org.apache.tools.ant.types.selectors.MajoritySelector majoritySelector) {
        appendSelector(majoritySelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addModified(org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector modifiedSelector) {
        appendSelector(modifiedSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addNone(org.apache.tools.ant.types.selectors.NoneSelector noneSelector) {
        appendSelector(noneSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addNot(org.apache.tools.ant.types.selectors.NotSelector notSelector) {
        appendSelector(notSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addOr(org.apache.tools.ant.types.selectors.OrSelector orSelector) {
        appendSelector(orSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addPresent(org.apache.tools.ant.types.selectors.PresentSelector presentSelector) {
        appendSelector(presentSelector);
    }

    public void addReadable(org.apache.tools.ant.types.selectors.ReadableSelector readableSelector) {
        appendSelector(readableSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addSelector(org.apache.tools.ant.types.selectors.SelectSelector selectSelector) {
        appendSelector(selectSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addSize(org.apache.tools.ant.types.selectors.SizeSelector sizeSelector) {
        appendSelector(sizeSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addType(org.apache.tools.ant.types.selectors.TypeSelector typeSelector) {
        appendSelector(typeSelector);
    }

    public void addWritable(org.apache.tools.ant.types.selectors.WritableSelector writableSelector) {
        appendSelector(writableSelector);
    }

    public synchronized void appendExcludes(java.lang.String[] strArr) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                this.n.createExclude().setName(str);
            }
            this.C = null;
        }
    }

    public synchronized void appendIncludes(java.lang.String[] strArr) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                this.n.createInclude().setName(str);
            }
            this.C = null;
        }
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public synchronized void appendSelector(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.u.add(fileSelector);
        this.C = null;
        setChecked(false);
    }

    public final org.apache.tools.ant.BuildException b() {
        return new org.apache.tools.ant.BuildException("you can only specify one of the dir and file attributes");
    }

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public synchronized java.lang.Object clone() {
        if (isReference()) {
            return getRef(getProject()).clone();
        }
        try {
            org.apache.tools.ant.types.AbstractFileSet abstractFileSet = (org.apache.tools.ant.types.AbstractFileSet) super.clone();
            abstractFileSet.n = (org.apache.tools.ant.types.PatternSet) this.n.clone();
            abstractFileSet.t = new java.util.ArrayList(this.t.size());
            java.util.Iterator<org.apache.tools.ant.types.PatternSet> it = this.t.iterator();
            while (it.hasNext()) {
                abstractFileSet.t.add((org.apache.tools.ant.types.PatternSet) it.next().clone());
            }
            abstractFileSet.u = new java.util.ArrayList(this.u);
            return abstractFileSet;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public synchronized org.apache.tools.ant.types.PatternSet.NameEntry createExclude() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.C = null;
        return this.n.createExclude();
    }

    public synchronized org.apache.tools.ant.types.PatternSet.NameEntry createExcludesFile() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.C = null;
        return this.n.createExcludesFile();
    }

    public synchronized org.apache.tools.ant.types.PatternSet.NameEntry createInclude() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.C = null;
        return this.n.createInclude();
    }

    public synchronized org.apache.tools.ant.types.PatternSet.NameEntry createIncludesFile() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.C = null;
        return this.n.createIncludesFile();
    }

    public synchronized org.apache.tools.ant.types.PatternSet createPatternSet() {
        org.apache.tools.ant.types.PatternSet patternSet;
        if (isReference()) {
            throw noChildrenAllowed();
        }
        patternSet = new org.apache.tools.ant.types.PatternSet();
        this.t.add(patternSet);
        this.C = null;
        return patternSet;
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            for (java.lang.Object obj : this.u) {
                if (obj instanceof org.apache.tools.ant.types.DataType) {
                    org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) obj, stack, project);
                }
            }
            java.util.Iterator<org.apache.tools.ant.types.PatternSet> it = this.t.iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(it.next(), stack, project);
            }
            setChecked(true);
        }
    }

    public synchronized boolean getDefaultexcludes() {
        if (isReference()) {
            return getRef(getProject()).getDefaultexcludes();
        }
        dieOnCircularReference();
        return this.x;
    }

    public java.io.File getDir() {
        return getDir(getProject());
    }

    public synchronized java.io.File getDir(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return getRef(project).getDir(project);
        }
        dieOnCircularReference();
        return this.v;
    }

    public org.apache.tools.ant.DirectoryScanner getDirectoryScanner() {
        return getDirectoryScanner(getProject());
    }

    public org.apache.tools.ant.DirectoryScanner getDirectoryScanner(org.apache.tools.ant.Project project) {
        org.apache.tools.ant.DirectoryScanner directoryScanner;
        if (isReference()) {
            return getRef(project).getDirectoryScanner(project);
        }
        dieOnCircularReference();
        synchronized (this) {
            if (this.C == null || project != getProject()) {
                java.io.File file = this.v;
                if (file == null) {
                    throw new org.apache.tools.ant.BuildException("No directory specified for " + getDataTypeName() + ".");
                }
                if (!file.exists() && this.A) {
                    throw new org.apache.tools.ant.BuildException(this.v.getAbsolutePath() + org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX);
                }
                if (!this.v.isDirectory() && this.v.exists()) {
                    throw new org.apache.tools.ant.BuildException(this.v.getAbsolutePath() + " is not a directory.");
                }
                org.apache.tools.ant.DirectoryScanner directoryScanner2 = new org.apache.tools.ant.DirectoryScanner();
                setupDirectoryScanner(directoryScanner2, project);
                directoryScanner2.setFollowSymlinks(this.z);
                directoryScanner2.setErrorOnMissingDir(this.A);
                directoryScanner2.setMaxLevelsOfSymlinks(this.B);
                this.C = project == getProject() ? directoryScanner2 : this.C;
                directoryScanner = directoryScanner2;
            } else {
                directoryScanner = this.C;
            }
        }
        directoryScanner.scan();
        return directoryScanner;
    }

    public boolean getErrorOnMissingDir() {
        return this.A;
    }

    public int getMaxLevelsOfSymlinks() {
        return this.B;
    }

    public org.apache.tools.ant.types.AbstractFileSet getRef(org.apache.tools.ant.Project project) {
        return (org.apache.tools.ant.types.AbstractFileSet) getCheckedRef(project);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public synchronized org.apache.tools.ant.types.selectors.FileSelector[] getSelectors(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return getRef(getProject()).getSelectors(project);
        }
        dieOnCircularReference(project);
        java.util.List<org.apache.tools.ant.types.selectors.FileSelector> list = this.u;
        return (org.apache.tools.ant.types.selectors.FileSelector[]) list.toArray(new org.apache.tools.ant.types.selectors.FileSelector[list.size()]);
    }

    public synchronized boolean hasPatterns() {
        if (isReference() && getProject() != null) {
            return getRef(getProject()).hasPatterns();
        }
        dieOnCircularReference();
        if (this.n.hasPatterns(getProject())) {
            return true;
        }
        java.util.Iterator<org.apache.tools.ant.types.PatternSet> it = this.t.iterator();
        while (it.hasNext()) {
            if (it.next().hasPatterns(getProject())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public synchronized boolean hasSelectors() {
        if (isReference()) {
            return getRef(getProject()).hasSelectors();
        }
        dieOnCircularReference();
        return !this.u.isEmpty();
    }

    public synchronized boolean isCaseSensitive() {
        if (isReference()) {
            return getRef(getProject()).isCaseSensitive();
        }
        dieOnCircularReference();
        return this.y;
    }

    public synchronized boolean isFollowSymlinks() {
        if (isReference()) {
            return getRef(getProject()).isCaseSensitive();
        }
        dieOnCircularReference();
        return this.z;
    }

    public java.lang.String[] mergeExcludes(org.apache.tools.ant.Project project) {
        return mergePatterns(project).getExcludePatterns(project);
    }

    public java.lang.String[] mergeIncludes(org.apache.tools.ant.Project project) {
        return mergePatterns(project).getIncludePatterns(project);
    }

    public synchronized org.apache.tools.ant.types.PatternSet mergePatterns(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return getRef(project).mergePatterns(project);
        }
        dieOnCircularReference();
        org.apache.tools.ant.types.PatternSet patternSet = (org.apache.tools.ant.types.PatternSet) this.n.clone();
        int size = this.t.size();
        for (int i = 0; i < size; i++) {
            patternSet.append(this.t.get(i), project);
        }
        return patternSet;
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public synchronized int selectorCount() {
        if (isReference()) {
            return getRef(getProject()).selectorCount();
        }
        dieOnCircularReference();
        return this.u.size();
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public synchronized java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements() {
        if (isReference()) {
            return getRef(getProject()).selectorElements();
        }
        dieOnCircularReference();
        return java.util.Collections.enumeration(this.u);
    }

    public synchronized void setCaseSensitive(boolean z) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.y = z;
        this.C = null;
    }

    public synchronized void setDefaultexcludes(boolean z) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.x = z;
        this.C = null;
    }

    public synchronized void setDir(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (this.w && !getDir().equals(file)) {
            throw b();
        }
        this.v = file;
        this.C = null;
    }

    public void setErrorOnMissingDir(boolean z) {
        this.A = z;
    }

    public synchronized void setExcludes(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.n.setExcludes(str);
        this.C = null;
    }

    public synchronized void setExcludesfile(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.n.setExcludesfile(file);
        this.C = null;
    }

    public synchronized void setFile(java.io.File file) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (this.w) {
            if (getDir().equals(file.getParentFile())) {
                java.lang.String[] includePatterns = this.n.getIncludePatterns(getProject());
                if (includePatterns.length == 1 && includePatterns[0].equals(file.getName())) {
                    return;
                }
            }
            throw new org.apache.tools.ant.BuildException("setFile cannot be called twice with different arguments");
        }
        if (getDir() != null) {
            throw b();
        }
        setDir(file.getParentFile());
        this.w = true;
        createInclude().setName(file.getName());
    }

    public synchronized void setFollowSymlinks(boolean z) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.z = z;
        this.C = null;
    }

    public synchronized void setIncludes(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.n.setIncludes(str);
        this.C = null;
    }

    public synchronized void setIncludesfile(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.n.setIncludesfile(file);
        this.C = null;
    }

    public void setMaxLevelsOfSymlinks(int i) {
        this.B = i;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (this.v != null || this.n.hasPatterns(getProject())) {
            throw tooManyAttributes();
        }
        if (!this.t.isEmpty()) {
            throw noChildrenAllowed();
        }
        if (!this.u.isEmpty()) {
            throw noChildrenAllowed();
        }
        super.setRefid(reference);
    }

    public void setupDirectoryScanner(org.apache.tools.ant.FileScanner fileScanner) {
        setupDirectoryScanner(fileScanner, getProject());
    }

    public synchronized void setupDirectoryScanner(org.apache.tools.ant.FileScanner fileScanner, org.apache.tools.ant.Project project) {
        if (isReference()) {
            getRef(project).setupDirectoryScanner(fileScanner, project);
            return;
        }
        dieOnCircularReference(project);
        if (fileScanner == null) {
            throw new java.lang.IllegalArgumentException("ds cannot be null");
        }
        fileScanner.setBasedir(this.v);
        org.apache.tools.ant.types.PatternSet mergePatterns = mergePatterns(project);
        project.log(getDataTypeName() + ": Setup scanner in dir " + this.v + " with " + mergePatterns, 4);
        fileScanner.setIncludes(mergePatterns.getIncludePatterns(project));
        fileScanner.setExcludes(mergePatterns.getExcludePatterns(project));
        if (fileScanner instanceof org.apache.tools.ant.types.selectors.SelectorScanner) {
            ((org.apache.tools.ant.types.selectors.SelectorScanner) fileScanner).setSelectors(getSelectors(project));
        }
        if (this.x) {
            fileScanner.addDefaultExcludes();
        }
        fileScanner.setCaseSensitive(this.y);
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        if (isReference()) {
            return getRef(getProject()).toString();
        }
        dieOnCircularReference();
        java.lang.String[] includedFiles = getDirectoryScanner(getProject()).getIncludedFiles();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < includedFiles.length; i++) {
            if (i > 0) {
                stringBuffer.append(';');
            }
            stringBuffer.append(includedFiles[i]);
        }
        return stringBuffer.toString();
    }
}
