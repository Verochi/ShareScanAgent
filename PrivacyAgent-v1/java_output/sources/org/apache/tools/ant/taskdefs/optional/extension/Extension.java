package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public final class Extension {
    public java.lang.String a;
    public org.apache.tools.ant.util.DeweyDecimal b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public org.apache.tools.ant.util.DeweyDecimal f;
    public java.lang.String g;
    public static final java.util.jar.Attributes.Name EXTENSION_LIST = new java.util.jar.Attributes.Name("Extension-List");
    public static final java.util.jar.Attributes.Name OPTIONAL_EXTENSION_LIST = new java.util.jar.Attributes.Name("Optional-Extension-List");
    public static final java.util.jar.Attributes.Name EXTENSION_NAME = new java.util.jar.Attributes.Name("Extension-Name");
    public static final java.util.jar.Attributes.Name SPECIFICATION_VERSION = java.util.jar.Attributes.Name.SPECIFICATION_VERSION;
    public static final java.util.jar.Attributes.Name SPECIFICATION_VENDOR = java.util.jar.Attributes.Name.SPECIFICATION_VENDOR;
    public static final java.util.jar.Attributes.Name IMPLEMENTATION_VERSION = java.util.jar.Attributes.Name.IMPLEMENTATION_VERSION;
    public static final java.util.jar.Attributes.Name IMPLEMENTATION_VENDOR = java.util.jar.Attributes.Name.IMPLEMENTATION_VENDOR;
    public static final java.util.jar.Attributes.Name IMPLEMENTATION_URL = new java.util.jar.Attributes.Name("Implementation-URL");
    public static final java.util.jar.Attributes.Name IMPLEMENTATION_VENDOR_ID = new java.util.jar.Attributes.Name("Implementation-Vendor-Id");
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility COMPATIBLE = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("COMPATIBLE");
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility REQUIRE_SPECIFICATION_UPGRADE = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("REQUIRE_SPECIFICATION_UPGRADE");
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility REQUIRE_VENDOR_SWITCH = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("REQUIRE_VENDOR_SWITCH");
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility REQUIRE_IMPLEMENTATION_UPGRADE = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("REQUIRE_IMPLEMENTATION_UPGRADE");
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility INCOMPATIBLE = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("INCOMPATIBLE");

    public Extension(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        this.a = str;
        this.c = str3;
        if (str2 != null) {
            try {
                this.b = new org.apache.tools.ant.util.DeweyDecimal(str2);
            } catch (java.lang.NumberFormatException e) {
                throw new java.lang.IllegalArgumentException("Bad specification version format '" + str2 + "' in '" + str + "'. (Reason: " + e + ")");
            }
        }
        this.g = str7;
        this.e = str5;
        this.d = str6;
        if (str4 != null) {
            try {
                this.f = new org.apache.tools.ant.util.DeweyDecimal(str4);
            } catch (java.lang.NumberFormatException e2) {
                throw new java.lang.IllegalArgumentException("Bad implementation version format '" + str4 + "' in '" + str + "'. (Reason: " + e2 + ")");
            }
        }
        if (this.a == null) {
            throw new java.lang.NullPointerException("extensionName property is null");
        }
    }

    public static org.apache.tools.ant.taskdefs.optional.extension.Extension a(java.lang.String str, java.util.jar.Attributes attributes) {
        java.lang.String d = d(attributes.getValue(str + EXTENSION_NAME));
        if (d == null) {
            return null;
        }
        java.lang.String d2 = d(attributes.getValue(str + SPECIFICATION_VENDOR));
        return new org.apache.tools.ant.taskdefs.optional.extension.Extension(d, d(attributes.getValue(str + SPECIFICATION_VERSION)), d2, d(attributes.getValue(str + IMPLEMENTATION_VERSION)), d(attributes.getValue(str + IMPLEMENTATION_VENDOR)), d(attributes.getValue(str + IMPLEMENTATION_VENDOR_ID)), d(attributes.getValue(str + IMPLEMENTATION_URL)));
    }

    public static void addExtension(org.apache.tools.ant.taskdefs.optional.extension.Extension extension, java.lang.String str, java.util.jar.Attributes attributes) {
        attributes.putValue(str + EXTENSION_NAME, extension.getExtensionName());
        java.lang.String specificationVendor = extension.getSpecificationVendor();
        if (specificationVendor != null) {
            attributes.putValue(str + SPECIFICATION_VENDOR, specificationVendor);
        }
        org.apache.tools.ant.util.DeweyDecimal specificationVersion = extension.getSpecificationVersion();
        if (specificationVersion != null) {
            attributes.putValue(str + SPECIFICATION_VERSION, specificationVersion.toString());
        }
        java.lang.String implementationVendorID = extension.getImplementationVendorID();
        if (implementationVendorID != null) {
            attributes.putValue(str + IMPLEMENTATION_VENDOR_ID, implementationVendorID);
        }
        java.lang.String implementationVendor = extension.getImplementationVendor();
        if (implementationVendor != null) {
            attributes.putValue(str + IMPLEMENTATION_VENDOR, implementationVendor);
        }
        org.apache.tools.ant.util.DeweyDecimal implementationVersion = extension.getImplementationVersion();
        if (implementationVersion != null) {
            attributes.putValue(str + IMPLEMENTATION_VERSION, implementationVersion.toString());
        }
        java.lang.String implementationURL = extension.getImplementationURL();
        if (implementationURL != null) {
            attributes.putValue(str + IMPLEMENTATION_URL, implementationURL);
        }
    }

    public static void addExtension(org.apache.tools.ant.taskdefs.optional.extension.Extension extension, java.util.jar.Attributes attributes) {
        addExtension(extension, "", attributes);
    }

    public static void b(java.util.jar.Attributes attributes, java.util.ArrayList arrayList, java.util.jar.Attributes.Name name) {
        java.lang.String value = attributes.getValue(name);
        if (value == null) {
            return;
        }
        for (java.lang.String str : f(value, " ")) {
            org.apache.tools.ant.taskdefs.optional.extension.Extension a = a(str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, attributes);
            if (a != null) {
                arrayList.add(a);
            }
        }
    }

    public static org.apache.tools.ant.taskdefs.optional.extension.Extension[] c(java.util.jar.Manifest manifest, java.util.jar.Attributes.Name name) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.jar.Attributes mainAttributes = manifest.getMainAttributes();
        if (mainAttributes != null) {
            b(mainAttributes, arrayList, name);
        }
        java.util.Map<java.lang.String, java.util.jar.Attributes> entries = manifest.getEntries();
        java.util.Iterator<java.lang.String> it = entries.keySet().iterator();
        while (it.hasNext()) {
            b(entries.get(it.next()), arrayList, name);
        }
        return (org.apache.tools.ant.taskdefs.optional.extension.Extension[]) arrayList.toArray(new org.apache.tools.ant.taskdefs.optional.extension.Extension[arrayList.size()]);
    }

    public static java.lang.String d(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static java.lang.String[] f(java.lang.String str, java.lang.String str2) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, str2);
        int countTokens = stringTokenizer.countTokens();
        java.lang.String[] strArr = new java.lang.String[countTokens];
        for (int i = 0; i < countTokens; i++) {
            strArr[i] = stringTokenizer.nextToken();
        }
        return strArr;
    }

    public static org.apache.tools.ant.taskdefs.optional.extension.Extension[] getAvailable(java.util.jar.Manifest manifest) {
        org.apache.tools.ant.taskdefs.optional.extension.Extension a;
        if (manifest == null) {
            return new org.apache.tools.ant.taskdefs.optional.extension.Extension[0];
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.jar.Attributes mainAttributes = manifest.getMainAttributes();
        if (mainAttributes != null && (a = a("", mainAttributes)) != null) {
            arrayList.add(a);
        }
        java.util.Map<java.lang.String, java.util.jar.Attributes> entries = manifest.getEntries();
        java.util.Iterator<java.lang.String> it = entries.keySet().iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.extension.Extension a2 = a("", entries.get(it.next()));
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return (org.apache.tools.ant.taskdefs.optional.extension.Extension[]) arrayList.toArray(new org.apache.tools.ant.taskdefs.optional.extension.Extension[arrayList.size()]);
    }

    public static org.apache.tools.ant.taskdefs.optional.extension.Extension[] getOptions(java.util.jar.Manifest manifest) {
        return c(manifest, OPTIONAL_EXTENSION_LIST);
    }

    public static org.apache.tools.ant.taskdefs.optional.extension.Extension[] getRequired(java.util.jar.Manifest manifest) {
        return c(manifest, java.util.jar.Attributes.Name.EXTENSION_LIST);
    }

    public final boolean e(org.apache.tools.ant.util.DeweyDecimal deweyDecimal, org.apache.tools.ant.util.DeweyDecimal deweyDecimal2) {
        return deweyDecimal.isGreaterThanOrEqual(deweyDecimal2);
    }

    public org.apache.tools.ant.taskdefs.optional.extension.Compatibility getCompatibilityWith(org.apache.tools.ant.taskdefs.optional.extension.Extension extension) {
        org.apache.tools.ant.util.DeweyDecimal deweyDecimal;
        java.lang.String str;
        org.apache.tools.ant.util.DeweyDecimal deweyDecimal2;
        if (!this.a.equals(extension.getExtensionName())) {
            return INCOMPATIBLE;
        }
        org.apache.tools.ant.util.DeweyDecimal specificationVersion = extension.getSpecificationVersion();
        if (specificationVersion != null && ((deweyDecimal2 = this.b) == null || !e(deweyDecimal2, specificationVersion))) {
            return REQUIRE_SPECIFICATION_UPGRADE;
        }
        java.lang.String implementationVendorID = extension.getImplementationVendorID();
        if (implementationVendorID != null && ((str = this.d) == null || !str.equals(implementationVendorID))) {
            return REQUIRE_VENDOR_SWITCH;
        }
        org.apache.tools.ant.util.DeweyDecimal implementationVersion = extension.getImplementationVersion();
        return (implementationVersion == null || ((deweyDecimal = this.f) != null && e(deweyDecimal, implementationVersion))) ? COMPATIBLE : REQUIRE_IMPLEMENTATION_UPGRADE;
    }

    public java.lang.String getExtensionName() {
        return this.a;
    }

    public java.lang.String getImplementationURL() {
        return this.g;
    }

    public java.lang.String getImplementationVendor() {
        return this.e;
    }

    public java.lang.String getImplementationVendorID() {
        return this.d;
    }

    public org.apache.tools.ant.util.DeweyDecimal getImplementationVersion() {
        return this.f;
    }

    public java.lang.String getSpecificationVendor() {
        return this.c;
    }

    public org.apache.tools.ant.util.DeweyDecimal getSpecificationVersion() {
        return this.b;
    }

    public boolean isCompatibleWith(org.apache.tools.ant.taskdefs.optional.extension.Extension extension) {
        return COMPATIBLE == getCompatibilityWith(extension);
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(EXTENSION_NAME.toString());
        stringBuffer.append(": ");
        stringBuffer.append(this.a);
        java.lang.String str = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        stringBuffer.append(str);
        if (this.b != null) {
            stringBuffer.append(SPECIFICATION_VERSION);
            stringBuffer.append(": ");
            stringBuffer.append(this.b);
            stringBuffer.append(str);
        }
        if (this.c != null) {
            stringBuffer.append(SPECIFICATION_VENDOR);
            stringBuffer.append(": ");
            stringBuffer.append(this.c);
            stringBuffer.append(str);
        }
        if (this.f != null) {
            stringBuffer.append(IMPLEMENTATION_VERSION);
            stringBuffer.append(": ");
            stringBuffer.append(this.f);
            stringBuffer.append(str);
        }
        if (this.d != null) {
            stringBuffer.append(IMPLEMENTATION_VENDOR_ID);
            stringBuffer.append(": ");
            stringBuffer.append(this.d);
            stringBuffer.append(str);
        }
        if (this.e != null) {
            stringBuffer.append(IMPLEMENTATION_VENDOR);
            stringBuffer.append(": ");
            stringBuffer.append(this.e);
            stringBuffer.append(str);
        }
        if (this.g != null) {
            stringBuffer.append(IMPLEMENTATION_URL);
            stringBuffer.append(": ");
            stringBuffer.append(this.g);
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
