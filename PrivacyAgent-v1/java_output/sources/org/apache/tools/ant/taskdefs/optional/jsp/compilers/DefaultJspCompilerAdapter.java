package org.apache.tools.ant.taskdefs.optional.jsp.compilers;

/* loaded from: classes25.dex */
public abstract class DefaultJspCompilerAdapter implements org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter {
    public static java.lang.String a = java.lang.System.getProperty("line.separator");
    protected org.apache.tools.ant.taskdefs.optional.jsp.JspC owner;

    public void addArg(org.apache.tools.ant.types.CommandlineJava commandlineJava, java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        commandlineJava.createArgument().setValue(str);
    }

    public void addArg(org.apache.tools.ant.types.CommandlineJava commandlineJava, java.lang.String str, java.io.File file) {
        if (file != null) {
            commandlineJava.createArgument().setValue(str);
            commandlineJava.createArgument().setFile(file);
        }
    }

    public void addArg(org.apache.tools.ant.types.CommandlineJava commandlineJava, java.lang.String str, java.lang.String str2) {
        if (str2 != null) {
            commandlineJava.createArgument().setValue(str);
            commandlineJava.createArgument().setValue(str2);
        }
    }

    public org.apache.tools.ant.taskdefs.optional.jsp.JspC getJspc() {
        return this.owner;
    }

    public org.apache.tools.ant.Project getProject() {
        return getJspc().getProject();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter
    public boolean implementsOwnDependencyChecking() {
        return false;
    }

    public void logAndAddFilesToCompile(org.apache.tools.ant.taskdefs.optional.jsp.JspC jspC, java.util.Vector vector, org.apache.tools.ant.types.CommandlineJava commandlineJava) {
        jspC.log("Compilation " + commandlineJava.describeJavaCommand(), 3);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("File");
        if (vector.size() != 1) {
            stringBuffer.append("s");
        }
        stringBuffer.append(" to be compiled:");
        stringBuffer.append(a);
        java.util.Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            java.lang.String str = (java.lang.String) elements.nextElement();
            commandlineJava.createArgument().setValue(str);
            stringBuffer.append("    ");
            stringBuffer.append(str);
            stringBuffer.append(a);
        }
        jspC.log(stringBuffer.toString(), 3);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter
    public void setJspc(org.apache.tools.ant.taskdefs.optional.jsp.JspC jspC) {
        this.owner = jspC;
    }
}
