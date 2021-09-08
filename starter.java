import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class starter {

  public static void main(String[] args) {

    try {

      BufferedImage bufferedImage = ImageIO.read(new File("bridge.jpg"));
 
      //Loop over every pixel
      for (int y = 0; y < bufferedImage.getHeight(); y++) {
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
          int pixelInt = bufferedImage.getRGB(x, y);
          Color pixelColor = new Color(pixelInt);

          //Just do a grayscale conversion for half the image
          if (x < bufferedImage.getWidth() / 2) {
            //Get the int [0,255] values for red, green, and blue
            int r = pixelColor.getRed();
            int g = pixelColor.getGreen();
            int b = pixelColor.getBlue();

            //Do a trivial grayscale conversion by just using the red channel.
            g = r;
            b = r;

            //Create a new color object with the new colors
            Color outColor = new Color(r, g, b);

            //Set the pixel to the color
            bufferedImage.setRGB(x, y, outColor.getRGB());
          }
        }
      }

      // Save the image to a file
      ImageIO.write(bufferedImage, "PNG", new File("out.png"));

      /*
      What I added to the code.
      */

      //Red rainbow image
      BufferedImage redRainbowBufferedImage = ImageIO.read(new File("rainbow.png"));

      for (int y = 0; y < redRainbowBufferedImage.getHeight(); y++){
          for (int x = 0; x < redRainbowBufferedImage.getWidth(); x++){
              int pixelInt = redRainbowBufferedImage.getRGB(x, y);
              Color pixelColor = new Color(pixelInt);

              int r = pixelColor.getRed();
              int g = pixelColor.getGreen();
              int b = pixelColor.getBlue();

              if (r >= 200 && g == 0 && b == 0) {
                  
              }
              else {
                  int avg = (int)((r * .3) + (g * .6) + (b * .1) / 3);
                  r = avg;
                  g = avg;
                  b = avg;
              }

              Color outColor = new Color(r, g, b);
              redRainbowBufferedImage.setRGB(x, y, outColor.getRGB());
              
          }
      }
      
      ImageIO.write(redRainbowBufferedImage, "PNG", new File("red_rainbow.png"));

      //Yellow rainbow image
      BufferedImage yellowRainbowBufferedImage = ImageIO.read(new File("rainbow.png"));

      for (int y = 0; y < yellowRainbowBufferedImage.getHeight(); y++){
          for (int x = 0; x < yellowRainbowBufferedImage.getWidth(); x++){
              int pixelInt = yellowRainbowBufferedImage.getRGB(x, y);
              Color pixelColor = new Color(pixelInt);

              int r = pixelColor.getRed();
              int g = pixelColor.getGreen();
              int b = pixelColor.getBlue();

              if (r >= 200 && g >= 200 && b == 0) {
                  
              }
              else {
                  int avg = (int)((r * .3) + (g * .6) + (b * .1) / 3);
                  r = avg;
                  g = avg;
                  b = avg;
              }

              Color outColor = new Color(r, g, b);
              yellowRainbowBufferedImage.setRGB(x, y, outColor.getRGB());
              
          }
      }
      
      ImageIO.write(yellowRainbowBufferedImage, "PNG", new File("yellow_rainbow.png"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}