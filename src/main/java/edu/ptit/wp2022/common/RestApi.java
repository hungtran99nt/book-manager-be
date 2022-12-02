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

    interface File {
        String MAIN = BASE + "/file";
        String UPLOAD = "/upload";
        String MULTI_UPLOAD = "/upload/all";
        String DOWNLOAD = "/download";
    }

    interface Common {
        String CREATE = "/create";
        String DETAIL = "/detail";
        String EDIT = "/edit";
        String DELETE = "/delete";
    }
}
