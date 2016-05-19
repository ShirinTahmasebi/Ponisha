package ir.ac.sbu.fakeponisha.utils;

public class GenderType {

    public enum Gender {

        NOTDEFINED,
        FEMALE,
        MALE
    }

    public static int getGender(Gender g) {
        switch (g) {
            case NOTDEFINED:
                return 0;
            case MALE:
                return 2;
            case FEMALE:
                return 1;
            default:
                return 0;
        }

    }

}
