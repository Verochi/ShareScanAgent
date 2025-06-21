package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public abstract class DataType extends org.apache.tools.ant.ProjectComponent {

    @java.lang.Deprecated
    protected boolean checked = true;

    @java.lang.Deprecated
    protected org.apache.tools.ant.types.Reference ref;

    public static void invokeCircularReferenceCheck(org.apache.tools.ant.types.DataType dataType, java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) {
        dataType.dieOnCircularReference(stack, project);
    }

    public static void pushAndInvokeCircularReferenceCheck(org.apache.tools.ant.types.DataType dataType, java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) {
        stack.push(dataType);
        dataType.dieOnCircularReference(stack, project);
        stack.pop();
    }

    public final java.lang.String a(java.lang.Class<?> cls) {
        return cls.getName() + " (loaded via " + cls.getClassLoader() + ")";
    }

    public void checkAttributesAllowed() {
        if (isReference()) {
            throw tooManyAttributes();
        }
    }

    public void checkChildrenAllowed() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
    }

    public org.apache.tools.ant.BuildException circularReference() {
        return new org.apache.tools.ant.BuildException("This data type contains a circular reference.");
    }

    @Override // org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        org.apache.tools.ant.types.DataType dataType = (org.apache.tools.ant.types.DataType) super.clone();
        dataType.setDescription(getDescription());
        if (getRefid() != null) {
            dataType.setRefid(getRefid());
        }
        dataType.setChecked(isChecked());
        return dataType;
    }

    public void dieOnCircularReference() {
        dieOnCircularReference(getProject());
    }

    public void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (this.checked || !isReference()) {
            return;
        }
        java.lang.Object referencedObject = this.ref.getReferencedObject(project);
        if (referencedObject instanceof org.apache.tools.ant.types.DataType) {
            org.apache.tools.ant.util.IdentityStack identityStack = org.apache.tools.ant.util.IdentityStack.getInstance(stack);
            if (identityStack.contains(referencedObject)) {
                throw circularReference();
            }
            identityStack.push(referencedObject);
            ((org.apache.tools.ant.types.DataType) referencedObject).dieOnCircularReference(identityStack, project);
            identityStack.pop();
        }
        this.checked = true;
    }

    public void dieOnCircularReference(org.apache.tools.ant.Project project) {
        if (this.checked || !isReference()) {
            return;
        }
        dieOnCircularReference(new org.apache.tools.ant.util.IdentityStack(this), project);
    }

    public java.lang.Object getCheckedRef() {
        return getCheckedRef(getProject());
    }

    public <T> T getCheckedRef(java.lang.Class<T> cls, java.lang.String str) {
        return (T) getCheckedRef(cls, str, getProject());
    }

    public <T> T getCheckedRef(java.lang.Class<T> cls, java.lang.String str, org.apache.tools.ant.Project project) {
        if (project == null) {
            throw new org.apache.tools.ant.BuildException("No Project specified");
        }
        dieOnCircularReference(project);
        T t = (T) this.ref.getReferencedObject(project);
        if (cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        log("Class " + a(t.getClass()) + " is not a subclass of " + a(cls), 3);
        throw new org.apache.tools.ant.BuildException(this.ref.getRefId() + " doesn't denote a " + str);
    }

    public java.lang.Object getCheckedRef(org.apache.tools.ant.Project project) {
        return getCheckedRef(getClass(), getDataTypeName(), project);
    }

    public java.lang.String getDataTypeName() {
        return org.apache.tools.ant.ComponentHelper.getElementName(getProject(), this, true);
    }

    public org.apache.tools.ant.types.Reference getRefid() {
        return this.ref;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isReference() {
        return this.ref != null;
    }

    public org.apache.tools.ant.BuildException noChildrenAllowed() {
        return new org.apache.tools.ant.BuildException("You must not specify nested elements when using refid");
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        this.ref = reference;
        this.checked = false;
    }

    public java.lang.String toString() {
        java.lang.String description = getDescription();
        if (description == null) {
            return getDataTypeName();
        }
        return getDataTypeName() + " " + description;
    }

    public org.apache.tools.ant.BuildException tooManyAttributes() {
        return new org.apache.tools.ant.BuildException("You must not specify more than one attribute when using refid");
    }
}
