package ge.unknown.utils;

import ge.unknown.entities.User;
import ge.unknown.security.SpringSecurityUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneralUtil {

    public static String generateString(int length) {
        if (length < 5) length = 5;
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = chars.charAt(rng.nextInt(chars.length()));
        }
        return String.valueOf(text);
    }

    public static String encodeMD5(String text) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(text.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {

        }
        return null;
    }

    public static int getDaysDifference(long t1, long t2) {
        if (t1 == t2) {
            return 0;
        }
        return (int) ((t2 - t1) / (1000 * 60 * 60 * 24));
    }

    public static void reloadUserData(User user){
        if(user != null){
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            grantedAuthorities.addAll(user.getRole().getPermissions().stream().map(
                    permission -> new SimpleGrantedAuthority(permission.getName())
            ).collect(Collectors.toList()));

            // Load User Role
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

            SpringSecurityUser securityUser = new SpringSecurityUser(user, grantedAuthorities);
            Authentication authentication = new UsernamePasswordAuthenticationToken(securityUser, securityUser.getPassword(), grantedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }


    public static RequestResponse RequestSuccess(){
        return new RequestResponse(true);
    }

    public static RequestResponse RequestSuccess(String message){
        return new RequestResponse(true, message);
    }

    public static RequestResponse RequestSuccess(String message, Integer code){
        return new RequestResponse(true, message, code);
    }

    public static RequestResponse RequestError(){
        return new RequestResponse(false);
    }

    public static RequestResponse RequestError(String message){
        return new RequestResponse(false, message);
    }

    public static RequestResponse RequestError(String message, Integer code){
        return new RequestResponse(false, message, code);
    }
}
