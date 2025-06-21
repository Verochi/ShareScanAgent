package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public interface EJBDeploymentTool {
    void configure(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.Config config);

    void processDescriptor(java.lang.String str, javax.xml.parsers.SAXParser sAXParser) throws org.apache.tools.ant.BuildException;

    void setTask(org.apache.tools.ant.Task task);

    void validateConfigured() throws org.apache.tools.ant.BuildException;
}
