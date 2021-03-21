package designpatterns.chainresponsability.middlewares;

public class CheckPermission extends Middleware{
    @Override
    public boolean check(String email, String password) {
        if("master@gmail.com".equals(email)){
            System.out.println("ADM");
            return true;
        }
        System.out.println("Bem vindo");
        return checkNext(email, password);
    }
}
