import java.util.Scanner;

public class Userinterface {


        private Scanner input;

        public Userinterface()
        {
            input = new Scanner(System.in);
        }


        public String inputStockCode()
        {

                System.out.println("Please write Stock Code");
                System.out.println("Enter 0 to quit");
                System.out.println();
                String StockCodes=input.nextLine();

                return StockCodes;

        }


        public String inputUnits()
        {
            System.out.println("Enter the desired units:");
            System.out.println("1) " + stockrequest.MINUTE);
            System.out.println("2) " + stockrequest.HOUR);
            System.out.println();

            String units = input.nextLine();

            return units;
        }

        public String validateUnits(String units)
        {
            String validUnits = null;
            if(units.equals("1"))
            {
                validUnits = stockrequest.MINUTE;
            }
            else if(units.equals("2"))
            {
                validUnits = stockrequest.HOUR;
            }
            else
            {
                displayUnitsErrorMessage();
            }
            return validUnits;
        }

        public void displayUnitsErrorMessage()
        {
            String error = "Units must be a number between 1 - 2";
            displayErrorMessage(error);
        }

        public void displayErrorMessage(String msg)
        {
            System.out.println("************ERROR************");;
            System.out.println(msg);
        }

        public void displayStockData(stockresponse response)
        {
            System.out.println("Symbol"+response.getStockcode());
            System.out.println("current date:"+response.getDate());
            System.out.println("Current high: " + response.getHigh());
            System.out.println("Current low:"+response.getLow());

        }

    }

