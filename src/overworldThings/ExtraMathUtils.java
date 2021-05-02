package overworldThings;

public class ExtraMathUtils {
    public static boolean doRectsIntersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        boolean isx1In = x3 <= x1 && x1 <= x4; //Rect 1 left side
        boolean isx2In = x3 <= x2 && x2 <= x4; //Rect 1 right side
        boolean isx3In = x1 <= x3 && x3 <= x2; //Rect 2 left side
        boolean isx4In = x1 <= x4 && x4 <= x2; //Rect 2 right side

        boolean isy1In = y3 <= y1 && y1 <= y4; //Rect 1 bottom side
        boolean isy2In = y3 <= y2 && y2 <= y4; //Rect 1 top side
        boolean isy3In = y1 <= y3 && y3 <= y2; //Rect 2 bottom side
        boolean isy4In = y1 <= y4 && y4 <= y2; //Rect 2 top side

        boolean isR1BottomLeftIn = isx1In && isy1In;
        boolean isR1BottomRightIn = isx2In && isy1In;
        boolean isR1TopLeftIn = isx1In && isy2In;
        boolean isR1TopRightIn = isx2In && isy2In;

        boolean isR2BottomLeftIn = isx3In && isy3In;
        boolean isR2BottomRightIn = isx4In && isy3In;
        boolean isR2TopLeftIn = isx3In && isy4In;
        boolean isR2TopRightIn = isx4In && isy4In;


        //This basically checks weather a corner of the rectange is inside another rectangle
        return isR1BottomLeftIn || isR1BottomRightIn || isR1TopLeftIn || isR1TopRightIn || isR2BottomLeftIn || isR2BottomRightIn || isR2TopLeftIn || isR2TopRightIn;

    }
}
