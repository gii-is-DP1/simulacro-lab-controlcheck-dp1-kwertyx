package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    @Override
    public String print(ProductType object, Locale locale) {
        if(object != null) {
            return String.format(locale, "%s", object.getName());
        }
        return null;
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        if(text != null) {
            try {
                if(text!=null && text.length()<15) {
                    ProductType pt = new ProductType();
                    pt.setName(text);
                    return pt;
                } else {
                    throw new ParseException("Hola", 1);
                }
            } catch(ParseException e) {
                throw e;
            }
        }
        return null;
    }
    
}
