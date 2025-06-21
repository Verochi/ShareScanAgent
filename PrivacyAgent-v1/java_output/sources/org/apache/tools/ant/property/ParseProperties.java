package org.apache.tools.ant.property;

/* loaded from: classes25.dex */
public class ParseProperties implements org.apache.tools.ant.property.ParseNextProperty {
    public final org.apache.tools.ant.Project a;
    public final org.apache.tools.ant.property.GetProperty b;
    public final java.util.Collection<org.apache.tools.ant.property.PropertyExpander> c;

    public ParseProperties(org.apache.tools.ant.Project project, java.util.Collection<org.apache.tools.ant.property.PropertyExpander> collection, org.apache.tools.ant.property.GetProperty getProperty) {
        this.a = project;
        this.c = collection;
        this.b = getProperty;
    }

    public final java.lang.Object a(java.lang.String str) {
        return this.b.getProperty(str);
    }

    public final java.lang.String b(java.lang.String str, java.text.ParsePosition parsePosition) {
        java.util.Iterator<org.apache.tools.ant.property.PropertyExpander> it = this.c.iterator();
        while (it.hasNext()) {
            java.lang.String parsePropertyName = it.next().parsePropertyName(str, parsePosition, this);
            if (parsePropertyName != null) {
                return parsePropertyName;
            }
        }
        return null;
    }

    public boolean containsProperties(java.lang.String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
        while (parsePosition.getIndex() < length) {
            if (b(str, parsePosition) != null) {
                return true;
            }
            parsePosition.setIndex(parsePosition.getIndex() + 1);
        }
        return false;
    }

    @Override // org.apache.tools.ant.property.ParseNextProperty
    public org.apache.tools.ant.Project getProject() {
        return this.a;
    }

    @Override // org.apache.tools.ant.property.ParseNextProperty
    public java.lang.Object parseNextProperty(java.lang.String str, java.text.ParsePosition parsePosition) {
        java.lang.String b;
        int index = parsePosition.getIndex();
        if (index > str.length() || (b = b(str, parsePosition)) == null) {
            return null;
        }
        java.lang.Object a = a(b);
        if (a != null) {
            return a;
        }
        org.apache.tools.ant.Project project = this.a;
        if (project != null) {
            project.log("Property \"" + b + "\" has not been set", 3);
        }
        return str.substring(index, parsePosition.getIndex());
    }

    public java.lang.Object parseProperties(java.lang.String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        int length = str.length();
        java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
        java.lang.Object parseNextProperty = parseNextProperty(str, parsePosition);
        if (parseNextProperty != null && parsePosition.getIndex() >= length) {
            return parseNextProperty;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(length * 2);
        if (parseNextProperty == null) {
            stringBuffer.append(str.charAt(parsePosition.getIndex()));
            parsePosition.setIndex(parsePosition.getIndex() + 1);
        } else {
            stringBuffer.append(parseNextProperty);
        }
        while (parsePosition.getIndex() < length) {
            java.lang.Object parseNextProperty2 = parseNextProperty(str, parsePosition);
            if (parseNextProperty2 == null) {
                stringBuffer.append(str.charAt(parsePosition.getIndex()));
                parsePosition.setIndex(parsePosition.getIndex() + 1);
            } else {
                stringBuffer.append(parseNextProperty2);
            }
        }
        return stringBuffer.toString();
    }
}
