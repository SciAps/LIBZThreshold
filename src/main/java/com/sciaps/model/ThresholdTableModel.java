/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sciaps.model;

import com.sciaps.common.ThresholdObj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jchen
 */
public class ThresholdTableModel extends AbstractTableModel{
    
    private final List<ThresholdObj> mData;
    String[] columnNames_ = {"Base/Element", "Offset", "Factor", "Sigma", "Threshold"};


    public ThresholdTableModel() {
        mData = new ArrayList<ThresholdObj>();
    }

    @Override
    public int getRowCount() {
        return mData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames_.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames_[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return mData.get(rowIndex).getBaseAndElement();
            case 1:
                return mData.get(rowIndex).getOffset();
            case 2:
                return mData.get(rowIndex).getFactor();
            case 3:
                return mData.get(rowIndex).getSigma();
            case 4:
                return mData.get(rowIndex).getThreshold();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                mData.get(rowIndex).setBaseAndElement((String) aValue);
                break;
            case 1:
                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    mData.get(rowIndex).setOffset(newVal);
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid Offset Value: " + (String) aValue);
                }
                break;
            case 2:

                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    mData.get(rowIndex).setFactor(newVal);
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid Factor Value: " + (String) aValue);
                }
                break;
            case 3:
                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    mData.get(rowIndex).setSigma(newVal);
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid Sigma Value: " + (String) aValue);
                }
                break;
            case 4:
                try {
                    double newVal = Double.parseDouble(aValue.toString());
                    mData.get(rowIndex).setThreshold(newVal);
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid Threshold Value: " + (String) aValue);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
                return String.class;
            default:
                return Double.class;
        }
    }

    @Override
    public boolean isCellEditable(int RowIndex, int columnIndex) {
        return true;
    }

    public void addRow(ThresholdObj thresholdObj) {
        mData.add(thresholdObj);
        fireTableDataChanged();
    }

    public void removeRow(int rowIndex) {
        mData.remove(rowIndex);
        fireTableDataChanged();
    }

    public void removeRows(int[] rowIndex) {
        Arrays.sort(rowIndex);
        for (int i = rowIndex.length - 1; i >= 0; i--) {
            mData.remove(rowIndex[i]);
        }

        fireTableDataChanged();
    }

    public List<ThresholdObj> getData() {
        return mData;
    }
    
    private void showErrorDialog(final String msg) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, msg);
            }
        });
    }
}
