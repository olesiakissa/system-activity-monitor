package system;

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
     * The first 4 lines in tasklist include system processes that are
     * not informative for this application.
     */
    public final static int WINDOWS_PROCESS_UNNECESSARY_PROCESS_LINE_SIZE = 4;

    /** CMD command for printing the list in <tt>csv</tt> format.*/
    public final static String WINDOWS_TASKLIST = "tasklist /fo csv /nh";

    //endregion




}
