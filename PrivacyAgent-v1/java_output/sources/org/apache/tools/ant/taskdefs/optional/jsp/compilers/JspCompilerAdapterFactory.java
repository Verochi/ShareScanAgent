package org.apache.tools.ant.taskdefs.optional.jsp.compilers;

/* loaded from: classes25.dex */
public final class JspCompilerAdapterFactory {
    public static org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter a(java.lang.String str, org.apache.tools.ant.AntClassLoader antClassLoader) throws org.apache.tools.ant.BuildException {
        try {
            return (org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter) antClassLoader.findClass(str).newInstance();
        } catch (java.lang.ClassCastException e) {
            throw new org.apache.tools.ant.BuildException(str + " isn't the classname of a compiler adapter.", e);
        } catch (java.lang.ClassNotFoundException e2) {
            throw new org.apache.tools.ant.BuildException(str + " can't be found.", e2);
        } catch (java.lang.Throwable th) {
            throw new org.apache.tools.ant.BuildException(str + " caused an interesting exception.", th);
        }
    }

    public static org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter getCompiler(java.lang.String str, org.apache.tools.ant.Task task) throws org.apache.tools.ant.BuildException {
        return getCompiler(str, task, task.getProject().createClassLoader(null));
    }

    public static org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter getCompiler(java.lang.String str, org.apache.tools.ant.Task task, org.apache.tools.ant.AntClassLoader antClassLoader) throws org.apache.tools.ant.BuildException {
        return str.equalsIgnoreCase("jasper") ? new org.apache.tools.ant.taskdefs.optional.jsp.compilers.JasperC(new org.apache.tools.ant.taskdefs.optional.jsp.JspNameMangler()) : str.equalsIgnoreCase("jasper41") ? new org.apache.tools.ant.taskdefs.optional.jsp.compilers.JasperC(new org.apache.tools.ant.taskdefs.optional.jsp.Jasper41Mangler()) : a(str, antClassLoader);
    }
}
