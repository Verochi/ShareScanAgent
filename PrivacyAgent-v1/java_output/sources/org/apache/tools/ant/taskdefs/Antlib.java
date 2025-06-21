package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Antlib extends org.apache.tools.ant.Task implements org.apache.tools.ant.TaskContainer {
    public static final java.lang.String TAG = "antlib";
    public java.lang.ClassLoader u;
    public java.lang.String v = "";
    public java.util.List<java.lang.Object> w = new java.util.ArrayList();

    public static org.apache.tools.ant.taskdefs.Antlib createAntlib(org.apache.tools.ant.Project project, java.net.URL url, java.lang.String str) {
        try {
            java.net.URLConnection openConnection = url.openConnection();
            openConnection.setUseCaches(false);
            openConnection.connect();
            org.apache.tools.ant.ComponentHelper componentHelper = org.apache.tools.ant.ComponentHelper.getComponentHelper(project);
            componentHelper.enterAntLib(str);
            org.apache.tools.ant.types.resources.URLResource uRLResource = new org.apache.tools.ant.types.resources.URLResource(url);
            try {
                java.lang.Object reference = project.getReference("ant.projectHelper");
                org.apache.tools.ant.ProjectHelper projectHelper = null;
                if (reference instanceof org.apache.tools.ant.ProjectHelper) {
                    org.apache.tools.ant.ProjectHelper projectHelper2 = (org.apache.tools.ant.ProjectHelper) reference;
                    if (projectHelper2.canParseAntlibDescriptor(uRLResource)) {
                        projectHelper = projectHelper2;
                    }
                }
                if (projectHelper == null) {
                    projectHelper = org.apache.tools.ant.ProjectHelperRepository.getInstance().getProjectHelperForAntlib(uRLResource);
                }
                org.apache.tools.ant.UnknownElement parseAntlibDescriptor = projectHelper.parseAntlibDescriptor(project, uRLResource);
                if (!parseAntlibDescriptor.getTag().equals(TAG)) {
                    throw new org.apache.tools.ant.BuildException("Unexpected tag " + parseAntlibDescriptor.getTag() + " expecting " + TAG, parseAntlibDescriptor.getLocation());
                }
                org.apache.tools.ant.taskdefs.Antlib antlib = new org.apache.tools.ant.taskdefs.Antlib();
                antlib.setProject(project);
                antlib.setLocation(parseAntlibDescriptor.getLocation());
                antlib.setTaskName(TAG);
                antlib.init();
                parseAntlibDescriptor.configure(antlib);
                return antlib;
            } finally {
                componentHelper.exitAntLib();
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Unable to find " + url, e);
        }
    }

    @Override // org.apache.tools.ant.TaskContainer
    public void addTask(org.apache.tools.ant.Task task) {
        this.w.add(task);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        java.util.Iterator<java.lang.Object> it = this.w.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.UnknownElement unknownElement = (org.apache.tools.ant.UnknownElement) it.next();
            setLocation(unknownElement.getLocation());
            unknownElement.maybeConfigure();
            java.lang.Object realThing = unknownElement.getRealThing();
            if (realThing != null) {
                if (!(realThing instanceof org.apache.tools.ant.taskdefs.AntlibDefinition)) {
                    throw new org.apache.tools.ant.BuildException("Invalid task in antlib " + unknownElement.getTag() + " " + realThing.getClass() + " does not extend org.apache.tools.ant.taskdefs.AntlibDefinition");
                }
                org.apache.tools.ant.taskdefs.AntlibDefinition antlibDefinition = (org.apache.tools.ant.taskdefs.AntlibDefinition) realThing;
                antlibDefinition.setURI(this.v);
                antlibDefinition.setAntlibClassLoader(getClassLoader());
                antlibDefinition.init();
                antlibDefinition.execute();
            }
        }
    }

    public final java.lang.ClassLoader getClassLoader() {
        if (this.u == null) {
            this.u = org.apache.tools.ant.taskdefs.Antlib.class.getClassLoader();
        }
        return this.u;
    }

    public void setClassLoader(java.lang.ClassLoader classLoader) {
        this.u = classLoader;
    }

    public void setURI(java.lang.String str) {
        this.v = str;
    }
}
