package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class TaskAdapter extends org.apache.tools.ant.Task implements org.apache.tools.ant.TypeAdapter {
    public java.lang.Object u;

    public TaskAdapter() {
    }

    public TaskAdapter(java.lang.Object obj) {
        this();
        setProxy(obj);
    }

    public static void checkTaskClass(java.lang.Class<?> cls, org.apache.tools.ant.Project project) {
        if (org.apache.tools.ant.dispatch.Dispatchable.class.isAssignableFrom(cls)) {
            return;
        }
        try {
            java.lang.reflect.Method method = cls.getMethod("execute", null);
            if (java.lang.Void.TYPE.equals(method.getReturnType())) {
                return;
            }
            project.log("return type of execute() should be void but was \"" + method.getReturnType() + "\" in " + cls, 1);
        } catch (java.lang.LinkageError e) {
            java.lang.String str = "Could not load " + cls + ": " + e;
            project.log(str, 0);
            throw new org.apache.tools.ant.BuildException(str, e);
        } catch (java.lang.NoSuchMethodException unused) {
            java.lang.String str2 = "No public execute() in " + cls;
            project.log(str2, 0);
            throw new org.apache.tools.ant.BuildException(str2);
        }
    }

    @Override // org.apache.tools.ant.TypeAdapter
    public void checkProxyClass(java.lang.Class<?> cls) {
        checkTaskClass(cls, getProject());
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        try {
            java.lang.reflect.Method method = this.u.getClass().getMethod("setLocation", org.apache.tools.ant.Location.class);
            if (method != null) {
                method.invoke(this.u, getLocation());
            }
        } catch (java.lang.NoSuchMethodException unused) {
        } catch (java.lang.Exception e) {
            log("Error setting location in " + this.u.getClass(), 0);
            throw new org.apache.tools.ant.BuildException(e);
        }
        try {
            java.lang.reflect.Method method2 = this.u.getClass().getMethod("setProject", org.apache.tools.ant.Project.class);
            if (method2 != null) {
                method2.invoke(this.u, getProject());
            }
        } catch (java.lang.NoSuchMethodException unused2) {
        } catch (java.lang.Exception e2) {
            log("Error setting project in " + this.u.getClass(), 0);
            throw new org.apache.tools.ant.BuildException(e2);
        }
        try {
            org.apache.tools.ant.dispatch.DispatchUtils.execute(this.u);
        } catch (org.apache.tools.ant.BuildException e3) {
            throw e3;
        } catch (java.lang.Exception e4) {
            log("Error in " + this.u.getClass(), 3);
            throw new org.apache.tools.ant.BuildException(e4);
        }
    }

    @Override // org.apache.tools.ant.TypeAdapter
    public java.lang.Object getProxy() {
        return this.u;
    }

    @Override // org.apache.tools.ant.TypeAdapter
    public void setProxy(java.lang.Object obj) {
        this.u = obj;
    }
}
