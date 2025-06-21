package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public final class AttributeNamespaceDef extends org.apache.tools.ant.taskdefs.AntlibDefinition {
    @Override // org.apache.tools.ant.Task
    public void execute() {
        java.lang.String nsToComponentName = org.apache.tools.ant.ProjectHelper.nsToComponentName(getURI());
        org.apache.tools.ant.AntTypeDefinition antTypeDefinition = new org.apache.tools.ant.AntTypeDefinition();
        antTypeDefinition.setName(nsToComponentName);
        antTypeDefinition.setClassName(org.apache.tools.ant.attribute.AttributeNamespace.class.getName());
        antTypeDefinition.setClass(org.apache.tools.ant.attribute.AttributeNamespace.class);
        antTypeDefinition.setRestrict(true);
        antTypeDefinition.setClassLoader(org.apache.tools.ant.attribute.AttributeNamespace.class.getClassLoader());
        org.apache.tools.ant.ComponentHelper.getComponentHelper(getProject()).addDataTypeDefinition(antTypeDefinition);
    }
}
