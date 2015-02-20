/* Put your Pixel class here */
/**
 * This class represents a Pixel object.
 * @author Michelle Chiu
 * @version 13.31
 */
public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int alpha;


    /**
    * Creates a Pixel.
    * @param red int value
    * @param green int value
    * @param blue int value
    * @param alpha int value
    */
    public Pixel(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    /**
    * Creates the Red int Value from Pixel.
    * @return red int value
    */
    public int getRed() {
        return red;
    }

    /**
    * Returns the Green int Value from Pixel.
    * @return green int value
    */
    public int getGreen() {
        return green;
    }

    /**
    * Returns the Blue int Value from Pixel.
    * @return blue int value
    */
    public int getBlue() {
        return blue;
    }

    /**
    * Returns the Alpha int Value from Pixel.
    * @return alpha int value
    */
    public int getAlpha() {
        return alpha;
    }

    /**
    * This method takes in an int value (red).
    * @param r red int value
    */
    public void setRed(int r) {
        this.red = checkVal(r);
    }

    /**
    * This method takes in an int value (green).
    * @param g green int value
    */
    public void setGreen(int g) {
        this.green = checkVal(g);
    }

    /**
    * This method takes in an int value (blue).
    * @param b blue int value
    */
    public void setBlue(int b) {
        this.blue = checkVal(b);
    }

    /**
    * This method takes in an int value (alpha).
    * @param a alpha int value
    */
    public void setAlpha(int a) {
        this.alpha = a;
    }

    /**
    * This method takes in an int value (val).
    * @param val int value
    * @return val int value that is in the range of 0 and 255
    */
    public int checkVal(int val) {
        if (val > 255) {
            val = 255;
        }
        if (val < 0) {
            val = 0;
        }
        return val;
    }
}