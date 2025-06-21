package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public abstract class ScriptRunnerBase {
    public java.lang.String b;
    public org.apache.tools.ant.Project d;
    public java.lang.ClassLoader e;
    public boolean a = false;
    public java.lang.String c = "";
    public java.util.Map f = new java.util.HashMap();

    public final void a(java.io.Reader reader, java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new java.io.BufferedReader(reader);
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            this.c += org.apache.tools.ant.util.FileUtils.safeReadFully(bufferedReader);
            org.apache.tools.ant.util.FileUtils.close(bufferedReader);
        } catch (java.io.IOException e2) {
            e = e2;
            bufferedReader2 = bufferedReader;
            throw new org.apache.tools.ant.BuildException("Failed to read " + str, e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
            throw th;
        }
    }

    public void addBean(java.lang.String str, java.lang.Object obj) {
        boolean z = false;
        if (str.length() > 0 && java.lang.Character.isJavaIdentifierStart(str.charAt(0))) {
            z = true;
        }
        for (int i = 1; z && i < str.length(); i++) {
            z = java.lang.Character.isJavaIdentifierPart(str.charAt(i));
        }
        if (z) {
            this.f.put(str, obj);
        }
    }

    public void addBeans(java.util.Map map) {
        for (java.lang.String str : map.keySet()) {
            try {
                addBean(str, map.get(str));
            } catch (org.apache.tools.ant.BuildException unused) {
            }
        }
    }

    public void addText(java.lang.String str) {
        this.c += str;
    }

    public void bindToComponent(org.apache.tools.ant.ProjectComponent projectComponent) {
        org.apache.tools.ant.Project project = projectComponent.getProject();
        this.d = project;
        addBeans(project.getProperties());
        addBeans(this.d.getUserProperties());
        addBeans(this.d.getCopyOfTargets());
        addBeans(this.d.getCopyOfReferences());
        addBean("project", this.d);
        addBean("self", projectComponent);
    }

    public void bindToComponentMinimum(org.apache.tools.ant.ProjectComponent projectComponent) {
        org.apache.tools.ant.Project project = projectComponent.getProject();
        this.d = project;
        addBean("project", project);
        addBean("self", projectComponent);
    }

    public void checkLanguage() {
        if (this.b == null) {
            throw new org.apache.tools.ant.BuildException("script language must be specified");
        }
    }

    public void clearScript() {
        this.c = "";
    }

    public abstract java.lang.Object evaluateScript(java.lang.String str);

    public abstract void executeScript(java.lang.String str);

    public java.util.Map getBeans() {
        return this.f;
    }

    public boolean getKeepEngine() {
        return this.a;
    }

    public java.lang.String getLanguage() {
        return this.b;
    }

    public abstract java.lang.String getManagerName();

    public org.apache.tools.ant.Project getProject() {
        return this.d;
    }

    public java.lang.String getScript() {
        return this.c;
    }

    public java.lang.ClassLoader getScriptClassLoader() {
        return this.e;
    }

    public void loadResource(org.apache.tools.ant.types.Resource resource) {
        java.lang.String longString = resource.toLongString();
        try {
            a(new java.io.InputStreamReader(resource.getInputStream()), longString);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Failed to open " + longString, e);
        } catch (java.lang.UnsupportedOperationException e2) {
            throw new org.apache.tools.ant.BuildException("Failed to open " + longString + " -it is not readable", e2);
        }
    }

    public void loadResources(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = resourceCollection.iterator();
        while (it.hasNext()) {
            loadResource(it.next());
        }
    }

    public java.lang.ClassLoader replaceContextLoader() {
        java.lang.ClassLoader contextClassLoader = java.lang.Thread.currentThread().getContextClassLoader();
        if (getScriptClassLoader() == null) {
            setScriptClassLoader(getClass().getClassLoader());
        }
        java.lang.Thread.currentThread().setContextClassLoader(getScriptClassLoader());
        return contextClassLoader;
    }

    public void restoreContextLoader(java.lang.ClassLoader classLoader) {
        java.lang.Thread.currentThread().setContextClassLoader(classLoader);
    }

    public void setKeepEngine(boolean z) {
        this.a = z;
    }

    public void setLanguage(java.lang.String str) {
        this.b = str;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.d = project;
    }

    public void setScriptClassLoader(java.lang.ClassLoader classLoader) {
        this.e = classLoader;
    }

    public void setSrc(java.io.File file) {
        java.lang.String path = file.getPath();
        if (!file.exists()) {
            throw new org.apache.tools.ant.BuildException("file " + path + " not found.");
        }
        try {
            a(new java.io.FileReader(file), path);
        } catch (java.io.FileNotFoundException unused) {
            throw new org.apache.tools.ant.BuildException("file " + path + " not found.");
        }
    }

    public abstract boolean supportsLanguage();
}
