package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class TokenizedPath {
    public static final org.apache.tools.ant.types.selectors.TokenizedPath EMPTY_PATH = new org.apache.tools.ant.types.selectors.TokenizedPath("", new java.lang.String[0]);
    public static final org.apache.tools.ant.util.FileUtils c = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final org.apache.tools.ant.util.SymbolicLinkUtils d = org.apache.tools.ant.util.SymbolicLinkUtils.getSymbolicLinkUtils();
    public static final boolean[] e = {true};
    public static final boolean[] f = {true, false};
    public final java.lang.String a;
    public final java.lang.String[] b;

    public TokenizedPath(java.lang.String str) {
        this(str, org.apache.tools.ant.types.selectors.SelectorUtils.e(str));
    }

    public TokenizedPath(java.lang.String str, java.lang.String[] strArr) {
        this.a = str;
        this.b = strArr;
    }

    public TokenizedPath(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, java.lang.String str) {
        if (tokenizedPath.a.length() > 0) {
            if (tokenizedPath.a.charAt(r0.length() - 1) != java.io.File.separatorChar) {
                this.a = tokenizedPath.a + java.io.File.separatorChar + str;
                java.lang.String[] strArr = new java.lang.String[tokenizedPath.b.length + 1];
                this.b = strArr;
                java.lang.String[] strArr2 = tokenizedPath.b;
                java.lang.System.arraycopy(strArr2, 0, strArr, 0, strArr2.length);
                strArr[tokenizedPath.b.length] = str;
            }
        }
        this.a = tokenizedPath.a + str;
        java.lang.String[] strArr3 = new java.lang.String[tokenizedPath.b.length + 1];
        this.b = strArr3;
        java.lang.String[] strArr22 = tokenizedPath.b;
        java.lang.System.arraycopy(strArr22, 0, strArr3, 0, strArr22.length);
        strArr3[tokenizedPath.b.length] = str;
    }

    public static java.io.File a(java.io.File file, java.lang.String[] strArr, boolean z) {
        int i;
        for (java.lang.String str : strArr) {
            if (!file.isDirectory()) {
                return null;
            }
            java.lang.String[] list = file.list();
            if (list == null) {
                throw new org.apache.tools.ant.BuildException("IO error scanning directory " + file.getAbsolutePath());
            }
            boolean[] zArr = z ? e : f;
            boolean z2 = false;
            for (int i2 = 0; !z2 && i2 < zArr.length; i2++) {
                while (!z2 && i < list.length) {
                    if (zArr[i2]) {
                        i = list[i].equals(str) ? 0 : i + 1;
                        file = new java.io.File(file, list[i]);
                        z2 = true;
                    } else {
                        if (!list[i].equalsIgnoreCase(str)) {
                        }
                        file = new java.io.File(file, list[i]);
                        z2 = true;
                    }
                }
            }
            if (!z2) {
                return null;
            }
        }
        if (strArr.length != 0 || file.isDirectory()) {
            return file;
        }
        return null;
    }

    public java.lang.String[] b() {
        return this.b;
    }

    public int depth() {
        return this.b.length;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof org.apache.tools.ant.types.selectors.TokenizedPath) && this.a.equals(((org.apache.tools.ant.types.selectors.TokenizedPath) obj).a);
    }

    public java.io.File findFile(java.io.File file, boolean z) {
        java.lang.String[] strArr = this.b;
        if (org.apache.tools.ant.util.FileUtils.isAbsolutePath(this.a)) {
            if (file == null) {
                java.lang.String[] dissect = c.dissect(this.a);
                java.io.File file2 = new java.io.File(dissect[0]);
                strArr = org.apache.tools.ant.types.selectors.SelectorUtils.e(dissect[1]);
                file = file2;
            } else {
                org.apache.tools.ant.util.FileUtils fileUtils = c;
                java.io.File normalize = fileUtils.normalize(this.a);
                java.lang.String removeLeadingPath = fileUtils.removeLeadingPath(file, normalize);
                if (removeLeadingPath.equals(normalize.getAbsolutePath())) {
                    return null;
                }
                strArr = org.apache.tools.ant.types.selectors.SelectorUtils.e(removeLeadingPath);
            }
        }
        return a(file, strArr, z);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean isSymlink(java.io.File file) {
        for (java.lang.String str : this.b) {
            if (file != null) {
                try {
                    if (d.isSymbolicLink(file, str)) {
                        return true;
                    }
                } catch (java.io.IOException unused) {
                    java.lang.System.err.println("IOException caught while checking for links, couldn't get canonical path!");
                }
            }
            if (file == null && d.isSymbolicLink(str)) {
                return true;
            }
            file = new java.io.File(file, str);
        }
        return false;
    }

    public org.apache.tools.ant.types.selectors.TokenizedPattern toPattern() {
        return new org.apache.tools.ant.types.selectors.TokenizedPattern(this.a, this.b);
    }

    public java.lang.String toString() {
        return this.a;
    }
}
