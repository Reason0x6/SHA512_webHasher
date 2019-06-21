package sys;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureHash
{
    byte[] salt;
    

    public SecureHash(){
        salt = getSalt();
    }

    public String hasher(String passwordToHash){
        String generatedPassword = null;
        try{
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (Exception e){}
       

           try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(generatedPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch (Exception f){}
        
        
        return generatedPassword;
    
    }
    private static byte[] getSalt()
    {
        SecureRandom sr = null;
        try{  sr  = SecureRandom.getInstance("SHA1PRNG");
        }catch(Exception k){}
        byte[] salt = new byte[16];
       // sr.nextBytes(salt);
        return salt;
    }
}   