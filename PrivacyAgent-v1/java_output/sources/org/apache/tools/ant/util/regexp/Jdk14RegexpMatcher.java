package org.apache.tools.ant.util.regexp;

/* loaded from: classes26.dex */
public class Jdk14RegexpMatcher implements org.apache.tools.ant.util.regexp.RegexpMatcher {
    public java.lang.String a;

    public java.util.regex.Pattern getCompiledPattern(int i) throws org.apache.tools.ant.BuildException {
        try {
            return java.util.regex.Pattern.compile(this.a, getCompilerOptions(i));
        } catch (java.util.regex.PatternSyntaxException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public int getCompilerOptions(int i) {
        int i2 = org.apache.tools.ant.util.regexp.RegexpUtil.hasFlag(i, 256) ? 3 : 1;
        if (org.apache.tools.ant.util.regexp.RegexpUtil.hasFlag(i, 4096)) {
            i2 |= 8;
        }
        return org.apache.tools.ant.util.regexp.RegexpUtil.hasFlag(i, 65536) ? i2 | 32 : i2;
    }

    @Override // org.apache.tools.ant.util.regexp.RegexpMatcher
    public java.util.Vector getGroups(java.lang.String str) throws org.apache.tools.ant.BuildException {
        return getGroups(str, 0);
    }

    @Override // org.apache.tools.ant.util.regexp.RegexpMatcher
    public java.util.Vector getGroups(java.lang.String str, int i) throws org.apache.tools.ant.BuildException {
        java.util.regex.Matcher matcher = getCompiledPattern(i).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        java.util.Vector vector = new java.util.Vector();
        int groupCount = matcher.groupCount();
        for (int i2 = 0; i2 <= groupCount; i2++) {
            java.lang.String group = matcher.group(i2);
            if (group == null) {
                group = "";
            }
            vector.addElement(group);
        }
        return vector;
    }

    @Override // org.apache.tools.ant.util.regexp.RegexpMatcher
    public java.lang.String getPattern() {
        return this.a;
    }

    @Override // org.apache.tools.ant.util.regexp.RegexpMatcher
    public boolean matches(java.lang.String str) throws org.apache.tools.ant.BuildException {
        return matches(str, 0);
    }

    @Override // org.apache.tools.ant.util.regexp.RegexpMatcher
    public boolean matches(java.lang.String str, int i) throws org.apache.tools.ant.BuildException {
        try {
            return getCompiledPattern(i).matcher(str).find();
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    @Override // org.apache.tools.ant.util.regexp.RegexpMatcher
    public void setPattern(java.lang.String str) {
        this.a = str;
    }
}
