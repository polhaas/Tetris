package ru.main;


public enum RotationMode {
	  
    NORMAL(0),

    FLIP_CCW(1),

    INVERT(2),

    FLIP_CW(3);

    private int number;
    RotationMode(int number){
        this.number = number;
    }
    private static RotationMode[] rotationByNumber = {NORMAL, FLIP_CCW, INVERT, FLIP_CW};

    public static RotationMode getNextRotationFrom(RotationMode perviousRotation) {
        int newRotationIndex = (perviousRotation.number + 1) % rotationByNumber.length;
        return rotationByNumber[newRotationIndex];
    }
}
