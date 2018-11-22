public class Calendar {

   static void printUsage() {
       System.out.println("Usage:");
       System.out.println("java Calendar");
       System.out.println("java Calendar <month>");
       System.out.println("java Calendar <month> <year>");

       System.exit(1);
    }

    static int calculateMonthNumber(String month) {
      String[] monthAbbreviations = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
      int i = 0;
      int monthNumber = 0;

       while (i < monthAbbreviations.length) {
         if (monthAbbreviations[i].equals(month)) {
           monthNumber = i + 1;
           break;
         }
         i++;
        }
        if (monthNumber == 0) {
           printUsage();
      }

      return monthNumber;
    } // end method

    static boolean isLeapYear(int year) {
      if (year % 4 == 0) {
        if (year % 100 == 0) {
          if (year % 400 == 0) {
            return true;
          }
          return false;
        }
        return true;
      }
      return false;
    }


    static int mod(int a, int b) {
      return a % b;
    }

    static int firstWeekdayOfYear(int year) {
      return mod(1 + 5 * mod(year - 1, 4) + 4 * mod(year -1 , 100) + 6 * mod(year -1, 400), 7);
   }

    public static void main(String[] args) {
      int month = 0;
      int year = 0;
      int[] monthLengths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

      if (args.length == 0) {
        month = 11;
        year = 2018;
      } else if (args.length == 1) {
        year = 2018;
        month = calculateMonthNumber(args[0]);
      } else if (args.length == 2) {
        month = calculateMonthNumber(args[0]);
      try {
        year = Integer.parseInt(args[1]);
      } catch (NumberFormatException e) {
             printUsage();
      }
        if (year < 0) {
          printUsage();
        }
      } else {
        printUsage();
      }

      System.out.println(month);
      System.out.println(year);
      System.out.println("Leap year: " + isLeapYear(year));
      //change length of february in case of leap year
      if (isLeapYear(year)) {
        monthLengths[1]++;
      }

      System.out.println("Total days february: " + monthLengths[1]);
      System.out.println("First weekday of year: " + firstWeekdayOfYear(year));
    } //end main
} //end class
