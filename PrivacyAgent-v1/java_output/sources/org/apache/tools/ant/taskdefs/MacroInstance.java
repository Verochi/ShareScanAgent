package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class MacroInstance extends org.apache.tools.ant.Task implements org.apache.tools.ant.DynamicAttribute, org.apache.tools.ant.TaskContainer {
    public org.apache.tools.ant.taskdefs.MacroDef u;
    public java.util.Map<java.lang.String, org.apache.tools.ant.UnknownElement> x;
    public java.util.Hashtable<java.lang.String, java.lang.String> y;
    public java.util.Map<java.lang.String, java.lang.String> v = new java.util.HashMap();
    public java.util.Map<java.lang.String, org.apache.tools.ant.taskdefs.MacroDef.TemplateElement> w = null;
    public java.lang.String z = null;
    public java.lang.String A = null;
    public java.util.List<org.apache.tools.ant.Task> B = new java.util.ArrayList();

    public static class Element implements org.apache.tools.ant.TaskContainer {
        public java.util.List<org.apache.tools.ant.Task> n = new java.util.ArrayList();

        @Override // org.apache.tools.ant.TaskContainer
        public void addTask(org.apache.tools.ant.Task task) {
            this.n.add(task);
        }

        public java.util.List<org.apache.tools.ant.Task> getUnknownElements() {
            return this.n;
        }
    }

    @Override // org.apache.tools.ant.TaskContainer
    public void addTask(org.apache.tools.ant.Task task) {
        this.B.add(task);
    }

    public void addText(java.lang.String str) {
        this.z = str;
    }

    public final org.apache.tools.ant.UnknownElement c(org.apache.tools.ant.UnknownElement unknownElement, boolean z) {
        org.apache.tools.ant.UnknownElement unknownElement2 = new org.apache.tools.ant.UnknownElement(unknownElement.getTag());
        unknownElement2.setNamespace(unknownElement.getNamespace());
        unknownElement2.setProject(getProject());
        unknownElement2.setQName(unknownElement.getQName());
        unknownElement2.setTaskType(unknownElement.getTaskType());
        unknownElement2.setTaskName(unknownElement.getTaskName());
        unknownElement2.setLocation(this.u.getBackTrace() ? unknownElement.getLocation() : getLocation());
        if (getOwningTarget() == null) {
            org.apache.tools.ant.Target target = new org.apache.tools.ant.Target();
            target.setProject(getProject());
            unknownElement2.setOwningTarget(target);
        } else {
            unknownElement2.setOwningTarget(getOwningTarget());
        }
        org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable = new org.apache.tools.ant.RuntimeConfigurable(unknownElement2, unknownElement.getTaskName());
        runtimeConfigurable.setPolyType(unknownElement.getWrapper().getPolyType());
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : unknownElement.getWrapper().getAttributeMap().entrySet()) {
            runtimeConfigurable.setAttribute(entry.getKey(), e((java.lang.String) entry.getValue(), this.y));
        }
        runtimeConfigurable.addText(e(unknownElement.getWrapper().getText().toString(), this.y));
        java.util.Enumeration<org.apache.tools.ant.RuntimeConfigurable> children = unknownElement.getWrapper().getChildren();
        while (children.hasMoreElements()) {
            org.apache.tools.ant.UnknownElement unknownElement3 = (org.apache.tools.ant.UnknownElement) children.nextElement().getProxy();
            java.lang.String taskType = unknownElement3.getTaskType();
            if (taskType != null) {
                taskType = taskType.toLowerCase(java.util.Locale.ENGLISH);
            }
            org.apache.tools.ant.taskdefs.MacroDef.TemplateElement templateElement = d().get(taskType);
            if (templateElement == null || z) {
                org.apache.tools.ant.UnknownElement c = c(unknownElement3, z);
                runtimeConfigurable.addChild(c.getWrapper());
                unknownElement2.addChild(c);
            } else if (!templateElement.isImplicit()) {
                org.apache.tools.ant.UnknownElement unknownElement4 = this.x.get(taskType);
                if (unknownElement4 != null) {
                    java.lang.String stringBuffer = unknownElement4.getWrapper().getText().toString();
                    if (!"".equals(stringBuffer)) {
                        runtimeConfigurable.addText(e(stringBuffer, this.y));
                    }
                    java.util.List<org.apache.tools.ant.UnknownElement> children2 = unknownElement4.getChildren();
                    if (children2 != null) {
                        java.util.Iterator<org.apache.tools.ant.UnknownElement> it = children2.iterator();
                        while (it.hasNext()) {
                            org.apache.tools.ant.UnknownElement c2 = c(it.next(), true);
                            runtimeConfigurable.addChild(c2.getWrapper());
                            unknownElement2.addChild(c2);
                        }
                    }
                } else if (!templateElement.isOptional()) {
                    throw new org.apache.tools.ant.BuildException("Required nested element " + templateElement.getName() + " missing");
                }
            } else {
                if (this.B.size() == 0 && !templateElement.isOptional()) {
                    throw new org.apache.tools.ant.BuildException("Missing nested elements for implicit element " + templateElement.getName());
                }
                java.util.Iterator<org.apache.tools.ant.Task> it2 = this.B.iterator();
                while (it2.hasNext()) {
                    org.apache.tools.ant.UnknownElement c3 = c((org.apache.tools.ant.UnknownElement) it2.next(), true);
                    runtimeConfigurable.addChild(c3.getWrapper());
                    unknownElement2.addChild(c3);
                }
            }
        }
        return unknownElement2;
    }

    public java.lang.Object createDynamicElement(java.lang.String str) throws org.apache.tools.ant.BuildException {
        throw new org.apache.tools.ant.BuildException("Not implemented any more");
    }

    public final java.util.Map<java.lang.String, org.apache.tools.ant.taskdefs.MacroDef.TemplateElement> d() {
        if (this.w == null) {
            this.w = new java.util.HashMap();
            for (java.util.Map.Entry<java.lang.String, org.apache.tools.ant.taskdefs.MacroDef.TemplateElement> entry : this.u.getElements().entrySet()) {
                this.w.put(entry.getKey(), entry.getValue());
                org.apache.tools.ant.taskdefs.MacroDef.TemplateElement value = entry.getValue();
                if (value.isImplicit()) {
                    this.A = value.getName();
                }
            }
        }
        return this.w;
    }

    public final java.lang.String e(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (str == null) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.StringBuffer stringBuffer2 = null;
        char c = 0;
        for (char c2 : str.toCharArray()) {
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        if (c2 == '}') {
                            java.lang.String lowerCase = stringBuffer2.toString().toLowerCase(java.util.Locale.ENGLISH);
                            java.lang.String str2 = map.get(lowerCase);
                            if (str2 == null) {
                                stringBuffer.append("@{");
                                stringBuffer.append(lowerCase);
                                stringBuffer.append(com.alipay.sdk.m.u.i.d);
                            } else {
                                stringBuffer.append(str2);
                            }
                            stringBuffer2 = null;
                            c = 0;
                        } else {
                            stringBuffer2.append(c2);
                        }
                    }
                } else if (c2 == '{') {
                    stringBuffer2 = new java.lang.StringBuffer();
                    c = 2;
                } else {
                    if (c2 == '@') {
                        stringBuffer.append('@');
                    } else {
                        stringBuffer.append('@');
                        stringBuffer.append(c2);
                    }
                    c = 0;
                }
            } else if (c2 == '@') {
                c = 1;
            } else {
                stringBuffer.append(c2);
            }
        }
        if (c == 1) {
            stringBuffer.append('@');
        } else if (c == 2) {
            stringBuffer.append("@{");
            stringBuffer.append(stringBuffer2.toString());
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        this.x = new java.util.HashMap();
        d();
        f();
        this.y = new java.util.Hashtable<>();
        java.util.HashSet hashSet = new java.util.HashSet(this.v.keySet());
        for (org.apache.tools.ant.taskdefs.MacroDef.Attribute attribute : this.u.getAttributes()) {
            java.lang.String str = this.v.get(attribute.getName());
            if (str == null && "description".equals(attribute.getName())) {
                str = getDescription();
            }
            if (str == null) {
                str = e(attribute.getDefault(), this.y);
            }
            if (str == null) {
                throw new org.apache.tools.ant.BuildException("required attribute " + attribute.getName() + " not set");
            }
            this.y.put(attribute.getName(), str);
            hashSet.remove(attribute.getName());
        }
        if (hashSet.contains("id")) {
            hashSet.remove("id");
        }
        if (this.u.getText() != null) {
            if (this.z == null) {
                java.lang.String str2 = this.u.getText().getDefault();
                if (!this.u.getText().getOptional() && str2 == null) {
                    throw new org.apache.tools.ant.BuildException("required text missing");
                }
                this.z = str2 != null ? str2 : "";
            }
            if (this.u.getText().getTrim()) {
                this.z = this.z.trim();
            }
            this.y.put(this.u.getText().getName(), this.z);
        } else {
            java.lang.String str3 = this.z;
            if (str3 != null && !str3.trim().equals("")) {
                throw new org.apache.tools.ant.BuildException("The \"" + getTaskName() + "\" macro does not support nested text data.");
            }
        }
        if (hashSet.size() != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Unknown attribute");
            sb.append(hashSet.size() > 1 ? "s " : " ");
            sb.append(hashSet);
            throw new org.apache.tools.ant.BuildException(sb.toString());
        }
        org.apache.tools.ant.UnknownElement c = c(this.u.getNestedTask(), false);
        c.init();
        org.apache.tools.ant.property.LocalProperties localProperties = org.apache.tools.ant.property.LocalProperties.get(getProject());
        localProperties.enterScope();
        try {
            try {
                c.perform();
            } catch (org.apache.tools.ant.BuildException e) {
                if (this.u.getBackTrace()) {
                    throw org.apache.tools.ant.ProjectHelper.addLocationToBuildException(e, getLocation());
                }
                e.setLocation(getLocation());
                throw e;
            }
        } finally {
            this.x = null;
            this.y = null;
            localProperties.exitScope();
        }
    }

    public final void f() {
        if (this.A != null) {
            return;
        }
        java.util.Iterator<org.apache.tools.ant.Task> it = this.B.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.UnknownElement unknownElement = (org.apache.tools.ant.UnknownElement) it.next();
            java.lang.String lowerCase = org.apache.tools.ant.ProjectHelper.extractNameFromComponentName(unknownElement.getTag()).toLowerCase(java.util.Locale.ENGLISH);
            if (d().get(lowerCase) == null) {
                throw new org.apache.tools.ant.BuildException("unsupported element " + lowerCase);
            }
            if (this.x.get(lowerCase) != null) {
                throw new org.apache.tools.ant.BuildException("Element " + lowerCase + " already present");
            }
            this.x.put(lowerCase, unknownElement);
        }
    }

    public org.apache.tools.ant.taskdefs.MacroDef getMacroDef() {
        return this.u;
    }

    @Override // org.apache.tools.ant.DynamicAttribute
    public void setDynamicAttribute(java.lang.String str, java.lang.String str2) {
        this.v.put(str.toLowerCase(java.util.Locale.ENGLISH), str2);
    }

    public void setMacroDef(org.apache.tools.ant.taskdefs.MacroDef macroDef) {
        this.u = macroDef;
    }
}
