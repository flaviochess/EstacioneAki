package br.usp.sistemasdeinformacao.estacioneaki.sistema.converter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author colored <http://www.guj.com.br/user/profile/25204.java>
 * @adaptation flavio
 */
@FacesConverter("Moeda")
public class MoedaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.trim().equals("")) {
            return 0.0D;
        }

        Boolean matcher = Pattern.matches("[0-9]+([.,][0-9]{2}+)?", value);
        if (matcher) {
            value = value.replace(",", ".");
            return new Double(value);
        }

        throw new ConverterException();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        
        if (object == null || object.toString().trim().equals("")) {
            return "0.00";
        } else {
            NumberFormat nF = NumberFormat.getInstance(new Locale("pt", "BR"));
            nF.setMaximumFractionDigits(2);
            return nF.format(Double.valueOf(object.toString()));
        }
    }

}
