package org.apache.tools.ant.helper;

/* loaded from: classes25.dex */
public class AntXMLContext {
    public org.apache.tools.ant.Project a;
    public java.io.File b;
    public java.net.URL c;
    public java.io.File e;
    public java.net.URL f;
    public java.lang.String g;
    public org.xml.sax.Locator h;
    public java.util.Vector<org.apache.tools.ant.Target> d = new java.util.Vector<>();
    public org.apache.tools.ant.Target i = new org.apache.tools.ant.Target();
    public org.apache.tools.ant.Target j = null;
    public java.util.Vector<org.apache.tools.ant.RuntimeConfigurable> k = new java.util.Vector<>();
    public boolean l = false;
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> m = new java.util.HashMap();
    public java.util.Map<java.lang.String, org.apache.tools.ant.Target> n = null;

    public AntXMLContext(org.apache.tools.ant.Project project) {
        this.a = project;
        this.i.setProject(project);
        this.i.setName("");
        this.d.addElement(this.i);
    }

    public void addTarget(org.apache.tools.ant.Target target) {
        this.d.addElement(target);
        this.j = target;
    }

    public void configureId(java.lang.Object obj, org.xml.sax.Attributes attributes) {
        java.lang.String value = attributes.getValue("id");
        if (value != null) {
            this.a.addIdReference(value, obj);
        }
    }

    public org.apache.tools.ant.RuntimeConfigurable currentWrapper() {
        if (this.k.size() < 1) {
            return null;
        }
        java.util.Vector<org.apache.tools.ant.RuntimeConfigurable> vector = this.k;
        return vector.elementAt(vector.size() - 1);
    }

    public void endPrefixMapping(java.lang.String str) {
        java.util.List<java.lang.String> list = this.m.get(str);
        if (list == null || list.size() == 0) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public java.io.File getBuildFile() {
        return this.b;
    }

    public java.io.File getBuildFileParent() {
        return this.e;
    }

    public java.net.URL getBuildFileParentURL() {
        return this.f;
    }

    public java.net.URL getBuildFileURL() {
        return this.c;
    }

    public java.lang.String getCurrentProjectName() {
        return this.g;
    }

    public org.apache.tools.ant.Target getCurrentTarget() {
        return this.j;
    }

    public java.util.Map<java.lang.String, org.apache.tools.ant.Target> getCurrentTargets() {
        return this.n;
    }

    public org.apache.tools.ant.Target getImplicitTarget() {
        return this.i;
    }

    public org.xml.sax.Locator getLocator() {
        return this.h;
    }

    public java.lang.String getPrefixMapping(java.lang.String str) {
        java.util.List<java.lang.String> list = this.m.get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public org.apache.tools.ant.Project getProject() {
        return this.a;
    }

    public java.util.Vector<org.apache.tools.ant.Target> getTargets() {
        return this.d;
    }

    public java.util.Vector<org.apache.tools.ant.RuntimeConfigurable> getWrapperStack() {
        return this.k;
    }

    public boolean isIgnoringProjectTag() {
        return this.l;
    }

    public org.apache.tools.ant.RuntimeConfigurable parentWrapper() {
        if (this.k.size() < 2) {
            return null;
        }
        java.util.Vector<org.apache.tools.ant.RuntimeConfigurable> vector = this.k;
        return vector.elementAt(vector.size() - 2);
    }

    public void popWrapper() {
        if (this.k.size() > 0) {
            this.k.removeElementAt(r0.size() - 1);
        }
    }

    public void pushWrapper(org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) {
        this.k.addElement(runtimeConfigurable);
    }

    public void setBuildFile(java.io.File file) {
        this.b = file;
        if (file == null) {
            this.e = null;
            return;
        }
        this.e = new java.io.File(file.getParent());
        this.i.setLocation(new org.apache.tools.ant.Location(file.getAbsolutePath()));
        try {
            setBuildFile(org.apache.tools.ant.util.FileUtils.getFileUtils().getFileURL(file));
        } catch (java.net.MalformedURLException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public void setBuildFile(java.net.URL url) throws java.net.MalformedURLException {
        this.c = url;
        this.f = new java.net.URL(url, ".");
        if (this.i.getLocation() == null) {
            this.i.setLocation(new org.apache.tools.ant.Location(url.toString()));
        }
    }

    public void setCurrentProjectName(java.lang.String str) {
        this.g = str;
    }

    public void setCurrentTarget(org.apache.tools.ant.Target target) {
        this.j = target;
    }

    public void setCurrentTargets(java.util.Map<java.lang.String, org.apache.tools.ant.Target> map) {
        this.n = map;
    }

    public void setIgnoreProjectTag(boolean z) {
        this.l = z;
    }

    public void setImplicitTarget(org.apache.tools.ant.Target target) {
        this.i = target;
    }

    public void setLocator(org.xml.sax.Locator locator) {
        this.h = locator;
    }

    public void startPrefixMapping(java.lang.String str, java.lang.String str2) {
        java.util.List<java.lang.String> list = this.m.get(str);
        if (list == null) {
            list = new java.util.ArrayList<>();
            this.m.put(str, list);
        }
        list.add(str2);
    }
}
