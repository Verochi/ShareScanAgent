package org.apache.tools.ant.util.regexp;

/* loaded from: classes26.dex */
public interface RegexpMatcher {
    public static final int MATCH_CASE_INSENSITIVE = 256;
    public static final int MATCH_DEFAULT = 0;
    public static final int MATCH_MULTILINE = 4096;
    public static final int MATCH_SINGLELINE = 65536;

    java.util.Vector getGroups(java.lang.String str) throws org.apache.tools.ant.BuildException;

    java.util.Vector getGroups(java.lang.String str, int i) throws org.apache.tools.ant.BuildException;

    java.lang.String getPattern() throws org.apache.tools.ant.BuildException;

    boolean matches(java.lang.String str) throws org.apache.tools.ant.BuildException;

    boolean matches(java.lang.String str, int i) throws org.apache.tools.ant.BuildException;

    void setPattern(java.lang.String str) throws org.apache.tools.ant.BuildException;
}
