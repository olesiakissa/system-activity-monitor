package app;

/**
 * Collected constants for usage in application.
 */
public final class Constants {

    //region System constants

    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");
    public static final String OS_ARCHITECTURE = System.getProperty("os.arch");
    public static final String USER_NAME = System.getProperty("user.name");

    public static final String NEW_LINE = System.getProperty("line.separator");

    //endregion

    //region WINDOWS monitor

    /**
     * The first 4 lines in tasklist include app processes that are
     * not informative for this application.
     */
    public final static int WINDOWS_PROCESS_UNNECESSARY_PROCESS_LINE_SIZE = 4;

    /** CMD command for printing the list in <tt>csv</tt> format.*/
    public final static String WINDOWS_TASKLIST = "tasklist /fo csv /nh";

    //endregion

    //region TIME units

    public final static long SECOND = 1000L;  // 1000ms
    public final static long MINUTE = 60000L; // 1000*60ms
    public final static long HOUR = 3600000L; // 1000*60*60 ms

    public final static long WORKING_DAY_DURATION = 28800000L; //1000*60*60*8
    //endregion

    //region NETWORK
    
    public final static int ANY_FREE_PORT = 0;
    public final static int DEFAULT_PORT = 8080;
    public final static String LOCALHOST = "localhost";

    //endregion
}
