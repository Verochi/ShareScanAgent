package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class ParserSupports extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public static final java.lang.String ERROR_BOTH_ATTRIBUTES = "Property and feature attributes are exclusive";
    public static final java.lang.String ERROR_NO_ATTRIBUTES = "Neither feature or property are set";
    public static final java.lang.String ERROR_NO_VALUE = "A value is needed when testing for property support";
    public static final java.lang.String FEATURE = "feature";
    public static final java.lang.String NOT_RECOGNIZED = " not recognized: ";
    public static final java.lang.String NOT_SUPPORTED = " not supported: ";
    public static final java.lang.String PROPERTY = "property";
    public java.lang.String n;
    public java.lang.String t;
    public java.lang.String u;

    public final org.xml.sax.XMLReader a() {
        org.apache.tools.ant.util.JAXPUtils.getParser();
        return org.apache.tools.ant.util.JAXPUtils.getXMLReader();
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        java.lang.String str = this.n;
        if (str != null && this.t != null) {
            throw new org.apache.tools.ant.BuildException(ERROR_BOTH_ATTRIBUTES);
        }
        if (str == null && this.t == null) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_ATTRIBUTES);
        }
        if (str != null) {
            return evalFeature();
        }
        if (this.u != null) {
            return evalProperty();
        }
        throw new org.apache.tools.ant.BuildException(ERROR_NO_VALUE);
    }

    public boolean evalFeature() {
        org.xml.sax.XMLReader a = a();
        if (this.u == null) {
            this.u = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
        }
        try {
            a.setFeature(this.n, org.apache.tools.ant.Project.toBoolean(this.u));
            return true;
        } catch (org.xml.sax.SAXNotRecognizedException unused) {
            log("feature not recognized: " + this.n, 3);
            return false;
        } catch (org.xml.sax.SAXNotSupportedException unused2) {
            log("feature not supported: " + this.n, 3);
            return false;
        }
    }

    public boolean evalProperty() {
        try {
            a().setProperty(this.t, this.u);
            return true;
        } catch (org.xml.sax.SAXNotRecognizedException unused) {
            log("property not recognized: " + this.t, 3);
            return false;
        } catch (org.xml.sax.SAXNotSupportedException unused2) {
            log("property not supported: " + this.t, 3);
            return false;
        }
    }

    public void setFeature(java.lang.String str) {
        this.n = str;
    }

    public void setProperty(java.lang.String str) {
        this.t = str;
    }

    public void setValue(java.lang.String str) {
        this.u = str;
    }
}
