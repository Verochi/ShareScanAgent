package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
class LibraryDisplayer {
    public void a(java.io.File file) throws org.apache.tools.ant.BuildException {
        b(file, org.apache.tools.ant.taskdefs.optional.extension.ExtensionUtil.e(file));
    }

    public void b(java.io.File file, java.util.jar.Manifest manifest) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.optional.extension.Extension[] available = org.apache.tools.ant.taskdefs.optional.extension.Extension.getAvailable(manifest);
        org.apache.tools.ant.taskdefs.optional.extension.Extension[] required = org.apache.tools.ant.taskdefs.optional.extension.Extension.getRequired(manifest);
        org.apache.tools.ant.taskdefs.optional.extension.Extension[] options = org.apache.tools.ant.taskdefs.optional.extension.Extension.getOptions(manifest);
        org.apache.tools.ant.taskdefs.optional.extension.Specification[] d = d(manifest);
        if (available.length == 0 && required.length == 0 && options.length == 0 && d.length == 0) {
            return;
        }
        java.lang.String str = "File: " + file;
        int length = str.length();
        e(length);
        java.lang.System.out.println(str);
        e(length);
        if (available.length != 0) {
            java.lang.System.out.println("Extensions Supported By Library:");
            for (org.apache.tools.ant.taskdefs.optional.extension.Extension extension : available) {
                java.lang.System.out.println(extension);
            }
        }
        if (required.length != 0) {
            java.lang.System.out.println("Extensions Required By Library:");
            for (org.apache.tools.ant.taskdefs.optional.extension.Extension extension2 : required) {
                java.lang.System.out.println(extension2);
            }
        }
        if (options.length != 0) {
            java.lang.System.out.println("Extensions that will be used by Library if present:");
            for (org.apache.tools.ant.taskdefs.optional.extension.Extension extension3 : options) {
                java.lang.System.out.println(extension3);
            }
        }
        if (d.length != 0) {
            java.lang.System.out.println("Specifications Supported By Library:");
            for (org.apache.tools.ant.taskdefs.optional.extension.Specification specification : d) {
                c(specification);
            }
        }
    }

    public final void c(org.apache.tools.ant.taskdefs.optional.extension.Specification specification) {
        java.lang.String[] sections = specification.getSections();
        if (sections != null) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("Sections: ");
            for (java.lang.String str : sections) {
                stringBuffer.append(" ");
                stringBuffer.append(str);
            }
            java.lang.System.out.println(stringBuffer);
        }
        java.lang.System.out.println(specification.toString());
    }

    public final org.apache.tools.ant.taskdefs.optional.extension.Specification[] d(java.util.jar.Manifest manifest) throws org.apache.tools.ant.BuildException {
        try {
            return org.apache.tools.ant.taskdefs.optional.extension.Specification.getSpecifications(manifest);
        } catch (java.text.ParseException e) {
            throw new org.apache.tools.ant.BuildException(e.getMessage(), e);
        }
    }

    public final void e(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            java.lang.System.out.print(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        java.lang.System.out.println();
    }
}
