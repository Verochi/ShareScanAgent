package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class LoadFile extends org.apache.tools.ant.taskdefs.LoadResource {
    public final void setSrcFile(java.io.File file) {
        addConfigured(new org.apache.tools.ant.types.resources.FileResource(file));
    }
}
