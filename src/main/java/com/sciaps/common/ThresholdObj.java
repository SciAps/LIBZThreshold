/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.common;

/**
 *
 * @author jchen
 */
public class ThresholdObj {
    private String mBaseAndElement;
    private double mOffset;
    private double mFactor;
    private double mSigma;
    private double mThreshold;
    
    public ThresholdObj() {
        mBaseAndElement = "";
        mOffset = 0;
        mFactor = 0;
        mSigma = 0;
        mThreshold = 0;
    }
    
    public ThresholdObj(String baseAndElement, double offset, double factor, double sigma, double threshold) {
        mBaseAndElement = baseAndElement;
        mOffset = offset;
        mFactor = factor;
        mSigma = sigma;
        mThreshold = threshold;
    }
    
    public void setBaseAndElement(String baseAndElement) {
        mBaseAndElement = baseAndElement;
    }
    
    public String getBaseAndElement() {
        return mBaseAndElement;
    }
    
    public void setOffset(double offset) {
        mOffset = offset;
    }
    
    public double getOffset() {
        return mOffset;
    }
    
    public void setFactor(double factor) {
        mFactor = factor;
    }
    
    public double getFactor() {
        return mFactor;
    }
    
    public void setSigma(double sigma) {
        mSigma = sigma;
    }
    
    public double getSigma() {
        return mSigma;
    }
    
    public void setThreshold(double threshold) {
        mThreshold = threshold;
    }
    
    public double getThreshold() {
        return mThreshold;
    }
    
    public String[] toCSV() {
        String[] str = new String[5];
        str[0] = mBaseAndElement;
        str[1] = String.valueOf(mOffset);
        str[2] = String.valueOf(mFactor);
        str[3] = String.valueOf(mSigma);
        str[4] = String.valueOf(mThreshold);        
        return str;
    }
    
}
