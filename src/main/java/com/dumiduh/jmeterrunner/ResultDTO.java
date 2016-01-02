/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumiduh.jmeterrunner;

/**
 *
 * @author dumiduh
 */
public class ResultDTO {
private String samplerName;
private String responseCode;
private boolean result;

    /**
     * @return the samplerName
     */
    public String getSamplerName() {
        return samplerName;
    }

    /**
     * @param samplerName the samplerName to set
     */
    public void setSamplerName(String samplerName) {
        this.samplerName = samplerName;
    }

    /**
     * @return the responseCode
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return the result
     */
    public boolean isResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(boolean result) {
        this.result = result;
    }
}
