package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class RedirectorElement extends org.apache.tools.ant.types.DataType {
    public java.lang.Boolean A;
    public java.lang.Boolean B;
    public org.apache.tools.ant.types.Mapper C;
    public org.apache.tools.ant.types.Mapper D;
    public org.apache.tools.ant.types.Mapper E;
    public java.lang.String I;
    public java.lang.String J;
    public java.lang.String K;
    public java.lang.Boolean L;
    public java.lang.Boolean v;
    public java.lang.String w;
    public java.lang.String x;
    public java.lang.String y;
    public java.lang.Boolean z;
    public boolean n = false;
    public boolean t = false;
    public boolean u = false;
    public java.util.Vector<org.apache.tools.ant.types.FilterChain> F = new java.util.Vector<>();
    public java.util.Vector<org.apache.tools.ant.types.FilterChain> G = new java.util.Vector<>();
    public java.util.Vector<org.apache.tools.ant.types.FilterChain> H = new java.util.Vector<>();
    public boolean M = false;

    public void addConfiguredErrorMapper(org.apache.tools.ant.types.Mapper mapper) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.E != null) {
            if (!this.u) {
                throw new org.apache.tools.ant.BuildException("Cannot have > 1 <errormapper>");
            }
            throw new org.apache.tools.ant.BuildException("attribute \"error\" cannot coexist with a nested <errormapper>");
        }
        setChecked(false);
        this.E = mapper;
    }

    public void addConfiguredInputMapper(org.apache.tools.ant.types.Mapper mapper) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.C != null) {
            if (!this.n) {
                throw new org.apache.tools.ant.BuildException("Cannot have > 1 <inputmapper>");
            }
            throw new org.apache.tools.ant.BuildException("attribute \"input\" cannot coexist with a nested <inputmapper>");
        }
        setChecked(false);
        this.C = mapper;
    }

    public void addConfiguredOutputMapper(org.apache.tools.ant.types.Mapper mapper) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.D != null) {
            if (!this.t) {
                throw new org.apache.tools.ant.BuildException("Cannot have > 1 <outputmapper>");
            }
            throw new org.apache.tools.ant.BuildException("attribute \"output\" cannot coexist with a nested <outputmapper>");
        }
        setChecked(false);
        this.D = mapper;
    }

    public final org.apache.tools.ant.types.RedirectorElement b() {
        return (org.apache.tools.ant.types.RedirectorElement) getCheckedRef();
    }

    public void configure(org.apache.tools.ant.taskdefs.Redirector redirector) {
        configure(redirector, null);
    }

    public void configure(org.apache.tools.ant.taskdefs.Redirector redirector, java.lang.String str) {
        java.lang.String[] strArr;
        java.lang.String[] strArr2;
        if (isReference()) {
            b().configure(redirector, str);
            return;
        }
        dieOnCircularReference();
        java.lang.Boolean bool = this.A;
        if (bool != null) {
            redirector.setAlwaysLog(bool.booleanValue());
        }
        java.lang.Boolean bool2 = this.v;
        if (bool2 != null) {
            redirector.setLogError(bool2.booleanValue());
        }
        java.lang.Boolean bool3 = this.z;
        if (bool3 != null) {
            redirector.setAppend(bool3.booleanValue());
        }
        java.lang.Boolean bool4 = this.B;
        if (bool4 != null) {
            redirector.setCreateEmptyFiles(bool4.booleanValue());
        }
        java.lang.String str2 = this.w;
        if (str2 != null) {
            redirector.setOutputProperty(str2);
        }
        java.lang.String str3 = this.x;
        if (str3 != null) {
            redirector.setErrorProperty(str3);
        }
        java.lang.String str4 = this.y;
        if (str4 != null) {
            redirector.setInputString(str4);
        }
        java.lang.Boolean bool5 = this.L;
        if (bool5 != null) {
            redirector.setLogInputString(bool5.booleanValue());
        }
        org.apache.tools.ant.types.Mapper mapper = this.C;
        java.lang.String[] strArr3 = null;
        if (mapper != null) {
            try {
                strArr = mapper.getImplementation().mapFileName(str);
            } catch (java.lang.NullPointerException e) {
                if (str != null) {
                    throw e;
                }
                strArr = null;
            }
            if (strArr != null && strArr.length > 0) {
                redirector.setInput(toFileArray(strArr));
            }
        }
        org.apache.tools.ant.types.Mapper mapper2 = this.D;
        if (mapper2 != null) {
            try {
                strArr2 = mapper2.getImplementation().mapFileName(str);
            } catch (java.lang.NullPointerException e2) {
                if (str != null) {
                    throw e2;
                }
                strArr2 = null;
            }
            if (strArr2 != null && strArr2.length > 0) {
                redirector.setOutput(toFileArray(strArr2));
            }
        }
        org.apache.tools.ant.types.Mapper mapper3 = this.E;
        if (mapper3 != null) {
            try {
                strArr3 = mapper3.getImplementation().mapFileName(str);
            } catch (java.lang.NullPointerException e3) {
                if (str != null) {
                    throw e3;
                }
            }
            if (strArr3 != null && strArr3.length > 0) {
                redirector.setError(toFileArray(strArr3));
            }
        }
        if (this.F.size() > 0) {
            redirector.setInputFilterChains(this.F);
        }
        if (this.G.size() > 0) {
            redirector.setOutputFilterChains(this.G);
        }
        if (this.H.size() > 0) {
            redirector.setErrorFilterChains(this.H);
        }
        java.lang.String str5 = this.K;
        if (str5 != null) {
            redirector.setInputEncoding(str5);
        }
        java.lang.String str6 = this.I;
        if (str6 != null) {
            redirector.setOutputEncoding(str6);
        }
        java.lang.String str7 = this.J;
        if (str7 != null) {
            redirector.setErrorEncoding(str7);
        }
        redirector.setBinaryOutput(this.M);
    }

    public org.apache.tools.ant.types.FilterChain createErrorFilterChain() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        org.apache.tools.ant.types.FilterChain filterChain = new org.apache.tools.ant.types.FilterChain();
        filterChain.setProject(getProject());
        this.H.add(filterChain);
        setChecked(false);
        return filterChain;
    }

    public org.apache.tools.ant.types.FilterChain createInputFilterChain() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        org.apache.tools.ant.types.FilterChain filterChain = new org.apache.tools.ant.types.FilterChain();
        filterChain.setProject(getProject());
        this.F.add(filterChain);
        setChecked(false);
        return filterChain;
    }

    public org.apache.tools.ant.types.Mapper createMergeMapper(java.io.File file) {
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        mapper.setClassname(org.apache.tools.ant.util.MergingMapper.class.getName());
        mapper.setTo(file.getAbsolutePath());
        return mapper;
    }

    public org.apache.tools.ant.types.FilterChain createOutputFilterChain() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        org.apache.tools.ant.types.FilterChain filterChain = new org.apache.tools.ant.types.FilterChain();
        filterChain.setProject(getProject());
        this.G.add(filterChain);
        setChecked(false);
        return filterChain;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
            return;
        }
        for (org.apache.tools.ant.types.Mapper mapper : java.util.Arrays.asList(this.C, this.D, this.E)) {
            if (mapper != null) {
                stack.push(mapper);
                mapper.dieOnCircularReference(stack, project);
                stack.pop();
            }
        }
        for (java.util.List list : java.util.Arrays.asList(this.F, this.G, this.H)) {
            if (list != null) {
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.FilterChain) it.next(), stack, project);
                }
            }
        }
        setChecked(true);
    }

    public void setAlwaysLog(boolean z) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.A = z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public void setAppend(boolean z) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.z = z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public void setBinaryOutput(boolean z) {
        this.M = z;
    }

    public void setCreateEmptyFiles(boolean z) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.B = z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public void setError(java.io.File file) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (file == null) {
            throw new java.lang.IllegalArgumentException("error file specified as null");
        }
        this.u = true;
        this.E = createMergeMapper(file);
    }

    public void setErrorEncoding(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.J = str;
    }

    public void setErrorProperty(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.x = str;
    }

    public void setInput(java.io.File file) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("The \"input\" and \"inputstring\" attributes cannot both be specified");
        }
        this.n = true;
        this.C = createMergeMapper(file);
    }

    public void setInputEncoding(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.K = str;
    }

    public void setInputString(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (this.n) {
            throw new org.apache.tools.ant.BuildException("The \"input\" and \"inputstring\" attributes cannot both be specified");
        }
        this.y = str;
    }

    public void setLogError(boolean z) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.v = z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public void setLogInputString(boolean z) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.L = z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public void setOutput(java.io.File file) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (file == null) {
            throw new java.lang.IllegalArgumentException("output file specified as null");
        }
        this.t = true;
        this.D = createMergeMapper(file);
    }

    public void setOutputEncoding(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.I = str;
    }

    public void setOutputProperty(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.w = str;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (this.n || this.t || this.u || this.y != null || this.v != null || this.z != null || this.B != null || this.K != null || this.I != null || this.J != null || this.w != null || this.x != null || this.L != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public java.io.File[] toFileArray(java.lang.String[] strArr) {
        if (strArr == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length);
        for (java.lang.String str : strArr) {
            if (str != null) {
                arrayList.add(getProject().resolveFile(str));
            }
        }
        return (java.io.File[]) arrayList.toArray(new java.io.File[arrayList.size()]);
    }
}
