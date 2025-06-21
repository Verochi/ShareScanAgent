package org.apache.tools.ant.taskdefs.rmic;

/* loaded from: classes25.dex */
public class KaffeRmic extends org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter {
    public static final java.lang.String COMPILER_NAME = "kaffe";
    public static final java.lang.String[] d = {"gnu.classpath.tools.rmi.rmic.RMIC", "gnu.java.rmi.rmic.RMIC", "kaffe.rmi.rmic.RMIC"};

    public static java.lang.Class<?> d() {
        java.lang.String[] strArr = d;
        for (int i = 0; i < strArr.length; i++) {
            try {
                return java.lang.Class.forName(strArr[i]);
            } catch (java.lang.ClassNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean isAvailable() {
        return d() != null;
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter
    public boolean areIiopAndIdlSupported() {
        return true;
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.RmicAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        getRmic().log("Using Kaffe rmic", 3);
        org.apache.tools.ant.types.Commandline commandline = setupRmicCommand();
        java.lang.Class<?> d2 = d();
        if (d2 != null) {
            commandline.setExecutable(d2.getName());
            java.lang.String name = d2.getName();
            java.lang.String[] strArr = d;
            if (!name.equals(strArr[strArr.length - 1])) {
                commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE);
                getRmic().log(org.apache.tools.ant.types.Commandline.describeCommand(commandline));
            }
            org.apache.tools.ant.taskdefs.ExecuteJava executeJava = new org.apache.tools.ant.taskdefs.ExecuteJava();
            executeJava.setJavaCommand(commandline);
            return executeJava.fork(getRmic()) == 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Cannot use Kaffe rmic, as it is not available.  None of ");
        for (java.lang.String str : d) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" have been found. A common solution is to set the environment variable JAVA_HOME or CLASSPATH.");
        throw new org.apache.tools.ant.BuildException(sb.toString(), getRmic().getLocation());
    }
}
