package com.dumiduh.jmeterrunner;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String prop = "/home/dumiduh/SOFTWARE/apache-jmeter-2.13/bin/jmeter.properties";
        String jhome= "/home/dumiduh/SOFTWARE/apache-jmeter-2.13";
        String jtlhome="/home/dumiduh/SOFTWARE/";
        String script="/home/dumiduh/WORK/testscript.jmx";
        JmeterRunner runner = new JmeterRunner(script,prop, jhome, jtlhome);
        runner.runJScript();
        runner.processResult();
    }
}
