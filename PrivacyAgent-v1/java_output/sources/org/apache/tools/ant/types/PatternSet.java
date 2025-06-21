package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class PatternSet extends org.apache.tools.ant.types.DataType {
    public java.util.List<org.apache.tools.ant.types.PatternSet.NameEntry> n = new java.util.ArrayList();
    public java.util.List<org.apache.tools.ant.types.PatternSet.NameEntry> t = new java.util.ArrayList();
    public java.util.List<org.apache.tools.ant.types.PatternSet.PatternFileNameEntry> u = new java.util.ArrayList();
    public java.util.List<org.apache.tools.ant.types.PatternSet.PatternFileNameEntry> v = new java.util.ArrayList();

    public static final class InvertedPatternSet extends org.apache.tools.ant.types.PatternSet {
        public InvertedPatternSet(org.apache.tools.ant.types.PatternSet patternSet) {
            setProject(patternSet.getProject());
            addConfiguredPatternset(patternSet);
        }

        public /* synthetic */ InvertedPatternSet(org.apache.tools.ant.types.PatternSet patternSet, org.apache.tools.ant.types.PatternSet.AnonymousClass1 anonymousClass1) {
            this(patternSet);
        }

        @Override // org.apache.tools.ant.types.PatternSet
        public java.lang.String[] getExcludePatterns(org.apache.tools.ant.Project project) {
            return super.getIncludePatterns(project);
        }

        @Override // org.apache.tools.ant.types.PatternSet
        public java.lang.String[] getIncludePatterns(org.apache.tools.ant.Project project) {
            return super.getExcludePatterns(project);
        }
    }

    public class NameEntry {
        public java.lang.String a;
        public java.lang.Object b;
        public java.lang.Object c;

        public NameEntry() {
        }

        public final boolean a(org.apache.tools.ant.Project project) {
            org.apache.tools.ant.PropertyHelper propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(project);
            return propertyHelper.testIfCondition(this.b) && propertyHelper.testUnlessCondition(this.c);
        }

        public java.lang.String evalName(org.apache.tools.ant.Project project) {
            if (a(project)) {
                return this.a;
            }
            return null;
        }

        public java.lang.String getName() {
            return this.a;
        }

        public void setIf(java.lang.Object obj) {
            this.b = obj;
        }

        public void setIf(java.lang.String str) {
            setIf((java.lang.Object) str);
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }

        public void setUnless(java.lang.Object obj) {
            this.c = obj;
        }

        public void setUnless(java.lang.String str) {
            setUnless((java.lang.Object) str);
        }

        public java.lang.String toString() {
            java.lang.String str;
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.lang.String str2 = this.a;
            if (str2 == null) {
                stringBuffer.append("noname");
            } else {
                stringBuffer.append(str2);
            }
            if (this.b != null || this.c != null) {
                stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if (this.b != null) {
                    stringBuffer.append("if->");
                    stringBuffer.append(this.b);
                    str = com.alipay.sdk.m.u.i.b;
                } else {
                    str = "";
                }
                if (this.c != null) {
                    stringBuffer.append(str);
                    stringBuffer.append("unless->");
                    stringBuffer.append(this.c);
                }
            }
            return stringBuffer.toString();
        }
    }

    public class PatternFileNameEntry extends org.apache.tools.ant.types.PatternSet.NameEntry {
        public java.lang.String e;

        public PatternFileNameEntry() {
            super();
        }

        public final java.lang.String getEncoding() {
            return this.e;
        }

        public final void setEncoding(java.lang.String str) {
            this.e = str;
        }

        @Override // org.apache.tools.ant.types.PatternSet.NameEntry
        public java.lang.String toString() {
            java.lang.String nameEntry = super.toString();
            if (this.e == null) {
                return nameEntry;
            }
            return nameEntry + ";encoding->" + this.e;
        }
    }

    public void addConfiguredInvert(org.apache.tools.ant.types.PatternSet patternSet) {
        addConfiguredPatternset(new org.apache.tools.ant.types.PatternSet.InvertedPatternSet(patternSet, null));
    }

    public void addConfiguredPatternset(org.apache.tools.ant.types.PatternSet patternSet) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        java.lang.String[] includePatterns = patternSet.getIncludePatterns(getProject());
        java.lang.String[] excludePatterns = patternSet.getExcludePatterns(getProject());
        if (includePatterns != null) {
            for (java.lang.String str : includePatterns) {
                createInclude().setName(str);
            }
        }
        if (excludePatterns != null) {
            for (java.lang.String str2 : excludePatterns) {
                createExclude().setName(str2);
            }
        }
    }

    public void append(org.apache.tools.ant.types.PatternSet patternSet, org.apache.tools.ant.Project project) {
        if (isReference()) {
            throw new org.apache.tools.ant.BuildException("Cannot append to a reference");
        }
        dieOnCircularReference(project);
        java.lang.String[] includePatterns = patternSet.getIncludePatterns(project);
        if (includePatterns != null) {
            for (java.lang.String str : includePatterns) {
                createInclude().setName(str);
            }
        }
        java.lang.String[] excludePatterns = patternSet.getExcludePatterns(project);
        if (excludePatterns != null) {
            for (java.lang.String str2 : excludePatterns) {
                createExclude().setName(str2);
            }
        }
    }

    public final org.apache.tools.ant.types.PatternSet.PatternFileNameEntry b(java.util.List<org.apache.tools.ant.types.PatternSet.PatternFileNameEntry> list) {
        org.apache.tools.ant.types.PatternSet.PatternFileNameEntry patternFileNameEntry = new org.apache.tools.ant.types.PatternSet.PatternFileNameEntry();
        list.add(patternFileNameEntry);
        return patternFileNameEntry;
    }

    public final org.apache.tools.ant.types.PatternSet.NameEntry c(java.util.List<org.apache.tools.ant.types.PatternSet.NameEntry> list) {
        org.apache.tools.ant.types.PatternSet.NameEntry nameEntry = new org.apache.tools.ant.types.PatternSet.NameEntry();
        list.add(nameEntry);
        return nameEntry;
    }

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        try {
            org.apache.tools.ant.types.PatternSet patternSet = (org.apache.tools.ant.types.PatternSet) super.clone();
            patternSet.n = new java.util.ArrayList(this.n);
            patternSet.t = new java.util.ArrayList(this.t);
            patternSet.u = new java.util.ArrayList(this.u);
            patternSet.v = new java.util.ArrayList(this.v);
            return patternSet;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createExclude() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        return c(this.t);
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createExcludesFile() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        return b(this.v);
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createInclude() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        return c(this.n);
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createIncludesFile() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        return b(this.u);
    }

    public final org.apache.tools.ant.types.PatternSet d(org.apache.tools.ant.Project project) {
        return (org.apache.tools.ant.types.PatternSet) getCheckedRef(project);
    }

    public final java.lang.String[] e(java.util.List<org.apache.tools.ant.types.PatternSet.NameEntry> list, org.apache.tools.ant.Project project) {
        if (list.size() == 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<org.apache.tools.ant.types.PatternSet.NameEntry> it = list.iterator();
        while (it.hasNext()) {
            java.lang.String evalName = it.next().evalName(project);
            if (evalName != null && evalName.length() > 0) {
                arrayList.add(evalName);
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public final void f(org.apache.tools.ant.Project project) {
        if (this.u.size() > 0) {
            for (org.apache.tools.ant.types.PatternSet.PatternFileNameEntry patternFileNameEntry : this.u) {
                java.lang.String evalName = patternFileNameEntry.evalName(project);
                if (evalName != null) {
                    java.io.File resolveFile = project.resolveFile(evalName);
                    if (!resolveFile.exists()) {
                        throw new org.apache.tools.ant.BuildException("Includesfile " + resolveFile.getAbsolutePath() + " not found.");
                    }
                    g(resolveFile, patternFileNameEntry.getEncoding(), this.n, project);
                }
            }
            this.u.clear();
        }
        if (this.v.size() > 0) {
            for (org.apache.tools.ant.types.PatternSet.PatternFileNameEntry patternFileNameEntry2 : this.v) {
                java.lang.String evalName2 = patternFileNameEntry2.evalName(project);
                if (evalName2 != null) {
                    java.io.File resolveFile2 = project.resolveFile(evalName2);
                    if (!resolveFile2.exists()) {
                        throw new org.apache.tools.ant.BuildException("Excludesfile " + resolveFile2.getAbsolutePath() + " not found.");
                    }
                    g(resolveFile2, patternFileNameEntry2.getEncoding(), this.t, project);
                }
            }
            this.v.clear();
        }
    }

    public final void g(java.io.File file, java.lang.String str, java.util.List<org.apache.tools.ant.types.PatternSet.NameEntry> list, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                bufferedReader = str == null ? new java.io.BufferedReader(new java.io.FileReader(file)) : new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), str));
                for (java.lang.String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    if (readLine.length() > 0) {
                        c(list).setName(project.replaceProperties(readLine));
                    }
                }
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("An error occurred while reading from pattern file: " + file, e);
            }
        } finally {
            org.apache.tools.ant.util.FileUtils.close(bufferedReader);
        }
    }

    public java.lang.String[] getExcludePatterns(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return d(project).getExcludePatterns(project);
        }
        dieOnCircularReference(project);
        f(project);
        return e(this.t, project);
    }

    public java.lang.String[] getIncludePatterns(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return d(project).getIncludePatterns(project);
        }
        dieOnCircularReference(project);
        f(project);
        return e(this.n, project);
    }

    public boolean hasPatterns(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return d(project).hasPatterns(project);
        }
        dieOnCircularReference(project);
        return this.u.size() > 0 || this.v.size() > 0 || this.n.size() > 0 || this.t.size() > 0;
    }

    public void setExcludes(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ", ", false);
        while (stringTokenizer.hasMoreTokens()) {
            createExclude().setName(stringTokenizer.nextToken());
        }
    }

    public void setExcludesfile(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw tooManyAttributes();
        }
        createExcludesFile().setName(file.getAbsolutePath());
    }

    public void setIncludes(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ", ", false);
        while (stringTokenizer.hasMoreTokens()) {
            createInclude().setName(stringTokenizer.nextToken());
        }
    }

    public void setIncludesfile(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw tooManyAttributes();
        }
        createIncludesFile().setName(file.getAbsolutePath());
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (!this.n.isEmpty() || !this.t.isEmpty()) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return "patternSet{ includes: " + this.n + " excludes: " + this.t + " }";
    }
}
