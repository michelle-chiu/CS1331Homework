/* Put your ImageProcessor class here */
/**
 * This class represents a ImageProcessor object.
 * @author Michelle Chiu
 * @version 13.31
 */
public class ImageProcessor {
        private Pic img;

        /**
        * Creates an ImageProcessor.
        * @param img Pic object
        */
        public ImageProcessor(Pic img) {
            this.img = img.deepCopy();
        }

        /**
        * Creates a Pic.
        * @param increment integer value to add to RBG pixel values
        * @return img Pic object
        */
        public Pic add(int increment) {
            Pixel[][] p = img.getPixels();
            for (int a=0; a < p.length; a++) {
                for(int b=0; b < p[a].length; b++) {
                    p[a][b].setRed(p[a][b].getRed() + increment);
                    p[a][b].setGreen(p[a][b].getGreen() + increment);
                    p[a][b].setBlue(p[a][b].getBlue() + increment);
                }
            }
            return img;
        }

        /**
        * Creates a Pic.
        * @param scale int value to multiply to RGB pixel values
        * @return img Pic object
        */
        public Pic multiply(double scale) {
            Pixel[][] p = img.getPixels();
            for (int c=0; c < p.length; c++) {
                for (int d=0; d < p[c].length; d++) {
                    p[c][d].setRed((int) (p[c][d].getRed() * scale));
                    p[c][d].setGreen((int) (p[c][d].getGreen() * scale));
                    p[c][d].setBlue((int) (p[c][d].getBlue() * scale));
                }
            }
            return img;
        }

        /**
        * Creates a Pic.
        * @param key Pixel Object
        * @param dr int value (delta for red pixel value)
        * @param dg int value (delta for green pixel value)
        * @param db int value (delta for blue pixel value)
        * @return img Pic object
        */
        public Pic chroma(Pixel key, int dr, int dg, int db) {
            Pixel[][] p = img.getPixels();
            for (int e=0; e < p.length; e++) {
                for (int f=0; f < p[e].length; f++) {
                    if ((Math.abs(p[e][f].getRed() - key.getRed()) < dr)
                        && ((Math.abs(p[e][f].getGreen() - key.getGreen())) < dg)
                            && (Math.abs(p[e][f].getBlue() - key.getBlue()) < db)) {
                                p[e][f].setAlpha(0);
                    }

                }
            }
            return img;
        }

        /**
        * Creates a Pic.
        * @param bg Pic Object
        * @return img Pic object
        */
        public Pic background(Pic bg) {
            Pixel[][] b = bg.getPixels();
            Pixel[][] p = img.getPixels();
            for (int g=0; g < p.length; g++) {
                for (int h=0; h < p[g].length; h++) {
                    if (p[g][h].getAlpha() == 0) {
                        p[g][h].setRed(b[g][h].getRed());
                        p[g][h].setGreen(b[g][h].getGreen());
                        p[g][h].setBlue(b[g][h].getBlue());
                        p[g][h].setAlpha(b[g][h].getAlpha());
                    }
                }
            }
            return img;
        }
}