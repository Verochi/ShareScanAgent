package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class SchemaValidate extends org.apache.tools.ant.taskdefs.optional.XMLValidateTask {
    public static final java.lang.String ERROR_DUPLICATE_SCHEMA = "Duplicate declaration of schema ";
    public static final java.lang.String ERROR_NO_XSD_SUPPORT = "Parser does not support Xerces or JAXP schema features";
    public static final java.lang.String ERROR_PARSER_CREATION_FAILURE = "Could not create parser";
    public static final java.lang.String ERROR_SAX_1 = "SAX1 parsers are not supported";
    public static final java.lang.String ERROR_TOO_MANY_DEFAULT_SCHEMAS = "Only one of defaultSchemaFile and defaultSchemaURL allowed";
    public static final java.lang.String MESSAGE_ADDING_SCHEMA = "Adding schema ";
    public org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation C;
    public java.util.HashMap z = new java.util.HashMap();
    public boolean A = true;
    public boolean B = false;

    public static class SchemaLocation {
        public static final java.lang.String ERROR_NO_FILE = "File not found: ";
        public static final java.lang.String ERROR_NO_LOCATION = "No file or URL supplied for the schema ";
        public static final java.lang.String ERROR_NO_URI = "No namespace URI";
        public static final java.lang.String ERROR_NO_URL_REPRESENTATION = "Cannot make a URL of ";
        public static final java.lang.String ERROR_TWO_LOCATIONS = "Both URL and File were given for schema ";
        public java.lang.String a;
        public java.io.File b;
        public java.lang.String c;

        public final boolean a(java.lang.String str) {
            return (str == null || str.length() == 0) ? false : true;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation)) {
                return false;
            }
            org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation schemaLocation = (org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation) obj;
            java.io.File file = this.b;
            if (file == null ? schemaLocation.b != null : !file.equals(schemaLocation.b)) {
                return false;
            }
            java.lang.String str = this.a;
            if (str == null ? schemaLocation.a != null : !str.equals(schemaLocation.a)) {
                return false;
            }
            java.lang.String str2 = this.c;
            java.lang.String str3 = schemaLocation.c;
            return str2 == null ? str3 == null : str2.equals(str3);
        }

        public java.io.File getFile() {
            return this.b;
        }

        public java.lang.String getNamespace() {
            return this.a;
        }

        public java.lang.String getSchemaLocationURL() {
            boolean z = this.b != null;
            boolean a = a(this.c);
            if (!z && !a) {
                throw new org.apache.tools.ant.BuildException(ERROR_NO_LOCATION + this.a);
            }
            if (z && a) {
                throw new org.apache.tools.ant.BuildException(ERROR_TWO_LOCATIONS + this.a);
            }
            java.lang.String str = this.c;
            if (!z) {
                return str;
            }
            if (!this.b.exists()) {
                throw new org.apache.tools.ant.BuildException(ERROR_NO_FILE + this.b);
            }
            try {
                return org.apache.tools.ant.util.FileUtils.getFileUtils().getFileURL(this.b).toString();
            } catch (java.net.MalformedURLException e) {
                throw new org.apache.tools.ant.BuildException(ERROR_NO_URL_REPRESENTATION + this.b, e);
            }
        }

        public java.lang.String getURIandLocation() throws org.apache.tools.ant.BuildException {
            validateNamespace();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append(this.a);
            stringBuffer.append(' ');
            stringBuffer.append(getSchemaLocationURL());
            return new java.lang.String(stringBuffer);
        }

        public java.lang.String getUrl() {
            return this.c;
        }

        public int hashCode() {
            java.lang.String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 29;
            java.io.File file = this.b;
            int hashCode2 = (hashCode + (file != null ? file.hashCode() : 0)) * 29;
            java.lang.String str2 = this.c;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public void setFile(java.io.File file) {
            this.b = file;
        }

        public void setNamespace(java.lang.String str) {
            this.a = str;
        }

        public void setUrl(java.lang.String str) {
            this.c = str;
        }

        public java.lang.String toString() {
            java.lang.String str;
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.lang.String str2 = this.a;
            if (str2 == null) {
                str2 = "(anonymous)";
            }
            stringBuffer.append(str2);
            stringBuffer.append(' ');
            if (this.c != null) {
                str = this.c + " ";
            } else {
                str = "";
            }
            stringBuffer.append(str);
            java.io.File file = this.b;
            stringBuffer.append(file != null ? file.getAbsolutePath() : "");
            return stringBuffer.toString();
        }

        public void validateNamespace() {
            if (!a(getNamespace())) {
                throw new org.apache.tools.ant.BuildException(ERROR_NO_URI);
            }
        }
    }

    public void addConfiguredSchema(org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation schemaLocation) {
        log("adding schema " + schemaLocation, 4);
        schemaLocation.validateNamespace();
        org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation schemaLocation2 = (org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation) this.z.get(schemaLocation.getNamespace());
        if (schemaLocation2 == null || schemaLocation2.equals(schemaLocation)) {
            this.z.put(schemaLocation.getNamespace(), schemaLocation);
            return;
        }
        throw new org.apache.tools.ant.BuildException(ERROR_DUPLICATE_SCHEMA + schemaLocation);
    }

    public void addSchemaLocations() {
        java.util.Iterator it = this.z.values().iterator();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int i = 0;
        while (it.hasNext()) {
            if (i > 0) {
                stringBuffer.append(' ');
            }
            java.lang.String uRIandLocation = ((org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation) it.next()).getURIandLocation();
            stringBuffer.append(uRIandLocation);
            log(MESSAGE_ADDING_SCHEMA + uRIandLocation, 3);
            i++;
        }
        if (i > 0) {
            setProperty(org.apache.tools.ant.util.XmlConstants.PROPERTY_SCHEMA_LOCATION, stringBuffer.toString());
        }
    }

    public void createAnonymousSchema() {
        if (this.C == null) {
            this.C = new org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation();
        }
        this.C.setNamespace("(no namespace)");
    }

    @Override // org.apache.tools.ant.taskdefs.optional.XMLValidateTask
    public org.xml.sax.XMLReader createDefaultReader() {
        javax.xml.parsers.SAXParserFactory newInstance = javax.xml.parsers.SAXParserFactory.newInstance();
        newInstance.setValidating(true);
        newInstance.setNamespaceAware(true);
        try {
            return newInstance.newSAXParser().getXMLReader();
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new org.apache.tools.ant.BuildException(ERROR_PARSER_CREATION_FAILURE, e);
        } catch (org.xml.sax.SAXException e2) {
            throw new org.apache.tools.ant.BuildException(ERROR_PARSER_CREATION_FAILURE, e2);
        }
    }

    public final void e(java.lang.String str) {
        java.lang.String noNamespaceSchemaURL = getNoNamespaceSchemaURL();
        if (noNamespaceSchemaURL != null) {
            setProperty(str, noNamespaceSchemaURL);
        }
    }

    public boolean enableJAXP12SchemaValidation() {
        try {
            setProperty(org.apache.tools.ant.util.XmlConstants.FEATURE_JAXP12_SCHEMA_LANGUAGE, org.apache.tools.ant.util.XmlConstants.URI_XSD);
            e(org.apache.tools.ant.util.XmlConstants.FEATURE_JAXP12_SCHEMA_SOURCE);
            return true;
        } catch (org.apache.tools.ant.BuildException e) {
            log(e.toString(), 3);
            return false;
        }
    }

    public boolean enableXercesSchemaValidation() {
        try {
            setFeature(org.apache.tools.ant.util.XmlConstants.FEATURE_XSD, true);
            e(org.apache.tools.ant.util.XmlConstants.PROPERTY_NO_NAMESPACE_SCHEMA_LOCATION);
            return true;
        } catch (org.apache.tools.ant.BuildException e) {
            log(e.toString(), 3);
            return false;
        }
    }

    public java.lang.String getNoNamespaceSchemaURL() {
        org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation schemaLocation = this.C;
        if (schemaLocation == null) {
            return null;
        }
        return schemaLocation.getSchemaLocationURL();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.XMLValidateTask, org.apache.tools.ant.Task
    public void init() throws org.apache.tools.ant.BuildException {
        super.init();
        setLenient(false);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.XMLValidateTask
    public void initValidator() {
        super.initValidator();
        if (isSax1Parser()) {
            throw new org.apache.tools.ant.BuildException(ERROR_SAX_1);
        }
        setFeature(org.apache.tools.ant.util.XmlConstants.FEATURE_NAMESPACES, true);
        if (!enableXercesSchemaValidation() && !enableJAXP12SchemaValidation()) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_XSD_SUPPORT);
        }
        setFeature(org.apache.tools.ant.util.XmlConstants.FEATURE_XSD_FULL_VALIDATION, this.A);
        setFeatureIfSupported(org.apache.tools.ant.util.XmlConstants.FEATURE_DISALLOW_DTD, this.B);
        addSchemaLocations();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.XMLValidateTask
    public void onSuccessfulValidation(int i) {
        log(i + org.apache.tools.ant.taskdefs.optional.XMLValidateTask.MESSAGE_FILES_VALIDATED, 3);
    }

    public void setDisableDTD(boolean z) {
        this.B = z;
    }

    public void setFeatureIfSupported(java.lang.String str, boolean z) {
        try {
            getXmlReader().setFeature(str, z);
        } catch (org.xml.sax.SAXNotRecognizedException unused) {
            log("Not recognized: " + str, 3);
        } catch (org.xml.sax.SAXNotSupportedException unused2) {
            log("Not supported: " + str, 3);
        }
    }

    public void setFullChecking(boolean z) {
        this.A = z;
    }

    public void setNoNamespaceFile(java.io.File file) {
        createAnonymousSchema();
        this.C.setFile(file);
    }

    public void setNoNamespaceURL(java.lang.String str) {
        createAnonymousSchema();
        this.C.setUrl(str);
    }
}
