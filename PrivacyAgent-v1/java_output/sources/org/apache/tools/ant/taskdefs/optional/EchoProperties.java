package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class EchoProperties extends org.apache.tools.ant.Task {
    public java.lang.String A;
    public java.io.File u = null;
    public java.io.File v = null;
    public boolean w = true;
    public java.util.Vector x = new java.util.Vector();
    public java.lang.String y = "text";
    public java.lang.String z;

    /* renamed from: org.apache.tools.ant.taskdefs.optional.EchoProperties$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.Properties {
        private static final long serialVersionUID = 5090936442309201654L;
        final /* synthetic */ java.util.List val$keyList;

        /* renamed from: org.apache.tools.ant.taskdefs.optional.EchoProperties$1$1, reason: invalid class name and collision with other inner class name */
        public class C05411 implements java.util.Comparator {
            public C05411() {
            }

            @Override // java.util.Comparator
            public int compare(java.lang.Object obj, java.lang.Object obj2) {
                return ((java.lang.String) ((java.util.Map.Entry) obj).getKey()).compareTo((java.lang.String) ((java.util.Map.Entry) obj2).getKey());
            }
        }

        public AnonymousClass1(java.util.List list) {
            this.val$keyList = list;
        }

        @Override // java.util.Hashtable, java.util.Map
        public java.util.Set entrySet() {
            java.util.Set entrySet = super.entrySet();
            if (!org.apache.tools.ant.util.JavaEnvUtils.isKaffe()) {
                return entrySet;
            }
            java.util.TreeSet treeSet = new java.util.TreeSet(new org.apache.tools.ant.taskdefs.optional.EchoProperties.AnonymousClass1.C05411());
            treeSet.addAll(entrySet);
            return treeSet;
        }

        @Override // java.util.Hashtable, java.util.Dictionary
        public java.util.Enumeration keys() {
            return org.apache.tools.ant.util.CollectionUtils.asEnumeration(this.val$keyList.iterator());
        }
    }

    public static class FormatAttribute extends org.apache.tools.ant.types.EnumeratedAttribute {
        public java.lang.String[] b = {com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML, "text"};

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return this.b;
        }
    }

    public static final class Tuple implements java.lang.Comparable {
        public java.lang.String n;
        public java.lang.String t;

        public Tuple(java.lang.String str, java.lang.String str2) {
            this.n = str;
            this.t = str2;
        }

        public /* synthetic */ Tuple(java.lang.String str, java.lang.String str2, org.apache.tools.ant.taskdefs.optional.EchoProperties.AnonymousClass1 anonymousClass1) {
            this(str, str2);
        }

        @Override // java.lang.Comparable
        public int compareTo(java.lang.Object obj) {
            return this.n.compareTo(((org.apache.tools.ant.taskdefs.optional.EchoProperties.Tuple) obj).n);
        }

        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != org.apache.tools.ant.taskdefs.optional.EchoProperties.Tuple.class) {
                return false;
            }
            org.apache.tools.ant.taskdefs.optional.EchoProperties.Tuple tuple = (org.apache.tools.ant.taskdefs.optional.EchoProperties.Tuple) obj;
            java.lang.String str = this.n;
            if (str != null ? str.equals(tuple.n) : tuple.n == null) {
                java.lang.String str2 = this.t;
                java.lang.String str3 = tuple.t;
                if (str2 == null) {
                    if (str3 == null) {
                        return true;
                    }
                } else if (str2.equals(str3)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            java.lang.String str = this.n;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }
    }

    public static javax.xml.parsers.DocumentBuilder c() {
        try {
            return javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (java.lang.Exception e) {
            throw new java.lang.ExceptionInInitializerError(e);
        }
    }

    public void addPropertyset(org.apache.tools.ant.types.PropertySet propertySet) {
        this.x.addElement(propertySet);
    }

    public final java.util.List d(java.util.Properties properties) {
        java.util.ArrayList arrayList = new java.util.ArrayList(properties.size());
        java.util.Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            java.lang.String str = (java.lang.String) propertyNames.nextElement();
            arrayList.add(new org.apache.tools.ant.taskdefs.optional.EchoProperties.Tuple(str, properties.getProperty(str), null));
        }
        java.util.Collections.sort(arrayList);
        return arrayList;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.FileInputStream fileInputStream;
        java.io.File file;
        if (this.z != null && this.A != null) {
            throw new org.apache.tools.ant.BuildException("Please specify either prefix or regex, but not both", getLocation());
        }
        java.util.Hashtable hashtable = new java.util.Hashtable();
        java.io.FileInputStream fileInputStream2 = null;
        java.io.OutputStream outputStream = null;
        java.io.OutputStream outputStream2 = null;
        java.io.FileInputStream fileInputStream3 = null;
        java.io.FileInputStream fileInputStream4 = null;
        java.io.OutputStream outputStream3 = null;
        if (this.u == null && this.x.size() == 0) {
            hashtable.putAll(getProject().getProperties());
        } else {
            java.io.File file2 = this.u;
            if (file2 != null) {
                if (file2.exists() && this.u.isDirectory()) {
                    if (this.w) {
                        throw new org.apache.tools.ant.BuildException("srcfile is a directory!", getLocation());
                    }
                    log("srcfile is a directory!", 0);
                    return;
                }
                if (this.u.exists() && !this.u.canRead()) {
                    if (this.w) {
                        throw new org.apache.tools.ant.BuildException("Can not read from the specified srcfile!", getLocation());
                    }
                    log("Can not read from the specified srcfile!", 0);
                    return;
                }
                try {
                    try {
                        fileInputStream = new java.io.FileInputStream(this.u);
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                } catch (java.io.FileNotFoundException e) {
                    e = e;
                } catch (java.io.IOException e2) {
                    e = e2;
                }
                try {
                    java.util.Properties properties = new java.util.Properties();
                    properties.load(fileInputStream);
                    hashtable.putAll(properties);
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                } catch (java.io.FileNotFoundException e3) {
                    e = e3;
                    fileInputStream4 = fileInputStream;
                    java.lang.String str = "Could not find file " + this.u.getAbsolutePath();
                    if (this.w) {
                        throw new org.apache.tools.ant.BuildException(str, e, getLocation());
                    }
                    log(str, 1);
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream4);
                    return;
                } catch (java.io.IOException e4) {
                    e = e4;
                    fileInputStream2 = fileInputStream;
                    java.lang.String str2 = "Could not read file " + this.u.getAbsolutePath();
                    if (this.w) {
                        throw new org.apache.tools.ant.BuildException(str2, e, getLocation());
                    }
                    log(str2, 1);
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
                    return;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileInputStream3 = fileInputStream;
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream3);
                    throw th;
                }
            }
        }
        java.util.Enumeration elements = this.x.elements();
        while (elements.hasMoreElements()) {
            hashtable.putAll(((org.apache.tools.ant.types.PropertySet) elements.nextElement()).getProperties());
        }
        try {
            try {
                file = this.v;
            } catch (java.io.IOException e5) {
                e = e5;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        try {
            if (file == null) {
                outputStream3 = new java.io.ByteArrayOutputStream();
                saveProperties(hashtable, outputStream3);
                log(outputStream3.toString(), 2);
            } else {
                if (file.exists() && this.v.isDirectory()) {
                    if (this.w) {
                        throw new org.apache.tools.ant.BuildException("destfile is a directory!", getLocation());
                    }
                    log("destfile is a directory!", 0);
                    org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) null);
                    return;
                }
                if (this.v.exists() && !this.v.canWrite()) {
                    if (this.w) {
                        throw new org.apache.tools.ant.BuildException("Can not write to the specified destfile!", getLocation());
                    }
                    log("Can not write to the specified destfile!", 0);
                    org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) null);
                    return;
                }
                outputStream3 = new java.io.FileOutputStream(this.v);
                saveProperties(hashtable, outputStream3);
            }
            org.apache.tools.ant.util.FileUtils.close(outputStream3);
        } catch (java.io.IOException e6) {
            e = e6;
            outputStream = outputStream3;
            if (this.w) {
                throw new org.apache.tools.ant.BuildException(e, getLocation());
            }
            log(e.getMessage(), 2);
            org.apache.tools.ant.util.FileUtils.close(outputStream);
        } catch (java.lang.Throwable th4) {
            th = th4;
            outputStream2 = outputStream3;
            org.apache.tools.ant.util.FileUtils.close(outputStream2);
            throw th;
        }
    }

    public void jdkSaveProperties(java.util.Properties properties, java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        try {
            try {
                properties.store(outputStream, str);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (java.io.IOException unused) {
                        log("Failed to close output stream");
                    }
                }
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException(e, getLocation());
            }
        } catch (java.lang.Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (java.io.IOException unused2) {
                    log("Failed to close output stream");
                }
            }
            throw th;
        }
    }

    public void saveProperties(java.util.Hashtable hashtable, java.io.OutputStream outputStream) throws java.io.IOException, org.apache.tools.ant.BuildException {
        java.util.ArrayList arrayList = new java.util.ArrayList(hashtable.keySet());
        java.util.Collections.sort(arrayList);
        org.apache.tools.ant.taskdefs.optional.EchoProperties.AnonymousClass1 anonymousClass1 = new org.apache.tools.ant.taskdefs.optional.EchoProperties.AnonymousClass1(arrayList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            java.lang.String obj = arrayList.get(i).toString();
            anonymousClass1.setProperty(obj, hashtable.get(obj).toString());
        }
        if ("text".equals(this.y)) {
            jdkSaveProperties(anonymousClass1, outputStream, "Ant properties");
        } else if (com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML.equals(this.y)) {
            xmlSaveProperties(anonymousClass1, outputStream);
        }
    }

    public void setDestfile(java.io.File file) {
        this.v = file;
    }

    public void setFailOnError(boolean z) {
        this.w = z;
    }

    public void setFormat(org.apache.tools.ant.taskdefs.optional.EchoProperties.FormatAttribute formatAttribute) {
        this.y = formatAttribute.getValue();
    }

    public void setPrefix(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.z = str;
        org.apache.tools.ant.types.PropertySet propertySet = new org.apache.tools.ant.types.PropertySet();
        propertySet.setProject(getProject());
        propertySet.appendPrefix(str);
        addPropertyset(propertySet);
    }

    public void setRegex(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.A = str;
        org.apache.tools.ant.types.PropertySet propertySet = new org.apache.tools.ant.types.PropertySet();
        propertySet.setProject(getProject());
        propertySet.appendRegex(str);
        addPropertyset(propertySet);
    }

    public void setSrcfile(java.io.File file) {
        this.u = file;
    }

    public void xmlSaveProperties(java.util.Properties properties, java.io.OutputStream outputStream) throws java.io.IOException {
        java.io.OutputStreamWriter outputStreamWriter;
        java.lang.Throwable th;
        java.io.IOException e;
        org.w3c.dom.Document newDocument = c().newDocument();
        org.w3c.dom.Element createElement = newDocument.createElement("properties");
        for (org.apache.tools.ant.taskdefs.optional.EchoProperties.Tuple tuple : d(properties)) {
            org.w3c.dom.Element createElement2 = newDocument.createElement(org.apache.tools.ant.taskdefs.condition.ParserSupports.PROPERTY);
            createElement2.setAttribute("name", tuple.n);
            createElement2.setAttribute("value", tuple.t);
            createElement.appendChild(createElement2);
        }
        try {
            outputStreamWriter = new java.io.OutputStreamWriter(outputStream, net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8);
            try {
                try {
                    outputStreamWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                    new org.apache.tools.ant.util.DOMElementWriter().write(createElement, outputStreamWriter, 0, "\t");
                    outputStreamWriter.flush();
                    org.apache.tools.ant.util.FileUtils.close(outputStreamWriter);
                } catch (java.io.IOException e2) {
                    e = e2;
                    throw new org.apache.tools.ant.BuildException("Unable to write XML file", e);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                org.apache.tools.ant.util.FileUtils.close(outputStreamWriter);
                throw th;
            }
        } catch (java.io.IOException e3) {
            outputStreamWriter = null;
            e = e3;
        } catch (java.lang.Throwable th3) {
            outputStreamWriter = null;
            th = th3;
            org.apache.tools.ant.util.FileUtils.close(outputStreamWriter);
            throw th;
        }
    }
}
