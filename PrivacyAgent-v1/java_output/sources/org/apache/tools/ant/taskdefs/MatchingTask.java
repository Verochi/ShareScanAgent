package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public abstract class MatchingTask extends org.apache.tools.ant.Task implements org.apache.tools.ant.types.selectors.SelectorContainer {
    protected org.apache.tools.ant.types.FileSet fileset = new org.apache.tools.ant.types.FileSet();

    public void XsetIgnore(java.lang.String str) {
        log("The ignore attribute is deprecated.Please use the excludes attribute.", 1);
        if (str == null || str.length() <= 0) {
            return;
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ", ", false);
        while (stringTokenizer.hasMoreTokens()) {
            createExclude().setName("**/" + stringTokenizer.nextToken().trim() + "/**");
        }
    }

    public void XsetItems(java.lang.String str) {
        log("The items attribute is deprecated. Please use the includes attribute.", 1);
        if (str == null || str.equals("*") || str.equals(".")) {
            createInclude().setName(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH);
            return;
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ", ");
        while (stringTokenizer.hasMoreTokens()) {
            java.lang.String trim = stringTokenizer.nextToken().trim();
            if (trim.length() > 0) {
                createInclude().setName(trim + "/**");
            }
        }
    }

    public void add(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        this.fileset.add(fileSelector);
    }

    public void addAnd(org.apache.tools.ant.types.selectors.AndSelector andSelector) {
        this.fileset.addAnd(andSelector);
    }

    public void addContains(org.apache.tools.ant.types.selectors.ContainsSelector containsSelector) {
        this.fileset.addContains(containsSelector);
    }

    public void addContainsRegexp(org.apache.tools.ant.types.selectors.ContainsRegexpSelector containsRegexpSelector) {
        this.fileset.addContainsRegexp(containsRegexpSelector);
    }

    public void addCustom(org.apache.tools.ant.types.selectors.ExtendSelector extendSelector) {
        this.fileset.addCustom(extendSelector);
    }

    public void addDate(org.apache.tools.ant.types.selectors.DateSelector dateSelector) {
        this.fileset.addDate(dateSelector);
    }

    public void addDepend(org.apache.tools.ant.types.selectors.DependSelector dependSelector) {
        this.fileset.addDepend(dependSelector);
    }

    public void addDepth(org.apache.tools.ant.types.selectors.DepthSelector depthSelector) {
        this.fileset.addDepth(depthSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addDifferent(org.apache.tools.ant.types.selectors.DifferentSelector differentSelector) {
        this.fileset.addDifferent(differentSelector);
    }

    public void addFilename(org.apache.tools.ant.types.selectors.FilenameSelector filenameSelector) {
        this.fileset.addFilename(filenameSelector);
    }

    public void addMajority(org.apache.tools.ant.types.selectors.MajoritySelector majoritySelector) {
        this.fileset.addMajority(majoritySelector);
    }

    public void addModified(org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector modifiedSelector) {
        this.fileset.addModified(modifiedSelector);
    }

    public void addNone(org.apache.tools.ant.types.selectors.NoneSelector noneSelector) {
        this.fileset.addNone(noneSelector);
    }

    public void addNot(org.apache.tools.ant.types.selectors.NotSelector notSelector) {
        this.fileset.addNot(notSelector);
    }

    public void addOr(org.apache.tools.ant.types.selectors.OrSelector orSelector) {
        this.fileset.addOr(orSelector);
    }

    public void addPresent(org.apache.tools.ant.types.selectors.PresentSelector presentSelector) {
        this.fileset.addPresent(presentSelector);
    }

    public void addSelector(org.apache.tools.ant.types.selectors.SelectSelector selectSelector) {
        this.fileset.addSelector(selectSelector);
    }

    public void addSize(org.apache.tools.ant.types.selectors.SizeSelector sizeSelector) {
        this.fileset.addSize(sizeSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void addType(org.apache.tools.ant.types.selectors.TypeSelector typeSelector) {
        this.fileset.addType(typeSelector);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public void appendSelector(org.apache.tools.ant.types.selectors.FileSelector fileSelector) {
        this.fileset.appendSelector(fileSelector);
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createExclude() {
        return this.fileset.createExclude();
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createExcludesFile() {
        return this.fileset.createExcludesFile();
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createInclude() {
        return this.fileset.createInclude();
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createIncludesFile() {
        return this.fileset.createIncludesFile();
    }

    public org.apache.tools.ant.types.PatternSet createPatternSet() {
        return this.fileset.createPatternSet();
    }

    public org.apache.tools.ant.DirectoryScanner getDirectoryScanner(java.io.File file) {
        this.fileset.setDir(file);
        return this.fileset.getDirectoryScanner(getProject());
    }

    public final org.apache.tools.ant.types.FileSet getImplicitFileSet() {
        return this.fileset;
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public org.apache.tools.ant.types.selectors.FileSelector[] getSelectors(org.apache.tools.ant.Project project) {
        return this.fileset.getSelectors(project);
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public boolean hasSelectors() {
        return this.fileset.hasSelectors();
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public int selectorCount() {
        return this.fileset.selectorCount();
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorContainer
    public java.util.Enumeration<org.apache.tools.ant.types.selectors.FileSelector> selectorElements() {
        return this.fileset.selectorElements();
    }

    public void setCaseSensitive(boolean z) {
        this.fileset.setCaseSensitive(z);
    }

    public void setDefaultexcludes(boolean z) {
        this.fileset.setDefaultexcludes(z);
    }

    public void setExcludes(java.lang.String str) {
        this.fileset.setExcludes(str);
    }

    public void setExcludesfile(java.io.File file) {
        this.fileset.setExcludesfile(file);
    }

    public void setFollowSymlinks(boolean z) {
        this.fileset.setFollowSymlinks(z);
    }

    public void setIncludes(java.lang.String str) {
        this.fileset.setIncludes(str);
    }

    public void setIncludesfile(java.io.File file) {
        this.fileset.setIncludesfile(file);
    }

    @Override // org.apache.tools.ant.ProjectComponent
    public void setProject(org.apache.tools.ant.Project project) {
        super.setProject(project);
        this.fileset.setProject(project);
    }
}
