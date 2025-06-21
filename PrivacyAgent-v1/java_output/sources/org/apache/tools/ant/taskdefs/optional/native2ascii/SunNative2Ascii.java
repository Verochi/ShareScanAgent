package org.apache.tools.ant.taskdefs.optional.native2ascii;

/* loaded from: classes25.dex */
public final class SunNative2Ascii extends org.apache.tools.ant.taskdefs.optional.native2ascii.DefaultNative2Ascii {
    public static final java.lang.String IMPLEMENTATION_NAME = "sun";

    @Override // org.apache.tools.ant.taskdefs.optional.native2ascii.DefaultNative2Ascii
    public boolean run(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.ProjectComponent projectComponent) throws org.apache.tools.ant.BuildException {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("sun.tools.native2ascii.Main");
            java.lang.reflect.Method method = cls.getMethod("convert", java.lang.String[].class);
            if (method != null) {
                return ((java.lang.Boolean) method.invoke(cls.newInstance(), commandline.getArguments())).booleanValue();
            }
            throw new org.apache.tools.ant.BuildException("Could not find convert() method in sun.tools.native2ascii.Main");
        } catch (org.apache.tools.ant.BuildException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new org.apache.tools.ant.BuildException("Error starting Sun's native2ascii: ", e2);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.native2ascii.DefaultNative2Ascii
    public void setup(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.taskdefs.optional.Native2Ascii native2Ascii) throws org.apache.tools.ant.BuildException {
        if (native2Ascii.getReverse()) {
            commandline.createArgument().setValue("-reverse");
        }
        super.setup(commandline, native2Ascii);
    }
}
