import java.io.IOException;
/**
 * This class represents a Photoslop object.
 * @author Michelle Chiu
 * @version 13.31
 */
public class Photoslop {
    /**
    * Creates a Pic.
    * @param args Takes in ImageProcessor method, img filename, value, img filename
    */
    public static void main(String... args) throws IOException {
        if (args.length < 4) {
            printUsage();
            System.exit(0);
        }
        try {
            //your code here
            //hint the base pic for use with the image processor is in args[1]
            Pic img = new Pic(args[1]);
            ImageProcessor imgProcessor = new ImageProcessor(img);

            if (args[0].equals("-a")) {
                //add mode
                //your code here
                //add args[2] to the picture, then call
                Pic picture = imgProcessor.add(Integer.parseInt(args[2]));
                picture.save(args[3]);
                //Save to args[3]
            } else if (args[0].equals("-m")) {
                //same as add, but multiply
                Pic picture = imgProcessor.multiply(Integer.parseInt(args[2]));
                picture.save(args[3]);
            } else if (args[0].equals("-c")) {
                //use this as your chroma key to match the greenscreen in the lego guy image
                Pixel chromaKey = new Pixel(26, 185, 19, 1);

                //Your code here to apply the chroma key transformation
                //It's up to you what you want the rgb deltas (thresholds) to be,
                //I used something like 20, 40, 20

                //Hint: to do this part, consider making another ImageProcessor
                //Your code here to apply the background (args[2])
                Pic picture = imgProcessor.chroma(chromaKey, 20, 40, 20);
                Pic img2 = new Pic(args[2]);
                ImageProcessor imgProcessor2 = new ImageProcessor(picture);
                Pic img3 = imgProcessor2.background(img2);

                //Finally, save to args[3]
                img3.save(args[3]);

            } else {
                printUsage();
            }
        } catch (IOException ex) {
            System.out.println("One of the files you referenced does not exist,"
                + " or is corrupted. Double-check and try again.");
        }
    }

    private static void printUsage() {
        System.out.println("Add mode: ");
        System.out.println("java -a imageFile n outputFile");
        System.out.println("");
        System.out.println("Multiply mode: ");
        System.out.println("java -m imageFile n outputFile");
        System.out.println("");
        System.out.println("Greenscreen mode: ");
        System.out.println("java -c imageFile backgroundFile outputFile");
    }
}
