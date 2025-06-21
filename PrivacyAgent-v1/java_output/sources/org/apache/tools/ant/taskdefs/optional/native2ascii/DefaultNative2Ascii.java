package org.apache.tools.ant.taskdefs.optional.native2ascii;

/* loaded from: classes25.dex */
public abstract class DefaultNative2Ascii implements org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter {
    public void addFiles(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.ProjectComponent projectComponent, java.io.File file, java.io.File file2) throws org.apache.tools.ant.BuildException {
        commandline.createArgument().setFile(file);
        commandline.createArgument().setFile(file2);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter
    public final boolean convert(org.apache.tools.ant.taskdefs.optional.Native2Ascii native2Ascii, java.io.File file, java.io.File file2) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        setup(commandline, native2Ascii);
        addFiles(commandline, native2Ascii, file, file2);
        return run(commandline, native2Ascii);
    }

    public abstract boolean run(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.ProjectComponent projectComponent) throws org.apache.tools.ant.BuildException;

    public void setup(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.taskdefs.optional.Native2Ascii native2Ascii) throws org.apache.tools.ant.BuildException {
        if (native2Ascii.getEncoding() != null) {
            commandline.createArgument().setValue("-encoding");
            commandline.createArgument().setValue(native2Ascii.getEncoding());
        }
        commandline.addArguments(native2Ascii.getCurrentArgs());
    }
}
