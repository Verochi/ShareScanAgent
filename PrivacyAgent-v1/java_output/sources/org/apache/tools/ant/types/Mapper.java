package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Mapper extends org.apache.tools.ant.types.DataType {
    protected org.apache.tools.ant.types.Mapper.MapperType type = null;
    protected java.lang.String classname = null;
    protected org.apache.tools.ant.types.Path classpath = null;
    protected java.lang.String from = null;
    protected java.lang.String to = null;
    public org.apache.tools.ant.util.ContainerMapper n = null;

    public static class MapperType extends org.apache.tools.ant.types.EnumeratedAttribute {
        public java.util.Properties b;

        public MapperType() {
            java.util.Properties properties = new java.util.Properties();
            this.b = properties;
            properties.put("identity", "org.apache.tools.ant.util.IdentityMapper");
            this.b.put("flatten", "org.apache.tools.ant.util.FlatFileNameMapper");
            this.b.put("glob", "org.apache.tools.ant.util.GlobPatternMapper");
            this.b.put("merge", "org.apache.tools.ant.util.MergingMapper");
            this.b.put(org.apache.tools.ant.types.RegularExpression.DATA_TYPE_NAME, "org.apache.tools.ant.util.RegexpPatternMapper");
            this.b.put("package", "org.apache.tools.ant.util.PackageNameMapper");
            this.b.put("unpackage", "org.apache.tools.ant.util.UnPackageNameMapper");
        }

        public java.lang.String getImplementation() {
            return this.b.getProperty(getValue());
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"identity", "flatten", "glob", "merge", org.apache.tools.ant.types.RegularExpression.DATA_TYPE_NAME, "package", "unpackage"};
        }
    }

    public Mapper(org.apache.tools.ant.Project project) {
        setProject(project);
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.n == null) {
            if (this.type == null && this.classname == null) {
                this.n = new org.apache.tools.ant.util.CompositeMapper();
            } else {
                org.apache.tools.ant.util.FileNameMapper implementation = getImplementation();
                if (!(implementation instanceof org.apache.tools.ant.util.ContainerMapper)) {
                    throw new org.apache.tools.ant.BuildException(java.lang.String.valueOf(implementation) + " mapper implementation does not support nested mappers!");
                }
                this.n = (org.apache.tools.ant.util.ContainerMapper) implementation;
            }
        }
        this.n.add(fileNameMapper);
        setChecked(false);
    }

    public void addConfigured(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        add(fileNameMapper);
    }

    public void addConfiguredMapper(org.apache.tools.ant.types.Mapper mapper) {
        add(mapper.getImplementation());
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.classpath == null) {
            this.classpath = new org.apache.tools.ant.types.Path(getProject());
        }
        setChecked(false);
        return this.classpath.createPath();
    }

    public org.apache.tools.ant.util.FileNameMapper getImplementation() throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            dieOnCircularReference();
            org.apache.tools.ant.types.Reference refid = getRefid();
            java.lang.Object referencedObject = refid.getReferencedObject(getProject());
            if (referencedObject instanceof org.apache.tools.ant.util.FileNameMapper) {
                return (org.apache.tools.ant.util.FileNameMapper) referencedObject;
            }
            if (referencedObject instanceof org.apache.tools.ant.types.Mapper) {
                return ((org.apache.tools.ant.types.Mapper) referencedObject).getImplementation();
            }
            throw new org.apache.tools.ant.BuildException((referencedObject == null ? com.igexin.push.core.b.m : referencedObject.getClass().getName()) + " at reference '" + refid.getRefId() + "' is not a valid mapper reference.");
        }
        org.apache.tools.ant.types.Mapper.MapperType mapperType = this.type;
        if (mapperType == null && this.classname == null && this.n == null) {
            throw new org.apache.tools.ant.BuildException("nested mapper or one of the attributes type or classname is required");
        }
        org.apache.tools.ant.util.ContainerMapper containerMapper = this.n;
        if (containerMapper != null) {
            return containerMapper;
        }
        if (mapperType != null && this.classname != null) {
            throw new org.apache.tools.ant.BuildException("must not specify both type and classname attribute");
        }
        try {
            org.apache.tools.ant.util.FileNameMapper newInstance = getImplementationClass().newInstance();
            org.apache.tools.ant.Project project = getProject();
            if (project != null) {
                project.setProjectReference(newInstance);
            }
            newInstance.setFrom(this.from);
            newInstance.setTo(this.to);
            return newInstance;
        } catch (org.apache.tools.ant.BuildException e) {
            throw e;
        } catch (java.lang.Throwable th) {
            throw new org.apache.tools.ant.BuildException(th);
        }
    }

    public java.lang.Class<? extends org.apache.tools.ant.util.FileNameMapper> getImplementationClass() throws java.lang.ClassNotFoundException {
        java.lang.String str = this.classname;
        org.apache.tools.ant.types.Mapper.MapperType mapperType = this.type;
        if (mapperType != null) {
            str = mapperType.getImplementation();
        }
        return java.lang.Class.forName(str, true, this.classpath == null ? getClass().getClassLoader() : getProject().createClassLoader(this.classpath)).asSubclass(org.apache.tools.ant.util.FileNameMapper.class);
    }

    @java.lang.Deprecated
    public org.apache.tools.ant.types.Mapper getRef() {
        return (org.apache.tools.ant.types.Mapper) getCheckedRef(org.apache.tools.ant.types.Mapper.class, getDataTypeName());
    }

    public void setClassname(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.classname = str;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        org.apache.tools.ant.types.Path path2 = this.classpath;
        if (path2 == null) {
            this.classpath = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        createClasspath().setRefid(reference);
    }

    public void setFrom(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.from = str;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (this.type != null || this.from != null || this.to != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public void setTo(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.to = str;
    }

    public void setType(org.apache.tools.ant.types.Mapper.MapperType mapperType) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.type = mapperType;
    }
}
