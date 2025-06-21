package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class RegexpPatternMapper implements org.apache.tools.ant.util.FileNameMapper {
    protected org.apache.tools.ant.util.regexp.RegexpMatcher reg;
    protected char[] to = null;
    protected java.lang.StringBuffer result = new java.lang.StringBuffer();
    public boolean n = false;
    public int t = 0;

    public RegexpPatternMapper() throws org.apache.tools.ant.BuildException {
        this.reg = null;
        this.reg = new org.apache.tools.ant.util.regexp.RegexpMatcherFactory().newRegexpMatcher();
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (this.n && str.contains("\\")) {
            str = str.replace('\\', '/');
        }
        org.apache.tools.ant.util.regexp.RegexpMatcher regexpMatcher = this.reg;
        if (regexpMatcher == null || this.to == null || !regexpMatcher.matches(str, this.t)) {
            return null;
        }
        return new java.lang.String[]{replaceReferences(str)};
    }

    public java.lang.String replaceReferences(java.lang.String str) {
        java.util.Vector groups = this.reg.getGroups(str, this.t);
        this.result.setLength(0);
        int i = 0;
        while (true) {
            char[] cArr = this.to;
            if (i >= cArr.length) {
                return this.result.substring(0);
            }
            char c = cArr[i];
            if (c == '\\') {
                i++;
                if (i < cArr.length) {
                    int digit = java.lang.Character.digit(cArr[i], 10);
                    if (digit > -1) {
                        this.result.append((java.lang.String) groups.elementAt(digit));
                    } else {
                        this.result.append(this.to[i]);
                    }
                } else {
                    this.result.append('\\');
                }
            } else {
                this.result.append(c);
            }
            i++;
        }
    }

    public void setCaseSensitive(boolean z) {
        this.t = org.apache.tools.ant.util.regexp.RegexpUtil.asOptions(z);
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setFrom(java.lang.String str) throws org.apache.tools.ant.BuildException {
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("this mapper requires a 'from' attribute");
        }
        try {
            this.reg.setPattern(str);
        } catch (java.lang.NoClassDefFoundError e) {
            throw new org.apache.tools.ant.BuildException("Cannot load regular expression matcher", e);
        }
    }

    public void setHandleDirSep(boolean z) {
        this.n = z;
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setTo(java.lang.String str) {
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("this mapper requires a 'to' attribute");
        }
        this.to = str.toCharArray();
    }
}
