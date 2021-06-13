package ru.main;

import ru.graphics.TpReadableColor;

public class Constants {
	public static final int CELL_SIZE = 24;
    public static final int COUNT_CELLS_X = 10;
    public static final int COUNT_CELLS_Y = 2 * COUNT_CELLS_X;

  
    public static final int OFFSET_TOP = 3;
    public static final int SCREEN_WIDTH = COUNT_CELLS_X *CELL_SIZE;
    public static final int SCREEN_HEIGHT = COUNT_CELLS_Y *CELL_SIZE;
    public static final String SCREEN_NAME = "Tproger's Tetris";

    public static final int BOOST_MULTIPLIER = 5;

    
    public static final int MOVEDOWNS_PER_SECOND = 3;

   
    public static final int FPS = 60;

    public static final int FRAMES_PER_MOVE = FPS / MOVEDOWNS_PER_SECOND;
    public static final TpReadableColor EMPTINESS_COLOR = TpReadableColor.BLACK;

    public static final int BLOCKS_INITIAL_LEVEL = COUNT_CELLS_Y / 3;

    public static final int MISSNG_BLOCKS_IN_INITIAL_LINE_MIN = COUNT_CELLS_X/3;
    public static final int MISSNG_BLOCKS_IN_INITIAL_LINE_MAX = COUNT_CELLS_X/2;

    public static final int MAX_FIGURE_WIDTH = 4;
}

