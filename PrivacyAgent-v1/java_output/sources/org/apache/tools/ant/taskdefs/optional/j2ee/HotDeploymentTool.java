package org.apache.tools.ant.taskdefs.optional.j2ee;

/* loaded from: classes25.dex */
public interface HotDeploymentTool {
    public static final java.lang.String ACTION_DELETE = "delete";
    public static final java.lang.String ACTION_DEPLOY = "deploy";
    public static final java.lang.String ACTION_LIST = "list";
    public static final java.lang.String ACTION_UNDEPLOY = "undeploy";
    public static final java.lang.String ACTION_UPDATE = "update";

    void deploy() throws org.apache.tools.ant.BuildException;

    void setTask(org.apache.tools.ant.taskdefs.optional.j2ee.ServerDeploy serverDeploy);

    void validateAttributes() throws org.apache.tools.ant.BuildException;
}
