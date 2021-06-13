package ru.keyboard;

import ru.main.ShiftDirection;


public interface KeyboardHandleModule {

    void update();

    boolean wasEscPressed();

    ShiftDirection getShiftDirection();

    boolean wasRotateRequested();

    boolean wasBoostRequested();
}
