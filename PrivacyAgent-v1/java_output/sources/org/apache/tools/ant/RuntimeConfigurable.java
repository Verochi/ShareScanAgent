package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class RuntimeConfigurable implements java.io.Serializable {
    private static final java.util.Hashtable<java.lang.String, java.lang.Object> EMPTY_HASHTABLE = new java.util.Hashtable<>(0);
    private static final long serialVersionUID = 1;

    @java.lang.Deprecated
    private transient org.xml.sax.AttributeList attributes;
    private java.lang.String elementTag = null;
    private java.util.ArrayList<org.apache.tools.ant.RuntimeConfigurable> children = null;
    private transient java.lang.Object wrappedObject = null;
    private transient boolean namespacedAttribute = false;
    private java.util.LinkedHashMap<java.lang.String, java.lang.Object> attributeMap = null;
    private java.lang.StringBuffer characters = null;
    private boolean proxyConfigured = false;
    private java.lang.String polyType = null;
    private java.lang.String id = null;

    public static class AttributeComponentInformation {
        public java.lang.String a;
        public boolean b;

        public AttributeComponentInformation(java.lang.String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public /* synthetic */ AttributeComponentInformation(java.lang.String str, boolean z, org.apache.tools.ant.RuntimeConfigurable.AnonymousClass1 anonymousClass1) {
            this(str, z);
        }

        public java.lang.String a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }
    }

    public static class EnableAttributeConsumer {
        public EnableAttributeConsumer() {
        }

        public /* synthetic */ EnableAttributeConsumer(org.apache.tools.ant.RuntimeConfigurable.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public RuntimeConfigurable(java.lang.Object obj, java.lang.String str) {
        setProxy(obj);
        setElementTag(str);
        if (obj instanceof org.apache.tools.ant.Task) {
            ((org.apache.tools.ant.Task) obj).setRuntimeConfigurableWrapper(this);
        }
    }

    private java.lang.String attrToComponent(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(58);
        return str.substring(0, str.lastIndexOf(58, lastIndexOf - 1)) + str.substring(lastIndexOf);
    }

    private org.apache.tools.ant.RuntimeConfigurable.AttributeComponentInformation isRestrictedAttribute(java.lang.String str, org.apache.tools.ant.ComponentHelper componentHelper) {
        if (str.indexOf(58) == -1) {
            return new org.apache.tools.ant.RuntimeConfigurable.AttributeComponentInformation(null, false, null);
        }
        java.lang.String attrToComponent = attrToComponent(str);
        return componentHelper.getRestrictedDefinitions(org.apache.tools.ant.ProjectHelper.nsToComponentName(org.apache.tools.ant.ProjectHelper.extractUriFromComponentName(attrToComponent))) == null ? new org.apache.tools.ant.RuntimeConfigurable.AttributeComponentInformation(null, false, null) : new org.apache.tools.ant.RuntimeConfigurable.AttributeComponentInformation(attrToComponent, true, null);
    }

    public synchronized void addChild(org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) {
        java.util.ArrayList<org.apache.tools.ant.RuntimeConfigurable> arrayList = this.children;
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
        }
        this.children = arrayList;
        arrayList.add(runtimeConfigurable);
    }

    public synchronized void addText(java.lang.String str) {
        if (str.length() == 0) {
            return;
        }
        java.lang.StringBuffer stringBuffer = this.characters;
        if (stringBuffer == null) {
            stringBuffer = new java.lang.StringBuffer(str);
        } else {
            stringBuffer.append(str);
        }
        this.characters = stringBuffer;
    }

    public synchronized void addText(char[] cArr, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        java.lang.StringBuffer stringBuffer = this.characters;
        if (stringBuffer == null) {
            stringBuffer = new java.lang.StringBuffer(i2);
        }
        stringBuffer.append(cArr, i, i2);
        this.characters = stringBuffer;
    }

    public void applyPreSet(org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) {
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap = runtimeConfigurable.attributeMap;
        if (linkedHashMap != null) {
            for (java.lang.String str : linkedHashMap.keySet()) {
                java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap2 = this.attributeMap;
                if (linkedHashMap2 == null || linkedHashMap2.get(str) == null) {
                    setAttribute(str, (java.lang.String) runtimeConfigurable.attributeMap.get(str));
                }
            }
        }
        java.lang.String str2 = this.polyType;
        if (str2 == null) {
            str2 = runtimeConfigurable.polyType;
        }
        this.polyType = str2;
        if (runtimeConfigurable.children != null) {
            java.util.ArrayList<org.apache.tools.ant.RuntimeConfigurable> arrayList = new java.util.ArrayList<>(runtimeConfigurable.children);
            java.util.ArrayList<org.apache.tools.ant.RuntimeConfigurable> arrayList2 = this.children;
            if (arrayList2 != null) {
                arrayList.addAll(arrayList2);
            }
            this.children = arrayList;
        }
        if (runtimeConfigurable.characters != null) {
            java.lang.StringBuffer stringBuffer = this.characters;
            if (stringBuffer == null || stringBuffer.toString().trim().length() == 0) {
                this.characters = new java.lang.StringBuffer(runtimeConfigurable.characters.toString());
            }
        }
    }

    public synchronized java.util.Hashtable<java.lang.String, java.lang.Object> getAttributeMap() {
        return this.attributeMap == null ? EMPTY_HASHTABLE : new java.util.Hashtable<>(this.attributeMap);
    }

    @java.lang.Deprecated
    public synchronized org.xml.sax.AttributeList getAttributes() {
        return this.attributes;
    }

    public synchronized org.apache.tools.ant.RuntimeConfigurable getChild(int i) {
        return this.children.get(i);
    }

    public synchronized java.util.Enumeration<org.apache.tools.ant.RuntimeConfigurable> getChildren() {
        java.util.ArrayList<org.apache.tools.ant.RuntimeConfigurable> arrayList;
        arrayList = this.children;
        return arrayList == null ? new org.apache.tools.ant.util.CollectionUtils.EmptyEnumeration<>() : java.util.Collections.enumeration(arrayList);
    }

    public synchronized java.lang.String getElementTag() {
        return this.elementTag;
    }

    public synchronized java.lang.String getId() {
        return this.id;
    }

    public synchronized java.lang.String getPolyType() {
        return this.polyType;
    }

    public synchronized java.lang.Object getProxy() {
        return this.wrappedObject;
    }

    public synchronized java.lang.StringBuffer getText() {
        java.lang.StringBuffer stringBuffer;
        stringBuffer = this.characters;
        if (stringBuffer == null) {
            stringBuffer = new java.lang.StringBuffer(0);
        }
        return stringBuffer;
    }

    public boolean isEnabled(org.apache.tools.ant.UnknownElement unknownElement) {
        if (!this.namespacedAttribute) {
            return true;
        }
        org.apache.tools.ant.ComponentHelper componentHelper = org.apache.tools.ant.ComponentHelper.getComponentHelper(unknownElement.getProject());
        org.apache.tools.ant.IntrospectionHelper helper = org.apache.tools.ant.IntrospectionHelper.getHelper(unknownElement.getProject(), org.apache.tools.ant.RuntimeConfigurable.EnableAttributeConsumer.class);
        for (int i = 0; i < this.attributeMap.keySet().size(); i++) {
            java.lang.String str = (java.lang.String) this.attributeMap.keySet().toArray()[i];
            org.apache.tools.ant.RuntimeConfigurable.AttributeComponentInformation isRestrictedAttribute = isRestrictedAttribute(str, componentHelper);
            if (isRestrictedAttribute.b()) {
                java.lang.String str2 = (java.lang.String) this.attributeMap.get(str);
                try {
                    org.apache.tools.ant.attribute.EnableAttribute enableAttribute = (org.apache.tools.ant.attribute.EnableAttribute) helper.createElement(unknownElement.getProject(), new org.apache.tools.ant.RuntimeConfigurable.EnableAttributeConsumer(null), isRestrictedAttribute.a());
                    if (enableAttribute != null && !enableAttribute.isEnabled(unknownElement, unknownElement.getProject().replaceProperties(str2))) {
                        return false;
                    }
                } catch (org.apache.tools.ant.BuildException unused) {
                    throw new org.apache.tools.ant.BuildException("Unsupported attribute " + isRestrictedAttribute.a());
                }
            }
        }
        return true;
    }

    public void maybeConfigure(org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        maybeConfigure(project, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        if (r7.isDoubleExpanding() == false) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void maybeConfigure(org.apache.tools.ant.Project project, boolean z) throws org.apache.tools.ant.BuildException {
        if (this.proxyConfigured) {
            return;
        }
        java.lang.Object obj = this.wrappedObject;
        if (obj instanceof org.apache.tools.ant.TypeAdapter) {
            obj = ((org.apache.tools.ant.TypeAdapter) obj).getProxy();
        }
        org.apache.tools.ant.IntrospectionHelper helper = org.apache.tools.ant.IntrospectionHelper.getHelper(project, obj.getClass());
        org.apache.tools.ant.ComponentHelper componentHelper = org.apache.tools.ant.ComponentHelper.getComponentHelper(project);
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap = this.attributeMap;
        if (linkedHashMap != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : linkedHashMap.entrySet()) {
                java.lang.String key = entry.getKey();
                if (!isRestrictedAttribute(key, componentHelper).b()) {
                    java.lang.Object value = entry.getValue();
                    java.lang.Object eval = value instanceof org.apache.tools.ant.Evaluable ? ((org.apache.tools.ant.Evaluable) value).eval() : org.apache.tools.ant.PropertyHelper.getPropertyHelper(project).parseProperties(value.toString());
                    if (obj instanceof org.apache.tools.ant.taskdefs.MacroInstance) {
                        java.util.Iterator<org.apache.tools.ant.taskdefs.MacroDef.Attribute> it = ((org.apache.tools.ant.taskdefs.MacroInstance) obj).getMacroDef().getAttributes().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            org.apache.tools.ant.taskdefs.MacroDef.Attribute next = it.next();
                            if (next.getName().equals(key)) {
                            }
                        }
                    }
                    value = eval;
                    try {
                        helper.setAttribute(project, obj, key, value);
                    } catch (org.apache.tools.ant.UnsupportedAttributeException e) {
                        if (!key.equals("id")) {
                            if (getElementTag() == null) {
                                throw e;
                            }
                            throw new org.apache.tools.ant.BuildException(getElementTag() + " doesn't support the \"" + e.getAttribute() + "\" attribute", e);
                        }
                    } catch (org.apache.tools.ant.BuildException e2) {
                        if (!key.equals("id")) {
                            throw e2;
                        }
                    }
                }
            }
        }
        java.lang.StringBuffer stringBuffer = this.characters;
        if (stringBuffer != null) {
            org.apache.tools.ant.ProjectHelper.addText(project, this.wrappedObject, stringBuffer.substring(0));
        }
        java.lang.String str = this.id;
        if (str != null) {
            project.addReference(str, this.wrappedObject);
        }
        this.proxyConfigured = true;
    }

    public void reconfigure(org.apache.tools.ant.Project project) {
        this.proxyConfigured = false;
        maybeConfigure(project);
    }

    public synchronized void removeAttribute(java.lang.String str) {
        this.attributeMap.remove(str);
    }

    public synchronized void setAttribute(java.lang.String str, java.lang.Object obj) {
        java.lang.String str2 = null;
        if (str.equalsIgnoreCase(org.apache.tools.ant.ProjectHelper.ANT_TYPE)) {
            if (obj != null) {
                str2 = obj.toString();
            }
            this.polyType = str2;
        } else {
            if (this.attributeMap == null) {
                this.attributeMap = new java.util.LinkedHashMap<>();
            }
            if (!str.equalsIgnoreCase("refid") || this.attributeMap.isEmpty()) {
                this.attributeMap.put(str, obj);
            } else {
                java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap = new java.util.LinkedHashMap<>();
                linkedHashMap.put(str, obj);
                linkedHashMap.putAll(this.attributeMap);
                this.attributeMap = linkedHashMap;
            }
            if (str.equals("id")) {
                if (obj != null) {
                    str2 = obj.toString();
                }
                this.id = str2;
            }
        }
    }

    public synchronized void setAttribute(java.lang.String str, java.lang.String str2) {
        if (str.indexOf(58) != -1) {
            this.namespacedAttribute = true;
        }
        setAttribute(str, (java.lang.Object) str2);
    }

    @java.lang.Deprecated
    public synchronized void setAttributes(org.xml.sax.AttributeList attributeList) {
        this.attributes = new org.xml.sax.helpers.AttributeListImpl(attributeList);
        for (int i = 0; i < attributeList.getLength(); i++) {
            setAttribute(attributeList.getName(i), attributeList.getValue(i));
        }
    }

    public synchronized void setCreator(org.apache.tools.ant.IntrospectionHelper.Creator creator) {
    }

    public synchronized void setElementTag(java.lang.String str) {
        this.elementTag = str;
    }

    public synchronized void setPolyType(java.lang.String str) {
        this.polyType = str;
    }

    public synchronized void setProxy(java.lang.Object obj) {
        this.wrappedObject = obj;
        this.proxyConfigured = false;
    }
}
