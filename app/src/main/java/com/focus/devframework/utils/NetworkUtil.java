package com.focus.devframework.utils;

/**
 * Created by focus on 16/8/16.
 */
public class NetworkUtil {

    public static final String protocol = "http://";
    public static final String airPort = ":80";
    public static final String groundPort = ":80";
    public static final String airSocketPort = ":8081";
    public static final String groundSocketPort = ":8081";
    public static final String picPort = ":8082";
    public static final String airPath = "/rest";
    public static final String groundPath = "/gps";
    public static String airIp = "api.feitian-tech-system.com";
    public static String groundIp = "api.feitian-tech-system.com";
    public static String webClientHost = "/PortalApp";
    public static String airHost = NetworkUtil.airIp+NetworkUtil.airPort+NetworkUtil.airPath;
    public static String airSocketHost = NetworkUtil.airIp+NetworkUtil.airSocketPort;
    public static String groundHost = NetworkUtil.groundIp+NetworkUtil.groundPort+NetworkUtil.groundPath;
    public static String groundSocketHost = NetworkUtil.groundIp+NetworkUtil.groundSocketPort;

}
