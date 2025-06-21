package org.apache.tools.ant.taskdefs.rmic;

/* loaded from: classes25.dex */
public class XNewRmic extends org.apache.tools.ant.taskdefs.rmic.ForkingSunRmic {
    public static final java.lang.String COMPILER_NAME = "xnew";

    @Override // org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter
    public org.apache.tools.ant.types.Commandline setupRmicCommand() {
        return super.setupRmicCommand(new java.lang.String[]{"-Xnew"});
    }
}
