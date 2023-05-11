package firstspring.firstApp.services;

public interface TestService{

    String getTestData();
    int getTestDataInt();
    void setTestData(String testData);
    void setDataInt(int dataInt);

    boolean auth(String email, String password);
}
