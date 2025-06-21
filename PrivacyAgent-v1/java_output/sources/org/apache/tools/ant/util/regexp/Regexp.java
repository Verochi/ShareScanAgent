package org.apache.tools.ant.util.regexp;

/* loaded from: classes26.dex */
public interface Regexp extends org.apache.tools.ant.util.regexp.RegexpMatcher {
    public static final int REPLACE_ALL = 16;
    public static final int REPLACE_FIRST = 1;

    java.lang.String substitute(java.lang.String str, java.lang.String str2, int i) throws org.apache.tools.ant.BuildException;
}
