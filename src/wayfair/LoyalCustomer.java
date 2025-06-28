package wayfair;

import java.util.*;

/* Easy Problem, given user click logs from two days, needed to identify
loyal customers who visited the website on both the days and clicked on
 at-least two unique products.*/
/*Let's say we have a website and we keep track of what pages customers are viewing, for things like business metrics.
Every time somebody comes to the website, we write a record to a log file consisting of Timestamp, PageId, CustomerId.
 At the end of the day we have a big log file with many entries in that format. And for every day we have a new file.
  Now, given two log files (log file from day 1 and log file from day 2) we want to generate a list of 'loyal customers'
  that meet the criteria of: (a) they came on both days, and (b) they visited at least two unique pages.*/
public class LoyalCustomer {

    public static void main(String[] args) {
        List<String> loyalCustomers= new ArrayList<>();
        List<String> customerAuditLog = List.of(
                "logFile1,05252025T090000,1,101",
                "logFile1,05252025T090100,1,102",
                "logFile1,05252025T091000,2,201",
                "logFile1,05252025T091500,2,201",
                "logFile1,05252025T092000,3,301",
                "logFile1,05252025T093000,3,302",
                "logFile1,05252025T093500,3,303",
                "logFile1,05252025T090000,6,120",
                "logFile2,05262025T090000,6,120",

                "logFile2,05262025T100000,1,103",
                "logFile2,05262025T100500,1,104",
                "logFile2,05262025T101000,2,202",
                "logFile2,05262025T101500,3,304",
                "logFile2,05262025T102000,3,305",
                "logFile2,05262025T102500,4,401",
                "logFile2,05262025T103000,4,402",
                "logFile1,05252025T090000,9,201",
                "logFile1,05252025T090100,9,202",
                "logFile2,05262025T091000,9,203", // Loyal (3 SKUs, 2 days)

                "logFile1,05252025T090000,10,301",
                "logFile2,05262025T090000,10,301", // Not Loyal (1 SKU)

                "logFile2,05262025T090000,11,401", // Not Loyal (only 1 day)
                "logFile2,05262025T091000,11,402"
        );

        Map<String,List<Customer>> customerLog= new HashMap<String,List<Customer>>();
        for(String s: customerAuditLog)
        {
            String [] log=s.split(",");
            String timstamp=log[1];
            String customerId=log[2];
            String skuId=log[3];
            Customer c= new Customer(customerId,timstamp,skuId);
            customerLog.computeIfAbsent(c.customerId,cus->new ArrayList<>()).add(c);
        }

        for(String c: customerLog.keySet())
        {
            List<Customer> customerList=customerLog.get(c);
            HashSet<String> timestamp = new HashSet<>();
            HashSet<String> uniqueSku = new HashSet<>();
            if(customerList.size()>1)
            {
                for(Customer customer: customerList)
                {
                    String[] dateArray= customer.timestamp.split("T");
                    timestamp.add(dateArray[0]);
                    uniqueSku.add(customer.skuId);
                }
                if(uniqueSku.size()>1 && timestamp.size()>1)
                {
                    loyalCustomers.add(c);
                }
            }
        }

        System.out.println(loyalCustomers);
    }
    public static class Customer
    {
        String customerId;
        String timestamp;
        String skuId;

        public Customer (String customerId, String timestamp, String skuId)
        {
            this.customerId=customerId;
            this.timestamp=timestamp;
            this.skuId=skuId;
        }
    }
}
