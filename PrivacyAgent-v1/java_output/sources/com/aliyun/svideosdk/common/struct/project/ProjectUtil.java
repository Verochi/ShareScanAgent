package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class ProjectUtil {
    private static final java.lang.String TAG = "Project";

    public static org.json.JSONObject getJson(java.io.File file) {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), "UTF-8"));
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (java.lang.Exception unused) {
                    if (bufferedReader == null) {
                        return null;
                    }
                    try {
                        bufferedReader.close();
                        return null;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(sb.toString());
            try {
                bufferedReader.close();
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
            }
            return jSONObject;
        } catch (java.lang.Exception unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static com.aliyun.svideosdk.common.struct.project.AliyunEditorProject newProject(java.io.File file) {
        java.lang.String name = file.getName();
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = new com.aliyun.svideosdk.common.struct.project.AliyunEditorProject();
        aliyunEditorProject.setProjectDir(file, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.getProjectFile(file));
        aliyunEditorProject.setTitle(name);
        aliyunEditorProject.setCreationTime(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.DATE_FORMAT.format(new java.util.Date()));
        aliyunEditorProject.setModifiedTime(aliyunEditorProject.getCreationTime());
        return aliyunEditorProject;
    }

    public static java.io.File newProjectDir(java.lang.String str) {
        java.io.File file = new java.io.File(str, java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static com.aliyun.svideosdk.common.struct.project.AliyunEditorProject read(java.lang.String str, com.aliyun.common.jasonparse.JSONSupport jSONSupport) {
        try {
            return (com.aliyun.svideosdk.common.struct.project.AliyunEditorProject) jSONSupport.readValue(str, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.class);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject(java.io.File file, com.aliyun.common.jasonparse.JSONSupport jSONSupport) {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject;
        try {
            org.json.JSONObject json = getJson(file);
            if (json != null && json.has("mLayoutVersion")) {
                aliyunEditorProject = com.aliyun.svideosdk.common.struct.project.ProjectVersionUtil.readProject(file, json);
            } else {
                if (json.optInt("Version", 1) > 1) {
                    return null;
                }
                aliyunEditorProject = (com.aliyun.svideosdk.common.struct.project.AliyunEditorProject) jSONSupport.readValue(file, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.class);
            }
            aliyunEditorProject.setProjectDir(file.getParentFile(), file);
            return aliyunEditorProject;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String writeProject(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.common.jasonparse.JSONSupport jSONSupport) {
        try {
            return jSONSupport.writeValue(aliyunEditorProject);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static boolean writeProject(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, java.io.File file, com.aliyun.common.jasonparse.JSONSupport jSONSupport) {
        return writeProject(aliyunEditorProject, file, jSONSupport, true);
    }

    public static boolean writeProject(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, java.io.File file, com.aliyun.common.jasonparse.JSONSupport jSONSupport, boolean z) {
        if (z) {
            try {
                aliyunEditorProject.setModifiedTime(com.aliyun.svideosdk.common.struct.project.AliyunEditorProject.DATE_FORMAT.format(new java.util.Date()));
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
        jSONSupport.writeValue(file, (java.io.File) aliyunEditorProject);
        return true;
    }
}
