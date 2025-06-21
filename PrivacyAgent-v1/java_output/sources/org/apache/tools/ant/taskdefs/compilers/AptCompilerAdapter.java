package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public class AptCompilerAdapter extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    public static final java.lang.String APT_ENTRY_POINT = "com.sun.tools.apt.Main";
    public static final java.lang.String APT_METHOD_NAME = "process";

    public static void f(org.apache.tools.ant.taskdefs.Apt apt, org.apache.tools.ant.types.Commandline commandline) {
        if (!apt.isCompile()) {
            commandline.createArgument().setValue("-nocompile");
        }
        java.lang.String factory = apt.getFactory();
        if (factory != null) {
            commandline.createArgument().setValue("-factory");
            commandline.createArgument().setValue(factory);
        }
        org.apache.tools.ant.types.Path factoryPath = apt.getFactoryPath();
        if (factoryPath != null) {
            commandline.createArgument().setValue("-factorypath");
            commandline.createArgument().setPath(factoryPath);
        }
        java.io.File preprocessDir = apt.getPreprocessDir();
        if (preprocessDir != null) {
            commandline.createArgument().setValue("-s");
            commandline.createArgument().setFile(preprocessDir);
        }
        java.util.Enumeration<org.apache.tools.ant.taskdefs.Apt.Option> elements = apt.getOptions().elements();
        while (elements.hasMoreElements()) {
            org.apache.tools.ant.taskdefs.Apt.Option nextElement = elements.nextElement();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("-A");
            stringBuffer.append(nextElement.getName());
            if (nextElement.getValue() != null) {
                stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(nextElement.getValue());
            }
            commandline.createArgument().setValue(stringBuffer.toString());
        }
    }

    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using apt compiler", 3);
        org.apache.tools.ant.types.Commandline commandline = setupModernJavacCommand();
        setAptCommandlineSwitches(commandline);
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(APT_ENTRY_POINT);
            return ((java.lang.Integer) cls.getMethod("process", new java.lang.String[0].getClass()).invoke(cls.newInstance(), commandline.getArguments())).intValue() == 0;
        } catch (org.apache.tools.ant.BuildException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new org.apache.tools.ant.BuildException("Error starting apt compiler", e2, this.location);
        }
    }

    public org.apache.tools.ant.taskdefs.Apt getApt() {
        return (org.apache.tools.ant.taskdefs.Apt) getJavac();
    }

    public void setAptCommandlineSwitches(org.apache.tools.ant.types.Commandline commandline) {
        f(getApt(), commandline);
    }
}
