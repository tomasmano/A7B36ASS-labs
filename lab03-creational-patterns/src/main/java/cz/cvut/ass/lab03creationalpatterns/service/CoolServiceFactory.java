package cz.cvut.ass.lab03creationalpatterns.service;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class CoolServiceFactory {

    private CoolServiceFactory() {
    }
    
    public static CoolService getTeacherService(){
        return TeacherCoolService.INSTANCE;
    }
    
    public static CoolService getStudentService(){
        return StudentCoolService.INSTANCE;
    }
}
