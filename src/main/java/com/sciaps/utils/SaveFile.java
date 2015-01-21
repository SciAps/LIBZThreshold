/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author jchen
 */
public class SaveFile {

    public void doSave(File file, String[] data) throws IOException {
        BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        try {
            for (String str : data) {
                bout.append(str);
                bout.newLine();
            }
        } finally {
            bout.close();
        }
    }
}
