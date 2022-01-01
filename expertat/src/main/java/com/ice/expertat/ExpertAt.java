package com.ice.expertat;

public class ExpertAt {
    private static boolean DEBUG = true;
    /**
     * 上一次调用的时间
     */
    private static long sLastCllTime;

    /**
     * 最近一次调用的方法
     */
    private static String sLastCallMethod;

    public static void setDebug(boolean isDebug){
        DEBUG = isDebug;
    }

    public static boolean isDebug(){
        return DEBUG;
    }

    /**
     * 是否是 短时间多次调用
     *
     * @param intervalMillis 时间间期（毫秒）
     * @return true:是，false:不是
     */
    static boolean isFastDoubleCall(String methodName,long intervalMillis) {
        long time = System.currentTimeMillis();
        long interval = time - sLastCllTime;
        if (0 < interval && interval < intervalMillis && methodName.equals(sLastCallMethod)) {
            return true;
        } else {
            sLastCllTime = time;
            sLastCallMethod = methodName;
            return false;
        }
    }
}
