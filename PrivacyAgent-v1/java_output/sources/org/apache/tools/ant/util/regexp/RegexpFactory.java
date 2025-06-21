package org.apache.tools.ant.util.regexp;

/* loaded from: classes26.dex */
public class RegexpFactory extends org.apache.tools.ant.util.regexp.RegexpMatcherFactory {
    public org.apache.tools.ant.util.regexp.Regexp createRegexpInstance(java.lang.String str) throws org.apache.tools.ant.BuildException {
        return (org.apache.tools.ant.util.regexp.Regexp) org.apache.tools.ant.util.ClasspathUtils.newInstance(str, org.apache.tools.ant.util.regexp.RegexpFactory.class.getClassLoader(), org.apache.tools.ant.util.regexp.Regexp.class);
    }

    public org.apache.tools.ant.util.regexp.Regexp newRegexp() throws org.apache.tools.ant.BuildException {
        return newRegexp(null);
    }

    public org.apache.tools.ant.util.regexp.Regexp newRegexp(org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        java.lang.String property = project == null ? java.lang.System.getProperty(org.apache.tools.ant.MagicNames.REGEXP_IMPL) : project.getProperty(org.apache.tools.ant.MagicNames.REGEXP_IMPL);
        return property != null ? createRegexpInstance(property) : new org.apache.tools.ant.util.regexp.Jdk14RegexpRegexp();
    }
}
