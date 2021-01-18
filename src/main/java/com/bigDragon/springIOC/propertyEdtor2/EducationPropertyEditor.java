package com.bigDragon.springIOC.propertyEdtor2;

import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;
/**
 * 实体类属性编辑器
 * @author bigDragon
 * @create 2021-01-18 16:39
 */
public class EducationPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        if (text == null || !StringUtils.hasText(text)) {
            throw new IllegalArgumentException("就读住址不能为空！");
        } else {
            String[] StrAddressArr = StringUtils.tokenizeToStringArray(text, ",");
            Education add = new Education();
            add.setCountry(StrAddressArr[0]);
            add.setDirectory(StrAddressArr[1]);
            setValue(add);
        }
    }

    public String getAsText() {
        Education add = (Education) getValue();
        return "" + add;
    }
}