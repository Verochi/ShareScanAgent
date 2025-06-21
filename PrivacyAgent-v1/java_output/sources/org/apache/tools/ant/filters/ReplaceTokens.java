package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class ReplaceTokens extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public int A;
    public java.lang.String B;
    public java.lang.String C;
    public java.util.Hashtable<java.lang.String, java.lang.String> v;
    public final java.util.TreeMap<java.lang.String, java.lang.String> w;
    public boolean x;
    public java.lang.String y;
    public java.lang.String z;

    public static class Token {
        public java.lang.String a;
        public java.lang.String b;

        public final java.lang.String getKey() {
            return this.a;
        }

        public final java.lang.String getValue() {
            return this.b;
        }

        public final void setKey(java.lang.String str) {
            this.a = str;
        }

        public final void setValue(java.lang.String str) {
            this.b = str;
        }
    }

    public ReplaceTokens() {
        this.v = new java.util.Hashtable<>();
        this.w = new java.util.TreeMap<>();
        this.x = false;
        this.y = "";
        this.z = null;
        this.A = -1;
        this.B = "@";
        this.C = "@";
    }

    public ReplaceTokens(java.io.Reader reader) {
        super(reader);
        this.v = new java.util.Hashtable<>();
        this.w = new java.util.TreeMap<>();
        this.x = false;
        this.y = "";
        this.z = null;
        this.A = -1;
        this.B = "@";
        this.C = "@";
    }

    public final java.lang.String a() {
        return this.B;
    }

    public void addConfiguredToken(org.apache.tools.ant.filters.ReplaceTokens.Token token) {
        this.v.put(token.getKey(), token.getValue());
        this.x = false;
    }

    public final java.lang.String c() {
        return this.C;
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.ReplaceTokens replaceTokens = new org.apache.tools.ant.filters.ReplaceTokens(reader);
        replaceTokens.setBeginToken(a());
        replaceTokens.setEndToken(c());
        replaceTokens.l(g());
        replaceTokens.setInitialized(true);
        return replaceTokens;
    }

    public final int e() {
        if (this.y.length() <= 0) {
            return -1;
        }
        char charAt = this.y.charAt(0);
        this.y = this.y.substring(1);
        return charAt;
    }

    public final java.util.Properties f(org.apache.tools.ant.types.Resource resource) {
        java.util.Properties properties = new java.util.Properties();
        java.io.InputStream inputStream = null;
        try {
            try {
                inputStream = resource.getInputStream();
                properties.load(inputStream);
            } catch (java.io.IOException e) {
                if (getProject() != null) {
                    getProject().log("getProperties failed, " + e.getMessage(), 0);
                } else {
                    e.printStackTrace();
                }
            }
            return properties;
        } finally {
            org.apache.tools.ant.util.FileUtils.close(inputStream);
        }
    }

    public final java.util.Hashtable<java.lang.String, java.lang.String> g() {
        return this.v;
    }

    public final void j() {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if (parameter != null) {
                    java.lang.String type = parameter.getType();
                    if ("tokenchar".equals(type)) {
                        java.lang.String name = parameter.getName();
                        if ("begintoken".equals(name)) {
                            this.B = parameter.getValue();
                        } else if ("endtoken".equals(name)) {
                            this.C = parameter.getValue();
                        }
                    } else if ("token".equals(type)) {
                        this.v.put(parameter.getName(), parameter.getValue());
                    } else if ("propertiesfile".equals(type)) {
                        k(new org.apache.tools.ant.types.resources.FileResource(new java.io.File(parameter.getValue())));
                    }
                }
            }
        }
    }

    public final void k(org.apache.tools.ant.types.Resource resource) {
        java.util.Properties f = f(resource);
        java.util.Enumeration keys = f.keys();
        while (keys.hasMoreElements()) {
            java.lang.String str = (java.lang.String) keys.nextElement();
            this.v.put(str, f.getProperty(str));
        }
    }

    public final void l(java.util.Hashtable<java.lang.String, java.lang.String> hashtable) {
        this.v = hashtable;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        if (!getInitialized()) {
            j();
            setInitialized(true);
        }
        if (!this.x) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.v.entrySet()) {
                this.w.put(this.B + entry.getKey() + this.C, entry.getValue());
            }
            this.x = true;
        }
        java.lang.String str = this.z;
        if (str != null) {
            if (this.A < str.length()) {
                java.lang.String str2 = this.z;
                int i = this.A;
                this.A = i + 1;
                return str2.charAt(i);
            }
            this.z = null;
        }
        if (this.y.length() == 0) {
            int read = ((java.io.FilterReader) this).in.read();
            if (read == -1) {
                return read;
            }
            this.y += ((char) read);
        }
        while (true) {
            java.util.SortedMap<java.lang.String, java.lang.String> tailMap = this.w.tailMap(this.y);
            if (tailMap.isEmpty() || !tailMap.firstKey().startsWith(this.y)) {
                break;
            }
            if (this.y.equals(tailMap.firstKey())) {
                this.z = this.w.get(this.y);
                this.A = 0;
                this.y = "";
                return read();
            }
            int read2 = ((java.io.FilterReader) this).in.read();
            if (read2 == -1) {
                return e();
            }
            this.y += ((char) read2);
        }
        return e();
    }

    public void setBeginToken(java.lang.String str) {
        this.B = str;
    }

    public void setEndToken(java.lang.String str) {
        this.C = str;
    }

    public void setPropertiesResource(org.apache.tools.ant.types.Resource resource) {
        k(resource);
    }
}
