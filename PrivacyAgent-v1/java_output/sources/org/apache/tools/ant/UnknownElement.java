package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class UnknownElement extends org.apache.tools.ant.Task {
    public final java.lang.String u;
    public java.lang.String w;
    public java.lang.Object x;
    public java.lang.String v = "";
    public java.util.List<org.apache.tools.ant.UnknownElement> y = null;
    public boolean z = false;

    public UnknownElement(java.lang.String str) {
        this.u = str;
    }

    public static boolean c(java.lang.String str, java.lang.String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public void addChild(org.apache.tools.ant.UnknownElement unknownElement) {
        if (this.y == null) {
            this.y = new java.util.ArrayList();
        }
        this.y.add(unknownElement);
    }

    public void applyPreSet(org.apache.tools.ant.UnknownElement unknownElement) {
        if (this.z) {
            return;
        }
        getWrapper().applyPreSet(unknownElement.getWrapper());
        if (unknownElement.y != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList(unknownElement.y);
            java.util.List<org.apache.tools.ant.UnknownElement> list = this.y;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.y = arrayList;
        }
        this.z = true;
    }

    public void configure(java.lang.Object obj) {
        org.apache.tools.ant.Task task;
        if (obj == null) {
            return;
        }
        this.x = obj;
        getWrapper().setProxy(this.x);
        java.lang.Object obj2 = this.x;
        if (obj2 instanceof org.apache.tools.ant.Task) {
            task = (org.apache.tools.ant.Task) obj2;
            task.setRuntimeConfigurableWrapper(getWrapper());
            if (getWrapper().getId() != null) {
                getOwningTarget().a(this, (org.apache.tools.ant.Task) this.x);
            }
        } else {
            task = null;
        }
        if (task != null) {
            task.maybeConfigure();
        } else {
            getWrapper().maybeConfigure(getProject());
        }
        handleChildren(this.x, getWrapper());
    }

    public org.apache.tools.ant.UnknownElement copy(org.apache.tools.ant.Project project) {
        org.apache.tools.ant.UnknownElement unknownElement = new org.apache.tools.ant.UnknownElement(getTag());
        unknownElement.setNamespace(getNamespace());
        unknownElement.setProject(project);
        unknownElement.setQName(getQName());
        unknownElement.setTaskType(getTaskType());
        unknownElement.setTaskName(getTaskName());
        unknownElement.setLocation(getLocation());
        if (getOwningTarget() == null) {
            org.apache.tools.ant.Target target = new org.apache.tools.ant.Target();
            target.setProject(getProject());
            unknownElement.setOwningTarget(target);
        } else {
            unknownElement.setOwningTarget(getOwningTarget());
        }
        org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable = new org.apache.tools.ant.RuntimeConfigurable(unknownElement, getTaskName());
        runtimeConfigurable.setPolyType(getWrapper().getPolyType());
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : getWrapper().getAttributeMap().entrySet()) {
            runtimeConfigurable.setAttribute(entry.getKey(), (java.lang.String) entry.getValue());
        }
        runtimeConfigurable.addText(getWrapper().getText().toString());
        java.util.Enumeration<org.apache.tools.ant.RuntimeConfigurable> children = getWrapper().getChildren();
        while (children.hasMoreElements()) {
            org.apache.tools.ant.UnknownElement copy = ((org.apache.tools.ant.UnknownElement) children.nextElement().getProxy()).copy(project);
            runtimeConfigurable.addChild(copy.getWrapper());
            unknownElement.addChild(copy);
        }
        return unknownElement;
    }

    public final boolean d(java.lang.String str, org.apache.tools.ant.IntrospectionHelper introspectionHelper, java.lang.Object obj, org.apache.tools.ant.UnknownElement unknownElement, org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) {
        java.lang.String genComponentName = org.apache.tools.ant.ProjectHelper.genComponentName(unknownElement.getNamespace(), unknownElement.getTag());
        if (!introspectionHelper.supportsNestedElement(str, genComponentName, getProject(), obj)) {
            return false;
        }
        try {
            org.apache.tools.ant.IntrospectionHelper.Creator elementCreator = introspectionHelper.getElementCreator(getProject(), str, obj, genComponentName, unknownElement);
            elementCreator.setPolyType(runtimeConfigurable.getPolyType());
            java.lang.Object create = elementCreator.create();
            if (create instanceof org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) {
                java.lang.Object realObject = elementCreator.getRealObject();
                unknownElement.applyPreSet(((org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) create).getPreSets());
                create = realObject;
            }
            runtimeConfigurable.setCreator(elementCreator);
            runtimeConfigurable.setProxy(create);
            if (create instanceof org.apache.tools.ant.Task) {
                org.apache.tools.ant.Task task = (org.apache.tools.ant.Task) create;
                task.setRuntimeConfigurableWrapper(runtimeConfigurable);
                task.setTaskName(genComponentName);
                task.setTaskType(genComponentName);
            }
            if (create instanceof org.apache.tools.ant.ProjectComponent) {
                ((org.apache.tools.ant.ProjectComponent) create).setLocation(unknownElement.getLocation());
            }
            runtimeConfigurable.maybeConfigure(getProject());
            unknownElement.handleChildren(create, runtimeConfigurable);
            elementCreator.store();
            return true;
        } catch (org.apache.tools.ant.UnsupportedElementException e) {
            if (introspectionHelper.isDynamic()) {
                return false;
            }
            throw e;
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        java.lang.Object obj = this.x;
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof org.apache.tools.ant.Task) {
                ((org.apache.tools.ant.Task) obj).execute();
            }
        } finally {
            if (getWrapper().getId() == null) {
                this.x = null;
                getWrapper().setProxy(null);
            }
        }
    }

    public java.util.List<org.apache.tools.ant.UnknownElement> getChildren() {
        return this.y;
    }

    public java.lang.String getComponentName() {
        return org.apache.tools.ant.ProjectHelper.genComponentName(getNamespace(), getTag());
    }

    public java.lang.String getNamespace() {
        return this.v;
    }

    public org.apache.tools.ant.BuildException getNotFoundException(java.lang.String str, java.lang.String str2) {
        return new org.apache.tools.ant.BuildException(org.apache.tools.ant.ComponentHelper.getComponentHelper(getProject()).diagnoseCreationFailure(str2, str), getLocation());
    }

    public java.lang.String getQName() {
        return this.w;
    }

    public java.lang.Object getRealThing() {
        return this.x;
    }

    public java.lang.String getTag() {
        return this.u;
    }

    public org.apache.tools.ant.Task getTask() {
        java.lang.Object obj = this.x;
        if (obj instanceof org.apache.tools.ant.Task) {
            return (org.apache.tools.ant.Task) obj;
        }
        return null;
    }

    @Override // org.apache.tools.ant.Task
    public java.lang.String getTaskName() {
        java.lang.Object obj = this.x;
        return (obj == null || !(obj instanceof org.apache.tools.ant.Task)) ? super.getTaskName() : ((org.apache.tools.ant.Task) obj).getTaskName();
    }

    @Override // org.apache.tools.ant.Task
    public org.apache.tools.ant.RuntimeConfigurable getWrapper() {
        return super.getWrapper();
    }

    public void handleChildren(java.lang.Object obj, org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) throws org.apache.tools.ant.BuildException {
        if (obj instanceof org.apache.tools.ant.TypeAdapter) {
            obj = ((org.apache.tools.ant.TypeAdapter) obj).getProxy();
        }
        java.lang.String namespace = getNamespace();
        org.apache.tools.ant.IntrospectionHelper helper = org.apache.tools.ant.IntrospectionHelper.getHelper(getProject(), obj.getClass());
        java.util.List<org.apache.tools.ant.UnknownElement> list = this.y;
        if (list != null) {
            int i = 0;
            for (org.apache.tools.ant.UnknownElement unknownElement : list) {
                org.apache.tools.ant.RuntimeConfigurable child = runtimeConfigurable.getChild(i);
                try {
                    if ((child.isEnabled(unknownElement) || !helper.supportsNestedElement(namespace, org.apache.tools.ant.ProjectHelper.genComponentName(unknownElement.getNamespace(), unknownElement.getTag()))) && !d(namespace, helper, obj, unknownElement, child)) {
                        if (obj instanceof org.apache.tools.ant.TaskContainer) {
                            ((org.apache.tools.ant.TaskContainer) obj).addTask(unknownElement);
                        } else {
                            helper.throwNotSupported(getProject(), obj, unknownElement.getTag());
                        }
                    }
                    i++;
                } catch (org.apache.tools.ant.UnsupportedElementException e) {
                    throw new org.apache.tools.ant.BuildException(runtimeConfigurable.getElementTag() + " doesn't support the nested \"" + e.getElement() + "\" element.", e);
                }
            }
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorFlush(java.lang.String str) {
        java.lang.Object obj = this.x;
        if (obj instanceof org.apache.tools.ant.Task) {
            ((org.apache.tools.ant.Task) obj).handleErrorFlush(str);
        } else {
            super.handleErrorFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorOutput(java.lang.String str) {
        java.lang.Object obj = this.x;
        if (obj instanceof org.apache.tools.ant.Task) {
            ((org.apache.tools.ant.Task) obj).handleErrorOutput(str);
        } else {
            super.handleErrorOutput(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleFlush(java.lang.String str) {
        java.lang.Object obj = this.x;
        if (obj instanceof org.apache.tools.ant.Task) {
            ((org.apache.tools.ant.Task) obj).handleFlush(str);
        } else {
            super.handleFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public int handleInput(byte[] bArr, int i, int i2) throws java.io.IOException {
        java.lang.Object obj = this.x;
        return obj instanceof org.apache.tools.ant.Task ? ((org.apache.tools.ant.Task) obj).handleInput(bArr, i, i2) : super.handleInput(bArr, i, i2);
    }

    @Override // org.apache.tools.ant.Task
    public void handleOutput(java.lang.String str) {
        java.lang.Object obj = this.x;
        if (obj instanceof org.apache.tools.ant.Task) {
            ((org.apache.tools.ant.Task) obj).handleOutput(str);
        } else {
            super.handleOutput(str);
        }
    }

    public java.lang.Object makeObject(org.apache.tools.ant.UnknownElement unknownElement, org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) {
        if (!runtimeConfigurable.isEnabled(unknownElement)) {
            return null;
        }
        org.apache.tools.ant.ComponentHelper componentHelper = org.apache.tools.ant.ComponentHelper.getComponentHelper(getProject());
        java.lang.String componentName = unknownElement.getComponentName();
        java.lang.Object createComponent = componentHelper.createComponent(unknownElement, unknownElement.getNamespace(), componentName);
        if (createComponent == null) {
            throw getNotFoundException("task or type", componentName);
        }
        if (createComponent instanceof org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) {
            org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition preSetDefinition = (org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) createComponent;
            java.lang.Object createObject = preSetDefinition.createObject(unknownElement.getProject());
            if (createObject == null) {
                throw getNotFoundException("preset " + componentName, preSetDefinition.getPreSets().getComponentName());
            }
            unknownElement.applyPreSet(preSetDefinition.getPreSets());
            if (createObject instanceof org.apache.tools.ant.Task) {
                org.apache.tools.ant.Task task = (org.apache.tools.ant.Task) createObject;
                task.setTaskType(unknownElement.getTaskType());
                task.setTaskName(unknownElement.getTaskName());
                task.init();
            }
            createComponent = createObject;
        }
        if (createComponent instanceof org.apache.tools.ant.UnknownElement) {
            org.apache.tools.ant.UnknownElement unknownElement2 = (org.apache.tools.ant.UnknownElement) createComponent;
            createComponent = unknownElement2.makeObject(unknownElement2, runtimeConfigurable);
        }
        if (createComponent instanceof org.apache.tools.ant.Task) {
            ((org.apache.tools.ant.Task) createComponent).setOwningTarget(getOwningTarget());
        }
        if (createComponent instanceof org.apache.tools.ant.ProjectComponent) {
            ((org.apache.tools.ant.ProjectComponent) createComponent).setLocation(getLocation());
        }
        return createComponent;
    }

    public org.apache.tools.ant.Task makeTask(org.apache.tools.ant.UnknownElement unknownElement, org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) {
        org.apache.tools.ant.Task createTask = getProject().createTask(unknownElement.getTag());
        if (createTask != null) {
            createTask.setLocation(getLocation());
            createTask.setOwningTarget(getOwningTarget());
            createTask.init();
        }
        return createTask;
    }

    @Override // org.apache.tools.ant.Task
    public void maybeConfigure() throws org.apache.tools.ant.BuildException {
        if (this.x != null) {
            return;
        }
        configure(makeObject(this, getWrapper()));
    }

    public void setNamespace(java.lang.String str) {
        if (str.equals(org.apache.tools.ant.ProjectHelper.ANT_CURRENT_URI)) {
            str = org.apache.tools.ant.ComponentHelper.getComponentHelper(getProject()).getCurrentAntlibUri();
        }
        if (str == null) {
            str = "";
        }
        this.v = str;
    }

    public void setQName(java.lang.String str) {
        this.w = str;
    }

    public void setRealThing(java.lang.Object obj) {
        this.x = obj;
    }

    public boolean similar(java.lang.Object obj) {
        if (obj == null || !getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        org.apache.tools.ant.UnknownElement unknownElement = (org.apache.tools.ant.UnknownElement) obj;
        if (!c(this.u, unknownElement.u) || !this.v.equals(unknownElement.v) || !this.w.equals(unknownElement.w) || !getWrapper().getAttributeMap().equals(unknownElement.getWrapper().getAttributeMap()) || !getWrapper().getText().toString().equals(unknownElement.getWrapper().getText().toString())) {
            return false;
        }
        java.util.List<org.apache.tools.ant.UnknownElement> list = this.y;
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            java.util.List<org.apache.tools.ant.UnknownElement> list2 = unknownElement.y;
            return list2 == null || list2.size() == 0;
        }
        java.util.List<org.apache.tools.ant.UnknownElement> list3 = unknownElement.y;
        if (list3 == null || size != list3.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.y.get(i).similar(unknownElement.y.get(i))) {
                return false;
            }
        }
        return true;
    }
}
