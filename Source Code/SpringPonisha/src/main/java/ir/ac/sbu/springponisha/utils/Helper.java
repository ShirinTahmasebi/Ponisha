/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.springponisha.utils;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Shirin
 */
public class Helper {

    public static String getRequestString(HttpServletRequest request, String stringName) {
        try {
            return new String(request.getParameter(stringName).getBytes("8859_1"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static boolean validator(String word, String regex) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(word);
        return matcher.matches();
    }
}
