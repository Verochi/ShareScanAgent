package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Manifest {
    public static final java.lang.String ATTRIBUTE_CLASSPATH = "Class-Path";
    public static final java.lang.String ATTRIBUTE_FROM = "From";
    public static final java.lang.String ATTRIBUTE_MANIFEST_VERSION = "Manifest-Version";
    public static final java.lang.String ATTRIBUTE_NAME = "Name";
    public static final java.lang.String ATTRIBUTE_SIGNATURE_VERSION = "Signature-Version";
    public static final java.lang.String DEFAULT_MANIFEST_VERSION = "1.0";
    public static final java.lang.String EOL = "\r\n";
    public static final java.lang.String ERROR_FROM_FORBIDDEN = "Manifest attributes should not start with \"From\" in \"";
    public static final java.lang.String JAR_ENCODING = "UTF-8";
    public static final int MAX_LINE_LENGTH = 72;
    public static final int MAX_SECTION_LENGTH = 70;
    public static final java.lang.String d;
    public static final java.lang.String e;
    public static final java.lang.String f;
    public static final java.lang.String g;
    public java.lang.String a;
    public org.apache.tools.ant.taskdefs.Manifest.Section b = new org.apache.tools.ant.taskdefs.Manifest.Section();
    public java.util.Map<java.lang.String, org.apache.tools.ant.taskdefs.Manifest.Section> c = new java.util.LinkedHashMap();

    public static class Attribute {
        public java.lang.String a;
        public java.util.Vector<java.lang.String> b;
        public int c;

        public Attribute() {
            this.a = null;
            this.b = new java.util.Vector<>();
            this.c = 0;
        }

        public Attribute(java.lang.String str) throws org.apache.tools.ant.taskdefs.ManifestException {
            this.a = null;
            this.b = new java.util.Vector<>();
            this.c = 0;
            parse(str);
        }

        public Attribute(java.lang.String str, java.lang.String str2) {
            this.a = null;
            this.b = new java.util.Vector<>();
            this.c = 0;
            this.a = str;
            setValue(str2);
        }

        public final void a(java.io.PrintWriter printWriter, java.lang.String str) throws java.io.IOException {
            java.lang.String str2;
            int length = this.a.getBytes("UTF-8").length;
            if (length <= 68) {
                str2 = this.a + ": " + str;
            } else {
                if (length > 70) {
                    throw new java.io.IOException("Unable to write manifest line " + this.a + ": " + str);
                }
                printWriter.print(this.a + ": \r\n");
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(" ");
                sb.append(str);
                str2 = sb.toString();
            }
            while (str2.getBytes("UTF-8").length > 70) {
                int length2 = 70 >= str2.length() ? str2.length() - 1 : 70;
                java.lang.String substring = str2.substring(0, length2);
                while (substring.getBytes("UTF-8").length > 70 && length2 > 0) {
                    length2--;
                    substring = str2.substring(0, length2);
                }
                if (length2 == 0) {
                    throw new java.io.IOException("Unable to write manifest line " + this.a + ": " + str);
                }
                printWriter.print(substring + "\r\n");
                str2 = " " + str2.substring(length2);
            }
            printWriter.print(str2 + "\r\n");
        }

        public void addContinuation(java.lang.String str) {
            setValue(this.b.elementAt(this.c) + str.substring(1));
        }

        public void addValue(java.lang.String str) {
            this.c++;
            setValue(str);
        }

        public boolean equals(java.lang.Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            org.apache.tools.ant.taskdefs.Manifest.Attribute attribute = (org.apache.tools.ant.taskdefs.Manifest.Attribute) obj;
            java.lang.String key = getKey();
            java.lang.String key2 = attribute.getKey();
            if ((key != null || key2 == null) && (key == null || key.equals(key2))) {
                return this.b.equals(attribute.b);
            }
            return false;
        }

        public java.lang.String getKey() {
            java.lang.String str = this.a;
            if (str == null) {
                return null;
            }
            return str.toLowerCase(java.util.Locale.ENGLISH);
        }

        public java.lang.String getName() {
            return this.a;
        }

        public java.lang.String getValue() {
            if (this.b.size() == 0) {
                return null;
            }
            java.util.Enumeration<java.lang.String> values = getValues();
            java.lang.String str = "";
            while (values.hasMoreElements()) {
                str = str + values.nextElement() + " ";
            }
            return str.trim();
        }

        public java.util.Enumeration<java.lang.String> getValues() {
            return this.b.elements();
        }

        public int hashCode() {
            return (this.a != null ? 0 + getKey().hashCode() : 0) + this.b.hashCode();
        }

        public void parse(java.lang.String str) throws org.apache.tools.ant.taskdefs.ManifestException {
            int indexOf = str.indexOf(": ");
            if (indexOf != -1) {
                this.a = str.substring(0, indexOf);
                setValue(str.substring(indexOf + 2));
            } else {
                throw new org.apache.tools.ant.taskdefs.ManifestException("Manifest line \"" + str + "\" is not valid as it does not contain a name and a value separated by ': ' ");
            }
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }

        public void setValue(java.lang.String str) {
            if (this.c < this.b.size()) {
                this.b.setElementAt(str, this.c);
            } else {
                this.b.addElement(str);
                this.c = this.b.size() - 1;
            }
        }

        public void write(java.io.PrintWriter printWriter) throws java.io.IOException {
            write(printWriter, false);
        }

        public void write(java.io.PrintWriter printWriter, boolean z) throws java.io.IOException {
            if (z) {
                a(printWriter, getValue());
                return;
            }
            java.util.Enumeration<java.lang.String> values = getValues();
            while (values.hasMoreElements()) {
                a(printWriter, values.nextElement());
            }
        }
    }

    public static class Section {
        public java.util.Vector<java.lang.String> a = new java.util.Vector<>();
        public java.lang.String b = null;
        public java.util.Map<java.lang.String, org.apache.tools.ant.taskdefs.Manifest.Attribute> c = new java.util.LinkedHashMap();

        public java.lang.String addAttributeAndCheck(org.apache.tools.ant.taskdefs.Manifest.Attribute attribute) throws org.apache.tools.ant.taskdefs.ManifestException {
            if (attribute.getName() == null || attribute.getValue() == null) {
                throw new org.apache.tools.ant.BuildException("Attributes must have name and value");
            }
            java.lang.String key = attribute.getKey();
            if (key.equals(org.apache.tools.ant.taskdefs.Manifest.e)) {
                this.a.addElement("\"Name\" attributes should not occur in the main section and must be the first element in all other sections: \"" + attribute.getName() + ": " + attribute.getValue() + "\"");
                return attribute.getValue();
            }
            if (key.startsWith(org.apache.tools.ant.taskdefs.Manifest.f)) {
                this.a.addElement(org.apache.tools.ant.taskdefs.Manifest.ERROR_FROM_FORBIDDEN + attribute.getName() + ": " + attribute.getValue() + "\"");
                return null;
            }
            if (!key.equals(org.apache.tools.ant.taskdefs.Manifest.g)) {
                if (!this.c.containsKey(key)) {
                    b(attribute);
                    return null;
                }
                throw new org.apache.tools.ant.taskdefs.ManifestException("The attribute \"" + attribute.getName() + "\" may not occur more than once in the same section");
            }
            org.apache.tools.ant.taskdefs.Manifest.Attribute attribute2 = this.c.get(key);
            if (attribute2 == null) {
                b(attribute);
                return null;
            }
            this.a.addElement("Multiple Class-Path attributes are supported but violate the Jar specification and may not be correctly processed in all environments");
            java.util.Enumeration<java.lang.String> values = attribute.getValues();
            while (values.hasMoreElements()) {
                attribute2.addValue(values.nextElement());
            }
            return null;
        }

        public void addConfiguredAttribute(org.apache.tools.ant.taskdefs.Manifest.Attribute attribute) throws org.apache.tools.ant.taskdefs.ManifestException {
            if (addAttributeAndCheck(attribute) != null) {
                throw new org.apache.tools.ant.BuildException("Specify the section name using the \"name\" attribute of the <section> element rather than using a \"Name\" manifest attribute");
            }
        }

        public final void b(org.apache.tools.ant.taskdefs.Manifest.Attribute attribute) {
            if (attribute == null) {
                return;
            }
            this.c.put(attribute.getKey(), attribute);
        }

        public java.lang.Object clone() {
            org.apache.tools.ant.taskdefs.Manifest.Section section = new org.apache.tools.ant.taskdefs.Manifest.Section();
            section.setName(this.b);
            java.util.Enumeration<java.lang.String> attributeKeys = getAttributeKeys();
            while (attributeKeys.hasMoreElements()) {
                org.apache.tools.ant.taskdefs.Manifest.Attribute attribute = getAttribute(attributeKeys.nextElement());
                section.b(new org.apache.tools.ant.taskdefs.Manifest.Attribute(attribute.getName(), attribute.getValue()));
            }
            return section;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return this.c.equals(((org.apache.tools.ant.taskdefs.Manifest.Section) obj).c);
        }

        public org.apache.tools.ant.taskdefs.Manifest.Attribute getAttribute(java.lang.String str) {
            return this.c.get(str.toLowerCase(java.util.Locale.ENGLISH));
        }

        public java.util.Enumeration<java.lang.String> getAttributeKeys() {
            return org.apache.tools.ant.util.CollectionUtils.asEnumeration(this.c.keySet().iterator());
        }

        public java.lang.String getAttributeValue(java.lang.String str) {
            org.apache.tools.ant.taskdefs.Manifest.Attribute attribute = getAttribute(str.toLowerCase(java.util.Locale.ENGLISH));
            if (attribute == null) {
                return null;
            }
            return attribute.getValue();
        }

        public java.lang.String getName() {
            return this.b;
        }

        public java.util.Enumeration<java.lang.String> getWarnings() {
            return this.a.elements();
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public void merge(org.apache.tools.ant.taskdefs.Manifest.Section section) throws org.apache.tools.ant.taskdefs.ManifestException {
            merge(section, false);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        
            if (r0.toLowerCase(r1).equals(r6.getName().toLowerCase(r1)) != false) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void merge(org.apache.tools.ant.taskdefs.Manifest.Section section, boolean z) throws org.apache.tools.ant.taskdefs.ManifestException {
            org.apache.tools.ant.taskdefs.Manifest.Attribute attribute;
            if (this.b != null || section.getName() == null) {
                if (this.b != null && section.getName() != null) {
                    java.lang.String str = this.b;
                    java.util.Locale locale = java.util.Locale.ENGLISH;
                }
                java.util.Enumeration<java.lang.String> attributeKeys = section.getAttributeKeys();
                org.apache.tools.ant.taskdefs.Manifest.Attribute attribute2 = null;
                while (attributeKeys.hasMoreElements()) {
                    java.lang.String nextElement = attributeKeys.nextElement();
                    org.apache.tools.ant.taskdefs.Manifest.Attribute attribute3 = section.getAttribute(nextElement);
                    if (nextElement.equalsIgnoreCase(org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_CLASSPATH)) {
                        if (attribute2 == null) {
                            attribute2 = new org.apache.tools.ant.taskdefs.Manifest.Attribute();
                            attribute2.setName(org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_CLASSPATH);
                        }
                        java.util.Enumeration<java.lang.String> values = attribute3.getValues();
                        while (values.hasMoreElements()) {
                            attribute2.addValue(values.nextElement());
                        }
                    } else {
                        b(attribute3);
                    }
                }
                if (attribute2 != null) {
                    if (z && (attribute = getAttribute(org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_CLASSPATH)) != null) {
                        java.util.Enumeration<java.lang.String> values2 = attribute.getValues();
                        while (values2.hasMoreElements()) {
                            attribute2.addValue(values2.nextElement());
                        }
                    }
                    b(attribute2);
                }
                java.util.Enumeration<java.lang.String> elements = section.a.elements();
                while (elements.hasMoreElements()) {
                    this.a.addElement(elements.nextElement());
                }
                return;
            }
            throw new org.apache.tools.ant.taskdefs.ManifestException("Unable to merge sections with different names");
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.String read(java.io.BufferedReader bufferedReader) throws org.apache.tools.ant.taskdefs.ManifestException, java.io.IOException {
            org.apache.tools.ant.taskdefs.Manifest.Attribute attribute = null;
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.length() == 0) {
                    break;
                }
                if (readLine.charAt(0) != ' ') {
                    org.apache.tools.ant.taskdefs.Manifest.Attribute attribute2 = new org.apache.tools.ant.taskdefs.Manifest.Attribute(readLine);
                    java.lang.String addAttributeAndCheck = addAttributeAndCheck(attribute2);
                    attribute = getAttribute(attribute2.getKey());
                    if (addAttributeAndCheck != null) {
                        return addAttributeAndCheck;
                    }
                } else if (attribute != null) {
                    attribute.addContinuation(readLine);
                } else {
                    if (this.b == null) {
                        throw new org.apache.tools.ant.taskdefs.ManifestException("Can't start an attribute with a continuation line " + readLine);
                    }
                    this.b += readLine.substring(1);
                }
            }
        }

        public void removeAttribute(java.lang.String str) {
            this.c.remove(str.toLowerCase(java.util.Locale.ENGLISH));
        }

        public void setName(java.lang.String str) {
            this.b = str;
        }

        public void write(java.io.PrintWriter printWriter) throws java.io.IOException {
            write(printWriter, false);
        }

        public void write(java.io.PrintWriter printWriter, boolean z) throws java.io.IOException {
            java.lang.String str = this.b;
            if (str != null) {
                new org.apache.tools.ant.taskdefs.Manifest.Attribute(org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_NAME, str).write(printWriter);
            }
            java.util.Enumeration<java.lang.String> attributeKeys = getAttributeKeys();
            while (attributeKeys.hasMoreElements()) {
                getAttribute(attributeKeys.nextElement()).write(printWriter, z);
            }
            printWriter.print("\r\n");
        }
    }

    static {
        java.util.Locale locale = java.util.Locale.ENGLISH;
        d = ATTRIBUTE_MANIFEST_VERSION.toLowerCase(locale);
        e = ATTRIBUTE_NAME.toLowerCase(locale);
        f = "From".toLowerCase(locale);
        g = ATTRIBUTE_CLASSPATH.toLowerCase(locale);
    }

    public Manifest() {
        this.a = "1.0";
        this.a = null;
    }

    public Manifest(java.io.Reader reader) throws org.apache.tools.ant.taskdefs.ManifestException, java.io.IOException {
        this.a = "1.0";
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(reader);
        java.lang.String read = this.b.read(bufferedReader);
        java.lang.String attributeValue = this.b.getAttributeValue(ATTRIBUTE_MANIFEST_VERSION);
        if (attributeValue != null) {
            this.a = attributeValue;
            this.b.removeAttribute(ATTRIBUTE_MANIFEST_VERSION);
        }
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (readLine.length() != 0) {
                org.apache.tools.ant.taskdefs.Manifest.Section section = new org.apache.tools.ant.taskdefs.Manifest.Section();
                if (read == null) {
                    org.apache.tools.ant.taskdefs.Manifest.Attribute attribute = new org.apache.tools.ant.taskdefs.Manifest.Attribute(readLine);
                    if (!attribute.getName().equalsIgnoreCase(ATTRIBUTE_NAME)) {
                        throw new org.apache.tools.ant.taskdefs.ManifestException("Manifest sections should start with a \"Name\" attribute and not \"" + attribute.getName() + "\"");
                    }
                    read = attribute.getValue();
                } else {
                    section.addAttributeAndCheck(new org.apache.tools.ant.taskdefs.Manifest.Attribute(readLine));
                }
                section.setName(read);
                read = section.read(bufferedReader);
                addConfiguredSection(section);
            }
        }
    }

    public static org.apache.tools.ant.taskdefs.Manifest getDefaultManifest() throws org.apache.tools.ant.BuildException {
        java.io.InputStream inputStream;
        java.lang.Throwable th;
        java.io.Reader reader;
        org.apache.tools.ant.taskdefs.ManifestException e2;
        java.io.IOException e3;
        java.io.InputStreamReader inputStreamReader;
        org.apache.tools.ant.taskdefs.Manifest manifest;
        try {
            try {
                inputStream = org.apache.tools.ant.taskdefs.Manifest.class.getResourceAsStream("/org/apache/tools/ant/defaultManifest.mf");
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e4) {
            e3 = e4;
        } catch (org.apache.tools.ant.taskdefs.ManifestException e5) {
            e2 = e5;
        } catch (java.lang.Throwable th3) {
            inputStream = null;
            th = th3;
            reader = null;
        }
        try {
            if (inputStream == null) {
                throw new org.apache.tools.ant.BuildException("Could not find default manifest: /org/apache/tools/ant/defaultManifest.mf");
            }
            try {
                inputStreamReader = new java.io.InputStreamReader(inputStream, "UTF-8");
            } catch (java.io.UnsupportedEncodingException unused) {
            }
            try {
                try {
                    manifest = new org.apache.tools.ant.taskdefs.Manifest(inputStreamReader);
                    java.lang.String property = java.lang.System.getProperty("java.runtime.version");
                    if (property == null) {
                        property = java.lang.System.getProperty("java.vm.version");
                    }
                    manifest.getMainSection().b(new org.apache.tools.ant.taskdefs.Manifest.Attribute("Created-By", property + " (" + java.lang.System.getProperty("java.vm.vendor") + ")"));
                } catch (java.io.UnsupportedEncodingException unused2) {
                    inputStreamReader = new java.io.InputStreamReader(inputStream);
                    manifest = new org.apache.tools.ant.taskdefs.Manifest(inputStreamReader);
                    org.apache.tools.ant.util.FileUtils.close(inputStreamReader);
                    org.apache.tools.ant.util.FileUtils.close(inputStream);
                    return manifest;
                }
                org.apache.tools.ant.util.FileUtils.close(inputStreamReader);
                org.apache.tools.ant.util.FileUtils.close(inputStream);
                return manifest;
            } catch (java.io.IOException e6) {
                e3 = e6;
                throw new org.apache.tools.ant.BuildException("Unable to read default manifest", e3);
            } catch (org.apache.tools.ant.taskdefs.ManifestException e7) {
                e2 = e7;
                throw new org.apache.tools.ant.BuildException("Default manifest is invalid !!", e2);
            }
        } catch (java.io.IOException e8) {
            e3 = e8;
        } catch (org.apache.tools.ant.taskdefs.ManifestException e9) {
            e2 = e9;
        } catch (java.lang.Throwable th4) {
            reader = null;
            th = th4;
            org.apache.tools.ant.util.FileUtils.close(reader);
            org.apache.tools.ant.util.FileUtils.close(inputStream);
            throw th;
        }
    }

    public void addConfiguredAttribute(org.apache.tools.ant.taskdefs.Manifest.Attribute attribute) throws org.apache.tools.ant.taskdefs.ManifestException {
        if (attribute.getKey() == null || attribute.getValue() == null) {
            throw new org.apache.tools.ant.BuildException("Attributes must have name and value");
        }
        if (attribute.getKey().equals(d)) {
            this.a = attribute.getValue();
        } else {
            this.b.addConfiguredAttribute(attribute);
        }
    }

    public void addConfiguredSection(org.apache.tools.ant.taskdefs.Manifest.Section section) throws org.apache.tools.ant.taskdefs.ManifestException {
        java.lang.String name = section.getName();
        if (name == null) {
            throw new org.apache.tools.ant.BuildException("Sections must have a name");
        }
        this.c.put(name, section);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        org.apache.tools.ant.taskdefs.Manifest manifest = (org.apache.tools.ant.taskdefs.Manifest) obj;
        java.lang.String str = this.a;
        if (str == null) {
            if (manifest.a != null) {
                return false;
            }
        } else if (!str.equals(manifest.a)) {
            return false;
        }
        if (this.b.equals(manifest.b)) {
            return this.c.equals(manifest.c);
        }
        return false;
    }

    public org.apache.tools.ant.taskdefs.Manifest.Section getMainSection() {
        return this.b;
    }

    public java.lang.String getManifestVersion() {
        return this.a;
    }

    public org.apache.tools.ant.taskdefs.Manifest.Section getSection(java.lang.String str) {
        return this.c.get(str);
    }

    public java.util.Enumeration<java.lang.String> getSectionNames() {
        return org.apache.tools.ant.util.CollectionUtils.asEnumeration(this.c.keySet().iterator());
    }

    public java.util.Enumeration<java.lang.String> getWarnings() {
        java.util.Vector vector = new java.util.Vector();
        java.util.Enumeration<java.lang.String> warnings = this.b.getWarnings();
        while (warnings.hasMoreElements()) {
            vector.addElement(warnings.nextElement());
        }
        java.util.Iterator<org.apache.tools.ant.taskdefs.Manifest.Section> it = this.c.values().iterator();
        while (it.hasNext()) {
            java.util.Enumeration<java.lang.String> warnings2 = it.next().getWarnings();
            while (warnings2.hasMoreElements()) {
                vector.addElement(warnings2.nextElement());
            }
        }
        return vector.elements();
    }

    public int hashCode() {
        java.lang.String str = this.a;
        return (str != null ? 0 + str.hashCode() : 0) + this.b.hashCode() + this.c.hashCode();
    }

    public void merge(org.apache.tools.ant.taskdefs.Manifest manifest) throws org.apache.tools.ant.taskdefs.ManifestException {
        merge(manifest, false);
    }

    public void merge(org.apache.tools.ant.taskdefs.Manifest manifest, boolean z) throws org.apache.tools.ant.taskdefs.ManifestException {
        merge(manifest, z, false);
    }

    public void merge(org.apache.tools.ant.taskdefs.Manifest manifest, boolean z, boolean z2) throws org.apache.tools.ant.taskdefs.ManifestException {
        if (manifest != null) {
            if (z) {
                this.b = (org.apache.tools.ant.taskdefs.Manifest.Section) manifest.b.clone();
            } else {
                this.b.merge(manifest.b, z2);
            }
            java.lang.String str = manifest.a;
            if (str != null) {
                this.a = str;
            }
            java.util.Enumeration<java.lang.String> sectionNames = manifest.getSectionNames();
            while (sectionNames.hasMoreElements()) {
                java.lang.String nextElement = sectionNames.nextElement();
                org.apache.tools.ant.taskdefs.Manifest.Section section = this.c.get(nextElement);
                org.apache.tools.ant.taskdefs.Manifest.Section section2 = manifest.c.get(nextElement);
                if (section != null) {
                    section.merge(section2, z2);
                } else if (section2 != null) {
                    addConfiguredSection((org.apache.tools.ant.taskdefs.Manifest.Section) section2.clone());
                }
            }
        }
    }

    public java.lang.String toString() {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        try {
            write(new java.io.PrintWriter(stringWriter));
            return stringWriter.toString();
        } catch (java.io.IOException unused) {
            return "";
        }
    }

    public void write(java.io.PrintWriter printWriter) throws java.io.IOException {
        write(printWriter, false);
    }

    public void write(java.io.PrintWriter printWriter, boolean z) throws java.io.IOException {
        printWriter.print("Manifest-Version: " + this.a + "\r\n");
        java.lang.String attributeValue = this.b.getAttributeValue(ATTRIBUTE_SIGNATURE_VERSION);
        if (attributeValue != null) {
            printWriter.print("Signature-Version: " + attributeValue + "\r\n");
            this.b.removeAttribute(ATTRIBUTE_SIGNATURE_VERSION);
        }
        this.b.write(printWriter, z);
        if (attributeValue != null) {
            try {
                this.b.addConfiguredAttribute(new org.apache.tools.ant.taskdefs.Manifest.Attribute(ATTRIBUTE_SIGNATURE_VERSION, attributeValue));
            } catch (org.apache.tools.ant.taskdefs.ManifestException unused) {
            }
        }
        java.util.Iterator<java.lang.String> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            getSection(it.next()).write(printWriter, z);
        }
    }
}
