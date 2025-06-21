package org.apache.tools.ant.dispatch;

/* loaded from: classes25.dex */
public class DispatchUtils {
    public static final void execute(java.lang.Object obj) throws org.apache.tools.ant.BuildException {
        java.lang.Object realThing;
        try {
            try {
                java.lang.String str = null;
                org.apache.tools.ant.dispatch.Dispatchable dispatchable = obj instanceof org.apache.tools.ant.dispatch.Dispatchable ? (org.apache.tools.ant.dispatch.Dispatchable) obj : ((obj instanceof org.apache.tools.ant.UnknownElement) && (realThing = ((org.apache.tools.ant.UnknownElement) obj).getRealThing()) != null && (realThing instanceof org.apache.tools.ant.dispatch.Dispatchable) && (realThing instanceof org.apache.tools.ant.Task)) ? (org.apache.tools.ant.dispatch.Dispatchable) realThing : null;
                if (dispatchable == null) {
                    java.lang.reflect.Method method = obj.getClass().getMethod("execute", new java.lang.Class[0]);
                    if (method != null) {
                        method.invoke(obj, null);
                        if (obj instanceof org.apache.tools.ant.UnknownElement) {
                            ((org.apache.tools.ant.UnknownElement) obj).setRealThing(null);
                            return;
                        }
                        return;
                    }
                    throw new org.apache.tools.ant.BuildException("No public execute() in " + obj.getClass());
                }
                try {
                    java.lang.String actionParameterName = dispatchable.getActionParameterName();
                    if (actionParameterName == null || actionParameterName.trim().length() <= 0) {
                        throw new org.apache.tools.ant.BuildException("Action Parameter Name must not be empty for Dispatchable Task.");
                    }
                    java.lang.String str2 = com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET + actionParameterName.trim().substring(0, 1).toUpperCase();
                    try {
                        if (actionParameterName.length() > 1) {
                            str2 = str2 + actionParameterName.substring(1);
                        }
                        java.lang.reflect.Method method2 = dispatchable.getClass().getMethod(str2, new java.lang.Class[0]);
                        if (method2 != null) {
                            java.lang.Object invoke = method2.invoke(dispatchable, null);
                            if (invoke == null) {
                                throw new org.apache.tools.ant.BuildException("Dispatchable Task attribute '" + actionParameterName.trim() + "' not set or value is empty.");
                            }
                            java.lang.String obj2 = invoke.toString();
                            if (obj2.trim().length() <= 0) {
                                throw new org.apache.tools.ant.BuildException("Dispatchable Task attribute '" + actionParameterName.trim() + "' not set or value is empty.");
                            }
                            java.lang.String trim = obj2.trim();
                            java.lang.reflect.Method method3 = dispatchable.getClass().getMethod(trim, new java.lang.Class[0]);
                            if (method3 != null) {
                                method3.invoke(dispatchable, null);
                                if (obj instanceof org.apache.tools.ant.UnknownElement) {
                                    ((org.apache.tools.ant.UnknownElement) obj).setRealThing(null);
                                    return;
                                }
                                return;
                            }
                            throw new org.apache.tools.ant.BuildException("No public " + trim + "() in " + dispatchable.getClass());
                        }
                    } catch (java.lang.NoSuchMethodException unused) {
                        str = str2;
                        throw new org.apache.tools.ant.BuildException("No public " + str + "() in " + obj.getClass());
                    }
                } catch (java.lang.NoSuchMethodException unused2) {
                }
            } catch (java.lang.NoSuchMethodException e) {
                throw new org.apache.tools.ant.BuildException(e);
            }
        } catch (java.lang.IllegalAccessException e2) {
            throw new org.apache.tools.ant.BuildException(e2);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            java.lang.Throwable targetException = e3.getTargetException();
            if (!(targetException instanceof org.apache.tools.ant.BuildException)) {
                throw new org.apache.tools.ant.BuildException(targetException);
            }
            throw ((org.apache.tools.ant.BuildException) targetException);
        }
    }
}
