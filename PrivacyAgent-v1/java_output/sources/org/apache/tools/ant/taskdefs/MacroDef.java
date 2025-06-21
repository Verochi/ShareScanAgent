package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class MacroDef extends org.apache.tools.ant.taskdefs.AntlibDefinition {
    public org.apache.tools.ant.taskdefs.MacroDef.NestedSequential w;
    public java.lang.String x;
    public boolean y = true;
    public java.util.List<org.apache.tools.ant.taskdefs.MacroDef.Attribute> z = new java.util.ArrayList();
    public java.util.Map<java.lang.String, org.apache.tools.ant.taskdefs.MacroDef.TemplateElement> A = new java.util.HashMap();
    public java.lang.String B = null;
    public org.apache.tools.ant.taskdefs.MacroDef.Text C = null;
    public boolean D = false;

    public static class Attribute {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public boolean d = true;

        public boolean equals(java.lang.Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            org.apache.tools.ant.taskdefs.MacroDef.Attribute attribute = (org.apache.tools.ant.taskdefs.MacroDef.Attribute) obj;
            java.lang.String str = this.a;
            if (str == null) {
                if (attribute.a != null) {
                    return false;
                }
            } else if (!str.equals(attribute.a)) {
                return false;
            }
            java.lang.String str2 = this.b;
            return str2 == null ? attribute.b == null : str2.equals(attribute.b);
        }

        public java.lang.String getDefault() {
            return this.b;
        }

        public java.lang.String getDescription() {
            return this.c;
        }

        public java.lang.String getName() {
            return this.a;
        }

        public int hashCode() {
            return org.apache.tools.ant.taskdefs.MacroDef.g(this.b) + org.apache.tools.ant.taskdefs.MacroDef.g(this.a);
        }

        public boolean isDoubleExpanding() {
            return this.d;
        }

        public void setDefault(java.lang.String str) {
            this.b = str;
        }

        public void setDescription(java.lang.String str) {
            this.c = str;
        }

        public void setDoubleExpanding(boolean z) {
            this.d = z;
        }

        public void setName(java.lang.String str) {
            if (org.apache.tools.ant.taskdefs.MacroDef.f(str)) {
                this.a = str.toLowerCase(java.util.Locale.ENGLISH);
                return;
            }
            throw new org.apache.tools.ant.BuildException("Illegal name [" + str + "] for attribute");
        }
    }

    public static class MyAntTypeDefinition extends org.apache.tools.ant.AntTypeDefinition {
        public org.apache.tools.ant.taskdefs.MacroDef h;

        public MyAntTypeDefinition(org.apache.tools.ant.taskdefs.MacroDef macroDef) {
            this.h = macroDef;
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public java.lang.Object create(org.apache.tools.ant.Project project) {
            java.lang.Object create = super.create(project);
            if (create == null) {
                return null;
            }
            ((org.apache.tools.ant.taskdefs.MacroInstance) create).setMacroDef(this.h);
            return create;
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public boolean sameDefinition(org.apache.tools.ant.AntTypeDefinition antTypeDefinition, org.apache.tools.ant.Project project) {
            if (super.sameDefinition(antTypeDefinition, project)) {
                return this.h.sameDefinition(((org.apache.tools.ant.taskdefs.MacroDef.MyAntTypeDefinition) antTypeDefinition).h);
            }
            return false;
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public boolean similarDefinition(org.apache.tools.ant.AntTypeDefinition antTypeDefinition, org.apache.tools.ant.Project project) {
            if (super.similarDefinition(antTypeDefinition, project)) {
                return this.h.similar(((org.apache.tools.ant.taskdefs.MacroDef.MyAntTypeDefinition) antTypeDefinition).h);
            }
            return false;
        }
    }

    public static class NestedSequential implements org.apache.tools.ant.TaskContainer {
        public java.util.List<org.apache.tools.ant.Task> n = new java.util.ArrayList();

        @Override // org.apache.tools.ant.TaskContainer
        public void addTask(org.apache.tools.ant.Task task) {
            this.n.add(task);
        }

        public java.util.List<org.apache.tools.ant.Task> getNested() {
            return this.n;
        }

        public boolean similar(org.apache.tools.ant.taskdefs.MacroDef.NestedSequential nestedSequential) {
            int size = this.n.size();
            if (size != nestedSequential.n.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!((org.apache.tools.ant.UnknownElement) this.n.get(i)).similar((org.apache.tools.ant.UnknownElement) nestedSequential.n.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class TemplateElement {
        public java.lang.String a;
        public java.lang.String b;
        public boolean c = false;
        public boolean d = false;

        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !obj.getClass().equals(getClass())) {
                return false;
            }
            org.apache.tools.ant.taskdefs.MacroDef.TemplateElement templateElement = (org.apache.tools.ant.taskdefs.MacroDef.TemplateElement) obj;
            java.lang.String str = this.a;
            if (str != null ? str.equals(templateElement.a) : templateElement.a == null) {
                if (this.c == templateElement.c && this.d == templateElement.d) {
                    return true;
                }
            }
            return false;
        }

        public java.lang.String getDescription() {
            return this.b;
        }

        public java.lang.String getName() {
            return this.a;
        }

        public int hashCode() {
            return org.apache.tools.ant.taskdefs.MacroDef.g(this.a) + (this.c ? 1 : 0) + (this.d ? 1 : 0);
        }

        public boolean isImplicit() {
            return this.d;
        }

        public boolean isOptional() {
            return this.c;
        }

        public void setDescription(java.lang.String str) {
            this.b = str;
        }

        public void setImplicit(boolean z) {
            this.d = z;
        }

        public void setName(java.lang.String str) {
            if (org.apache.tools.ant.taskdefs.MacroDef.f(str)) {
                this.a = str.toLowerCase(java.util.Locale.ENGLISH);
                return;
            }
            throw new org.apache.tools.ant.BuildException("Illegal name [" + str + "] for macro element");
        }

        public void setOptional(boolean z) {
            this.c = z;
        }
    }

    public static class Text {
        public java.lang.String a;
        public boolean b;
        public boolean c;
        public java.lang.String d;
        public java.lang.String e;

        public boolean equals(java.lang.Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            org.apache.tools.ant.taskdefs.MacroDef.Text text = (org.apache.tools.ant.taskdefs.MacroDef.Text) obj;
            return org.apache.tools.ant.taskdefs.MacroDef.h(this.a, text.a) && this.b == text.b && this.c == text.c && org.apache.tools.ant.taskdefs.MacroDef.h(this.e, text.e);
        }

        public java.lang.String getDefault() {
            return this.e;
        }

        public java.lang.String getDescription() {
            return this.d;
        }

        public java.lang.String getName() {
            return this.a;
        }

        public boolean getOptional() {
            return this.b;
        }

        public boolean getTrim() {
            return this.c;
        }

        public int hashCode() {
            return org.apache.tools.ant.taskdefs.MacroDef.g(this.a);
        }

        public void setDefault(java.lang.String str) {
            this.e = str;
        }

        public void setDescription(java.lang.String str) {
            this.d = str;
        }

        public void setName(java.lang.String str) {
            if (org.apache.tools.ant.taskdefs.MacroDef.f(str)) {
                this.a = str.toLowerCase(java.util.Locale.ENGLISH);
                return;
            }
            throw new org.apache.tools.ant.BuildException("Illegal name [" + str + "] for attribute");
        }

        public void setOptional(boolean z) {
            this.b = z;
        }

        public void setTrim(boolean z) {
            this.c = z;
        }
    }

    public static boolean f(java.lang.String str) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!isValidNameCharacter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int g(java.lang.Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static boolean h(java.lang.Object obj, java.lang.Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean isValidNameCharacter(char c) {
        return java.lang.Character.isLetterOrDigit(c) || c == '.' || c == '-';
    }

    public void addConfiguredAttribute(org.apache.tools.ant.taskdefs.MacroDef.Attribute attribute) {
        if (attribute.getName() == null) {
            throw new org.apache.tools.ant.BuildException("the attribute nested element needed a \"name\" attribute");
        }
        if (attribute.getName().equals(this.B)) {
            throw new org.apache.tools.ant.BuildException("the name \"" + attribute.getName() + "\" has already been used by the text element");
        }
        this.z.size();
        java.util.Iterator<org.apache.tools.ant.taskdefs.MacroDef.Attribute> it = this.z.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(attribute.getName())) {
                throw new org.apache.tools.ant.BuildException("the name \"" + attribute.getName() + "\" has already been used in another attribute element");
            }
        }
        this.z.add(attribute);
    }

    public void addConfiguredElement(org.apache.tools.ant.taskdefs.MacroDef.TemplateElement templateElement) {
        if (templateElement.getName() == null) {
            throw new org.apache.tools.ant.BuildException("the element nested element needed a \"name\" attribute");
        }
        if (this.A.get(templateElement.getName()) != null) {
            throw new org.apache.tools.ant.BuildException("the element " + templateElement.getName() + " has already been specified");
        }
        if (this.D || (templateElement.isImplicit() && this.A.size() != 0)) {
            throw new org.apache.tools.ant.BuildException("Only one element allowed when using implicit elements");
        }
        this.D = templateElement.isImplicit();
        this.A.put(templateElement.getName(), templateElement);
    }

    public void addConfiguredText(org.apache.tools.ant.taskdefs.MacroDef.Text text) {
        if (this.C != null) {
            throw new org.apache.tools.ant.BuildException("Only one nested text element allowed");
        }
        if (text.getName() == null) {
            throw new org.apache.tools.ant.BuildException("the text nested element needed a \"name\" attribute");
        }
        java.util.Iterator<org.apache.tools.ant.taskdefs.MacroDef.Attribute> it = this.z.iterator();
        while (it.hasNext()) {
            if (text.getName().equals(it.next().getName())) {
                throw new org.apache.tools.ant.BuildException("the name \"" + text.getName() + "\" is already used as an attribute");
            }
        }
        this.C = text;
        this.B = text.getName();
    }

    public org.apache.tools.ant.taskdefs.MacroDef.NestedSequential createSequential() {
        if (this.w != null) {
            throw new org.apache.tools.ant.BuildException("Only one sequential allowed");
        }
        org.apache.tools.ant.taskdefs.MacroDef.NestedSequential nestedSequential = new org.apache.tools.ant.taskdefs.MacroDef.NestedSequential();
        this.w = nestedSequential;
        return nestedSequential;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        if (this.w == null) {
            throw new org.apache.tools.ant.BuildException("Missing sequential element");
        }
        if (this.x == null) {
            throw new org.apache.tools.ant.BuildException("Name not specified");
        }
        this.x = org.apache.tools.ant.ProjectHelper.genComponentName(getURI(), this.x);
        org.apache.tools.ant.taskdefs.MacroDef.MyAntTypeDefinition myAntTypeDefinition = new org.apache.tools.ant.taskdefs.MacroDef.MyAntTypeDefinition(this);
        myAntTypeDefinition.setName(this.x);
        myAntTypeDefinition.setClass(org.apache.tools.ant.taskdefs.MacroInstance.class);
        org.apache.tools.ant.ComponentHelper.getComponentHelper(getProject()).addDataTypeDefinition(myAntTypeDefinition);
        log("creating macro  " + this.x, 3);
    }

    public java.util.List<org.apache.tools.ant.taskdefs.MacroDef.Attribute> getAttributes() {
        return this.z;
    }

    public boolean getBackTrace() {
        return this.y;
    }

    public java.util.Map<java.lang.String, org.apache.tools.ant.taskdefs.MacroDef.TemplateElement> getElements() {
        return this.A;
    }

    public org.apache.tools.ant.UnknownElement getNestedTask() {
        org.apache.tools.ant.UnknownElement unknownElement = new org.apache.tools.ant.UnknownElement(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_SEQUENTIAL);
        unknownElement.setTaskName(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_SEQUENTIAL);
        unknownElement.setNamespace("");
        unknownElement.setQName(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_SEQUENTIAL);
        new org.apache.tools.ant.RuntimeConfigurable(unknownElement, com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_SEQUENTIAL);
        int size = this.w.getNested().size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.UnknownElement unknownElement2 = (org.apache.tools.ant.UnknownElement) this.w.getNested().get(i);
            unknownElement.addChild(unknownElement2);
            unknownElement.getWrapper().addChild(unknownElement2.getWrapper());
        }
        return unknownElement;
    }

    public org.apache.tools.ant.taskdefs.MacroDef.Text getText() {
        return this.C;
    }

    public final boolean i(java.lang.Object obj, boolean z) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        org.apache.tools.ant.taskdefs.MacroDef macroDef = (org.apache.tools.ant.taskdefs.MacroDef) obj;
        java.lang.String str = this.x;
        if (str == null) {
            return macroDef.x == null;
        }
        if (!str.equals(macroDef.x)) {
            return false;
        }
        if (macroDef.getLocation() != null && macroDef.getLocation().equals(getLocation()) && !z) {
            return true;
        }
        org.apache.tools.ant.taskdefs.MacroDef.Text text = this.C;
        if (text == null) {
            if (macroDef.C != null) {
                return false;
            }
        } else if (!text.equals(macroDef.C)) {
            return false;
        }
        if (getURI() == null || getURI().equals("") || getURI().equals(org.apache.tools.ant.ProjectHelper.ANT_CORE_URI)) {
            if (macroDef.getURI() != null && !macroDef.getURI().equals("") && !macroDef.getURI().equals(org.apache.tools.ant.ProjectHelper.ANT_CORE_URI)) {
                return false;
            }
        } else if (!getURI().equals(macroDef.getURI())) {
            return false;
        }
        return this.w.similar(macroDef.w) && this.z.equals(macroDef.z) && this.A.equals(macroDef.A);
    }

    public boolean sameDefinition(java.lang.Object obj) {
        return i(obj, true);
    }

    public void setBackTrace(boolean z) {
        this.y = z;
    }

    public void setName(java.lang.String str) {
        this.x = str;
    }

    public boolean similar(java.lang.Object obj) {
        return i(obj, false);
    }
}
