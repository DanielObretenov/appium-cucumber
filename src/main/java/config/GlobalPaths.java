package config;

public class GlobalPaths {
    public static final String LOCAL_NEXUS_30 = "\\src\\main\\java\\browserConfigs\\local_android_app_nexus30";
    private static final String BROWSER_CONFIG_PATH = "src\\main\\java\\browserConfigs\\%s";

    public static String getPropertyPath(String browserConfigProperty){
        return String.format(BROWSER_CONFIG_PATH, browserConfigProperty);
    }
}


