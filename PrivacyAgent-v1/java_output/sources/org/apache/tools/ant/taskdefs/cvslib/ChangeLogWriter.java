package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
public class ChangeLogWriter {
    public static final org.apache.tools.ant.util.DOMElementWriter c = new org.apache.tools.ant.util.DOMElementWriter();
    public final java.text.SimpleDateFormat a;
    public java.text.SimpleDateFormat b;

    public ChangeLogWriter() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        this.a = simpleDateFormat;
        this.b = new java.text.SimpleDateFormat("HH:mm");
        java.util.TimeZone timeZone = java.util.TimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        this.b.setTimeZone(timeZone);
    }

    public final void a(org.w3c.dom.Document document, java.io.PrintWriter printWriter, org.apache.tools.ant.taskdefs.cvslib.CVSEntry cVSEntry) throws java.io.IOException {
        org.w3c.dom.Element createElement = document.createElement(com.anythink.expressad.foundation.g.a.aj);
        org.apache.tools.ant.util.DOMUtils.appendTextElement(createElement, "date", this.a.format(cVSEntry.getDate()));
        org.apache.tools.ant.util.DOMUtils.appendTextElement(createElement, "time", this.b.format(cVSEntry.getDate()));
        org.apache.tools.ant.util.DOMUtils.appendCDATAElement(createElement, "author", cVSEntry.getAuthor());
        java.util.Enumeration elements = cVSEntry.getFiles().elements();
        while (elements.hasMoreElements()) {
            org.apache.tools.ant.taskdefs.cvslib.RCSFile rCSFile = (org.apache.tools.ant.taskdefs.cvslib.RCSFile) elements.nextElement();
            org.w3c.dom.Element createChildElement = org.apache.tools.ant.util.DOMUtils.createChildElement(createElement, "file");
            org.apache.tools.ant.util.DOMUtils.appendCDATAElement(createChildElement, "name", rCSFile.a());
            org.apache.tools.ant.util.DOMUtils.appendTextElement(createChildElement, "revision", rCSFile.c());
            java.lang.String b = rCSFile.b();
            if (b != null) {
                org.apache.tools.ant.util.DOMUtils.appendTextElement(createChildElement, "prevrevision", b);
            }
        }
        org.apache.tools.ant.util.DOMUtils.appendCDATAElement(createElement, "msg", cVSEntry.getComment());
        c.write(createElement, printWriter, 1, "\t");
    }

    public void printChangeLog(java.io.PrintWriter printWriter, org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] cVSEntryArr) {
        try {
            printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            org.w3c.dom.Document newDocument = org.apache.tools.ant.util.DOMUtils.newDocument();
            org.w3c.dom.Element createElement = newDocument.createElement("changelog");
            c.openElement(createElement, printWriter, 0, "\t");
            printWriter.println();
            for (org.apache.tools.ant.taskdefs.cvslib.CVSEntry cVSEntry : cVSEntryArr) {
                a(newDocument, printWriter, cVSEntry);
            }
            c.closeElement(createElement, printWriter, 0, "\t", true);
            printWriter.flush();
            printWriter.close();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }
}
