package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class PropertyHelper implements org.apache.tools.ant.property.GetProperty {
    public static final org.apache.tools.ant.PropertyHelper.PropertyEvaluator g = new org.apache.tools.ant.PropertyHelper.AnonymousClass1();
    public static final org.apache.tools.ant.property.PropertyExpander h = new org.apache.tools.ant.PropertyHelper.AnonymousClass2();
    public static final org.apache.tools.ant.property.PropertyExpander i = new org.apache.tools.ant.PropertyHelper.AnonymousClass3();
    public static final org.apache.tools.ant.PropertyHelper.PropertyEvaluator j = new org.apache.tools.ant.PropertyHelper.AnonymousClass4();
    public org.apache.tools.ant.Project a;
    public org.apache.tools.ant.PropertyHelper b;
    public final java.util.Hashtable<java.lang.Class<? extends org.apache.tools.ant.PropertyHelper.Delegate>, java.util.List<org.apache.tools.ant.PropertyHelper.Delegate>> c = new java.util.Hashtable<>();
    public java.util.Hashtable<java.lang.String, java.lang.Object> d = new java.util.Hashtable<>();
    public java.util.Hashtable<java.lang.String, java.lang.Object> e = new java.util.Hashtable<>();
    public java.util.Hashtable<java.lang.String, java.lang.Object> f = new java.util.Hashtable<>();

    /* renamed from: org.apache.tools.ant.PropertyHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements org.apache.tools.ant.PropertyHelper.PropertyEvaluator {
        public final java.lang.String a = "toString:";
        public final int b = 9;

        @Override // org.apache.tools.ant.PropertyHelper.PropertyEvaluator
        public java.lang.Object evaluate(java.lang.String str, org.apache.tools.ant.PropertyHelper propertyHelper) {
            java.lang.Object reference = (!str.startsWith("toString:") || propertyHelper.getProject() == null) ? null : propertyHelper.getProject().getReference(str.substring(this.b));
            if (reference == null) {
                return null;
            }
            return reference.toString();
        }
    }

    /* renamed from: org.apache.tools.ant.PropertyHelper$2, reason: invalid class name */
    public static class AnonymousClass2 implements org.apache.tools.ant.property.PropertyExpander {
        @Override // org.apache.tools.ant.property.PropertyExpander
        public java.lang.String parsePropertyName(java.lang.String str, java.text.ParsePosition parsePosition, org.apache.tools.ant.property.ParseNextProperty parseNextProperty) {
            int index = parsePosition.getIndex();
            if (str.length() - index < 3 || '$' != str.charAt(index) || '{' != str.charAt(index + 1)) {
                return null;
            }
            int i = index + 2;
            int indexOf = str.indexOf(125, i);
            if (indexOf >= 0) {
                parsePosition.setIndex(indexOf + 1);
                return i == indexOf ? "" : str.substring(i, indexOf);
            }
            throw new org.apache.tools.ant.BuildException("Syntax error in property: " + str.substring(index));
        }
    }

    /* renamed from: org.apache.tools.ant.PropertyHelper$3, reason: invalid class name */
    public static class AnonymousClass3 implements org.apache.tools.ant.property.PropertyExpander {
        @Override // org.apache.tools.ant.property.PropertyExpander
        public java.lang.String parsePropertyName(java.lang.String str, java.text.ParsePosition parsePosition, org.apache.tools.ant.property.ParseNextProperty parseNextProperty) {
            int index = parsePosition.getIndex();
            if (str.length() - index < 2 || '$' != str.charAt(index)) {
                return null;
            }
            int i = index + 1;
            if ('$' != str.charAt(i)) {
                return null;
            }
            parsePosition.setIndex(i);
            return null;
        }
    }

    /* renamed from: org.apache.tools.ant.PropertyHelper$4, reason: invalid class name */
    public static class AnonymousClass4 implements org.apache.tools.ant.PropertyHelper.PropertyEvaluator {
        public final java.lang.String a = "ant.refid:";
        public final int b = 10;

        @Override // org.apache.tools.ant.PropertyHelper.PropertyEvaluator
        public java.lang.Object evaluate(java.lang.String str, org.apache.tools.ant.PropertyHelper propertyHelper) {
            if (!str.startsWith("ant.refid:") || propertyHelper.getProject() == null) {
                return null;
            }
            return propertyHelper.getProject().getReference(str.substring(this.b));
        }
    }

    public interface Delegate {
    }

    public interface PropertyEvaluator extends org.apache.tools.ant.PropertyHelper.Delegate {
        java.lang.Object evaluate(java.lang.String str, org.apache.tools.ant.PropertyHelper propertyHelper);
    }

    public interface PropertySetter extends org.apache.tools.ant.PropertyHelper.Delegate {
        boolean set(java.lang.String str, java.lang.Object obj, org.apache.tools.ant.PropertyHelper propertyHelper);

        boolean setNew(java.lang.String str, java.lang.Object obj, org.apache.tools.ant.PropertyHelper propertyHelper);
    }

    public PropertyHelper() {
        add(j);
        add(g);
        add(i);
        add(h);
    }

    public static boolean b(java.lang.Object obj) {
        return obj == null || "".equals(obj);
    }

    public static void c(java.lang.String str, java.util.Vector<java.lang.String> vector, java.util.Vector<java.lang.String> vector2) throws org.apache.tools.ant.BuildException {
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf("$", i2);
            if (indexOf < 0) {
                if (i2 < str.length()) {
                    vector.addElement(str.substring(i2));
                    return;
                }
                return;
            }
            if (indexOf > 0) {
                vector.addElement(str.substring(i2, indexOf));
            }
            if (indexOf == str.length() - 1) {
                vector.addElement("$");
                i2 = indexOf + 1;
            } else {
                int i3 = indexOf + 1;
                if (str.charAt(i3) == '{') {
                    int indexOf2 = str.indexOf(125, indexOf);
                    if (indexOf2 < 0) {
                        throw new org.apache.tools.ant.BuildException("Syntax error in property: " + str);
                    }
                    java.lang.String substring = str.substring(indexOf + 2, indexOf2);
                    vector.addElement(null);
                    vector2.addElement(substring);
                    i2 = indexOf2 + 1;
                } else if (str.charAt(i3) == '$') {
                    vector.addElement("$");
                    i2 = indexOf + 2;
                } else {
                    i2 = indexOf + 2;
                    vector.addElement(str.substring(indexOf, i2));
                }
            }
        }
    }

    public static java.util.Set<java.lang.Class<? extends org.apache.tools.ant.PropertyHelper.Delegate>> getDelegateInterfaces(org.apache.tools.ant.PropertyHelper.Delegate delegate) {
        java.util.HashSet hashSet = new java.util.HashSet();
        for (java.lang.Class<?> cls = delegate.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (java.lang.Class<?> cls2 : cls.getInterfaces()) {
                if (org.apache.tools.ant.PropertyHelper.Delegate.class.isAssignableFrom(cls2)) {
                    hashSet.add(cls2);
                }
            }
        }
        hashSet.remove(org.apache.tools.ant.PropertyHelper.Delegate.class);
        return hashSet;
    }

    public static java.lang.Object getProperty(org.apache.tools.ant.Project project, java.lang.String str) {
        return getPropertyHelper(project).getProperty(str);
    }

    public static synchronized org.apache.tools.ant.PropertyHelper getPropertyHelper(org.apache.tools.ant.Project project) {
        synchronized (org.apache.tools.ant.PropertyHelper.class) {
            org.apache.tools.ant.PropertyHelper propertyHelper = project != null ? (org.apache.tools.ant.PropertyHelper) project.getReference(org.apache.tools.ant.MagicNames.REFID_PROPERTY_HELPER) : null;
            if (propertyHelper != null) {
                return propertyHelper;
            }
            org.apache.tools.ant.PropertyHelper propertyHelper2 = new org.apache.tools.ant.PropertyHelper();
            propertyHelper2.setProject(project);
            if (project != null) {
                project.addReference(org.apache.tools.ant.MagicNames.REFID_PROPERTY_HELPER, propertyHelper2);
            }
            return propertyHelper2;
        }
    }

    public static void setNewProperty(org.apache.tools.ant.Project project, java.lang.String str, java.lang.Object obj) {
        getPropertyHelper(project).setNewProperty(str, obj);
    }

    public static void setProperty(org.apache.tools.ant.Project project, java.lang.String str, java.lang.Object obj) {
        getPropertyHelper(project).setProperty(str, obj, true);
    }

    public static java.lang.Boolean toBoolean(java.lang.Object obj) {
        if (obj instanceof java.lang.Boolean) {
            return (java.lang.Boolean) obj;
        }
        if (!(obj instanceof java.lang.String)) {
            return null;
        }
        java.lang.String str = (java.lang.String) obj;
        if (org.apache.tools.ant.Project.toBoolean(str)) {
            return java.lang.Boolean.TRUE;
        }
        if (kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF.equalsIgnoreCase(str) || com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equalsIgnoreCase(str) || "no".equalsIgnoreCase(str)) {
            return java.lang.Boolean.FALSE;
        }
        return null;
    }

    public final boolean a(java.lang.Object obj) {
        java.lang.Boolean bool = toBoolean(obj);
        return bool != null ? bool.booleanValue() : getProperty(java.lang.String.valueOf(obj)) != null;
    }

    public void add(org.apache.tools.ant.PropertyHelper.Delegate delegate) {
        java.util.ArrayList arrayList;
        synchronized (this.c) {
            for (java.lang.Class<? extends org.apache.tools.ant.PropertyHelper.Delegate> cls : getDelegateInterfaces(delegate)) {
                java.util.List<org.apache.tools.ant.PropertyHelper.Delegate> list = this.c.get(cls);
                if (list == null) {
                    arrayList = new java.util.ArrayList();
                } else {
                    java.util.ArrayList arrayList2 = new java.util.ArrayList(list);
                    arrayList2.remove(delegate);
                    arrayList = arrayList2;
                }
                arrayList.add(0, delegate);
                this.c.put(cls, java.util.Collections.unmodifiableList(arrayList));
            }
        }
    }

    public boolean containsProperties(java.lang.String str) {
        return new org.apache.tools.ant.property.ParseProperties(getProject(), getExpanders(), this).containsProperties(str);
    }

    public void copyInheritedProperties(org.apache.tools.ant.Project project) {
        synchronized (this.f) {
            java.util.Enumeration<java.lang.String> keys = this.f.keys();
            while (keys.hasMoreElements()) {
                java.lang.String str = keys.nextElement().toString();
                if (project.getUserProperty(str) == null) {
                    project.setInheritedProperty(str, this.f.get(str).toString());
                }
            }
        }
    }

    public void copyUserProperties(org.apache.tools.ant.Project project) {
        synchronized (this.e) {
            java.util.Enumeration<java.lang.String> keys = this.e.keys();
            while (keys.hasMoreElements()) {
                java.lang.String nextElement = keys.nextElement();
                if (!this.f.containsKey(nextElement)) {
                    project.setUserProperty(nextElement.toString(), this.e.get(nextElement).toString());
                }
            }
        }
    }

    public <D extends org.apache.tools.ant.PropertyHelper.Delegate> java.util.List<D> getDelegates(java.lang.Class<D> cls) {
        java.util.List<D> list = (java.util.List) this.c.get(cls);
        return list == null ? java.util.Collections.emptyList() : list;
    }

    public java.util.Collection<org.apache.tools.ant.property.PropertyExpander> getExpanders() {
        return getDelegates(org.apache.tools.ant.property.PropertyExpander.class);
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getInheritedProperties() {
        java.util.Hashtable<java.lang.String, java.lang.Object> hashtable;
        synchronized (this.f) {
            hashtable = new java.util.Hashtable<>(this.f);
        }
        return hashtable;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getInternalInheritedProperties() {
        return this.f;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getInternalProperties() {
        return this.d;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getInternalUserProperties() {
        return this.e;
    }

    @java.lang.Deprecated
    public org.apache.tools.ant.PropertyHelper getNext() {
        return this.b;
    }

    public org.apache.tools.ant.Project getProject() {
        return this.a;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getProperties() {
        java.util.Hashtable<java.lang.String, java.lang.Object> hashtable;
        synchronized (this.d) {
            hashtable = new java.util.Hashtable<>(this.d);
        }
        return hashtable;
    }

    @Override // org.apache.tools.ant.property.GetProperty
    public java.lang.Object getProperty(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.Iterator it = getDelegates(org.apache.tools.ant.PropertyHelper.PropertyEvaluator.class).iterator();
        while (it.hasNext()) {
            java.lang.Object evaluate = ((org.apache.tools.ant.PropertyHelper.PropertyEvaluator) it.next()).evaluate(str, this);
            if (evaluate != null) {
                if (evaluate instanceof org.apache.tools.ant.property.NullReturn) {
                    return null;
                }
                return evaluate;
            }
        }
        return this.d.get(str);
    }

    @java.lang.Deprecated
    public java.lang.Object getProperty(java.lang.String str, java.lang.String str2) {
        return getProperty(str2);
    }

    @java.lang.Deprecated
    public java.lang.Object getPropertyHook(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.Object propertyHook;
        if (getNext() != null && (propertyHook = getNext().getPropertyHook(str, str2, z)) != null) {
            return propertyHook;
        }
        if (this.a == null || !str2.startsWith("toString:")) {
            return null;
        }
        java.lang.Object reference = this.a.getReference(str2.substring(9));
        if (reference == null) {
            return null;
        }
        return reference.toString();
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getUserProperties() {
        java.util.Hashtable<java.lang.String, java.lang.Object> hashtable;
        synchronized (this.e) {
            hashtable = new java.util.Hashtable<>(this.e);
        }
        return hashtable;
    }

    public java.lang.Object getUserProperty(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return this.e.get(str);
    }

    @java.lang.Deprecated
    public java.lang.Object getUserProperty(java.lang.String str, java.lang.String str2) {
        return getUserProperty(str2);
    }

    public java.lang.Object parseProperties(java.lang.String str) throws org.apache.tools.ant.BuildException {
        return new org.apache.tools.ant.property.ParseProperties(getProject(), getExpanders(), this).parseProperties(str);
    }

    @java.lang.Deprecated
    public void parsePropertyString(java.lang.String str, java.util.Vector<java.lang.String> vector, java.util.Vector<java.lang.String> vector2) throws org.apache.tools.ant.BuildException {
        c(str, vector, vector2);
    }

    public java.lang.String replaceProperties(java.lang.String str) throws org.apache.tools.ant.BuildException {
        java.lang.Object parseProperties = parseProperties(str);
        return (parseProperties == null || (parseProperties instanceof java.lang.String)) ? (java.lang.String) parseProperties : parseProperties.toString();
    }

    public java.lang.String replaceProperties(java.lang.String str, java.lang.String str2, java.util.Hashtable<java.lang.String, java.lang.Object> hashtable) throws org.apache.tools.ant.BuildException {
        return replaceProperties(str2);
    }

    public void setInheritedProperty(java.lang.String str, java.lang.Object obj) {
        org.apache.tools.ant.Project project = this.a;
        if (project != null) {
            project.log("Setting ro project property: " + str + " -> " + obj, 4);
        }
        synchronized (this) {
            this.f.put(str, obj);
            this.e.put(str, obj);
            this.d.put(str, obj);
        }
    }

    @java.lang.Deprecated
    public void setInheritedProperty(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        setInheritedProperty(str2, obj);
    }

    public void setNewProperty(java.lang.String str, java.lang.Object obj) {
        java.util.Iterator it = getDelegates(org.apache.tools.ant.PropertyHelper.PropertySetter.class).iterator();
        while (it.hasNext()) {
            if (((org.apache.tools.ant.PropertyHelper.PropertySetter) it.next()).setNew(str, obj, this)) {
                return;
            }
        }
        synchronized (this) {
            if (this.a != null && this.d.containsKey(str)) {
                this.a.log("Override ignored for property \"" + str + "\"", 3);
                return;
            }
            org.apache.tools.ant.Project project = this.a;
            if (project != null) {
                project.log("Setting project property: " + str + " -> " + obj, 4);
            }
            if (str != null && obj != null) {
                this.d.put(str, obj);
            }
        }
    }

    @java.lang.Deprecated
    public void setNewProperty(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        setNewProperty(str2, obj);
    }

    @java.lang.Deprecated
    public void setNext(org.apache.tools.ant.PropertyHelper propertyHelper) {
        this.b = propertyHelper;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.a = project;
    }

    public boolean setProperty(java.lang.String str, java.lang.Object obj, boolean z) {
        java.util.Iterator it = getDelegates(org.apache.tools.ant.PropertyHelper.PropertySetter.class).iterator();
        while (it.hasNext()) {
            if (((org.apache.tools.ant.PropertyHelper.PropertySetter) it.next()).set(str, obj, this)) {
                return true;
            }
        }
        synchronized (this) {
            if (this.e.containsKey(str)) {
                org.apache.tools.ant.Project project = this.a;
                if (project != null && z) {
                    project.log("Override ignored for user property \"" + str + "\"", 3);
                }
                return false;
            }
            if (this.a != null && z) {
                if (this.d.containsKey(str)) {
                    this.a.log("Overriding previous definition of property \"" + str + "\"", 3);
                }
                this.a.log("Setting project property: " + str + " -> " + obj, 4);
            }
            if (str != null && obj != null) {
                this.d.put(str, obj);
            }
            return true;
        }
    }

    @java.lang.Deprecated
    public boolean setProperty(java.lang.String str, java.lang.String str2, java.lang.Object obj, boolean z) {
        return setProperty(str2, obj, z);
    }

    @java.lang.Deprecated
    public boolean setPropertyHook(java.lang.String str, java.lang.String str2, java.lang.Object obj, boolean z, boolean z2, boolean z3) {
        return getNext() != null && getNext().setPropertyHook(str, str2, obj, z, z2, z3);
    }

    public void setUserProperty(java.lang.String str, java.lang.Object obj) {
        org.apache.tools.ant.Project project = this.a;
        if (project != null) {
            project.log("Setting ro project property: " + str + " -> " + obj, 4);
        }
        synchronized (this) {
            this.e.put(str, obj);
            this.d.put(str, obj);
        }
    }

    @java.lang.Deprecated
    public void setUserProperty(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        setUserProperty(str2, obj);
    }

    public boolean testIfCondition(java.lang.Object obj) {
        return b(obj) || a(obj);
    }

    public boolean testUnlessCondition(java.lang.Object obj) {
        return b(obj) || !a(obj);
    }
}
