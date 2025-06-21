package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class FilterSet extends org.apache.tools.ant.types.DataType {
    public static final java.lang.String DEFAULT_TOKEN_END = "@";
    public static final java.lang.String DEFAULT_TOKEN_START = "@";
    public boolean A;
    public int B;
    public java.util.Vector<org.apache.tools.ant.types.FilterSet.Filter> C;
    public java.lang.String n;
    public java.lang.String t;
    public java.util.Vector<java.lang.String> u;
    public boolean v;
    public boolean w;
    public java.util.Hashtable<java.lang.String, java.lang.String> x;
    public java.util.Vector<java.io.File> y;
    public org.apache.tools.ant.types.FilterSet.OnMissing z;

    public static class Filter {
        public java.lang.String a;
        public java.lang.String b;

        public Filter() {
        }

        public Filter(java.lang.String str, java.lang.String str2) {
            setToken(str);
            setValue(str2);
        }

        public java.lang.String getToken() {
            return this.a;
        }

        public java.lang.String getValue() {
            return this.b;
        }

        public void setToken(java.lang.String str) {
            this.a = str;
        }

        public void setValue(java.lang.String str) {
            this.b = str;
        }
    }

    public class FiltersFile {
        public FiltersFile() {
        }

        public void setFile(java.io.File file) {
            org.apache.tools.ant.types.FilterSet.this.y.add(file);
        }
    }

    public static class OnMissing extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String[] b = {"fail", "warn", org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE};
        public static final org.apache.tools.ant.types.FilterSet.OnMissing FAIL = new org.apache.tools.ant.types.FilterSet.OnMissing("fail");
        public static final org.apache.tools.ant.types.FilterSet.OnMissing WARN = new org.apache.tools.ant.types.FilterSet.OnMissing("warn");
        public static final org.apache.tools.ant.types.FilterSet.OnMissing IGNORE = new org.apache.tools.ant.types.FilterSet.OnMissing(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);

        public OnMissing() {
        }

        public OnMissing(java.lang.String str) {
            setValue(str);
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return b;
        }
    }

    public FilterSet() {
        this.n = "@";
        this.t = "@";
        this.v = false;
        this.w = true;
        this.x = null;
        this.y = new java.util.Vector<>();
        this.z = org.apache.tools.ant.types.FilterSet.OnMissing.FAIL;
        this.A = false;
        this.B = 0;
        this.C = new java.util.Vector<>();
    }

    public FilterSet(org.apache.tools.ant.types.FilterSet filterSet) {
        this.n = "@";
        this.t = "@";
        this.v = false;
        this.w = true;
        this.x = null;
        this.y = new java.util.Vector<>();
        this.z = org.apache.tools.ant.types.FilterSet.OnMissing.FAIL;
        this.A = false;
        this.B = 0;
        this.C = new java.util.Vector<>();
        this.C = (java.util.Vector) filterSet.getFilters().clone();
    }

    public synchronized void addConfiguredFilterSet(org.apache.tools.ant.types.FilterSet filterSet) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        java.util.Iterator<org.apache.tools.ant.types.FilterSet.Filter> it = filterSet.getFilters().iterator();
        while (it.hasNext()) {
            addFilter(it.next());
        }
    }

    public synchronized void addConfiguredPropertySet(org.apache.tools.ant.types.PropertySet propertySet) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        for (java.util.Map.Entry entry : propertySet.getProperties().entrySet()) {
            addFilter(new org.apache.tools.ant.types.FilterSet.Filter(java.lang.String.valueOf(entry.getKey()), java.lang.String.valueOf(entry.getValue())));
        }
    }

    public synchronized void addFilter(java.lang.String str, java.lang.String str2) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        addFilter(new org.apache.tools.ant.types.FilterSet.Filter(str, str2));
    }

    public synchronized void addFilter(org.apache.tools.ant.types.FilterSet.Filter filter) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.C.addElement(filter);
        this.x = null;
    }

    public final void c(java.lang.String str) {
        int index = this.z.getIndex();
        if (index == 0) {
            throw new org.apache.tools.ant.BuildException(str);
        }
        if (index == 1) {
            log(str, 1);
        } else if (index != 2) {
            throw new org.apache.tools.ant.BuildException("Invalid value for onMissingFiltersFile");
        }
    }

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public synchronized java.lang.Object clone() throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            return getRef().clone();
        }
        try {
            org.apache.tools.ant.types.FilterSet filterSet = (org.apache.tools.ant.types.FilterSet) super.clone();
            filterSet.C = (java.util.Vector) getFilters().clone();
            filterSet.setProject(getProject());
            return filterSet;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public org.apache.tools.ant.types.FilterSet.FiltersFile createFiltersfile() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        return new org.apache.tools.ant.types.FilterSet.FiltersFile();
    }

    public final synchronized java.lang.String d(java.lang.String str) {
        int i;
        java.lang.String beginToken = getBeginToken();
        java.lang.String endToken = getEndToken();
        int indexOf = str.indexOf(beginToken);
        if (indexOf <= -1) {
            return str;
        }
        java.util.Hashtable<java.lang.String, java.lang.String> filterHash = getFilterHash();
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i2 = 0;
            while (indexOf > -1) {
                int indexOf2 = str.indexOf(endToken, beginToken.length() + indexOf + 1);
                if (indexOf2 == -1) {
                    break;
                }
                java.lang.String substring = str.substring(beginToken.length() + indexOf, indexOf2);
                sb.append(str.substring(i2, indexOf));
                if (filterHash.containsKey(substring)) {
                    java.lang.String str2 = filterHash.get(substring);
                    if (this.w && !str2.equals(substring)) {
                        str2 = e(str2, substring);
                    }
                    log("Replacing: " + beginToken + substring + endToken + " -> " + str2, 3);
                    sb.append(str2);
                    i = indexOf + beginToken.length() + substring.length() + endToken.length();
                } else {
                    sb.append(beginToken.charAt(0));
                    i = indexOf + 1;
                }
                i2 = i;
                indexOf = str.indexOf(beginToken, i2);
            }
            sb.append(str.substring(i2));
            return sb.toString();
        } catch (java.lang.StringIndexOutOfBoundsException unused) {
            return str;
        }
    }

    public final synchronized java.lang.String e(java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        java.lang.String beginToken = getBeginToken();
        java.lang.String endToken = getEndToken();
        if (this.B == 0) {
            this.u = new org.apache.tools.ant.util.VectorSet();
        }
        this.B++;
        if (this.u.contains(str2) && !this.v) {
            this.v = true;
            java.lang.System.out.println("Infinite loop in tokens. Currently known tokens : " + this.u.toString() + "\nProblem token : " + beginToken + str2 + endToken + " called from " + beginToken + this.u.lastElement().toString() + endToken);
            this.B = this.B - 1;
            return str2;
        }
        this.u.addElement(str2);
        java.lang.String d = d(str);
        if (!d.contains(beginToken) && !this.v && this.B == 1) {
            this.u = null;
        } else if (this.v) {
            if (this.u.size() > 0) {
                java.util.Vector<java.lang.String> vector = this.u;
                d = vector.remove(vector.size() - 1);
                if (this.u.size() == 0) {
                    d = beginToken + d + endToken;
                    this.v = false;
                }
            }
        } else if (this.u.size() > 0) {
            java.util.Vector<java.lang.String> vector2 = this.u;
            vector2.remove(vector2.size() - 1);
        }
        this.B--;
        return d;
    }

    public java.lang.String getBeginToken() {
        return isReference() ? getRef().getBeginToken() : this.n;
    }

    public java.lang.String getEndToken() {
        return isReference() ? getRef().getEndToken() : this.t;
    }

    public synchronized java.util.Hashtable<java.lang.String, java.lang.String> getFilterHash() {
        if (isReference()) {
            return getRef().getFilterHash();
        }
        dieOnCircularReference();
        if (this.x == null) {
            this.x = new java.util.Hashtable<>(getFilters().size());
            java.util.Enumeration<org.apache.tools.ant.types.FilterSet.Filter> elements = getFilters().elements();
            while (elements.hasMoreElements()) {
                org.apache.tools.ant.types.FilterSet.Filter nextElement = elements.nextElement();
                this.x.put(nextElement.getToken(), nextElement.getValue());
            }
        }
        return this.x;
    }

    public synchronized java.util.Vector<org.apache.tools.ant.types.FilterSet.Filter> getFilters() {
        if (isReference()) {
            return getRef().getFilters();
        }
        dieOnCircularReference();
        if (!this.A) {
            this.A = true;
            java.util.Iterator<java.io.File> it = this.y.iterator();
            while (it.hasNext()) {
                readFiltersFromFile(it.next());
            }
            this.y.clear();
            this.A = false;
        }
        return this.C;
    }

    public org.apache.tools.ant.types.FilterSet.OnMissing getOnMissingFiltersFile() {
        return this.z;
    }

    public org.apache.tools.ant.types.FilterSet getRef() {
        return (org.apache.tools.ant.types.FilterSet) getCheckedRef(org.apache.tools.ant.types.FilterSet.class, "filterset");
    }

    public synchronized boolean hasFilters() {
        return getFilters().size() > 0;
    }

    public boolean isRecurse() {
        return this.w;
    }

    public synchronized void readFiltersFromFile(java.io.File file) throws org.apache.tools.ant.BuildException {
        java.util.Properties properties;
        java.io.FileInputStream fileInputStream;
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (!file.exists()) {
            c("Could not read filters from file " + file + " as it doesn't exist.");
        }
        java.io.FileInputStream fileInputStream2 = null;
        if (file.isFile()) {
            log("Reading filters from " + file, 3);
            try {
                try {
                    properties = new java.util.Properties();
                    fileInputStream = new java.io.FileInputStream(file);
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                properties.load(fileInputStream);
                java.util.Enumeration<?> propertyNames = properties.propertyNames();
                java.util.Vector<org.apache.tools.ant.types.FilterSet.Filter> filters = getFilters();
                while (propertyNames.hasMoreElements()) {
                    java.lang.String str = (java.lang.String) propertyNames.nextElement();
                    filters.addElement(new org.apache.tools.ant.types.FilterSet.Filter(str, properties.getProperty(str)));
                }
                org.apache.tools.ant.util.FileUtils.close(fileInputStream);
            } catch (java.lang.Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                throw new org.apache.tools.ant.BuildException("Could not read filters from file: " + file, e);
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
                throw th;
            }
        } else {
            c("Must specify a file rather than a directory in the filtersfile attribute:" + file);
        }
        this.x = null;
    }

    public synchronized java.lang.String replaceTokens(java.lang.String str) {
        return d(str);
    }

    public void setBeginToken(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (str == null || "".equals(str)) {
            throw new org.apache.tools.ant.BuildException("beginToken must not be empty");
        }
        this.n = str;
    }

    public void setEndToken(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (str == null || "".equals(str)) {
            throw new org.apache.tools.ant.BuildException("endToken must not be empty");
        }
        this.t = str;
    }

    public void setFiltersfile(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.y.add(file);
    }

    public void setOnMissingFiltersFile(org.apache.tools.ant.types.FilterSet.OnMissing onMissing) {
        this.z = onMissing;
    }

    public void setRecurse(boolean z) {
        this.w = z;
    }
}
