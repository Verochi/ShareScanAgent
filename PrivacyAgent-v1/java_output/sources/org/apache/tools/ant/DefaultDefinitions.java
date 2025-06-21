package org.apache.tools.ant;

/* loaded from: classes25.dex */
public final class DefaultDefinitions {
    public final org.apache.tools.ant.ComponentHelper a;

    public DefaultDefinitions(org.apache.tools.ant.ComponentHelper componentHelper) {
        this.a = componentHelper;
    }

    public final void a(java.lang.String str) {
        org.apache.tools.ant.AntTypeDefinition antTypeDefinition = new org.apache.tools.ant.AntTypeDefinition();
        antTypeDefinition.setName(org.apache.tools.ant.ProjectHelper.nsToComponentName(str));
        antTypeDefinition.setClassName("org.apache.tools.ant.attribute.AttributeNamespace");
        antTypeDefinition.setClassLoader(org.apache.tools.ant.DefaultDefinitions.class.getClassLoader());
        antTypeDefinition.setRestrict(true);
        this.a.addDataTypeDefinition(antTypeDefinition);
    }

    public final void b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        org.apache.tools.ant.AntTypeDefinition antTypeDefinition = new org.apache.tools.ant.AntTypeDefinition();
        org.apache.tools.ant.ProjectHelper.genComponentName(str, str2);
        antTypeDefinition.setName(org.apache.tools.ant.ProjectHelper.genComponentName(str, str2));
        antTypeDefinition.setClassName(str3);
        antTypeDefinition.setClassLoader(org.apache.tools.ant.DefaultDefinitions.class.getClassLoader());
        antTypeDefinition.setRestrict(true);
        this.a.addDataTypeDefinition(antTypeDefinition);
    }

    public final void c(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = "org.apache.tools.ant.attribute." + str2;
        b("ant:if", str, str3);
        b("ant:unless", str, str3 + "$Unless");
    }

    public void execute() {
        a("ant:if");
        a("ant:unless");
        c(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE, "IfTrueAttribute");
        c("set", "IfSetAttribute");
        c("blank", "IfBlankAttribute");
    }
}
