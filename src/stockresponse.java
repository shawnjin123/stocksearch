public class stockresponse {

        private double high;
        private double low;
        private String date;
        private String stockcode;


        public stockresponse(String stockcode,double high,double low,String date)
        {
            this.stockcode=stockcode;
            this.low=low;
            this.high = high;
            this.date=date;

        }
        public  String getStockcode(){return stockcode;}
        public double getHigh()
        {
            return high;
        }
        public double getLow(){return  low;}
        public String getDate(){return date;}


    }

