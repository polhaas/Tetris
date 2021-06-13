package ru.graphics;

import ru.main.GameField;

public interface GraphicsModule {

    void draw(GameField field);

    boolean isCloseRequested();

    void destroy();

    void sync(int fps);
}