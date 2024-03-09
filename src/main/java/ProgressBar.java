import java.util.Random;

public class ProgressBar {public static void main(String[] args) throws InterruptedException {
  if (args.length < 2) {
    System.out.println("Please provide 2 or more input arguments, example: 15 3");
    return;
  }
  Random random = new Random();
  int countElements = Integer.parseInt(args[0]);
  int[] arrayOfSecondSleep = new int[args.length - 1];

  for (int i = 0; i < arrayOfSecondSleep.length; i++) {
    arrayOfSecondSleep[i] = Integer.parseInt(args[i + 1]);
  }

  int[] delaysRandom = new int[countElements];
  int delaysRandomSum = 0;
  for (int i = 0; i < countElements; i++) {
    delaysRandom[i] = arrayOfSecondSleep[random.nextInt(arrayOfSecondSleep.length)] * 1000;
    delaysRandomSum += delaysRandom[i];
  }
  drawProgressBar(countElements, delaysRandom, delaysRandomSum);
}

  private static void drawProgressBar(int countElements, int[] delaysRandom, int delaysRandomSum)
          throws InterruptedException {
    for (int i = 0; i < countElements; i++) {
      int delay = delaysRandom[i];
      delaysRandomSum -= delay;
      Thread.sleep(delay);
      drawElement(i + 1, countElements, delaysRandomSum);
    }
  }

  private static void drawElement(int current, int total, int totalTime) {
    int progress = (int) (((double) current / total) * 100);
    System.out.print(progress + "% [");

    for (int j = 0; j < 50; j++) {
      if (j < progress / 2) {
        System.out.print("=");
      } else if (j == progress / 2) {
        System.out.print(">");
      } else {
        System.out.print(" ");
      }
    }
    System.out.print("] " + current + "/" + total + ", ETA: " + formatTime(totalTime) + "\r");
  }

  private static String formatTime(long milliseconds) {
    long seconds = milliseconds / 1000;
    long minutes = seconds / 60;
    long hours = minutes / 60;
    long remainingSeconds = seconds % 60;
    long remainingMinutes = minutes % 60;
    long remainingHours = hours % 24;
    String formattedHours = String.format("%02d", remainingHours);
    String formattedMinutes = String.format("%02d", remainingMinutes);
    String formattedSeconds = String.format("%02d", remainingSeconds);
    return formattedHours + ":" + formattedMinutes + ":" + formattedSeconds;
  }
}