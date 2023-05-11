package firstspring.firstApp.services;


import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    private String testData;
    private int testInt;
    @Override
    public String getTestData() {
        return "Some Test DATA " + this.testData;
    }

    @Override
    public int getTestDataInt() {
        return this.testInt;
    }

    @Override
    public void setTestData(String testData) {
        this.testData = testData;

    }

    @Override
    public void setDataInt(int dataInt) {
        this.testInt = dataInt;
    }

    @Override
    public boolean auth(String email, String password) {
        return false;
    }
}
