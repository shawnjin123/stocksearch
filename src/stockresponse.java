public class stockresponse {

        private double high;
        private double low;
        private String date;


        public stockresponse(double high,double low,String date)
        {
            this.low=low;
            this.high = high;
            this.date=date;
        }

        public double getHigh()
        {
            return high;
        }
        public double getLow(){return  low;}
        public String getDate(){return date;}


    }

