//package help;
//
//import pages.AuthorizationPage;
//import pages.PageMain;
//import pages.ProfilePage;
//
//public class Step {
//
//    PageMain pageMain = new PageMain();
//
//    public void openMainPage(){
//        pageMain.open();
//    }
//
//    public void openAuthorizationForm(){
//        PageMain mainPage = new PageMain();
//        mainPage.openAuthorizationPage();
//    }
//
//    public void fillTheAuthorizationForm(String LOGIN, String PASSWORD){
//        AuthorizationPage authorizationPage = new AuthorizationPage();
//        authorizationPage.enterLogin(LOGIN);
//        authorizationPage.enterPassword(PASSWORD);
//
//    }
//
//    public void submitAuthorizationForm(){
//        AuthorizationPage authorizationPage = new AuthorizationPage();
//        authorizationPage.authorize();
//    }
//
//    public void openProfilePage() {
//        PageMain mainPage = new PageMain();
//        mainPage.openProfilePage();
//    }
//
//    public ProfilePage fillProfileFields() {
//        return new ProfilePage();
//    }
//}
