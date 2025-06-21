package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class DirectoryScanner implements org.apache.tools.ant.FileScanner, org.apache.tools.ant.types.selectors.SelectorScanner, org.apache.tools.ant.types.ResourceFactory {
    public static final java.lang.String DOES_NOT_EXIST_POSTFIX = " does not exist.";
    public static final int MAX_LEVELS_OF_SYMLINKS = 5;
    protected java.io.File basedir;
    protected java.util.Vector<java.lang.String> dirsDeselected;
    protected java.util.Vector<java.lang.String> dirsExcluded;
    protected java.util.Vector<java.lang.String> dirsIncluded;
    protected java.util.Vector<java.lang.String> dirsNotIncluded;
    protected java.lang.String[] excludes;
    protected java.util.Vector<java.lang.String> filesDeselected;
    protected java.util.Vector<java.lang.String> filesExcluded;
    protected java.util.Vector<java.lang.String> filesIncluded;
    protected java.util.Vector<java.lang.String> filesNotIncluded;
    protected java.lang.String[] includes;
    public org.apache.tools.ant.types.selectors.TokenizedPattern[] w;
    public org.apache.tools.ant.types.selectors.TokenizedPattern[] x;
    public static final boolean G = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS);

    @java.lang.Deprecated
    protected static final java.lang.String[] DEFAULTEXCLUDES = {"**/*~", "**/#*#", "**/.#*", "**/%*%", "**/._*", "**/CVS", "**/CVS/**", "**/.cvsignore", "**/SCCS", "**/SCCS/**", "**/vssver.scc", "**/.svn", "**/.svn/**", "**/.git", "**/.git/**", "**/.gitattributes", "**/.gitignore", "**/.gitmodules", "**/.hg", "**/.hg/**", "**/.hgignore", "**/.hgsub", "**/.hgsubstate", "**/.hgtags", "**/.bzr", "**/.bzr/**", "**/.bzrignore", "**/.DS_Store"};
    public static final org.apache.tools.ant.util.FileUtils H = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final org.apache.tools.ant.util.SymbolicLinkUtils I = org.apache.tools.ant.util.SymbolicLinkUtils.getSymbolicLinkUtils();
    public static final java.util.Set<java.lang.String> J = new java.util.HashSet();
    protected org.apache.tools.ant.types.selectors.FileSelector[] selectors = null;
    protected boolean haveSlowResults = false;
    protected boolean isCaseSensitive = true;
    protected boolean errorOnMissingDir = true;
    public boolean n = true;
    protected boolean everythingIncluded = true;
    public final java.util.Set<java.lang.String> t = new java.util.HashSet();
    public final java.util.Map<java.lang.String, org.apache.tools.ant.types.selectors.TokenizedPath> u = new java.util.HashMap();
    public final java.util.Map<java.lang.String, org.apache.tools.ant.types.selectors.TokenizedPath> v = new java.util.HashMap();
    public boolean y = false;
    public boolean z = false;
    public final java.lang.Object A = new java.lang.Object();
    public boolean B = false;
    public final java.lang.Object C = new java.lang.Object();
    public java.lang.IllegalStateException D = null;
    public int E = 5;
    public final java.util.Set<java.lang.String> F = new java.util.HashSet();

    static {
        resetDefaultExcludes();
    }

    public static boolean addDefaultExclude(java.lang.String str) {
        boolean add;
        java.util.Set<java.lang.String> set = J;
        synchronized (set) {
            add = set.add(str);
        }
        return add;
    }

    public static java.lang.String[] getDefaultExcludes() {
        java.lang.String[] strArr;
        java.util.Set<java.lang.String> set = J;
        synchronized (set) {
            strArr = (java.lang.String[]) set.toArray(new java.lang.String[set.size()]);
        }
        return strArr;
    }

    public static boolean match(java.lang.String str, java.lang.String str2) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.match(str, str2);
    }

    public static boolean match(java.lang.String str, java.lang.String str2, boolean z) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.match(str, str2, z);
    }

    public static boolean matchPath(java.lang.String str, java.lang.String str2) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.matchPath(str, str2);
    }

    public static boolean matchPath(java.lang.String str, java.lang.String str2, boolean z) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.matchPath(str, str2, z);
    }

    public static boolean matchPatternStart(java.lang.String str, java.lang.String str2) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.matchPatternStart(str, str2);
    }

    public static boolean matchPatternStart(java.lang.String str, java.lang.String str2, boolean z) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.matchPatternStart(str, str2, z);
    }

    public static boolean removeDefaultExclude(java.lang.String str) {
        boolean remove;
        java.util.Set<java.lang.String> set = J;
        synchronized (set) {
            remove = set.remove(str);
        }
        return remove;
    }

    public static void resetDefaultExcludes() {
        java.util.Set<java.lang.String> set = J;
        synchronized (set) {
            set.clear();
            int i = 0;
            while (true) {
                java.lang.String[] strArr = DEFAULTEXCLUDES;
                if (i < strArr.length) {
                    J.add(strArr[i]);
                    i++;
                }
            }
        }
    }

    public static java.lang.String s(java.lang.String str) {
        java.lang.String replace = str.replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
        if (!replace.endsWith(java.io.File.separator)) {
            return replace;
        }
        return replace + org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH;
    }

    public final void a(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, java.io.File file, boolean z) {
        t(tokenizedPath, file, this.dirsIncluded, this.dirsExcluded, this.dirsDeselected);
        if (z && j(tokenizedPath) && !i(tokenizedPath)) {
            v(file, tokenizedPath, z);
        }
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized void addDefaultExcludes() {
        java.lang.String[] strArr = this.excludes;
        int length = strArr == null ? 0 : strArr.length;
        java.lang.String[] defaultExcludes = getDefaultExcludes();
        java.lang.String[] strArr2 = new java.lang.String[defaultExcludes.length + length];
        if (length > 0) {
            java.lang.System.arraycopy(this.excludes, 0, strArr2, 0, length);
        }
        for (int i = 0; i < defaultExcludes.length; i++) {
            strArr2[i + length] = defaultExcludes[i].replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
        }
        this.excludes = strArr2;
    }

    public synchronized void addExcludes(java.lang.String[] strArr) {
        if (strArr != null) {
            if (strArr.length > 0) {
                java.lang.String[] strArr2 = this.excludes;
                if (strArr2 == null || strArr2.length <= 0) {
                    setExcludes(strArr);
                } else {
                    java.lang.String[] strArr3 = new java.lang.String[strArr.length + strArr2.length];
                    java.lang.System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
                    for (int i = 0; i < strArr.length; i++) {
                        strArr3[this.excludes.length + i] = s(strArr[i]);
                    }
                    this.excludes = strArr3;
                }
            }
        }
    }

    public final void b(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, java.io.File file, boolean z, java.lang.String[] strArr, java.util.LinkedList<java.lang.String> linkedList) {
        t(tokenizedPath, file, this.dirsIncluded, this.dirsExcluded, this.dirsDeselected);
        if (z && j(tokenizedPath) && !i(tokenizedPath)) {
            w(file, tokenizedPath, z, strArr, linkedList);
        }
    }

    public final void c(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, java.io.File file) {
        t(tokenizedPath, file, this.filesIncluded, this.filesExcluded, this.filesDeselected);
    }

    public synchronized void clearResults() {
        this.filesIncluded = new org.apache.tools.ant.util.VectorSet();
        this.filesNotIncluded = new org.apache.tools.ant.util.VectorSet();
        this.filesExcluded = new org.apache.tools.ant.util.VectorSet();
        this.filesDeselected = new org.apache.tools.ant.util.VectorSet();
        this.dirsIncluded = new org.apache.tools.ant.util.VectorSet();
        this.dirsNotIncluded = new org.apache.tools.ant.util.VectorSet();
        this.dirsExcluded = new org.apache.tools.ant.util.VectorSet();
        this.dirsDeselected = new org.apache.tools.ant.util.VectorSet();
        this.everythingIncluded = this.basedir != null;
        this.t.clear();
        this.F.clear();
    }

    public boolean couldHoldIncluded(java.lang.String str) {
        return j(new org.apache.tools.ant.types.selectors.TokenizedPath(str));
    }

    public final void d(java.lang.String str, java.io.File file) {
        e(new org.apache.tools.ant.types.selectors.TokenizedPath(str), file);
    }

    public final void e(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, java.io.File file) {
        if (p(tokenizedPath)) {
            return;
        }
        if (q(tokenizedPath) || (file.isDirectory() && j(tokenizedPath) && !i(tokenizedPath))) {
            this.F.add(file.getAbsolutePath());
        }
    }

    public final boolean f(java.lang.String str, java.io.File file, java.util.LinkedList<java.lang.String> linkedList) {
        try {
            if (linkedList.size() < this.E || org.apache.tools.ant.util.CollectionUtils.frequency(linkedList, str) < this.E || !I.isSymbolicLink(file, str)) {
                return false;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.lang.String canonicalPath = H.resolveFile(file, str).getCanonicalPath();
            arrayList.add(canonicalPath);
            java.lang.String str2 = "";
            java.util.Iterator<java.lang.String> it = linkedList.iterator();
            while (it.hasNext()) {
                java.lang.String next = it.next();
                str2 = str2 + "../";
                if (str.equals(next)) {
                    arrayList.add(H.resolveFile(file, str2 + next).getCanonicalPath());
                    if (arrayList.size() > this.E && org.apache.tools.ant.util.CollectionUtils.frequency(arrayList, canonicalPath) > this.E) {
                        return true;
                    }
                }
            }
            return false;
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Caught error while checking for symbolic links", e);
        }
    }

    public final void g() {
        java.io.File canonicalFile;
        java.io.File file;
        java.io.File findFile;
        java.io.File file2;
        l();
        java.util.HashMap hashMap = new java.util.HashMap();
        int i = 0;
        while (true) {
            org.apache.tools.ant.types.selectors.TokenizedPattern[] tokenizedPatternArr = this.w;
            if (i >= tokenizedPatternArr.length) {
                break;
            }
            java.lang.String tokenizedPattern = tokenizedPatternArr[i].toString();
            if (!x(tokenizedPattern)) {
                hashMap.put(this.w[i].rtrimWildcardTokens(), tokenizedPattern);
            }
            i++;
        }
        for (java.util.Map.Entry<java.lang.String, org.apache.tools.ant.types.selectors.TokenizedPath> entry : this.u.entrySet()) {
            java.lang.String key = entry.getKey();
            if (!x(key)) {
                hashMap.put(entry.getValue(), key);
            }
        }
        if (hashMap.containsKey(org.apache.tools.ant.types.selectors.TokenizedPath.EMPTY_PATH) && (file2 = this.basedir) != null) {
            scandir(file2, "", true);
            return;
        }
        java.io.File file3 = this.basedir;
        if (file3 != null) {
            try {
                canonicalFile = file3.getCanonicalFile();
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException(e);
            }
        } else {
            canonicalFile = null;
        }
        for (java.util.Map.Entry entry2 : hashMap.entrySet()) {
            org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath = (org.apache.tools.ant.types.selectors.TokenizedPath) entry2.getKey();
            java.lang.String tokenizedPath2 = tokenizedPath.toString();
            if (this.basedir != null || org.apache.tools.ant.util.FileUtils.isAbsolutePath(tokenizedPath2)) {
                java.io.File file4 = new java.io.File(this.basedir, tokenizedPath2);
                if (file4.exists()) {
                    try {
                        if ((!(this.basedir == null ? file4.getCanonicalPath() : H.removeLeadingPath(canonicalFile, file4.getCanonicalFile())).equals(tokenizedPath2) || G) && (file4 = tokenizedPath.findFile(this.basedir, true)) != null && (file = this.basedir) != null) {
                            tokenizedPath2 = H.removeLeadingPath(file, file4);
                            if (!tokenizedPath.toString().equals(tokenizedPath2)) {
                                tokenizedPath = new org.apache.tools.ant.types.selectors.TokenizedPath(tokenizedPath2);
                            }
                        }
                    } catch (java.io.IOException e2) {
                        throw new org.apache.tools.ant.BuildException(e2);
                    }
                }
                if ((file4 == null || !file4.exists()) && !isCaseSensitive() && (findFile = tokenizedPath.findFile(this.basedir, false)) != null && findFile.exists()) {
                    java.io.File file5 = this.basedir;
                    tokenizedPath2 = file5 == null ? findFile.getAbsolutePath() : H.removeLeadingPath(file5, findFile);
                    tokenizedPath = new org.apache.tools.ant.types.selectors.TokenizedPath(tokenizedPath2);
                    file4 = findFile;
                }
                if (file4 != null && file4.exists()) {
                    if (!this.n && tokenizedPath.isSymlink(this.basedir)) {
                        e(tokenizedPath, file4);
                    } else if (file4.isDirectory()) {
                        if (!q(tokenizedPath) || tokenizedPath2.length() <= 0) {
                            v(file4, tokenizedPath, true);
                        } else {
                            a(tokenizedPath, file4, true);
                        }
                    } else if (file4.isFile()) {
                        java.lang.String str = (java.lang.String) entry2.getValue();
                        if (isCaseSensitive() ? str.equals(tokenizedPath2) : str.equalsIgnoreCase(tokenizedPath2)) {
                            c(tokenizedPath, file4);
                        }
                    }
                }
            }
        }
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized java.io.File getBasedir() {
        return this.basedir;
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorScanner
    public synchronized java.lang.String[] getDeselectedDirectories() {
        java.lang.String[] strArr;
        slowScan();
        strArr = new java.lang.String[this.dirsDeselected.size()];
        this.dirsDeselected.copyInto(strArr);
        return strArr;
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorScanner
    public synchronized java.lang.String[] getDeselectedFiles() {
        java.lang.String[] strArr;
        slowScan();
        strArr = new java.lang.String[this.filesDeselected.size()];
        this.filesDeselected.copyInto(strArr);
        return strArr;
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized java.lang.String[] getExcludedDirectories() {
        java.lang.String[] strArr;
        slowScan();
        strArr = new java.lang.String[this.dirsExcluded.size()];
        this.dirsExcluded.copyInto(strArr);
        return strArr;
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized java.lang.String[] getExcludedFiles() {
        java.lang.String[] strArr;
        slowScan();
        strArr = new java.lang.String[this.filesExcluded.size()];
        this.filesExcluded.copyInto(strArr);
        return strArr;
    }

    @Override // org.apache.tools.ant.FileScanner
    public java.lang.String[] getIncludedDirectories() {
        java.lang.String[] strArr;
        synchronized (this) {
            java.util.Vector<java.lang.String> vector = this.dirsIncluded;
            if (vector == null) {
                throw new java.lang.IllegalStateException("Must call scan() first");
            }
            strArr = new java.lang.String[vector.size()];
            this.dirsIncluded.copyInto(strArr);
        }
        java.util.Arrays.sort(strArr);
        return strArr;
    }

    public synchronized int getIncludedDirsCount() {
        java.util.Vector<java.lang.String> vector;
        vector = this.dirsIncluded;
        if (vector == null) {
            throw new java.lang.IllegalStateException("Must call scan() first");
        }
        return vector.size();
    }

    @Override // org.apache.tools.ant.FileScanner
    public java.lang.String[] getIncludedFiles() {
        java.lang.String[] strArr;
        synchronized (this) {
            java.util.Vector<java.lang.String> vector = this.filesIncluded;
            if (vector == null) {
                throw new java.lang.IllegalStateException("Must call scan() first");
            }
            strArr = new java.lang.String[vector.size()];
            this.filesIncluded.copyInto(strArr);
        }
        java.util.Arrays.sort(strArr);
        return strArr;
    }

    public synchronized int getIncludedFilesCount() {
        java.util.Vector<java.lang.String> vector;
        vector = this.filesIncluded;
        if (vector == null) {
            throw new java.lang.IllegalStateException("Must call scan() first");
        }
        return vector.size();
    }

    public synchronized java.lang.String[] getNotFollowedSymlinks() {
        java.lang.String[] strArr;
        synchronized (this) {
            java.util.Set<java.lang.String> set = this.F;
            strArr = (java.lang.String[]) set.toArray(new java.lang.String[set.size()]);
        }
        return strArr;
        java.util.Arrays.sort(strArr);
        return strArr;
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized java.lang.String[] getNotIncludedDirectories() {
        java.lang.String[] strArr;
        slowScan();
        strArr = new java.lang.String[this.dirsNotIncluded.size()];
        this.dirsNotIncluded.copyInto(strArr);
        return strArr;
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized java.lang.String[] getNotIncludedFiles() {
        java.lang.String[] strArr;
        slowScan();
        strArr = new java.lang.String[this.filesNotIncluded.size()];
        this.filesNotIncluded.copyInto(strArr);
        return strArr;
    }

    @Override // org.apache.tools.ant.types.ResourceFactory
    public synchronized org.apache.tools.ant.types.Resource getResource(java.lang.String str) {
        return new org.apache.tools.ant.types.resources.FileResource(this.basedir, str);
    }

    public final synchronized void h() {
        this.u.clear();
        this.v.clear();
        this.w = null;
        this.x = null;
        this.y = false;
    }

    public boolean i(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath) {
        int i = 0;
        while (true) {
            org.apache.tools.ant.types.selectors.TokenizedPattern[] tokenizedPatternArr = this.x;
            if (i >= tokenizedPatternArr.length) {
                return false;
            }
            if (tokenizedPatternArr[i].endsWith(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH) && this.x[i].withoutLastToken().matchPath(tokenizedPath, isCaseSensitive())) {
                return true;
            }
            i++;
        }
    }

    public synchronized boolean isCaseSensitive() {
        return this.isCaseSensitive;
    }

    public synchronized boolean isEverythingIncluded() {
        return this.everythingIncluded;
    }

    public boolean isExcluded(java.lang.String str) {
        return p(new org.apache.tools.ant.types.selectors.TokenizedPath(str));
    }

    public synchronized boolean isFollowSymlinks() {
        return this.n;
    }

    public boolean isIncluded(java.lang.String str) {
        return q(new org.apache.tools.ant.types.selectors.TokenizedPath(str));
    }

    public boolean isSelected(java.lang.String str, java.io.File file) {
        if (this.selectors == null) {
            return true;
        }
        int i = 0;
        while (true) {
            org.apache.tools.ant.types.selectors.FileSelector[] fileSelectorArr = this.selectors;
            if (i >= fileSelectorArr.length) {
                return true;
            }
            if (!fileSelectorArr[i].isSelected(this.basedir, str, file)) {
                return false;
            }
            i++;
        }
    }

    public final boolean j(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath) {
        int i = 0;
        while (true) {
            org.apache.tools.ant.types.selectors.TokenizedPattern[] tokenizedPatternArr = this.w;
            if (i >= tokenizedPatternArr.length) {
                java.util.Iterator<org.apache.tools.ant.types.selectors.TokenizedPath> it = this.u.values().iterator();
                while (it.hasNext()) {
                    if (k(tokenizedPath, it.next().toPattern())) {
                        return true;
                    }
                }
                return false;
            }
            if (k(tokenizedPath, tokenizedPatternArr[i])) {
                return true;
            }
            i++;
        }
    }

    public final boolean k(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, org.apache.tools.ant.types.selectors.TokenizedPattern tokenizedPattern) {
        return tokenizedPattern.matchStartOf(tokenizedPath, isCaseSensitive()) && r(tokenizedPath.toString()) && o(tokenizedPattern, tokenizedPath);
    }

    public synchronized void l() {
        if (!this.y) {
            this.w = m(this.u, this.includes);
            this.x = m(this.v, this.excludes);
            this.y = true;
        }
    }

    public final org.apache.tools.ant.types.selectors.TokenizedPattern[] m(java.util.Map<java.lang.String, org.apache.tools.ant.types.selectors.TokenizedPath> map, java.lang.String[] strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            if (org.apache.tools.ant.types.selectors.SelectorUtils.hasWildcards(strArr[i])) {
                arrayList.add(new org.apache.tools.ant.types.selectors.TokenizedPattern(strArr[i]));
            } else {
                java.lang.String upperCase = isCaseSensitive() ? strArr[i] : strArr[i].toUpperCase();
                map.put(upperCase, new org.apache.tools.ant.types.selectors.TokenizedPath(upperCase));
            }
        }
        return (org.apache.tools.ant.types.selectors.TokenizedPattern[]) arrayList.toArray(new org.apache.tools.ant.types.selectors.TokenizedPattern[arrayList.size()]);
    }

    public final boolean n(java.lang.String str) {
        return !this.t.add(str);
    }

    public final boolean o(org.apache.tools.ant.types.selectors.TokenizedPattern tokenizedPattern, org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath) {
        return tokenizedPattern.containsPattern(org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH) || tokenizedPattern.depth() > tokenizedPath.depth();
    }

    public final boolean p(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath) {
        l();
        if (!isCaseSensitive() ? !this.v.containsKey(tokenizedPath.toString().toUpperCase()) : !this.v.containsKey(tokenizedPath.toString())) {
            return true;
        }
        int i = 0;
        while (true) {
            org.apache.tools.ant.types.selectors.TokenizedPattern[] tokenizedPatternArr = this.x;
            if (i >= tokenizedPatternArr.length) {
                return false;
            }
            if (tokenizedPatternArr[i].matchPath(tokenizedPath, isCaseSensitive())) {
                return true;
            }
            i++;
        }
    }

    public final boolean q(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath) {
        l();
        if (!isCaseSensitive() ? !this.u.containsKey(tokenizedPath.toString().toUpperCase()) : !this.u.containsKey(tokenizedPath.toString())) {
            return true;
        }
        int i = 0;
        while (true) {
            org.apache.tools.ant.types.selectors.TokenizedPattern[] tokenizedPatternArr = this.w;
            if (i >= tokenizedPatternArr.length) {
                return false;
            }
            if (tokenizedPatternArr[i].matchPath(tokenizedPath, isCaseSensitive())) {
                return true;
            }
            i++;
        }
    }

    public final boolean r(java.lang.String str) {
        java.lang.String str2 = str + java.io.File.separatorChar + org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH;
        int i = 0;
        while (true) {
            org.apache.tools.ant.types.selectors.TokenizedPattern[] tokenizedPatternArr = this.x;
            if (i >= tokenizedPatternArr.length) {
                return true;
            }
            if (tokenizedPatternArr[i].toString().equals(str2)) {
                return false;
            }
            i++;
        }
    }

    @Override // org.apache.tools.ant.FileScanner
    public void scan() throws java.lang.IllegalStateException {
        synchronized (this.A) {
            if (this.z) {
                while (this.z) {
                    try {
                        this.A.wait();
                    } catch (java.lang.InterruptedException unused) {
                    }
                }
                java.lang.IllegalStateException illegalStateException = this.D;
                if (illegalStateException != null) {
                    throw illegalStateException;
                }
                return;
            }
            boolean z = true;
            this.z = true;
            java.io.File file = this.basedir;
            try {
                try {
                    synchronized (this) {
                        java.lang.String[] strArr = null;
                        this.D = null;
                        clearResults();
                        java.lang.String[] strArr2 = this.includes;
                        boolean z2 = strArr2 == null;
                        if (z2) {
                            strArr2 = new java.lang.String[]{org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH};
                        }
                        this.includes = strArr2;
                        java.lang.String[] strArr3 = this.excludes;
                        if (strArr3 != null) {
                            z = false;
                        }
                        if (z) {
                            strArr3 = new java.lang.String[0];
                        }
                        this.excludes = strArr3;
                        java.io.File file2 = this.basedir;
                        if (file2 != null && !this.n && I.isSymbolicLink(file2)) {
                            this.F.add(this.basedir.getAbsolutePath());
                            this.basedir = null;
                        }
                        java.io.File file3 = this.basedir;
                        if (file3 != null) {
                            if (file3.exists()) {
                                if (!this.basedir.isDirectory()) {
                                    this.D = new java.lang.IllegalStateException("basedir " + this.basedir + " is not a directory.");
                                }
                            } else {
                                if (!this.errorOnMissingDir) {
                                    this.basedir = file;
                                    synchronized (this.A) {
                                        this.z = false;
                                        this.A.notifyAll();
                                    }
                                    return;
                                }
                                this.D = new java.lang.IllegalStateException("basedir " + this.basedir + DOES_NOT_EXIST_POSTFIX);
                            }
                            java.lang.IllegalStateException illegalStateException2 = this.D;
                            if (illegalStateException2 != null) {
                                throw illegalStateException2;
                            }
                        } else if (z2) {
                            this.basedir = file;
                            synchronized (this.A) {
                                this.z = false;
                                this.A.notifyAll();
                            }
                            return;
                        }
                        org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath = org.apache.tools.ant.types.selectors.TokenizedPath.EMPTY_PATH;
                        if (!q(tokenizedPath)) {
                            this.dirsNotIncluded.addElement("");
                        } else if (p(tokenizedPath)) {
                            this.dirsExcluded.addElement("");
                        } else if (isSelected("", this.basedir)) {
                            this.dirsIncluded.addElement("");
                        } else {
                            this.dirsDeselected.addElement("");
                        }
                        g();
                        h();
                        this.includes = z2 ? null : this.includes;
                        if (!z) {
                            strArr = this.excludes;
                        }
                        this.excludes = strArr;
                        this.basedir = file;
                        synchronized (this.A) {
                            this.z = false;
                            this.A.notifyAll();
                        }
                    }
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException(e);
                }
            } catch (java.lang.Throwable th) {
                this.basedir = file;
                synchronized (this.A) {
                    this.z = false;
                    this.A.notifyAll();
                    throw th;
                }
            }
        }
    }

    public void scandir(java.io.File file, java.lang.String str, boolean z) {
        v(file, new org.apache.tools.ant.types.selectors.TokenizedPath(str), z);
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized void setBasedir(java.io.File file) {
        this.basedir = file;
    }

    @Override // org.apache.tools.ant.FileScanner
    public void setBasedir(java.lang.String str) {
        setBasedir(str == null ? null : new java.io.File(str.replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar)));
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized void setCaseSensitive(boolean z) {
        this.isCaseSensitive = z;
    }

    public void setErrorOnMissingDir(boolean z) {
        this.errorOnMissingDir = z;
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized void setExcludes(java.lang.String[] strArr) {
        if (strArr == null) {
            this.excludes = null;
        } else {
            this.excludes = new java.lang.String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                this.excludes[i] = s(strArr[i]);
            }
        }
    }

    public synchronized void setFollowSymlinks(boolean z) {
        this.n = z;
    }

    @Override // org.apache.tools.ant.FileScanner
    public synchronized void setIncludes(java.lang.String[] strArr) {
        if (strArr == null) {
            this.includes = null;
        } else {
            this.includes = new java.lang.String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                this.includes[i] = s(strArr[i]);
            }
        }
    }

    public void setMaxLevelsOfSymlinks(int i) {
        this.E = i;
    }

    @Override // org.apache.tools.ant.types.selectors.SelectorScanner
    public synchronized void setSelectors(org.apache.tools.ant.types.selectors.FileSelector[] fileSelectorArr) {
        this.selectors = fileSelectorArr;
    }

    public void slowScan() {
        synchronized (this.C) {
            if (this.haveSlowResults) {
                return;
            }
            if (this.B) {
                while (this.B) {
                    try {
                        this.C.wait();
                    } catch (java.lang.InterruptedException unused) {
                    }
                }
                return;
            }
            this.B = true;
            try {
                synchronized (this) {
                    java.lang.String[] strArr = this.includes;
                    boolean z = strArr == null;
                    if (z) {
                        strArr = new java.lang.String[]{org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH};
                    }
                    this.includes = strArr;
                    java.lang.String[] strArr2 = this.excludes;
                    boolean z2 = strArr2 == null;
                    if (z2) {
                        strArr2 = new java.lang.String[0];
                    }
                    this.excludes = strArr2;
                    java.lang.String[] strArr3 = new java.lang.String[this.dirsExcluded.size()];
                    this.dirsExcluded.copyInto(strArr3);
                    java.lang.String[] strArr4 = new java.lang.String[this.dirsNotIncluded.size()];
                    this.dirsNotIncluded.copyInto(strArr4);
                    l();
                    u(strArr3);
                    u(strArr4);
                    h();
                    java.lang.String[] strArr5 = null;
                    this.includes = z ? null : this.includes;
                    if (!z2) {
                        strArr5 = this.excludes;
                    }
                    this.excludes = strArr5;
                }
                synchronized (this.C) {
                    this.haveSlowResults = true;
                    this.B = false;
                    this.C.notifyAll();
                }
            } catch (java.lang.Throwable th) {
                synchronized (this.C) {
                    this.haveSlowResults = true;
                    this.B = false;
                    this.C.notifyAll();
                    throw th;
                }
            }
        }
    }

    public final void t(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, java.io.File file, java.util.Vector<java.lang.String> vector, java.util.Vector<java.lang.String> vector2, java.util.Vector<java.lang.String> vector3) {
        boolean z;
        java.lang.String tokenizedPath2 = tokenizedPath.toString();
        if (vector.contains(tokenizedPath2) || vector2.contains(tokenizedPath2) || vector3.contains(tokenizedPath2)) {
            return;
        }
        if (p(tokenizedPath)) {
            vector2.add(tokenizedPath2);
        } else {
            if (isSelected(tokenizedPath2, file)) {
                vector.add(tokenizedPath2);
                z = true;
                this.everythingIncluded = z & this.everythingIncluded;
            }
            vector3.add(tokenizedPath2);
        }
        z = false;
        this.everythingIncluded = z & this.everythingIncluded;
    }

    public final void u(java.lang.String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath = new org.apache.tools.ant.types.selectors.TokenizedPath(strArr[i]);
            if (!j(tokenizedPath) || i(tokenizedPath)) {
                v(new java.io.File(this.basedir, strArr[i]), tokenizedPath, false);
            }
        }
    }

    public final void v(java.io.File file, org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, boolean z) {
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("dir must not be null.");
        }
        java.lang.String[] list = file.list();
        if (list != null) {
            w(file, tokenizedPath, z, list, new java.util.LinkedList<>());
            return;
        }
        if (!file.exists()) {
            throw new org.apache.tools.ant.BuildException(file + DOES_NOT_EXIST_POSTFIX);
        }
        if (!file.isDirectory()) {
            throw new org.apache.tools.ant.BuildException(file + " is not a directory.");
        }
        throw new org.apache.tools.ant.BuildException("IO error scanning directory '" + file.getAbsolutePath() + "'");
    }

    public final void w(java.io.File file, org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, boolean z, java.lang.String[] strArr, java.util.LinkedList<java.lang.String> linkedList) {
        java.lang.String[] strArr2;
        java.io.File file2;
        java.lang.String[] strArr3 = strArr;
        java.lang.String tokenizedPath2 = tokenizedPath.toString();
        if (tokenizedPath2.length() > 0) {
            java.lang.String str = java.io.File.separator;
            if (!tokenizedPath2.endsWith(str)) {
                tokenizedPath2 = tokenizedPath2 + str;
            }
        }
        java.lang.String str2 = tokenizedPath2;
        if (z && n(str2)) {
            return;
        }
        if (this.n) {
            linkedList.addFirst(file.getName());
        } else {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str3 : strArr3) {
                try {
                    if (I.isSymbolicLink(file, str3)) {
                        java.lang.String str4 = str2 + str3;
                        java.io.File file3 = new java.io.File(file, str3);
                        if (file3.isDirectory()) {
                            this.dirsExcluded.addElement(str4);
                        } else if (file3.isFile()) {
                            this.filesExcluded.addElement(str4);
                        }
                        d(str4, file3);
                    } else {
                        arrayList.add(str3);
                    }
                } catch (java.io.IOException unused) {
                    java.lang.System.err.println("IOException caught while checking for links, couldn't get canonical path!");
                    arrayList.add(str3);
                }
            }
            strArr3 = (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
        }
        for (java.lang.String str5 : strArr3) {
            java.lang.String str6 = str2 + str5;
            org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath3 = new org.apache.tools.ant.types.selectors.TokenizedPath(tokenizedPath, str5);
            java.io.File file4 = new java.io.File(file, str5);
            java.lang.String[] list = file4.list();
            if (list == null || (list.length == 0 && file4.isFile())) {
                if (q(tokenizedPath3)) {
                    c(tokenizedPath3, file4);
                } else {
                    this.everythingIncluded = false;
                    this.filesNotIncluded.addElement(str6);
                }
            } else if (file4.isDirectory()) {
                if (this.n && f(str5, file, linkedList)) {
                    java.lang.System.err.println("skipping symbolic link " + file4.getAbsolutePath() + " -- too many levels of symbolic links.");
                    this.F.add(file4.getAbsolutePath());
                } else {
                    if (q(tokenizedPath3)) {
                        strArr2 = list;
                        file2 = file4;
                        b(tokenizedPath3, file4, z, list, linkedList);
                    } else {
                        strArr2 = list;
                        file2 = file4;
                        this.everythingIncluded = false;
                        this.dirsNotIncluded.addElement(str6);
                        if (z && j(tokenizedPath3) && !i(tokenizedPath3)) {
                            w(file2, tokenizedPath3, z, strArr2, linkedList);
                        }
                    }
                    if (!z) {
                        w(file2, tokenizedPath3, z, strArr2, linkedList);
                    }
                }
            }
        }
        if (this.n) {
            linkedList.removeFirst();
        }
    }

    public final boolean x(java.lang.String str) {
        if (!org.apache.tools.ant.util.FileUtils.isAbsolutePath(str)) {
            return this.basedir == null;
        }
        java.io.File file = this.basedir;
        return (file == null || org.apache.tools.ant.types.selectors.SelectorUtils.matchPatternStart(str, file.getAbsolutePath(), isCaseSensitive())) ? false : true;
    }
}
