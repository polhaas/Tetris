package ru.main;

import ru.graphics.GraphicsModule;
import ru.graphics.lwjglmodule.LwjglGraphicsModule;
import ru.keyboard.KeyboardHandleModule;
import ru.keyboard.lwjglmodule.LwjglKeyboardHandleModule;

import static ru.main.Constants.BOOST_MULTIPLIER;
import static ru.main.Constants.FPS;
import static ru.main.Constants.FRAMES_PER_MOVE;


public class Main {

    private static boolean endOfGame;
    private static GraphicsModule graphicsModule;
    private static KeyboardHandleModule keyboardModule;
    private static GameField gameField; 
    private static ShiftDirection shiftDirection;
    private static boolean isRotateRequested;
    private static boolean isBoostRequested;
    private static int loopNumber;

   
    public static void main(String[] args) {
        initFields();

        while(!endOfGame){
            input();
            logic();

            graphicsModule.draw(gameField);
            graphicsModule.sync(FPS);
        }

        graphicsModule.destroy();
    }

    private static void initFields() {
        loopNumber = 0;
        endOfGame = false;
        shiftDirection = ShiftDirection.AWAITING;
        isRotateRequested = false;
        graphicsModule = new LwjglGraphicsModule();
        keyboardModule = new LwjglKeyboardHandleModule();
        gameField = new GameField();
    }

    
    private static void input(){

        keyboardModule.update();

        shiftDirection = keyboardModule.getShiftDirection();

        isRotateRequested = keyboardModule.wasRotateRequested();

        isBoostRequested = keyboardModule.wasBoostRequested();

        endOfGame = endOfGame || keyboardModule.wasEscPressed() || graphicsModule.isCloseRequested();
    }

    
    private static void logic(){
       if(shiftDirection != ShiftDirection.AWAITING){ 

          
           gameField.tryShiftFigure(shiftDirection);

           shiftDirection = ShiftDirection.AWAITING;
       }

       if(isRotateRequested){ 
           gameField.tryRotateFigure();
           isRotateRequested = false;
       }

     
       if( (loopNumber % (FRAMES_PER_MOVE / (isBoostRequested ? BOOST_MULTIPLIER : 1)) ) == 0) gameField.letFallDown();

       loopNumber = (loopNumber+1)% (FRAMES_PER_MOVE);

       endOfGame = endOfGame || gameField.isOverfilled();
    }

}

