package futuristicbio.biometrics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User-PC
 */
public class ThreadLocalStorage {
    
    private static ThreadLocal idHolder = new ThreadLocal();

    public static void setUserContext(UserContext userContext) {
        idHolder.set(userContext);
    }

    public static Object getUserContext() {
        return idHolder.get();
    }

    public static void clearUserContext(){
    idHolder.remove();
    }
    
}
