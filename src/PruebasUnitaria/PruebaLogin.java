package PruebasUnitaria;

import Modelo.LoginDao;

public class PruebaLogin {

    public static void main(String[] args) {
        
        LoginDao userLogin = new LoginDao();
        userLogin.ListarLogin();
        
    }

}
