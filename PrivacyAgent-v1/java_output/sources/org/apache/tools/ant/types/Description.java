package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Description extends org.apache.tools.ant.types.DataType {
    public static void b(org.apache.tools.ant.Project project, org.apache.tools.ant.Target target, java.lang.StringBuilder sb) {
        java.lang.String stringBuffer;
        if (target == null) {
            return;
        }
        for (org.apache.tools.ant.Task task : c(project, target, "description")) {
            if ((task instanceof org.apache.tools.ant.UnknownElement) && (stringBuffer = ((org.apache.tools.ant.UnknownElement) task).getWrapper().getText().toString()) != null) {
                sb.append(project.replaceProperties(stringBuffer));
            }
        }
    }

    public static java.util.List<org.apache.tools.ant.Task> c(org.apache.tools.ant.Project project, org.apache.tools.ant.Target target, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (org.apache.tools.ant.Task task : target.getTasks()) {
            if (str.equals(task.getTaskName())) {
                arrayList.add(task);
            }
        }
        return arrayList;
    }

    public static java.lang.String getDescription(org.apache.tools.ant.Project project) {
        java.util.List list = (java.util.List) project.getReference(org.apache.tools.ant.helper.ProjectHelper2.REFID_TARGETS);
        if (list == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            b(project, (org.apache.tools.ant.Target) it.next(), sb);
        }
        return sb.toString();
    }

    public void addText(java.lang.String str) {
        if (((org.apache.tools.ant.ProjectHelper) getProject().getReference("ant.projectHelper")) instanceof org.apache.tools.ant.helper.ProjectHelperImpl) {
            java.lang.String description = getProject().getDescription();
            if (description == null) {
                getProject().setDescription(str);
                return;
            }
            getProject().setDescription(description + str);
        }
    }
}
