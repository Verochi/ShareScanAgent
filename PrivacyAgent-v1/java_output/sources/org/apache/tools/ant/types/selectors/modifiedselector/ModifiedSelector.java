package org.apache.tools.ant.types.selectors.modifiedselector;

/* loaded from: classes26.dex */
public class ModifiedSelector extends org.apache.tools.ant.types.selectors.BaseExtendSelector implements org.apache.tools.ant.BuildListener, org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public java.lang.String v;
    public java.lang.String x;
    public java.lang.String z;
    public org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.CacheName u = null;
    public org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.AlgorithmName w = null;
    public org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.ComparatorName y = null;
    public boolean A = true;
    public boolean B = true;
    public boolean C = true;
    public boolean D = true;
    public java.util.Comparator<? super java.lang.String> E = null;
    public org.apache.tools.ant.types.selectors.modifiedselector.Algorithm F = null;
    public org.apache.tools.ant.types.selectors.modifiedselector.Cache G = null;
    public int H = 0;
    public boolean I = false;
    public java.util.Vector<org.apache.tools.ant.types.Parameter> J = new java.util.Vector<>();
    public java.util.Vector<org.apache.tools.ant.types.Parameter> K = new java.util.Vector<>();
    public java.lang.ClassLoader L = null;
    public org.apache.tools.ant.types.Path M = null;

    public static class AlgorithmName extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"hashvalue", "digest", "checksum", "lastmodified"};
        }
    }

    public static class CacheName extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"propertyfile"};
        }
    }

    public static class ComparatorName extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"equal", com.heytap.mcssdk.constant.b.p};
        }
    }

    public void addClasspath(org.apache.tools.ant.types.Path path) {
        if (this.M != null) {
            throw new org.apache.tools.ant.BuildException("<classpath> can be set only once.");
        }
        this.M = path;
    }

    public void addParam(java.lang.String str, java.lang.Object obj) {
        org.apache.tools.ant.types.Parameter parameter = new org.apache.tools.ant.types.Parameter();
        parameter.setName(str);
        parameter.setValue(java.lang.String.valueOf(obj));
        this.J.add(parameter);
    }

    public void addParam(org.apache.tools.ant.types.Parameter parameter) {
        this.J.add(parameter);
    }

    public final boolean b(java.io.File file, java.lang.String str, java.lang.String str2) {
        validate();
        java.io.File file2 = new java.io.File(file, str);
        if (file2.isDirectory()) {
            return this.B;
        }
        java.lang.String valueOf = java.lang.String.valueOf(this.G.get(file2.getAbsolutePath()));
        java.lang.String value = this.F.getValue(file2);
        boolean z = this.E.compare(valueOf, value) != 0;
        if (this.A && z) {
            this.G.put(file2.getAbsolutePath(), value);
            setModified(getModified() + 1);
            if (!getDelayUpdate()) {
                saveCache();
            }
        }
        return z;
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        if (getDelayUpdate()) {
            saveCache();
        }
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    public void configure() {
        java.io.File file;
        if (this.I) {
            return;
        }
        this.I = true;
        org.apache.tools.ant.Project project = getProject();
        if (project != null) {
            file = new java.io.File(project.getBaseDir(), "cache.properties");
            getProject().addBuildListener(this);
        } else {
            file = new java.io.File("cache.properties");
            setDelayUpdate(false);
        }
        org.apache.tools.ant.types.selectors.modifiedselector.PropertiesfileCache propertiesfileCache = new org.apache.tools.ant.types.selectors.modifiedselector.PropertiesfileCache(file);
        org.apache.tools.ant.types.selectors.modifiedselector.DigestAlgorithm digestAlgorithm = new org.apache.tools.ant.types.selectors.modifiedselector.DigestAlgorithm();
        org.apache.tools.ant.types.selectors.modifiedselector.EqualComparator equalComparator = new org.apache.tools.ant.types.selectors.modifiedselector.EqualComparator();
        java.util.Iterator<org.apache.tools.ant.types.Parameter> it = this.J.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.Parameter next = it.next();
            if (next.getName().indexOf(".") > 0) {
                this.K.add(next);
            } else {
                useParameter(next);
            }
        }
        this.J = new java.util.Vector<>();
        org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.AlgorithmName algorithmName = this.w;
        if (algorithmName == null) {
            java.lang.String str = this.x;
            if (str != null) {
                this.F = (org.apache.tools.ant.types.selectors.modifiedselector.Algorithm) loadClass(str, "is not an Algorithm.", org.apache.tools.ant.types.selectors.modifiedselector.Algorithm.class);
            } else {
                this.F = digestAlgorithm;
            }
        } else if ("hashvalue".equals(algorithmName.getValue())) {
            this.F = new org.apache.tools.ant.types.selectors.modifiedselector.HashvalueAlgorithm();
        } else if ("digest".equals(this.w.getValue())) {
            this.F = new org.apache.tools.ant.types.selectors.modifiedselector.DigestAlgorithm();
        } else if ("checksum".equals(this.w.getValue())) {
            this.F = new org.apache.tools.ant.types.selectors.modifiedselector.ChecksumAlgorithm();
        } else if ("lastmodified".equals(this.w.getValue())) {
            this.F = new org.apache.tools.ant.types.selectors.modifiedselector.LastModifiedAlgorithm();
        }
        org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.CacheName cacheName = this.u;
        if (cacheName == null) {
            java.lang.String str2 = this.v;
            if (str2 != null) {
                this.G = (org.apache.tools.ant.types.selectors.modifiedselector.Cache) loadClass(str2, "is not a Cache.", org.apache.tools.ant.types.selectors.modifiedselector.Cache.class);
            } else {
                this.G = propertiesfileCache;
            }
        } else if ("propertyfile".equals(cacheName.getValue())) {
            this.G = new org.apache.tools.ant.types.selectors.modifiedselector.PropertiesfileCache();
        }
        org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.ComparatorName comparatorName = this.y;
        if (comparatorName == null) {
            java.lang.String str3 = this.z;
            if (str3 != null) {
                this.E = (java.util.Comparator) loadClass(str3, "is not a Comparator.", java.util.Comparator.class);
            } else {
                this.E = equalComparator;
            }
        } else if ("equal".equals(comparatorName.getValue())) {
            this.E = new org.apache.tools.ant.types.selectors.modifiedselector.EqualComparator();
        } else if (com.heytap.mcssdk.constant.b.p.equals(this.y.getValue())) {
            throw new org.apache.tools.ant.BuildException("RuleBasedCollator not yet supported.");
        }
        java.util.Iterator<org.apache.tools.ant.types.Parameter> it2 = this.K.iterator();
        while (it2.hasNext()) {
            useParameter(it2.next());
        }
        this.K = new java.util.Vector<>();
    }

    public org.apache.tools.ant.types.selectors.modifiedselector.Algorithm getAlgorithm() {
        return this.F;
    }

    public org.apache.tools.ant.types.selectors.modifiedselector.Cache getCache() {
        return this.G;
    }

    public java.lang.ClassLoader getClassLoader() {
        if (this.L == null) {
            this.L = this.M == null ? getClass().getClassLoader() : getProject().createClassLoader(this.M);
        }
        return this.L;
    }

    public java.util.Comparator<? super java.lang.String> getComparator() {
        return this.E;
    }

    public boolean getDelayUpdate() {
        return this.D;
    }

    public int getModified() {
        return this.H;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        return b(file, str, file2.getAbsolutePath());
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        if (resource.isFilesystemOnly()) {
            org.apache.tools.ant.types.resources.FileResource fileResource = (org.apache.tools.ant.types.resources.FileResource) resource;
            return isSelected(fileResource.getBaseDir(), fileResource.getName(), fileResource.getFile());
        }
        try {
            java.io.File createTempFile = org.apache.tools.ant.util.FileUtils.getFileUtils().createTempFile(getProject(), "modified-", com.baidu.mobads.sdk.internal.al.k, null, true, false);
            org.apache.tools.ant.util.ResourceUtils.copyResource(resource, new org.apache.tools.ant.types.resources.FileResource(createTempFile));
            boolean b = b(createTempFile.getParentFile(), createTempFile.getName(), resource.toLongString());
            createTempFile.delete();
            return b;
        } catch (java.lang.UnsupportedOperationException unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("The resource '");
            sb.append(resource.getName());
            sb.append("' does not provide an InputStream, so it is not checked. According to 'selres' attribute value it is ");
            sb.append(this.C ? "" : " not");
            sb.append("selected.");
            log(sb.toString(), 2);
            return this.C;
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public <T> T loadClass(java.lang.String str, java.lang.String str2, java.lang.Class<? extends T> cls) {
        try {
            java.lang.ClassLoader classLoader = getClassLoader();
            T t = (T) (classLoader != null ? classLoader.loadClass(str) : java.lang.Class.forName(str)).newInstance();
            if (cls.isInstance(t)) {
                return t;
            }
            throw new org.apache.tools.ant.BuildException("Specified class (" + str + ") " + str2);
        } catch (java.lang.ClassNotFoundException unused) {
            throw new org.apache.tools.ant.BuildException("Specified class (" + str + ") not found.");
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    @Override // org.apache.tools.ant.BuildListener
    public void messageLogged(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    public void saveCache() {
        if (getModified() > 0) {
            this.G.save();
            setModified(0);
        }
    }

    public void setAlgorithm(org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.AlgorithmName algorithmName) {
        this.w = algorithmName;
    }

    public void setAlgorithmClass(java.lang.String str) {
        this.x = str;
    }

    public void setCache(org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.CacheName cacheName) {
        this.u = cacheName;
    }

    public void setCacheClass(java.lang.String str) {
        this.v = str;
    }

    public void setClassLoader(java.lang.ClassLoader classLoader) {
        this.L = classLoader;
    }

    public void setComparator(org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.ComparatorName comparatorName) {
        this.y = comparatorName;
    }

    public void setComparatorClass(java.lang.String str) {
        this.z = str;
    }

    public void setDelayUpdate(boolean z) {
        this.D = z;
    }

    public void setModified(int i) {
        this.H = i;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.Parameterizable
    public void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        if (parameterArr != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameterArr) {
                this.J.add(parameter);
            }
        }
    }

    public void setSeldirs(boolean z) {
        this.B = z;
    }

    public void setSelres(boolean z) {
        this.C = z;
    }

    public void setUpdate(boolean z) {
        this.A = z;
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        if (getDelayUpdate()) {
            saveCache();
        }
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        if (getDelayUpdate()) {
            saveCache();
        }
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("{modifiedselector");
        stringBuffer.append(" update=");
        stringBuffer.append(this.A);
        stringBuffer.append(" seldirs=");
        stringBuffer.append(this.B);
        stringBuffer.append(" cache=");
        stringBuffer.append(this.G);
        stringBuffer.append(" algorithm=");
        stringBuffer.append(this.F);
        stringBuffer.append(" comparator=");
        stringBuffer.append(this.E);
        stringBuffer.append(com.alipay.sdk.m.u.i.d);
        return stringBuffer.toString();
    }

    public void tryToSetAParameter(java.lang.Object obj, java.lang.String str, java.lang.String str2) {
        org.apache.tools.ant.Project project = getProject() != null ? getProject() : new org.apache.tools.ant.Project();
        try {
            org.apache.tools.ant.IntrospectionHelper.getHelper(project, obj.getClass()).setAttribute(project, obj, str, str2);
        } catch (org.apache.tools.ant.BuildException unused) {
        }
    }

    public void useParameter(org.apache.tools.ant.types.Parameter parameter) {
        java.lang.String name = parameter.getName();
        java.lang.String value = parameter.getValue();
        if ("cache".equals(name)) {
            org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.CacheName cacheName = new org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.CacheName();
            cacheName.setValue(value);
            setCache(cacheName);
            return;
        }
        if ("algorithm".equals(name)) {
            org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.AlgorithmName algorithmName = new org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.AlgorithmName();
            algorithmName.setValue(value);
            setAlgorithm(algorithmName);
            return;
        }
        if ("comparator".equals(name)) {
            org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.ComparatorName comparatorName = new org.apache.tools.ant.types.selectors.modifiedselector.ModifiedSelector.ComparatorName();
            comparatorName.setValue(value);
            setComparator(comparatorName);
            return;
        }
        if ("update".equals(name)) {
            setUpdate(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(value));
            return;
        }
        if ("delayupdate".equals(name)) {
            setDelayUpdate(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(value));
            return;
        }
        if ("seldirs".equals(name)) {
            setSeldirs(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(value));
            return;
        }
        if (name.startsWith("cache.")) {
            tryToSetAParameter(this.G, name.substring(6), value);
            return;
        }
        if (name.startsWith("algorithm.")) {
            tryToSetAParameter(this.F, name.substring(10), value);
        } else if (name.startsWith("comparator.")) {
            tryToSetAParameter(this.E, name.substring(11), value);
        } else {
            setError("Invalid parameter " + name);
        }
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        configure();
        org.apache.tools.ant.types.selectors.modifiedselector.Cache cache = this.G;
        if (cache == null) {
            setError("Cache must be set.");
            return;
        }
        if (this.F == null) {
            setError("Algorithm must be set.");
        } else if (!cache.isValid()) {
            setError("Cache must be proper configured.");
        } else {
            if (this.F.isValid()) {
                return;
            }
            setError("Algorithm must be proper configured.");
        }
    }
}
