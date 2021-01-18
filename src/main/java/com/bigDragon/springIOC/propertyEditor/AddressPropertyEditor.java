package com.bigDragon.springIOC.propertyEditor;

import org.springframework.util.Assert;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * 属性编辑器
 * @author bigDragon
 * @create 2021-01-13 19:18
 */
public class AddressPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        try {
            //Assert.notNull(text);
            String[] adds = text.split("-");

            Address address = new Address();
            address.setProvince(adds[0]);
            address.setCity(adds[1]);
            address.setDistrict(adds[2]);
            setValue(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}