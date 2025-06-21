package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class PropertySet extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.ResourceCollection {
    public java.util.Set<java.lang.String> u;
    public org.apache.tools.ant.types.Mapper x;
    public boolean n = true;
    public boolean t = false;
    public java.util.List<org.apache.tools.ant.types.PropertySet.PropertyRef> v = new java.util.ArrayList();
    public java.util.List<org.apache.tools.ant.types.PropertySet> w = new java.util.ArrayList();
    public boolean y = true;

    /* renamed from: org.apache.tools.ant.types.PropertySet$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Iterator<org.apache.tools.ant.types.Resource> {
        public final /* synthetic */ java.util.Iterator n;
        public final /* synthetic */ org.apache.tools.ant.util.FileNameMapper t;

        public AnonymousClass1(java.util.Iterator it, org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
            this.n = it;
            this.t = fileNameMapper;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.apache.tools.ant.types.Resource next() {
            org.apache.tools.ant.types.resources.PropertyResource propertyResource = new org.apache.tools.ant.types.resources.PropertyResource(org.apache.tools.ant.types.PropertySet.this.getProject(), (java.lang.String) this.n.next());
            return this.t == null ? propertyResource : new org.apache.tools.ant.types.resources.MappedResource(propertyResource, this.t);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static class BuiltinPropertySetName extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"all", "system", "commandline"};
        }
    }

    public static class PropertyRef {
        public int a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;

        public final void e(java.lang.String str, java.lang.String str2) {
            if (str2 == null || str2.length() < 1) {
                throw new org.apache.tools.ant.BuildException("Invalid attribute: " + str);
            }
            int i = this.a + 1;
            this.a = i;
            if (i != 1) {
                throw new org.apache.tools.ant.BuildException("Attributes name, regex, and prefix are mutually exclusive");
            }
        }

        public void setBuiltin(org.apache.tools.ant.types.PropertySet.BuiltinPropertySetName builtinPropertySetName) {
            java.lang.String value = builtinPropertySetName.getValue();
            e("builtin", value);
            this.e = value;
        }

        public void setName(java.lang.String str) {
            e("name", str);
            this.b = str;
        }

        public void setPrefix(java.lang.String str) {
            e(com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX, str);
            this.d = str;
        }

        public void setRegex(java.lang.String str) {
            e(org.apache.tools.ant.types.selectors.FilenameSelector.REGEX_KEY, str);
            this.c = str;
        }

        public java.lang.String toString() {
            return "name=" + this.b + ", regex=" + this.c + ", prefix=" + this.d + ", builtin=" + this.e;
        }
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        createMapper().add(fileNameMapper);
    }

    public void addPropertyref(org.apache.tools.ant.types.PropertySet.PropertyRef propertyRef) {
        assertNotReference();
        setChecked(false);
        this.v.add(propertyRef);
    }

    public void addPropertyset(org.apache.tools.ant.types.PropertySet propertySet) {
        assertNotReference();
        setChecked(false);
        this.w.add(propertySet);
    }

    public void appendBuiltin(org.apache.tools.ant.types.PropertySet.BuiltinPropertySetName builtinPropertySetName) {
        org.apache.tools.ant.types.PropertySet.PropertyRef propertyRef = new org.apache.tools.ant.types.PropertySet.PropertyRef();
        propertyRef.setBuiltin(builtinPropertySetName);
        addPropertyref(propertyRef);
    }

    public void appendName(java.lang.String str) {
        org.apache.tools.ant.types.PropertySet.PropertyRef propertyRef = new org.apache.tools.ant.types.PropertySet.PropertyRef();
        propertyRef.setName(str);
        addPropertyref(propertyRef);
    }

    public void appendPrefix(java.lang.String str) {
        org.apache.tools.ant.types.PropertySet.PropertyRef propertyRef = new org.apache.tools.ant.types.PropertySet.PropertyRef();
        propertyRef.setPrefix(str);
        addPropertyref(propertyRef);
    }

    public void appendRegex(java.lang.String str) {
        org.apache.tools.ant.types.PropertySet.PropertyRef propertyRef = new org.apache.tools.ant.types.PropertySet.PropertyRef();
        propertyRef.setRegex(str);
        addPropertyref(propertyRef);
    }

    public final void assertNotReference() {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.y = false;
    }

    public final void b(java.util.Set<java.lang.String> set, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (isReference()) {
            getRef().b(set, map);
        }
        dieOnCircularReference();
        for (org.apache.tools.ant.types.PropertySet.PropertyRef propertyRef : this.v) {
            if (propertyRef.b != null) {
                if (map.get(propertyRef.b) != null) {
                    set.add(propertyRef.b);
                }
            } else if (propertyRef.d != null) {
                for (java.lang.String str : map.keySet()) {
                    if (str.startsWith(propertyRef.d)) {
                        set.add(str);
                    }
                }
            } else if (propertyRef.c != null) {
                org.apache.tools.ant.util.regexp.RegexpMatcher newRegexpMatcher = new org.apache.tools.ant.util.regexp.RegexpMatcherFactory().newRegexpMatcher();
                newRegexpMatcher.setPattern(propertyRef.c);
                for (java.lang.String str2 : map.keySet()) {
                    if (newRegexpMatcher.matches(str2)) {
                        set.add(str2);
                    }
                }
            } else {
                if (propertyRef.e == null) {
                    throw new org.apache.tools.ant.BuildException("Impossible: Invalid PropertyRef!");
                }
                if (propertyRef.e.equals("all")) {
                    set.addAll(map.keySet());
                } else if (propertyRef.e.equals("system")) {
                    set.addAll(c().keySet());
                } else {
                    if (!propertyRef.e.equals("commandline")) {
                        throw new org.apache.tools.ant.BuildException("Impossible: Invalid builtin attribute!");
                    }
                    set.addAll(getProject().getUserProperties().keySet());
                }
            }
        }
    }

    public final java.util.Hashtable<java.lang.String, java.lang.Object> c() {
        java.util.Hashtable<java.lang.String, java.lang.Object> hashtable = new java.util.Hashtable<>();
        java.util.Enumeration<?> propertyNames = java.lang.System.getProperties().propertyNames();
        while (propertyNames.hasMoreElements()) {
            java.lang.String str = (java.lang.String) propertyNames.nextElement();
            hashtable.put(str, java.lang.System.getProperties().getProperty(str));
        }
        return hashtable;
    }

    public org.apache.tools.ant.types.Mapper createMapper() {
        assertNotReference();
        if (this.x != null) {
            throw new org.apache.tools.ant.BuildException("Too many <mapper>s!");
        }
        this.x = new org.apache.tools.ant.types.Mapper(getProject());
        setChecked(false);
        return this.x;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> d() {
        org.apache.tools.ant.Project project = getProject();
        java.util.Hashtable<java.lang.String, java.lang.Object> c = project == null ? c() : project.getProperties();
        java.util.Iterator<org.apache.tools.ant.types.PropertySet> it = this.w.iterator();
        while (it.hasNext()) {
            c.putAll(it.next().e());
        }
        return c;
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            org.apache.tools.ant.types.Mapper mapper = this.x;
            if (mapper != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(mapper, stack, project);
            }
            java.util.Iterator<org.apache.tools.ant.types.PropertySet> it = this.w.iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(it.next(), stack, project);
            }
            setChecked(true);
        }
    }

    public final java.util.Map<java.lang.String, java.lang.Object> e() {
        java.lang.String[] mapFileName;
        if (isReference()) {
            return getRef().e();
        }
        dieOnCircularReference();
        org.apache.tools.ant.types.Mapper mapper = getMapper();
        org.apache.tools.ant.util.FileNameMapper implementation = mapper == null ? null : mapper.getImplementation();
        java.util.Map<java.lang.String, java.lang.Object> d = d();
        java.util.Set<java.lang.String> f = f(d);
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.lang.String str : f) {
            java.lang.Object obj = d.get(str);
            if (obj != null) {
                if (implementation != null && (mapFileName = implementation.mapFileName(str)) != null) {
                    str = mapFileName[0];
                }
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    public final java.util.Set<java.lang.String> f(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.Set<java.lang.String> hashSet;
        if (getDynamic() || (hashSet = this.u) == null) {
            hashSet = new java.util.HashSet<>();
            b(hashSet, map);
            java.util.Iterator<org.apache.tools.ant.types.PropertySet> it = this.w.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().e().keySet());
            }
            if (this.t) {
                java.util.HashSet hashSet2 = new java.util.HashSet(map.keySet());
                hashSet2.removeAll(hashSet);
                hashSet = hashSet2;
            }
            if (!getDynamic()) {
                this.u = hashSet;
            }
        }
        return hashSet;
    }

    public boolean getDynamic() {
        if (isReference()) {
            return getRef().n;
        }
        dieOnCircularReference();
        return this.n;
    }

    public org.apache.tools.ant.types.Mapper getMapper() {
        if (isReference()) {
            return getRef().x;
        }
        dieOnCircularReference();
        return this.x;
    }

    public java.util.Properties getProperties() {
        java.util.Properties properties = new java.util.Properties();
        properties.putAll(e());
        return properties;
    }

    public org.apache.tools.ant.types.PropertySet getRef() {
        return (org.apache.tools.ant.types.PropertySet) getCheckedRef(org.apache.tools.ant.types.PropertySet.class, "propertyset");
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        if (isReference()) {
            return getRef().isFilesystemOnly();
        }
        dieOnCircularReference();
        return false;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return getRef().iterator();
        }
        dieOnCircularReference();
        java.util.Set<java.lang.String> f = f(d());
        org.apache.tools.ant.types.Mapper mapper = getMapper();
        return new org.apache.tools.ant.types.PropertySet.AnonymousClass1(f.iterator(), mapper == null ? null : mapper.getImplementation());
    }

    public void setDynamic(boolean z) {
        assertNotReference();
        this.n = z;
    }

    public void setMapper(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        org.apache.tools.ant.types.Mapper createMapper = createMapper();
        org.apache.tools.ant.types.Mapper.MapperType mapperType = new org.apache.tools.ant.types.Mapper.MapperType();
        mapperType.setValue(str);
        createMapper.setType(mapperType);
        createMapper.setFrom(str2);
        createMapper.setTo(str3);
    }

    public void setNegate(boolean z) {
        assertNotReference();
        this.t = z;
    }

    @Override // org.apache.tools.ant.types.DataType
    public final void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (!this.y) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public int size() {
        return isReference() ? getRef().size() : getProperties().size();
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        if (isReference()) {
            return getRef().toString();
        }
        dieOnCircularReference();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry entry : new java.util.TreeMap(e()).entrySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append((java.lang.String) entry.getKey());
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }
}
