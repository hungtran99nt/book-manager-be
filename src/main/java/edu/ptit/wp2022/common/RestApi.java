package edu.ptit.wp2022.common;

public interface RestApi {
    String BASE = "/api/v1";

    interface Auth {
        String SIGN_IN = "/signin";
        String SIGN_UP = "/signup";
        String SIGN_OUT = "/signout";
    }

    interface Book {
        String MAIN = BASE + "/books";
    }

    interface Common {
        String CREATE = "/create";
        String DETAIL = "/detail";
        String EDIT = "/edit";
        String DELETE = "/delete";
    }
}
