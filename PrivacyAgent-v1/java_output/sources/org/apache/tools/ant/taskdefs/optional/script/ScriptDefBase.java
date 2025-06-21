package org.apache.tools.ant.taskdefs.optional.script;

/* loaded from: classes25.dex */
public class ScriptDefBase extends org.apache.tools.ant.Task implements org.apache.tools.ant.DynamicConfigurator {
    public java.util.Map u = new java.util.HashMap();
    public java.util.Map v = new java.util.HashMap();
    public java.lang.String w;

    public void addText(java.lang.String str) {
        this.w = getProject().replaceProperties(str);
    }

    public final org.apache.tools.ant.taskdefs.optional.script.ScriptDef c() {
        java.lang.String taskType = getTaskType();
        java.util.Map map = (java.util.Map) getProject().getReference(org.apache.tools.ant.MagicNames.SCRIPT_REPOSITORY);
        if (map == null) {
            throw new org.apache.tools.ant.BuildException("Script repository not found for " + taskType);
        }
        org.apache.tools.ant.taskdefs.optional.script.ScriptDef scriptDef = (org.apache.tools.ant.taskdefs.optional.script.ScriptDef) map.get(getTaskType());
        if (scriptDef != null) {
            return scriptDef;
        }
        throw new org.apache.tools.ant.BuildException("Script definition not found for " + taskType);
    }

    @Override // org.apache.tools.ant.DynamicElement
    public java.lang.Object createDynamicElement(java.lang.String str) {
        java.util.List list = (java.util.List) this.u.get(str);
        if (list == null) {
            list = new java.util.ArrayList();
            this.u.put(str, list);
        }
        java.lang.Object createNestedElement = c().createNestedElement(str);
        list.add(createNestedElement);
        return createNestedElement;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        c().executeScript(this.v, this.u, this);
    }

    public void fail(java.lang.String str) {
        throw new org.apache.tools.ant.BuildException(str);
    }

    public java.lang.String getText() {
        return this.w;
    }

    @Override // org.apache.tools.ant.DynamicAttribute
    public void setDynamicAttribute(java.lang.String str, java.lang.String str2) {
        if (c().isAttributeSupported(str)) {
            this.v.put(str, str2);
            return;
        }
        throw new org.apache.tools.ant.BuildException("<" + getTaskType() + "> does not support the \"" + str + "\" attribute");
    }
}
