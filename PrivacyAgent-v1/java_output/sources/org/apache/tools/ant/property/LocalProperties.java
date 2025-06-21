package org.apache.tools.ant.property;

/* loaded from: classes25.dex */
public class LocalProperties extends java.lang.InheritableThreadLocal<org.apache.tools.ant.property.LocalPropertyStack> implements org.apache.tools.ant.PropertyHelper.PropertyEvaluator, org.apache.tools.ant.PropertyHelper.PropertySetter {
    public static synchronized org.apache.tools.ant.property.LocalProperties get(org.apache.tools.ant.Project project) {
        org.apache.tools.ant.property.LocalProperties localProperties;
        synchronized (org.apache.tools.ant.property.LocalProperties.class) {
            localProperties = (org.apache.tools.ant.property.LocalProperties) project.getReference(org.apache.tools.ant.MagicNames.REFID_LOCAL_PROPERTIES);
            if (localProperties == null) {
                localProperties = new org.apache.tools.ant.property.LocalProperties();
                project.addReference(org.apache.tools.ant.MagicNames.REFID_LOCAL_PROPERTIES, localProperties);
                org.apache.tools.ant.PropertyHelper.getPropertyHelper(project).add(localProperties);
            }
        }
        return localProperties;
    }

    public final org.apache.tools.ant.property.LocalPropertyStack a() {
        return get();
    }

    public void addLocal(java.lang.String str) {
        a().addLocal(str);
    }

    public void copy() {
        set(a().copy());
    }

    public void enterScope() {
        a().enterScope();
    }

    @Override // org.apache.tools.ant.PropertyHelper.PropertyEvaluator
    public java.lang.Object evaluate(java.lang.String str, org.apache.tools.ant.PropertyHelper propertyHelper) {
        return a().evaluate(str, propertyHelper);
    }

    public void exitScope() {
        a().exitScope();
    }

    @Override // java.lang.ThreadLocal
    public synchronized org.apache.tools.ant.property.LocalPropertyStack initialValue() {
        return new org.apache.tools.ant.property.LocalPropertyStack();
    }

    @Override // org.apache.tools.ant.PropertyHelper.PropertySetter
    public boolean set(java.lang.String str, java.lang.Object obj, org.apache.tools.ant.PropertyHelper propertyHelper) {
        return a().set(str, obj, propertyHelper);
    }

    @Override // org.apache.tools.ant.PropertyHelper.PropertySetter
    public boolean setNew(java.lang.String str, java.lang.Object obj, org.apache.tools.ant.PropertyHelper propertyHelper) {
        return a().setNew(str, obj, propertyHelper);
    }
}
