public class StockSearch {
    public static void main(String[] args) throws Exception
    {
        Userinterface ui = new Userinterface();
        stockrequest req = new stockrequest();

        stockresponse response=req.getStockCode();
        ui.displayStockData(response.getPrice());





    }


        public static void StockCodePath(Userinterface ui, stockrequest req)
        {
            //set the mode on the request which will determine how the url is constructed
            //TODO: refactor so the validation loop is handled in the UserInterface
            boolean validZip = false;
            while (!validZip) {
                String zip = ui.inputStockCode();
                String result = req.setStockCode(zip);
                if (result == null) {

                    validZip = true;
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

