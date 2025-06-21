package org.apache.tools.ant.taskdefs.optional.native2ascii;

/* loaded from: classes25.dex */
public final class KaffeNative2Ascii extends org.apache.tools.ant.taskdefs.optional.native2ascii.DefaultNative2Ascii {
    public static final java.lang.String IMPLEMENTATION_NAME = "kaffe";
    public static final java.lang.String[] a = {"gnu.classpath.tools.native2ascii.Native2ASCII", "kaffe.tools.native2ascii.Native2Ascii"};

    public static java.lang.Class<?> a() {
        java.lang.String[] strArr = a;
        for (int i = 0; i < strArr.length; i++) {
            try {
                return java.lang.Class.forName(strArr[i]);
            } catch (java.lang.ClassNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.native2ascii.DefaultNative2Ascii
    public boolean run(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.ProjectComponent projectComponent) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.ExecuteJava executeJava = new org.apache.tools.ant.taskdefs.ExecuteJava();
        java.lang.Class<?> a2 = a();
        if (a2 == null) {
            throw new org.apache.tools.ant.BuildException("Couldn't load Kaffe's Native2Ascii class");
        }
        commandline.setExecutable(a2.getName());
        executeJava.setJavaCommand(commandline);
        executeJava.execute(projectComponent.getProject());
        return true;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.native2ascii.DefaultNative2Ascii
    public void setup(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.taskdefs.optional.Native2Ascii native2Ascii) throws org.apache.tools.ant.BuildException {
        if (native2Ascii.getReverse()) {
            throw new org.apache.tools.ant.BuildException("-reverse is not supported by Kaffe");
        }
        super.setup(commandline, native2Ascii);
    }
}
