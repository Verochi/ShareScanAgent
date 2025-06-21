package org.apache.tools.ant.util.regexp;

/* loaded from: classes26.dex */
public class RegexpMatcherFactory {
    public static boolean regexpMatcherPresent(org.apache.tools.ant.Project project) {
        try {
            new org.apache.tools.ant.util.regexp.RegexpMatcherFactory().newRegexpMatcher(project);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public org.apache.tools.ant.util.regexp.RegexpMatcher createInstance(java.lang.String str) throws org.apache.tools.ant.BuildException {
        return (org.apache.tools.ant.util.regexp.RegexpMatcher) org.apache.tools.ant.util.ClasspathUtils.newInstance(str, org.apache.tools.ant.util.regexp.RegexpMatcherFactory.class.getClassLoader(), org.apache.tools.ant.util.regexp.RegexpMatcher.class);
    }

    public org.apache.tools.ant.util.regexp.RegexpMatcher newRegexpMatcher() throws org.apache.tools.ant.BuildException {
        return newRegexpMatcher(null);
    }

    public org.apache.tools.ant.util.regexp.RegexpMatcher newRegexpMatcher(org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        java.lang.String property = project == null ? java.lang.System.getProperty(org.apache.tools.ant.MagicNames.REGEXP_IMPL) : project.getProperty(org.apache.tools.ant.MagicNames.REGEXP_IMPL);
        return property != null ? createInstance(property) : new org.apache.tools.ant.util.regexp.Jdk14RegexpMatcher();
    }

    public void testAvailability(java.lang.String str) throws org.apache.tools.ant.BuildException {
        try {
            java.lang.Class.forName(str);
        } catch (java.lang.Throwable th) {
            throw new org.apache.tools.ant.BuildException(th);
        }
    }
}
