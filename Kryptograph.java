import java.lang.Math;

public class Kryptograph
{
    String key;
    int f;

    public String caeser (String klar) {
        f = (int)(Math.random()*25);
        String geheim="";
        char zeichen;
        for (int i=0; i < klar.length(); i++) {
            zeichen = klar.charAt(i);
            int code = zeichen-65;
            //System.out.println(f);
            code += f;
            geheim += (char)((code%25)+65);
        }
        key = String.valueOf(f);
        return geheim;
    }
    
    public String vigenere (String klar) {
        key = "ABC";
        String geheim="";
        char zeichen;
        for (int i=0; i < klar.length(); i++) {
            zeichen = klar.charAt(i);
            int code = zeichen-65;
            //System.out.println(key.charAt(i%key.length()));
            code += (int) ((key.charAt(i%key.length()))-65);
            geheim += (char)((code%25)+65);
        }
        return geheim;
    }
    
    public String getFak () {
        return key;
    }
}
