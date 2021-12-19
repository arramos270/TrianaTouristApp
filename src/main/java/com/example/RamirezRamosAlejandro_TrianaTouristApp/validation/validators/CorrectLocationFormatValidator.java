package com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.validators;

import com.example.RamirezRamosAlejandro_TrianaTouristApp.repos.PoiRepository;
import com.example.RamirezRamosAlejandro_TrianaTouristApp.validation.anotations.CorrectLocationFormat;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectLocationFormatValidator implements ConstraintValidator<CorrectLocationFormat, String> {

    @Autowired
    private PoiRepository repositorio;

    @Override
    public void initialize(CorrectLocationFormat constraintAnnotation) {
    }

    //De -90 a 90 lat
    //De 180 a -180 a long
    @Override
    public boolean isValid(String location, ConstraintValidatorContext constraintValidatorContext) {
        boolean latCorrecta = false;
        boolean longCorrecta = false;

        String[] latlong = location.split(",");
        String lat = latlong[1];
        String longi = latlong[2];

        String regex_latitud = "^(\\+|-)?((\\d((\\.)|\\.\\d{1,6})?)|(0*?[0-8]\\d((\\.)|\\.\\d{1,6})?)|(0*?90((\\.)|\\.0{1,6})?))$";
        String regex_longitud = "^(\\+|-)?((\\d((\\.)|\\.\\d{1,6})?)|(0*?\\d\\d((\\.)|\\.\\d{1,6})?)|(0*?1[0-7]\\d((\\.)|\\.\\d{1,6})?)|(0*?180((\\.)|\\.0{1,6})?))$";
        Pattern patronLatitud = Pattern.compile(regex_latitud, Pattern.CASE_INSENSITIVE);
        Pattern patronLongitud = Pattern.compile(regex_longitud, Pattern.CASE_INSENSITIVE);

        Matcher matcherLat = patronLatitud.matcher(lat);
        Matcher matcherLong = patronLongitud.matcher(longi);
        if (matcherLat.find()) {
            //System.out.println("Latitud Válida: " + matcherLat.group());
            latCorrecta=true;
        }
        if (matcherLong.find()) {
            //System.out.println("Longitud Válida " + matcherLong.group());
            longCorrecta=true;
        }

        if(latCorrecta && longCorrecta){
            return true;
        }

        return false;
    }
}
