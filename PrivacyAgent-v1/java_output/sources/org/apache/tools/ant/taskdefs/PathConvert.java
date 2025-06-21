package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class PathConvert extends org.apache.tools.ant.Task {
    public static boolean F = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS);
    public boolean E;
    public org.apache.tools.ant.types.resources.Resources u = null;
    public org.apache.tools.ant.types.Reference v = null;
    public java.lang.String w = null;
    public boolean x = false;
    public boolean y = true;
    public java.lang.String z = null;
    public java.util.Vector A = new java.util.Vector();
    public java.lang.String B = null;
    public java.lang.String C = null;
    public org.apache.tools.ant.types.Mapper D = null;

    public class MapEntry {
        public java.lang.String a = null;
        public java.lang.String b = null;

        public MapEntry() {
        }

        public java.lang.String apply(java.lang.String str) {
            if (this.a == null || this.b == null) {
                throw new org.apache.tools.ant.BuildException("Both 'from' and 'to' must be set in a map entry");
            }
            if (!(org.apache.tools.ant.taskdefs.PathConvert.F ? str.toLowerCase().replace('\\', '/') : str).startsWith(org.apache.tools.ant.taskdefs.PathConvert.F ? this.a.toLowerCase().replace('\\', '/') : this.a)) {
                return str;
            }
            return this.b + str.substring(this.a.length());
        }

        public void setFrom(java.lang.String str) {
            this.a = str;
        }

        public void setTo(java.lang.String str) {
            this.b = str;
        }
    }

    public static class TargetOs extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS, org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX, org.apache.tools.ant.taskdefs.condition.Os.FAMILY_NETWARE, org.apache.tools.ant.taskdefs.condition.Os.FAMILY_OS2, org.apache.tools.ant.taskdefs.condition.Os.FAMILY_TANDEM};
        }
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        d().add(resourceCollection);
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        mapper.add(fileNameMapper);
        addMapper(mapper);
    }

    public void addMapper(org.apache.tools.ant.types.Mapper mapper) {
        if (this.D != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS);
        }
        this.D = mapper;
    }

    public org.apache.tools.ant.taskdefs.PathConvert.MapEntry createMap() {
        org.apache.tools.ant.taskdefs.PathConvert.MapEntry mapEntry = new org.apache.tools.ant.taskdefs.PathConvert.MapEntry();
        this.A.addElement(mapEntry);
        return mapEntry;
    }

    public org.apache.tools.ant.types.Path createPath() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getProject());
        add(path);
        return path;
    }

    public final synchronized org.apache.tools.ant.types.resources.Resources d() {
        if (this.u == null) {
            org.apache.tools.ant.types.resources.Resources resources = new org.apache.tools.ant.types.resources.Resources(getProject());
            this.u = resources;
            resources.setCache(true);
        }
        return this.u;
    }

    public final java.lang.String e(java.lang.String str) {
        int size = this.A.size();
        if (size == 0) {
            return str;
        }
        for (int i = 0; i < size; i++) {
            java.lang.String apply = ((org.apache.tools.ant.taskdefs.PathConvert.MapEntry) this.A.elementAt(i)).apply(str);
            if (apply != str) {
                return apply;
            }
        }
        return str;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.resources.Resources resources = this.u;
        java.lang.String str = this.B;
        java.lang.String str2 = this.C;
        try {
            if (isReference()) {
                java.lang.Object referencedObject = this.v.getReferencedObject(getProject());
                if (!(referencedObject instanceof org.apache.tools.ant.types.ResourceCollection)) {
                    throw new org.apache.tools.ant.BuildException("refid '" + this.v.getRefId() + "' does not refer to a resource collection.");
                }
                d().add((org.apache.tools.ant.types.ResourceCollection) referencedObject);
            }
            f();
            java.lang.String str3 = F ? "\\" : net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.lang.Iterable union = isPreserveDuplicates() ? this.u : new org.apache.tools.ant.types.resources.Union(this.u);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            org.apache.tools.ant.types.Mapper mapper = this.D;
            org.apache.tools.ant.util.FileNameMapper identityMapper = mapper == null ? new org.apache.tools.ant.util.IdentityMapper() : mapper.getImplementation();
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = union.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.lang.String[] mapFileName = identityMapper.mapFileName(java.lang.String.valueOf(it.next()));
                for (int i = 0; mapFileName != null && i < mapFileName.length; i++) {
                    arrayList.add(mapFileName[i]);
                }
            }
            java.util.Iterator it2 = arrayList.iterator();
            boolean z = true;
            while (it2.hasNext()) {
                java.lang.String e = e((java.lang.String) it2.next());
                if (!z) {
                    stringBuffer.append(this.B);
                }
                java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(e, str3, true);
                while (stringTokenizer.hasMoreTokens()) {
                    java.lang.String nextToken = stringTokenizer.nextToken();
                    if (str3.equals(nextToken)) {
                        nextToken = this.C;
                    }
                    stringBuffer.append(nextToken);
                }
                z = false;
            }
            if (this.y || stringBuffer.length() > 0) {
                java.lang.String stringBuffer2 = stringBuffer.toString();
                if (this.z == null) {
                    log(stringBuffer2);
                } else {
                    log("Set property " + this.z + " = " + stringBuffer2, 3);
                    getProject().setNewProperty(this.z, stringBuffer2);
                }
            }
        } finally {
            this.u = resources;
            this.C = str2;
            this.B = str;
        }
    }

    public final void f() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("You must specify a path to convert");
        }
        java.lang.String str = java.io.File.separator;
        java.lang.String str2 = java.io.File.pathSeparator;
        if (this.w != null) {
            boolean z = this.x;
            str2 = z ? com.alipay.sdk.m.u.i.b : com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
            str = z ? "\\" : net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        java.lang.String str3 = this.B;
        if (str3 != null) {
            str2 = str3;
        }
        java.lang.String str4 = this.C;
        if (str4 != null) {
            str = str4;
        }
        this.B = str2;
        this.C = str;
    }

    public boolean isPreserveDuplicates() {
        return this.E;
    }

    public boolean isReference() {
        return this.v != null;
    }

    public final org.apache.tools.ant.BuildException noChildrenAllowed() {
        return new org.apache.tools.ant.BuildException("You must not specify nested elements when using the refid attribute.");
    }

    public void setDirSep(java.lang.String str) {
        this.C = str;
    }

    public void setPathSep(java.lang.String str) {
        this.B = str;
    }

    public void setPreserveDuplicates(boolean z) {
        this.E = z;
    }

    public void setProperty(java.lang.String str) {
        this.z = str;
    }

    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.u != null) {
            throw noChildrenAllowed();
        }
        this.v = reference;
    }

    public void setSetonempty(boolean z) {
        this.y = z;
    }

    @java.lang.Deprecated
    public void setTargetos(java.lang.String str) {
        org.apache.tools.ant.taskdefs.PathConvert.TargetOs targetOs = new org.apache.tools.ant.taskdefs.PathConvert.TargetOs();
        targetOs.setValue(str);
        setTargetos(targetOs);
    }

    public void setTargetos(org.apache.tools.ant.taskdefs.PathConvert.TargetOs targetOs) {
        java.lang.String value = targetOs.getValue();
        this.w = value;
        this.x = (value.equals(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX) || this.w.equals(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_TANDEM)) ? false : true;
    }
}
