public class StockSearch {
    public static void main(String[] args) throws Exception
    {
        Userinterface ui = new Userinterface();
        stockrequest req = new stockrequest();
        while (true) {


            StockCodePath(ui, req);

            if (req.getStockCode().equals("0"))
            {
                break;
            }

            stockresponse response = req.getStockdata();
            ui.displayStockData(response);


        }





    }


        public static void StockCodePath(Userinterface ui, stockrequest req)
        {
            //set the mode on the request which will determine how the url is constructed
            //TODO: refactor so the validation loop is handled in the UserInterface
            boolean validStockCode = false;
            while (!validStockCode) {
                String zip = ui.inputStockCode();
                String result = req.setStockCode(zip);
                if (result == null) {

                    validStockCode = true;
                } else {
                    ui.displayErrorMessage(result);
                }

            }
        }





        public static void unitSelectionPath(Userinterface ui, stockrequest req)
        {
            boolean validUnits = false;
            while (!validUnits)
            {
                String unitsInput = ui.inputUnits();
                String units = ui.validateUnits(unitsInput);

                if (units != null) {
                    String result = req.setUnits(units);
                    if (result == null) {
                        //this means that the unit passed validation
                        //so end the while loop
                        validUnits = true;
                    } else {
                        ui.displayErrorMessage(result);
                    }
                }
            }
        }
    }

