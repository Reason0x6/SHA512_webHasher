
import java.util.*;

public class CreateHash{

    public static void main(String [ ] args){
        /*
        ** Password Hashing
        */
        SecureHash hash = new SecureHash();
        String toHash = args[0];
        String hashed = hash.hasher(toHash);

        System.out.println(hashed);
       

        
        

    }

}