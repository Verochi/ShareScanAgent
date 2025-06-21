package org.apache.tools.ant.property;

/* loaded from: classes25.dex */
public class ResolvePropertyMap implements org.apache.tools.ant.property.GetProperty {
    public final org.apache.tools.ant.property.ParseProperties b;
    public final org.apache.tools.ant.property.GetProperty c;
    public java.util.Map<java.lang.String, java.lang.Object> d;
    public java.lang.String e;
    public final java.util.Set<java.lang.String> a = new java.util.HashSet();
    public boolean f = false;
    public boolean g = true;

    public ResolvePropertyMap(org.apache.tools.ant.Project project, org.apache.tools.ant.property.GetProperty getProperty, java.util.Collection<org.apache.tools.ant.property.PropertyExpander> collection) {
        this.c = getProperty;
        this.b = new org.apache.tools.ant.property.ParseProperties(project, collection, this);
    }

    @Override // org.apache.tools.ant.property.GetProperty
    public java.lang.Object getProperty(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        if (this.a.contains(str)) {
            throw new org.apache.tools.ant.BuildException("Property " + str + " was circularly defined.");
        }
        try {
            if (this.e == null || !(this.g || this.f)) {
                str2 = str;
            } else {
                str2 = this.e + str;
            }
            java.lang.Object property = this.c.getProperty(str2);
            if (property == null) {
                this.a.add(str);
                if (this.e == null || this.g || this.f) {
                    str3 = str;
                } else {
                    str3 = this.e + str;
                }
                this.g = false;
                property = this.b.parseProperties((java.lang.String) this.d.get(str3));
            }
            return property;
        } finally {
            this.a.remove(str);
        }
    }

    public void resolveAllProperties(java.util.Map<java.lang.String, java.lang.Object> map) {
        resolveAllProperties(map, null, false);
    }

    public void resolveAllProperties(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        resolveAllProperties(map, null, false);
    }

    public void resolveAllProperties(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, boolean z) {
        this.d = map;
        this.e = str;
        this.f = z;
        for (java.lang.String str2 : map.keySet()) {
            this.g = true;
            java.lang.Object property = getProperty(str2);
            map.put(str2, property == null ? "" : property.toString());
        }
    }
}
