package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class ProjectHelper {
    public static final java.lang.String ANTLIB_URI = "antlib:";
    public static final java.lang.String ANT_ATTRIBUTE_URI = "ant:attribute";
    public static final java.lang.String ANT_CORE_URI = "antlib:org.apache.tools.ant";
    public static final java.lang.String ANT_CURRENT_URI = "ant:current";
    public static final java.lang.String ANT_TYPE = "ant-type";
    public static final java.lang.String HELPER_PROPERTY = "org.apache.tools.ant.ProjectHelper";
    public static final java.lang.String PROJECTHELPER_REFERENCE = "ant.projectHelper";
    public static final java.lang.String SERVICE_ID = "META-INF/services/org.apache.tools.ant.ProjectHelper";
    public static final java.lang.String USE_PROJECT_NAME_AS_TARGET_PREFIX = "USE_PROJECT_NAME_AS_TARGET_PREFIX";
    public static final java.lang.ThreadLocal<java.lang.String> c = new java.lang.ThreadLocal<>();
    public static final java.lang.ThreadLocal<java.lang.String> d = new org.apache.tools.ant.ProjectHelper.AnonymousClass1();
    public static final java.lang.ThreadLocal<java.lang.Boolean> e = new org.apache.tools.ant.ProjectHelper.AnonymousClass2();
    public java.util.Vector<java.lang.Object> a = new java.util.Vector<>();
    public java.util.List<java.lang.String[]> b = new java.util.LinkedList();

    /* renamed from: org.apache.tools.ant.ProjectHelper$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.ThreadLocal<java.lang.String> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.String initialValue() {
            return ".";
        }
    }

    /* renamed from: org.apache.tools.ant.ProjectHelper$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.lang.ThreadLocal<java.lang.Boolean> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Boolean initialValue() {
            return java.lang.Boolean.FALSE;
        }
    }

    public static final class OnMissingExtensionPoint {
        public static final org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint FAIL;
        public static final org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint IGNORE;
        public static final org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint WARN;
        public static final org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint[] b;
        public final java.lang.String a;

        static {
            org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint onMissingExtensionPoint = new org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint("fail");
            FAIL = onMissingExtensionPoint;
            org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint onMissingExtensionPoint2 = new org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint("warn");
            WARN = onMissingExtensionPoint2;
            org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint onMissingExtensionPoint3 = new org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
            IGNORE = onMissingExtensionPoint3;
            b = new org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint[]{onMissingExtensionPoint, onMissingExtensionPoint2, onMissingExtensionPoint3};
        }

        public OnMissingExtensionPoint(java.lang.String str) {
            this.a = str;
        }

        public static org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint valueOf(java.lang.String str) {
            str.getClass();
            for (org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint onMissingExtensionPoint : b) {
                if (str.equals(onMissingExtensionPoint.name())) {
                    return onMissingExtensionPoint;
                }
            }
            throw new java.lang.IllegalArgumentException("Unknown onMissingExtensionPoint " + str);
        }

        public java.lang.String name() {
            return this.a;
        }

        public java.lang.String toString() {
            return this.a;
        }
    }

    public static org.apache.tools.ant.BuildException addLocationToBuildException(org.apache.tools.ant.BuildException buildException, org.apache.tools.ant.Location location) {
        if (buildException.getLocation() == null || buildException.getMessage() == null) {
            return buildException;
        }
        java.lang.String str = "The following error occurred while executing this line:" + java.lang.System.getProperty("line.separator") + buildException.getLocation().toString() + buildException.getMessage();
        if (!(buildException instanceof org.apache.tools.ant.ExitStatusException)) {
            return location == null ? new org.apache.tools.ant.BuildException(str, buildException) : new org.apache.tools.ant.BuildException(str, buildException, location);
        }
        int status = ((org.apache.tools.ant.ExitStatusException) buildException).getStatus();
        return location == null ? new org.apache.tools.ant.ExitStatusException(str, status) : new org.apache.tools.ant.ExitStatusException(str, status, location);
    }

    public static void addText(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws org.apache.tools.ant.BuildException {
        if (str == null) {
            return;
        }
        if (obj instanceof org.apache.tools.ant.TypeAdapter) {
            obj = ((org.apache.tools.ant.TypeAdapter) obj).getProxy();
        }
        org.apache.tools.ant.IntrospectionHelper.getHelper(project, obj.getClass()).addText(project, obj, str);
    }

    public static void addText(org.apache.tools.ant.Project project, java.lang.Object obj, char[] cArr, int i, int i2) throws org.apache.tools.ant.BuildException {
        addText(project, obj, new java.lang.String(cArr, i, i2));
    }

    @java.lang.Deprecated
    public static void configure(java.lang.Object obj, org.xml.sax.AttributeList attributeList, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (obj instanceof org.apache.tools.ant.TypeAdapter) {
            obj = ((org.apache.tools.ant.TypeAdapter) obj).getProxy();
        }
        org.apache.tools.ant.IntrospectionHelper helper = org.apache.tools.ant.IntrospectionHelper.getHelper(project, obj.getClass());
        int length = attributeList.getLength();
        for (int i = 0; i < length; i++) {
            try {
                helper.setAttribute(project, obj, attributeList.getName(i).toLowerCase(java.util.Locale.ENGLISH), replaceProperties(project, attributeList.getValue(i), project.getProperties()));
            } catch (org.apache.tools.ant.BuildException e2) {
                if (!attributeList.getName(i).equals("id")) {
                    throw e2;
                }
            }
        }
    }

    public static void configureProject(org.apache.tools.ant.Project project, java.io.File file) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.ProjectHelper projectHelperForBuildFile = org.apache.tools.ant.ProjectHelperRepository.getInstance().getProjectHelperForBuildFile(new org.apache.tools.ant.types.resources.FileResource(file));
        project.addReference("ant.projectHelper", projectHelperForBuildFile);
        projectHelperForBuildFile.parse(project, file);
    }

    public static java.lang.String extractNameFromComponentName(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(58);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    public static java.lang.String extractUriFromComponentName(java.lang.String str) {
        int lastIndexOf;
        return (str == null || (lastIndexOf = str.lastIndexOf(58)) == -1) ? "" : str.substring(0, lastIndexOf);
    }

    public static java.lang.String genComponentName(java.lang.String str, java.lang.String str2) {
        if (str == null || str.equals("") || str.equals(ANT_CORE_URI)) {
            return str2;
        }
        return str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2;
    }

    @java.lang.Deprecated
    public static java.lang.ClassLoader getContextClassLoader() {
        if (org.apache.tools.ant.util.LoaderUtils.isContextLoaderAvailable()) {
            return org.apache.tools.ant.util.LoaderUtils.getContextClassLoader();
        }
        return null;
    }

    public static java.lang.String getCurrentPrefixSeparator() {
        return d.get();
    }

    public static java.lang.String getCurrentTargetPrefix() {
        return c.get();
    }

    public static org.apache.tools.ant.ProjectHelper getProjectHelper() {
        return org.apache.tools.ant.ProjectHelperRepository.getInstance().getHelpers().next();
    }

    public static boolean isInIncludeMode() {
        return java.lang.Boolean.TRUE.equals(e.get());
    }

    public static java.lang.String nsToComponentName(java.lang.String str) {
        return "attribute namespace:" + str;
    }

    @java.lang.Deprecated
    public static void parsePropertyString(java.lang.String str, java.util.Vector<java.lang.String> vector, java.util.Vector<java.lang.String> vector2) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.PropertyHelper.c(str, vector, vector2);
    }

    @java.lang.Deprecated
    public static java.lang.String replaceProperties(org.apache.tools.ant.Project project, java.lang.String str) throws org.apache.tools.ant.BuildException {
        return project.replaceProperties(str);
    }

    @java.lang.Deprecated
    public static java.lang.String replaceProperties(org.apache.tools.ant.Project project, java.lang.String str, java.util.Hashtable<java.lang.String, java.lang.Object> hashtable) throws org.apache.tools.ant.BuildException {
        return org.apache.tools.ant.PropertyHelper.getPropertyHelper(project).replaceProperties(null, str, hashtable);
    }

    public static void setCurrentPrefixSeparator(java.lang.String str) {
        d.set(str);
    }

    public static void setCurrentTargetPrefix(java.lang.String str) {
        c.set(str);
    }

    public static void setInIncludeMode(boolean z) {
        e.set(java.lang.Boolean.valueOf(z));
    }

    public static void storeChild(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.Object obj2, java.lang.String str) {
        org.apache.tools.ant.IntrospectionHelper.getHelper(project, obj.getClass()).storeElement(project, obj, obj2, str);
    }

    public boolean canParseAntlibDescriptor(org.apache.tools.ant.types.Resource resource) {
        return false;
    }

    public boolean canParseBuildFile(org.apache.tools.ant.types.Resource resource) {
        return true;
    }

    public java.lang.String getDefaultBuildFile() {
        return org.apache.tools.ant.Main.DEFAULT_BUILD_FILENAME;
    }

    public java.util.List<java.lang.String[]> getExtensionStack() {
        return this.b;
    }

    public java.util.Vector<java.lang.Object> getImportStack() {
        return this.a;
    }

    public void parse(org.apache.tools.ant.Project project, java.lang.Object obj) throws org.apache.tools.ant.BuildException {
        throw new org.apache.tools.ant.BuildException("ProjectHelper.parse() must be implemented in a helper plugin " + getClass().getName());
    }

    public org.apache.tools.ant.UnknownElement parseAntlibDescriptor(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Resource resource) {
        throw new org.apache.tools.ant.BuildException("can't parse antlib descriptors");
    }

    public void resolveExtensionOfAttributes(org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.Target target;
        for (java.lang.String[] strArr : getExtensionStack()) {
            java.lang.String str = strArr[0];
            java.lang.String str2 = strArr[1];
            org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint valueOf = org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint.valueOf(strArr[2]);
            java.lang.String str3 = strArr.length > 3 ? strArr[3] : null;
            java.util.Hashtable<java.lang.String, org.apache.tools.ant.Target> targets = project.getTargets();
            if (str3 == null) {
                target = targets.get(str);
            } else {
                target = targets.get(str3 + str);
                if (target == null) {
                    target = targets.get(str);
                }
            }
            if (target == null) {
                java.lang.String str4 = "can't add target " + str2 + " to extension-point " + str + " because the extension-point is unknown.";
                if (valueOf == org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint.FAIL) {
                    throw new org.apache.tools.ant.BuildException(str4);
                }
                if (valueOf == org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint.WARN) {
                    project.log(targets.get(str2), "Warning: " + str4, 1);
                }
            } else {
                if (!(target instanceof org.apache.tools.ant.ExtensionPoint)) {
                    throw new org.apache.tools.ant.BuildException("referenced target " + str + " is not an extension-point");
                }
                target.addDependency(str2);
            }
        }
    }
}
