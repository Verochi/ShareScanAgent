package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public final class Specification {
    public java.lang.String a;
    public org.apache.tools.ant.util.DeweyDecimal b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String[] g;
    public static final java.util.jar.Attributes.Name SPECIFICATION_TITLE = java.util.jar.Attributes.Name.SPECIFICATION_TITLE;
    public static final java.util.jar.Attributes.Name SPECIFICATION_VERSION = java.util.jar.Attributes.Name.SPECIFICATION_VERSION;
    public static final java.util.jar.Attributes.Name SPECIFICATION_VENDOR = java.util.jar.Attributes.Name.SPECIFICATION_VENDOR;
    public static final java.util.jar.Attributes.Name IMPLEMENTATION_TITLE = java.util.jar.Attributes.Name.IMPLEMENTATION_TITLE;
    public static final java.util.jar.Attributes.Name IMPLEMENTATION_VERSION = java.util.jar.Attributes.Name.IMPLEMENTATION_VERSION;
    public static final java.util.jar.Attributes.Name IMPLEMENTATION_VENDOR = java.util.jar.Attributes.Name.IMPLEMENTATION_VENDOR;
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility COMPATIBLE = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("COMPATIBLE");
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility REQUIRE_SPECIFICATION_UPGRADE = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("REQUIRE_SPECIFICATION_UPGRADE");
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility REQUIRE_VENDOR_SWITCH = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("REQUIRE_VENDOR_SWITCH");
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility REQUIRE_IMPLEMENTATION_CHANGE = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("REQUIRE_IMPLEMENTATION_CHANGE");
    public static final org.apache.tools.ant.taskdefs.optional.extension.Compatibility INCOMPATIBLE = new org.apache.tools.ant.taskdefs.optional.extension.Compatibility("INCOMPATIBLE");

    public Specification(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        this(str, str2, str3, str4, str5, str6, null);
    }

    public Specification(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String[] strArr) {
        java.lang.String[] strArr2;
        this.a = str;
        this.c = str3;
        if (str2 != null) {
            try {
                this.b = new org.apache.tools.ant.util.DeweyDecimal(str2);
            } catch (java.lang.NumberFormatException e) {
                throw new java.lang.IllegalArgumentException("Bad specification version format '" + str2 + "' in '" + str + "'. (Reason: " + e + ")");
            }
        }
        this.d = str4;
        this.e = str6;
        this.f = str5;
        if (this.a == null) {
            throw new java.lang.NullPointerException("specificationTitle");
        }
        if (strArr != null) {
            strArr2 = new java.lang.String[strArr.length];
            java.lang.System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        } else {
            strArr2 = null;
        }
        this.g = strArr2;
    }

    public static org.apache.tools.ant.taskdefs.optional.extension.Specification a(java.lang.String str, java.util.jar.Attributes attributes) throws java.text.ParseException {
        java.lang.String b = b(attributes.getValue(SPECIFICATION_TITLE));
        if (b == null) {
            return null;
        }
        java.util.jar.Attributes.Name name = SPECIFICATION_VENDOR;
        java.lang.String b2 = b(attributes.getValue(name));
        if (b2 == null) {
            throw new java.text.ParseException("Missing " + name, 0);
        }
        java.util.jar.Attributes.Name name2 = SPECIFICATION_VERSION;
        java.lang.String b3 = b(attributes.getValue(name2));
        if (b3 == null) {
            throw new java.text.ParseException("Missing " + name2, 0);
        }
        java.util.jar.Attributes.Name name3 = IMPLEMENTATION_TITLE;
        java.lang.String b4 = b(attributes.getValue(name3));
        if (b4 == null) {
            throw new java.text.ParseException("Missing " + name3, 0);
        }
        java.util.jar.Attributes.Name name4 = IMPLEMENTATION_VERSION;
        java.lang.String b5 = b(attributes.getValue(name4));
        if (b5 == null) {
            throw new java.text.ParseException("Missing " + name4, 0);
        }
        java.util.jar.Attributes.Name name5 = IMPLEMENTATION_VENDOR;
        java.lang.String b6 = b(attributes.getValue(name5));
        if (b6 != null) {
            return new org.apache.tools.ant.taskdefs.optional.extension.Specification(b, b3, b2, b4, b5, b6, new java.lang.String[]{str});
        }
        throw new java.text.ParseException("Missing " + name5, 0);
    }

    public static java.lang.String b(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static boolean d(org.apache.tools.ant.taskdefs.optional.extension.Specification specification, org.apache.tools.ant.taskdefs.optional.extension.Specification specification2) {
        return specification.getSpecificationTitle().equals(specification2.getSpecificationTitle()) && specification.getSpecificationVersion().isEqual(specification2.getSpecificationVersion()) && specification.getSpecificationVendor().equals(specification2.getSpecificationVendor()) && specification.getImplementationTitle().equals(specification2.getImplementationTitle()) && specification.getImplementationVersion().equals(specification2.getImplementationVersion()) && specification.getImplementationVendor().equals(specification2.getImplementationVendor());
    }

    public static org.apache.tools.ant.taskdefs.optional.extension.Specification e(org.apache.tools.ant.taskdefs.optional.extension.Specification specification, java.util.ArrayList arrayList) {
        if (arrayList.size() == 0) {
            return specification;
        }
        arrayList.addAll(java.util.Arrays.asList(specification.getSections()));
        return new org.apache.tools.ant.taskdefs.optional.extension.Specification(specification.getSpecificationTitle(), specification.getSpecificationVersion().toString(), specification.getSpecificationVendor(), specification.getImplementationTitle(), specification.getImplementationVersion(), specification.getImplementationVendor(), (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
    }

    public static java.util.ArrayList f(java.util.ArrayList arrayList) {
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        while (arrayList.size() > 0) {
            org.apache.tools.ant.taskdefs.optional.extension.Specification specification = (org.apache.tools.ant.taskdefs.optional.extension.Specification) arrayList.remove(0);
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.taskdefs.optional.extension.Specification specification2 = (org.apache.tools.ant.taskdefs.optional.extension.Specification) it.next();
                if (d(specification, specification2)) {
                    java.lang.String[] sections = specification2.getSections();
                    if (sections != null) {
                        arrayList3.addAll(java.util.Arrays.asList(sections));
                    }
                    it.remove();
                }
            }
            arrayList2.add(e(specification, arrayList3));
            arrayList3.clear();
        }
        return arrayList2;
    }

    public static org.apache.tools.ant.taskdefs.optional.extension.Specification[] getSpecifications(java.util.jar.Manifest manifest) throws java.text.ParseException {
        if (manifest == null) {
            return new org.apache.tools.ant.taskdefs.optional.extension.Specification[0];
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Map<java.lang.String, java.util.jar.Attributes> entries = manifest.getEntries();
        for (java.lang.String str : entries.keySet()) {
            org.apache.tools.ant.taskdefs.optional.extension.Specification a = a(str, entries.get(str));
            if (a != null) {
                arrayList.add(a);
            }
        }
        java.util.ArrayList f = f(arrayList);
        return (org.apache.tools.ant.taskdefs.optional.extension.Specification[]) f.toArray(new org.apache.tools.ant.taskdefs.optional.extension.Specification[f.size()]);
    }

    public final boolean c(org.apache.tools.ant.util.DeweyDecimal deweyDecimal, org.apache.tools.ant.util.DeweyDecimal deweyDecimal2) {
        return deweyDecimal.isGreaterThanOrEqual(deweyDecimal2);
    }

    public org.apache.tools.ant.taskdefs.optional.extension.Compatibility getCompatibilityWith(org.apache.tools.ant.taskdefs.optional.extension.Specification specification) {
        if (!this.a.equals(specification.getSpecificationTitle())) {
            return INCOMPATIBLE;
        }
        org.apache.tools.ant.util.DeweyDecimal specificationVersion = specification.getSpecificationVersion();
        org.apache.tools.ant.util.DeweyDecimal deweyDecimal = this.b;
        if (deweyDecimal != null && (specificationVersion == null || !c(deweyDecimal, specificationVersion))) {
            return REQUIRE_SPECIFICATION_UPGRADE;
        }
        java.lang.String implementationVendor = specification.getImplementationVendor();
        java.lang.String str = this.e;
        if (str != null && (implementationVendor == null || !str.equals(implementationVendor))) {
            return REQUIRE_VENDOR_SWITCH;
        }
        java.lang.String implementationVersion = specification.getImplementationVersion();
        java.lang.String str2 = this.f;
        return (str2 == null || (implementationVersion != null && str2.equals(implementationVersion))) ? COMPATIBLE : REQUIRE_IMPLEMENTATION_CHANGE;
    }

    public java.lang.String getImplementationTitle() {
        return this.d;
    }

    public java.lang.String getImplementationVendor() {
        return this.e;
    }

    public java.lang.String getImplementationVersion() {
        return this.f;
    }

    public java.lang.String[] getSections() {
        java.lang.String[] strArr = this.g;
        if (strArr == null) {
            return null;
        }
        java.lang.String[] strArr2 = new java.lang.String[strArr.length];
        java.lang.System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    public java.lang.String getSpecificationTitle() {
        return this.a;
    }

    public java.lang.String getSpecificationVendor() {
        return this.c;
    }

    public org.apache.tools.ant.util.DeweyDecimal getSpecificationVersion() {
        return this.b;
    }

    public boolean isCompatibleWith(org.apache.tools.ant.taskdefs.optional.extension.Specification specification) {
        return COMPATIBLE == getCompatibilityWith(specification);
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(SPECIFICATION_TITLE.toString());
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
        if (this.d != null) {
            stringBuffer.append(IMPLEMENTATION_TITLE);
            stringBuffer.append(": ");
            stringBuffer.append(this.d);
            stringBuffer.append(str);
        }
        if (this.f != null) {
            stringBuffer.append(IMPLEMENTATION_VERSION);
            stringBuffer.append(": ");
            stringBuffer.append(this.f);
            stringBuffer.append(str);
        }
        if (this.e != null) {
            stringBuffer.append(IMPLEMENTATION_VENDOR);
            stringBuffer.append(": ");
            stringBuffer.append(this.e);
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
