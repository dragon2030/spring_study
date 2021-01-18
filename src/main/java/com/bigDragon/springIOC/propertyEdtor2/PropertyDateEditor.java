package com.bigDragon.springIOC.propertyEdtor2;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期编辑器
 * @author bigDragon
 * @create 2021-01-18 16:36
 */

public class PropertyDateEditor extends PropertyEditorSupport {


    private String dataPattern;



    /**
     * Parse the value from the given text, using the SimpleDateFormat
     */
    @Override
    public void setAsText(String text) {
        System.out.println("------UtilDatePropertyEditor.setAsText()------" + text);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            //SimpleDateFormat sdf = new SimpleDateFormat(dataPattern);
            Date date = new Date();
            date = sdf.parse(text);
            this.setValue(date);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(text);
        }
    }

    // 只要有set方法就可以注入进来
    public void setDataPattern(String pattern) {
        this.dataPattern = pattern;
    }
}
